package com.king.web.usermanage.systemfunction.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.systemfunction.dao.ISystemFunctionDAO;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;

public class SystemFunctionService  extends FrmService implements ISystemFunctionService{

	private ISystemFunctionDAO systemFunctionDao;

	/**
	 * 1.添加系统功能组件信息
	 * @param u 系统功能组件信息
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData addSystemFunction(SystemFunctionData u) throws KINGException{
		systemFunctionDao.add(u);
		return u;
	}
	
	/**
	 * 2.单个删除系统功能组件信息
	 * @param u 系统功能组件信息
	 * @throws KINGException
	 */
	public void deleteSystemFunction(SystemFunctionData u) throws KINGException{
		systemFunctionDao.delete(u);
	}
	
	/**
	 * 3.批量删除系统功能组件信息
	 * @param ids 系统功能组件信息ID数组
	 * @throws KINGException
	 */
	public void deleteSystemFunction(String[] ids) throws KINGException{
		systemFunctionDao.delete(ids);
	}
	
	/**
	 * 4.修改系统功能组件信息
	 * @param u 系统功能组件信息
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData updateSystemFunction(SystemFunctionData u) throws KINGException{
		systemFunctionDao.update(u);
		return u;
	}
	
	/**
	 * 5.查询单个系统功能组件信息
	 * @param id 系统功能组件信息ID
	 * @return 系统功能组件信息
	 * @throws KINGException
	 */
	public SystemFunctionData retrieveSystemFunction(String id) throws KINGException{
		String hql = "from SystemFunctionData u where u.id = '" +id+ "'";
		return (SystemFunctionData) systemFunctionDao.search(hql).get(0);
	}
	
	/**
	 * 6.查询系统功能组件信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> searchSystemFunctions(PageRoll pageRoll,JSONObject jsonu) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from SystemFunctionData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		List list = systemFunctionDao.searchlist(pageRoll,"");
		return list;
	}
	
	/**
	 * 7.按排序查询系统功能组件
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> getSysFun() throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("from SystemFunctionData order by seq asc");
		List<SystemFunctionData> list = systemFunctionDao.search(hql.toString());
		return list;
	}
	
	/**
	 * 8.按系统用户ID查询系统功能组件信息
	 * @param userId
	 * @return 系统功能组件信息集合
	 * @throws KINGException
	 */
	public List<SystemFunctionData> getSysFunByUserId(int userId) throws KINGException{
		StringBuffer hql  = new StringBuffer();
		hql.append("select s from SystemFunctionData s where s.id in(select r.functionId from RoleFunctionData r where r.roleId in(select u.roleId from UserRoleData u where u.userId="
						+ userId + ")" + ")");
		hql.append(" order by s.seq asc,s.id asc");
		List<SystemFunctionData> list = systemFunctionDao.search(hql.toString());
		return list;
	}

	public ISystemFunctionDAO getSystemFunctionDao() {
		return systemFunctionDao;
	}

	public void setSystemFunctionDao(ISystemFunctionDAO systemFunctionDao) {
		this.systemFunctionDao = systemFunctionDao;
	}



}
