package com.qlu.web.bean;

import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = 5019562314460007776L;
	
	private Integer uid;
	private String uname;
	private String unumber;
	private String upassword;
	private Integer usex;
	private String ucol;
	private String umajor;
	private String usub;
	private String ugrade;
	private String uphoto;
	private Integer ulike;
	private Integer ustate;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUnumber() {
		return unumber;
	}
	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public Integer getUsex() {
		return usex;
	}
	public void setUsex(Integer usex) {
		this.usex = usex;
	}
	public String getUcol() {
		return ucol;
	}
	public void setUcol(String ucol) {
		this.ucol = ucol;
	}
	public String getUmajor() {
		return umajor;
	}
	public void setUmajor(String umajor) {
		this.umajor = umajor;
	}
	public String getUsub() {
		return usub;
	}
	public void setUsub(String usub) {
		this.usub = usub;
	}
	public String getUgrade() {
		return ugrade;
	}
	public void setUgrade(String ugrade) {
		this.ugrade = ugrade;
	}
	public String getUphoto() {
		return uphoto;
	}
	public void setUphoto(String uphoto) {
		this.uphoto = uphoto;
	}
	public Integer getUstate() {
		return ustate;
	}
	public void setUstate(Integer ustate) {
		this.ustate = ustate;
	}
	
	public Integer getUlike() {
		return ulike;
	}
	public void setUlike(Integer ulike) {
		this.ulike = ulike;
	}
	public Grade() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Grade [uid=" + uid + ", uname=" + uname + ", unumber=" + unumber + ", upassword=" + upassword
				+ ", usex=" + usex + ", ucol=" + ucol + ", umajor=" + umajor + ", usub=" + usub + ", ugrade=" + ugrade
				+ ", uphoto=" + uphoto + ", ulike=" + ulike + ", ustate=" + ustate + "]";
	}
	
	

}
