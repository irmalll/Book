package com.zy.book.biz;

import java.util.ArrayList;
import java.util.List;

import com.zy.book.dao.BookDao;
import com.zy.book.dao.BorrowDao;
import com.zy.book.entity.Book;

public class BookBiz {
	//���ͼ��
	public int addBook(Book book) throws Exception{
		int state = 0;
		
		BookDao bDao = new BookDao();
		try {
			state = bDao.addBook(book);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return state;
	}
	
	//ɾ��ͼ����Ϣ: ɾ��֮ǰ�����жϽ��ı����Ƿ�ʹ���˸�ͼ�����Ϣ�����У����޸�ͼ��״̬����Ϊ�����ã���û�У���ֱ��ɾ��ͼ�顣
	public int deleteBook(int bid) throws Exception{
		int state = 0;
		
		BookDao bDao = new BookDao();
		
		try {
			//����bid��ѯ�Ƿ���ڽ��ļ�¼
			boolean result = bDao.selectAssignBorrow(bid);
			if(result){
				//�����ڣ����޸�ͼ��״̬��
				state = bDao.updateBookState(bid);
			}else{
				//�������ڣ���ֱ��ɾ����
				state = bDao.deleteBook(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return state;
	}

	
	//�޸�ͼ����Ϣ: �޸�ǰ����Ҫ�ȸ��ݴ�ҳ���ȡ����ͼ���Ų�ѯ��ͼ����Ϣ
	//��ѯָ��ͼ����Ϣ
	public Book searchOneBook(int bid) throws Exception{
		Book book = null;
		
		BookDao bDao = new BookDao();
		try {
			book = bDao.searchOneBook(bid);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return book;
	}
	//�޸�ָ��ͼ����Ϣ
	public int update(Book book) throws Exception{
		int state = 0;
		
		BookDao bDao = new BookDao();
		try {
			state = bDao.update(book);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return state;
	}
	
	//�����û��������������ѯ��Ӧ��ͼ����Ϣ
	public List<Book> searchBooks(Book book) throws Exception{
		List<Book> bookList = new ArrayList<Book>();
		
		BookDao bDao = new BookDao();
		try {
			bookList = bDao.searchBooks(book);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return bookList;
	}
}
