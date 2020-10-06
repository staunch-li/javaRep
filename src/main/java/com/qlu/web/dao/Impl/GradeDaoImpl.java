package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;
import com.qlu.web.bean.Grade;
import com.qlu.web.bean.User;
import com.qlu.web.bean.javamatch;
import com.qlu.web.dao.GradeDao;
import com.qlu.web.until.DruidUtil;

public class GradeDaoImpl implements GradeDao{
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
	@Override
	public List<Grade> usergradelist() {
		String sql = "select * from grade";
		Object[] params = null;
		try {
			List<Grade> grade = qr.query(sql, new BeanListHandler<Grade>(Grade.class), params);
			return grade;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户成绩时出现问题");
		}
	}
	@Override
	public int queryCounts() {
		String sql = "select count(*) cc from grade";
		Object[] params = null;
		try {
			Number query = qr.query(sql, new ScalarHandler<Number>("cc"), params);
			return query.intValue();//此方法返回转换为int类型后该对象表示的数值。
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询学生记录数时出现异常");
		}
	}
	@Override
	public List<Grade> queryByPage(String selectname ,int currentPage, int pageSize) {
//		String sql = "select * from grade order by uid asc limit ?,?";
//		Object[] params = {(currentPage-1)*pageSize,pageSize};
//		try {
//			List<Grade> datas = qr.query(sql, new BeanListHandler<Grade>(Grade.class), params);
//			return datas;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new RuntimeException("查询分页数据时出现问题");
//		}
		List<Grade> datas;
		String sql="";
		if (selectname==null) {
			sql = "select * from grade order by uid asc limit ?,?";
			Object[] params = { (currentPage - 1) * pageSize, pageSize };
			try {
				datas = qr.query(sql, new BeanListHandler<Grade>(Grade.class), params);
				return datas;
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO Auto-generated catch block	
			}
		}else {
			sql = "select * from grade where uname like ? order by uid asc limit ?,?";
			Object[]  params = { "%"+selectname+"%",(currentPage - 1) * pageSize, pageSize};
			try {
				datas = qr.query(sql, new BeanListHandler<Grade>(Grade.class), params);
				return datas;
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
	return null;
		
	}
	//点赞
	@Override
	public int like(String unumber, String usub) {
		String sql = "update grade set ulike=ulike+1 where unumber = ? and usub = ?";
		Object[] params = {unumber,usub};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("点赞时出现问题");
		}
	}
	@Override
	public List<javamatch> javamatchshow() {
		String sql = "select * from javamatch order by jgrade desc limit 0,3";
		Object[] params = null;
		try {
			List<javamatch> grade = qr.query(sql, new BeanListHandler<javamatch>(javamatch.class), params);
			return grade;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询用户java成绩时出现问题");
		}
	}
	@Override
	public int javalike(String jid) {
		String sql = "update javamatch set jlike=jlike+1 where jid = ? ";
		Object[] params = {jid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("点赞时出现问题");
		}
	}

}
