package com.king.web.ordermanage.orderinfo.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;

@Entity()
@Table(name = "orderitem")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class OrderItemData extends FrmData{

	private String orderNumber;
	private String orderItemId;
	private int productCount;
	private String productId;
	private String productName;
	private String productSpec;
	private double productAmount;
	private double productPrice;
	private int rebate;
	private String productFile;
	private String productRemark;
	
	@Column(name = "orderNumber",nullable = true)
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	@Column(name = "orderItemId",nullable = true)
	public String getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}
	@Column(name = "productCount",nullable = true)
	public int getProductCount() {
		return productCount;
	}
	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}
	@Column(name = "productId",nullable = true)
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Column(name = "productName",nullable = true)
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Column(name = "productSpec",nullable = true)
	public String getProductSpec() {
		return productSpec;
	}
	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	@Column(name = "productAmount",nullable = true)
	public double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(double productAmount) {
		this.productAmount = productAmount;
	}
	@Column(name = "productPrice",nullable = true)
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	@Column(name = "rebate",nullable = true)
	public int getRebate() {
		return rebate;
	}
	public void setRebate(int rebate) {
		this.rebate = rebate;
	}
	@Column(name = "productFile",nullable = true)
	public String getProductFile() {
		return productFile;
	}
	public void setProductFile(String productFile) {
		this.productFile = productFile;
	}
	@Column(name = "productRemark",nullable = true)
	public String getProductRemark() {
		return productRemark;
	}
	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
	
	
}
