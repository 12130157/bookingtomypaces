/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class SpringContextHelper implements ServletContextListener {

	/**
	 * Spring容器对象。
	 */
	private static WebApplicationContext ctx = null;

	/**
	 * 应用服务器初始化时调用，设置容器实例。
	 * 
	 * @param event
	 *            应用服务器启动事件
	 * 
	 */
	public void contextInitialized(ServletContextEvent event) {
		SpringContextHelper.ctx = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
	}

	/**
	 * 应用服务器关闭时调用，未做处理。
	 * 
	 * @param event
	 *            应用服务器启动事件
	 * 
	 */
	public void contextDestroyed(ServletContextEvent event) {
		this.ctx = null;
	}

	/**
	 * 返回beanName对应的bean实例。
	 * 
	 * @param beanName
	 * @return Spring配置中的bean
	 */
	public static Object getBean(String beanName) {
		Object bean = ctx.getBean(beanName);
		return bean;
	}

	public static void publish(FrmEvent evt) {
		ctx.publishEvent(evt);
	}
}