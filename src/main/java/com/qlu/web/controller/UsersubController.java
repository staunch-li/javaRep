package com.qlu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qlu.web.bean.Csubject;
import com.qlu.web.bean.User;
import com.qlu.web.bean.UserSub;
import com.qlu.web.service.Usersubservice;
import com.qlu.web.service.impl.UsersubServiceImpl;

/**
 * Servlet implementation class UsersubController
 */
@WebServlet("/usersub")
public class UsersubController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("csubject")) {
			csubject(request, response);
		}else if (action!=null&&action.equals("select")) {
			select(request, response);
		}else if (action!=null&&action.equals("unselect")) {
			unselect(request, response);
		}else if (action!=null&&action.equals("musublist")) {
			musublist(request, response);
		}	
	}
	protected void musublist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usersubservice us =  new UsersubServiceImpl();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		List<UserSub> usb  = us.musublist(user);	
		request.setAttribute("UserSub", usb);
		request.getRequestDispatcher("/usersubjectlist.jsp").forward(request, response);
	}
	protected void unselect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		Usersubservice us =  new UsersubServiceImpl();
		boolean bool = us.unselect(sname);
		int rows = us.unselectupdate(sname);
		if (bool) {
			response.getWriter().write("退选成功");
		}else {
			response.getWriter().write("退选失败");
		}
	}
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("sname");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Usersubservice us =  new UsersubServiceImpl();
		boolean bool = us.select(user,sname);
		int rows = us.selectupdate(sname);
		if (bool) {
			response.getWriter().write("选课成功");
		}else {
			response.getWriter().write("选课失败");
		}
	}
	protected void csubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usersubservice us =  new UsersubServiceImpl();
		List<Csubject> cs  = us.csubject();
		request.setAttribute("Csubject", cs);
		request.getRequestDispatcher("/csubjectlist.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
