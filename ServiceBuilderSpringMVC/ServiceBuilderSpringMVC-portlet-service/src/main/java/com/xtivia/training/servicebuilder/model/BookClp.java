package com.xtivia.training.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;


public class BookClp extends BaseModelImpl<Book> implements Book {
    private String _uuid;
    private long _id;
    private String _name;
    private long _isbn;
    private String _author;
    private String _summary;

    public BookClp() {
    }

    public Class<?> getModelClass() {
        return Book.class;
    }

    public String getModelClassName() {
        return Book.class.getName();
    }

    public long getPrimaryKey() {
        return _id;
    }

    public void setPrimaryKey(long primaryKey) {
        setId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_id);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    public void persist() throws SystemException {
        if (this.isNew()) {
            BookLocalServiceUtil.addBook(this);
        } else {
            BookLocalServiceUtil.updateBook(this);
        }
    }

    @Override
    public Book toEscapedModel() {
        return (Book) Proxy.newProxyInstance(Book.class.getClassLoader(),
            new Class[] { Book.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BookClp clone = new BookClp();

        clone.setUuid(getUuid());
        clone.setId(getId());
        clone.setName(getName());
        clone.setIsbn(getIsbn());
        clone.setAuthor(getAuthor());
        clone.setSummary(getSummary());

        return clone;
    }

    public int compareTo(Book book) {
        long primaryKey = book.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        BookClp book = null;

        try {
            book = (BookClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = book.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", id=");
        sb.append(getId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", isbn=");
        sb.append(getIsbn());
        sb.append(", author=");
        sb.append(getAuthor());
        sb.append(", summary=");
        sb.append(getSummary());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.xtivia.training.servicebuilder.model.Book");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>id</column-name><column-value><![CDATA[");
        sb.append(getId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isbn</column-name><column-value><![CDATA[");
        sb.append(getIsbn());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>author</column-name><column-value><![CDATA[");
        sb.append(getAuthor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>summary</column-name><column-value><![CDATA[");
        sb.append(getSummary());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
