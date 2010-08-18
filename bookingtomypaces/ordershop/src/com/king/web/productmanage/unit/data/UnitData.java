
/**   
* 文件名：UnitData.java   
*   
* 版本信息：   
* 日期：2010-7-27   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.unit.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：UnitData   
 * 类描述：   产品单位
 * 创建人：tim   
 * 创建时间：2010-7-27 下午08:14:47   
 * 修改人：tim   
 * 修改时间：2010-7-27 下午08:14:47   
 * 修改备注：   
 * @version    
 *    
 */

@Entity()
@Table(name = "ProductUnit")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UnitData extends FrmData {

	private int unitNum;        //单位编号
	private String unitName;    //单位名称
	private String unitRemark;  //单位描述
	private int status;         //状态
	
	@Column(length = 4,name = "unitNum",nullable = true)
	public int getUnitNum() {
		return unitNum;
	}
	public void setUnitNum(int unitNum) {
		this.unitNum = unitNum;
	}
	
	@Column(length = 50,name = "unitName",nullable = true)
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	@Column(length = 200,name = "unitRemark",nullable = true)
	public String getUnitRemark() {
		return unitRemark;
	}
	public void setUnitRemark(String unitRemark) {
		this.unitRemark = unitRemark;
	}
	
	@Column(length = 4,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
