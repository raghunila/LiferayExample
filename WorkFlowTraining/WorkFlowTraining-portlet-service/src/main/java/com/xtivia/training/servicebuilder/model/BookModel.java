package com.xtivia.training.servicebuilder.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.WorkflowedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Book service. Represents a row in the &quot;BookFlow_Book&quot; database table, with each column mapped to a property of this class.
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
public interface BookModel extends BaseModel<Book>, WorkflowedModel {
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

    /**
     * Returns the status of this book.
     *
     * @return the status of this book
     */
    public int getStatus();

    /**
     * Sets the status of this book.
     *
     * @param status the status of this book
     */
    public void setStatus(int status);

    /**
     * Returns the status by user ID of this book.
     *
     * @return the status by user ID of this book
     */
    public long getStatusByUserId();

    /**
     * Sets the status by user ID of this book.
     *
     * @param statusByUserId the status by user ID of this book
     */
    public void setStatusByUserId(long statusByUserId);

    /**
     * Returns the status by user uuid of this book.
     *
     * @return the status by user uuid of this book
     * @throws SystemException if a system exception occurred
     */
    public String getStatusByUserUuid() throws SystemException;

    /**
     * Sets the status by user uuid of this book.
     *
     * @param statusByUserUuid the status by user uuid of this book
     */
    public void setStatusByUserUuid(String statusByUserUuid);

    /**
     * Returns the status by user name of this book.
     *
     * @return the status by user name of this book
     */
    @AutoEscape
    public String getStatusByUserName();

    /**
     * Sets the status by user name of this book.
     *
     * @param statusByUserName the status by user name of this book
     */
    public void setStatusByUserName(String statusByUserName);

    /**
     * Returns the status date of this book.
     *
     * @return the status date of this book
     */
    public Date getStatusDate();

    /**
     * Sets the status date of this book.
     *
     * @param statusDate the status date of this book
     */
    public void setStatusDate(Date statusDate);

    /**
     * Returns the company ID of this book.
     *
     * @return the company ID of this book
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this book.
     *
     * @param companyId the company ID of this book
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the group ID of this book.
     *
     * @return the group ID of this book
     */
    public long getGroupId();

    /**
     * Sets the group ID of this book.
     *
     * @param groupId the group ID of this book
     */
    public void setGroupId(long groupId);

    /**
     * Returns the user ID of this book.
     *
     * @return the user ID of this book
     */
    public long getUserId();

    /**
     * Sets the user ID of this book.
     *
     * @param userId the user ID of this book
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this book.
     *
     * @return the user uuid of this book
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this book.
     *
     * @param userUuid the user uuid of this book
     */
    public void setUserUuid(String userUuid);

    /**
     * @deprecated Renamed to {@link #isApproved()}
     */
    public boolean getApproved();

    /**
     * Returns <code>true</code> if this book is approved.
     *
     * @return <code>true</code> if this book is approved; <code>false</code> otherwise
     */
    public boolean isApproved();

    /**
     * Returns <code>true</code> if this book is a draft.
     *
     * @return <code>true</code> if this book is a draft; <code>false</code> otherwise
     */
    public boolean isDraft();

    /**
     * Returns <code>true</code> if this book is expired.
     *
     * @return <code>true</code> if this book is expired; <code>false</code> otherwise
     */
    public boolean isExpired();

    /**
     * Returns <code>true</code> if this book is pending.
     *
     * @return <code>true</code> if this book is pending; <code>false</code> otherwise
     */
    public boolean isPending();

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
