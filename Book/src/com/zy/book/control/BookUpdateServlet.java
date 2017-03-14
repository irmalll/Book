package com.zy.book.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BookBiz;
import com.zy.book.entity.Book;

/**
 * Servlet implementation class BookUpdate
 */
public class BookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		
		BookBiz bBiz = new BookBiz();
		try {
			Book book = bBiz.searchOneBook(bid);
			if(book != null){
				request.setAttribute("book", book);
				request.getRequestDispatcher("adminPage/bookupdate.jsp").forward(request, response);
			}else{
				String msg = "��ѯʧ�ܣ�û���ҵ����Ϊ��" + bid + "��ͼ��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminPage/booklist.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ����ʽ
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		String bname = request.getParameter("bname");
		String bauthor = request.getParameter("bauthor");
		String bpress = request.getParameter("bpress");
		int bamount = Integer.parseInt(request.getParameter("bamount"));
		int binventory = Integer.parseInt(request.getParameter("binventory"));
		
		Book book = new Book(bid, bname, bauthor, bpress, bamount, binventory);
		
		BookBiz bBiz = new BookBiz();
		try {
			int state = bBiz.update(book);
			if(state > 0){
				PrintWriter pw = response.getWriter();
				pw.println("<script type='text/javascript'>alert('�޸ĳɹ�����ͨ�������鿴�޸ĺ��ͼ����Ϣ');window.location.href='adminPage/booksearch.jsp';</script>");
			}else{
				String msg = "�޸�ʧ�ܣ����Ժ�����";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminPage/bookupdate.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
