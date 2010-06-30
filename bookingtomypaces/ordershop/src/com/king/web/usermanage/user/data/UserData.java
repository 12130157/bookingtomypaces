/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.web.usermanage.user.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "UserInfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserData extends FrmData {

	private String deptId;//部门ID
	private String userName;//登錄名稱
	private String realName;//用户名称
	private String passWord;//用户密码 
	private int status;//状态
	private java.util.Date lastTime;//最后登录时间 
	private String lastIp;//最后登录IP
	private java.util.Date creatTime;//创建时间
	private String mobile;//手機
	private String areaId;//地區ID
	private String shopId;//店面ID
	private int isHeadOffice;//是否總店；1：總店，2：分店
	
	/**
	 * @return the unitId
	 */
	@Column(length = 32,name = "DEPTID",nullable = true)
	public String getDeptId() {
		return deptId;
	}
	/**
	 * @param unitId the unitId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	/**
	 * @return the userName
	 */
	@Column(length = 128,name = "USERNAME",nullable = true)
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
	 * @return the passWord
	 */
	@Column(length = 128,name = "PASSWORD",nullable = true)
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
	 * @return the status
	 */
	@Column(length = 4,name = "STATUS",nullable = true)
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
	 * @return the lastTime
	 */
	@Column(name = "LASTTIME",nullable = true)
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
	@Column(length = 128,name = "LASTIP",nullable = true)
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
	 * @return the creatTime
	 */
	@Column(name = "CREATTIME",nullable = true)
	public java.util.Date getCreatTime() {
		return creatTime;
	}
	/**
	 * @param creatTime the creatTime to set
	 */
	public void setCreatTime(java.util.Date creatTime) {
		this.creatTime = creatTime;
	}
	/**
	 * @return the realName
	 */
	@Column(length = 128,name = "REALNAME",nullable = true)
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
	@Column(length = 50,name = "MOBILE",nullable = true)
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
	@Column(length = 32,name = "AREAID",nullable = true)
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
	@Column(length = 32,name = "SHOPID",nullable = true)
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
	@Column(length = 4,name = "ISHEADOFFICE",nullable = false)
	public int getIsHeadOffice() {
		return isHeadOffice;
	}
	/**
	 * @param isHeadOffice the isHeadOffice to set
	 */
	public void setIsHeadOffice(int isHeadOffice) {
		this.isHeadOffice = isHeadOffice;
	}
	
	

	
}
