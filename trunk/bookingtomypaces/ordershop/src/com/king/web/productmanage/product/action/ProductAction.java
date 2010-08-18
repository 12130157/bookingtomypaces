
/**   
* 文件名：ProductAction.java   
*   
* 版本信息：   
* 日期：2010-8-5   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.product.action;

import com.king.base.FrmAction;
import com.king.web.productmanage.product.service.IProductService;
import com.king.web.productmanage.type.service.ITypeService;
import com.king.web.productmanage.unit.service.IUnitService;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：ProductAction   
 * 类描述：   
 * 创建人：tim   
 * 创建时间：2010-8-5 下午01:52:27   
 * 修改人：tim   
 * 修改时间：2010-8-5 下午01:52:27   
 * 修改备注：   
 * @version    
 *    
 */

public class ProductAction extends FrmAction {

	public IProductService productService;
	public ITypeService typeService;
	public IUnitService unitService;
	
	
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public ITypeService getTypeService() {
		return typeService;
	}
	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}
	public IUnitService getUnitService() {
		return unitService;
	}
	public void setUnitService(IUnitService unitService) {
		this.unitService = unitService;
	}
	
	
	
}
