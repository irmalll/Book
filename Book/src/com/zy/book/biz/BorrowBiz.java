package com.zy.book.biz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zy.book.dao.BorrowDao;
import com.zy.book.entity.Borrow;

public class BorrowBiz {
	//��ӽ��ļ�¼
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
	
	//���ݹ���Ա�������������ѯ��Ӧ�Ľ�����Ϣ
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
	
	//�����û��������������ѯ���û��Ľ�����Ϣ
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
	
	//�޸Ľ�����Ϣ: �޸�ǰ����Ҫ�ȸ��ݴ�ҳ���ȡ���Ľ��ı�Ų�ѯ�ý�����Ϣ
	//��ѯָ��������Ϣ
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
	//�޸�ָ��������Ϣ
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
	
	//�黹ͼ��
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
