
/**   
* 文件名：ProductData.java   
*   
* 版本信息：   
* 日期：2010-7-27   
* Copyright 足下 Corporation 2010    
* Mypaces 版权所有   
*   
*/

package com.king.web.productmanage.product.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.king.base.FrmData;


/**   
 *    
 * 项目名称：ordershop   
 * 类名称：ProductData   
 * 类描述：   产品资料
 * 创建人：tim   
 * 创建时间：2010-7-27 下午08:54:15   
 * 修改人：tim   
 * 修改时间：2010-7-27 下午08:54:15   
 * 修改备注：   
 * @version    
 *    
 */
@Entity()
@Table(name = "Product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ProductData extends FrmData{

	private String num;                 //商品编号
	private String name;                //商品名称
	private int typeLevel;              //类别ID
	private int storeCount;             //仓库数量
	private double price;               //实际价格
	private double marketPrice;         //市场价格
	private String picName;             //图片名称
	private String picSmallPath;        //缩略图路径
	private String picNormalPath;       //正常图路径
	private String description;         //描述
	private String spec;                //产品规格
	private String unitId;              //产品单位
	private String creator;             //录入人员
	private java.util.Date createTime;  //录入时间
	private String mender;              //修改人员
	private java.util.Date modifyTime;  //修改时间
	private int status;                 //状态
	private int seq;                    //排序
	
	@Column(length = 100,name = "num",nullable = true)
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Column(length = 100,name = "name",nullable = true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(length = 30,name = "typeLevel",nullable = true)
	public int getTypeLevel() {
		return typeLevel;
	}
	public void setTypeLevel(int typeLevel) {
		this.typeLevel = typeLevel;
	}
	
	@Column(length = 4,name = "storeCount",nullable = true)
	public int getStoreCount() {
		return storeCount;
	}
	public void setStoreCount(int storeCount) {
		this.storeCount = storeCount;
	}
	
	@Column(length = 14,name = "price",nullable = true)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Column(length = 14,name = "marketPrice",nullable = true)
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	
	@Column(length = 100,name = "picName",nullable = true)
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}
	
	@Column(length = 100,name = "picSmallPath",nullable = true)
	public String getPicSmallPath() {
		return picSmallPath;
	}
	public void setPicSmallPath(String picSmallPath) {
		this.picSmallPath = picSmallPath;
	}
	
	@Column(length = 100,name = "picNormalPath",nullable = true)
	public String getPicNormalPath() {
		return picNormalPath;
	}
	public void setPicNormalPath(String picNormalPath) {
		this.picNormalPath = picNormalPath;
	}
	
	@Column(length = 200,name = "description",nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(length = 200,name = "spec",nullable = true)
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	@Column(length = 32,name = "unitId",nullable = true)
	public String getUnitId() {
		return unitId;
	}
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
	@Column(length = 32,name = "creator",nullable = true)
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Column(name = "createTime",nullable = true)
	public java.util.Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(length = 32,name = "mender",nullable = true)
	public String getMender() {
		return mender;
	}
	public void setMender(String mender) {
		this.mender = mender;
	}
	
	@Column(name = "modifyTime",nullable = true)
	public java.util.Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(java.util.Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	@Column(length = 4,name = "status",nullable = true)
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(length = 4,name = "seq",nullable = true)
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
	
}
