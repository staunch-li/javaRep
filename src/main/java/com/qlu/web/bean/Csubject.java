package com.qlu.web.bean;

import java.io.Serializable;

public class Csubject implements Serializable{

	private static final long serialVersionUID = 3758243154127401490L;
	private Integer sid;
	private String sname;
	private Integer sstate;
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Integer getSstate() {
		return sstate;
	}
	public void setSstate(Integer sstate) {
		this.sstate = sstate;
	}
	@Override
	public String toString() {
		return "Csubject [sid=" + sid + ", sname=" + sname + ", sstate=" + sstate + "]";
	}
	public Csubject() {
		// TODO Auto-generated constructor stub
	}
}
