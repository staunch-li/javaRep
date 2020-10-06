package com.qlu.web.bean;

import java.io.Serializable;
import java.util.Date;


public class Notice implements Serializable{

	private static final long serialVersionUID = 9123153924580832026L;
	private Integer nid;
	private String nname;
	private String ncontent;
	private Date ntime;
	private Integer nstate;
	public Notice() {
		// TODO Auto-generated constructor stub
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getNname() {
		return nname;
	}
	public void setNname(String nname) {
		this.nname = nname;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public Date getNtime() {
		return ntime;
	}
	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}
	public Integer getNstate() {
		return nstate;
	}
	public void setNstate(Integer nstate) {
		this.nstate = nstate;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", nname=" + nname + ", ncontent=" + ncontent + ", ntime=" + ntime + ", nstate="
				+ nstate + "]";
	}
	
}
