package com.king.web.usermanage.role.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;



import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.data.RoleData;
import com.king.web.usermanage.role.data.RoleFunctionData;
import com.king.web.usermanage.role.service.IRoleFunctionService;
import com.king.web.usermanage.role.service.IRoleService;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;
import com.king.web.usermanage.systemfunction.service.ISystemFunctionService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="view/role/role_list.jsp"),
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="login", location="view/user/login.jsp"),
	@Result(name="addview", location="view/role/role_add.jsp")
})

public class RoleAction extends FrmAction{

	public IRoleService roleService;
	public List<RoleData> roleList=new ArrayList<RoleData>();
	public IRoleFunctionService roleFunctionService;
	private String funId;
	private List<SystemFunctionData> funList;
	private ISystemFunctionService systemFunctionService;
	
	
	public ISystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}
	public void setSystemFunctionService(
			ISystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
	}
	public List<SystemFunctionData> getFunList() {
		return funList;
	}
	public void setFunList(List<SystemFunctionData> funList) {
		this.funList = funList;
	}
	public IRoleFunctionService getRoleFunctionService() {
		return roleFunctionService;
	}
	public void setRoleFunctionService(IRoleFunctionService roleFunctionService) {
		this.roleFunctionService = roleFunctionService;
	}
	public String getFunId() {
		return funId;
	}
	public void setFunId(String funId) {
		this.funId = funId;
	}
	public IRoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public List<RoleData> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<RoleData> roleList) {
		this.roleList = roleList;
	}
	
	public String list() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		//p.setTotalPage(list.size()/p.getPageSize());
		
		roleList =roleService.searchRoles(p, "");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/booking/role/key/index?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}
	
	/**
	 * 增加角色
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addRole() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			Set<RoleFunctionData> fun = new HashSet();
			RoleData r = new RoleData();
			r.setName(request.getParameter("name"));
			r.setMemo(request.getParameter("memo"));
			roleService.addRole(r);
			// r.setAccountSetId(this.checkUser().getAccountSetId());
			// Integer[] fId = getFunId();
			if (null != getFunId()) {
				String[] fId = getFunId().split(",");
				RoleFunctionData rf = null;
				Integer uId = 0;
				for (String id : fId) {
					uId = Integer.parseInt(id);
					if (0 < uId) {// 去掉checkbox值为0的选项
						rf = new RoleFunctionData();
						rf.setFunctionId(uId);
						rf.setRoleId(Integer.parseInt(r.getId()));
						roleFunctionService.addRoleFunction(rf);
					}
				}
			}
			
			return this.list();
		}
	}
	
	
	/**
	 * 增加角色
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			funList=systemFunctionService.getSysFun();
			return "addview";
		}
	}
	
}
