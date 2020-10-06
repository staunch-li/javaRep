package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Category;
import com.qlu.web.bean.SmallCategory;

public interface CategoryService {

	List<Category> categorylist();

	List<SmallCategory> smcateByCid(String cid);

	boolean addnewcol(String col);

	boolean addnewmaj(String cid, String newmajor);

	boolean deletecol(String cid);

	boolean deletemaj(String sid);

	List<Category> updatecolname(String cid, String newcolname, Category cates);

	boolean updatemajname(String sid, String newmajname);

}
