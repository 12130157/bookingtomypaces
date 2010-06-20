/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.web.usermanage.role.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "RoleFunction")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleFunctionData extends FrmData {

	private int roleId;//规矩ID
	private int functionId;//功能ID
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
	/**
	 * @return the functionId
	 */
	@Column(length = 4,name = "FUNCTIONID",nullable = true)
	public int getFunctionId() {
		return functionId;
	}
	/**
	 * @param functionId the functionId to set
	 */
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	
	
}
