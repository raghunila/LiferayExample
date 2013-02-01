/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xitivia.training.validator;

import com.xtivia.training.data.Book;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author rnila
 */
public class BookValidator implements Validator {

	public boolean supports(Class<?> klass) {
		return Book.class.isAssignableFrom(klass);
	}

	public void validate(Object target, Errors errors) {
		Book book = (Book)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.book.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "NotEmpty.book.author");
		String name = book.getName();
		if(name.length() >100 || name.length() < 10) {
			errors.rejectValue("name", "fieldLength");
		}
	}
}