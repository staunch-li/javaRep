package com.qlu.web.bean;

import java.io.Serializable;

public class SmallCategory implements Serializable{

	
	private static final long serialVersionUID = 7066150150286842804L;
	private Integer sid;
	private String smajor;
	private Integer cid;
	public SmallCategory() {
		// TODO Auto-generated constructor stub
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSmajor() {
		return smajor;
	}
	public void setSmajor(String smajor) {
		this.smajor = smajor;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "SmallCategory [sid=" + sid + ", smajor=" + smajor + ", cid=" + cid + "]";
	}
	
	
	
	
}
