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

	private String userId;//用户ID
	private int funcId;//用户规矩ID
	/**
	 * @return the userId
	 */
	@Column(length = 32,name = "USERID",nullable = true)
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
	 * funcId   
	 *   
	 * @return  the funcId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 4,name = "FUNCID",nullable = true)
	public int getFuncId() {
		return funcId;
	}
	/**   
	 * @param funcId the funcId to set   
	 */
	
	public void setFuncId(int funcId) {
		this.funcId = funcId;
	}
	/**
	 * @return the roleId
	 */
	
	



}
