package com.king.web.usermanage.dept.service;

import java.util.List;

import com.king.base.FrmService;
import com.king.common.exception.KINGException;
import com.king.tools.PageRoll;
import com.king.web.usermanage.dept.dao.IDeptDAO;
import com.king.web.usermanage.dept.data.DeptData;

public class DeptService extends FrmService implements IDeptService{

	private IDeptDAO deptDao;
	/**
	 * 1.添加用户部门信息
	 * @param u 用户部门信息
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData addDept(DeptData u) throws KINGException{
		deptDao.add(u);
		return u;
	}
	
	/**
	 * 2.单个删除用户部门信息
	 * @param u 用户部门信息
	 * @throws KINGException
	 */
	public void deleteDept(DeptData u) throws KINGException{
		deptDao.delete(u);
	}
	
	/**
	 * 3.批量删除用户部门信息
	 * @param ids 用户部门信息ID数组
	 * @throws KINGException
	 */
	public void deleteDept(String[] ids) throws KINGException{
		deptDao.delete(ids);
	}
	
	/**
	 * 4.修改用户部门信息
	 * @param u 用户部门信息
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData updateDept(DeptData u) throws KINGException{
		deptDao.update(u);
		return u;
	}
	
	/**
	 * 5.查询单个用户部门信息
	 * @param id 用户部门信息ID
	 * @return 用户部门信息
	 * @throws KINGException
	 */
	public DeptData retrieveDept(String id) throws KINGException{
		String hql = "from DeptData u where u.id = '" +id+ "'";
		return (DeptData) deptDao.search(hql).get(0);
	}
	
	/**
	 * 6.查询用户部门信息
	 * @param pageRoll 分页所需要的对象
	 * @param jsonu JSON对象
	 * @return 用户部门信息集合
	 * @throws KINGException
	 */
	public List<DeptData> searchDept(PageRoll pageRoll,String withhql) throws KINGException{
		List<DeptData> list=null;
		StringBuffer hql  = new StringBuffer();
		hql.append("from DeptData ");
		String CountSQL = "select count(*) " + hql.toString();
		pageRoll.setCountSQL(CountSQL);
		pageRoll.setSearchSQL(hql.toString());
		try{
		 list= deptDao.searchlist(pageRoll,withhql);
		//System.out.println("-----list.size()="+list.size());
		//for(DeptData a:list){
		//	System.out.println(":::"+a.getName()+":list.size="+pageRoll.getTotalPage());
		//}
		}catch( Exception  e){
			e.printStackTrace();
			System.out.println("::::::::;"+e);
		}
		
		return list;
	}

	public IDeptDAO getDeptDao() {
		return deptDao;
	}

	public void setDeptDao(IDeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	
}
