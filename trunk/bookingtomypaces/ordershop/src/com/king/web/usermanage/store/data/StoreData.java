
/**   
* 文件名：StoreData.java   
*   
* 版本信息：   
* 日期：2010-7-1   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.usermanage.store.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：StoreData   
 * 类描述：   
 * 创建人：Tim  
 * 创建时间：2010-7-1 下午08:06:20   
 * 修改人：Tim   
 * 修改时间：2010-7-1 下午08:06:20   
 * 修改备注：   
 * @version    
 *    
 */
@Entity()
@Table(name = "Store")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StoreData extends FrmData {

	
	private String name;//店鋪名称
	
	private String shortName;//英文簡稱
	
	private String address;//店鋪地址
	
	private String managerName;//店長姓名
	
	private String managerMobile;//店長電話
	
	private int status;//狀態
	/**   
	 * name   
	 *   
	 * @return  the name   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 255,name = "name",nullable = true)
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
	 * shortName   
	 *   
	 * @return  the shortName   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 150,name = "shortName",nullable = true)
	public String getShortName() {
		return shortName;
	}
	/**   
	 * @param shortName the shortName to set   
	 */
	
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**   
	 * address   
	 *   
	 * @return  the address   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 350,name = "address",nullable = true)
	public String getAddress() {
		return address;
	}
	/**   
	 * @param address the address to set   
	 */
	
	public void setAddress(String address) {
		this.address = address;
	}
	/**   
	 * managerName   
	 *   
	 * @return  the managerName   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 50,name = "managerName",nullable = true)
	public String getManagerName() {
		return managerName;
	}
	/**   
	 * @param managerName the managerName to set   
	 */
	
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**   
	 * managerMobile   
	 *   
	 * @return  the managerMobile   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 50,name = "managerMobile",nullable = true)
	public String getManagerMobile() {
		return managerMobile;
	}
	/**   
	 * @param managerMobile the managerMobile to set   
	 */
	
	public void setManagerMobile(String managerMobile) {
		this.managerMobile = managerMobile;
	}
	/**   
	 * status   
	 *   
	 * @return  the status   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	@Column(length = 1,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	/**   
	 * @param status the status to set   
	 */
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
