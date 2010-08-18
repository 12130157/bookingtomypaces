
/**   
* 文件名：ProductService.java   
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

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.productmanage.product.dao.IProductDAO;
import com.king.web.productmanage.product.data.ProductData;
import com.king.web.productmanage.type.dao.ITypeDAO;
import com.king.web.productmanage.type.data.TypeData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：ProductService   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-8-5 下午01:52:12   
 * 修改人：tim   
 * 修改时间：2010-8-5 下午01:52:12   
 * 修改备注：   
 * @version    
 *    
 */

public class ProductService extends FrmService implements IProductService{

	private IProductDAO productDao;
	/**
	 * 添加 产品信息
	 * @param u  产品信息
	 * @return  产品信息
	 * @throws KINGException
	 */
	public ProductData addProduct(ProductData u) throws KINGException{
		productDao.add(u);
		return u;
	}
	
	/**
	 * 单个删除 产品信息
	 * @param u  产品信息
	 * @throws KINGException
	 */
	public void deleteProduct(ProductData u) throws KINGException{
		productDao.delete(u);
	}
	
	/**
	 * 批量删除 产品信息
	 * @param ids  产品信息ID数组
	 * @throws KINGException
	 */
	public void deleteProduct(String[] ids) throws KINGException{
		productDao.delete(ids);
	}
	
	/**
	 * 修改 产品信息
	 * @param u  产品信息
	 * @return  产品信息
	 * @throws KINGException
	 */
	public ProductData updateProduct(ProductData u) throws KINGException{
		productDao.update(u);
		return u;
	}
	
	/**
	 * 查询单个 产品信息
	 * @param id  产品信息ID
	 * @return  产品信息
	 * @throws KINGException
	 */
	public ProductData retrieveProduct(String id) throws KINGException{
		ProductData u=productDao.retrieve(id);
		return u;
	}
	
	/**
	 * 查询 产品信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return  产品信息集合
	 * @throws KINGException
	 */
	public List<ProductData> searchProducts(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from ProductData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = productDao.searchlist(pageRoll,"");
		return list;
	}
	
	/**
	 * 查询 产品信息
	 * @param pageRoll 分页所需要的对象
	 * @param withsql
	 * @return  产品信息集合
	 * @throws KINGException
	 */
	public List<ProductData> searchProducts(PageRoll pageRoll,String withsql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from ProductData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = productDao.searchlist(pageRoll,withsql);
		return list;
	}

	public IProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(IProductDAO productDao) {
		this.productDao = productDao;
	}


	
}
