/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.log;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

import com.king.common.jms.JMSLog;
import com.king.common.jms.JMSMessage;
import com.king.tools.DateTool;

public class LogAfterReturningAdvice implements  AfterReturningAdvice {
	
	/**
	 * 当方法被成功执行后调用。
	 * @param returnValue 方法的返回值
	 * @param method 当前被调用的方法
	 * @param args 调用方法的参数。
	 * @param target 当前方法依赖的对象。
	 * @throws Throwable 抛出例外时，将中止本操作.
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args,
			Object target) throws Throwable {
		JMSLog jmsLog=new JMSLog();
//		jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_INFO);
		jmsLog.setType("aop_afterReturning");
		jmsLog.setUserid("ID001");
		jmsLog.setMethod(method.getName());
		jmsLog.setContent(target.getClass().getName()+"."+method.getName()+"("+args.toString()+")="+returnValue.toString());
		JMSMessage jmsMsg=new JMSMessage();
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_LOG);
		jmsMsg.setMessageContent(jmsLog);
		LogUtil.info("KSYS", jmsMsg);
	}
}

