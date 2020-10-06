package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Notice;
import com.qlu.web.dao.NoticeDao;
import com.qlu.web.dao.Impl.NoticeDaoImpl;
import com.qlu.web.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	NoticeDao nd = new NoticeDaoImpl();
	@Override
	public Notice noticeShow() {
		// TODO Auto-generated method stub
		return nd.noticeShow();
	}
	@Override
	public List<Notice> noticeList() {
		// TODO Auto-generated method stub
		return nd.noticeList();
	}
	@Override
	public boolean conceal(String nid) {
		int rows = nd.conceal(nid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean display(String nid) {
		int rows = nd.display(nid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(String nid) {
		int rows = nd.delete(nid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addnotice(String uname, String ncontent, String ntime) {
		int rows = nd.addnotice(uname, ncontent,ntime);
		if (rows==1) {
			return true;
		}
		return false;
	}

}
