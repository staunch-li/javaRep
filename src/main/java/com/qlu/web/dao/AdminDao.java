package com.qlu.web.dao;

import com.qlu.web.bean.Admin;
import com.qlu.web.bean.AdminRole;

public interface AdminDao {

	AdminRole login(Admin admin);

}
