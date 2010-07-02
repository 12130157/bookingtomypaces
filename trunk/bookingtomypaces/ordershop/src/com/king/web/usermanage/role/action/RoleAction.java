package com.king.web.usermanage.role.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;



import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Common;
import com.king.tools.Constants;
import com.king.tools.PageRoll;
import com.king.web.usermanage.role.data.RoleData;
import com.king.web.usermanage.role.data.RoleFunctionData;
import com.king.web.usermanage.role.data.RoleFunctionData1;
import com.king.web.usermanage.role.service.IRoleFunctionService;
import com.king.web.usermanage.role.service.IRoleService;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;
import com.king.web.usermanage.systemfunction.service.ISystemFunctionService;
import com.king.tools.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="view/role/role_list.jsp"),
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="login", location="view/user/login.jsp"),
	@Result(name="addview", location="view/role/role_add.jsp"),
	@Result(name="editview", location="view/role/role_edit.jsp")
})

public class RoleAction extends FrmAction{

	public IRoleService roleService;
	public List<RoleData> roleList=new ArrayList<RoleData>();
	public IRoleFunctionService roleFunctionService;
	private String funId;
	private List<SystemFunctionData> funList;
	private ISystemFunctionService systemFunctionService;
	private RoleData role =new RoleData();
	private HashMap ht = new HashMap();
	public Common common=new Common();
	
	
	
	public String list() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}

		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		String name = request.getParameter("name")==null?"":request.getParameter("name").toString();
		String memo = request.getParameter("memo")==null?"":request.getParameter("memo").toString();
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		String withsql=" where 1=1 ";
		if(!"".equals(name)){
			withsql+=" and name like '%"+name+"%' ";
		}
		if(!"".equals(memo)){
			withsql+=" and memo like '%"+memo+"%' ";
		}
		roleList =roleService.searchRoles(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/role/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}
	
	public String staticlist() throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		
		String withsql=" where 1=1 ";
		
		roleList =roleService.searchRoles(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/role/key/list?curPage=";
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
			List<RoleFunctionData> fun = new ArrayList<RoleFunctionData>();
			RoleData r = new RoleData();
			r.setName(request.getParameter("name"));
			r.setMemo(request.getParameter("memo"));
			if (null != getFunId()) {
				String[] fId = getFunId().split(",");
				
				Integer uId = 0;
				for (String id : fId) {
					uId = Integer.parseInt(id);
					if (0 < uId) {// 去掉checkbox值为0的选项
						RoleFunctionData rf = new RoleFunctionData();
						rf.setFunctionId(uId);
						rf.setRoleData(r);
						fun.add(rf);
					}
				}
				
				r.setRfdata(fun);
			}
			roleService.addRole(r);
			return this.staticlist();
		}
	}
	
	/**
	 * 修改角色
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editRole() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			List<RoleFunctionData> fun = new ArrayList<RoleFunctionData>();
			RoleData r =roleService.retrieveRole(request.getParameter("id"));
			r.setName(request.getParameter("name"));
			r.setMemo(request.getParameter("memo"));
			
			// r.setAccountSetId(this.checkUser().getAccountSetId());
			// Integer[] fId = getFunId();
			if (null != getFunId()) {
				String buf=getFunId().replace("0,", "");
				String[] fId = buf.split(",");
				roleFunctionService.deleteRoleFunction(request.getParameter("id"));
				Integer uId = 0;
				for (String id : fId) {
					uId = Integer.parseInt(id);
					if (0 < uId) {// 去掉checkbox值为0的选项
						RoleFunctionData rf = new RoleFunctionData();
						
						rf.setFunctionId(uId);
						rf.setRoleData(r);
						fun.add(rf);
					}
				}
			
				r.setRfdata(fun);
			}
			roleService.updateRole(r);
			return this.staticlist();
		}
	}
	
	/**
	 * 增加角色JSP頁面
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
	
	
	/**
	 * 修改角色JSP頁面
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			role =roleService.retrieveRole(request.getParameter("id"));
			List<RoleFunctionData1> list=roleFunctionService.getUserRole(request.getParameter("id"));
			for(RoleFunctionData1 rf:list){
				ht.put(rf.getFunctionId(), rf.getFunctionId()+"");//注意數據類型，頁面可能對比不了
			}
			
			funList=systemFunctionService.getSysFun();
			return "editview";
		}
	}
	
	
	/**
	 * 刪除角色
	 * 
	 * @return
	 * @throws WebException
	 */
	public String deleteRole() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			role =roleService.retrieveRole(request.getParameter("id"));
			roleService.deleteRole(role);
			return this.staticlist();
		}
	}
	

	public HashMap getHt() {
		return ht;
	}
	public void setHt(HashMap ht) {
		this.ht = ht;
	}
	public RoleData getRole() {
		return role;
	}
	public void setRole(RoleData role) {
		this.role = role;
	}
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
}
