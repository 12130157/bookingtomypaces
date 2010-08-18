package com.king.web.ordermanage.orderinfo.service;

import java.util.List;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.ordermanage.orderinfo.data.OrderInfoData;

public interface IOrderInfoService {

	/**
	 * 添加客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData addOrderInfo(OrderInfoData u) throws KINGException;
	
	/**
	 * 单个删除客户 基本信息
	 * @param u 客户 基本信息
	 * @throws KINGException
	 */
	public void deleteOrderInfo(OrderInfoData u) throws KINGException;
	
	/**
	 * 批量删除客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteOrderInfo(String[] ids) throws KINGException;
	
	/**
	 * 修改客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData updateOrderInfo(OrderInfoData u) throws KINGException;
	
	/**
	 * 查询单个客户 基本信息
	 * @param id 客户 基本信息ID
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public OrderInfoData retrieveOrderInfo(String id) throws KINGException;
	
	/**
	 * 查询客户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 客户 基本信息集合
	 * @throws KINGException
	 */
	public List<OrderInfoData> searchOrderInfoList(PageRoll pageRoll,String withhql) throws KINGException;
	
	/**
	 * 批量更新客户 状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateOrderInfo(String[] ids) throws KINGException;
	/**
	 * 更新id客户 状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateOrderInfoByid(String id,String state) throws KINGException;	
	
}
