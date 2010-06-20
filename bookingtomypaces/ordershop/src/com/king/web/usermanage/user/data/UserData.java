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

	private int deptId;//部门ID
	private String userName;//用户名称
	private String passWord;//用户密码 
	private int status;//状态
	private java.util.Date lastTime;//最后登录时间 
	private String lastIp;//最后登录IP
	private java.util.Date creatTime;//创建时间
	
	/**
	 * @return the unitId
	 */
	@Column(length = 4,name = "DEPTID",nullable = true)
	public int getDeptId() {
		return deptId;
	}
	/**
	 * @param unitId the unitId to set
	 */
	public void setDeptId(int deptId) {
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

}
