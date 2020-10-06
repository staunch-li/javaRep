package com.qlu.web.bean;

import java.io.Serializable;

/**
 * javabean 重点是 无参 和 getset , 实现序列化 可以在网络中传递.
 * @author Administrator
 *
 */
public class Admin implements Serializable{
	
	private static final long serialVersionUID = 10098L;
	protected Integer aid;//防止null指针异常.
	protected String aname;
	protected String apassword;
	protected Integer rid;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", apassword=" + apassword + ", rid=" + rid + "]";
	}
	
	
}
