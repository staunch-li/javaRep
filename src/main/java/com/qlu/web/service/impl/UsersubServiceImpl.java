package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.User;
import com.qlu.web.bean.UserSub;
import com.qlu.web.dao.UsersubDao;
import com.qlu.web.dao.Impl.UsersubDaoImpl;
import com.qlu.web.filter.userFilter;
import com.qlu.web.service.Usersubservice;

public class UsersubServiceImpl implements Usersubservice{
	UsersubDao ud = new UsersubDaoImpl();
	@Override
	public List<Csubject> csubject() {
		
		return ud.csubject();
	}
	@Override
	public boolean select(User user, String sname) {
		int rows = ud.select(user,sname);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public int selectupdate(String sname) {
		// TODO Auto-generated method stub
		return ud.selectupdate(sname);
	}
	@Override
	public boolean unselect(String sname) {
		int rows = ud.unselect(sname);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public int unselectupdate(String sname) {
		// TODO Auto-generated method stub
		return ud.unselectupdate(sname);
	}
	@Override
	public List<UserSub> musublist(User user) {
		// TODO Auto-generated method stub
		return ud.musublist(user);
	}

}
