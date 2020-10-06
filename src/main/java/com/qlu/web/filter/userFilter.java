package com.qlu.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.qlu.web.bean.Admin;


@WebFilter(urlPatterns = {"/javamatchlist.jsp","/csubjectlist.jsp" })
public class userFilter implements Filter {

    
    public userFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req  = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Admin user = (Admin) session.getAttribute("user");
		if (user==null) {
			res.sendRedirect(req.getContextPath()+"/studentLogin.jsp?msg=2");
		}else {
		chain.doFilter(request, response);
	}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
