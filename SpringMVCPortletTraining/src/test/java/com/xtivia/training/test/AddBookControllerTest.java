package com.xtivia.training.test;

import com.xtivia.training.AddBookController;
import com.xtivia.training.dao.BookServiceDAO;
import com.xtivia.training.data.Book;
import javax.portlet.RenderResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.portlet.MockActionResponse;
import org.springframework.mock.web.portlet.MockRenderResponse;
import org.springframework.validation.BindException;
import org.springframework.web.bind.support.SimpleSessionStatus;

public class AddBookControllerTest {
	private AddBookController addBookController;
	private BookServiceDAO bookServiceDAO = new MockBookService();

	@Before
	public void setUp() {
		addBookController = new AddBookController();
		addBookController.setBookServiceDAO(bookServiceDAO);
	}

	@Test
	public void testShowAddBookForm() {
		RenderResponse response = new MockRenderResponse();
		assertEquals("addBook", addBookController.addBookForm(response));
	}

	@Test
	public void testAddBook() {
		Book book = new Book("test book", "test author", 1234567890L," this is test");
		MockActionResponse response = new MockActionResponse();
		addBookController.addBook(book, new BindException(book, "book"),
				response, new SimpleSessionStatus());
		assertNotNull(bookServiceDAO.getBook(1234567890L));
		assertEquals("books", response.getRenderParameter("myAction"));
	}
}