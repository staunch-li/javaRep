package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.User;
import com.qlu.web.exception.StudentException;

public interface UserService {

	List<User> userlist();

	StringBuffer csv();

	PageModel<User> userlistPage(PageModel<User> pageModel,String condition);

	boolean unumFind(String unumber);

	boolean userRegister(User user) throws StudentException;

	User customerlogin(User user);

	User updatePSW(User user, String newpassword) throws StudentException;

	List<Grade> myselfgradeshow(User user);

	User update(User olduser, User user) throws StudentException;

	User updatemyphoto(User user, String filename);







}
