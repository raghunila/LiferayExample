package com.xtivia.training.servicebuilder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.xtivia.training.servicebuilder.model.Book;

/**
 * The persistence interface for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistenceImpl
 * @see BookUtil
 * @generated
 */
public interface BookPersistence extends BasePersistence<Book> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the book in the entity cache if it is enabled.
    *
    * @param book the book
    */
    public void cacheResult(com.xtivia.training.servicebuilder.model.Book book);

    /**
    * Caches the books in the entity cache if it is enabled.
    *
    * @param books the books
    */
    public void cacheResult(
        java.util.List<com.xtivia.training.servicebuilder.model.Book> books);

    /**
    * Creates a new book with the primary key. Does not add the book to the database.
    *
    * @param id the primary key for the new book
    * @return the new book
    */
    public com.xtivia.training.servicebuilder.model.Book create(long id);

    /**
    * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the book
    * @return the book that was removed
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    public com.xtivia.training.servicebuilder.model.Book updateImpl(
        com.xtivia.training.servicebuilder.model.Book book, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the book with the primary key or throws a {@link com.xtivia.training.servicebuilder.NoSuchBookException} if it could not be found.
    *
    * @param id the primary key of the book
    * @return the book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByPrimaryKey(
        long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the book with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the book
    * @return the book, or <code>null</code> if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the books where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the books where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @return the range of matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the books where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first book in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the last book in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the books before and after the current book in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current book
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or throws a {@link com.xtivia.training.servicebuilder.NoSuchBookException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching book, or <code>null</code> if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching book, or <code>null</code> if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the books where isbn = &#63;.
    *
    * @param isbn the isbn
    * @return the matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the books where isbn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isbn the isbn
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @return the range of matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the books where isbn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isbn the isbn
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first book in the ordered set where isbn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isbn the isbn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByIsbn_First(
        long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the last book in the ordered set where isbn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param isbn the isbn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book findByIsbn_Last(
        long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns the books before and after the current book in the ordered set where isbn = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param id the primary key of the current book
    * @param isbn the isbn
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.xtivia.training.servicebuilder.model.Book[] findByIsbn_PrevAndNext(
        long id, long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Returns all the books.
    *
    * @return the books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the books.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of books
    * @param end the upper bound of the range of books (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of books
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the books where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the book where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException;

    /**
    * Removes all the books where isbn = &#63; from the database.
    *
    * @param isbn the isbn
    * @throws SystemException if a system exception occurred
    */
    public void removeByIsbn(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the books from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of books where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of books where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of books where isbn = &#63;.
    *
    * @param isbn the isbn
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public int countByIsbn(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of books.
    *
    * @return the number of books
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
