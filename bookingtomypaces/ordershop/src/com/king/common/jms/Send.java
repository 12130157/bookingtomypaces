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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.jms.TopicConnection;

public class Send {
    
    String topicName = "mytopic" ;     //要监听的topic名字
    String queueName = "myqueue" ;     //要监听的queue的名字
    String brokerHost = "localhost" ;  //OpenMQ server （broker）的ip
    String brokerPort = "7676" ;  //OpenMQ server （broker）的port
    String username = "admin";          //customer账号必须有可以发送此queue或者topic的权限
    String password = "admin";
    ConnectionFactory       connectionFactory = null;
    
    /* topic or queue */
    TopicConnection              connection = null;
//    QueueConnection              connection = null;
    
    Destination  destination = null;
    Session                 session = null;
    MessageProducer               producer = null;
    ObjectMessage                  message = null;

    public Send(){
        try {
            init();
        } catch (Exception ex) {
           ex.printStackTrace();
        }

    }
     private void init() throws Exception{
        connectionFactory =  new ConnectionFactory();
        connectionFactory.setProperty(ConnectionConfiguration.imqBrokerHostName, brokerHost);
        connectionFactory.setProperty(ConnectionConfiguration.imqBrokerHostPort, brokerPort);
        connectionFactory.setProperty(ConnectionConfiguration.imqDefaultUsername,username);
        connectionFactory.setProperty(ConnectionConfiguration.imqDefaultPassword,password);
        
        /* topic or queue */
        connection = connectionFactory.createTopicConnection();

        session =  connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        
        /* topic or queue */
        destination =  new Topic(topicName);
        
        producer = session.createProducer(destination);

        connection.start();
    }
     public void send(Serializable msg) throws JMSException{
        try {
            message = session.createObjectMessage();
            message.setObject(msg);
            producer.send(message);
           
        } catch (JMSException ex) {
            ex.printStackTrace();
        }finally{
             connection.close();
        }
     }

     public static void main(String[] args)throws JMSException {
        
        Send send = new Send();
        send.send("test user : tim");
    }



}

