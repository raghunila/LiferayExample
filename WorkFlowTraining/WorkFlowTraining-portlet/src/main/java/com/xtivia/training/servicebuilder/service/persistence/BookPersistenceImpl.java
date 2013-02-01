package com.xtivia.training.servicebuilder.service.persistence;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.portlet.asset.service.persistence.AssetEntryPersistence;
import com.liferay.portlet.ratings.service.persistence.RatingsStatsPersistence;

import com.xtivia.training.servicebuilder.NoSuchBookException;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.model.impl.BookImpl;
import com.xtivia.training.servicebuilder.model.impl.BookModelImpl;
import com.xtivia.training.servicebuilder.service.persistence.BookPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the book service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookPersistence
 * @see BookUtil
 * @generated
 */
public class BookPersistenceImpl extends BasePersistenceImpl<Book>
    implements BookPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link BookUtil} to access the book persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = BookImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
            new String[] { String.class.getName() },
            BookModelImpl.UUID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() },
            BookModelImpl.UUID_COLUMN_BITMASK |
            BookModelImpl.GROUPID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
            new String[] { String.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ISBN = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByIsbn",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISBN = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByIsbn",
            new String[] { Long.class.getName() },
            BookModelImpl.ISBN_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ISBN = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIsbn",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, BookImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_BOOK = "SELECT book FROM Book book";
    private static final String _SQL_SELECT_BOOK_WHERE = "SELECT book FROM Book book WHERE ";
    private static final String _SQL_COUNT_BOOK = "SELECT COUNT(book) FROM Book book";
    private static final String _SQL_COUNT_BOOK_WHERE = "SELECT COUNT(book) FROM Book book WHERE ";
    private static final String _FINDER_COLUMN_UUID_UUID_1 = "book.uuid IS NULL";
    private static final String _FINDER_COLUMN_UUID_UUID_2 = "book.uuid = ?";
    private static final String _FINDER_COLUMN_UUID_UUID_3 = "(book.uuid IS NULL OR book.uuid = ?)";
    private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "book.uuid IS NULL AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "book.uuid = ? AND ";
    private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(book.uuid IS NULL OR book.uuid = ?) AND ";
    private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "book.groupId = ?";
    private static final String _FINDER_COLUMN_ISBN_ISBN_2 = "book.isbn = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "book.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Book exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Book exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(BookPersistenceImpl.class);
    private static Book _nullBook = new BookImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Book> toCacheModel() {
                return _nullBookCacheModel;
            }
        };

    private static CacheModel<Book> _nullBookCacheModel = new CacheModel<Book>() {
            public Book toEntityModel() {
                return _nullBook;
            }
        };

    @BeanReference(type = BookPersistence.class)
    protected BookPersistence bookPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    @BeanReference(type = AssetEntryPersistence.class)
    protected AssetEntryPersistence assetEntryPersistence;
    @BeanReference(type = RatingsStatsPersistence.class)
    protected RatingsStatsPersistence ratingsStatsPersistence;

    /**
     * Caches the book in the entity cache if it is enabled.
     *
     * @param book the book
     */
    public void cacheResult(Book book) {
        EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookImpl.class, book.getPrimaryKey(), book);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { book.getUuid(), Long.valueOf(book.getGroupId()) },
            book);

        book.resetOriginalValues();
    }

    /**
     * Caches the books in the entity cache if it is enabled.
     *
     * @param books the books
     */
    public void cacheResult(List<Book> books) {
        for (Book book : books) {
            if (EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
                        BookImpl.class, book.getPrimaryKey()) == null) {
                cacheResult(book);
            } else {
                book.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all books.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(BookImpl.class.getName());
        }

        EntityCacheUtil.clearCache(BookImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the book.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Book book) {
        EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookImpl.class, book.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(book);
    }

    @Override
    public void clearCache(List<Book> books) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Book book : books) {
            EntityCacheUtil.removeResult(BookModelImpl.ENTITY_CACHE_ENABLED,
                BookImpl.class, book.getPrimaryKey());

            clearUniqueFindersCache(book);
        }
    }

    protected void clearUniqueFindersCache(Book book) {
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
            new Object[] { book.getUuid(), Long.valueOf(book.getGroupId()) });
    }

    /**
     * Creates a new book with the primary key. Does not add the book to the database.
     *
     * @param id the primary key for the new book
     * @return the new book
     */
    public Book create(long id) {
        Book book = new BookImpl();

        book.setNew(true);
        book.setPrimaryKey(id);

        String uuid = PortalUUIDUtil.generate();

        book.setUuid(uuid);

        return book;
    }

    /**
     * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param id the primary key of the book
     * @return the book that was removed
     * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Book remove(long id) throws NoSuchBookException, SystemException {
        return remove(Long.valueOf(id));
    }

    /**
     * Removes the book with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the book
     * @return the book that was removed
     * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Book remove(Serializable primaryKey)
        throws NoSuchBookException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Book book = (Book) session.get(BookImpl.class, primaryKey);

            if (book == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(book);
        } catch (NoSuchBookException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Book removeImpl(Book book) throws SystemException {
        book = toUnwrappedModel(book);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, book);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(book);

        return book;
    }

    @Override
    public Book updateImpl(com.xtivia.training.servicebuilder.model.Book book,
        boolean merge) throws SystemException {
        book = toUnwrappedModel(book);

        boolean isNew = book.isNew();

        BookModelImpl bookModelImpl = (BookModelImpl) book;

        if (Validator.isNull(book.getUuid())) {
            String uuid = PortalUUIDUtil.generate();

            book.setUuid(uuid);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, book, merge);

            book.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !BookModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((bookModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { bookModelImpl.getOriginalUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);

                args = new Object[] { bookModelImpl.getUuid() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
                    args);
            }

            if ((bookModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISBN.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(bookModelImpl.getOriginalIsbn())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISBN, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISBN,
                    args);

                args = new Object[] { Long.valueOf(bookModelImpl.getIsbn()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ISBN, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISBN,
                    args);
            }
        }

        EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
            BookImpl.class, book.getPrimaryKey(), book);

        if (isNew) {
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                new Object[] { book.getUuid(), Long.valueOf(book.getGroupId()) },
                book);
        } else {
            if ((bookModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        bookModelImpl.getOriginalUuid(),
                        Long.valueOf(bookModelImpl.getOriginalGroupId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                    new Object[] { book.getUuid(), Long.valueOf(
                            book.getGroupId()) }, book);
            }
        }

        return book;
    }

    protected Book toUnwrappedModel(Book book) {
        if (book instanceof BookImpl) {
            return book;
        }

        BookImpl bookImpl = new BookImpl();

        bookImpl.setNew(book.isNew());
        bookImpl.setPrimaryKey(book.getPrimaryKey());

        bookImpl.setUuid(book.getUuid());
        bookImpl.setId(book.getId());
        bookImpl.setName(book.getName());
        bookImpl.setIsbn(book.getIsbn());
        bookImpl.setAuthor(book.getAuthor());
        bookImpl.setSummary(book.getSummary());
        bookImpl.setStatus(book.getStatus());
        bookImpl.setStatusByUserId(book.getStatusByUserId());
        bookImpl.setStatusByUserName(book.getStatusByUserName());
        bookImpl.setStatusDate(book.getStatusDate());
        bookImpl.setCompanyId(book.getCompanyId());
        bookImpl.setGroupId(book.getGroupId());
        bookImpl.setUserId(book.getUserId());

        return bookImpl;
    }

    /**
     * Returns the book with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the book
     * @return the book
     * @throws com.liferay.portal.NoSuchModelException if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Book findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the book with the primary key or throws a {@link com.xtivia.training.servicebuilder.NoSuchBookException} if it could not be found.
     *
     * @param id the primary key of the book
     * @return the book
     * @throws com.xtivia.training.servicebuilder.NoSuchBookException if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Book findByPrimaryKey(long id)
        throws NoSuchBookException, SystemException {
        Book book = fetchByPrimaryKey(id);

        if (book == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + id);
            }

            throw new NoSuchBookException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                id);
        }

        return book;
    }

    /**
     * Returns the book with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the book
     * @return the book, or <code>null</code> if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Book fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the book with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param id the primary key of the book
     * @return the book, or <code>null</code> if a book with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Book fetchByPrimaryKey(long id) throws SystemException {
        Book book = (Book) EntityCacheUtil.getResult(BookModelImpl.ENTITY_CACHE_ENABLED,
                BookImpl.class, id);

        if (book == _nullBook) {
            return null;
        }

        if (book == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                book = (Book) session.get(BookImpl.class, Long.valueOf(id));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (book != null) {
                    cacheResult(book);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(BookModelImpl.ENTITY_CACHE_ENABLED,
                        BookImpl.class, id, _nullBook);
                }

                closeSession(session);
            }
        }

        return book;
    }

    /**
     * Returns all the books where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the matching books
     * @throws SystemException if a system exception occurred
     */
    public List<Book> findByUuid(String uuid) throws SystemException {
        return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Book> findByUuid(String uuid, int start, int end)
        throws SystemException {
        return findByUuid(uuid, start, end, null);
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
    public List<Book> findByUuid(String uuid, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
            finderArgs = new Object[] { uuid, start, end, orderByComparator };
        }

        List<Book> list = (List<Book>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_BOOK_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                } else {
                    query.append(_FINDER_COLUMN_UUID_UUID_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(BookModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                list = (List<Book>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
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
    public Book findByUuid_First(String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        List<Book> list = findByUuid(uuid, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchBookException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public Book findByUuid_Last(String uuid, OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        int count = countByUuid(uuid);

        List<Book> list = findByUuid(uuid, count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchBookException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public Book[] findByUuid_PrevAndNext(long id, String uuid,
        OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        Book book = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Book[] array = new BookImpl[3];

            array[0] = getByUuid_PrevAndNext(session, book, uuid,
                    orderByComparator, true);

            array[1] = book;

            array[2] = getByUuid_PrevAndNext(session, book, uuid,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Book getByUuid_PrevAndNext(Session session, Book book,
        String uuid, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BOOK_WHERE);

        if (uuid == null) {
            query.append(_FINDER_COLUMN_UUID_UUID_1);
        } else {
            if (uuid.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_UUID_UUID_3);
            } else {
                query.append(_FINDER_COLUMN_UUID_UUID_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(BookModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (uuid != null) {
            qPos.add(uuid);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(book);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Book> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    public Book findByUUID_G(String uuid, long groupId)
        throws NoSuchBookException, SystemException {
        Book book = fetchByUUID_G(uuid, groupId);

        if (book == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("uuid=");
            msg.append(uuid);

            msg.append(", groupId=");
            msg.append(groupId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchBookException(msg.toString());
        }

        return book;
    }

    /**
     * Returns the book where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the matching book, or <code>null</code> if a matching book could not be found
     * @throws SystemException if a system exception occurred
     */
    public Book fetchByUUID_G(String uuid, long groupId)
        throws SystemException {
        return fetchByUUID_G(uuid, groupId, true);
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
    public Book fetchByUUID_G(String uuid, long groupId,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_UUID_G,
                    finderArgs, this);
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_BOOK_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_3);
                } else {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_2);
                }
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            query.append(BookModelImpl.ORDER_BY_JPQL);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                List<Book> list = q.list();

                result = list;

                Book book = null;

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs, list);
                } else {
                    book = list.get(0);

                    cacheResult(book);

                    if ((book.getUuid() == null) ||
                            !book.getUuid().equals(uuid) ||
                            (book.getGroupId() != groupId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_UUID_G,
                            finderArgs, book);
                    }
                }

                return book;
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (result == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_UUID_G,
                        finderArgs);
                }

                closeSession(session);
            }
        } else {
            if (result instanceof List<?>) {
                return null;
            } else {
                return (Book) result;
            }
        }
    }

    /**
     * Returns all the books where isbn = &#63;.
     *
     * @param isbn the isbn
     * @return the matching books
     * @throws SystemException if a system exception occurred
     */
    public List<Book> findByIsbn(long isbn) throws SystemException {
        return findByIsbn(isbn, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Book> findByIsbn(long isbn, int start, int end)
        throws SystemException {
        return findByIsbn(isbn, start, end, null);
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
    public List<Book> findByIsbn(long isbn, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ISBN;
            finderArgs = new Object[] { isbn };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ISBN;
            finderArgs = new Object[] { isbn, start, end, orderByComparator };
        }

        List<Book> list = (List<Book>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_BOOK_WHERE);

            query.append(_FINDER_COLUMN_ISBN_ISBN_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }
            else {
                query.append(BookModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isbn);

                list = (List<Book>) QueryUtil.list(q, getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
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
    public Book findByIsbn_First(long isbn, OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        List<Book> list = findByIsbn(isbn, 0, 1, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("isbn=");
            msg.append(isbn);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchBookException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public Book findByIsbn_Last(long isbn, OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        int count = countByIsbn(isbn);

        List<Book> list = findByIsbn(isbn, count - 1, count, orderByComparator);

        if (list.isEmpty()) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("isbn=");
            msg.append(isbn);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            throw new NoSuchBookException(msg.toString());
        } else {
            return list.get(0);
        }
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
    public Book[] findByIsbn_PrevAndNext(long id, long isbn,
        OrderByComparator orderByComparator)
        throws NoSuchBookException, SystemException {
        Book book = findByPrimaryKey(id);

        Session session = null;

        try {
            session = openSession();

            Book[] array = new BookImpl[3];

            array[0] = getByIsbn_PrevAndNext(session, book, isbn,
                    orderByComparator, true);

            array[1] = book;

            array[2] = getByIsbn_PrevAndNext(session, book, isbn,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Book getByIsbn_PrevAndNext(Session session, Book book, long isbn,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_BOOK_WHERE);

        query.append(_FINDER_COLUMN_ISBN_ISBN_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }
        else {
            query.append(BookModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(isbn);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(book);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Book> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the books.
     *
     * @return the books
     * @throws SystemException if a system exception occurred
     */
    public List<Book> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Book> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    public List<Book> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Book> list = (List<Book>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_BOOK);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_BOOK.concat(BookModelImpl.ORDER_BY_JPQL);
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Book>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Book>) QueryUtil.list(q, getDialect(), start,
                            end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the books where uuid = &#63; from the database.
     *
     * @param uuid the uuid
     * @throws SystemException if a system exception occurred
     */
    public void removeByUuid(String uuid) throws SystemException {
        for (Book book : findByUuid(uuid)) {
            remove(book);
        }
    }

    /**
     * Removes the book where uuid = &#63; and groupId = &#63; from the database.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByUUID_G(String uuid, long groupId)
        throws NoSuchBookException, SystemException {
        Book book = findByUUID_G(uuid, groupId);

        remove(book);
    }

    /**
     * Removes all the books where isbn = &#63; from the database.
     *
     * @param isbn the isbn
     * @throws SystemException if a system exception occurred
     */
    public void removeByIsbn(long isbn) throws SystemException {
        for (Book book : findByIsbn(isbn)) {
            remove(book);
        }
    }

    /**
     * Removes all the books from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Book book : findAll()) {
            remove(book);
        }
    }

    /**
     * Returns the number of books where uuid = &#63;.
     *
     * @param uuid the uuid
     * @return the number of matching books
     * @throws SystemException if a system exception occurred
     */
    public int countByUuid(String uuid) throws SystemException {
        Object[] finderArgs = new Object[] { uuid };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BOOK_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_UUID_3);
                } else {
                    query.append(_FINDER_COLUMN_UUID_UUID_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of books where uuid = &#63; and groupId = &#63;.
     *
     * @param uuid the uuid
     * @param groupId the group ID
     * @return the number of matching books
     * @throws SystemException if a system exception occurred
     */
    public int countByUUID_G(String uuid, long groupId)
        throws SystemException {
        Object[] finderArgs = new Object[] { uuid, groupId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID_G,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_BOOK_WHERE);

            if (uuid == null) {
                query.append(_FINDER_COLUMN_UUID_G_UUID_1);
            } else {
                if (uuid.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_3);
                } else {
                    query.append(_FINDER_COLUMN_UUID_G_UUID_2);
                }
            }

            query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (uuid != null) {
                    qPos.add(uuid);
                }

                qPos.add(groupId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID_G,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of books where isbn = &#63;.
     *
     * @param isbn the isbn
     * @return the number of matching books
     * @throws SystemException if a system exception occurred
     */
    public int countByIsbn(long isbn) throws SystemException {
        Object[] finderArgs = new Object[] { isbn };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_ISBN,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_BOOK_WHERE);

            query.append(_FINDER_COLUMN_ISBN_ISBN_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(isbn);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_ISBN,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of books.
     *
     * @return the number of books
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_BOOK);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the book persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.xtivia.training.servicebuilder.model.Book")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Book>> listenersList = new ArrayList<ModelListener<Book>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Book>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(BookImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
