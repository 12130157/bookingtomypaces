
/**   
* 文件名：IProductService.java   
*   
* 版本信息：   
* 日期：2010-8-5   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.product.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.productmanage.product.data.ProductData;
import com.king.web.productmanage.type.data.TypeData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：IProductService   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-8-5 下午01:51:58   
 * 修改人：tim   
 * 修改时间：2010-8-5 下午01:51:58   
 * 修改备注：   
 * @version    
 *    
 */

public interface IProductService {

	/**
	 * 添加 产品资料
	 * @param u  产品资料
	 * @return  产品资料
	 * @throws KINGException
	 */
	public ProductData addProduct(ProductData u) throws KINGException;
	
	/**
	 * 单个删除 产品资料
	 * @param u  产品资料
	 * @throws KINGException
	 */
	public void deleteProduct(ProductData u) throws KINGException;
	
	/**
	 * 批量删除 产品资料
	 * @param ids  产品资料ID数组
	 * @throws KINGException
	 */
	public void deleteProduct(String[] ids) throws KINGException;
	
	/**
	 * 修改 产品资料
	 * @param u  产品资料
	 * @return  产品资料
	 * @throws KINGException
	 */
	public ProductData updateProduct(ProductData u) throws KINGException;
	
	/**
	 * 查询单个 产品资料
	 * @param id  产品资料ID
	 * @return  产品资料
	 * @throws KINGException
	 */
	public ProductData retrieveProduct(String id) throws KINGException;
	
	/**
	 * 查询 产品资料
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return  产品资料集合
	 * @throws KINGException
	 */
	public List<ProductData> searchProducts(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 查询 产品资料
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return  产品资料集合
	 * @throws KINGException
	 */
	public List<ProductData> searchProducts(PageRoll pageRoll,String withsql) throws KINGException;
}
