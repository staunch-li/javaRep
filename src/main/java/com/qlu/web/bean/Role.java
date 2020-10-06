package com.qlu.web.bean;

import java.io.Serializable;

public class Role implements Serializable{
	
	private static final long serialVersionUID = -6567394867740130362L;
	
	private Integer rid;
	private String rname;
	private String rdisplay;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
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
		return "Role [rid=" + rid + ", rname=" + rname + ", rdisplay=" + rdisplay + "]";
	}
	
}
