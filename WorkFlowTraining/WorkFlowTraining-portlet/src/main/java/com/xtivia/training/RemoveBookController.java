/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.xtivia.training.dao.BookServiceDAO;
import java.io.IOException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

/**
 *
 * @author rnila
 */
@Controller
@RequestMapping("VIEW")
public class RemoveBookController {

    @Autowired
    @Qualifier("bookServiceDAO")
    private BookServiceDAO bookServiceDAO;

    @ActionMapping(params = "myaction=removeBook")
    public void removeBook(@RequestParam Long isbn) {
        
    }
    @ResourceMapping("ajaxRemove")
    public void ajaxHandler(ResourceRequest request, ResourceResponse response)
            throws IOException {
        Long isbn= Long.parseLong(request.getParameter("isbn"));
        bookServiceDAO.removeBook(isbn);
    }
    
    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "errorPage";
    }
}
