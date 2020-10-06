package com.qlu.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.qlu.web.until.Getmy;


@WebListener
public class AppListener implements ServletContextListener {

   
    public AppListener() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext application = sce.getServletContext();
    	application.setAttribute("photopath", "http://localhost:9090/web/photo");
    	application.setAttribute("filepath", "http://localhost:9090/web/picture");
    	application.setAttribute("locale", "zh_CN");
    	for (String data : Getmy.getDatas()) {
			String[] ss = data.split("=");
			if ("filepath".equals(ss[0])) {
				application.setAttribute("filepath", ss[1]);
			}
		}
    }
	
}
