package com.king.web.ordermanage.orderinfo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "orderinfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrderInfoData extends FrmData{

	private String orderNumber;
	private String writeOrderNum;
	private String clientCompName;
	private String clientLinkman;
	private String clientMobile;
	private String clientCompPhone;
	private int isUrgentMail;
	private String startGoodsTime;
	private int deliverType;
	private int isSms;
	private String smsType;
	private String smsMobile;
	private double orderAmount;
	private int channel;
	private int orderStatus;
	private String operator;
	private String operatStoreId;
	private String operatStoreName;
	private String paytype;
	private double payAmount;
	private String paytime;
	private int payResult;
	private String auditor;
	private String auditDate;
	private String auditRemark;
	private String createTime;
	private String orderResultDesc;
	
	@Column(name = "orderNumber",nullable = true)
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Column(name = "writeOrderNum",nullable = true)
	public String getWriteOrderNum() {
		return writeOrderNum;
	}
	public void setWriteOrderNum(String writeOrderNum) {
		this.writeOrderNum = writeOrderNum;
	}
	@Column(name = "clientCompName",nullable = true)
	public String getClientCompName() {
		return clientCompName;
	}
	public void setClientCompName(String clientCompName) {
		this.clientCompName = clientCompName;
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
	@Column(name = "clientCompPhone",nullable = true)
	public String getClientCompPhone() {
		return clientCompPhone;
	}
	public void setClientCompPhone(String clientCompPhone) {
		this.clientCompPhone = clientCompPhone;
	}
	@Column(name = "isUrgentMail",nullable = true)
	public int getIsUrgentMail() {
		return isUrgentMail;
	}
	public void setIsUrgentMail(int isUrgentMail) {
		this.isUrgentMail = isUrgentMail;
	}
	@Column(name = "startGoodsTime",nullable = true)
	public String getStartGoodsTime() {
		return startGoodsTime;
	}
	public void setStartGoodsTime(String startGoodsTime) {
		this.startGoodsTime = startGoodsTime;
	}
	@Column(name = "deliverType",nullable = true)
	public int getDeliverType() {
		return deliverType;
	}
	public void setDeliverType(int deliverType) {
		this.deliverType = deliverType;
	}
	@Column(name = "isSms",nullable = true)
	public int getIsSms() {
		return isSms;
	}
	public void setIsSms(int isSms) {
		this.isSms = isSms;
	}
	@Column(name = "smsType",nullable = true)
	public String getSmsType() {
		return smsType;
	}
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	@Column(name = "smsMobile",nullable = true)
	public String getSmsMobile() {
		return smsMobile;
	}
	public void setSmsMobile(String smsMobile) {
		this.smsMobile = smsMobile;
	}
	@Column(name = "orderAmount",nullable = true)
	public double getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(double orderAmount) {
		this.orderAmount = orderAmount;
	}
	@Column(name = "channel",nullable = true)
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	@Column(name = "orderStatus",nullable = true)
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Column(name = "operator",nullable = true)
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	@Column(name = "operatStoreId",nullable = true)
	public String getOperatStoreId() {
		return operatStoreId;
	}
	public void setOperatStoreId(String operatStoreId) {
		this.operatStoreId = operatStoreId;
	}
	@Column(name = "operatStoreName",nullable = true)
	public String getOperatStoreName() {
		return operatStoreName;
	}
	public void setOperatStoreName(String operatStoreName) {
		this.operatStoreName = operatStoreName;
	}
	@Column(name = "paytype",nullable = true)
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	@Column(name = "payAmount",nullable = true)
	public double getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(double payAmount) {
		this.payAmount = payAmount;
	}
	@Column(name = "paytime",nullable = true)
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	@Column(name = "payResult",nullable = true)
	public int getPayResult() {
		return payResult;
	}
	public void setPayResult(int payResult) {
		this.payResult = payResult;
	}
	@Column(name = "auditor",nullable = true)
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	@Column(name = "auditDate",nullable = true)
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	@Column(name = "auditRemark",nullable = true)
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	@Column(name = "createTime",nullable = true)
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Column(name = "orderResultDesc",nullable = true)
	public String getOrderResultDesc() {
		return orderResultDesc;
	}
	public void setOrderResultDesc(String orderResultDesc) {
		this.orderResultDesc = orderResultDesc;
	}
	
	
}
