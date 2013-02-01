package com.xtivia.training.servicebuilder.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.xtivia.training.servicebuilder.service.http.BookServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.xtivia.training.servicebuilder.service.http.BookServiceSoap
 * @generated
 */
public class BookSoap implements Serializable {
    private String _uuid;
    private long _id;
    private String _name;
    private long _isbn;
    private String _author;
    private String _summary;

    public BookSoap() {
    }

    public static BookSoap toSoapModel(Book model) {
        BookSoap soapModel = new BookSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setId(model.getId());
        soapModel.setName(model.getName());
        soapModel.setIsbn(model.getIsbn());
        soapModel.setAuthor(model.getAuthor());
        soapModel.setSummary(model.getSummary());

        return soapModel;
    }

    public static BookSoap[] toSoapModels(Book[] models) {
        BookSoap[] soapModels = new BookSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BookSoap[][] toSoapModels(Book[][] models) {
        BookSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BookSoap[models.length][models[0].length];
        } else {
            soapModels = new BookSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BookSoap[] toSoapModels(List<Book> models) {
        List<BookSoap> soapModels = new ArrayList<BookSoap>(models.size());

        for (Book model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BookSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long pk) {
        setId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public long getIsbn() {
        return _isbn;
    }

    public void setIsbn(long isbn) {
        _isbn = isbn;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        _author = author;
    }

    public String getSummary() {
        return _summary;
    }

    public void setSummary(String summary) {
        _summary = summary;
    }
}
