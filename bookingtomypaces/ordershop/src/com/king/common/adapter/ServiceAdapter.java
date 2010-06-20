/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.adapter;

import java.lang.reflect.Method;

import com.king.base.IService;

public class ServiceAdapter implements IAdapter {
	private IService service;
	public IService getService() {
		return service;
	}
	public void setService(IService service) {
		this.service = service;
	}
	public Object[] invoke(String methodName, Object param, Class<?> returnType) throws Exception {
		Method method = service.getClass().getMethod(methodName, param.getClass());
		Object objReturn[] = new Object[]{method.invoke(service,param)};
		return objReturn;
	}
	
	

}
