package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the book local service. This utility wraps {@link com.xtivia.training.servicebuilder.service.impl.BookLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookLocalService
 * @see com.xtivia.training.servicebuilder.service.base.BookLocalServiceBaseImpl
 * @see com.xtivia.training.servicebuilder.service.impl.BookLocalServiceImpl
 * @generated
 */
public class BookLocalServiceUtil {
    private static BookLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.xtivia.training.servicebuilder.service.impl.BookLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the book to the database. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @return the book that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book addBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addBook(book);
    }

    /**
    * Creates a new book with the primary key. Does not add the book to the database.
    *
    * @param id the primary key for the new book
    * @return the new book
    */
    public static com.xtivia.training.servicebuilder.model.Book createBook(
        long id) {
        return getService().createBook(id);
    }

    /**
    * Deletes the book with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id the primary key of the book
    * @throws PortalException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException
    */
    public static void deleteBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        getService().deleteBook(id);
    }

    /**
    * Deletes the book from the database. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @throws SystemException if a system exception occurred
    */
    public static void deleteBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteBook(book);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.xtivia.training.servicebuilder.model.Book fetchBook(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchBook(id);
    }

    /**
    * Returns the book with the primary key.
    *
    * @param id the primary key of the book
    * @return the book
    * @throws PortalException if a book with the primary key could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException
    */
    public static com.xtivia.training.servicebuilder.model.Book getBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getService().getBook(id);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the book with the UUID in the group.
    *
    * @param uuid the UUID of book
    * @param groupId the group id of the book
    * @return the book
    * @throws PortalException if a book with the UUID in the group could not be found
    * @throws SystemException if a system exception occurred
    * @throws com.xtivia.training.servicebuilder.NoSuchBookException
    */
    public static com.xtivia.training.servicebuilder.model.Book getBookByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        return getService().getBookByUuidAndGroupId(uuid, groupId);
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
    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> getBooks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBooks(start, end);
    }

    /**
    * Returns the number of books.
    *
    * @return the number of books
    * @throws SystemException if a system exception occurred
    */
    public static int getBooksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getBooksCount();
    }

    /**
    * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @return the book that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBook(book);
    }

    /**
    * Updates the book in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param book the book
    * @param merge whether to merge the book with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the book that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateBook(book, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static com.xtivia.training.servicebuilder.model.Book addBook(
        com.xtivia.training.servicebuilder.model.Book newBook,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().addBook(newBook, serviceContext);
    }

    public static com.xtivia.training.servicebuilder.model.Book editBook(
        com.xtivia.training.servicebuilder.model.Book newBook)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().editBook(newBook);
    }

    public static void updateAudit(
        com.xtivia.training.servicebuilder.model.Book oldBook,
        com.xtivia.training.servicebuilder.model.Book newBook) {
        getService().updateAudit(oldBook, newBook);
    }

    public static com.xtivia.training.servicebuilder.model.Book findByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByPrimaryKey(id);
    }

    public static com.xtivia.training.servicebuilder.model.Book findByIsbn(
        long isbn) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByIsbn(isbn);
    }

    public static com.xtivia.training.servicebuilder.model.Book updateStatus(
        long userId, long resourcePrimKey, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateStatus(userId, resourcePrimKey, status, serviceContext);
    }

    public static com.xtivia.training.servicebuilder.model.Book getNewBook()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewBook();
    }

    public static java.util.List<com.xtivia.training.servicebuilder.model.Book> findBooks() {
        return getService().findBooks();
    }

    public static com.liferay.portal.kernel.audit.AuditMessage buildAuditMessage(
        java.lang.String eventType, java.lang.String className, long classPK,
        java.util.List<com.liferay.portal.audit.hook.listeners.util.Attribute> attributes) {
        return getService()
                   .buildAuditMessage(eventType, className, classPK, attributes);
    }

    public static void clearService() {
        _service = null;
    }

    public static BookLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    BookLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    BookLocalService.class.getName(), portletClassLoader);

            _service = new BookLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(BookLocalServiceUtil.class,
                "_service");
            MethodCache.remove(BookLocalService.class);
        }

        return _service;
    }

    public void setService(BookLocalService service) {
        MethodCache.remove(BookLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(BookLocalServiceUtil.class,
            "_service");
        MethodCache.remove(BookLocalService.class);
    }
}
