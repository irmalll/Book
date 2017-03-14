package com.zy.book.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zy.book.entity.Book;
import com.zy.book.entity.Borrow;
import com.zy.book.entity.User;


public class BorrowDao extends BaseDao{
	//添加借阅信息
	public int addBorrow(Borrow borrow) throws Exception{
		int state = 0;
		
		String sql = "insert into tborrow(id,bid,borrcount,borrtime,borrstate) values(?,?,?,?,0)";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, borrow.getUser().getId());
		ps.setInt(2, borrow.getBook().getBid());
		ps.setInt(3, borrow.getBorrcount());
		ps.setDate(4, new Date(borrow.getBorrtime().getTime()));
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	//根据管理员输入的条件，查询借阅信息
	public List<Borrow> searchBorrows(Borrow borrow) throws Exception{
		List<Borrow> borrowList = new ArrayList<Borrow>();
		
		String sql = "select * from tborrow where 1=1";
		if(borrow.getBorrid() != 0){
			sql = sql + " and borrid like '%" + borrow.getBorrid() + "%'";
		}
		if(borrow.getUser() != null && borrow.getUser().getId() != 0){
			sql = sql + " and id like '%" + borrow.getUser().getId() + "%'";
		}
		if(borrow.getBook() != null && borrow.getBook().getBid() != 0){
			sql = sql + " and bid like '%" + borrow.getBook().getBid()+ "%'";
		}
		if(borrow.getBorrstate() != null && !borrow.getBorrstate().equals("")){
			sql = sql + " and borrstate =" + borrow.getBorrstate();
		}
		
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Borrow borrow1 = new Borrow();
			borrow1.setBorrid(rs.getInt("borrid"));
			User user = new User();
			user.setId(rs.getInt("id"));
			borrow1.setUser(user);
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			borrow1.setBook(book);
			borrow1.setBorrcount(rs.getInt("borrcount"));
			borrow1.setBorrtime(rs.getDate("borrtime"));
			borrow1.setReturntime(rs.getDate("returntime"));
			borrow1.setBorrstate(rs.getString("borrstate"));
			
			borrowList.add(borrow1);
		}
		
		return borrowList;
	}
	
	//根据用户输入的条件，查询该用户的借阅信息
	public List<Borrow> searchUserBorrows(Borrow borrow) throws Exception{
		List<Borrow> borrowList = new ArrayList<Borrow>();
		
		String sql = "select * from tborrow where id="+borrow.getUser().getId();
		if(borrow.getBorrid() != 0){
			sql = sql + " and borrid like '%" + borrow.getBorrid() + "%'";
		}
		if(borrow.getBook() != null && borrow.getBook().getBid() != 0){
			sql = sql + " and bid like '%" + borrow.getBook().getBid()+ "%'";
		}
		if(borrow.getBorrstate() != null && !borrow.getBorrstate().equals("")){
			sql = sql + " and borrstate =" + borrow.getBorrstate();
		}
		
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Borrow borrow1 = new Borrow();
			borrow1.setBorrid(rs.getInt("borrid"));
			User user = new User();
			user.setId(rs.getInt("id"));
			borrow1.setUser(user);
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			borrow1.setBook(book);
			borrow1.setBorrcount(rs.getInt("borrcount"));
			borrow1.setBorrtime(rs.getDate("borrtime"));
			borrow1.setReturntime(rs.getDate("returntime"));
			borrow1.setBorrstate(rs.getString("borrstate"));
			
			borrowList.add(borrow1);
		}
		
		return borrowList;
	}
	
	//修改借阅信息: 修改前，需要先根据从页面获取来的借阅编号查询该借阅信息
	//查询指定借阅信息
	public Borrow searchOneBorrow(int borrid) throws Exception{
		Borrow borrow = null;
		
		String sql = "select * from tborrow where borrid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, borrid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			borrow = new Borrow();
			borrow.setBorrid(rs.getInt("borrid"));
			User user = new User();
			user.setId(rs.getInt("id"));
			borrow.setUser(user);
			Book book = new Book();
			book.setBid(rs.getInt("bid"));
			borrow.setBook(book);
			borrow.setBorrcount(rs.getInt("borrcount"));
			borrow.setBorrtime(rs.getDate("borrtime"));
			borrow.setReturntime(rs.getDate("returntime"));
			borrow.setBorrstate(rs.getString("borrstate"));
		}
		
		return borrow;
	}
	//修改指定借阅信息
	public int update(Borrow borrow) throws Exception{
		int state = 0;
		
		String sql = "update tborrow set id=?,bid=?,borrcount=?,borrtime=?";
		if(borrow.getReturntime() != null && !borrow.getReturntime().equals("")){
			sql = sql + ",returntime='" + new Date(borrow.getReturntime().getTime()) + "'";
		}else{
			sql = sql + ",returntime=null";
		}
		sql = sql + " where borrid=" + borrow.getBorrid();
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, borrow.getUser().getId());
		ps.setInt(2, borrow.getBook().getBid());
		ps.setInt(3, borrow.getBorrcount());
		ps.setDate(4, new Date(borrow.getBorrtime().getTime()));
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	//归还图书
	public int returnBook(int borrid) throws Exception{
		int state = 0;
		
		String sql = "update tborrow set returntime=?,borrstate=1 where borrid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setDate(1, new Date(new java.util.Date().getTime()));
		ps.setInt(2, borrid);
		
		state = ps.executeUpdate();
		
		return state;
	}
}
