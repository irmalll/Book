package com.zy.book.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zy.book.entity.Book;

public class BookDao extends BaseDao{
	//���ͼ��
	public int addBook(Book book) throws Exception{
		int state = 0;
		
		String sql = "insert into tbook values(?,?,?,?,?,?,0)";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, book.getBid());
		ps.setString(2, book.getBname());
		ps.setString(3, book.getBauthor());
		ps.setString(4, book.getBpress());
		ps.setInt(5, book.getBamount());
		ps.setInt(6, book.getBinventory());
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	//ɾ��ͼ����Ϣ: ɾ��֮ǰ�����жϽ��ı����Ƿ�ʹ���˸�ͼ�����Ϣ�����У����޸�ͼ��״̬����Ϊ�����ã���û�У���ֱ��ɾ��ͼ�顣
	//1������ָ����ͼ���ţ���ѯ���ļ�¼
	public boolean selectAssignBorrow(int bid) throws Exception{
		boolean result = false;
		
		String sql = "select * from tborrow where bid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bid);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			result = true;
		}
		
		return result;
	}
	//2���޸�ͼ��״̬:��Ϊ������
		public int updateBookState(int bid) throws Exception{
			int state = 0;
			String sql = "update tbook set bstate=1 where bid=?";
			this.openConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			state = ps.executeUpdate();
			
			return state;
		}
	//3��ֱ��ɾ��ͼ��
	public int deleteBook(int bid) throws Exception{
		int state = 0;
		String sql = "delete from tbook where bid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bid);
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	
	//�޸�ͼ����Ϣ: �޸�ǰ����Ҫ�ȸ��ݴ�ҳ���ȡ����ͼ���Ų�ѯ��ͼ����Ϣ
	//��ѯָ��ͼ����Ϣ
	public Book searchOneBook(int bid) throws Exception{
		Book book = null;
		
		String sql = "select * from tbook where bid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, bid);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			book = new Book();
			book.setBid(rs.getInt("bid"));
			book.setBname(rs.getString("bname"));
			book.setBauthor(rs.getString("bauthor"));
			book.setBpress(rs.getString("bpress"));
			book.setBamount(rs.getInt("bamount"));
			book.setBinventory(rs.getInt("binventory"));
			book.setBstate(rs.getString("bstate"));
		}
		
		return book;
	}
	//�޸�ָ��ͼ����Ϣ
	public int update(Book book) throws Exception{
		int state = 0;
		
		String sql = "update tbook set bname=?,bauthor=?,bpress=?,bamount=?,binventory=? where bid=?";
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, book.getBname());
		ps.setString(2, book.getBauthor());
		ps.setString(3, book.getBpress());
		ps.setInt(4, book.getBamount());
		ps.setInt(5, book.getBinventory());
		ps.setInt(6, book.getBid());
		
		state = ps.executeUpdate();
		
		return state;
	}
	
	//��ѯ����ͼ��
	public List<Book> searchBooks(Book book) throws Exception{
		List<Book> bookList = new ArrayList<Book>();
		
		String sql = "select * from tbook where bstate = 0";
		if(book.getBid() != 0){
			sql = sql + " and bid like '%" + book.getBid() + "%'";
		}
		if(book.getBname() != null && !book.getBname().equals("")){
			sql = sql + " and bname like '%" + book.getBname() + "%'";
		}
		if(book.getBauthor() != null && !book.getBauthor().equals("")){
			sql = sql + " and bauthor like '%" + book.getBauthor() + "%'";
		}
		
		this.openConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Book book1 = new Book();
			book1.setBid(rs.getInt("bid"));
			book1.setBname(rs.getString("bname"));
			book1.setBauthor(rs.getString("bauthor"));
			book1.setBpress(rs.getString("bpress"));
			book1.setBamount(rs.getInt("bamount"));
			book1.setBinventory(rs.getInt("binventory"));
			book1.setBstate(rs.getString("bstate"));
			
			bookList.add(book1);
		}
		
		return bookList;
	}
}
