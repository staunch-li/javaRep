package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qlu.web.bean.Category;
import com.qlu.web.bean.SmallCategory;
import com.qlu.web.dao.CategoryDao;
import com.qlu.web.until.DruidUtil;

public class CategoryDaoImpl implements CategoryDao{
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
	@Override
	public List<Category> categorylist() {
		String sql = "select * from category";
		Object[] params = null;
		try {
			List<Category> cates = qr.query(sql, new BeanListHandler<Category>(Category.class), params);
			return cates;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有学院时出现问题");
		}
	}
	@Override
	public List<SmallCategory> smcateByCid(String cid) {
		String sql = "select * from smallcategory where cid = ?";
		Object[] params = {cid};
		try {
			List<SmallCategory> smcates = qr.query(sql, new BeanListHandler<SmallCategory>(SmallCategory.class), params);
			return smcates;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有小分类时出现问题");
		}
	}
	@Override
	public int addnewcol(String col) {
		String sql ="insert category values(null,?)";
		Object[] params = {col};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加学院时出现问题");
		}
		
	}
	@Override
	public int addnewmaj(String cid, String newmajor) {
		String sql ="insert smallcategory values(null,?,?)";
		Object[] params = {newmajor,cid};
		System.out.println(params);
		try {
			int rows = qr.update(sql, params);
			System.out.println(rows);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加新专业时出现问题");
		}
	}
	@Override
	public int deletecol(String cid) {
		String sql ="delete from category where cid = ?";
		Object[] params = {cid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除学院时出现问题");
		}
	}
	@Override
	public int deletemaj(String sid) {
		String sql ="delete from smallcategory where sid = ?";
		Object[] params = {sid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除专业时出现问题");
		}
	}
	@Override
	public int updatecolname(String cid, String newcolname) {
		String sql = "update category set ccol = ? where cid = ?";
		Object[] params = { newcolname, cid };
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改学院名时出现问题");

		}
	}
	@Override
	public int updatemajname(String sid, String newmajname) {
		String sql = "update smallcategory set smajor = ? where sid = ?";
		Object[] params = { newmajname, sid };
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改专业名时出现问题");

		}
	}

}
