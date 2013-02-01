/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.xtivia.training.servicebuilder.model.Book;
import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;
import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

/**
 *
 * @author rnila
 */
public class BookWorkFlowHander extends BaseWorkflowHandler {

    public String getClassName() {
         return CLASS_NAME;
    }

    public String getType(Locale locale) {
         return LanguageUtil.get(locale, "model.resource." + CLASS_NAME);
    }

    public Object updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException, SystemException {
         long userId = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

        long resourcePrimKey = GetterUtil.getLong(
            workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext =
            (ServiceContext) workflowContext.get("serviceContext");

        return BookLocalServiceUtil.updateStatus(
            userId, resourcePrimKey, status, serviceContext);
    }
    public static final String CLASS_NAME = Book.class.getName();
}
