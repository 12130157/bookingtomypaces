package com.king.web.usermanage.user.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.Md5Tools;
import com.king.base.FrmAction;
import com.king.common.cache.CacheUtil;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.DateTool;
import com.king.tools.PageRoll;
import com.king.web.usermanage.dept.data.DeptData;
import com.king.web.usermanage.dept.service.IDeptService;
import com.king.web.usermanage.role.data.RoleData;
import com.king.web.usermanage.role.data.RoleFunctionData1;
import com.king.web.usermanage.role.service.IRoleFunctionService;
import com.king.web.usermanage.role.service.IRoleService;
import com.king.web.usermanage.store.data.StoreData;
import com.king.web.usermanage.store.service.IStoreService;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;
import com.king.web.usermanage.systemfunction.service.ISystemFunctionService;
import com.king.web.usermanage.user.data.UserData;
import com.king.web.usermanage.user.data.UserFunctionData;
import com.king.web.usermanage.user.service.IUserFunctionService;
import com.king.web.usermanage.user.service.IUserService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="login", location="view/login/login.jsp"),
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="list", location="view/user/user_list.jsp"),
	@Result(name="editjsp", location="view/user/user_edit.jsp"),
	@Result(name="resetpwdjsp", location="view/user/resetpwd.jsp"),
	@Result(name="addjsp", location="view/user/user_add.jsp"),
	@Result(name="funcjsp", location="view/user/func.jsp")
})

public class UserAction extends FrmAction{

