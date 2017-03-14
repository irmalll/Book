package com.zy.book.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zy.book.biz.UserBiz;
import com.zy.book.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		//���ñ����ʽ
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		
		//��ע��ҳ���ȡ�û��������Ϣ
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String urole = request.getParameter("urole");
		
		//����ȡ������Ϣ��ӵ�user������
		User user = new User(uname, upwd, urole);
		
		UserBiz uBiz = new UserBiz();
		try {
			//����ע�᷽��
			int state = uBiz.register(user);
			if(state > 0){
				PrintWriter pw = response.getWriter();
				pw.println("<script type='text/javascript'>alert('ע��ɹ������½ϵͳ');window.location.href='login.jsp';</script>");
			}else{
				String msg = "ע��ʧ��";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
