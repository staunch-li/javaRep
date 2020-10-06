package com.qlu.web.until;

public class Regex {
	public static final String UNUM_REG ="^[0-9]{6}$";
	public static final String UNUM_DIS ="学号由6位数字组成";
	
	public static final String UPSW_REG = "^\\w{3,8}$";
	public static final String UPSW_DIS = "密码由3-8位字母数字下滑线组成";
	
	public static final String UNANME_REG ="^[\u4E00-\u9FA5]{2,4}$";
	public static final String UNANME_DIS ="姓名由2-4个汉字组成组成";
	
	public static final String UCOL_REG ="^[\u4E00-\u9FA5]{3,10}$";
	public static final String UCOL_DIS ="学院名由3-10个汉字组成";
	public static final String UCOLNULL_DIS = "学院名不正确";
	
	public static final String UMAJ_REG ="^[\u4E00-\u9FA5]{3,10}$";
	public static final String UMAJ_DIS ="专业名由3-10个汉字组成";
	public static final String UMAJNULL_DIS = "该学院中无此专业";
	public static final String UINPUTNULL_DIS = "输入框不能为null";
}
