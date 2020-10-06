package com.qlu.web.bean;

import java.io.Serializable;

public class Category implements Serializable{

	
	private static final long serialVersionUID = 6975114063409670688L;

	private Integer cid;
	private String ccol;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCcol() {
		return ccol;
	}
	public void setCcol(String ccol) {
		this.ccol = ccol;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", ccol=" + ccol + "]";
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	
	
}
