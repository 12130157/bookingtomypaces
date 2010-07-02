package com.king.web.clientmanage.clientInfo.service;

import java.util.List;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.clientmanage.clientInfo.data.ClientInfoData;

public interface IClientInfoService {

	/**
	 * 添加客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData addClientInfo(ClientInfoData u) throws KINGException;
	
	/**
	 * 单个删除客户 基本信息
	 * @param u 客户 基本信息
	 * @throws KINGException
	 */
	public void deleteClientInfo(ClientInfoData u) throws KINGException;
	
	/**
	 * 批量删除客户 基本信息
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteClientInfo(String[] ids) throws KINGException;
	
	/**
	 * 修改客户 基本信息
	 * @param u 客户 基本信息
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData updateClientInfo(ClientInfoData u) throws KINGException;
	
	/**
	 * 查询单个客户 基本信息
	 * @param id 客户 基本信息ID
	 * @return 客户 基本信息
	 * @throws KINGException
	 */
	public ClientInfoData retrieveClientInfo(String id) throws KINGException;
	
	/**
	 * 查询客户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 客户 基本信息集合
	 * @throws KINGException
	 */
	public List<ClientInfoData> searchClientInfoList(PageRoll pageRoll,String withhql) throws KINGException;
	
	/**
	 * 批量更新客户 状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateClientInfo(String[] ids) throws KINGException;
	/**
	 * 更新id客户 状态
	 * @param ids 客户 基本信息ID数组
	 * @throws KINGException
	 */
	public void updateClientInfoByid(String id,String state) throws KINGException;	
	
}
