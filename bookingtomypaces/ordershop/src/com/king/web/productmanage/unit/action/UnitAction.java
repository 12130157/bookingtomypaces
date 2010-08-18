
/**   
* 文件名：UnitAction.java   
*   
* 版本信息：   
* 日期：2010-8-1   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.unit.action;

import com.king.base.FrmAction;
import com.king.web.productmanage.unit.service.IUnitService;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：UnitAction   
 * 类描述：产品单位
 * 创建人：tim   
 * 创建时间：2010-8-1 上午02:42:07   
 * 修改人：tim   
 * 修改时间：2010-8-1 上午02:42:07   
 * 修改备注：   
 * @version    
 *    
 */

public class UnitAction extends FrmAction{

	public IUnitService unitService;

	public IUnitService getUnitService() {
		return unitService;
	}

	public void setUnitService(IUnitService unitService) {
		this.unitService = unitService;
	}
	
}
