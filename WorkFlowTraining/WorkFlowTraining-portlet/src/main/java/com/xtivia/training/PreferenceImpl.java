/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.RenderResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 *
 * @author rnila
 */
@Controller(value="preferenceImpl")
@RequestMapping(value="EDIT")
public class PreferenceImpl {
    @RenderMapping
    public String showBooks(RenderResponse response) {
        return "edit";
    }
    @ExceptionHandler({Exception.class})
    public String handleException() {
        return "errorPage";
    }
    @ActionMapping(value="welcomePage")
    public void showWelcomePage (@RequestParam String message, ActionRequest actionRequest, ActionResponse actionResponse,SessionStatus sessionStatus) throws PortletModeException
    {
        
        actionRequest.setAttribute("message", message);
        actionResponse.setPortletMode(PortletMode.VIEW);
        actionResponse.setRenderParameter("myAction", "viewBooks");
        sessionStatus.setComplete();
    }
}
