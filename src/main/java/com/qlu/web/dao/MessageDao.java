package com.qlu.web.dao;

import java.util.List;

import com.qlu.web.bean.Message;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.User;

public interface MessageDao {

	int upmessage(User user, String title, String content);


	int queryCounts();


	List<Message> messagelist(int currentPage, int pageSize);


	int daletemsg(String mid);


	int replymsg(Reply reply);


	List<Reply> messageshow(String unumber);


	int daletereply(String rid);




}
