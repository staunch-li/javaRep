package com.qlu.web.bean;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 5019562314460007776L;
	private String unumber;
	private Integer uid;
	private String uname;
	private String upassword;
	private Integer usex;
	private String ucol;
	private String umajor;
	private String uphoto;
	private Integer ustate;
	
public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUnumber() {
		return unumber;
	}

	public void setUnumber(String unumber) {
		this.unumber = unumber;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
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
	
@Override
	public String toString() {
		return "User [uid=" + uid + ", unumber=" + unumber + ", uname=" + uname + ", upassword=" + upassword + ", usex="
				+ usex + ", ucol=" + ucol + ", umajor=" + umajor + ", uphoto=" + uphoto + ", ustate=" + ustate + "]";
	}

public User() {
	// TODO Auto-generated constructor stub
}

}
