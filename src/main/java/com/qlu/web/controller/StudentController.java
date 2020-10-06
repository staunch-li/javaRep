package com.qlu.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qlu.web.bean.Grade;
import com.qlu.web.bean.PageModel;
import com.qlu.web.bean.User;
import com.qlu.web.exception.StudentException;
import com.qlu.web.service.UserService;
import com.qlu.web.service.impl.UserServiceImpl;
import com.qlu.web.until.PSWUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/user")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action!=null&&action.equals("userlist")) {
			userlist(request, response);
		}else if (action!=null&&action.equals("csv")) {
			csv(request, response);
		}else if (action!=null&&action.equals("userlistPage")) {
			userlistPage(request, response);
		}else if (action!=null&&action.equals("unumFind")) {
			unumFind(request, response);
		}else if (action!=null&&action.equals("userRegister")) {
			userRegister(request, response);
		}else if (action!=null&&action.equals("customerlogin")) {
			customerlogin(request, response);
		}else if (action!=null&&action.equals("upswfind")) {
			upswfind(request, response);
		}else if (action!=null&&action.equals("updatePSW")) {
			updatePSW(request, response);
		}else if (action!=null&&action.equals("myselfgradeshow")) {
			myselfgradeshow(request, response);
		}else if (action!=null&&action.equals("update")) {
			update(request, response);
		}else if (action!=null&&action.equals("updatemyphoto")) {
			updatemyphoto(request, response);
		}else if (action!=null&&action.equals("exit")) {
			exit(request, response);
		}else if (action!=null&&action.equals("changeChinese")) {
			changeChinese(request, response);
		}else if (action!=null&&action.equals("changeEnglish")) {
			changeEnglish(request, response);
		}
		
		
		
	}
	protected void changeEnglish(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("locale", "en_US");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void changeChinese(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("locale", "zh_CN");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/studentLogin.jsp");
	}
	protected void updatemyphoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);
		sfu.setHeaderEncoding("UTF-8");//设置文件上传组件里的文件名的编码
		//sfu对象解析 特殊编码下的请求
		try {
			List<FileItem> items = sfu.parseRequest(request);
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					//System.out.println(fileItem.getFieldName()+":"+fileItem.getString("UTF-8"));
				}else {										
					String filename = fileItem.getName();
					//System.out.println("文件名:"+filename+"文件大小:"+fileItem.getSize());
					ServletContext application = request.getServletContext();
					String filepath = (String) application.getAttribute("filepath");
					String uid = UUID.randomUUID().toString().replace("-", "");
					filename =uid + filename;
					String lastpath = filepath+"/"+filename;
					//System.out.println(lastpath);
					Client client = Client.create();
					WebResource webResource = client.resource(lastpath);
					webResource.put(fileItem.getInputStream());
					System.out.println("文件上传成功");					
					HttpSession session = request.getSession();
					User user = (User) session.getAttribute("user");
					UserService us = new UserServiceImpl();
					user = us.updatemyphoto(user,filename);
					session.setAttribute("user", user);
					request.setAttribute("msg", "修改头像成功!");
					request.getRequestDispatcher("/updatePhoto.jsp").forward(request, response);
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new RuntimeException("文件上传最后一步出现问题");
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		HttpSession session = request.getSession();
		User olduser = (User) session.getAttribute("user");
		System.out.println(olduser);
		try {
			BeanUtils.populate(user, request.getParameterMap());
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserService us = new UserServiceImpl();
		try {
			User newuser = us.update(olduser,user);
			System.out.println(newuser+"------------");
			session.setAttribute("user", newuser);
			response.getWriter().write("学生信息修改成功!");
		} catch (StudentException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
		
		
	}
	protected void myselfgradeshow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		UserService us = new UserServiceImpl();
		List<Grade> mygrade = us.myselfgradeshow(user);
		session.setAttribute("mygrade", mygrade);
		request.getRequestDispatcher("/WEB-INF/stugradelist.jsp").forward(request, response);
		
	}
	protected void updatePSW(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String newpassword = request.getParameter("newpassword");
		String newpasswordrepeat = request.getParameter("newpasswordrepeat");
		if (!newpassword.equals(newpasswordrepeat)) {
			response.getWriter().write("两次新密码输入不同,请重新输入");
			return;
		}
		UserService us = new UserServiceImpl();
		try {
			User newuser =  us.updatePSW(user,newpassword);
			session.setAttribute("user", newuser);
			response.getWriter().write("密码修改成功!");
		} catch (StudentException e) {
			response.getWriter().write(e.getMessage());
		}
	}
	protected void upswfind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oldpsw = request.getParameter("oldpsw");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		boolean matchPSW = PSWUtil.matchPSW(oldpsw, user.getUpassword());
		if (matchPSW) {
			response.getWriter().write("yes");
		}else {
			response.getWriter().write("no");
		}
	}
	protected void customerlogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserService us = new UserServiceImpl();
		user = us.customerlogin(user);
		String myverify = request.getParameter("verify");
		HttpSession session = request.getSession();
		String verify = (String) session.getAttribute("verify");
		if (!verify.equalsIgnoreCase(myverify)) {
			response.sendRedirect(request.getContextPath()+"/studentLogin.jsp?mss=1");
			return;
		}
		if (user!=null) {
			session.setAttribute("user", user);
			String remeberme = request.getParameter("remeberme");
			if (remeberme!=null&&"1".equals(remeberme)) {
				Cookie num = new Cookie("num", request.getParameter("unumber"));
				num.setMaxAge(60*60*24*3650);
				Cookie smm = new Cookie("smm", request.getParameter("upassword"));
				smm.setMaxAge(60*60*24*3650);
				response.addCookie(num);
				response.addCookie(smm);
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/studentLogin.jsp?msg=9");
		}
	}
	protected void userRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserService us = new UserServiceImpl();
		try {
			boolean isSuccess = us.userRegister(user);
			if (isSuccess) {
				response.getWriter().write("注册成功");
			}else {
				response.getWriter().write("注册失败");
			}
		} catch (StudentException e) {
			//e.printStackTrace();
			response.getWriter().write(e.getMessage());
		}
	}
	protected void userlistPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String condition = request.getParameter("condition");
		String curpage = request.getParameter("currentPage");
		System.out.println(condition);
		System.out.println(condition);
		PageModel<User> pageModel = new PageModel<User>();
		if (curpage!=null) {
			pageModel.setCurrentPage(Integer.parseInt(curpage));
		}
		UserService us = new UserServiceImpl();
		pageModel = us.userlistPage(pageModel,condition);
		request.setAttribute("page", pageModel);
		request.getRequestDispatcher("/WEB-INF/userlistPage.jsp").forward(request, response);
	}

	protected void userlist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService UserService = new UserServiceImpl();
		List<User> users = UserService.userlist();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/WEB-INF/userlist.jsp").forward(request, response);
	}
	protected void csv(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		StringBuffer sb = us.csv();
		response.setHeader("content-disposition", "attachment;filename=userlist.csv");
		response.getWriter().write(sb.toString());
	}
	protected void unumFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String unumber = request.getParameter("unumber");
		UserService us = new UserServiceImpl();
		boolean isFind = us.unumFind(unumber);
		if (isFind) {
			response.getWriter().write("repeat");
		}else {
			response.getWriter().write("can");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
