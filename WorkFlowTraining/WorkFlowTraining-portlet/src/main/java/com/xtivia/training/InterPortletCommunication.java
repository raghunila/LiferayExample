/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xtivia.training;

import com.xtivia.training.data.BookAddedEvent;
import java.io.IOException;
import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
/**
 *
 * @author rnila
 */
public class InterPortletCommunication extends GenericPortlet {


    @RenderMode(name = "view")
    public void showLatestBook(RenderRequest request, RenderResponse response)
            throws IOException, PortletException {
        getPortletContext().getRequestDispatcher(
                response.encodeURL("/WEB-INF/jsp/interportlet.jsp")).include(request, response);
    }

    @ProcessEvent(qname = "{http://www.xtivia.com}bookAddedEvent")
    public void processAddedBookEvent(EventRequest request, EventResponse eventResponse)
            throws IOException, PortletException {
        Event event = request.getEvent();
        BookAddedEvent bookAddedEvent = (BookAddedEvent) event.getValue();
        eventResponse.setRenderParameter("summary", bookAddedEvent.getSummary());
        eventResponse.setRenderParameter("name", bookAddedEvent.getName());
        eventResponse.setRenderParameter("author", bookAddedEvent.getAuthor());
        eventResponse.setRenderParameter("isbn", String.valueOf(bookAddedEvent.getisbn()));
    }
}
/*
@Controller(value="interPortletCommunication")
@RequestMapping(value="VIEW")
public class InterPortletCommunication{

    private Logger logger = Logger.getLogger(InterPortletCommunication.class);

    @RenderMapping
    public String showBooks(RenderResponse response) {
        logger.info("Entering showLatestBook render method");
        return "interportlet";
    }
    @ProcessEvent(qname = "{http://www.xtivia.com}bookAddedEvent")
    @ModelAttribute(value = "book")
    public BookAddedEvent processAddedBookEvent(EventRequest request, EventResponse eventResponse)
            throws IOException, PortletException {
        logger.info("Processing bookAddedEvent.....");
        Event event = request.getEvent();
        return (BookAddedEvent) event.getValue();
    }
}*/

