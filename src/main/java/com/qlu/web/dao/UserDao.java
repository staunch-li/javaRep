package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.User;

public interface UserDao {

	List<User> userlist();

	int queryCounts();

	List<User> queryByPage(int currentPage, int pageSize,String condition);

	int unumFind(String unumber);

	int userRegister(User user);

	User customerlogin(String unumber);

	int updatePSW(User user, String psw);

	User queryUnum(User olduser);

	List<Grade> myselfgradeshow(User user);

	int update(User user,User olduser);

	int updatemyphoto(User user, String filename);
	
	



	

	

}
