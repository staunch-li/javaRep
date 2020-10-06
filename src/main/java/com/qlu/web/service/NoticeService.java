package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Notice;

public interface NoticeService {

	Notice noticeShow();

	List<Notice> noticeList();

	boolean conceal(String nid);

	boolean display(String nid);

	boolean delete(String nid);

	boolean addnotice(String uname, String ncontent, String ntime);

}
