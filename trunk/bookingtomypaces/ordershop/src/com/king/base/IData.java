/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

public  interface IData{
	/**
	 * 获取对象的id
	 * @return
	 * 	对象的id
	 */	
	public String getId();
	/**
	 * 设置对象的id，由hibernate自动设置
	 * @param id
	 * 	对象的id，由hibernate设置。
	 */
	public void setId(String id);
	/**
	 *  获取对象的版本戳
	 * @return 
	 * 	int类型参数，标识对象在数据库中对应记录的版本
	 */	
	public Integer getVersion();
	
	/**
	 * 设置对象的版本戳
	 * @param version
	 * 	版本戳，不需要手工设置，由hibernate自动设置
	 */
	public void setVersion(Integer version);
}
