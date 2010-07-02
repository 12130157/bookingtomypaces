package com.king.web.usermanage.user.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.DaoFactory;
import com.king.base.FrmService;
import com.king.base.HibernateDao;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.dao.IUserFunctionDAO;
import com.king.web.usermanage.user.data.UserFunctionData;

public class UserFunctionService extends FrmService implements IUserFunctionService{

	private IUserFunctionDAO userFunctionDAO;
	
	/**
	 * 添加系统用户功能信息
	 * @param u 系统用户功能信息
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData addUserFunction(UserFunctionData u) throws KINGException{
		userFunctionDAO.add(u);
		return u;
	}
	
	/**
	 * 单个删除系统用户功能信息
	 * @param u 系统用户功能信息
	 * @throws KINGException
	 */
	public void deleteUserFunction(UserFunctionData u) throws KINGException{
		userFunctionDAO.delete(u);
	}
	
	/**
	 * 批量删除系统用户功能信息
	 * @param ids 系统用户功能信息ID数组
	 * @throws KINGException
	 */
	public void deleteUserFunction(String[] ids) throws KINGException{
		userFunctionDAO.delete(ids);
	}
	
	/**
	 * 修改系统用户功能信息
	 * @param u 系统用户功能信息
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData updateUserFunction(UserFunctionData u) throws KINGException{
		userFunctionDAO.update(u);
		return u;
	}
	
	/**
	 * 查询单个系统用户功能信息
	 * @param id 系统用户功能信息ID
	 * @return 系统用户功能信息
	 * @throws KINGException
	 */
	public UserFunctionData retrieveUserFunction(String id) throws KINGException{
		String hql = "from UserFunctionData u where u.id = '" +id+ "'";
		return (UserFunctionData) userFunctionDAO.search(hql).get(0);
	}
	
	/**
	 * 查询系统用户功能信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统用户功能信息集合
	 * @throws KINGException
	 */
	public List<UserFunctionData> searchUserFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from UserFunctionData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = userFunctionDAO.searchlist(pageRoll,"");
		return list;
	}
	
	/**
	 * 查询用戶功能信息
	 * @param userId
	 * @return 用戶功能信息集合
	 * @throws KINGException
	 */
	public List<UserFunctionData> getUserFunction(String userId)throws KINGException{
		String hql = "from UserFunctionData u where u.userId = '" +userId+ "'";
		
		return  (List<UserFunctionData>)((HibernateDao) DaoFactory.getDao("hibernate")).search(hql);
	}

	
	/**
	 * 删除某个用戶所带功能信息
	 * @param userId 用戶ID
	 * @throws KINGException
	 */
	public void deleteUserFunction(String userId) throws KINGException{
		userFunctionDAO.executeSQL("delete from userfunction where userId = '"+userId+"'");
	}

	public IUserFunctionDAO getUserFunctionDAO() {
		return userFunctionDAO;
	}

	public void setUserFunctionDAO(IUserFunctionDAO userFunctionDAO) {
		this.userFunctionDAO = userFunctionDAO;
	}
	
	

}
