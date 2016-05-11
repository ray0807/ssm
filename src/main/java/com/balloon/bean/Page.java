package com.balloon.bean;

/**
 * 
 * @author Administrator
 *
 */
public class Page {
	public Page(int currentPage, int pageSize, int totalPage) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}

	public int currentPage;
	public int pageSize;
	public int totalPage;
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize + ", totalPage=" + totalPage + "]";
	}

}
