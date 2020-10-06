package com.qlu.web.service.impl;

import com.qlu.web.bean.Admin;
import com.qlu.web.bean.AdminRole;
import com.qlu.web.dao.AdminDao;
import com.qlu.web.dao.Impl.AdminDaoImpl;
import com.qlu.web.service.AdminService;

public class AdminServiceImlp implements AdminService{
	AdminDao ad = new AdminDaoImpl();
	
	@Override
	public AdminRole login(Admin admin) {
		// TODO Auto-generated method stub
		return ad.login(admin);
	}

}
