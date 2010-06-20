/**    
*  
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import org.springframework.context.ApplicationEvent;

public class FrmEvent extends ApplicationEvent {
	public FrmEvent(Object source){
		super(source);
	}
	/**
	 * �¼���ʶ
	 */
	private String eventID =null;
	/**
	 * �¼���Ϣ
	 */
	private String eventMessage=null;
	/**
	 * �¼�����
	 */
	private Object eventObject = null;
	public String getEventID() {
		return eventID;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEventMessage() {
		return eventMessage;
	}
	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}
	public Object getEventObject() {
		return eventObject;
	}
	public void setEventObject(Object eventObject) {
		this.eventObject = eventObject;
	}
	
	
}
