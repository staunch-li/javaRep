package com.qlu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.javamatch;
import com.qlu.web.service.GradeService;
import com.qlu.web.service.impl.GradeServiceImpl;


@WebServlet("/grade")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("usergradelist")) {
			usergradelist(request, response);
		}else if (action!=null&&action.equals("usergradelistPage")) {
			usergradelistPage(request, response);
		}else if (action!=null&&action.equals("like")) {
			like(request, response);
		}else if (action!=null&&action.equals("javamatchshow")) {
			javamatchshow(request, response);
		}else if (action!=null&&action.equals("javalike")) {
			javalike(request, response);
		}
		
		
	}
	protected void javalike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService gs = new GradeServiceImpl();
		String jid = request.getParameter("jid");
		boolean bool = gs.javalike(jid);
		if (bool) {
			response.getWriter().write("点赞成功");
		}else {
			response.getWriter().write("点赞失败");
		}
	}
	protected void javamatchshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService gs = new GradeServiceImpl();
		List<javamatch> jm = gs.javamatchshow();
		request.setAttribute("javamatch", jm);
		request.getRequestDispatcher("/javamatchlist.jsp").forward(request, response);
		
	}
	protected void like(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService gs = new GradeServiceImpl();
		String unumber = request.getParameter("unumber");
		String usub = request.getParameter("usub");
		boolean bool = gs.like(unumber,usub);
		if (bool) {
			response.getWriter().write("点赞成功");
		}else {
			response.getWriter().write("点赞失败");
		}
	}
	
	protected void usergradelist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GradeService gs = new GradeServiceImpl();
		List<Grade> usergrades =  gs.usergradelist();
		request.setAttribute("grade", usergrades);
		request.getRequestDispatcher("/WEB-INF/gradelist.jsp").forward(request, response);
	}
	protected void usergradelistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curpage = request.getParameter("currentPage");
		String selectname = request.getParameter("selectname");
		PageModel<Grade> PageModel = new PageModel<Grade>();
		if (curpage!=null) {
			PageModel.setCurrentPage(Integer.parseInt(curpage));
		}
		GradeService gs = new GradeServiceImpl();
		PageModel = gs.usergradelistPage(PageModel,selectname);
		request.setAttribute("page", PageModel);
		request.getRequestDispatcher("/WEB-INF/gradelistPage.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
