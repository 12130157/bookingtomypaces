/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.adapter;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class WebServiceAdapter implements IAdapter {
	String targetNamespace;
	private RPCServiceClient serviceClient;
	private Options options;
	private String endPointReference;
	
	public String getEndPointReference() {
		return endPointReference;
	}

	public void setEndPointReference(String endPointReference) {
		this.endPointReference = endPointReference;
	}


	public Object[] invokeOp(String targetNamespace, String opName,
			Object[] opArgs, Class<?>[] opReturnType) throws AxisFault,
			ClassNotFoundException {
		QName opQName = new QName(targetNamespace, opName);
		return serviceClient.invokeBlocking(opQName, opArgs, opReturnType);
	}

	public String getTargetNamespace() {
		return targetNamespace;
	}

	public void setTargetNamespace(String targetNamespace) {
		this.targetNamespace = targetNamespace;
	}

	public Object[] invoke(String methodName, Object param, Class<?> returnType)
			throws Exception {
		
		Object response[] = null;
		try {
			System.out.println("================================");
			serviceClient = new RPCServiceClient();
			options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference(endPointReference);
			options.setTo(targetEPR);
			
			Object[] opArgs = new Object[]{param};
			Class<?>[] opReturnType = new Class[]{returnType};
			
			response = invokeOp(targetNamespace, methodName, opArgs, opReturnType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

}
