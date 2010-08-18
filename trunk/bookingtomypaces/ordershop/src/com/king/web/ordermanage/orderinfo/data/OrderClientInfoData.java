package com.king.web.ordermanage.orderinfo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "orderclientinfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class OrderClientInfoData extends FrmData{

	private String orderNumber;
	private String clientNum;
	private String clientCompAddress;
	private String clientE_mail;
	private String clientCompFax;
	private String clientAppraise;
	private String clientRemark;
	private String deliverStore;
	private int deliverCash;
	private String deliverArea;
	private String deliverDate;
	private String deliverCompany;
	private String deliverMan;
	private String deliverPhone;
	private String deliverMobile;
	private String deliveAddress;
	private String deliverRemark;
	
	@Column(name = "orderNumber",nullable = true)
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Column(name = "orderNumber",nullable = true)
	public String getClientNum() {
		return clientNum;
	}
	public void setClientNum(String clientNum) {
		this.clientNum = clientNum;
	}
	@Column(name = "clientCompAddress",nullable = true)
	public String getClientCompAddress() {
		return clientCompAddress;
	}
	public void setClientCompAddress(String clientCompAddress) {
		this.clientCompAddress = clientCompAddress;
	}
	@Column(name = "clientE_mail",nullable = true)
	public String getClientE_mail() {
		return clientE_mail;
	}
	public void setClientE_mail(String clientEMail) {
		clientE_mail = clientEMail;
	}
	@Column(name = "clientCompFax",nullable = true)
	public String getClientCompFax() {
		return clientCompFax;
	}
	public void setClientCompFax(String clientCompFax) {
		this.clientCompFax = clientCompFax;
	}
	@Column(name = "clientAppraise",nullable = true)
	public String getClientAppraise() {
		return clientAppraise;
	}
	public void setClientAppraise(String clientAppraise) {
		this.clientAppraise = clientAppraise;
	}
	@Column(name = "clientRemark",nullable = true)
	public String getClientRemark() {
		return clientRemark;
	}
	public void setClientRemark(String clientRemark) {
		this.clientRemark = clientRemark;
	}
	@Column(name = "deliverStore",nullable = true)
	public String getDeliverStore() {
		return deliverStore;
	}
	public void setDeliverStore(String deliverStore) {
		this.deliverStore = deliverStore;
	}
	@Column(name = "deliverCash",nullable = true)
	public int getDeliverCash() {
		return deliverCash;
	}
	public void setDeliverCash(int deliverCash) {
		this.deliverCash = deliverCash;
	}
	@Column(name = "deliverArea",nullable = true)
	public String getDeliverArea() {
		return deliverArea;
	}
	public void setDeliverArea(String deliverArea) {
		this.deliverArea = deliverArea;
	}
	@Column(name = "deliverDate",nullable = true)
	public String getDeliverDate() {
		return deliverDate;
	}
	public void setDeliverDate(String deliverDate) {
		this.deliverDate = deliverDate;
	}
	@Column(name = "deliverCompany",nullable = true)
	public String getDeliverCompany() {
		return deliverCompany;
	}
	public void setDeliverCompany(String deliverCompany) {
		this.deliverCompany = deliverCompany;
	}
	@Column(name = "deliverMan",nullable = true)
	public String getDeliverMan() {
		return deliverMan;
	}
	public void setDeliverMan(String deliverMan) {
		this.deliverMan = deliverMan;
	}
	@Column(name = "deliverPhone",nullable = true)
	public String getDeliverPhone() {
		return deliverPhone;
	}
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	@Column(name = "deliverMobile",nullable = true)
	public String getDeliverMobile() {
		return deliverMobile;
	}
	public void setDeliverMobile(String deliverMobile) {
		this.deliverMobile = deliverMobile;
	}
	@Column(name = "deliveAddress",nullable = true)
	public String getDeliveAddress() {
		return deliveAddress;
	}
	public void setDeliveAddress(String deliveAddress) {
		this.deliveAddress = deliveAddress;
	}
	@Column(name = "deliverRemark",nullable = true)
	public String getDeliverRemark() {
		return deliverRemark;
	}
	public void setDeliverRemark(String deliverRemark) {
		this.deliverRemark = deliverRemark;
	}
}
