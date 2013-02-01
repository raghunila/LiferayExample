package com.xtivia.training.servicebuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.xtivia.training.servicebuilder.model.Book;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Book
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Serializable {
    public String uuid;
    public long id;
    public String name;
    public long isbn;
    public String author;
    public String summary;
    public int status;
    public long statusByUserId;
    public String statusByUserName;
    public long statusDate;
    public long companyId;
    public long groupId;
    public long userId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", id=");
        sb.append(id);
        sb.append(", name=");
        sb.append(name);
        sb.append(", isbn=");
        sb.append(isbn);
        sb.append(", author=");
        sb.append(author);
        sb.append(", summary=");
        sb.append(summary);
        sb.append(", status=");
        sb.append(status);
        sb.append(", statusByUserId=");
        sb.append(statusByUserId);
        sb.append(", statusByUserName=");
        sb.append(statusByUserName);
        sb.append(", statusDate=");
        sb.append(statusDate);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append("}");

        return sb.toString();
    }

    public Book toEntityModel() {
        BookImpl bookImpl = new BookImpl();

        if (uuid == null) {
            bookImpl.setUuid(StringPool.BLANK);
        } else {
            bookImpl.setUuid(uuid);
        }

        bookImpl.setId(id);

        if (name == null) {
            bookImpl.setName(StringPool.BLANK);
        } else {
            bookImpl.setName(name);
        }

        bookImpl.setIsbn(isbn);

        if (author == null) {
            bookImpl.setAuthor(StringPool.BLANK);
        } else {
            bookImpl.setAuthor(author);
        }

        if (summary == null) {
            bookImpl.setSummary(StringPool.BLANK);
        } else {
            bookImpl.setSummary(summary);
        }

        bookImpl.setStatus(status);
        bookImpl.setStatusByUserId(statusByUserId);

        if (statusByUserName == null) {
            bookImpl.setStatusByUserName(StringPool.BLANK);
        } else {
            bookImpl.setStatusByUserName(statusByUserName);
        }

        if (statusDate == Long.MIN_VALUE) {
            bookImpl.setStatusDate(null);
        } else {
            bookImpl.setStatusDate(new Date(statusDate));
        }

        bookImpl.setCompanyId(companyId);
        bookImpl.setGroupId(groupId);
        bookImpl.setUserId(userId);

        bookImpl.resetOriginalValues();

        return bookImpl;
    }
}
