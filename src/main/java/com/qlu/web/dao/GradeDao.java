package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.javamatch;

public interface GradeDao {


	List<Grade> usergradelist();

	int queryCounts();

	List<Grade> queryByPage(String selectname,int currentPage, int pageSize);


	int like(String unumber, String usub);

	List<javamatch> javamatchshow();

	int javalike(String jid);

}
