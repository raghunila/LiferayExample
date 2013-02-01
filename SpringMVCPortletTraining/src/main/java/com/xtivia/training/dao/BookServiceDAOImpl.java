/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.dao;

import com.xtivia.training.data.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import org.springframework.stereotype.Service;

/**
 *
 * @author rnila
 */
@Service(value = "bookServiceDAO")
public class BookServiceDAOImpl implements BookServiceDAO {

    private List<Book> books = Collections.synchronizedList(new ArrayList<Book>());

    public BookServiceDAOImpl() {
        books.add(new Book("AspectJ in Action, Second Edition", "Ramnivas Laddad", Long.valueOf("1933988053"), ""));
        books.add(new Book("ActiveMQ in Action", "Bruce Snyder, Dejan Bosanac, and Rob Davies", Long.valueOf("1933988940"), ""));
        books.add(new Book("Hadoop in Action", "Chuck Lam", Long.valueOf("9781935182191"), ""));
        books.add(new Book("JUnit in Action, Second Edition", "Petar Tahchiev, Felipe Leme, Vincent Massol, and Gary Gregory", Long.valueOf("9781935182023"), ""));

    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean isUniqueISBN(Long isbnNumber) {
        boolean isUnique = true;
        for (Book book : books) {
            if (book.getIsbnNumber().equals(isbnNumber)) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }

    public Book getBook(Long isbnNumber) {
        Book matchingBook = null;
        Book returnBook = null;

        synchronized (books) {
            for (Book book : books) {
                if (book.getIsbnNumber().equals(isbnNumber)) {
                    matchingBook = book;
                    break;
                }
            }
            // --create shallow copy of the Book object
            if (matchingBook != null) {
                returnBook = new Book();
                returnBook.setAuthor(matchingBook.getAuthor());
                returnBook.setIsbnNumber(matchingBook.getIsbnNumber());
                returnBook.setName(matchingBook.getName());
                returnBook.setSummary(matchingBook.getSummary());
            }
        }
        return returnBook;
    }
    public void removeBook(Long isbnNumber) {
        synchronized (books) {
            books.remove(getBook(isbnNumber));
        }
    }
    public void editBook(Book book) {
        System.out.println("i am here");
        Long isbnNumber = book.getIsbnNumber();
        Book matchingBook = null;
        ListIterator iterator = books.listIterator();
        while (iterator.hasNext()) {
            Book book_ = (Book) iterator.next();

            if (isbnNumber.equals(book.getIsbnNumber())) {
                iterator.remove();
                System.out.println("hi whats up");
                books.add(book);
                break;
            }
        }
    }
}
