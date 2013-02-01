package com.xtivia.training.servicebuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.xtivia.training.servicebuilder.model.Book;

import java.io.Serializable;

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

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

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

        bookImpl.resetOriginalValues();

        return bookImpl;
    }
}
