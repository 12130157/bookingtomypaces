package com.king.web.usermanage.user.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.PageRoll;
import com.king.web.usermanage.user.data.UserData;
import com.king.web.usermanage.user.service.IUserService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="login", location="view/login/login.jsp"),
	@Result(name="list", location="view/user/user_list.jsp"),
	@Result(name="edit", location="view/user/user_edit.jsp"),
	@Result(name="add", location="view/user/user_add.jsp")
})

public class UserAction extends FrmAction{

	private IUserService userService;
	private List<UserData> userList= new ArrayList<UserData>();
	private UserData userdata;

	
	/**
	 * 1.用戶列表
	 * @return
	 * @throws KINGException
	 */
	public String staticlist() throws KINGException {
		if(null==getFrmUser()){
			return "login";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		userList =userService.searchUsersList(p, " where 1=1 ");
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
			return "login";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		userList =userService.searchUsersList(p, " where 1=1 and status = 0 ");
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = Constants.ProjectName+"/user/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		return "list";
	}
	
	public String addjsp()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		return "add";
	}

	public String add()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		//System.out.println("unitId=="+request.getParameter("unitId"));
		//System.out.println("userName=="+request.getParameter("userName"));
		System.out.println("unitId=="+userdata.getDeptId());
		System.out.println("userName=="+userdata.getUserName());
		System.out.println("passw=="+userdata.getPassWord());
		userService.addUser(userdata);
		return this.staticlist();
	}
	
	public String editjsp()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		System.out.println("id=="+request.getParameter("id"));
		return "edit";
	}

	public String edit()throws KINGException{
		if(null==getFrmUser()){
			return "login";
		}
		//System.out.println("unitId=="+request.getParameter("unitId"));
		//System.out.println("userName=="+request.getParameter("userName"));
		System.out.println("unitId=="+userdata.getDeptId());
		System.out.println("userName=="+userdata.getUserName());
		System.out.println("passw=="+userdata.getPassWord());
		userService.addUser(userdata);
		
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

}
