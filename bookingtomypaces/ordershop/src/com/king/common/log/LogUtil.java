/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.king.common.jms.JMSDeskTop;
import com.king.common.jms.JMSLog;
import com.king.common.jms.JMSMessage;
import com.king.tools.DateTool;

public class LogUtil {

	/**
	 * 通过手动加载Log4j配置文件记录日志
	 * @param Object 消息
	 * @return 
	 * @throws 
	 */
	public void run(Object obj){
		Logger log = Logger.getLogger(this.getClass());
		String url=this.getClass().getResource("/com/king/common/log/log4j.properties").toString().substring(6);
		PropertyConfigurator.configure(url);
		log.info(obj);
	}
	
	/**
	 * 致命错误，导致系统中止。
	 * @param logName　配置的日志模块名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void fatal(String logName,Object message){
		Logger log = Logger.getLogger(logName);
		log.fatal(message);
	}
	
	/**
	 * 致命错误，导致系统中止。
	 * @param logName　配置的日志模块名称
	 * @param message　日志信息
	 * @param t 系统例外对象
	 * @throws 
	 */ 
	public static void fatal(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.fatal(message,t);
	}
	
	
	/**
	 * 记录普通逻辑错误，但是不会导致系统中止。
	 * @param logName　日志实例名
	 * @param message　记录的日志信息对象
	 * @throws 
	 */
	public static void error(String logName,Object message) {
		Logger log = Logger.getLogger(logName);
		log.error(message);
	}
	/**
	 * 记录普通逻辑错误，不会导致系统中止
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @param t　例外对象
	 * @throws 
	 */ 
	public static void error(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.error(message,t);
	}
	
	/**
	 * 记录警告信息
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @throws 
	 */
	public static void warn(String logName,Object message) {
		Logger log = Logger.getLogger(logName);
		log.warn(message);
	}
	/**
	 * 记录警告信息。
	 * @param logName　日志实例名
	 * @param message　日志信息
	 * @param t　例外实例
	 * @throws 
	 */
	public static void warn(String logName,Object message,Throwable t){
		Logger log = Logger.getLogger(logName);
		log.warn(message,t);
	}
	/**
	 * 记录提示信息
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void info(String logName,Object message){
		
		Logger log = Logger.getLogger(logName);
		log.info(message);
	}
		
	/**
	 * 记录提示信息。
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @param t　例外对象信息
	 * @throws 
	 */
	public static void info(String logName,Object message,Throwable t) {
		Logger log = Logger.getLogger(logName);
		log.info(message,t);
	}
	/**
	 * 记录调试信息
	 * @param logName 日志实例名称
	 * @param message　日志信息
	 * @throws 
	 */
	public static void debug(String logName,Object message){
		Logger log = Logger.getLogger(logName);
		log.debug(message);
	}
	/**
	 * 记录调试信息。
	 * @param logName　日志实例名称
	 * @param message　日志信息
	 * @param t　例外对象
	 * @throws 
	 */
	public static void debug(String logName,Object message,Throwable t) {
		Logger log = Logger.getLogger(logName);
		log.debug(message,t);
	}
	
}
