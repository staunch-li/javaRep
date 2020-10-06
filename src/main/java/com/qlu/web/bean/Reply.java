package com.qlu.web.bean;

import java.io.Serializable;

public class Reply implements Serializable{

	private static final long serialVersionUID = -4904038748297712661L;
	private Integer rid;
	private Integer rnum;
	private String rtitle;
	private String rreply;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	public Integer getRnum() {
		return rnum;
	}
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}
	public String getRreply() {
		return rreply;
	}
	public void setRreply(String rreply) {
		this.rreply = rreply;
	}
	public Reply() {
		// TODO Auto-generated constructor stub
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", rnum=" + rnum + ", rtitle=" + rtitle + ", rreply=" + rreply + "]";
	}
	
	
	
}
