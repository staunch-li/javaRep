package com.qlu.web.bean;

import java.io.Serializable;

public class UserSub implements Serializable{

	private static final long serialVersionUID = 1548432974030193666L;
	private Integer uid;
	private String unum;
	private String usubject;
	private Integer ustate;
	public UserSub() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserSub [uid=" + uid + ", unum=" + unum + ", usubject=" + usubject + ", ustate=" + ustate + "]";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUnum() {
		return unum;
	}
	public void setUnum(String unum) {
		this.unum = unum;
	}
	public String getUsubject() {
		return usubject;
	}
	public void setUsubject(String usubject) {
		this.usubject = usubject;
	}
	public Integer getUstate() {
		return ustate;
	}
	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}
	
}
