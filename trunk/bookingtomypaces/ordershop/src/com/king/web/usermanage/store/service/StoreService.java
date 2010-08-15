
/**   
* 文件名：StoreService.java   
*   
* 版本信息：   
* 日期：2010-7-1   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.usermanage.store.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.store.dao.IStoreDAO;
import com.king.web.usermanage.store.data.StoreData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：StoreService   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-7-1 下午08:49:22   
 * 修改人：tim   
 * 修改时间：2010-7-1 下午08:49:22   
 * 修改备注：   
 * @version    
 *    
 */

public class StoreService  extends FrmService implements IStoreService {

	private IStoreDAO storeDao;

	/**
	 * 添加店鋪信息
	 * @param u 店鋪信息
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData addStore(StoreData u) throws KINGException{
		storeDao.add(u);
		return u;
	}
	
	/**
	 * 单个删除店鋪信息
	 * @param u 店鋪信息
	 * @throws KINGException
	 */
	public void deleteStore(StoreData u) throws KINGException{
		storeDao.delete(u);
	}
	
	/**
	 * 批量删除店鋪信息
	 * @param ids 店鋪信息ID数组
	 * @throws KINGException
	 */
	public void deleteStore(String[] ids) throws KINGException{
		storeDao.delete(ids);
	}
	
	/**
	 * 修改店鋪信息
	 * @param u 店鋪信息
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData updateStore(StoreData u) throws KINGException{
		storeDao.update(u);
		return u;
	}
	
	/**
	 * 查询单个店鋪信息
	 * @param id 店鋪信息ID
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData retrieveStore(String id) throws KINGException{
		String hql = "from StoreData u where u.id = '" +id+ "'";
		return (StoreData) storeDao.search(hql).get(0);
	}
	
	/**
	 * 查询店鋪信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 店鋪信息集合
	 * @throws KINGException
	 */
	public List<StoreData> searchStores(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from StoreData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = storeDao.searchlist(pageRoll,"");
		return list;
	}

	/**
	 * 查询店鋪信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return 店鋪信息集合
	 * @throws KINGException
	 */
	public List<StoreData> searchStores(PageRoll pageRoll,String withsql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from StoreData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = storeDao.searchlist(pageRoll,withsql);
		return list;
	}
	
	/**
	 * 【新增订单】查询所有状态为0的店鋪信息
	 * @param withsql
	 * @return 店鋪信息集合
	 * @throws KINGException
	 */
	public List<StoreData> searchAllStores(String withsql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from StoreData "+withsql);
		List list = storeDao.search(hql.toString());
		return list;
	}
	/**   
	 * storeDao   
	 *   
	 * @return  the storeDao   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IStoreDAO getStoreDao() {
		return storeDao;
	}

	/**   
	 * @param storeDao the storeDao to set   
	 */
	
	public void setStoreDao(IStoreDAO storeDao) {
		this.storeDao = storeDao;
	}
	
}
