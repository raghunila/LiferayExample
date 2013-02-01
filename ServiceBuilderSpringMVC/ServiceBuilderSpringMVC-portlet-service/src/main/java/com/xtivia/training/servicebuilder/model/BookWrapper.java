package com.xtivia.training.servicebuilder.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Book
 * @generated
 */
public class BookWrapper implements Book, ModelWrapper<Book> {
    private Book _book;

    public BookWrapper(Book book) {
        _book = book;
    }

    public Class<?> getModelClass() {
        return Book.class;
    }

    public String getModelClassName() {
        return Book.class.getName();
    }

    /**
    * Returns the primary key of this book.
    *
    * @return the primary key of this book
    */
    public long getPrimaryKey() {
        return _book.getPrimaryKey();
    }

    /**
    * Sets the primary key of this book.
    *
    * @param primaryKey the primary key of this book
    */
    public void setPrimaryKey(long primaryKey) {
        _book.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this book.
    *
    * @return the uuid of this book
    */
    public java.lang.String getUuid() {
        return _book.getUuid();
    }

    /**
    * Sets the uuid of this book.
    *
    * @param uuid the uuid of this book
    */
    public void setUuid(java.lang.String uuid) {
        _book.setUuid(uuid);
    }

    /**
    * Returns the ID of this book.
    *
    * @return the ID of this book
    */
    public long getId() {
        return _book.getId();
    }

    /**
    * Sets the ID of this book.
    *
    * @param id the ID of this book
    */
    public void setId(long id) {
        _book.setId(id);
    }

    /**
    * Returns the name of this book.
    *
    * @return the name of this book
    */
    public java.lang.String getName() {
        return _book.getName();
    }

    /**
    * Sets the name of this book.
    *
    * @param name the name of this book
    */
    public void setName(java.lang.String name) {
        _book.setName(name);
    }

    /**
    * Returns the isbn of this book.
    *
    * @return the isbn of this book
    */
    public long getIsbn() {
        return _book.getIsbn();
    }

    /**
    * Sets the isbn of this book.
    *
    * @param isbn the isbn of this book
    */
    public void setIsbn(long isbn) {
        _book.setIsbn(isbn);
    }

    /**
    * Returns the author of this book.
    *
    * @return the author of this book
    */
    public java.lang.String getAuthor() {
        return _book.getAuthor();
    }

    /**
    * Sets the author of this book.
    *
    * @param author the author of this book
    */
    public void setAuthor(java.lang.String author) {
        _book.setAuthor(author);
    }

    /**
    * Returns the summary of this book.
    *
    * @return the summary of this book
    */
    public java.lang.String getSummary() {
        return _book.getSummary();
    }

    /**
    * Sets the summary of this book.
    *
    * @param summary the summary of this book
    */
    public void setSummary(java.lang.String summary) {
        _book.setSummary(summary);
    }

    public boolean isNew() {
        return _book.isNew();
    }

    public void setNew(boolean n) {
        _book.setNew(n);
    }

    public boolean isCachedModel() {
        return _book.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _book.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _book.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _book.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _book.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _book.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _book.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BookWrapper((Book) _book.clone());
    }

    public int compareTo(Book book) {
        return _book.compareTo(book);
    }

    @Override
    public int hashCode() {
        return _book.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Book> toCacheModel() {
        return _book.toCacheModel();
    }

    public Book toEscapedModel() {
        return new BookWrapper(_book.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _book.toString();
    }

    public java.lang.String toXmlString() {
        return _book.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _book.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Book getWrappedBook() {
        return _book;
    }

    public Book getWrappedModel() {
        return _book;
    }

    public void resetOriginalValues() {
        _book.resetOriginalValues();
    }
}