	private IUserService userService;
	private IDeptService deptService;
	private IStoreService storeService;
	private IUserFunctionService userFunctionService;
	private ISystemFunctionService systemFunctionService;
	private String funId;
	private String uId;
	private List<SystemFunctionData> funList;
	public IRoleService roleService;
	public List<RoleData> roleList=new ArrayList<RoleData>();
	public IRoleFunctionService roleFunctionService;
	private RoleData role =new RoleData();
	private HashMap ht = new HashMap();
	private List<UserData> userList= new ArrayList<UserData>();
	private UserData userdata;
	TreeMap areaMap =new TreeMap();
	TreeMap deptMap = new TreeMap();
	TreeMap storeMap = new TreeMap();
	TreeMap roleMap = new TreeMap();
	/**
	 * 1.用戶列表
	 * @return
	 * @throws KINGException
	 */
	public String staticlist() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}
		//區域信息
		areaMap=CacheUtil.getInstance().getCacheMap("SystemArea");//in conf->cache->data->data.xml
		/*Iterator   it=areaMap.keySet().iterator(); 
		while(it.hasNext()){ 
		String   key=(String)it.next(); 
		String   val=(String) areaMap.get(key); 
		System.out.println(key.toString()); 
		System.out.println(val.toString()); 
		}*/
		//店鋪資料
		PageRoll p2 =new PageRoll();
		p2.setPageSize(1000);
		p2.setStartRow(1);
		List<StoreData> liststore=storeService.searchStores(p2, " where 1=1 and status =0 ");
		for(StoreData s:liststore){
			storeMap.put(s.getId(), s.getName());
		}
		//部門信息
		PageRoll p1 =new PageRoll();
		p1.setPageSize(1000);
		p1.setStartRow(1);
		List<DeptData> listdept=deptService.searchDept(p1, " where 1=1 and status =0 ");
		for(DeptData d:listdept){
			deptMap.put(d.getId(), d.getName());
		}
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		userList =userService.searchUsersList(p, " where 1=1  and userName<>'admin' ");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr =Constants.ProjectName+"/user/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	/**
	 * 1.用戶列表
	 * @return
	 * @throws KINGException
	 */
	public String list() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}
		//區域信息
		areaMap=CacheUtil.getInstance().getCacheMap("SystemArea");//in conf->cache->data->data.xml
		/*Iterator   it=areaMap.keySet().iterator(); 
		while(it.hasNext()){ 
		String   key=(String)it.next(); 
		String   val=(String) areaMap.get(key); 
		System.out.println(key.toString()); 
		System.out.println(val.toString()); 
		}*/
		//店鋪資料
		PageRoll p2 =new PageRoll();
		p2.setPageSize(1000);
		p2.setStartRow(1);
		List<StoreData> liststore=storeService.searchStores(p2, " where 1=1 and status =0 ");
		for(StoreData s:liststore){
			storeMap.put(s.getId(), s.getName());
		}
		//部門信息
		PageRoll p1 =new PageRoll();
		p1.setPageSize(1000);
		p1.setStartRow(1);
		List<DeptData> listdept=deptService.searchDept(p1, " where 1=1 and status =0 ");
		for(DeptData d:listdept){
			deptMap.put(d.getId(), d.getName());
		}
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		String deptId = request.getParameter("deptId")==null?"0":request.getParameter("deptId").toString();
		String userName = request.getParameter("userName")==null?"":request.getParameter("userName").toString();
		String realName = request.getParameter("realName")==null?"":request.getParameter("realName").toString();
		String mobile = request.getParameter("mobile")==null?"":request.getParameter("mobile").toString();
		String areaId = request.getParameter("areaId")==null?"0":request.getParameter("areaId").toString();
		String shopId = request.getParameter("shopId")==null?"0":request.getParameter("shopId").toString();
		Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		String withsql=" where 1=1 and userName<>'admin' ";
		if(!"0".equals(deptId)){
			withsql+=" and deptId = '"+deptId+"' ";
		}
		if(!"".equals(userName)){
			withsql+=" and userName = '"+userName+"' ";
		}
		if(!"".equals(mobile)){
			withsql+=" and mobile = '"+mobile+"' ";
		}
		if(!"0".equals(areaId)){
			withsql+=" and areaId = '"+areaId+"' ";
		}
		if(!"0".equals(shopId)){
			withsql+=" and shopId = '"+shopId+"' ";
		}
		if(!"".equals(realName)){
			withsql+=" and realName like '%"+realName+"%' ";
		}
		if(status>-1){
			withsql+=" and status = "+status;
		}
		userList =userService.searchUsersList(p, withsql);
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/user/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	public String addjsp()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		areaMap=CacheUtil.getInstance().getCacheMap("SystemArea");//in conf->cache->data->data.xml
		//店鋪資料
		PageRoll p2 =new PageRoll();
		p2.setPageSize(1000);
		p2.setStartRow(1);
		List<StoreData> liststore=storeService.searchStores(p2, " where 1=1 and status =0 ");
		
		for(StoreData s:liststore){
	
			storeMap.put(s.getId(), s.getName());
		}
		//部門信息
		PageRoll p1 =new PageRoll();
		p1.setPageSize(1000);
		p1.setStartRow(1);
		List<DeptData> listdept=deptService.searchDept(p1, " where 1=1 and status =0 ");
	
		for(DeptData d:listdept){
			deptMap.put(d.getId(), d.getName());
		}
		return "addjsp";
	}

	public String addUser()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		//System.out.println("unitId=="+request.getParameter("unitId"));
		//System.out.println("userName=="+request.getParameter("userName"));
		System.out.println("unitId=="+userdata.getDeptId());
		System.out.println("userName=="+userdata.getUserName());
		System.out.println("passw=="+userdata.getPassWord());
		userdata.setPassWord(Md5Tools.encode(userdata.getPassWord()));
		userdata.setCreatTime(DateTool.getNow());
		userService.addUser(userdata);
		return this.staticlist();
	}
	
	public String editjsp()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		areaMap=CacheUtil.getInstance().getCacheMap("SystemArea");//in conf->cache->data->data.xml
		//店鋪資料
		PageRoll p2 =new PageRoll();
		p2.setPageSize(1000);
		p2.setStartRow(1);
		List<StoreData> liststore=storeService.searchStores(p2, " where 1=1 and status =0 ");
		for(StoreData s:liststore){
			storeMap.put(s.getId(), s.getName());
		}
		//部門信息
		PageRoll p1 =new PageRoll();
		p1.setPageSize(1000);
		p1.setStartRow(1);
		List<DeptData> listdept=deptService.searchDept(p1, " where 1=1 and status =0 ");
		for(DeptData d:listdept){
			deptMap.put(d.getId(), d.getName());
		}
		userdata = userService.retrieveUser(request.getParameter("id"));
		return "editjsp";
	}

	public String resetpwd()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		
		userdata = userService.retrieveUser(getFrmUser().getUserId());
		return "resetpwdjsp";
	}
	
	public String editpwd()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		UserData user = userService.retrieveUser(userdata.getId());
		if(!user.getPassWord().equals(userdata.getPassWord())&&!"".equals(userdata.getPassWord())&&null!=userdata.getPassWord()){
			user.setPassWord(Md5Tools.encode(userdata.getPassWord()));
		}else{
			user.setPassWord(user.getPassWord());
		}
		
		userService.updateUser(user);
		
		return this.staticlist();
	}
	
	
	public String editUser()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		UserData user = userService.retrieveUser(userdata.getId());
		if(!user.getPassWord().equals(userdata.getPassWord())&&!"".equals(userdata.getPassWord())&&null!=userdata.getPassWord()){
			userdata.setPassWord(Md5Tools.encode(userdata.getPassWord()));
		}else{
			userdata.setPassWord(user.getPassWord());
		}
		
		userService.updateUser(userdata);
		
		return this.staticlist();
	}
	
	public String updateUser()throws KINGException{
		if(null==getFrmUser()){
			return "home";
		}
		userdata=userService.retrieveUser(request.getParameter("id"));
		Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
		if(status>-1){
			userdata.setStatus(status);
		}
		userService.updateUser(userdata);
		
		return this.staticlist();
	}
	
	public Integer findByProperty(String name)throws KINGException{
		System.out.println("findByProperty.name=="+name);
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(1);
		userList =userService.searchUsersList(p, " where 1=1 and userName='"+name+"' ");
		System.out.println("findByProperty.count=="+p.getTotalRows()+":::"+userList.size());
		return p.getTotalRows();
	}
	
	
	public String funcjsp()throws KINGException{
		PageRoll p =new PageRoll();
		p.setPageSize(100);
		p.setStartRow(1);
		roleList=roleService.searchRoles(p, "");
		for(RoleData r:roleList){
			roleMap.put(r.getId(), r.getName());
		}
		
		System.out.println("funcjsp.id============="+request.getParameter("id"));
		List<UserFunctionData> list=userFunctionService.getUserFunction(request.getParameter("id"));
		for(UserFunctionData ur:list){
			ht.put(ur.getFuncId(), ur.getFuncId()+"");//注意數據類型，頁面可能對比不了
		}
		uId=request.getParameter("id");
		funList=systemFunctionService.getSysFun();
		return "funcjsp";
	}
	
	
	/**
	 * 修改權限
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editfunc() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			
			String rId=request.getParameter("rId");
			if(rId.equals("0")){
				if (null != getFunId()) {
					String buf=getFunId().replace("0,", "");
					String[] fId = buf.split(",");
					userFunctionService.deleteUserFunction(request.getParameter("uId"));
					Integer funcId = 0;
					for (String id : fId) {
						funcId = Integer.parseInt(id);
						if (0 < funcId) {
							UserFunctionData ur = new UserFunctionData();
							ur.setUserId(request.getParameter("uId"));
							ur.setFuncId(funcId);
							userFunctionService.addUserFunction(ur);
						}
					}
				}
			}else{
				userFunctionService.deleteUserFunction(request.getParameter("uId"));
				List<RoleFunctionData1> lr=roleFunctionService.getUserRole(rId);
				for(RoleFunctionData1 r:lr){
					UserFunctionData ur = new UserFunctionData();
					ur.setUserId(request.getParameter("uId"));
					ur.setFuncId(r.getFunctionId());
					userFunctionService.addUserFunction(ur);
				}
			}
			return this.staticlist();
		}
	}
	/**---------------------------get()-set()-----------------------------**/	

	public List<UserData> getUserList() {
		return userList;
	}


	public void setUserList(List<UserData> userList) {
		this.userList = userList;
	}


	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public UserData getUserdata() {
		return userdata;
	}

	public void setUserdata(UserData userdata) {
		this.userdata = userdata;
	}

	/**
	 * @return the areaMap
	 */
	public TreeMap getAreaMap() {
		return areaMap;
	}

	/**
	 * @param areaMap the areaMap to set
	 */
	public void setAreaMap(TreeMap areaMap) {
		this.areaMap = areaMap;
	}

	/**   
	 * deptService   
	 *   
	 * @return  the deptService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IDeptService getDeptService() {
		return deptService;
	}

	/**   
	 * @param deptService the deptService to set   
	 */
	
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	/**   
	 * storeService   
	 *   
	 * @return  the storeService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IStoreService getStoreService() {
		return storeService;
	}

	/**   
	 * @param storeService the storeService to set   
	 */
	
	public void setStoreService(IStoreService storeService) {
		this.storeService = storeService;
	}

	/**   
	 * deptMap   
	 *   
	 * @return  the deptMap   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public TreeMap getDeptMap() {
		return deptMap;
	}

	/**   
	 * @param deptMap the deptMap to set   
	 */
	
	public void setDeptMap(TreeMap deptMap) {
		this.deptMap = deptMap;
	}

	/**   
	 * storeMap   
	 *   
	 * @return  the storeMap   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public TreeMap getStoreMap() {
		return storeMap;
	}

	/**   
	 * @param storeMap the storeMap to set   
	 */
	
	public void setStoreMap(TreeMap storeMap) {
		this.storeMap = storeMap;
	}

	
	

	/**   
	 * systemFunctionService   
	 *   
	 * @return  the systemFunctionService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public ISystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}

	/**   
	 * @param systemFunctionService the systemFunctionService to set   
	 */
	
	public void setSystemFunctionService(
			ISystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
	}

	/**   
	 * funId   
	 *   
	 * @return  the funId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getFunId() {
		return funId;
	}

	/**   
	 * @param funId the funId to set   
	 */
	
	public void setFunId(String funId) {
		this.funId = funId;
	}

	/**   
	 * funList   
	 *   
	 * @return  the funList   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public List<SystemFunctionData> getFunList() {
		return funList;
	}

	/**   
	 * @param funList the funList to set   
	 */
	
	public void setFunList(List<SystemFunctionData> funList) {
		this.funList = funList;
	}

	/**   
	 * ht   
	 *   
	 * @return  the ht   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public HashMap getHt() {
		return ht;
	}

	/**   
	 * @param ht the ht to set   
	 */
	
	public void setHt(HashMap ht) {
		this.ht = ht;
	}

	/**   
	 * roleService   
	 *   
	 * @return  the roleService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IRoleService getRoleService() {
		return roleService;
	}

	/**   
	 * @param roleService the roleService to set   
	 */
	
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	/**   
	 * roleList   
	 *   
	 * @return  the roleList   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public List<RoleData> getRoleList() {
		return roleList;
	}

	/**   
	 * @param roleList the roleList to set   
	 */
	
	public void setRoleList(List<RoleData> roleList) {
		this.roleList = roleList;
	}

	/**   
	 * roleFunctionService   
	 *   
	 * @return  the roleFunctionService   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public IRoleFunctionService getRoleFunctionService() {
		return roleFunctionService;
	}

	/**   
	 * @param roleFunctionService the roleFunctionService to set   
	 */
	
	public void setRoleFunctionService(IRoleFunctionService roleFunctionService) {
		this.roleFunctionService = roleFunctionService;
	}

	/**   
	 * role   
	 *   
	 * @return  the role   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public RoleData getRole() {
		return role;
	}

	/**   
	 * @param role the role to set   
	 */
	
	public void setRole(RoleData role) {
		this.role = role;
	}

	/**   
	 * uId   
	 *   
	 * @return  the uId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getuId() {
		return uId;
	}

	/**   
	 * @param uId the uId to set   
	 */
	
	public void setuId(String uId) {
		this.uId = uId;
	}

	/**   
	 * roleMap   
	 *   
	 * @return  the roleMap   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public TreeMap getRoleMap() {
		return roleMap;
	}

	/**   
	 * @param roleMap the roleMap to set   
	 */
	
	public void setRoleMap(TreeMap roleMap) {
		this.roleMap = roleMap;
	}

	public IUserFunctionService getUserFunctionService() {
		return userFunctionService;
	}

	public void setUserFunctionService(IUserFunctionService userFunctionService) {
		this.userFunctionService = userFunctionService;
	}

	
	

}
