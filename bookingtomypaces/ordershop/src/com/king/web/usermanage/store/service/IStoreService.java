
/**   
* 文件名：IStoreService.java   
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

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.store.data.StoreData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：IStoreService   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-7-1 下午08:49:06   
 * 修改人：tim   
 * 修改时间：2010-7-1 下午08:49:06   
 * 修改备注：   
 * @version    
 *    
 */

public interface IStoreService {

	
	/**
	 * 添加店鋪信息
	 * @param u 店鋪信息
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData addStore(StoreData u) throws KINGException;
	
	/**
	 * 单个删除店鋪信息
	 * @param u 店鋪信息
	 * @throws KINGException
	 */
	public void deleteStore(StoreData u) throws KINGException;
	
	/**
	 * 批量删除店鋪信息
	 * @param ids 店鋪信息ID数组
	 * @throws KINGException
	 */
	public void deleteStore(String[] ids) throws KINGException;
	
	/**
	 * 修改店鋪信息
	 * @param u 店鋪信息
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData updateStore(StoreData u) throws KINGException;
	
	/**
	 * 查询单个店鋪信息
	 * @param id 店鋪信息ID
	 * @return 店鋪信息
	 * @throws KINGException
	 */
	public StoreData retrieveStore(String id) throws KINGException;
	
	/**
	 * 查询店鋪信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 店鋪信息集合
	 * @throws KINGException
	 */
	public List<StoreData> searchStores(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询店鋪信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return 店鋪信息集合
	 * @throws KINGException
	 */
	public List<StoreData> searchStores(PageRoll pageRoll,String withsql) throws KINGException;
	

	
	
}
