package com.xtivia.training.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Book service. Represents a row in the &quot;Book_Book&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.xtivia.training.servicebuilder.model.impl.BookModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.xtivia.training.servicebuilder.model.impl.BookImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @see com.xtivia.training.servicebuilder.model.impl.BookImpl
 * @see com.xtivia.training.servicebuilder.model.impl.BookModelImpl
 * @generated
 */
public interface BookModel extends BaseModel<Book> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a book model instance should use the {@link Book} interface instead.
     */

    /**
     * Returns the primary key of this book.
     *
     * @return the primary key of this book
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this book.
     *
     * @param primaryKey the primary key of this book
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the uuid of this book.
     *
     * @return the uuid of this book
     */
    @AutoEscape
    public String getUuid();

    /**
     * Sets the uuid of this book.
     *
     * @param uuid the uuid of this book
     */
    public void setUuid(String uuid);

    /**
     * Returns the ID of this book.
     *
     * @return the ID of this book
     */
    public long getId();

    /**
     * Sets the ID of this book.
     *
     * @param id the ID of this book
     */
    public void setId(long id);

    /**
     * Returns the name of this book.
     *
     * @return the name of this book
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this book.
     *
     * @param name the name of this book
     */
    public void setName(String name);

    /**
     * Returns the isbn of this book.
     *
     * @return the isbn of this book
     */
    public long getIsbn();

    /**
     * Sets the isbn of this book.
     *
     * @param isbn the isbn of this book
     */
    public void setIsbn(long isbn);

    /**
     * Returns the author of this book.
     *
     * @return the author of this book
     */
    @AutoEscape
    public String getAuthor();

    /**
     * Sets the author of this book.
     *
     * @param author the author of this book
     */
    public void setAuthor(String author);

    /**
     * Returns the summary of this book.
     *
     * @return the summary of this book
     */
    @AutoEscape
    public String getSummary();

    /**
     * Sets the summary of this book.
     *
     * @param summary the summary of this book
     */
    public void setSummary(String summary);

    public boolean isNew();

    public void setNew(boolean n);

    public boolean isCachedModel();

    public void setCachedModel(boolean cachedModel);

    public boolean isEscapedModel();

    public Serializable getPrimaryKeyObj();

    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    public ExpandoBridge getExpandoBridge();

    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    public Object clone();

    public int compareTo(Book book);

    public int hashCode();

    public CacheModel<Book> toCacheModel();

    public Book toEscapedModel();

    public String toString();

    public String toXmlString();
}