/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.jms;

import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import com.sun.messaging.Topic;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TopicConnection;

public class SendQueueMessage {

	//	/**
	//	 * 要监听的topic名字
	//	 */
	//	private String topicName;
	
	/**
	 * OpenMQ服务器地址列表
	 */
	private String imqAddressList;
	
	/**
	 * 要监听的queue的名字
	 */
	private String queueName;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	ConnectionFactory connectionFactory = null;

	/* topic or queue */
	//    TopicConnection              connection = null;
	QueueConnection connection = null;

	Destination destination = null;

	Session session = null;

	MessageProducer producer = null;

	Message message = null;

	public String getImqAddressList() {
		return imqAddressList;
	}

	public void setImqAddressList(String imqAddressList) {
		this.imqAddressList = imqAddressList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQueueName() {
		return queueName;
	}

	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public SendQueueMessage() {
	}

	/**
	 * 初始化必要参数创建连接对象和发送对象 
	 */
	private void init() {
		connectionFactory = new ConnectionFactory();
		try {
			connectionFactory.setProperty("imqAddressList",imqAddressList);
//			connectionFactory.setProperty(ConnectionConfiguration.imqBrokerHostName, brokerHost);
//			connectionFactory.setProperty(ConnectionConfiguration.imqBrokerHostPort, brokerPort);
			connectionFactory.setProperty(ConnectionConfiguration.imqDefaultUsername, username);
			connectionFactory.setProperty(ConnectionConfiguration.imqDefaultPassword, password);

			/* topic or queue */
			//connection = connectionFactory.createTopicConnection();
			connection = connectionFactory.createQueueConnection();

			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			/* topic or queue */
			//destination =  new Topic(topicName);
			destination = new Queue(queueName);

			//session.createTopic(topicName);
			producer = session.createProducer(destination);

			connection.start();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送Queue消息主调方法
	 * @param msg 消息体(JMSMessage.class)
	 */
	public void send(Serializable msg){
		try {
			JMSMessage jmsMsg=(JMSMessage) msg;
			queueName=jmsMsg.getDestination();
			Object obj = jmsMsg.getMessageContent();
			init();
			
        	if(obj instanceof String){
        		message = session.createTextMessage (obj.toString());
        	}else if(obj instanceof HashMap){
        		HashMap m = (HashMap)obj;
        		MapMessage mm = session.createMapMessage();
            	Iterator it = m.keySet().iterator();
            	while(it.hasNext()){
            		String name = it.next().toString();
            		Object o = m.get(name);
            		if(o == null){
            			mm.setString(name, "");
            		}else{
            			mm.setString(name, o.toString());
            		}
            	}
            	message = mm;
        	}else{
        		message = session.createObjectMessage ((Serializable)obj);
        	}
			producer.send(message);

		} catch (JMSException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		JMSMessage msg=new JMSMessage();
		msg.setDestination("myqueue");
		msg.setMessageType("myqueue");
		msg.setMessageContent("test message");
		
		SendQueueMessage send = new SendQueueMessage();
		send.setImqAddressList("localhost:7676");
		send.setUsername("admin");
		send.setPassword("admin");
//		send.setQueueName("myqueue");
		send.send(msg);
	}

}
