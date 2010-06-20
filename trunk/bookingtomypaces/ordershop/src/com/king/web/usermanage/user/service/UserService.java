package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.dao.IUserDAO;
import com.king.web.usermanage.user.data.UserData;

public class UserService extends FrmService implements IUserService{

	private IUserDAO userDao;
	
	/**
	 * 1.添加用户 基本信息
	 * @param u 用户 基本信息
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData addUser(UserData u) throws KINGException{
		userDao.add(u);
		return u;
	}
	
	/**
	 * 2.单个删除用户 基本信息
	 * @param u 用户 基本信息
	 * @throws KINGException
	 */
	public void deleteUser(UserData u) throws KINGException{
		userDao.delete(u);
	}
	
	/**
	 * 3.批量删除用户 基本信息
	 * @param ids 用户 基本信息ID数组
	 * @throws KINGException
	 */
	public void deleteUser(String[] ids) throws KINGException{
		userDao.delete(ids);
	}
	
	/**
	 * 4.修改用户 基本信息
	 * @param u 用户 基本信息
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData updateUser(UserData u) throws KINGException{
		userDao.update(u);
		return u;
	}
	
	/**
	 * 5.查询单个用户 基本信息
	 * @param id 用户 基本信息ID
	 * @return 用户 基本信息
	 * @throws KINGException
	 */
	public UserData retrieveUser(String id) throws KINGException{
		String hql = "from UserData u where u.id = '" +id+ "'";
		return (UserData) userDao.search(hql).get(0);
	}
	
	/**
	 * 6.查询用户 基本信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 用户 基本信息集合
	 * @throws KINGException
	 */
	public List<UserData> searchUsersList(PageRoll pageRoll,String withhql) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from UserData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = userDao.searchlist(pageRoll,withhql);
		System.out.println("-----list.size()="+list.size());
		return list;
	}
	
	/**
	 * 7.用户登录
	 * @param 用户帐号
	 * @param 用户密码
	 * @return 用户 基本信息集合UserData
	 * @throws KINGException
	 */
	public UserData login(String name, String pwd) throws KINGException{
		System.out.println("7.用户登录====================="+name+"      pwd===="+pwd);
		String hql = "select u FROM UserData u WHERE u.userName='"
			+ name + "' and u.passWord='" + pwd + "'";
		List<UserData> list=userDao.search(hql);
		UserData u = new UserData();
		System.out.println("list.size()==="+list.size());
		if(list.size()>0){
			u=list.get(0);
		}else{
			u=null;
		}
		return u;
	}
	
	/**
	 * 8.用户登录记录
	 * @param IP
	 * @param 登录时间
	 * @param 用户ID
	 * @return void
	 * @throws KINGException
	 */
	public void loginLogUser(String ip, String lastTime, int uid) throws KINGException{
		userDao.executeSQL("update UserInfo set lastIp='" + ip + "',lastTime='"
				+ lastTime + "' where id=" + uid);
	}
	
	/**
	 * 9.判断用户是否有权限登录系统
	 * @param 用户ID
	 * @return 数量
	 * @throws KINGException
	 */
	public int userExistRole(int uid) throws KINGException{
		String hql = "select count(u.id) from UserRoleData u where u.userId='" +uid+ "'";
		return userDao.search(hql).size();
	}

	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}



}
