package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Notice;

public interface NoticeDao {

	Notice noticeShow();

	List<Notice> noticeList();

	int conceal(String nid);

	int display(String nid);

	int delete(String nid);

	int addnotice(String uname, String ncontent, String ntime);

}
