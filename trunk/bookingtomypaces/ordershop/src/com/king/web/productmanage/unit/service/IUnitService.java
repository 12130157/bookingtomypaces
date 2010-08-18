
/**   
* 文件名：IUnitService.java   
*   
* 版本信息：   
* 日期：2010-8-1   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.unit.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.productmanage.unit.data.UnitData;
import com.king.web.usermanage.role.data.RoleFunctionData;
import com.king.web.usermanage.role.data.RoleFunctionData1;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：IUnitService   
 * 类描述： 产品单位
 * 创建人：tim   
 * 创建时间：2010-8-1 上午02:39:14   
 * 修改人：tim   
 * 修改时间：2010-8-1 上午02:39:14   
 * 修改备注：   
 * @version    
 *    
 */

public interface IUnitService {

	
	/**
	 * 添加 产品单位
	 * @param u  产品单位
	 * @return  产品单位
	 * @throws KINGException
	 */
	public UnitData addUnit(UnitData u) throws KINGException;
	
	/**
	 * 单个删除 产品单位
	 * @param u  产品单位
	 * @throws KINGException
	 */
	public void deleteUnit(UnitData u) throws KINGException;
	
	/**
	 * 批量删除 产品单位
	 * @param ids  产品单位ID数组
	 * @throws KINGException
	 */
	public void deleteUnit(String[] ids) throws KINGException;
	
	/**
	 * 修改 产品单位
	 * @param u  产品单位
	 * @return  产品单位
	 * @throws KINGException
	 */
	public UnitData updateUnit(UnitData u) throws KINGException;
	
	/**
	 * 查询单个 产品单位
	 * @param id  产品单位ID
	 * @return  产品单位
	 * @throws KINGException
	 */
	public UnitData retrieveUnit(String id) throws KINGException;
	
	/**
	 * 查询 产品单位
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return  产品单位集合
	 * @throws KINGException
	 */
	public List<UnitData> searchUnits(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询 产品单位
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return  产品单位集合
	 * @throws KINGException
	 */
	public List<UnitData> searchUnits(PageRoll pageRoll,String withsql) throws KINGException;
	
	
	
	
}
