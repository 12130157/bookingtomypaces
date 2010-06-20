/**
 * 分页
 */
package com.king.tools;

public class Page {
	/**
	 * 第一页
	 */
	private Integer first;

	/**
	 * 上一页
	 */
	private Integer previous;

	/**
	 * 下一页
	 */
	private Integer next;

	/**
	 * 最后一页
	 */
	private Integer last;

	/**
	 * 当前页
	 */
	private Integer curPage;

	/**
	 * 是否有上一页
	 */
	private boolean havePrevious;

	/**
	 * 是否有下一页
	 */
	private boolean haveNext;

	/**
	 * 总页数
	 */
	private Integer pageCount;

	/**
	 * 总记录
	 */
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Page(Integer count, Integer curPage, Integer pageSize) {
		init(count, curPage, pageSize);
	}

	public void init(Integer count, Integer curPage, Integer pageSize) {
		Integer allPage = 0;
		if (count > 0) {
			if (count % pageSize == 0)
				allPage = count / pageSize;
			else
				allPage = count / pageSize + 1;

			if (curPage > allPage)
				curPage = allPage;

			this.count = count;
			this.first = 1;
			this.last = allPage;
			this.curPage = curPage;
			this.pageCount = allPage;

			if (1 < curPage) {
				this.havePrevious = true;
				this.previous = curPage - 1;
			} else
				this.havePrevious = false;

			if (allPage != curPage) {
				this.haveNext = true;
				this.next = curPage + 1;
			} else
				this.haveNext = false;
		} else {
			this.count = 0;
			this.first = 1;
			this.last = 1;
			this.curPage = 1;
			this.pageCount = 0;
			this.havePrevious = false;
			this.haveNext = false;
		}

	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getFirst() {
		return first;
	}

	public void setFirst(Integer first) {
		this.first = first;
	}

	public boolean isHaveNext() {
		return haveNext;
	}

	public void setHaveNext(boolean haveNext) {
		this.haveNext = haveNext;
	}

	public boolean isHavePrevious() {
		return havePrevious;
	}

	public void setHavePrevious(boolean havePrevious) {
		this.havePrevious = havePrevious;
	}

	public Integer getLast() {
		return last;
	}

	public void setLast(Integer last) {
		this.last = last;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public Integer getPrevious() {
		return previous;
	}

	public void setPrevious(Integer previous) {
		this.previous = previous;
	}

}
