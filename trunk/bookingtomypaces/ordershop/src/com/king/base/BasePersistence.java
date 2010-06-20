/**    
*   
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.king.base.IData;
import com.king.base.IBasePersistence;
import com.king.tools.PageRoll;

public abstract class BasePersistence<T extends IData> extends FrmPersistence implements
		IBasePersistence<T> {
	private Class<T> dataClass;
	/**
	 * 默认构造参数，确定dataClass的类型。
	 *
	 */
	public BasePersistence() {
		this.dataClass = (Class<T>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getDataClass() {
		return dataClass;
	}
	
	public void add(T data){
		((HibernateDao) DaoFactory.getDao("hibernate")).save(data);
	}
	
	public void update(T data) {
		((HibernateDao) DaoFactory.getDao("hibernate")).update(data);
	}
	
	public void delete(T data) {
		((HibernateDao) DaoFactory.getDao("hibernate")).delete(data);
	}
	
	/**
	 * 通过id删除对象
	 * @param id
	 * 		需要删除的对象的主键id
	 * 
	 */
	public void delete(String id){
		T data = (T) ((HibernateDao) DaoFactory
				.getDao("hibernate")).load(getDataClass(), id);
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
		return ((HibernateDao) DaoFactory.getDao("hibernate")).updateBySQL(sql);
	}

	public T load(String id)  {		
		return (T) ((HibernateDao) DaoFactory.getDao("hibernate"))
				.load(getDataClass(), id);
	}

	public T retrieve(String id)  {
		return (T) ((HibernateDao) DaoFactory.getDao("hibernate"))
				.retrieve(getDataClass(), id);
	}

	public List<T> search(PageRoll pageRoll)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(pageRoll);
	}

	public List<T> search(String hql)  {	
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql);
	}

	public List<T> search(String hql, Object[] parameters)  {
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql, parameters);
	}

	public List<T> searchlist(PageRoll pageRoll,String withhql){
		return (List<T>)((HibernateDao) DaoFactory.getDao("hibernate")).searchlist(pageRoll,withhql);
	}
}
