
/**   
* 文件名：TypeData.java   
*   
* 版本信息：   
* 日期：2010-7-27   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.type.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：TypeData   
 * 类描述：   产品类别
 * 创建人：tim   
 * 创建时间：2010-7-27 下午08:25:51   
 * 修改人：tim   
 * 修改时间：2010-7-27 下午08:25:51   
 * 修改备注：   
 * @version    
 *    
 */
@Entity()
@Table(name = "ProductType")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TypeData extends FrmData{

	private String name;       //类别名称
	private String memo;       //类别描述
	private int status;        //状态
	private String perentId;   //父ID
	private int level;         //类别等级
	private String method;     //计算方法
	
	@Column(length = 50,name = "name",nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 200,name = "memo",nullable = true)
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	@Column(length = 4,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(length = 50,name = "perentId",nullable = true)
	public String getPerentId() {
		return perentId;
	}
	public void setPerentId(String perentId) {
		this.perentId = perentId;
	}
	
	@Column(length = 30,name = "level",nullable = true)
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	@Column(length = 200,name = "method",nullable = true)
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
