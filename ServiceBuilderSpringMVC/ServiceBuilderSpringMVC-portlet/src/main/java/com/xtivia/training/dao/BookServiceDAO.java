/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.dao;

import com.xtivia.training.servicebuilder.model.Book;
import java.util.List;


/**
 *
 * @author rnila
 */
public interface BookServiceDAO {
        /**
	 * Retrieve book list.
	 * 
	 * @return all books in the catalog
	 */
	List<Book> getBooks();
	
	/**
	 * Adds a book to the catalog
	 * 
	 * @param book to added to the catalog
	 */
	void addBook(Book book);
	
	/**
	 * Checks if the ISBN number already exists in the catalog.
	 * 
	 * @param isbn isbn to check for.
	 * 
	 * @return true if there is no book with matching isbn is found in the catalog
	 */
	boolean isUniqueISBN(Long isbn);
	
	/**
	 * Retrieve a book based on its ISBN number.
	 * 
	 * @param isbn ISBN number of the book which needs to be retrieved
	 * @return book with the specified ISBN number
	 */
	Book getBook(Long isbn);
	
	/**
	 * Remove a book from the catalog.
	 * 
	 * @param isbn the ISBN number of the book that needs to be removed from the catalog
	 */
	void removeBook(Long isbn);
	
	/**
	 * Update the Book in the catalog.
	 * 
	 * @param book the modified Book
	 */
	void editBook(Book book);
        Book getNewBook();
}
