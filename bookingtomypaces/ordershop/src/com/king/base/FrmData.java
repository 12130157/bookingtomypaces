/**    
*  
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.king.base.IData;


@MappedSuperclass
public abstract class FrmData implements IData{
	/**
	 * id:数据的主键
	 */	
	protected String id;
	
	@Id
	@Column(name="ID", length = 32, nullable = false)
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid.hex")
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * 版本戳,自增长，保存一次增一
	 */
	@Version
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
}
