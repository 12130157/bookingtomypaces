/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.tools;

public class PageRoll {
	/*查询HQL语句，需要自己拼写*/
	private String searchSQL = null;
	/*查询所有记录数的HQL语句，需要自己拼写*/
	private String countSQL = null;
	
	public String getSearchSQL() {
		return searchSQL;
	}

	public void setSearchSQL(String searchSQL) {
		this.searchSQL = searchSQL;
	}

	public String getCountSQL() {
		return countSQL;
	}

	public void setCountSQL(String countSQL) {
		this.countSQL = countSQL;
	}
	/*当前页数*/
	private int currentPage = 0;
	/*每页记录数*/
	private int pageSize = 0;
	/*总记录数*/
	private int totalRows = 0;
	/*开始记录数*/
	private int startRow = 0;
	
	public PageRoll() {
		
	}

	private int totalPage = 0;


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

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
