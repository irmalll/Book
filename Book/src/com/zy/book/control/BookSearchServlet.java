package com.zy.book.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BookBiz;
import com.zy.book.entity.Book;

/**
 * Servlet implementation class BookSelectServlet
 */
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String booksearch = request.getParameter("booksearch");
		String content = request.getParameter("content");
		
		Book book = new Book();
		if(content != null && !content.equals("")){
			if(booksearch.equals("bid")){
				book.setBid(Integer.parseInt(content));
			}else if(booksearch.equals("bname")){
				book.setBname(content);
			}else if(booksearch.equals("bauthor")){
				book.setBauthor(content);
			}
		}
		
		BookBiz bBiz = new BookBiz();
		try {
			List<Book> bookList = bBiz.searchBooks(book);
			if(bookList.size() > 0){
				request.setAttribute("bookList", bookList);
				request.getRequestDispatcher("adminPage/booklist.jsp").forward(request, response);
			}else{
				String msg = "查询失败，没有符合条件的图书";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminPage/booksearch.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
