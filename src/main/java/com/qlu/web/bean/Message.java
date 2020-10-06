package com.qlu.web.bean;

import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = -7456843328146349071L;
	private Integer mid;
	private Integer mnum;
	private String mname;
	private String title;
	private String content;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Integer getMnum() {
		return mnum;
	}
	public void setMnum(Integer mnum) {
		this.mnum = mnum;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", mnum=" + mnum + ", mname=" + mname + ", title=" + title + ", content="
				+ content + "]";
	}
	

}
