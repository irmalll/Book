package com.zy.book.biz;

import com.zy.book.dao.UserDao;
import com.zy.book.entity.User;

public class UserBiz {
	//�û���¼
	public User login(String uname, String upwd) throws Exception{
		User user = null;
		UserDao uDao = new UserDao();
		try {
			user = uDao.login(uname, upwd);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر����ݿ�
			uDao.closeConnection();
		}
		
		return user;
	}
	
	//�û�ע��
	public int register(User user) throws Exception{
		int state = 0;
		UserDao uDao = new UserDao();
		try {
			state = uDao.register(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			uDao.closeConnection();
		}
		
		return state;
	}
	
	//�޸�����
	public int changePwd(int uid, String upwd) throws Exception{
		int state = 0;
		
		UserDao uDao = new UserDao();
		try {
			state = uDao.changePwd(uid, upwd);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			uDao.closeConnection();
		}
	
		return state;
	}
}
