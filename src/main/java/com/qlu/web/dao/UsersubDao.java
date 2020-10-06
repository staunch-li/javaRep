package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.User;
import com.qlu.web.bean.UserSub;

public interface UsersubDao {

	List<Csubject> csubject();

	int select(User user, String sname);

	int selectupdate(String sname);

	int unselect(String sname);

	int unselectupdate(String sname);

	List<UserSub> musublist(User user);


}
