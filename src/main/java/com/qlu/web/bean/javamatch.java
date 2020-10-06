package com.qlu.web.bean;

import java.io.Serializable;

public class javamatch implements Serializable{

	private static final long serialVersionUID = 5919315612145273049L;
	private Integer jid;
	private String project;
	private String jname;
	private Integer jgrade;
	private String jlike;
	public javamatch() {
		// TODO Auto-generated constructor stub
	}
	public Integer getJid() {
		return jid;
	}
	public void setJid(Integer jid) {
		this.jid = jid;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getJname() {
		return jname;
	}
	public void setJname(String jname) {
		this.jname = jname;
	}
	public Integer getJgrade() {
		return jgrade;
	}
	public void setJgrade(Integer jgrade) {
		this.jgrade = jgrade;
	}
	public String getJlike() {
		return jlike;
	}
	public void setJlike(String jlike) {
		this.jlike = jlike;
	}
	@Override
	public String toString() {
		return "javamatch [jid=" + jid + ", project=" + project + ", jname=" + jname + ", jgrade=" + jgrade + ", jlike="
				+ jlike + "]";
	}
	
 
}
