package com.zy.book.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BookBiz;
import com.zy.book.entity.Book;

/**
 * Servlet implementation class BookAddServlet
 */
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAddServlet() {
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
		String msg = null;
		
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bpress = request.getParameter("bpress");
		int bamount = Integer.parseInt(request.getParameter("bamount"));
		int binventory = Integer.parseInt(request.getParameter("binventory"));
		
		Book book = new Book(bname, bauthor, bpress, bamount, binventory);
		
		BookBiz bBiz = new BookBiz();
		try {
			int state = bBiz.addBook(book);
			
			if(state > 0){
				msg = "成功添加图书:" + bname;
			}else{
				msg = "添加失败";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("adminPage/bookadd.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
