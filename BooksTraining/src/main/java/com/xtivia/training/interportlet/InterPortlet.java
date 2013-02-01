package com.xtivia.training.interportlet;

import com.liferay.util.bridges.mvc.MVCPortlet;
import com.xtivia.training.BookPortlet;
import com.xtivia.training.dataObject.BookDataObject;
import com.xtivia.training.entities.Book;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rnila
 */
public class InterPortlet extends GenericPortlet {

    public void init() throws PortletException {
        bookJSP = getInitParameter("book-jsp");
    }

    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        
        String isbn = (String) renderRequest.getPortletSession().getAttribute("searchBook", PortletSession.APPLICATION_SCOPE);
        
        Book book = new Book();
        System.out.println(" in interportlet view >>>>>>>>>>>>>>>>" + isbn);
        if (isbn != null) {
            List<Book> books = BookDataObject.getBooks();
            for (Book book1 : books) {
                String isbns = book1.getIsbnNumber() + "";
                System.out.println(isbns+"<     >"+isbn );
                if (isbn.equals(isbns)) {
                    book = book1;
                    System.out.println("settting attribute");
                }
            }
        }
        renderRequest.setAttribute("book", book);
        include(bookJSP, renderRequest, renderResponse);
    }

    @ProcessEvent(qname = "{http://localhost:8080}isbn")
    public void handleProcessempinfoEvent(EventRequest request, EventResponse response) throws PortletException, IOException {

        javax.portlet.Event event = request.getEvent();
        String isbn = (String) event.getValue();
        List<Book> books = BookDataObject.getBooks();
        System.out.println("hi i am in the portlet>" + isbn);
        boolean valid = true;
        for (Book book : books) {
            String isbns = book.getIsbnNumber() + "";
            if (isbn.equals(isbns)) {
                request.setAttribute("book", book);
                System.out.println("settting attribute");
                valid = false;
            }
        }
        if (valid) {
            request.setAttribute("book", new Book());
        }
        request.setAttribute("book", new Book());

        response.setRenderParameter("jspPage", bookJSP);
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
    protected String bookJSP;
    private static Log _log = LogFactory.getLog(BookPortlet.class);
}
