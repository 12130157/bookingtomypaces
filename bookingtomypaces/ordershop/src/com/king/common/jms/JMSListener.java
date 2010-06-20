/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.jms;

import com.king.base.SpringContextHelper;
import com.king.tools.DateTool;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import com.sun.messaging.Topic;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.TopicConnection;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class JMSListener implements MessageListener, ServletContextListener {

	String topicName = "mytopic"; // 要监听的topic名字
	String queueName = "myqueue"; // 要监听的queue的名字
	String brokerHost = "localhost"; // OpenMQ server （broker）的ip
	String brokerPort = "7676"; // OpenMQ server （broker）的port
	String username = "admin"; // test账号必须有可以接受此queue或者topic的权限
	String password = "admin";
	ConnectionFactory connectionFactory = null;

	/* topic or queue */
	TopicConnection connection = null;
	// QueueConnection connection = null;

	Destination destination = null;
	Session session = null;
	MessageConsumer consumer = null;
	TextMessage message = null;
	JMSListener listen;

	public JMSListener() {
	}

	public void onMessage(Message msg) {
		try {
			ObjectMessage om = (ObjectMessage) msg;
			JMSMessage jmsMessage = (JMSMessage) om.getObject();
			JMSListener.addCache(jmsMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		connectionFactory = new ConnectionFactory();
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostName, brokerHost);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqBrokerHostPort, brokerPort);
		// connectionFactory.setProperty(ConnectionConfiguration.imqBrokerServiceName,brokerName);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultUsername, username);
		connectionFactory.setProperty(
				ConnectionConfiguration.imqDefaultPassword, password);

		/* topic or queue */
		connection = connectionFactory.createTopicConnection();
		// connection = connectionFactory.createQueueConnection();

		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		/* topic or queue */
		destination = new Topic(topicName);
		// destination = new Queue(queueName);

		consumer = session.createConsumer(destination);
		connection.start();
	}

	// 消费消息
	public void consumeMessage() throws JMSException, Exception {
		init();
		connection.start();

		// 开始监听
		consumer.setMessageListener(this);
		// Message message = consumer.receive();
	}

	public void destory() throws JMSException {
		consumer.close();
		session.close();
		connection.close();
	}

	public static void addCache(Object msg) {
		// CacheManager manager = CacheManager.create();
		CacheManager manager = (CacheManager) SpringContextHelper
				.getBean("cacheManager");
		Cache cache = manager.getCache("desktop");
		JMSMessage jmsMessage = (JMSMessage) msg;
		JMSDeskTop jmsDeskTop = (JMSDeskTop) jmsMessage.getMessageContent();
		String id = jmsDeskTop.getId();
		if (cache == null) {
			manager.addCache("desktop");
			cache = manager.getCache("desktop");
			Element element = new Element("newtime", msg);
			cache.put(element);
		} else {
			cache.remove("newtime");
			Element elementtime = new Element("newtime", DateTool.getDateTime(
					jmsDeskTop.getTime(), "yyyyMMddkkmmssS"));
			cache.put(elementtime);
			// 暂时不将消息存放到cache中，需要时可放开
			// Element element = new Element(id, jmsDeskTop);
			// cache.put(element);
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		try {
			listen.destory();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		listen = new JMSListener();
		try {
			listen.consumeMessage();
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
