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
import com.zy.book.entity.Book;
import com.zy.book.entity.Borrow;
import com.zy.book.entity.User;

/**
 * Servlet implementation class BorrowUpdateServlet
 */
public class BorrowUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowUpdateServlet() {
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
			request.setAttribute("borrow", borrow);
			request.getRequestDispatcher("adminPage/borrowdataup.jsp").forward(request, response);
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
		
		String borrid = request.getParameter("borrid");
		String id = request.getParameter("id");
		String bid = request.getParameter("bid");
		String borrcount = request.getParameter("borrcount");
		String btime = request.getParameter("borrtime");
		String rtime = request.getParameter("returntime");
		
		if(borrid != null && !borrid.equals("") && id != null && !id.equals("") && bid != null && !bid.equals("") && borrcount != null && !borrcount.equals("") && btime != null && !btime.equals("")){
			User user = new User();
			user.setId(Integer.parseInt(id));
			Book book = new Book();
			book.setBid(Integer.parseInt(bid));
			
			Borrow borrow = new Borrow();
			borrow.setBorrid(Integer.parseInt(borrid));
			borrow.setUser(user);
			borrow.setBook(book);
			borrow.setBorrcount(Integer.parseInt(borrcount));
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date borrtime = sdf.parse(btime);
				borrow.setBorrtime(borrtime);
				if(rtime != null && !rtime.equals("")){
					Date returntime = sdf.parse(rtime);
					borrow.setReturntime(returntime);
				}
				
				BorrowBiz borrBiz = new BorrowBiz();
				int state = borrBiz.update(borrow);
				if(state > 0){
					PrintWriter pw = response.getWriter();
					pw.println("<script type='text/javascript'>alert('修改成功，可通过搜索查看修改后的借阅信息');window.location.href='adminPage/borrowsearch.jsp';</script>");
				}else{
					String msg = "修改失败，请稍后再试";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("adminPage/borrowdataup.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
