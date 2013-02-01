/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;


import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.xtivia.training.dao.BookServiceDAO;
import com.xtivia.training.servicebuilder.model.Book;
import java.util.List;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author rnila
 */
@Controller(value = "bookController")
@RequestMapping(value = "VIEW")
public class BookController {
    // --maps the incoming portlet request to this method

    @Autowired
    @Qualifier(value = "bookServiceDAO")
    private BookServiceDAO bookServiceDAO;

    public void setBookServiceDAO(BookServiceDAO bookServiceDAO) {
        this.bookServiceDAO = bookServiceDAO;
    }

    @RenderMapping
    public String showBooks(RenderResponse response) {
        return "viewBooks";
    }
    @RenderMapping(params = "myAction=viewBooks")
    public String viewBooks(RenderResponse response) {
        return "viewBooks";
    }
    @ModelAttribute(value = "books")
    public List<Book> getBooks() {
        return bookServiceDAO.getBooks();
    }
    @ActionMapping(params = "myAction=invokeTaglibDiscussion")
    public void invokeTaglibDiscussion(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

        PortalClassInvoker.invoke(true, "com.liferay.portlet.messageboards.action.EditDiscussionAction",
                "processAction", new String[]{
                    "org.apache.struts.action.ActionMapping",
                    "org.apache.struts.action.ActionForm",
                    PortletConfig.class.getName(),
                    ActionRequest.class.getName(),
                    ActionResponse.class.getName()
                }, null, null, portletConfig, actionRequest, actionResponse);
    }

    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "errorPage";
    }
}
