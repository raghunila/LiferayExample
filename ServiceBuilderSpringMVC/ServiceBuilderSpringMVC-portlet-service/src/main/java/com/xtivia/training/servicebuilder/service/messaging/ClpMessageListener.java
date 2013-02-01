package com.xtivia.training.servicebuilder.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.xtivia.training.servicebuilder.service.BookLocalServiceUtil;
import com.xtivia.training.servicebuilder.service.BookServiceUtil;
import com.xtivia.training.servicebuilder.service.ClpSerializer;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            BookLocalServiceUtil.clearService();

            BookServiceUtil.clearService();
        }
    }
}
