package com.king.web.usermanage.login.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.web.usermanage.systemfunction.data.SystemFunctionData;
import com.king.web.usermanage.systemfunction.service.ISystemFunctionService;
import com.king.web.usermanage.user.data.UserData;
import com.king.web.usermanage.user.service.IUserService;

//定义页面所在的根目录，如果与struts.xml配置文件中的struts.convention.result.path相同，可以不写。
//跳转的页面只能在@ResultPath定义的路径及其子目录中，action不能跳转到@ResultPath的上级目录中的页面。

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="login", location="view/login/login.jsp"),
	@Result(name="home", location="main.jsp"),
	@Result(name="menu", location="left.jsp")
})
public class IndexAction extends FrmAction{

	private IUserService userService;
	private ISystemFunctionService systemFunctionService;
	private List<SystemFunctionData> funList= new ArrayList<SystemFunctionData>();
	private List<UserData> list = new ArrayList<UserData>();	
	
	/**
	 * 1.成功登陆进入主页面
	 * @return
	 * @throws KINGException
	 */
	public String home() throws KINGException {
		
		System.out.println("------home11111111111111---------");
		if(null==getFrmUser()){
			return "login";
		}
		return "home";
	}
	
	/**
	 * 2.成功登陆获取左边菜单信息
	 * @return
	 * @throws KINGException
	 */
	public String menu() throws KINGException {
		System.out.println("------menu-111111111111111111--------");
		setFunList(systemFunctionService.getSysFunByUserId(1));
		return "menu";
	}

	
	/**---------------------------get()-set()-----------------------------**/	


	public List<SystemFunctionData> getFunList() {
		return funList;
	}

	public void setFunList(List<SystemFunctionData> funList) {
		this.funList = funList;
	}

	public List<UserData> getList() {
		return list;
	}

	public void setList(List<UserData> list) {
		this.list = list;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ISystemFunctionService getSystemFunctionService() {
		return systemFunctionService;
	}

	public void setSystemFunctionService(
			ISystemFunctionService systemFunctionService) {
		this.systemFunctionService = systemFunctionService;
	}


}
