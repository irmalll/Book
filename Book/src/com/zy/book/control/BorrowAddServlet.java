package com.zy.book.control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BorrowBiz;
import com.zy.book.entity.Book;
import com.zy.book.entity.Borrow;
import com.zy.book.entity.User;

/**
 * Servlet implementation class BorrowAddServlet
 */
public class BorrowAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BorrowAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String msg = null;

		int id = Integer.parseInt(request.getParameter("uid"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		int borrcount = Integer.parseInt(request.getParameter("borrcount"));
		String btime = request.getParameter("borrtime");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		try {
			Date borrtime = sdf.parse(btime);
			User user = new User();
			user.setId(id);
			;
			Book book = new Book();
			book.setBid(bid);
			Borrow borrow = new Borrow(user, book, borrcount, borrtime);

			BorrowBiz borrBiz = new BorrowBiz();
			int state = borrBiz.addBorrow(borrow);
			if (state > 0) {
				msg = "成功添加" + state + "条借阅记录";
			} else {
				msg = "借阅记录添加失败";
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("adminPage/borrowadd.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
