/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.dao;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rnila
 */
@Service(value = "bookServiceDAO")
public class BookServiceDAOImpl implements BookServiceDAO {

    public void addBook(Book book) {
        try {
            BookLocalServiceUtil.addBook(book);
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isUniqueISBN(Long isbn) {
        boolean isUnique = true;
        try {
            if (BookLocalServiceUtil.findBook(isbn) != null) {
                isUnique = false;
            }
        } catch (PortalException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return isUnique;
    }

    public Book getBook(Long isbn) {
        try {
            return  BookLocalServiceUtil.findBook(isbn);
        } catch (PortalException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void removeBook(Long isbn) {
        try {
            BookLocalServiceUtil.deleteBook(isbn);
        } catch (PortalException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editBook(Book book) {
        try {
            BookLocalServiceUtil.editBook(book);
        } catch (PortalException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Book> getBooks() {
        try {
            return BookLocalServiceUtil.findBooks();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Book getNewBook() {
        try {
            return BookLocalServiceUtil.getNewBook();
        } catch (SystemException ex) {
            Logger.getLogger(BookServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
