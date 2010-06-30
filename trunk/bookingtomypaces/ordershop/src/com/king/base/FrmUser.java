/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.util.Date;

public class FrmUser {
	/**
	 * 部门ID
	 */
	private String deptId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户密码 
	 */
	private String passWord;
	/**
	 * 状态 
	 */
	private int status;
	/**
	 * 用户名称 
	 */
	private String realName;
	/**
	 * 手機
	 */
	private String mobile;
	/**
	 * 地區ID
	 */
	private String areaId;
	/**
	 * 店面ID
	 */
	private String shopId;
	/**
	 * 是否總店；1：總店，2：分店 
	 */
	private int isHeadOffice;
	
	private java.util.Date lastTime;//最后登录时间 
	private String lastIp;//最后登录IP
	/**   
	 * deptId   
	 *   
	 * @return  the deptId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getDeptId() {
		return deptId;
	}
	/**   
	 * @param deptId the deptId to set   
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**   
	 * userId   
	 *   
	 * @return  the userId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getUserId() {
		return userId;
	}
	/**   
	 * @param userId the userId to set   
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**   
	 * userName   
	 *   
	 * @return  the userName   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getUserName() {
		return userName;
	}
	/**   
	 * @param userName the userName to set   
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**   
	 * passWord   
	 *   
	 * @return  the passWord   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getPassWord() {
		return passWord;
	}
	/**   
	 * @param passWord the passWord to set   
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**   
	 * status   
	 *   
	 * @return  the status   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public int getStatus() {
		return status;
	}
	/**   
	 * @param status the status to set   
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the areaId
	 */
	public String getAreaId() {
		return areaId;
	}
	/**
	 * @param areaId the areaId to set
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	/**
	 * @return the shopId
	 */
	public String getShopId() {
		return shopId;
	}
	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	/**
	 * @return the isHeadOffice
	 */
	public int getIsHeadOffice() {
		return isHeadOffice;
	}
	/**
	 * @param isHeadOffice the isHeadOffice to set
	 */
	public void setIsHeadOffice(int isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	}
	/**
	 * @return the lastTime
	 */
	public java.util.Date getLastTime() {
		return lastTime;
	}
	/**
	 * @param lastTime the lastTime to set
	 */
	public void setLastTime(java.util.Date lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * @return the lastIp
	 */
	public String getLastIp() {
		return lastIp;
	}
	/**
	 * @param lastIp the lastIp to set
	 */
	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}
	/**
	 * @param deptId
	 * @param userId
	 * @param userName
	 * @param passWord
	 * @param status
	 * @param realName
	 * @param mobile
	 * @param areaId
	 * @param shopId
	 * @param isHeadOffice
	 * @param lastTime
	 * @param lastIp
	 */
	public FrmUser(String deptId, String userId, String userName,
			String passWord, int status, String realName, String mobile,
			String areaId, String shopId, int isHeadOffice, Date lastTime,
			String lastIp) {
		this.deptId = deptId;
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
		this.realName = realName;
		this.mobile = mobile;
		this.areaId = areaId;
		this.shopId = shopId;
		this.isHeadOffice = isHeadOffice;
		this.lastTime = lastTime;
		this.lastIp = lastIp;
	}
	
	  
	
	
	
	
	
		
}
