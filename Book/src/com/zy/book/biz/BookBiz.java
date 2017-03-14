package com.zy.book.biz;

import java.util.ArrayList;
import java.util.List;

import com.zy.book.dao.BookDao;
import com.zy.book.dao.BorrowDao;
import com.zy.book.entity.Book;

public class BookBiz {
	//添加图书
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
	
	//删除图书信息: 删除之前，先判断借阅表中是否使用了该图书的信息。若有，则修改图书状态，改为不可用；若没有，则直接删除图书。
	public int deleteBook(int bid) throws Exception{
		int state = 0;
		
		BookDao bDao = new BookDao();
		
		try {
			//根据bid查询是否存在借阅记录
			boolean result = bDao.selectAssignBorrow(bid);
			if(result){
				//若存在，则修改图书状态。
				state = bDao.updateBookState(bid);
			}else{
				//若不存在，则直接删除。
				state = bDao.deleteBook(bid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			bDao.closeConnection();
		}
		
		return state;
	}

	
	//修改图书信息: 修改前，需要先根据从页面获取来的图书编号查询该图书信息
	//查询指定图书信息
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
	//修改指定图书信息
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
	
	//根据用户输入的条件，查询相应的图书信息
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
