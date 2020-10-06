package com.qlu.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.Message;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.Reply;
import com.qlu.web.bean.User;
import com.qlu.web.exception.StudentException;
import com.qlu.web.service.MessageService;
import com.qlu.web.service.impl.MessageServiceImpl;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/message")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		//System.out.println(action);
		if (action!=null&&action.equals("upmessage")) {
			upmessage(request, response);
		}else if (action!=null&&action.equals("messagelist")) {
			messagelist(request, response);
		}else if (action!=null&&action.equals("daletemsg")) {
			daletemsg(request, response);
		}else if (action!=null&&action.equals("reply")) {
			reply(request, response);
		}else if (action!=null&&action.equals("replymsg")) {
			replymsg(request, response);
		}else if (action!=null&&action.equals("messageshow")) {
			messageshow(request, response);
		}else if (action!=null&&action.equals("daletereply")) {
			daletereply(request, response);
		}
		
		
		
	}
	protected void daletereply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rid = request.getParameter("rid");
		MessageService ms = new MessageServiceImpl();
		boolean bool =ms.daletereply(rid);
		if (bool) {
			response.getWriter().write("删除(回复/留言)成功");
		}else {
			response.getWriter().write("删除(回复/留言)失败");
		}
	}
	protected void messageshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String unumber = user.getUnumber();
		MessageService ms = new MessageServiceImpl();
		List<Reply> reply = ms.messageshow(unumber);
		
		session.setAttribute("reply", reply);
		request.getRequestDispatcher("/WEB-INF/replylist.jsp").forward(request, response);
	}
	protected void replymsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reply reply=new Reply();
		try {
			BeanUtils.populate(reply, request.getParameterMap());
			MessageService ms = new MessageServiceImpl();
			boolean bool =ms.replymsg(reply);
			if (bool) {
				response.getWriter().write("回复/通知成功");
			}else {
				response.getWriter().write("回复/通知失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void reply(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mnum = request.getParameter("mnum");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		session.setAttribute("mnum", mnum);
		session.setAttribute("title", title);
		System.out.println(mnum+title);
		
	}
	protected void daletemsg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = request.getParameter("mid");
		MessageService ms = new MessageServiceImpl();
		boolean bool = ms.daletemsg(mid);
		if (bool) {
			response.getWriter().write("删除留言成功");
		}else {
			response.getWriter().write("删除留言失败");
		}
	}
	protected void messagelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curpage = request.getParameter("currentPage");
		PageModel<Message> PageModel = new PageModel<Message>();
		if (curpage!=null) {
			PageModel.setCurrentPage(Integer.parseInt(curpage));
		}
		MessageService ms = new MessageServiceImpl();
		PageModel = ms.messagelist(PageModel);
		request.setAttribute("page", PageModel);
		request.getRequestDispatcher("/WEB-INF/messagePage.jsp").forward(request, response);
	}

	protected void upmessage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		MessageService ms = new MessageServiceImpl();
		
		try {
			boolean bool = ms.upmessage(user,title,content);
			if (bool) {
				response.getWriter().write("留言成功");
			}else {
				response.getWriter().write("留言失败");
			}
		} catch (StudentException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
