/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.xtivia.training.dao.BookServiceDAO;
import com.xtivia.training.data.BookAddedEvent;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.util.LongNumberPropertyEditor;
import javax.portlet.ActionRequest;
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
            BindingResult bindingResult, ActionResponse response, ActionRequest actionRequest,
            SessionStatus sessionStatus) throws PortalException, SystemException {
        bookValidators.validate(book, bindingResult);
        System.out.println(bindingResult.hasErrors() + "  error in adding the values");
        if (!bindingResult.hasErrors()) {
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext =
                    ServiceContextFactory.getInstance(
                    Book.class.getName(), actionRequest);
            book.setUserId(themeDisplay.getUserId());
            book.setGroupId(themeDisplay.getScopeGroupId());
            book.setCompanyId(themeDisplay.getCompanyId());
            bookServiceDAO.addBook(book,serviceContext);
            response.setRenderParameter("myAction", "books");
            System.out.println(" with out any error >>>>>>>>>>>>>>>>>>>>>>>");
            QName eventName = new QName("http://www.xtivia.com", "bookAddedEvent");
            response.setEvent(eventName, new BookAddedEvent(book));
            sessionStatus.setComplete();
        } else {

            response.setRenderParameter("myAction", "addBookForm");
        }
    }
}
