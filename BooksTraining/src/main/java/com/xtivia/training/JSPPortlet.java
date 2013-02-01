/**
 *
 * @author rnila
 */
package com.xtivia.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;

import com.liferay.portal.kernel.util.ParamUtil;

public class JSPPortlet extends GenericPortlet {

	/**
	 * this fires to create the view
	 */
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		//include("view.jsp", request, response);
		System.out.println("In doView code");
		response.setContentType(request.getResponseContentType());
		// file to display...
		String url = "/books/view.jsp";
		// read the above file and output it...
		getPortletContext().getRequestDispatcher(url).include(request, response);
	}
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		System.out.println("In serveResource code");
		response.setContentType("text/html");
		String message = request.getParameter("message");
		// this seems to be the page that was calling...?
		String resourceID = request.getResourceID();
		System.out.println("resourceId was : " + resourceID);
		System.out.println("message was : " + message);
		PrintWriter writer = response.getWriter();
		writer.print(message);
	}
}