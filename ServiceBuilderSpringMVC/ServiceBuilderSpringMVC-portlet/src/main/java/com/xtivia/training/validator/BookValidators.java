package com.xtivia.training.validator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.UserModel;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rnila
 */
public class BookValidators implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return UserModel.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book =(Book) target;
        System.out.println(">>>>>>1");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.book.author");
        try {
            if(book.getIsbn() > 0 &&  BookLocalServiceUtil.findBook(book.getIsbn())!= null)
            {
                System.out.println(">>>>>>2");
                errors.reject("isbn","unique.book.isbnNumber");
            }
        } catch (PortalException ex) {
            Logger.getLogger(BookValidators.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookValidators.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BookValidators.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(book.getName()!= null && (book.getName().length() < 10 || book.getName().length() > 100)  )
        {
            System.out.println(">>>>>>3");
            errors.reject("isbn","fieldLength.book.name");
        }else
        {
            System.out.println(">>>>>>4");
        }
        //typeMismatch.book.isbnNumber
        System.out.println(">>>>>>5");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "NotEmpty.book.isbnNumber");
        System.out.println(">>>>>>6");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "NotEmpty.book.summary");
        System.out.println(">>>>>>7");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.book.name");
    }
}
