package com.king.web.ordermanage.orderinfo.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.DateTool;
import com.king.web.ordermanage.orderinfo.data.OrderClientInfoData;
import com.king.web.ordermanage.orderinfo.data.OrderInfoData;
import com.king.web.ordermanage.orderinfo.data.OrderSmsData;
import com.king.web.ordermanage.orderinfo.service.IOrderInfoService;
import com.king.web.usermanage.store.data.StoreData;
import com.king.web.usermanage.store.service.IStoreService;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="list", location="view/clientInfo/clientInfo_list.jsp"),
	@Result(name="edit", location="view/clientInfo/clientInfo_edit.jsp"),
	@Result(name="add", location="view/orderInfo/orderInfo_add.jsp"),
	@Result(name="view", location="view/clientInfo/clientInfo_view.jsp")
})

public class OrderInfoAction extends FrmAction{

	
	public IStoreService storeService;
	public IOrderInfoService  orderInfoService;
	
	private List<StoreData> storeList=new ArrayList<StoreData>();
	private OrderInfoData orderinfodata;
	private OrderClientInfoData orderclientinfo;
	private OrderSmsData ordersms;
	
	/**
	 * 进入新增页面
	 * @return
	 * @throws KINGException
	 */
	public String addjsp()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		String withsql=" where status=0 ";
		storeList =storeService.searchAllStores(withsql);
		System.out.println("storeList:"+storeList.size());
		return "add";
	}
	
	/**
	 * 新增操作
	 * @return
	 * @throws KINGException
	 */
	public String add()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
//		System.out.println("Client_id=="+clientinfodata.getId());
		
//		System.out.println("getClientNum=="+this.clientinfodata.getClientNum());
//		System.out.println("getCompanyName=="+clientinfodata.getCompanyName());
//		System.out.println("getE_mail=="+clientinfodata.getE_mail());
//		clientinfodata.setCreateTime(DateTool.getNowDate());
//		System.out.println("getCreate_time=="+clientinfodata.getCreateTime());
		orderInfoService.addOrderInfo(orderinfodata);
		
		return this.addjsp();
	}
	


	public IStoreService getStoreService() {
		return storeService;
	}

	public void setStoreService(IStoreService storeService) {
		this.storeService = storeService;
	}

	public List<StoreData> getStoreList() {
		return storeList;
	}
	public void setStoreList(List<StoreData> storeList) {
		this.storeList = storeList;
	}

	public IOrderInfoService getOrderInfoService() {
		return orderInfoService;
	}

	public void setOrderInfoService(IOrderInfoService orderInfoService) {
		this.orderInfoService = orderInfoService;
	}


}
