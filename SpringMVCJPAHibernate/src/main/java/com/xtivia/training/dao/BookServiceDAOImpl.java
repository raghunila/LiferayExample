/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.dao;

import com.xitivia.training.entities.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rnila
 */
@Service(value = "bookServiceDAO")
public class BookServiceDAOImpl implements BookServiceDAO {

    @PersistenceContext
    private EntityManager em;

    public BookServiceDAOImpl() {
    }
    
    @Transactional
    public List<Book> getBooks() {
        return em.createNamedQuery("Book.findAll").getResultList();
    }
    @Transactional
    public void addBook(Book book) {
        em.persist(book);
    }

    public boolean isUniqueISBN(Long isbn) {
        boolean isUnique = true;

        for (Book book : getBooks()) {
            if (book.getIsbn() == isbn.longValue()) {
                isUnique = false;
                break;
            }
        }
        return isUnique;
    }
    @Transactional
    public Book getBook(Long isbn) {

        return (Book) em.createNamedQuery("Book.findByIsbn").setParameter("isbn", isbn.longValue()).getSingleResult();
    }
    @Transactional
    public void removeBook(Long isbn) {
        em.remove(getBook(isbn));
    }
    @Transactional
    public void editBook(Book book) {
        Book book_temp = getBook(book.getIsbn());
        book_temp.setAuthor(book.getAuthor());
        book_temp.setName(book.getName());
        book_temp.setSummary(book.getSummary());
        em.persist(book_temp);
    }
}
