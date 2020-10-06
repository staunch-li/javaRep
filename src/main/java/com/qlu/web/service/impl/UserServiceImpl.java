package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.User;
import com.qlu.web.dao.UserDao;
import com.qlu.web.dao.Impl.UserDaoImpl;
import com.qlu.web.exception.StudentException;
import com.qlu.web.service.UserService;
import com.qlu.web.until.PSWUtil;
import com.qlu.web.until.Regex;

public class UserServiceImpl implements UserService{
	UserDao ud = new UserDaoImpl();
	@Override
	public List<User> userlist() {
		// TODO Auto-generated method stub
		return ud.userlist() ;
	}
	@Override
	public StringBuffer csv() {
		List<User> users = ud.userlist();
		StringBuffer sb = new StringBuffer(100);
		for (User user : users) {
			sb.append(user.getUid()+",");
			sb.append(user.getUnumber()+",");
			sb.append(user.getUname()+",");
			sb.append(user.getUsex()+",");
			sb.append(user.getUcol()+",");
			sb.append(user.getUmajor()+",");
			sb.append(user.getUphoto()+",");
			sb.append(user.getUstate()+"\r\n");
			
		}
		return sb;
	}
	@Override
	public PageModel<User> userlistPage(PageModel<User> pageModel,String condition) {
		//1:总条数
		int Counts = ud.queryCounts();
		pageModel.setCounts(Counts);//这里直接往pageModel里设总条数,下面就可以获取到了.
		//2.查当前页pagesize条记录 limit语句第几页 每页几条
		List<User> datas = ud.queryByPage(pageModel.getCurrentPage(),pageModel.getPageSize(),condition);
		pageModel.setDatas(datas);
		//总页数
		int result = Counts/pageModel.getPageSize();
		int remain = Counts%pageModel.getPageSize();
		int totalPage = remain==0?result:result+1;
		pageModel.setTotalPage(totalPage);
		//当前页
		pageModel.setFirst(pageModel.getCurrentPage()>1?1:0);
		pageModel.setLast(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		pageModel.setPrevious(pageModel.getCurrentPage()>1?1:0);
		pageModel.setNext(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		return pageModel;
	}
	@Override
	public boolean unumFind(String unumber) {
		int cs = ud.unumFind(unumber);
		if (cs>=1) {
			return true ;
		}
		return false;
	}
	@Override
	public boolean userRegister(User user) throws StudentException {
		//1.格式通过
		if (!user.getUnumber().matches(Regex.UNUM_REG)) {
			throw new StudentException("101",Regex.UNUM_DIS);
		}
		if (!user.getUname().matches(Regex.UNANME_REG)) {
			throw new StudentException("102",Regex.UNANME_DIS);
		}
		if (!user.getUpassword().matches(Regex.UPSW_REG)) {
			throw new StudentException("103",Regex.UPSW_DIS);
		}
		if (!user.getUcol().matches(Regex.UCOL_REG)) {
			throw new StudentException("104",Regex.UCOL_DIS);
		}
		if (!user.getUcol().equals("电气工程与自动化学院")
			&!user.getUcol().equals("材料科学与工程学院")
			&!user.getUcol().equals("电子信息工程学院")
			&!user.getUcol().equals("计算机科学与技术学院")
			&!user.getUcol().equals("数学与统计学院")) {
			throw new StudentException("106",Regex.UCOLNULL_DIS);
		}
		if (!user.getUmajor().matches(Regex.UMAJ_REG)) {
			throw new StudentException("105",Regex.UMAJ_DIS);
		}
		if (user.getUcol().equals("电气工程与自动化学院")) {
			if (!user.getUmajor().equals("自动化")
				&!user.getUmajor().equals("电气工程及自动化")
				&!user.getUmajor().equals("测控技术与仪器")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
			}
		}else if (user.getUcol().equals("材料科学与工程学院")) {
			if (!user.getUmajor().equals("高分子材料与工程")
					&!user.getUmajor().equals("材料科学")
					&!user.getUmajor().equals("无机非金属材料工程")
					&!user.getUmajor().equals("复合材料与工程")
					&!user.getUmajor().equals("宝石及材料工艺学")) {
					throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("电子信息工程学院")) {
			if (!user.getUmajor().equals("电子信息工程")
				&!user.getUmajor().equals("通信工程")
				&!user.getUmajor().equals("电子信息科学与技术")
				&!user.getUmajor().equals("微电子科学与工程")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("计算机科学与技术学院")) {
			if (!user.getUmajor().equals("计算机科学与技术")
				&!user.getUmajor().equals("物联网工程")
				&!user.getUmajor().equals("软件工程")
				&!user.getUmajor().equals("数据科学与大数据技术")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("数学与统计学院")) {
			if (!user.getUmajor().equals("计算机科学与技术")
				&!user.getUmajor().equals("信息与计算科学")
				&!user.getUmajor().equals("智能科学与技术")
				&!user.getUmajor().equals("应用统计学")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
			}
		//2.加密
		user.setUpassword(PSWUtil.getPSW(user.getUpassword()));
		//3.dao层
		int rows = ud.userRegister(user);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public User customerlogin(User user) {
		User userLogin = ud.customerlogin(user.getUnumber());
		if (userLogin==null||!PSWUtil.matchPSW(user.getUpassword(), userLogin.getUpassword())) {
			return null;
		}		
		return userLogin;
	}
	@Override
	public User updatePSW(User user, String newpassword) throws StudentException {
		if (!newpassword.matches(Regex.UPSW_REG)) {
			throw new StudentException("103",Regex.UPSW_DIS);
		}
		String psw = PSWUtil.getPSW(newpassword);
		int row = ud.updatePSW(user,psw);
		if (row==1) {
			User u = ud.queryUnum(user);
			return u;
		}
		return user;
	}
	@Override
	public List<Grade> myselfgradeshow(User user) {
		// TODO Auto-generated method stub
		return ud.myselfgradeshow(user);
	}
	@Override
	public User update(User olduser, User user) throws StudentException {
		if (!user.getUcol().matches(Regex.UCOL_REG)) {
			throw new StudentException("104",Regex.UCOL_DIS);
		}
		if (!user.getUcol().equals("电气工程与自动化学院")
			&!user.getUcol().equals("材料科学与工程学院")
			&!user.getUcol().equals("电子信息工程学院")
			&!user.getUcol().equals("计算机科学与技术学院")
			&!user.getUcol().equals("数学与统计学院")) {
			throw new StudentException("106",Regex.UCOLNULL_DIS);
		}
		if (!user.getUmajor().matches(Regex.UMAJ_REG)) {
			throw new StudentException("105",Regex.UMAJ_DIS);
		}
		if (user.getUcol().equals("电气工程与自动化学院")) {
			if (!user.getUmajor().equals("自动化")
				&!user.getUmajor().equals("电气工程及自动化")
				&!user.getUmajor().equals("测控技术与仪器")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
			}
		}else if (user.getUcol().equals("材料科学与工程学院")) {
			if (!user.getUmajor().equals("高分子材料与工程")
					&!user.getUmajor().equals("材料科学")
					&!user.getUmajor().equals("无机非金属材料工程")
					&!user.getUmajor().equals("复合材料与工程")
					&!user.getUmajor().equals("宝石及材料工艺学")) {
					throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("电子信息工程学院")) {
			if (!user.getUmajor().equals("电子信息工程")
				&!user.getUmajor().equals("通信工程")
				&!user.getUmajor().equals("电子信息科学与技术")
				&!user.getUmajor().equals("微电子科学与工程")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("计算机科学与技术学院")) {
			if (!user.getUmajor().equals("计算机科学与技术")
				&!user.getUmajor().equals("物联网工程")
				&!user.getUmajor().equals("软件工程")
				&!user.getUmajor().equals("数据科学与大数据技术")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		}else if (user.getUcol().equals("数学与统计学院")) {
			if (!user.getUmajor().equals("计算机科学与技术")
				&!user.getUmajor().equals("信息与计算科学")
				&!user.getUmajor().equals("智能科学与技术")
				&!user.getUmajor().equals("应用统计学")) {
				throw new StudentException("107",Regex.UMAJNULL_DIS);
				}
		
	}
		int rows = ud.update(user,olduser);
		System.out.println(rows);
		if (rows==1) {
			User newuser = ud.queryUnum(olduser); //如果成功按照学号重新查询返回改后user
			return newuser;			
		}
		return olduser;//返回session里的老user
	}
	@Override
	public User updatemyphoto(User user, String filename) {
		int rows = ud.updatemyphoto(user, filename);
		if (rows==1) {
			User newuser = ud.queryUnum(user);
			return newuser;	
		}
		return user  ;
	}
}


