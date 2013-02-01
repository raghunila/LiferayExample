/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.dataObject;

/**
 *
 * @author rnila
 */
import com.xtivia.training.entities.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookDataObject {
	private static List<Book> books = Collections.synchronizedList(new ArrayList<Book>());
	public BookDataObject() {
	}
	public static List<Book> getBooks() {
            if(books.size() <1)
            {
                return getBook();
            }else {
                return books;
            }
	}
        private static List<Book>  getBook()
        {
            books.add(new Book("Liferay in Action", "Richard Sezov, Jr", Long.valueOf("1933988053"),"Liferay in action"));
            books.add(new Book("Portlets in action", "Ashish Sarin", Long.valueOf("1933988940"),"Portlets in action"));
            books.add(new Book("Java Complete Reference", "McGraw-Hill Osborne Media", Long.valueOf("1933988941"),"Java Complete reference"));
            books.add(new Book("C++: The Complete Reference", "McGraw-Hill Osborne Media", Long.valueOf("1933988942"),"C++: the complete reference"));
            return books;
        }
}
