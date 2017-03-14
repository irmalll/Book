package com.zy.book.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.book.dao.BorrowDao;
import com.zy.book.entity.Borrow;

public class BorrowBiz {
	//添加借阅记录
	public int addBorrow(Borrow borrow) throws Exception{
		int state = 0;
		
		BorrowDao borrDao = new BorrowDao();
		try {
			state = borrDao.addBorrow(borrow);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			borrDao.closeConnection();
		}
	
		return state;
	}
	
	//根据管理员输入的条件，查询相应的借阅信息
	public List<Borrow> searchBorrows(Borrow borrow) throws Exception{
		List<Borrow> borrowList = new ArrayList<Borrow>();
		
		BorrowDao borrDao = new BorrowDao();
		try {
			borrowList = borrDao.searchBorrows(borrow);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			borrDao.closeConnection();
		}
		
		return borrowList;
	}
	
	//根据用户输入的条件，查询该用户的借阅信息
		public List<Borrow> searchUserBorrows(Borrow borrow) throws Exception{
			List<Borrow> borrowList = null;
			
			BorrowDao borrDao = new BorrowDao();
			try {
				borrowList = borrDao.searchUserBorrows(borrow);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				borrDao.closeConnection();
			}
			
			return borrowList;
		}
	
	//修改借阅信息: 修改前，需要先根据从页面获取来的借阅编号查询该借阅信息
	//查询指定借阅信息
	public Borrow searchOneBorrow(int borrid) throws Exception{
		Borrow borrow = null;
		
		BorrowDao borrDao = new BorrowDao();
		try {
			borrow = borrDao.searchOneBorrow(borrid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			borrDao.closeConnection();
		}
		
		return borrow;
	}
	//修改指定借阅信息
	public int update(Borrow borrow) throws Exception{
		int state = 0;
		
		BorrowDao borrDao = new BorrowDao();
		try {
			state = borrDao.update(borrow);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			borrDao.closeConnection();
		}
		
		return state;
	}
	
	//归还图书
	public int returnBook(int borrid) throws Exception{
		int state = 0;
		
		BorrowDao borrDao = new BorrowDao();
		try {
			state = borrDao.returnBook(borrid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			borrDao.closeConnection();
		}
		
		return state;
	}
}
