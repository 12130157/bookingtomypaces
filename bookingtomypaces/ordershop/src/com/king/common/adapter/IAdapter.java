/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.adapter;

public interface IAdapter {
	/**
	 * 
	 * @param methodName
	 *        要调用的Service的方法名
	 * @param param
	 *        要调用的Service的方法需要的参数，按照顺序放入一个Object数组；
	 *        UserBean user = new UserBean();
	 *        user.setID("999");
	 *        .....
	 *        OrderBean order = new OrderBean;
	 *        order.setOrderID(orderId);
	 *        Object[] ojbArr = new Object[]{user,order};
	 *        invoke("methodName",objArr,String.class);
	 * @param returnType
	 *        要调用的Service的方法返回值类型，参见param
	 * @return 
	 *        要调用的Service的方法返回值
	 * @throws Exception
	 *        抛出的异常
	 */
	Object[] invoke(String methodName,Object param,Class<?> returnType) throws Exception;
}
