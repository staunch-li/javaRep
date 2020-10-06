package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.User;
import com.qlu.web.bean.UserSub;

public interface Usersubservice {

	List<Csubject> csubject();

	boolean select(User user, String sname);

	int selectupdate(String sname);

	boolean unselect(String sname);

	int unselectupdate(String sname);

	List<UserSub> musublist(User user);


}
