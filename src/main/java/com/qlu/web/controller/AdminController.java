package com.qlu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.qlu.web.bean.Admin;
import com.qlu.web.bean.AdminRole;
import com.qlu.web.service.AdminService;
import com.qlu.web.service.impl.AdminServiceImlp;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("login")) {
			login(request, response);
		}else	if (action!=null&&action.equals("exit")) {
			exit(request, response);
		}
	
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin();
		try {
			BeanUtils.populate(admin, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
//		System.out.println(admin);
		AdminService as = new AdminServiceImlp();
		AdminRole ar = as.login(admin);//接60行
		//验证码
		//用户输入的验证码
		String verify = request.getParameter("verify");
		HttpSession session1 = request.getSession();
		//网站上的验证码
		String sessionverify = (String) session1.getAttribute("verify");
		if (!sessionverify.equalsIgnoreCase(verify)) {
			request.setAttribute("mss", "验证码错误");
			response.sendRedirect(request.getContextPath()+"/adminLogin.jsp?mss=1");
			return;
		}
		//判断管理员账号是否存在
		if (ar!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("admin", ar);
			//Cookie
			String remeberme = request.getParameter("remeberme");
			if (remeberme!=null&&"1".equals(remeberme)) {
				Cookie yhm = new Cookie("yhm", ar.getAname());
				yhm.setMaxAge(60*60*24*3650);
				Cookie mm = new Cookie("mm", ar.getApassword());
				mm.setMaxAge(60*60*24*3650);
				response.addCookie(yhm);
				response.addCookie(mm);
			}
			if (ar.getRid()==1) {
				response.sendRedirect(request.getContextPath()+"/main.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/teacherlist.jsp");
			}
		}else {
			request.setAttribute("msg", "用户名或密码错误!");
			response.sendRedirect(request.getContextPath()+"/adminLogin.jsp?msg=1");
		}
	}
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("admin");
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/adminLogin.jsp");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
