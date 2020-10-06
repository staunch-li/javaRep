package com.qlu.web.service.impl;

import java.util.List;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.Message;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.User;
import com.qlu.web.dao.MessageDao;
import com.qlu.web.dao.Impl.MessageDaoImpl;
import com.qlu.web.exception.StudentException;
import com.qlu.web.service.MessageService;
import com.qlu.web.until.Regex;

public class MessageServiceImpl implements MessageService{
	MessageDao md = new MessageDaoImpl();
	@Override
	public boolean upmessage(User user, String title, String content)throws StudentException  {
		int rows = md.upmessage(user,title,content);
		if (title==null&&content==null) {
			throw new StudentException("108", "留言标题和留言内容都不能为空");
		}
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public PageModel<Message> messagelist(PageModel<Message> pageModel) {
		int counts = md.queryCounts();
		pageModel.setCounts(counts);
		List<Message> datas = md.messagelist(pageModel.getCurrentPage(),pageModel.getPageSize());
		pageModel.setDatas(datas);
		int result = counts/pageModel.getPageSize();
		int remain = counts%pageModel.getPageSize();
		int totalPage = remain==0?result:result+1;
		pageModel.setTotalPage(totalPage);
		pageModel.setFirst(pageModel.getCurrentPage()>1?1:0);
		pageModel.setLast(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		pageModel.setPrevious(pageModel.getCurrentPage()>1?1:0);
		pageModel.setNext(pageModel.getCurrentPage()<pageModel.getTotalPage()?1:0);
		return pageModel;
	}
	@Override
	public boolean daletemsg(String mid) {
		int rows = md.daletemsg(mid);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public boolean replymsg(Reply reply) {
		int rows = md.replymsg(reply);
		if (rows==1) {
			return true;
		}
		return false;
	}
	@Override
	public List<Reply> messageshow(String unumber) {
		// TODO Auto-generated method stub
		return md.messageshow(unumber);
	}
	@Override
	public boolean daletereply(String rid) {
		int rows = md.daletereply(rid);
		if (rows==1) {
			return true;
		}
		return false;
	}
}

