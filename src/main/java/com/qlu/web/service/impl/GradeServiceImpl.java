package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.javamatch;
import com.qlu.web.dao.GradeDao;
import com.qlu.web.dao.Impl.GradeDaoImpl;
import com.qlu.web.service.GradeService;

public class GradeServiceImpl implements GradeService{
  GradeDao gd = new GradeDaoImpl();
	@Override
	public List<Grade> usergradelist() {
		// TODO Auto-generated method stub
		return gd.usergradelist();
	}
	@Override
	public PageModel<Grade> usergradelistPage(PageModel<Grade> pageModel,String selectname) {
		int counts = gd.queryCounts();
		pageModel.setCounts(counts);
		List<Grade> datas = gd.queryByPage(selectname,pageModel.getCurrentPage(),pageModel.getPageSize());
		pageModel.setDatas(datas);
		int result = counts/pageModel.getPageSize();
		int remain = counts%pageModel.getPageSize();
		int totalPage = remain==0?result:result+1;
		pageModel.setTotalPage(totalPage);
		pageModel.setFirst(pageModel.getCurrentPage()>1?1:0);
		pageModel.setLast(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		pageModel.setPrevious(pageModel.getCurrentPage()>1?1:0);
		pageModel.setNext(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		return pageModel;
	}
	@Override
	public boolean like(String unumber, String usub) {
		int rows = gd.like(unumber,usub);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public List<javamatch> javamatchshow() {
		
		return gd.javamatchshow();
	}
	@Override
	public boolean javalike(String jid) {
		int rows = gd.javalike(jid);
		if (rows==1) {
			return true;
		}
		return false;
	}

}
