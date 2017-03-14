package com.zy.book.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zy.book.biz.UserBiz;
import com.zy.book.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		
		if(uname != null && !uname.equals("") && upwd != null && !upwd.equals("")){
			UserBiz uBiz = new UserBiz();
			try {
				User user = uBiz.login(uname, upwd);
				if(user != null){
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					if(user.getUrole().equals("0")){
						//��ͨ�û�
						request.getRequestDispatcher("userPage/uindex.html").forward(request, response);
					}else if(user.getUrole().equals("1")){
						//����Ա
						request.getRequestDispatcher("adminPage/aindex.html").forward(request, response);
					}
				}else{
					String msg = "��½ʧ�ܣ������û���������";
					request.setAttribute("msg", msg);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			String msg = "�û��������벻��Ϊ��";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
