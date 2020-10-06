package com.qlu.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.qlu.web.bean.Notice;
import com.qlu.web.service.NoticeService;
import com.qlu.web.service.impl.NoticeServiceImpl;


@WebServlet("/notice")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("noticeShow")) {
			noticeShow(request, response);
		}else if (action!=null&&action.equals("noticeList")) {
			noticeList(request, response);
		}else if (action!=null&&action.equals("conceal")) {
			conceal(request, response);
		}else if (action!=null&&action.equals("display")) {
			display(request, response);
		}else if (action!=null&&action.equals("delete")) {
			delete(request, response);
		}else if (action!=null&&action.equals("addnotice")) {
			addnotice(request, response);
		}
		
	}
	protected void addnotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("nname");
		String ncontent = request.getParameter("ncontent");
		String ntime = request.getParameter("ntime");
		NoticeService ns = new NoticeServiceImpl();
		boolean notice = ns.addnotice(uname,ncontent,ntime);
		System.out.println(uname+ncontent+ntime);
		if (notice) {
			request.setAttribute("noticecan", "新增公告成功");
			request.getRequestDispatcher("/filter/addnotice.jsp").forward(request, response);
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		NoticeService ns = new NoticeServiceImpl();
		boolean bool = ns.delete(nid);
		if (bool) {
			response.getWriter().write("删除公告成功!");
		}
	}
	protected void display(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		NoticeService ns = new NoticeServiceImpl();
		boolean bool = ns.display(nid);
		String msg = bool+"";
		response.getWriter().write(msg);
	}
	protected void conceal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nid = request.getParameter("nid");
		NoticeService ns = new NoticeServiceImpl();
		boolean bool = ns.conceal(nid);
		String msg = bool+"";
		response.getWriter().write(msg);
	}
	protected void noticeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NoticeService ns = new NoticeServiceImpl();
		List<Notice> noticelist = ns.noticeList();
		request.setAttribute("noticelist", noticelist);
		request.getRequestDispatcher("/WEB-INF/noticelist.jsp").forward(request, response);
	}
	protected void noticeShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		NoticeService ns = new NoticeServiceImpl();
		notice = ns.noticeShow();
		HttpSession session = request.getSession();
		session.setAttribute("notice", notice);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
