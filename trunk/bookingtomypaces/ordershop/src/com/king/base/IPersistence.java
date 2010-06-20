/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;


/**
 * 持久化层对象基础接口，用作语义声明 PO意思是PersistentObject,在应用系统中的持久化
 * 操作都通过IVWPPO接口提供服务，具体包括：
 * 1.SpringDAO方式调用。 2.Hibernate方式调用。 3.Ibatis方式调用。
 */

public interface IPersistence {
	/**
	 * 
	 * 返回Dao实例。
	 * 
	 * @param daoName
	 *  Dao名称。
	 */
	public IDao getDao(String daoName);
}
