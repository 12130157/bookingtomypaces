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

public class JMSMessage implements Serializable {
	
	/**
	 * 消息类型
	 * 按照现有接口规范允许使用的值有如下4种：
	 * <p>(日志)JMSMessage.MESSAGETYPE_LOG</p>
	 * <p>(邮件)JMSMessage.MESSAGETYPE_MAIL</p>
	 * <p>(短信)JMSMessage.MESSAGETYPE_SMS</p>
	 * <p>(桌面消息)JMSMessage.MESSAGETYPE_DESKTOP</p>
	 */
	private String messageType;
	/**
	 * 消息体
	 * <p>消息体按照现有接口规范允许使用的值有如下4种：</p>
	 * <p>(日志)JMSLog.class</p>
	 * <p>(邮件)JMSMail.class</p>
	 * <p>(短信)JMSSMS.class</p>
	 * <p>(桌面消息)JMSDeskTop.class</p>
	 */
	private Object messageContent;
	
	/**
	 * 目的地名称
	 */
	private String destination;
	
	/**
	 * 日志类型消息
	 */
	public final static String MESSAGETYPE_LOG="Log";
	/**
	 * 邮件类型消息
	 */
	public final static String MESSAGETYPE_MAIL="Mail";
	/**
	 * 短信类型消息
	 */
	public final static String MESSAGETYPE_SMS="SMS";
	/**
	 * 桌面消息类型消息
	 */
	public final static String MESSAGETYPE_DESKTOP="DeskTop";
	
	/**
	 * 获取目的地
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * 设置目的地
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * 获取消息体内容
	 */
	public Object getMessageContent() {
		return messageContent;
	}
	
	/**
	 * 设置消息体内容
	 */
	public void setMessageContent(Object messageContent) {
		this.messageContent = messageContent;
	}

	/**
	 * 获取消息类型
	 */
	public String getMessageType() {
		return messageType;
	}

	/**
	 * 设置消息类型
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
}
