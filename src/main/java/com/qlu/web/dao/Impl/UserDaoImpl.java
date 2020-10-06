package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.User;
import com.qlu.web.dao.UserDao;
import com.qlu.web.until.DruidUtil;

public class UserDaoImpl implements UserDao {
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());

	// 查用户的所有信息
	@Override
	public List<User> userlist() {
		String sql = "select * from tuser";
		Object[] params = null;
		try {
			List<User> users = qr.query(sql, new BeanListHandler<User>(User.class), params);
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有人信息时出现异常");
		}

	}

	// 查总页数
	@Override
	public int queryCounts() {
		String sql = "select count(*) cs from tuser";
		Object[] params = null;
		try {
			Number query = qr.query(sql, new ScalarHandler<Number>("cs"), params);
			return query.intValue();// 此方法返回转换为int类型后该对象表示的数值。
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询学生记录数时出现异常");
		}

	}

	@Override
	public List<User> queryByPage(int currentPage, int pageSize,String condition) {		
		List<User> datas;
		String sql="";
		if (condition==null) {
			sql = "select * from tuser order by uid asc limit ?,?";
			Object[] params = { (currentPage - 1) * pageSize, pageSize };
			try {
				datas = qr.query(sql, new BeanListHandler<User>(User.class), params);
				return datas;
			} catch (SQLException e) {
				e.printStackTrace();
				// TODO Auto-generated catch block	
			}
		}else {
			sql = "select * from tuser where uname like ? order by uid asc limit ?,?";
			Object[]  params = { "%"+condition+"%",(currentPage - 1) * pageSize, pageSize};
			try {
				datas = qr.query(sql, new BeanListHandler<User>(User.class), params);
				return datas;
			} catch (SQLException e) {
				e.printStackTrace();			
			}
		}
	return null;
		
		
		
	}

	@Override
	public int unumFind(String unumber) {
		String sql = "select count(*) cs from tuser where unumber = ?";
		Object[] params = { unumber };
		try {
			Number query = qr.query(sql, new ScalarHandler<Number>("cs"), params);
			return query.intValue();// 此方法返回转换为int类型后该对象表示的数值。
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询学生重复时出现异常");
		}
	}

	@Override
	public int userRegister(User user) {
		String sql = "insert tuser values(null,?,?,?,?,?,?,'sun.jpg',1)";
		Object[] params = { user.getUnumber(), user.getUname(), user.getUpassword(), user.getUsex(), user.getUcol(),
				user.getUmajor() };
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("注册学生信息时出现异常");
		}

	}

	@Override
	public User customerlogin(String unumber) {
		String sql = "select * from tuser where unumber = ? and ustate = 1";
		Object[] params = { unumber };
		try {
			User userlogin = qr.query(sql, new BeanHandler<User>(User.class), params);
			return userlogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("学生登录时出现异常");
		}
	}

	@Override
	public int updatePSW(User user, String psw) {
		String sql = "update tuser set upassword = ? where unumber = ?";
		Object[] params = { psw, user.getUnumber() };
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查看修改修改密码时出现问题");

		}

	}

	// 修改信息时按学号重新查询
	@Override
	public User queryUnum(User olduser) {
		String sql = "select * from tuser where unumber = ?";
		Object[] params = { olduser.getUnumber() };
		try {
			User userlogin = qr.query(sql, new BeanHandler<User>(User.class), params);
			return userlogin;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("学生按学号查询时出现问题时出现异常");
		}
	}


	@Override
	public List<Grade> myselfgradeshow(User user) {
		String sql = "select * from grade where unumber = ?";
		Object[] params = {user.getUnumber()};
		try {
			List<Grade> mygrade = qr.query(sql, new BeanListHandler<Grade>(Grade.class), params);
			System.out.println(mygrade);
			return mygrade;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("学生按学号查询成绩时出现问题");
		}
	}

	@Override
	public int update(User user,User olduser) {
		String sql = "update tuser set usex = ?,ucol = ? ,umajor = ? where unumber = ?";
		Object[] params = { user.getUsex(),user.getUcol(),user.getUmajor(), olduser.getUnumber() };
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改用户信息时出现问题");

		}
	}

	@Override
	public int updatemyphoto(User user, String filename) {
		String sql = "update tuser set uphoto = ? where unumber = ?";
		Object[] params = {filename,user.getUnumber()};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("修改用户头像时出现问题");

		}
	}

	

}
