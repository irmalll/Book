package com.zy.book.entity;

public class Book {
	private int bid;            //ͼ����
	private String bname;       //ͼ����
	private String bauthor;     //ͼ������
	private String bpress;      //������
	private int bamount;        //ͼ������
	private int binventory;     //ͼ����
	private String bstate;      //ͼ��״̬��0�����ã�1��������
	
	public Book() {
		super();
	}
	
	public Book(String bname, String bauthor, String bpress, int bamount,
			int binventory) {
		super();
		this.bname = bname;
		this.bauthor = bauthor;
		this.bpress = bpress;
		this.bamount = bamount;
		this.binventory = binventory;
	}

	public Book(int bid, String bname, String bauthor, String bpress,
			int bamount, int binventory) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.bauthor = bauthor;
		this.bpress = bpress;
		this.bamount = bamount;
		this.binventory = binventory;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBpress() {
		return bpress;
	}
	public void setBpress(String bpress) {
		this.bpress = bpress;
	}
	public int getBamount() {
		return bamount;
	}
	public void setBamount(int bamount) {
		this.bamount = bamount;
	}
	public int getBinventory() {
		return binventory;
	}
	public void setBinventory(int binventory) {
		this.binventory = binventory;
	}
	public String getBstate() {
		return bstate;
	}
	public void setBstate(String bstate) {
		this.bstate = bstate;
	}
}
