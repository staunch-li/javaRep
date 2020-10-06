package com.qlu.web.until;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * 使用Druid连接池来获取连接的工具类
 * 约定: 在当前应用中使用 此类 来获取 连接池对象 或者 连接池里的连接对象
 * @author Administrator
 *
 */
public class DruidUtil {
	
	//Druid使用 properties文件 做配置文件 ,Properties集合 读取配置文件
	private static Properties prop = new Properties();
	
	private static DataSource dataSource;
	
	static {
		//类路径下的文件 使用 列加载器读取 
		InputStream is = DruidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
		try {
			prop.load(is);
			//druid连接池工厂创建连接池对象
			dataSource = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("PoolUtil: 加载druid配置文件失败!");
		} 
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 获取连接池里的 连接代理对象 
	 * @return  JDBC连接对象 在 连接池里的代理对象
	 */
	public static Connection getCon() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("durid连接池不想给你连接!");
		}
	}
	
	//对JDBC里要关闭的资源 进行关闭 !  如果增删改就没有结果集,如果是查询则有结果集!
	public static void closeAll(ResultSet rs , Statement stmt , Connection con) {
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
