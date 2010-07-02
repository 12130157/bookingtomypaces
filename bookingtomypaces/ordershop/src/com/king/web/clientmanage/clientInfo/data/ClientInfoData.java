package com.king.web.clientmanage.clientInfo.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "clientinfo")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ClientInfoData  extends FrmData{
	
//	private String id;
	private String clientNum;
	private String companyName;
	private String companyShortname;
	private String compPhone;
	private String compFax;
	private String e_mail;
	private String linkmanOne;
	private String phoneOne;
	private String jobOne;
	
	private String addressOne;
	private String linkmanTwo;
	private String phoneTwo;
	private String jobTwo;
	private String addressTwo;
	private String areaName;
	private String remark;
	private int prompt;
	private double rebate;
	private String functionary;
	
	private String state;
	private Date createTime;
	
	@Column(name = "clientNum",nullable = true)
	public String getClientNum() {
		return clientNum;
	}
	public void setClientNum(String clientNum) {
		clientNum = clientNum;
	}
	@Column(name = "companyName",nullable = true)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		companyName = companyName;
	}
	@Column(name = "companyShortname",nullable = true)
	public String getCompanyShortname() {
		return companyShortname;
	}
	public void setCompanyShortname(String companyShortname) {
		companyShortname = companyShortname;
	}
	@Column(name = "compPhone",nullable = true)
	public String getCompPhone() {
		return compPhone;
	}
	public void setCompPhone(String compPhone) {
		compPhone = compPhone;
	}
	@Column(name = "compFax",nullable = true)
	public String getCompFax() {
		return compFax;
	}
	public void setCompFax(String compFax) {
		compFax = compFax;
	}
	@Column(name = "e_mail",nullable = true)
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String eMail) {
		e_mail = eMail;
	}
	@Column(name = "linkmanOne",nullable = true)
	public String getLinkmanOne() {
		return linkmanOne;
	}
	public void setLinkmanOne(String linkmanOne) {
		linkmanOne = linkmanOne;
	}
	@Column(name = "phoneOne",nullable = true)
	public String getPhoneOne() {
		return phoneOne;
	}
	public void setPhoneOne(String phoneOne) {
		phoneOne = phoneOne;
	}
	@Column(name = "jobOne",nullable = true)
	public String getJobOne() {
		return jobOne;
	}
	public void setJobOne(String jobOne) {
		jobOne = jobOne;
	}
	@Column(name = "addressOne",nullable = true)
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		addressOne = addressOne;
	}
	@Column(name = "linkmanTwo",nullable = true)
	public String getLinkmanTwo() {
		return linkmanTwo;
	}
	public void setLinkmanTwo(String linkmanTwo) {
		linkmanTwo = linkmanTwo;
	}
	@Column(name = "phoneTwo",nullable = true)
	public String getPhoneTwo() {
		return phoneTwo;
	}
	public void setPhoneTwo(String phoneTwo) {
		phoneTwo = phoneTwo;
	}
	@Column(name = "jobTwo",nullable = true)
	public String getJobTwo() {
		return jobTwo;
	}
	public void setJobTwo(String jobTwo) {
		jobTwo = jobTwo;
	}
	@Column(name = "addressTwo",nullable = true)
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		addressTwo = addressTwo;
	}
	@Column(name = "areaName",nullable = true)
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		areaName = areaName;
	}
	@Column(name = "remark",nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		remark = remark;
	}
	@Column(name = "prompt",nullable = true)
	public int getPrompt() {
		return prompt;
	}
	public void setPrompt(int prompt) {
		prompt = prompt;
	}
	@Column(name = "rebate",nullable = true)
	public double getRebate() {
		return rebate;
	}
	public void setRebate(double rebate) {
		rebate = rebate;
	}
	@Column(name = "functionary",nullable = true)
	
	public String getFunctionary() {
		return functionary;
	}
	public void setFunctionary(String functionary) {
		functionary = functionary;
	}
	@Column(name = "state",nullable = true)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		state = state;
	}
	@Column(name = "createTime",nullable = true)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		createTime = createTime;
	}
	
	
}
