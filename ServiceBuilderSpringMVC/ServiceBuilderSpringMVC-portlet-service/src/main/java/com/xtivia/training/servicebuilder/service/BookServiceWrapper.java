package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link BookService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       BookService
 * @generated
 */
public class BookServiceWrapper implements BookService,
    ServiceWrapper<BookService> {
    private BookService _bookService;

    public BookServiceWrapper(BookService bookService) {
        _bookService = bookService;
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public BookService getWrappedBookService() {
        return _bookService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedBookService(BookService bookService) {
        _bookService = bookService;
    }

    public BookService getWrappedService() {
        return _bookService;
    }

    public void setWrappedService(BookService bookService) {
        _bookService = bookService;
    }
}
