package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;


public class BookLocalServiceClp implements BookLocalService {
    private ClassLoaderProxy _classLoaderProxy;
    private MethodKey _addBookMethodKey0;
    private MethodKey _createBookMethodKey1;
    private MethodKey _deleteBookMethodKey2;
    private MethodKey _deleteBookMethodKey3;
    private MethodKey _dynamicQueryMethodKey4;
    private MethodKey _dynamicQueryMethodKey5;
    private MethodKey _dynamicQueryMethodKey6;
    private MethodKey _dynamicQueryCountMethodKey7;
    private MethodKey _fetchBookMethodKey8;
    private MethodKey _getBookMethodKey9;
    private MethodKey _getPersistedModelMethodKey10;
    private MethodKey _getBookByUuidAndGroupIdMethodKey11;
    private MethodKey _getBooksMethodKey12;
    private MethodKey _getBooksCountMethodKey13;
    private MethodKey _updateBookMethodKey14;
    private MethodKey _updateBookMethodKey15;
    private MethodKey _getBeanIdentifierMethodKey16;
    private MethodKey _setBeanIdentifierMethodKey17;
    private MethodKey _addBookMethodKey18;
    private MethodKey _editBookMethodKey19;
    private MethodKey _updateAuditMethodKey20;
    private MethodKey _findByPrimaryKeyMethodKey21;
    private MethodKey _findByIsbnMethodKey22;
    private MethodKey _updateStatusMethodKey23;
    private MethodKey _getNewBookMethodKey24;
    private MethodKey _findBooksMethodKey25;
    private MethodKey _buildAuditMessageMethodKey26;

    public BookLocalServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;

        _addBookMethodKey0 = new MethodKey(_classLoaderProxy.getClassName(),
                "addBook", com.xtivia.training.servicebuilder.model.Book.class);

        _createBookMethodKey1 = new MethodKey(_classLoaderProxy.getClassName(),
                "createBook", long.class);

        _deleteBookMethodKey2 = new MethodKey(_classLoaderProxy.getClassName(),
                "deleteBook", long.class);

        _deleteBookMethodKey3 = new MethodKey(_classLoaderProxy.getClassName(),
                "deleteBook",
                com.xtivia.training.servicebuilder.model.Book.class);

