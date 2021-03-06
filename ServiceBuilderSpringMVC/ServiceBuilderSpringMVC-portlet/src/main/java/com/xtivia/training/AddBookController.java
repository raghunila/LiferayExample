/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;


import com.xtivia.training.dao.BookServiceDAO;
import com.xtivia.training.data.BookAddedEvent;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.util.LongNumberPropertyEditor;
import com.xtivia.training.validator.BookValidators;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;
import javax.validation.Valid;
import javax.xml.namespace.QName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author rnila
 */
@Controller(value = "addBookController")
@RequestMapping(value = "VIEW")
@SessionAttributes(types = Book.class)
public class AddBookController {

    @Autowired
    @Qualifier(value = "bookServiceDAO")
    private BookServiceDAO bookServiceDAO;
    @Autowired
    Validator bookValidators;
    

    public void setBookServiceDAO(BookServiceDAO bookServiceDAO) {
        this.bookServiceDAO = bookServiceDAO;
    }

    @ModelAttribute("book")
    public Book getCommandObject() {
        return bookServiceDAO.getNewBook();
    }

    @InitBinder("book")
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Long.class, new LongNumberPropertyEditor());
    }

    @RenderMapping(params = "myAction=addBookForm")
    public String addBookForm(RenderResponse renderResponse) {
        return "addBook";
    }

    @ActionMapping(params = "myAction=addBook")
    public void addBook(@Valid @ModelAttribute(value = "book") Book book,
            BindingResult bindingResult, ActionResponse response,
            SessionStatus sessionStatus) {
            System.out.println("Hey I am in add Book >>>!!!");
            
            System.out.println("Initiating the validator");
            bookValidators.validate(book, bindingResult);
            System.out.println("validation is done");
        if (!bindingResult.hasErrors()) {
            bookServiceDAO.addBook(book);
            response.setRenderParameter("myAction", "books");
            // --set the session status as complete to cleanup the model
            // attributes
            // --stored using @SessionAttributes, otherwise when you click
            // --'Add Book' button you'll see the book information pre-populated
            // -- because the getCommandObject method of the controller is not
            // --invoked
            /*book = bookServiceDAO.getBook(book.getisbn());
            System.out.println(book.getSummary() +" >>>>>>>>>>>>>>>>>>>>>>>");*/
            QName eventName = new QName("http://www.xtivia.com", "bookAddedEvent");
            response.setEvent(eventName, new BookAddedEvent(book));
            sessionStatus.setComplete();
        } else {
            response.setRenderParameter("myAction", "addBookForm");
        }
    }
}
