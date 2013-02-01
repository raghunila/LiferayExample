package com.xtivia.training.servicebuilder.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;


public class BookServiceClp implements BookService {
    private ClassLoaderProxy _classLoaderProxy;

    public BookServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }
}
