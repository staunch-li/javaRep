package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.Grade;
import com.qlu.web.bean.User;
import com.qlu.web.bean.UserSub;
import com.qlu.web.dao.UsersubDao;
import com.qlu.web.filter.userFilter;
import com.qlu.web.until.DruidUtil;

public class UsersubDaoImpl implements UsersubDao{
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
	@Override
	public List<Csubject> csubject() {
		String sql = "select * from csubject";
		Object[] params = null;
		try {
			List<Csubject> cs = qr.query(sql, new BeanListHandler<Csubject>(Csubject.class), params);
			return cs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询选课表表单时出现问题");
		}
	}
	@Override
	public int select(User user, String sname) {
		String sql = "insert usersub values(null,?,?,1)";
		Object[] params = { user.getUnumber(),sname};
		try {
			int rows = qr.update(sql, params);
			System.out.println(rows);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("录入选课时出现异常");
		}
	}
	@Override
	public int selectupdate(String sname) {
		String sql = "update csubject set sstate = 2 where sname =?";
		Object[] params = {sname};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查看修改课程状态时出现问题");

		}
	}
	@Override
	public int unselect(String sname) {
		String sql = "delete from usersub where usubject = ?";
		Object[] params = {sname};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("退选选课时出现异常");
		}
	}
	@Override
	public int unselectupdate(String sname) {
		String sql = "update csubject set sstate = 1 where sname =?";
		Object[] params = {sname};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查看修改课程状态时出现问题");

		}
	}
	@Override
	public List<UserSub> musublist(User user) {
		String sql = "select * from usersub where unum = ?";
		Object[] params = {user.getUnumber()};
		try {
			List<UserSub> cs = qr.query(sql, new BeanListHandler<UserSub>(UserSub.class), params);
			return cs;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询学生选课表表单时出现问题");
		}
	}

}
