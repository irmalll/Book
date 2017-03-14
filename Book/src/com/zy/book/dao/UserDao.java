package com.zy.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.zy.book.entity.User;

public class UserDao extends BaseDao{
	//�û���¼
	public User login(String uname, String upwd) throws Exception{
		User user = null;
		
		String sql = "select * from tuser where uname=? and upwd=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, uname);
		ps.setString(2, upwd);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt("id"));
			user.setUname(rs.getString("uname"));
			user.setUpwd(rs.getString("upwd"));
			user.setUrole(rs.getString("urole"));
		}
		
		return user;
	}
	
	//�û�ע��
	public int register(User user) throws Exception{
		int state = 0;
		
		String sql = "insert into tuser values(?,?,?,?)";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, user.getId());
		ps.setString(2, user.getUname());
		ps.setString(3, user.getUpwd());
		ps.setString(4, user.getUrole());
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	//�޸�����
	public int changePwd(int id, String upwd) throws Exception{
		int state = 0;
		
		String sql = "update tuser set upwd=? where id=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, upwd);
		ps.setInt(2, id);
		state = ps.executeUpdate();
		
		return state;
	}
}
