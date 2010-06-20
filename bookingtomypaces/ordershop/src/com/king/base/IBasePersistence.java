/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.util.List;

import com.king.base.IData;
import com.king.base.IPersistence;
import com.king.tools.PageRoll;

public interface IBasePersistence<T extends IData> extends IPersistence{
		/**
		 * 持久化一个新IData对象到数据库
		 * @param data
		 * 		IData类型的对象，之前未存在于数据库
		 * @throws KINGException
		 * 		持久化中发生的异常
		 */
		public void add(T  data );
		/**
		 * 更新一个IData对象的状态到数据库
		 * @param data
		 * 		IData类型的对象，
		 * 
		 */
		public void update(T data);
		/**
		 * 从数据库中删除一个data对象对应的记录
		 * @param data
		 * 		需要删除的data对象
		 * @throws KINGException
		 * 		删除时发生的异常
		 */
		public void delete(T  data);
		/**
		 * 根据id删除对应的数据库记录
		 * @param id
		 * 		数据库记录的id
		 * @throws KINGException
		 * 		删除时发生的异常
		 */
		public void delete(String id);
		/**
		 * 根据多个id删除数据库中的多条记录
		 * @param ids
		 * 		字符串数组，对应多条数据库记录的id
		 * @throws KINGException
		 * 		删除记录时发生的异常
		 */
		public void delete(String[] ids);
		
		public T load(String id);
		/**
		 * 根据主键id返回data对象
		 * @param id
		 * 		对象的主键id
		 * @return
		 * 		从数据库获取的对应主键id的对象
		 * @throws KINGException
		 * 		查询时发生的异常。
		 */
		public T retrieve(String id);
		/**
		 * 按分页信息查询记录
		 * @param pageRoll
		 * 		分页对象，包含查询的语句
		 * @return
		 * 		List对象，其中的每个对象为符合查询条件和分页条件的数据对象。
		 * @throws KINGException
		 */
		public List<T> search(PageRoll pageRoll);
		/**
		 * 根据hql，查询出符合条件的data对象
		 * @param hql
		 * 		hql语句，需要根据该语句查询数据库
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws KINGException
		 * 		查询时发生的异常。
		 */
		public List<T> search(String hql);
		/**
		 * 根据hql和给出的参数，查询出符合条件的data对象
		 * @param hql
		 * 		hql语句，需要根据该语句查询数据库
		 * @param parameters
		 * 		hql语句中的参数。
		 * @return
		 * 		data对象List，List的每个元素为一个data对象。所有data对象的实际类型是相同的。
		 * @throws KINGException
		 * 		查询时发生的异常。
		 */
		public List<T> search(String hql, Object[] parameters) ;
		/**
		 * 执行sql语句
		 * @param sql
		 * 		sql语句，一般为增删改语句
		 * @return
		 * 		受sql影响的数据库记录行数
		 * @throws KINGException
		 * 		执行sql时发生的一场
		 */
		public int executeSQL(String sql);	
		
		
		public List<T> searchlist(PageRoll pageRoll,String withhql);
}
