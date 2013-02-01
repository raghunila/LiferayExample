package com.xtivia.training.servicebuilder.service.persistence;

public interface BookFinder {
    public com.xtivia.training.servicebuilder.model.Book findBook(long isbn)
        throws com.liferay.portal.kernel.exception.SystemException;
}
