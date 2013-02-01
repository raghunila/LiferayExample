package com.xtivia.training.servicebuilder.service.impl;

import com.liferay.portal.audit.hook.listeners.util.Attribute;
import com.liferay.portal.audit.hook.listeners.util.AttributesBuilder;
import com.liferay.portal.kernel.audit.AuditException;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRequestThreadLocal;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.xtivia.training.servicebuilder.NoSuchBookException;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.base.BookLocalServiceBaseImpl;
import com.xtivia.training.servicebuilder.service.persistence.BookUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.xtivia.training.servicebuilder.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.xtivia.training.servicebuilder.service.base.BookLocalServiceBaseImpl
 * @see com.xtivia.training.servicebuilder.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.xtivia.training.servicebuilder.service.BookLocalServiceUtil} to access the book local service.
     */

    public Book addBook(Book newBook, ServiceContext serviceContext) throws SystemException, PortalException {
        Book book = bookPersistence.create(counterLocalService.increment(Book.class.getName()));
        book.setAuthor(newBook.getAuthor());
        book.setCompanyId(newBook.getCompanyId());
        book.setGroupId(newBook.getGroupId());
        book.setIsbn(newBook.getIsbn());
        book.setName(newBook.getName());
        book.setSummary(newBook.getSummary());
        book.setUserId(newBook.getUserId());
        book.setStatus(WorkflowConstants.STATUS_DRAFT);
        book = bookPersistence.update(book, false);
        resourceLocalService.addResources(book.getCompanyId(), book.getGroupId(), book.getUserId(), Book.class.getName(), book.getPrimaryKey(), false, true, true);
        assetEntryLocalService.updateEntry(book.getUserId(), book.getGroupId(), Book.class.getName(), book.getId(), serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());
        WorkflowHandlerRegistryUtil.startWorkflowInstance(book.getCompanyId(), book.getGroupId(), book.getUserId(), Book.class.getName(), book.getPrimaryKey(), book, serviceContext);
        return book;
    }

    public Book editBook(Book newBook) throws SystemException {
        Book book = null;
        try {
            book = (Book) bookPersistence.findByPrimaryKey(newBook.getId());
        } catch (NoSuchBookException ex) {
            Logger.getLogger(BookLocalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        book.setAuthor(newBook.getAuthor());
        book.setCompanyId(newBook.getCompanyId());
        book.setGroupId(newBook.getGroupId());
        book.setIsbn(newBook.getIsbn());
        book.setName(newBook.getName());
        book.setSummary(newBook.getSummary());
        book.setUserId(newBook.getUserId());
        bookPersistence.update(book, true);
        updateAudit(book,newBook);
        return book;
    }

    public void updateAudit(Book oldBook, Book newBook) {
        List attributes = getModifiedAttributes(newBook, oldBook);
        Attribute att1 = new Attribute(Book.class.getName(), newBook.getName(), oldBook.getName());
        Attribute att2 = new Attribute(Book.class.getName(), newBook.getAuthor(), oldBook.getAuthor());
        Attribute att3 = new Attribute(Book.class.getName(), newBook.getIsbn() + "", oldBook.getIsbn() + "");
        Attribute att4 = new Attribute(Book.class.getName(), newBook.getSummary(), oldBook.getSummary());
        attributes.add(att1);
        attributes.add(att2);
        attributes.add(att3);
        attributes.add(att4);
        AuditMessage auditMessage = buildAuditMessage("Book Updated", Book.class.getName(), newBook.getId(),attributes);
        try {
            AuditRouterUtil.route(auditMessage);
        } catch (AuditException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(long id) throws SystemException, NoSuchBookException {
        Book book = bookPersistence.findByPrimaryKey(id);
        bookPersistence.remove(book);
    }

    public Book findByPrimaryKey(long id) throws SystemException{
        try {
            return BookUtil.findByPrimaryKey(id);
        } catch (NoSuchBookException ex) {
            Logger.getLogger(BookLocalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Book findByIsbn(long isbn) throws SystemException {
        return (Book) BookUtil.findByIsbn(isbn);
    }

    public Book updateStatus(
            long userId, long resourcePrimKey, int status,
            ServiceContext serviceContext)
            throws PortalException, SystemException {
        System.out.println(resourcePrimKey + "resourcePrimKey >>>>>>>>>>>>>>>>>>>>>>>>>");
        User user = userLocalService.getUser(userId);
        Book book = getBook(resourcePrimKey);
        System.out.println(status + " status of the book after approving it ");
        System.out.println(WorkflowConstants.STATUS_APPROVED + "   WorkflowConstants.STATUS_APPROVED");

        book.setStatus(status);
        book.setStatusByUserId(userId);
        book.setStatusByUserName(user.getFullName());
        book.setStatusDate(serviceContext.getModifiedDate());
        bookPersistence.update(book, true);

        if (status == WorkflowConstants.STATUS_APPROVED) {
            assetEntryLocalService.updateVisible(
                    Book.class.getName(), resourcePrimKey, true);
        } else {
            assetEntryLocalService.updateVisible(
                    Book.class.getName(), resourcePrimKey, false);
        }
        // Indexer
        /*Indexer indexer = IndexerRegistryUtil.getIndexer(Book.class);
         indexer.reindex(book);*/
        return book;
    }

    public Book getNewBook() throws SystemException {
        return bookPersistence.create(counterLocalService.increment(Book.class.getName()));

    }

    public List<Book> findBooks() {
        try {
            return bookPersistence.findAll();
        } catch (SystemException ex) {
            Logger.getLogger(BookLocalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Book getBook(long id) throws SystemException, NoSuchBookException {
        return bookPersistence.findByPrimaryKey(id);
    }
    public   AuditMessage buildAuditMessage(String eventType, String className, long classPK,
            List<com.liferay.portal.audit.hook.listeners.util.Attribute> attributes) {
        long companyId = CompanyThreadLocal.getCompanyId();
        long userId = 0;
        if (PrincipalThreadLocal.getName() != null) {
            userId = GetterUtil.getLong(PrincipalThreadLocal.getName());
        }
        AuditRequestThreadLocal auditRequestThreadLocal = AuditRequestThreadLocal.getAuditThreadLocal();
        long realUserId = auditRequestThreadLocal.getRealUserId();
        String realUserName = PortalUtil.getUserName(realUserId, StringPool.BLANK);
        JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();
        if ((realUserId > 0) && (userId != realUserId)) {
            additionalInfo.put("doAsUserId", String.valueOf(userId));
            additionalInfo.put("doAsUserName", PortalUtil.getUserName(userId, StringPool.BLANK));
        }
        if (attributes != null) {
            additionalInfo.put("attributes", _getAttributesJSON(attributes));
        }
        return new AuditMessage(eventType, companyId, realUserId, realUserName, className,
                String.valueOf(classPK), null, additionalInfo);
    }
    private   JSONArray _getAttributesJSON(List<Attribute> attributes) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
        for (Attribute attribute : attributes) {
            JSONObject attributeJSONObject = JSONFactoryUtil.createJSONObject();
            attributeJSONObject.put("name", attribute.getName());
            attributeJSONObject.put("newValue", attribute.getNewValue());
            attributeJSONObject.put("oldValue", attribute.getOldValue());
            jsonArray.put(attributeJSONObject);
        }
        return jsonArray;
    }
    private   List<Attribute> getModifiedAttributes(Book newBook, Book oldBook) {
		AttributesBuilder attributesBuilder = new AttributesBuilder(newBook,
				oldBook);
		attributesBuilder.add("name");
		attributesBuilder.add("author");
		attributesBuilder.add("isbn");
		attributesBuilder.add("summary");
		return attributesBuilder.getAttributes();
	}
}
