package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BookLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookLocalService
 * @generated
 */
public class BookLocalServiceWrapper implements BookLocalService,
    ServiceWrapper<BookLocalService> {
    private BookLocalService _bookLocalService;

    public BookLocalServiceWrapper(BookLocalService bookLocalService) {
        _bookLocalService = bookLocalService;
    }

    /**
    * Adds the book to the database. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @return the book that was added
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book addBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.addBook(book);
    }

    /**
    * Creates a new book with the primary key. Does not add the book to the database.
    *
    * @param id the primary key for the new book
    * @return the new book
    */
    public com.xtivia.training.servicebuilder.model.Book createBook(long id) {
        return _bookLocalService.createBook(id);
    }

    /**
    * Deletes the book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the book
    * @throws PortalException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _bookLocalService.deleteBook(id);
    }

    /**
    * Deletes the book from the database. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @throws SystemException if a system exception occurred
    */
    public void deleteBook(com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        _bookLocalService.deleteBook(book);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.xtivia.training.servicebuilder.model.Book fetchBook(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.fetchBook(id);
    }

    /**
    * Returns the book with the primary key.
    *
    * @param id the primary key of the book
    * @return the book
    * @throws PortalException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book getBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.getBook(id);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the books.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @return the range of books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> getBooks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.getBooks(start, end);
    }

    /**
    * Returns the number of books.
    *
    * @return the number of books
    * @throws SystemException if a system exception occurred
    */
    public int getBooksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.getBooksCount();
    }

    /**
    * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @return the book that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.updateBook(book);
    }

    /**
    * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @param merge whether to merge the book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the book that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.updateBook(book, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _bookLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _bookLocalService.setBeanIdentifier(beanIdentifier);
    }

    public com.xtivia.training.servicebuilder.model.Book getNewBook()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bookLocalService.getNewBook();
    }

    public com.xtivia.training.servicebuilder.model.Book editBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.rmi.RemoteException {
        return _bookLocalService.editBook(book);
    }

    public com.xtivia.training.servicebuilder.model.Book findBook(long isbn)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.rmi.RemoteException {
        return _bookLocalService.findBook(isbn);
    }

    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findBooks()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            java.rmi.RemoteException {
        return _bookLocalService.findBooks();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public BookLocalService getWrappedBookLocalService() {
        return _bookLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedBookLocalService(BookLocalService bookLocalService) {
        _bookLocalService = bookLocalService;
    }

    public BookLocalService getWrappedService() {
        return _bookLocalService;
    }

    public void setWrappedService(BookLocalService bookLocalService) {
        _bookLocalService = bookLocalService;
    }
}
