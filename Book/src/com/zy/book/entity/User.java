package com.zy.book.entity;

public class User {
	private int id;           //�û����
	private String uname;      //�û���
	private String upwd;       //����
	private String urole;      //�û���ɫ
	
	public User() {
		super();
	}
	
	public User(String uname, String upwd, String urole) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.urole = urole;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
}
