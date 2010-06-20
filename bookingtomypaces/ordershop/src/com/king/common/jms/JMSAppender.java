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
import java.util.HashMap;
import java.util.Iterator;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;


public class JMSAppender extends AppenderSkeleton {

	/**
	 * JMS服务器地址
	 */
	public String providerURL;
	
	/**
	 * JMS服务器地址
	 */
	public String getProviderURL() {
		return providerURL;
	}

	/**
	 * JMS服务器地址
	 */
	public void setProviderURL(String providerURL) {
		this.providerURL = providerURL;
	}
	
	/**
	 * 发送消息
	 * @param ConnectionFactory 连接工厂
	 * @param String 目的地名称
	 * @return 
	 * @throws 
	 */
	protected void append(LoggingEvent event) {
		ConnectionFactory connectionFactory= new ConnectionFactory();
		try {
			connectionFactory.setProperty(ConnectionConfiguration.imqAddressList, providerURL);
			/* 是否必须创建连接对象待分析
			 * connectionFactory.createConnection();
			*/
			JMSMessage jmsMsg= (JMSMessage) event.getMessage();
			String messageType=jmsMsg.getMessageType();
			JMSAppender.sendObject(connectionFactory, messageType, jmsMsg);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e){

		}
	}
	
	/**
	 * 发送消息
	 * @param ConnectionFactory 连接工厂
	 * @param String 目的地名称
	 * @return 
	 * @throws 
	 */
    public static void sendObject(ConnectionFactory connectionFactory, String queueName, final Serializable obj) {
    	JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory);
    	jmsTemplate.send(queueName, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
            	if(obj instanceof String){
            		return session.createTextMessage (obj.toString());
            	}else if(obj instanceof HashMap){
            		HashMap m = (HashMap)obj;
            		MapMessage mm = session.createMapMessage();
                	Iterator it = m.keySet().iterator();
                	while(it.hasNext()){
                		String name = it.next().toString();
                		Object obj = m.get(name);
                		if(obj == null){
                			mm.setString(name, "");
                		}else{
                			mm.setString(name, obj.toString());
                		}
                	}
                	return mm;
            	}else{
            		return session.createObjectMessage (obj);
            	}
            }
        });
    }

	public void close() {
	}

	public boolean requiresLayout() {
		return false;
	}

}
