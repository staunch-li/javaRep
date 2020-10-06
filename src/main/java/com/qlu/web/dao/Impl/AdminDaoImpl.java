package com.qlu.web.dao.Impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.qlu.web.bean.Admin;
import com.qlu.web.bean.AdminRole;
import com.qlu.web.dao.AdminDao;
import com.qlu.web.until.DruidUtil;

public class AdminDaoImpl implements AdminDao{
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
	@Override
	public AdminRole login(Admin admin) {
		String sql = "select a.aid,a.aname,a.apassword,a.rid,r.rname,r.rdisplay from tadmin a left join "
				+ "role r on a.rid = r.rid where a.aname = ? and a.apassword = ?";
		Object[] params = {admin.getAname(),admin.getApassword()};
		  
		try {
			AdminRole ar = qr.query(sql, new BeanHandler<AdminRole>(AdminRole.class), params);
			return ar;
		} catch (SQLException e) {	
			e.printStackTrace();
			throw new RuntimeException("admin登录出现问题");
		}
	}

}
