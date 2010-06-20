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
import org.springframework.aop.MethodBeforeAdvice;

import com.king.common.jms.JMSDeskTop;
import com.king.common.jms.JMSLog;
import com.king.common.jms.JMSMessage;
import com.king.tools.DateTool;

public class LogMethodBeforeAdvice implements MethodBeforeAdvice {
	
	/**
	 * 在方法调用前调用。
	 * @param method被调用的方法
	 * @param args 方法参数
	 * @param target 当前对象,可能为null
	 * @throws Throwable 抛出例外时，将中止本操作.
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		JMSLog jmsLog=new JMSLog();
//		jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_INFO);
		jmsLog.setType("aop_methodBefore");
		jmsLog.setUserid("ID001");
		jmsLog.setMethod(method.getName());
		jmsLog.setContent(target.getClass().getName()+"."+method.getName()+"("+args.toString()+")");
//		jmsLog.setContent(target.getClass().getName());
		JMSMessage jmsMsg=new JMSMessage();
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_LOG);
		jmsMsg.setMessageContent(jmsLog);
		LogUtil.info("KSYS", jmsMsg);
		
		//测试DeskTop
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_DESKTOP);
		JMSDeskTop jmsDeskTop=new JMSDeskTop();
//		jmsDeskTop.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsDeskTop.setTime(DateTool.getNow());
		jmsDeskTop.setType(JMSDeskTop.TYPE_ROLE);
		jmsDeskTop.setSender("admin001");
		jmsDeskTop.setRecipients("admin");
		jmsDeskTop.setContent("simulate desktop_message "+DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsMsg.setMessageContent(jmsDeskTop);
		LogUtil.info("KSYS", jmsMsg);
	}

}
