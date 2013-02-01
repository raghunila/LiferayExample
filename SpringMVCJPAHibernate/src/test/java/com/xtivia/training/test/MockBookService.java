package com.xtivia.training.test;

import com.xitivia.training.entities.Book;
import com.xtivia.training.dao.BookServiceDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;



/**
 * Mock BookService which provides implementation of some of the methods
 * of the BookService interface. The removeBook and isUniqueISBN number method
 * implementations have been left out as the test cases currently don't test these methods.
 * 
 * @author asarin
 *
 */
@Service("mockBookService")
public class MockBookService implements BookServiceDAO {
	private List<Book> books = Collections
			.synchronizedList(new ArrayList<Book>());

	public void addBook(Book book) {
		books.add(book);
	}

	public Book getBook(Long isbn) {
		Book matchedBook = null;
		for(Book book : books) {
			if(book.getIsbn()== isbn.longValue()) {
				matchedBook = book;
			   break;
			}
		}
		return matchedBook;
	}

	public List<Book> getBooks() {
		List<Book> list = new ArrayList<Book>();
		list.add(new Book("Portlets in Action", "Ashish Sarin", 1234567890L,"this is summary man"));
		return null;
	}

	//--this method is not currently being tested
	public boolean isUniqueISBN(Long isbn) {
		return false;
	}

	//--this method is not currently being tested
	public void removeBook(Long isbn) {
		//-- does nothing
	}
	
	//--this method is not currently being tested
	public void editBook(Book book) {
		//-- does nothing
	}
}
