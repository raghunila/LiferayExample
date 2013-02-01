package com.xtivia.training.util;

import com.xtivia.training.dao.BookServiceDAO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rnila
 */
public class UniqueContraintValidator implements ConstraintValidator<Unique, Long> {
	@Autowired
	@Qualifier("bookServiceDAO")
	private BookServiceDAO bookServiceDAO;
	
	public void initialize(Unique annotation) {
		//-- do nothing
	}
	public boolean isValid(Long isbnNumber, ConstraintValidatorContext context) {
		return bookServiceDAO.isUniqueISBN(isbnNumber);
	}
}
