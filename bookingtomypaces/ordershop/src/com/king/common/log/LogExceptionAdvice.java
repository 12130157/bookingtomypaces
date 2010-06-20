/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.log;

import org.springframework.aop.ThrowsAdvice;

import com.king.common.jms.JMSLog;
import com.king.common.jms.JMSMessage;
import com.king.tools.DateTool;

public class LogExceptionAdvice implements ThrowsAdvice {
	
	/**
	 * 当发生Excepion例外时，记录日志。
	 * @param Exception例外
	 */
	public void afterThrowing(Exception ex) {
		//得到异常棧的首个元素
		StackTraceElement stackTraceElement=ex.getStackTrace()[0];
		//文件名
		String File=stackTraceElement.getFileName();
		//出错行号
		int Line=stackTraceElement.getLineNumber();
		//出错方法
		String Method=stackTraceElement.getMethodName();
		
		JMSLog jmsLog=new JMSLog();
//		jmsLog.setId(DateTool.getDateTime("yyyyMMddHHmmssSSS"));
		jmsLog.setTime(DateTool.getNow());
		jmsLog.setLoglevel(JMSLog.LEVEL_FATAL);
		jmsLog.setType("aop");
		jmsLog.setUserid("ID001");
		jmsLog.setMethod(Method);
		jmsLog.setContent(ex.getMessage());
		JMSMessage jmsMsg=new JMSMessage();
		jmsMsg.setMessageType(JMSMessage.MESSAGETYPE_LOG);
		jmsMsg.setMessageContent(jmsLog);
		LogUtil.info("KSYS", jmsMsg);
	}

}
