package com.xtivia.training.servicebuilder.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.base.BookLocalServiceBaseImpl;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation of the book local service.
 *
 * <p> All custom service methods should be put in this class. Whenever methods
 * are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.xtivia.training.servicebuilder.service.BookLocalService}
 * interface.
 *
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.xtivia.training.servicebuilder.service.base.BookLocalServiceBaseImpl
 * @see com.xtivia.training.servicebuilder.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.xtivia.training.servicebuilder.service.BookLocalServiceUtil} to access the book local service.
     */

    @Override
    public Book addBook(Book book) throws SystemException {
        Book newBook = bookPersistence.create(counterLocalService.increment(Book.class.getName()));
        newBook.setAuthor(book.getAuthor());
        newBook.setIsbn(book.getIsbn());
        newBook.setName(book.getName());
        newBook.setSummary(book.getSummary());
        return bookPersistence.update(newBook, false);
    }
    public Book getNewBook() throws SystemException
    {
        return bookPersistence.create(counterLocalService.increment(Book.class.getName()));
    }

    public Book editBook(Book book) throws SystemException, PortalException, RemoteException {
        Book editBook = findBook(book.getIsbn());
        editBook.setAuthor(book.getAuthor());
        editBook.setName(book.getName());
        editBook.setSummary(book.getSummary());
        return bookPersistence.update(editBook, true);
    }

    public void deleteBook(long isbn) throws PortalException, SystemException {
        try {
            Book book = findBook(isbn);
            resourceLocalService.deleteResource(book.getId(), Book.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, book.getPrimaryKey());
            bookPersistence.remove(book);
        } catch (RemoteException ex) {
            Logger.getLogger(BookLocalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Book findBook(long isbn) throws PortalException,
            SystemException, RemoteException {
        return bookFinder.findBook(isbn);
    }
    public List<Book> findBooks() throws PortalException,
            SystemException, RemoteException {
        return bookPersistence.findAll();
    }
}
