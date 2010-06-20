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
@Table(name = "Role")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RoleData extends FrmData {

	private String name;//名字
	private String memo;//描述
	/**
	 * @return the name
	 */
	@Column(length = 64,name = "NAME",nullable = true)
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the memo
	 */
	@Column(length = 128,name = "MEMO",nullable = true)
	public String getMemo() {
		return memo;
	}
	/**
	 * @param memo the memo to set
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
