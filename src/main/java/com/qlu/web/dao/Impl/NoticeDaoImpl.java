package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qlu.web.bean.Notice;
import com.qlu.web.dao.NoticeDao;
import com.qlu.web.until.DruidUtil;

public class NoticeDaoImpl implements NoticeDao{

	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource()); 
	@Override
	public Notice noticeShow() {
		String sql = "select * from notice where nstate = 1";
		Object[] params = null;
		try {
			Notice notice = qr.query(sql, new BeanHandler<Notice>(Notice.class), params);
			return notice;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查看可查看的公告时出现问题");
		}
	}
	@Override
	public List<Notice> noticeList() {
		String sql = "select * from notice";
		Object[] params = null;
		try {
			List<Notice> noticelist = qr.query(sql, new BeanListHandler<Notice>(Notice.class), params);
			return noticelist;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查看所有公告时出现问题");
		}
	}
	@Override
	public int conceal(String nid) {
		String sql = "update notice set nstate = 2 where nid = ?";
		Object[] params = {nid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("使公告隐藏时出现问题");

		}
	}
	@Override
	public int display(String nid) {
		String sql = "update notice set nstate = 1 where nid = ?";
		Object[] params = {nid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("使公告显示时出现问题");

		}
	}
	@Override
	public int delete(String nid) {
		String sql = "delete from notice where nid = ?";
		Object[] params = {nid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除公告时出现问题");

		}
	}
	@Override
	public int addnotice(String uname, String ncontent, String ntime) {
		String sql = "insert notice values(null,?,?,?,2)";
		Object[] params = {uname,ncontent,ntime};
		try {
			int update = qr.update(sql, params);
			return update;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加公告时出现问题");
		}
	}

}
