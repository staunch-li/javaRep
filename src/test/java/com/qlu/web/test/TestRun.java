package com.qlu.web.test;




import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;

import com.qlu.web.bean.Admin;
import com.qlu.web.bean.AdminRole;
import com.qlu.web.bean.Category;
import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.Grade;
import com.qlu.web.bean.Message;
import com.qlu.web.bean.Notice;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.SmallCategory;
import com.qlu.web.bean.User;
import com.qlu.web.bean.javamatch;
import com.qlu.web.dao.Impl.AdminDaoImpl;
import com.qlu.web.dao.Impl.CategoryDaoImpl;
import com.qlu.web.dao.Impl.GradeDaoImpl;
import com.qlu.web.dao.Impl.MessageDaoImpl;
import com.qlu.web.dao.Impl.NoticeDaoImpl;
import com.qlu.web.dao.Impl.UserDaoImpl;
import com.qlu.web.dao.Impl.UsersubDaoImpl;
import com.qlu.web.service.UserService;
import com.qlu.web.service.impl.CategoryServiceImpl;
import com.qlu.web.service.impl.UserServiceImpl;
import com.qlu.web.until.DruidUtil;
import com.qlu.web.until.PSWUtil;

public class TestRun {

	@Test
	public void testPSW() throws Exception {
		String p = "123";
		String psw1 = PSWUtil.getPSW(p);
		boolean matchPSW = PSWUtil.matchPSW("123", psw1);
		System.out.println(matchPSW);
		//System.out.println(psw1);
	}
	@Test
	public void testDruid() throws Exception {
		DataSource dataSource = DruidUtil.getDataSource();
		System.out.println(dataSource);
		Connection con = DruidUtil.getCon();
		System.out.println(con);
	}
	@Test
	public void testAdminLoginDao() throws Exception {
		AdminDaoImpl ad = new AdminDaoImpl();
		Admin admin = new Admin();
		admin.setAname("admin");
		admin.setApassword("123");
		AdminRole ar = ad.login(admin);
		System.out.println(ar);
	}
	@Test
	public void testStuList() throws Exception {
		UserDaoImpl ud = new UserDaoImpl();
		List<User> users = ud.userlist();
		System.out.println(users);
	}
	@Test
	public void testcounts() throws Exception {
		UserDaoImpl ud = new UserDaoImpl();
		int counts = ud.queryCounts();
		System.out.println(counts);
	}

	/*
	 * @Test public void testUserPage() throws Exception { UserDaoImpl ud = new
	 * UserDaoImpl(); List<User> datas = ud.queryByPage(1, 3); for (User user :
	 * datas) { System.out.println(user);
	 * 
	 * } }
	 */
	@Test
	public void testUserPage() throws Exception {
		UserDaoImpl ud = new UserDaoImpl();
		List<User> queryByPage = ud.queryByPage(1, 3,"");
		for (User user : queryByPage) {
			System.out.println(user);
		}
	}
	@Test
	public void testUsergradelist() throws Exception {
		GradeDaoImpl gd = new GradeDaoImpl();
		List<Grade> grade = gd.usergradelist();
		System.out.println(grade);
	}
	@Test
	public void testgradecounts() throws Exception {
		GradeDaoImpl gd = new GradeDaoImpl();
		int queryCounts = gd.queryCounts();
		System.out.println(queryCounts);
	}

	/*
	 * @Test public void testgradePage() throws Exception { GradeDaoImpl gd = new
	 * GradeDaoImpl(); List<Grade> datas = gd.queryByPage(1, 3);
	 * System.out.println(datas); }
	 */
	@Test
	public void testunumFind() throws Exception {
//		UserDaoImpl ud = new UserDaoImpl();
//		int cs = ud.unumFind("201701");
//		System.out.println(cs);
		UserServiceImpl usi = new UserServiceImpl();
		boolean unumFind = usi.unumFind("201701");
		System.out.println(unumFind);
	}
	
	@Test
	public void testCategorylist() throws Exception {
//		CategoryDaoImpl cd = new CategoryDaoImpl();
//		List<Category> categorylist = cd.categorylist();
//		System.out.println(categorylist);
		CategoryServiceImpl cs =  new CategoryServiceImpl();
		List<Category> categorylist = cs.categorylist();
		System.out.println(categorylist);
	}
	@Test
	public void testsmcatelist() throws Exception {
		CategoryServiceImpl cs =  new CategoryServiceImpl();
		List<SmallCategory> smcateByCid = cs.smcateByCid("1");
		System.out.println(smcateByCid);
	}
	@Test
	public void testnoticeshow() throws Exception {
		NoticeDaoImpl nd = new NoticeDaoImpl();
		Notice show = nd.noticeShow();
		System.out.println(show);
	}
	@Test
	public void testnoticelist() throws Exception {
		NoticeDaoImpl nd = new NoticeDaoImpl();
		List<Notice> noticeList = nd.noticeList();
		for (Notice notice : noticeList) {
			System.out.println(notice);
		}
	}
	@Test
	public void testlike() throws Exception {
		GradeDaoImpl gd = new GradeDaoImpl();
		int like = gd.like("201701", "现代控制理论");
		System.out.println(like);
	}
	@Test
	public void testmesgpage() throws Exception {
		MessageDaoImpl md = new MessageDaoImpl();
		List<Message> messagelist = md.messagelist(1, 3);
		System.out.println(messagelist);
	}
	@Test
	public void mescount() throws Exception {
		MessageDaoImpl md = new MessageDaoImpl();
		int queryCounts = md.queryCounts();
		System.out.println(queryCounts);
	}
	@Test
	public void msgshow() throws Exception {
		MessageDaoImpl md = new MessageDaoImpl();
		List<Reply> messageshow = md.messageshow("201721");
		for (Reply reply : messageshow) {
			System.out.println(reply);
		}
	}
	@Test
	public void javamatchshwo() throws Exception {
		GradeDaoImpl gd = new GradeDaoImpl();
		List<javamatch> javamatchshow = gd.javamatchshow();
		for (javamatch javamatch : javamatchshow) {			
			System.out.println(javamatch);
		}
	}
	@Test
	public void csubjectshow() throws Exception {
		UsersubDaoImpl ud = new UsersubDaoImpl();
		List<Csubject> csubject = ud.csubject();
		System.out.println(csubject);
	}
}
