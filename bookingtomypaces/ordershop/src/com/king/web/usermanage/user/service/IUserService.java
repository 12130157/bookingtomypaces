package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.data.UserData;


public interface IUserService {

	/**
	 * 添加用户 基本信息
	 * @param u 用户 基本信息
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData addUser(UserData u) throws KINGException;
	
	/**
	 * 单个删除用户 基本信息
	 * @param u 用户 基本信息
	 * @throws KINGException
	 */
	public void deleteUser(UserData u) throws KINGException;
	
	/**
	 * 批量删除用户 基本信息
	 * @param ids 用户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteUser(String[] ids) throws KINGException;
	
	/**
	 * 修改用户 基本信息
	 * @param u 用户 基本信息
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData updateUser(UserData u) throws KINGException;
	
	/**
	 * 查询单个用户 基本信息
	 * @param id 用户 基本信息ID
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData retrieveUser(String id) throws KINGException;
	
	/**
	 * 查询用户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 用户 基本信息集合
	 * @throws KINGException
	 */
	public List<UserData> searchUsersList(PageRoll pageRoll,String withhql) throws KINGException;
	
	
	/**
	 * 用户登录
	 * @param 用户帐号
	 * @param 用户密码
	 * @return 用户 基本信息集合UserData
	 * @throws KINGException
	 */
	public UserData login(String name, String pwd) throws KINGException;
	
	/**
	 * 用户登录记录
	 * @param IP
	 * @param 登录时间
	 * @param 用户ID
	 * @return void
	 * @throws KINGException
	 */
	public void loginLogUser(String ip, String lastTime, int uid) throws KINGException;
	
	/**
	 * 判断用户是否有权限登录系统
	 * @param 用户ID
	 * @return 数量
	 * @throws KINGException
	 */
	public int userExistRole(int uid) throws KINGException;
}
