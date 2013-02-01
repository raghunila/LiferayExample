/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.liferay.portal.kernel.util.Validator;
import com.xtivia.training.entities.Book;
import java.util.List;

/**
 *
 * @author rnila
 */
public class ValidateBook {
    
    public static boolean validateBook(Book book, List errors)
    {
        boolean valid = true;
        if(Validator.isNull(book.getName()))
        {
            errors.add("bookname-required");
            valid=false;
        }
        if(Validator.isNull(book.getIsbnNumber()))
        {
            errors.add("isbnnumber-required");
            valid=false;
        }
        if(Validator.isNull(book.getAuthor()))
        {
            errors.add("author-required");
            valid=false;
        }
        if(Validator.isNull(book.getSummary()))
        {
            errors.add("summary-required");
            valid=false;
        }
        return valid;
    }
    public static boolean validateISBN(String isbn, String error)
    {
        boolean valid = true;
    
        if(Validator.isNull(isbn))
        {
            error="isbnnumber-required";
            valid=false;
        }
        return valid;
    }
}
