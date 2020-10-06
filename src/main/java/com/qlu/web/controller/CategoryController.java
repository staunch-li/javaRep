package com.qlu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qlu.web.bean.Category;
import com.qlu.web.bean.SmallCategory;
import com.qlu.web.service.CategoryService;
import com.qlu.web.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("categorylist")) {
			categorylist(request, response);	
		}else if (action!=null&&action.equals("smcateByCid")) {
			smcateByCid(request, response);	
		}else if (action!=null&&action.equals("addnewcol")) {
			addnewcol(request, response);	
		}else if (action!=null&&action.equals("addnewmaj")) {
			addnewmaj(request, response);	
		}else if (action!=null&&action.equals("deletecol")) {
			deletecol(request, response);	
		}else if (action!=null&&action.equals("deletemaj")) {
			deletemaj(request, response);	
		}else if (action!=null&&action.equals("updatecolname")) {
			updatecolname(request, response);	
		}else if (action!=null&&action.equals("updatemajname")) {
			updatemajname(request, response);	
		}
		
		
		
		
		
	}
	protected void updatemajname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		String newmajname = request.getParameter("newmajname");
		CategoryService cs = new CategoryServiceImpl();
		boolean bool =cs.updatemajname(sid,newmajname);
		if (bool) {
			response.getWriter().write("修改专业名成功");
		}else {
			response.getWriter().write("修改专业名失败");
		}
		
	}
	protected void updatecolname(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String newcolname = request.getParameter("newcolname");
		CategoryService cs = new CategoryServiceImpl();
		Category cates = (Category) request.getAttribute("cates");
		List<Category> newcates = cs.updatecolname(cid,newcolname,cates);
		request.setAttribute("cates", newcates);
		response.getWriter().write("修改学院名成功");
	}
	protected void deletemaj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("sid");
		CategoryService cs = new CategoryServiceImpl();
		boolean bool =cs.deletemaj(sid);
		if (bool) {
			response.getWriter().write("删除专业成功!");
		}else {
			response.getWriter().write("删除专业失败!");
		}
	}
	protected void deletecol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		CategoryService cs = new CategoryServiceImpl();
		boolean bool =cs.deletecol(cid);
		if (bool) {
			response.getWriter().write("删除学院成功!");
		}else {
			response.getWriter().write("删除学院失败!");
		}
	}
	protected void addnewmaj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		String newmajor = request.getParameter("newmajor");
		CategoryService cs = new CategoryServiceImpl();
		boolean bool =cs.addnewmaj(cid,newmajor);
		if (bool) {
			response.getWriter().write("添加新专业成功!");
		}else {
			response.getWriter().write("添加新专业失败!");
		}
	}
	protected void addnewcol(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs = new CategoryServiceImpl();
		String col = request.getParameter("col");
		boolean bool =cs.addnewcol(col);
		if (bool) {
			response.getWriter().write("添加学院成功");
		}else {
			response.getWriter().write("添加学院失败");
		}
	}
	protected void categorylist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cs = new CategoryServiceImpl();
		List<Category> cates = cs.categorylist();
		request.setAttribute("cates", cates);
		request.getRequestDispatcher("filter/categorylist.jsp").forward(request, response);
	}
	protected void smcateByCid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cid = request.getParameter("cid");
		CategoryService cs = new CategoryServiceImpl();
		List<SmallCategory> smcates = cs.smcateByCid(cid);
		//把smcates转为json格式字符串,响应写回
		ObjectMapper om = new ObjectMapper();
		String smcatesJson = om.writeValueAsString(smcates);
		response.getWriter().write(smcatesJson);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
