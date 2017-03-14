package com.zy.book.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.BorrowBiz;
import com.zy.book.entity.Borrow;

/**
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int borrid = Integer.parseInt(request.getParameter("borrid"));
		BorrowBiz borrBiz = new BorrowBiz();
		try {
			Borrow borrow = borrBiz.searchOneBorrow(borrid);
			if(borrow != null){
				request.setAttribute("borrow", borrow);
				request.getRequestDispatcher("adminPage/returnbook.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码格式
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		
		String borid = request.getParameter("borrid");
		
		if(borid != null && !borid.equals("")){
				int borrid = Integer.parseInt(borid);
				BorrowBiz borrBiz = new BorrowBiz();
			try{
				int state = borrBiz.returnBook(borrid);
				if(state > 0){
					PrintWriter pw = response.getWriter();
					pw.println("<script type='text/javascript'>alert('归还图书成功，可通过搜索借阅编号 " + borrid + " 确认');window.location.href='adminPage/borrowsearch.jsp';</script>");
				}else{
					String msg = "归还图书失败，请稍后再试";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("adminPage/returnbook.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
