/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.xtivia.training.dao.BookServiceDAO;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.util.LongNumberPropertyEditor;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author rnila
 */
@Controller(value = "editBookController")
@RequestMapping(value = "VIEW")
@SessionAttributes(value = "book")
public class EditBookController {

    @Autowired
    @Qualifier("bookServiceDAO")
    private BookServiceDAO bookServiceDAO;

    @RenderMapping(params = "myAction=editBookForm")
    public String showEditBookForm() {
        return "editBook";
    }

    @RenderMapping(params = "myAction=viewBook")
    public String showBook() {
        return "viewBook";
    }

    @ActionMapping(params = "myaction=editBook")
    public void editBook(@ModelAttribute("book") Book book, BindingResult bindingResult, ActionResponse response, SessionStatus sessionStatus) {
        if (!bindingResult.hasErrors()) {

            bookServiceDAO.editBook(book);
            response.setRenderParameter("myAction", "books");
            sessionStatus.setComplete();
        } else {
            //--this is required. the getBook method is not invoked but the @RequestParam
            //--is still evaluated
            response.setRenderParameter("isbn", book.getIsbn() + "");
            response.setRenderParameter("myaction", "editBookForm");
        }
    }

    @InitBinder("book")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
        binder.setDisallowedFields(new String[]{"isbn"});
    }

    @ModelAttribute("book")
    public Book getBook(@RequestParam Long isbn) {
        return bookServiceDAO.getBook(isbn);
    }

    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "errorPage";
    }
    
}