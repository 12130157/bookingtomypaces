/**    
* 持久化基础父类,用于声明持久化对象语义。 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import com.king.base.IDao;
import com.king.base.IPersistence;


public abstract class FrmPersistence implements IPersistence {
	/**
	 * 
	 * 返回Dao实例。
	 * 
	 * @param daoName
	 *            Dao名称。
	 */
	public IDao getDao(String daoName) {
		return DaoFactory.getDao(daoName);
	}

}
