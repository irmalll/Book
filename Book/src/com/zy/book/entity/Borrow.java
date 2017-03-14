package com.zy.book.entity;

import java.util.Date;

public class Borrow {
	private int borrid;         //���ı��
	private User user;          //������
	private Book book;          //����ͼ��
	private int borrcount;      //��������
	private Date borrtime;      //����ʱ��
	private Date returntime;    //�黹ʱ��
	private String borrstate;   //����״̬��0��δ�黹��1���ѹ黹
	
	public Borrow() {
		super();
	}
	
	public Borrow(User user, Book book, int borrcount, Date borrtime) {
		super();
		this.user = user;
		this.book = book;
		this.borrcount = borrcount;
		this.borrtime = borrtime;
	}

	public Borrow(int borrid, User user, Book book, int borrcount,
			Date borrtime, Date returntime) {
		super();
		this.borrid = borrid;
		this.user = user;
		this.book = book;
		this.borrcount = borrcount;
		this.borrtime = borrtime;
		this.returntime = returntime;
	}

	public int getBorrid() {
		return borrid;
	}
	public void setBorrid(int borrid) {
		this.borrid = borrid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getBorrcount() {
		return borrcount;
	}
	public void setBorrcount(int borrcount) {
		this.borrcount = borrcount;
	}
	public Date getBorrtime() {
		return borrtime;
	}
	public void setBorrtime(Date borrtime) {
		this.borrtime = borrtime;
	}
	public Date getReturntime() {
		return returntime;
	}
	public void setReturntime(Date returntime) {
		this.returntime = returntime;
	}
	public String getBorrstate() {
		return borrstate;
	}
	public void setBorrstate(String borrstate) {
		this.borrstate = borrstate;
	}
}
