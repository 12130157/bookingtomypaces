
/**   
* 文件名：TypeAction.java   
*   
* 版本信息：   
* 日期：2010-8-5   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.type.action;

import com.king.base.FrmAction;
import com.king.web.productmanage.type.service.ITypeService;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：TypeAction   
 * 类描述：產品類型
 * 创建人：tim   
 * 创建时间：2010-8-5 下午01:40:45   
 * 修改人：tim   
 * 修改时间：2010-8-5 下午01:40:45   
 * 修改备注：   
 * @version    
 *    
 */

public class TypeAction extends FrmAction{
	public ITypeService typeService;

	public ITypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(ITypeService typeService) {
		this.typeService = typeService;
	}
	
}
