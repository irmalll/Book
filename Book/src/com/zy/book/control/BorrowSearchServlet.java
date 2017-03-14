package com.zy.book.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BorrowBiz;
import com.zy.book.entity.Book;
import com.zy.book.entity.Borrow;
import com.zy.book.entity.User;

/**
 * Servlet implementation class BorrowSearchServlet
 */
public class BorrowSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 用户查询本人的借阅记录
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String borrowsearch = request.getParameter("borrowsearch");
		String borrowcontent = request.getParameter("borrowcontent");
		
		Borrow borrow = new Borrow();
		User user = new User();
		user.setId(id);
		borrow.setUser(user);
		
		if(borrowsearch.equals("borrid")){
			if(borrowcontent != null && !borrowcontent.equals("")){
				borrow.setBorrid(Integer.parseInt(borrowcontent));
			}
		}else if(borrowsearch.equals("bid")){
			if(borrowcontent != null && !borrowcontent.equals("")){
				Book book = new Book();
				book.setBid(Integer.parseInt(borrowcontent));
				borrow.setBook(book);
			}
		}else if(borrowsearch.equals("borrstate")){
			borrow.setBorrstate(borrowcontent);
		}
		
		BorrowBiz borrBiz = new BorrowBiz();
		try {
			List<Borrow> borrowList = borrBiz.searchUserBorrows(borrow);
			if(borrowList.size() > 0){
				request.setAttribute("borrowList", borrowList);
				request.getRequestDispatcher("userPage/borrowlist.jsp").forward(request, response);
			}else{
				String msg = "查询失败，没有符合条件的借阅信息";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("userPage/borrowsearch.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 管理员查询所有人的符合条件的借阅记录
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String borrowsearch = request.getParameter("borrowsearch");
		String borrowcontent = request.getParameter("borrowcontent");
		
		Borrow borrow = new Borrow();
		
		if(borrowsearch.equals("borrid")){
			if(borrowcontent != null && !borrowcontent.equals("")){
				borrow.setBorrid(Integer.parseInt(borrowcontent));
			}
		}else if(borrowsearch.equals("id")){
			if(borrowcontent != null && !borrowcontent.equals("")){
				User user = new User();
				user.setId(Integer.parseInt(borrowcontent));
				borrow.setUser(user);
			}
		}else if(borrowsearch.equals("bid")){
			if(borrowcontent != null && !borrowcontent.equals("")){
				Book book = new Book();
				book.setBid(Integer.parseInt(borrowcontent));
				borrow.setBook(book);
			}
		}else if(borrowsearch.equals("borrstate")){
			borrow.setBorrstate(borrowcontent);
		}
		
		BorrowBiz borrBiz = new BorrowBiz();
		try {
			List<Borrow> borrowList = borrBiz.searchBorrows(borrow);
			if(borrowList.size() > 0){
				request.setAttribute("borrowList", borrowList);
				request.getRequestDispatcher("adminPage/borrowlist.jsp").forward(request, response);
			}else{
				String msg = "查询失败，没有符合条件的借阅信息";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("adminPage/borrowsearch.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
