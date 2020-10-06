package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Category;
import com.qlu.web.bean.SmallCategory;
import com.qlu.web.dao.CategoryDao;
import com.qlu.web.dao.Impl.CategoryDaoImpl;
import com.qlu.web.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	CategoryDao cd = new CategoryDaoImpl();
	@Override
	public List<Category> categorylist() {
		// TODO Auto-generated method stub
		return cd.categorylist();
	}
	@Override
	public List<SmallCategory> smcateByCid(String cid) {
		// TODO Auto-generated method stub
		return cd.smcateByCid(cid);
	}
	@Override
	public boolean addnewcol(String col) {
		int rows =cd.addnewcol(col);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addnewmaj(String cid, String newmajor) {
		int rows =cd.addnewmaj(cid,newmajor);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deletecol(String cid) {
		int rows =cd.deletecol(cid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean deletemaj(String sid) {
		int rows =cd.deletemaj(sid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public List<Category> updatecolname(String cid, String newcolname, Category cates) {
		int rows =cd.updatecolname(cid,newcolname);
		if (rows==1) {
			List<Category> categorylist = cd.categorylist();
			return categorylist;
		}
		return (List<Category>) cates;
	}
	@Override
	public boolean updatemajname(String sid, String newmajname) {
		int rows =cd.updatemajname(sid,newmajname);
		if (rows==1) {
			return true;
		}
		return false;
	}


}
