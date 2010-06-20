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
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.king.base.FrmData;


@Entity()
@Table(name = "sysdesktop")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class JMSDeskTop extends FrmData implements Serializable{

//	/**
//	 * 日志编号
//	 */
//	@Id
//	@Column(length = 32,nullable = false)
//	@GeneratedValue(generator = "system-uuid")
//	@GenericGenerator(name = "system-uuid",strategy = "uuid.hex")
//	private String id;
	/**
	 * 桌面消息发起时间
	 */
	@Column(name = "time")
	private Date time;
	/**
	 * 桌面消息类型
	 */
	@Column(name = "type")
	private String type;
	/**
	 * 桌面消息发送者
	 */
	@Column(name = "sender")
	private String sender;
	/**
	 * 桌面消息授权对象
	 */
	@Column(name = "recipients")
	private String recipients;
	/**
	 * 桌面消息内容
	 */
	@Column(name = "content")
	private String content;
	/**
	 * 桌面消息ALL类型
	 */
	public final static String TYPE_ALL="ALL";
	/**
	 * 桌面消息ROLE类型
	 */
	public final static String TYPE_ROLE="ROLE";
	/**
	 * 桌面消息USER类型
	 */
	public final static String TYPE_USER="USER";
	
	/**
	 * 获取桌面消息内容的值
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * 设置桌面消息内容的值
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * 获取桌面消息授权对象的值
	 */
	public String getRecipients() {
		return recipients;
	}
	
	/**
	 * 设置桌面消息授权对象的值
	 */
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	
	/**
	 * 获取桌面消息发送者的值
	 */
	public String getSender() {
		return sender;
	}
	
	/**
	 * 设置桌面消息发送者的值
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	/**
	 * 获取桌面消息发起时间的值
	 */
	public Date getTime() {
		return time;
	}
	
	/**
	 * 设置桌面消息发起时间的值
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	
	/**
	 * 获取桌面消息类型的值
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * 设置桌面消息类型的值
	 */
	public void setType(String type) {
		this.type = type;
	}

//	public Object getOID() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	
}
