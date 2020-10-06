package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Category;
import com.qlu.web.bean.SmallCategory;

public interface CategoryDao {

	List<Category> categorylist();

	List<SmallCategory> smcateByCid(String cid);

	int addnewcol(String col);

	int addnewmaj(String cid, String newmajor);

	int deletecol(String cid);

	int deletemaj(String sid);

	int updatecolname(String cid, String newcolname);

	int updatemajname(String sid, String newmajname);

}
