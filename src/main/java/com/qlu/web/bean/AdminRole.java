package com.qlu.web.bean;

import java.io.Serializable;

public class AdminRole extends Admin implements Serializable{
	private static final long serialVersionUID = 8437503247494638671L;
	
	private String rname;
	private String rdisplay;
	public AdminRole() {
		// TODO Auto-generated constructor stub
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRdisplay() {
		return rdisplay;
	}
	public void setRdisplay(String rdisplay) {
		this.rdisplay = rdisplay;
	}
	
	@Override
	public String toString() {
		return "AdminRole:"+super.toString()+"[rname=" + rname + ", rdisplay=" + rdisplay + "]";
	}
	
}
