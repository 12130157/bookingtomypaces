package com.king.web.ordermanage.orderinfo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "ordersms")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrderSmsData extends FrmData{

	private String orderNumber;
	private String clientLinkman;
	private String clientMobile;
	private String smsType;
	private String state;
	
	@Column(name = "orderNumber",nullable = true)
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Column(name = "clientLinkman",nullable = true)
	public String getClientLinkman() {
		return clientLinkman;
	}
	public void setClientLinkman(String clientLinkman) {
		this.clientLinkman = clientLinkman;
	}
	@Column(name = "clientMobile",nullable = true)
	public String getClientMobile() {
		return clientMobile;
	}
	public void setClientMobile(String clientMobile) {
		this.clientMobile = clientMobile;
	}
	@Column(name = "orderNumber",nullable = true)
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	@Column(name = "state",nullable = true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
