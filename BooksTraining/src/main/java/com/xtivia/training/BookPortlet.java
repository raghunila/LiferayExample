/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xtivia.training;

import com.liferay.portal.kernel.portlet.LiferayPortletSession;
import com.liferay.portal.kernel.portlet.PortletBag;
import com.liferay.portal.kernel.portlet.PortletBagPool;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.xtivia.training.dataObject.BookDataObject;
import com.xtivia.training.entities.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import javax.portlet.ActionRequest;


import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Hello You portlet, a simple example demonstrating Portlet Modes, Portlet
 * Actions, and Portlet Preferences.
 *
 * @author Rich Sezov
 *
 */
public class BookPortlet extends GenericPortlet {

    List<Book> books = BookDataObject.getBooks();
    static String MYACTION_PARAM ="jspPAGE";
    public void init()
            throws PortletException {

        editJSP = getInitParameter("edit-jsp");
        viewJSP = getInitParameter("view-jsp");
        addJSP = getInitParameter("add-jsp");
        bookJSP = getInitParameter("book-jsp");
        welcomeJSP = getInitParameter("welcome-jsp");
        templateJSP = getInitParameter("template-jsp");
    }

    public void doEdit(
            RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
        System.out.println(" i am here ");
        renderResponse.setContentType("text/html");
        include(editJSP, renderRequest, renderResponse);
    }

