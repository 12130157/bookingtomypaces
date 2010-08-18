
/**   
* 文件名：ITypeService.java   
*   
* 版本信息：   
* 日期：2010-8-5   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.type.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.productmanage.type.data.TypeData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：ITypeService   
 * 类描述：   产品类型接口
 * 创建人：tim   
 * 创建时间：2010-8-5 下午01:40:12   
 * 修改人：tim   
 * 修改时间：2010-8-5 下午01:40:12   
 * 修改备注：   
 * @version    
 *    
 */

public interface ITypeService {


	/**
	 * 添加 产品类型
	 * @param u  产品类型
	 * @return  产品类型
	 * @throws KINGException
	 */
	public TypeData addType(TypeData u) throws KINGException;
	
	/**
	 * 单个删除 产品类型
	 * @param u  产品类型
	 * @throws KINGException
	 */
	public void deleteType(TypeData u) throws KINGException;
	
	/**
	 * 批量删除 产品类型
	 * @param ids  产品类型ID数组
	 * @throws KINGException
	 */
	public void deleteType(String[] ids) throws KINGException;
	
	/**
	 * 修改 产品类型
	 * @param u  产品类型
	 * @return  产品类型
	 * @throws KINGException
	 */
	public TypeData updateType(TypeData u) throws KINGException;
	
	/**
	 * 查询单个 产品类型
	 * @param id  产品类型ID
	 * @return  产品类型
	 * @throws KINGException
	 */
	public TypeData retrieveType(String id) throws KINGException;
	
	/**
	 * 查询 产品类型
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return  产品类型集合
	 * @throws KINGException
	 */
	public List<TypeData> searchTypes(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询 产品类型
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return  产品类型集合
	 * @throws KINGException
	 */
	public List<TypeData> searchTypes(PageRoll pageRoll,String withsql) throws KINGException;
}
