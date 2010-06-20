/**   
* 文件名：UserVo.java   
*   
* 版本信息：   
* 日期：2010-4-9   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.web.usermanage.user.vo;

import java.util.Date;

public class UserVo {
	
	private int unitId;//部门ID
	private String userName;//用户名称
	private String passWord;//用户密码 
	private int status;//状态
	private java.util.Date lastTime;//最后登录时间 
	private String lastIp;//最后登录IP
	private java.util.Date creatTime;//创建时间	
	private Integer curPage;
	private Integer pageSize;
 
	/**   
	* 创建一个新的实例 UserVo.   
	*      
	*/
	public UserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**   
	* 创建一个新的实例 UserVo.   
	*   
	* @param unitId
	* @param userName
	* @param passWord
	* @param status
	* @param lastTime
	* @param lastIp
	* @param creatTime
	* @param curPage
	* @param pageSize   
	*/
	public UserVo(int unitId, String userName, String passWord, int status,
			Date lastTime, String lastIp, Date creatTime, Integer curPage,
			Integer pageSize) {
		this.unitId = unitId;
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
		this.creatTime = creatTime;
		this.curPage = curPage;
		this.pageSize = pageSize;
	}
	
	public int getUnitId() {
		return unitId;
	}

	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public java.util.Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public java.util.Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