    public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
        request.setAttribute("books", books);
        System.out.println("In doView code");
        response.setContentType(request.getResponseContentType());
        String myaction = request.getParameter(MYACTION_PARAM);
        if(myaction == null)
        {
            getPortletContext().getRequestDispatcher(viewJSP).include(request, response);
        }else 
        {
            getPortletContext().getRequestDispatcher(myaction).include(request, response);
        }
    }
   @ProcessAction(name="getBook") 
   public void getBook(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        String isbn = actionRequest.getParameter("isbn");
        for (Book book : books) {
            String isbns = book.getIsbnNumber() + "";
            if (isbn.equals(isbns)) {
                actionRequest.setAttribute("book", book);
            }
        }
        actionResponse.setRenderParameter(MYACTION_PARAM, bookJSP);
    }
   @ProcessAction(name="backToMain") 
   public void backToMain(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        actionRequest.setAttribute("books", books);
        actionResponse.setRenderParameter(MYACTION_PARAM, viewJSP);
    }
    @ProcessAction(name="gotoAddBook")
    public void gotoAddBook(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {
        Book book = new Book();
        actionRequest.setAttribute("book", book);
        actionRequest.setAttribute("edit", "editddd");
        actionResponse.setRenderParameter(MYACTION_PARAM, addJSP);
        //getPortletContext().getRequestDispatcher(actionResponse.encodeURL(addJSP)).include(actionRequest, actionResponse);
        //actionResponse.setRenderParameter("jspPage", addJSP);
        
    }
    @ProcessAction(name = "addBook")
    public void addBook(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException, IOException {
        ArrayList<String> errors = new ArrayList<String>();
        Book book = ActionUtil.getFormRequest(actionRequest);
        boolean validate = ValidateBook.validateBook(book, errors);
        if (validate) {
            books.add(book);
            actionRequest.setAttribute("books", books);
            //getPortletContext().getRequestDispatcher(actionResponse.encodeURL(viewJSP)).include(actionRequest, actionResponse);
            actionResponse.setRenderParameter(MYACTION_PARAM, viewJSP);
        } else {
            for (String error : errors) {
                SessionErrors.add(actionRequest, error);
            }
            SessionErrors.add(actionRequest, "error-saving-book");
            actionRequest.setAttribute("book", book);
            actionResponse.setRenderParameter(MYACTION_PARAM, editJSP);
        }
    }
    @ProcessAction(name="editBookAction")
    public void editBookAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        String isbn = actionRequest.getParameter("isbn");
        ArrayList<String> errors = new ArrayList<String>();
        Book bookEdit = ActionUtil.getFormRequest(actionRequest);
        boolean validate = ValidateBook.validateBook(bookEdit, errors);
        Book fromArray = null;
        if (validate) {
            ListIterator iterator = books.listIterator();
            while (iterator.hasNext()) {
                Book book = (Book) iterator.next();
                String isbns = book.getIsbnNumber() + "";
                if (isbn.equals(isbns)) {
                    iterator.remove();
                }
            }
            books.add(bookEdit);
            actionRequest.setAttribute("book", bookEdit);
            actionResponse.setRenderParameter(MYACTION_PARAM, bookJSP);
        } else {
            for (String error : errors) {
                SessionErrors.add(actionRequest, error);
            }
            SessionErrors.add(actionRequest, "error-saving-book");
            actionResponse.setRenderParameter(MYACTION_PARAM, addJSP);
            actionRequest.setAttribute("book", bookEdit);
            actionRequest.setAttribute("edit", "edit");
        }
    }
    @ProcessAction(name="editBook")
    public void editBook(ActionRequest actionRequest, ActionResponse actionResponse) {
        String isbn = actionRequest.getParameter("isbn");
        for (Book book : books) {
            String isbns = book.getIsbnNumber() + "";
            if (isbn.equals(isbns)) {
                actionRequest.setAttribute("book", book);
            }
        }
        actionRequest.setAttribute("edit", "edit");
        actionResponse.setRenderParameter(MYACTION_PARAM, addJSP);

    }

    
    @ProcessAction(name="ajaxDelete")
    public void ajaxDelete(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        String isbn = request.getParameter("isbn");
        ListIterator iterator = books.listIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            String isbns = book.getIsbnNumber() + "";
            if (isbn.equals(isbns)) {
                iterator.remove();
            }
        }
        request.setAttribute("books", books);
        System.out.println("I am in ajax delete");
        /*request.setAttribute("books", books);
        System.out.println("I am here whats up");
        include(templateJSP, request, response, PortletRequest.RESOURCE_PHASE);*/
    }
    @ProcessAction(name="callInterPorltet")
    public void callInterPorltet(ActionRequest actionRequest, ActionResponse actionResponse) {
        String isbn = actionRequest.getParameter("isbn");
        String error = new String();
        boolean validate = ValidateBook.validateISBN(isbn, error);
        actionRequest.getPortletSession().setAttribute("searchBook", isbn, PortletSession.APPLICATION_SCOPE);
        System.out.println("in the seesions ");
        if (!validate) {
            System.out.println("error are happening");
            SessionErrors.add(actionRequest, error);
            SessionErrors.add(actionRequest, "error-saving-book");
        }
        /*String isbn = actionRequest.getParameter("isbn");
         String error = new String();
         System.out.println(isbn +"   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
         boolean validate = ValidateBook.validateISBN(isbn, error);
         if (validate) {
         System.out.println("in validate");
         QName qName = new QName("http://localhost:8080", "isbn", "x");
         actionResponse.setEvent(qName, isbn);
         } else {
         System.out.println("error are happening");
         SessionErrors.add(actionRequest, error);
         SessionErrors.add(actionRequest, "error-saving-book");
         }*/
        actionResponse.setRenderParameter("jspPage", viewJSP);
        actionRequest.setAttribute("books", books);

    }
    @ProcessAction(name="welcomePage")
    public void welcomePage(ActionRequest actionRequest, ActionResponse actionResponse) throws ReadOnlyException, IOException, ValidatorException, PortletModeException {
        System.out.println(actionRequest.getParameter("username") + " <<<<< i cannot be null buddy");
        actionRequest.setAttribute("username", actionRequest.getParameter("username"));
        actionResponse.setPortletMode(PortletMode.VIEW);
        actionResponse.setRenderParameter(MYACTION_PARAM, viewJSP);
    }
    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
            throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
                getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        } else {
            portletRequestDispatcher.include(
                    renderRequest, renderResponse);
        }
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        response.setContentType("text/html");
        String message = request.getParameter("message");
        String isbn = message;
        ListIterator iterator = books.listIterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            String isbns = book.getIsbnNumber() + "";
            if (isbn.equals(isbns)) {
                iterator.remove();
            }
        }
        request.setAttribute("books", books);
        System.out.println("I am in ajax delete");
        
        // this seems to be the page that was calling...?
        String resourceID = request.getResourceID();
        System.out.println("resourceId was : " + resourceID);
        System.out.println("message was : " + message);
    }
    protected String editJSP;
    protected String viewJSP;
    protected String addJSP;
    protected String bookJSP;
    protected String welcomeJSP;
    protected String templateJSP;
    private static Log _log = LogFactory.getLog(BookPortlet.class);
}