        _dynamicQueryMethodKey4 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _dynamicQueryMethodKey5 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class);

        _dynamicQueryMethodKey6 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQuery",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class,
                int.class, int.class,
                com.liferay.portal.kernel.util.OrderByComparator.class);

        _dynamicQueryCountMethodKey7 = new MethodKey(_classLoaderProxy.getClassName(),
                "dynamicQueryCount",
                com.liferay.portal.kernel.dao.orm.DynamicQuery.class);

        _fetchBookMethodKey8 = new MethodKey(_classLoaderProxy.getClassName(),
                "fetchBook", long.class);

        _getBookMethodKey9 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBook", long.class);

        _getPersistedModelMethodKey10 = new MethodKey(_classLoaderProxy.getClassName(),
                "getPersistedModel", java.io.Serializable.class);

        _getBookByUuidAndGroupIdMethodKey11 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBookByUuidAndGroupId", java.lang.String.class, long.class);

        _getBooksMethodKey12 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBooks", int.class, int.class);

        _getBooksCountMethodKey13 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBooksCount");

        _updateBookMethodKey14 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateBook",
                com.xtivia.training.servicebuilder.model.Book.class);

        _updateBookMethodKey15 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateBook",
                com.xtivia.training.servicebuilder.model.Book.class,
                boolean.class);

        _getBeanIdentifierMethodKey16 = new MethodKey(_classLoaderProxy.getClassName(),
                "getBeanIdentifier");

        _setBeanIdentifierMethodKey17 = new MethodKey(_classLoaderProxy.getClassName(),
                "setBeanIdentifier", java.lang.String.class);

        _addBookMethodKey18 = new MethodKey(_classLoaderProxy.getClassName(),
                "addBook", com.xtivia.training.servicebuilder.model.Book.class,
                com.liferay.portal.service.ServiceContext.class);

        _editBookMethodKey19 = new MethodKey(_classLoaderProxy.getClassName(),
                "editBook", com.xtivia.training.servicebuilder.model.Book.class);

        _updateAuditMethodKey20 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateAudit",
                com.xtivia.training.servicebuilder.model.Book.class,
                com.xtivia.training.servicebuilder.model.Book.class);

        _findByPrimaryKeyMethodKey21 = new MethodKey(_classLoaderProxy.getClassName(),
                "findByPrimaryKey", long.class);

        _findByIsbnMethodKey22 = new MethodKey(_classLoaderProxy.getClassName(),
                "findByIsbn", long.class);

        _updateStatusMethodKey23 = new MethodKey(_classLoaderProxy.getClassName(),
                "updateStatus", long.class, long.class, int.class,
                com.liferay.portal.service.ServiceContext.class);

        _getNewBookMethodKey24 = new MethodKey(_classLoaderProxy.getClassName(),
                "getNewBook");

        _findBooksMethodKey25 = new MethodKey(_classLoaderProxy.getClassName(),
                "findBooks");

        _buildAuditMessageMethodKey26 = new MethodKey(_classLoaderProxy.getClassName(),
                "buildAuditMessage", java.lang.String.class,
                java.lang.String.class, long.class, java.util.List.class);
    }

    public com.xtivia.training.servicebuilder.model.Book addBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_addBookMethodKey0,
                ClpSerializer.translateInput(book));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book createBook(long id) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_createBookMethodKey1,
                id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public void deleteBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        MethodHandler methodHandler = new MethodHandler(_deleteBookMethodKey2,
                id);

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.xtivia.training.servicebuilder.NoSuchBookException) {
                throw (com.xtivia.training.servicebuilder.NoSuchBookException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public void deleteBook(com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        MethodHandler methodHandler = new MethodHandler(_deleteBookMethodKey3,
                ClpSerializer.translateInput(book));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey4,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey5,
                ClpSerializer.translateInput(dynamicQuery), start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryMethodKey6,
                ClpSerializer.translateInput(dynamicQuery), start, end,
                ClpSerializer.translateInput(orderByComparator));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List) ClpSerializer.translateOutput(returnObj);
    }

    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_dynamicQueryCountMethodKey7,
                ClpSerializer.translateInput(dynamicQuery));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Long) returnObj).longValue();
    }

    public com.xtivia.training.servicebuilder.model.Book fetchBook(long id)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_fetchBookMethodKey8, id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book getBook(long id)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBookMethodKey9, id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.xtivia.training.servicebuilder.NoSuchBookException) {
                throw (com.xtivia.training.servicebuilder.NoSuchBookException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getPersistedModelMethodKey10,
                ClpSerializer.translateInput(primaryKeyObj));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.model.PersistedModel) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book getBookByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException,
            com.xtivia.training.servicebuilder.NoSuchBookException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBookByUuidAndGroupIdMethodKey11,
                ClpSerializer.translateInput(uuid), groupId);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof com.xtivia.training.servicebuilder.NoSuchBookException) {
                throw (com.xtivia.training.servicebuilder.NoSuchBookException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.xtivia.training.servicebuilder.model.Book> getBooks(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBooksMethodKey12,
                start, end);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.xtivia.training.servicebuilder.model.Book>) ClpSerializer.translateOutput(returnObj);
    }

    public int getBooksCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBooksCountMethodKey13);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return ((Integer) returnObj).intValue();
    }

    public com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateBookMethodKey14,
                ClpSerializer.translateInput(book));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book updateBook(
        com.xtivia.training.servicebuilder.model.Book book, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateBookMethodKey15,
                ClpSerializer.translateInput(book), merge);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getBeanIdentifierMethodKey16);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        MethodHandler methodHandler = new MethodHandler(_setBeanIdentifierMethodKey17,
                ClpSerializer.translateInput(beanIdentifier));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public com.xtivia.training.servicebuilder.model.Book addBook(
        com.xtivia.training.servicebuilder.model.Book newBook,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_addBookMethodKey18,
                ClpSerializer.translateInput(newBook),
                ClpSerializer.translateInput(serviceContext));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book editBook(
        com.xtivia.training.servicebuilder.model.Book newBook)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_editBookMethodKey19,
                ClpSerializer.translateInput(newBook));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public void updateAudit(
        com.xtivia.training.servicebuilder.model.Book oldBook,
        com.xtivia.training.servicebuilder.model.Book newBook) {
        MethodHandler methodHandler = new MethodHandler(_updateAuditMethodKey20,
                ClpSerializer.translateInput(oldBook),
                ClpSerializer.translateInput(newBook));

        try {
            _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    public com.xtivia.training.servicebuilder.model.Book findByPrimaryKey(
        long id) throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_findByPrimaryKeyMethodKey21,
                id);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book findByIsbn(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_findByIsbnMethodKey22,
                isbn);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book updateStatus(
        long userId, long resourcePrimKey, int status,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_updateStatusMethodKey23,
                userId, resourcePrimKey, status,
                ClpSerializer.translateInput(serviceContext));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
                throw (com.liferay.portal.kernel.exception.PortalException) t;
            }

            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public com.xtivia.training.servicebuilder.model.Book getNewBook()
        throws com.liferay.portal.kernel.exception.SystemException {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_getNewBookMethodKey24);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
                throw (com.liferay.portal.kernel.exception.SystemException) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.xtivia.training.servicebuilder.model.Book) ClpSerializer.translateOutput(returnObj);
    }

    public java.util.List<com.xtivia.training.servicebuilder.model.Book> findBooks() {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_findBooksMethodKey25);

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.xtivia.training.servicebuilder.model.Book>) ClpSerializer.translateOutput(returnObj);
    }

    public com.liferay.portal.kernel.audit.AuditMessage buildAuditMessage(
        java.lang.String eventType, java.lang.String className, long classPK,
        java.util.List<com.liferay.portal.audit.hook.listeners.util.Attribute> attributes) {
        Object returnObj = null;

        MethodHandler methodHandler = new MethodHandler(_buildAuditMessageMethodKey26,
                ClpSerializer.translateInput(eventType),
                ClpSerializer.translateInput(className), classPK,
                ClpSerializer.translateInput(attributes));

        try {
            returnObj = _classLoaderProxy.invoke(methodHandler);
        } catch (Throwable t) {
            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.portal.kernel.audit.AuditMessage) ClpSerializer.translateOutput(returnObj);
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
