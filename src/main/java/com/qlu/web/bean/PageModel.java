 package com.qlu.web.bean;

import java.util.List;

public class PageModel<T> {
	private int currentPage = 1;//分页查询的当前页!
	private int pageSize = 5;//每页显示的数据条数!
	private int counts;//数据总条数! 需要查询数据库!
	private int totalPage;//总页数 
	private int first;//是否显示  首页 按钮的标志!  
	private int last;//是否显示 尾页 按钮的标志! 
	private int previous;//是否显示 上一页按钮的标志! 
	private int next;//是否显示 下一页按钮的标志!  
	private List<T> datas;//每一页的数据 
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getPrevious() {
		return previous;
	}
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public PageModel() {
		// TODO Auto-generated constructor stub
	}
	
}
