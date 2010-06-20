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
@Table(name = "UserRole")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserRoleData extends FrmData{

	private int userId;//用户ID
	private int roleId;//用户规矩ID
	/**
	 * @return the userId
	 */
	@Column(length = 4,name = "USERID",nullable = true)
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the roleId
	 */
	@Column(length = 4,name = "ROLEID",nullable = true)
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



}
