
/**   
* 文件名：BasePersistenceOne.java   
*   
* 版本信息：   
* 日期：2010-7-11   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.king.tools.PageRoll;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：BasePersistenceOne   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-7-11 上午02:24:05   
 * 修改人：tim   
 * 修改时间：2010-7-11 上午02:24:05   
 * 修改备注：   
 * @version    
 *    
 */

public abstract class BasePersistenceOne <T extends IData> extends FrmPersistence implements
IBasePersistence<T> {

	private Class<T> dataClass;
	/**
	 * 默认构造参数，确定dataClass的类型。
	 *
	 */
	public BasePersistenceOne() {
		this.dataClass = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getDataClass() {
		return dataClass;
	}
	
	public void add(T data){
		((HibernateDao) DaoFactory.getDao("hibernateone")).save(data);
	}
	
	public void update(T data) {
		((HibernateDao) DaoFactory.getDao("hibernateone")).update(data);
	}
	
	public void delete(T data) {
		((HibernateDao) DaoFactory.getDao("hibernateone")).delete(data);
	}
	
	/**
	 * 通过id删除对象
	 * @param id
	 * 		需要删除的对象的主键id
	 * 
	 */
	public void delete(String id){
		T data = (T) ((HibernateDao) DaoFactory
				.getDao("hibernateone")).load(getDataClass(), id);
		//当查询出的对象不为空时，才执行删除操作
		if(data != null) {
			delete(data);
		}
	}

	public void delete(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			T data = (T)load(ids[i]);
			if(data != null) {
				delete(data);
			}
		}
	}

	public int executeSQL(String sql)  {
		return ((HibernateDao) DaoFactory.getDao("hibernateone")).updateBySQL(sql);
	}

	public T load(String id)  {		
		return (T) ((HibernateDao) DaoFactory.getDao("hibernateone"))
				.load(getDataClass(), id);
	}

	public T retrieve(String id)  {
		return (T) ((HibernateDao) DaoFactory.getDao("hibernateone"))
				.retrieve(getDataClass(), id);
	}

	public List<T> search(PageRoll pageRoll)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernateone")).search(pageRoll);
	}

	public List<T> search(String hql)  {	
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernateone")).search(hql);
	}

	public List<T> search(String hql, Object[] parameters)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernateone")).search(hql, parameters);
	}

	public List<T> searchlist(PageRoll pageRoll,String withhql){
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernateone")).searchlist(pageRoll,withhql);
	}
}
