package com.jiajiaohello.support.web;

/**
 * User: bohan
 * Date: 9/16/14
 * Time: 10:51 AM
 */
public class Pager {
	int page = 1; // 页号

	int total = -1; // 记录总数

	int size = 20; // 每页显示记录数

	public Pager() {
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int  getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getAllPage() {
		int allPage = 0;
		if (total != 0 && total % size == 0) {
			allPage = (int)(total / size);
		} else {
			allPage = (int)(total / size) + 1;
		}
		return allPage;
	}

	public int getOffset() {
		return (page - 1) * size;
	}
	public Integer getMaxResult(){
		int maxresult=getOffset()+size;
		return maxresult>=total?total:maxresult;
	}
	public Integer getPrePage() {
		return page == 1 ? null : page - 1;
	}

	public Integer getNextPage() {
		int allPage = getAllPage();
		return page == allPage || allPage == 0 ? null : page+1;
	}
}
