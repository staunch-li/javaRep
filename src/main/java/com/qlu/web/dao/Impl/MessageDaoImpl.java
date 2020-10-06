package com.qlu.web.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.NewCookie;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.alibaba.druid.pool.DruidDataSource;
import com.qlu.web.bean.Grade;
import com.qlu.web.bean.Message;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.User;
import com.qlu.web.dao.MessageDao;
import com.qlu.web.until.DruidUtil;

public class MessageDaoImpl implements MessageDao{
	QueryRunner qr = new QueryRunner(DruidUtil.getDataSource());
	@Override
	public int upmessage(User user, String title, String content) {
		String sql = "insert message values(null,?,?,?,?)";
		Object[] params = {user.getUname(),user.getUnumber(),title,content};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("添加留言失败");
		}
	}
	
	@Override
	public int queryCounts() {
		String sql = "select count(*) cc from message";
		Object[] params = null;
		try {
			Number query = qr.query(sql, new ScalarHandler<Number>("cc"), params);
			return query.intValue();//此方法返回转换为int类型后该对象表示的数值。
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询留言记录数时出现异常");
		}
	}

	@Override
	public List<Message> messagelist(int currentPage, int pageSize) {
		String sql = "select * from message order by mid asc limit ?,?";
		Object[] params = { (currentPage - 1) * pageSize, pageSize };
		try {
			List<Message> datas = qr.query(sql, new BeanListHandler<Message>(Message.class), params);
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询留言分页时出现异常");
		}
	}

	@Override
	public int daletemsg(String mid) {
		String sql = "delete from message where mid = ?";
		Object[] params = {mid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除留言时出现问题");

		}
	}

	@Override
	public int replymsg(Reply reply) {
		String sql = "insert reply values(null,?,?,?)";
		Object[] params = {reply.getRnum(),reply.getRtitle(),reply.getRreply()};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("回复留言失败");
		}
	}

	@Override
	public List<Reply> messageshow(String unumber) {
		String sql = "select * from reply where rnum = ?";
		Object[] params = {unumber};
		try {
			List<Reply> msg = qr.query(sql, new BeanListHandler<Reply>(Reply.class), params);
			return msg;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("查询留言记录数时出现异常");
		}
	}

	@Override
	public int daletereply(String rid) {
		String sql = "delete from reply where rid = ?";
		Object[] params = {rid};
		try {
			int rows = qr.update(sql, params);
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("删除回复时出现问题");
		}
	}


	

}
