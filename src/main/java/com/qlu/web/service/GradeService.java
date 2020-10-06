package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.javamatch;

public interface GradeService {

	List<Grade> usergradelist();

	PageModel<Grade> usergradelistPage(PageModel<Grade> pageModel,String selectname);

	boolean like(String unumber, String usub);

	List<javamatch> javamatchshow();

	boolean javalike(String jid);

}
