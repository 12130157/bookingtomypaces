package com.king.web.usermanage.systemfunction.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;


public interface ISystemFunctionService {

	/**
	 *1. 添加系统功能组件信息
	 * @param u 系统功能组件信息
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData addSystemFunction(SystemFunctionData u) throws KINGException;
	
	/**
	 * 2.单个删除系统功能组件信息
	 * @param u 系统功能组件信息
	 * @throws KINGException
	 */
	public void deleteSystemFunction(SystemFunctionData u) throws KINGException;
	
	/**
	 * 3.批量删除系统功能组件信息
	 * @param ids 系统功能组件信息ID数组
	 * @throws KINGException
	 */
	public void deleteSystemFunction(String[] ids) throws KINGException;
	
	/**
	 * 4.修改系统功能组件信息
	 * @param u 系统功能组件信息
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData updateSystemFunction(SystemFunctionData u) throws KINGException;
	
	/**
	 * 5.查询单个系统功能组件信息
	 * @param id 系统功能组件信息ID
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData retrieveSystemFunction(String id) throws KINGException;
	
	/**
	 * 6.查询系统功能组件信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> searchSystemFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException;
	
	/**
	 * 7.按排序查询系统功能组件
	 * @param indexNo
	 * @param 
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> getSysFun() throws KINGException;
	
	/**
	 * 8.查询系统功能组件信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> getSysFunByUserId(String userId) throws KINGException;
	
	
}
