/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.jms;

import java.io.Serializable;

import javax.jms.JMSException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import com.king.base.FrmPersistence;
import com.king.base.HibernateDao;
import com.king.tools.DateTool;

public class jmsReciever extends FrmPersistence{
	
	private class MessagePrinterTask implements Runnable {

		private String message;

		public MessagePrinterTask(String message) {
			this.message = message;
		}

		public void run() {
		}

	}

	private TaskExecutor taskExecutor;

	public jmsReciever(TaskExecutor taskExecutor) {
		this.taskExecutor = taskExecutor;
	}

	public void printMessages() {
		taskExecutor.execute(new MessagePrinterTask("Message"));
	}

	public void receive(String msg) {
	}
	
	/**
	 * 异步JMS消息接收器日志消息处理方法
	 * @param Object 消息体
	 * @return 
	 * @throws  
	 */
	public void receiveLog(Object msg) {
		JMSMessage jmsMsg=(JMSMessage) msg;
		JMSLog jmsLog=(JMSLog) jmsMsg.getMessageContent();
		try {
			((HibernateDao)getDao("hibernate")).save(jmsLog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 异步JMS消息接收器桌面消息处理方法
	 * @param Object 消息体
	 * @return 
	 * @throws 
	 */
	public void receiveDeskTop(Object msg) {
		JMSMessage jmsMsg=(JMSMessage) msg;
		JMSDeskTop jmsDeskTop=(JMSDeskTop) jmsMsg.getMessageContent();
		try {
			((HibernateDao)getDao("hibernate")).save(jmsDeskTop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//开始多播消息
		Send send=new Send();
		try {
//			send.send(DateTool.getDateTime(jmsDeskTop.getTime(), "yyyyMMddkkmmssS"));
			send.send((Serializable) msg);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 异步JMS消息接收器邮件消息处理方法
	 * @param Object 消息体
	 * @return 
	 * @throws 
	 */
	public void receiveMail(Object msg) {
	}
	
	/**
	 * 异步JMS消息接收器短信消息处理方法
	 * @param Object 消息体
	 * @return 
	 * @throws 
	 */
	public void receiveSMS(Object msg) {
	}

	/**
	 * 异步JMS消息接收器启动方法
	 * @param 
	 * @return 
	 * @throws 
	 */
	public static void main(String[] args) {
		ApplicationContext listener = new ClassPathXmlApplicationContext(
				"classpath:com/itour/etip/pub/kit/jms/applicationContextListener.xml");
		ApplicationContext datasource = new ClassPathXmlApplicationContext(
				"classpath:com/itour/etip/pub/kit/jms/applicationContext-datasource.xml");
	}
}
