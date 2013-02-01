package com.xtivia.training.servicebuilder.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.xtivia.training.servicebuilder.model.Book;

import java.util.List;

/**
 * The persistence utility for the book service. This utility wraps {@link BookPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see BookPersistenceImpl
 * @generated
 */
public class BookUtil {
    private static BookPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Book book) {
        getPersistence().clearCache(book);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Book> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Book update(Book book, boolean merge)
        throws SystemException {
        return getPersistence().update(book, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Book update(Book book, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(book, merge, serviceContext);
    }

    /**
    * Caches the book in the entity cache if it is enabled.
    *
    * @param book the book
    */
    public static void cacheResult(
        com.xtivia.training.servicebuilder.model.Book book) {
        getPersistence().cacheResult(book);
    }

    /**
    * Caches the books in the entity cache if it is enabled.
    *
    * @param books the books
    */
    public static void cacheResult(
        java.util.List<com.xtivia.training.servicebuilder.model.Book> books) {
        getPersistence().cacheResult(books);
    }

    /**
    * Creates a new book with the primary key. Does not add the book to the database.
    *
    * @param id the primary key for the new book
    * @return the new book
    */
    public static com.xtivia.training.servicebuilder.model.Book create(long id) {
        return getPersistence().create(id);
    }

    /**
    * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the book
    * @return the book that was removed
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book remove(long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().remove(id);
    }

    public static com.xtivia.training.servicebuilder.model.Book updateImpl(
        com.xtivia.training.servicebuilder.model.Book book, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(book, merge);
    }

    /**
    * Returns the book with the primary key or throws a {@link com.xtivia.training.servicebuilder.NoSuchBookException} if it could not be found.
    *
    * @param id the primary key of the book
    * @return the book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book findByPrimaryKey(
        long id)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByPrimaryKey(id);
    }

    /**
    * Returns the book with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id the primary key of the book
    * @return the book, or <code>null</code> if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book fetchByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    /**
    * Returns all the books where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching books
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence()
                   .findByUuid_PrevAndNext(id, uuid, orderByComparator);
    }

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or throws a {@link com.xtivia.training.servicebuilder.NoSuchBookException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching book
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching book, or <code>null</code> if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching book, or <code>null</code> if a matching book could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Returns all the books where isbn = &#63;.
    *
    * @param isbn the isbn
    * @return the matching books
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByIsbn(isbn);
    }

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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByIsbn(isbn, start, end);
    }

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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findByIsbn(
        long isbn, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByIsbn(isbn, start, end, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book findByIsbn_First(
        long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByIsbn_First(isbn, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book findByIsbn_Last(
        long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence().findByIsbn_Last(isbn, orderByComparator);
    }

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
    public static com.xtivia.training.servicebuilder.model.Book[] findByIsbn_PrevAndNext(
        long id, long isbn,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getPersistence()
                   .findByIsbn_PrevAndNext(id, isbn, orderByComparator);
    }

    /**
    * Returns all the books.
    *
    * @return the books
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the books where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Removes the book where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Removes all the books where isbn = &#63; from the database.
    *
    * @param isbn the isbn
    * @throws SystemException if a system exception occurred
    */
    public static void removeByIsbn(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByIsbn(isbn);
    }

    /**
    * Removes all the books from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of books where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the number of books where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of books where isbn = &#63;.
    *
    * @param isbn the isbn
    * @return the number of matching books
    * @throws SystemException if a system exception occurred
    */
    public static int countByIsbn(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByIsbn(isbn);
    }

    /**
    * Returns the number of books.
    *
    * @return the number of books
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BookPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BookPersistence) PortletBeanLocatorUtil.locate(com.xtivia.training.servicebuilder.service.ClpSerializer.getServletContextName(),
                    BookPersistence.class.getName());

            ReferenceRegistry.registerReference(BookUtil.class, "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(BookPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(BookUtil.class, "_persistence");
    }
}
