/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training.config;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 *
 * @author rnila
 */
public class ConfigurationActionImpl implements ConfigurationAction {

    public void processAction(PortletConfig pc, ActionRequest ar, ActionResponse ar1) throws Exception {
        String cmd = ParamUtil.getString(ar, Constants.CMD);

        if (!cmd.equals(Constants.UPDATE)) {
            return;
        }
        boolean book_name = ParamUtil.getBoolean(ar, "book_name");
        boolean book_author = ParamUtil.getBoolean(ar, "book_author");
        boolean book_isbn = ParamUtil.getBoolean(ar, "book_isbn");
        boolean book_summary = ParamUtil.getBoolean(ar, "book_summary");
        
        String portletResource = ParamUtil.getString(ar, "portletResource");
        PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(ar, portletResource);
        
        prefs.setValue("book_name", String.valueOf(book_name));
        prefs.setValue("book_author", String.valueOf(book_author));
        prefs.setValue("book_isbn", String.valueOf(book_isbn));
        prefs.setValue("book_summary", String.valueOf(book_summary));
        prefs.store();
        PortletSession portletSession = ar.getPortletSession();
        SessionMessages.add(ar, pc.getPortletName() + ".doConfigure");

    }

    public String render(PortletConfig pc, RenderRequest rr, RenderResponse rr1) throws Exception {
        return "/configuration.jsp";
    }
}
