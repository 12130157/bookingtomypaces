/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.log;

import com.king.common.jms.JMSDeskTop;
import com.king.common.jms.JMSLog;
import com.king.common.jms.JMSMessage;
import com.king.tools.DateTool;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LogInterceptor implements Interceptor {
	
	/**
	* 拦截方法
	* @param invocation 当前调用的方法。
    */
	public String intercept(ActionInvocation invocation) throws Exception {
		// 在Action调用前
		String result = invocation.invoke();
		// 在Action调用后
		JMSLog jmsLog=new JMSLog();
//		jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_INFO);
		jmsLog.setType("intercept");
		jmsLog.setUserid("ID001");
		jmsLog.setMethod("action");
		jmsLog.setContent(invocation.getAction().getClass().getName());
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
		jmsDeskTop.setContent("update date");
		jmsMsg.setMessageContent(jmsDeskTop);
		LogUtil.info("KSYS", jmsMsg);
		//测试Mail
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_MAIL);
		LogUtil.info("KSYS", jmsMsg);
		//测试SMS
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_SMS);
		LogUtil.info("KSYS", jmsMsg);
		
		return result;
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

}