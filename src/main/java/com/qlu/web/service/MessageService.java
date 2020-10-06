package com.qlu.web.service;

import java.util.List;

import com.qlu.web.bean.Message;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.User;
import com.qlu.web.exception.StudentException;

public interface MessageService {

	boolean upmessage(User user, String title, String content) throws StudentException;

	PageModel<Message> messagelist(PageModel<Message> pageModel);

	boolean daletemsg(String mid);

	boolean replymsg(Reply reply);

	List<Reply> messageshow(String unumber);

	boolean daletereply(String rid);

	

}
