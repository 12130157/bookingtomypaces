package com.king.web.usermanage.dept.action;

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
import com.king.web.usermanage.dept.data.DeptData;
import com.king.web.usermanage.dept.service.IDeptService;
import com.tag.PageVo;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="view/dept/dept_list.jsp"),
	@Result(name="home", location="user/key/home",type="redirectAction"),
	@Result(name="login", location="view/user/login.jsp"),
	@Result(name="addview", location="view/dept/dept_add.jsp"),
	@Result(name="editview", location="view/dept/dept_edit.jsp")
})

public class DeptAction extends FrmAction{

	private IDeptService deptService;
	private List<DeptData> deptList= new ArrayList<DeptData>();
	private DeptData dept =new DeptData();
	
	public String list() throws KINGException{
		System.out.println("----DeptAction.list()----------"+getFrmUser().getUserName());
		if(null==getFrmUser()){
			return "home";
		}
		
		Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
		String name = request.getParameter("name")==null?"":request.getParameter("name").toString();
		Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(curPage);
		//p.setTotalPage(list.size()/p.getPageSize());
		String withsql=" where 1=1 ";
		if(!"".equals(name)){
			withsql+=" and name like '%"+name+"%' ";
		}
		if(status>-1){
			withsql+=" and status ="+status;
		}
		deptList =deptService.searchDept(p, withsql);
		//for(DeptData a:DeptList){
		//	System.out.println(":::"+a.getName()+":list.size="+p.getTotalPage());
		//}
		ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
		String urlStr = "/ordershop/dept/key/list?curPage=";
		ServletActionContext.getRequest().setAttribute("url", urlStr);
		
		return "index";
		
	}
	
	public Integer findByProperty(String name)throws KINGException{
		PageRoll p =new PageRoll();
		p.setPageSize(Constants.PAGE_SIZE);
		p.setStartRow(1);
		
		deptList =deptService.searchDept(p, " where 1=1 and name = '"+name+"' " );
		return p.getTotalRows();
	}
	
	/**
	 * 增加部門
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addDept() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			String name = request.getParameter("name")==null?"":request.getParameter("name").toString();
			Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
			dept.setName(name);
			dept.setStatus(status);
			deptService.addDept(dept);
			Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
			PageRoll p =new PageRoll();
			p.setPageSize(Constants.PAGE_SIZE);
			p.setStartRow(curPage);
			String withsql=" where 1=1 ";
			deptList =deptService.searchDept(p, withsql);
			ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
			String urlStr = "/ordershop/dept/key/list?curPage=";
			ServletActionContext.getRequest().setAttribute("url", urlStr);
			return "index";
		}
	}
	
	/**
	 * 修改部門
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editDept() throws KINGException {
		System.out.println("----editDept----------"+getFrmUser().getUserName());
		if(null==getFrmUser()){
			return "home";
		}else {
			dept=deptService.retrieveDept(request.getParameter("id"));
			String name = request.getParameter("name")==null?"":request.getParameter("name").toString();
			Integer status=request.getParameter("status")==null?-1:Integer.parseInt(request.getParameter("status").toString());
			if(!"".equals(name)){
				dept.setName(name);
			}
			if(status!=-1){
				dept.setStatus(status);
			}
			
			deptService.updateDept(dept);
			Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
			PageRoll p =new PageRoll();
			p.setPageSize(Constants.PAGE_SIZE);
			p.setStartRow(curPage);
			String withsql=" where 1=1 ";
			deptList =deptService.searchDept(p, withsql);
			ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
			String urlStr = "/ordershop/dept/key/list?curPage=";
			ServletActionContext.getRequest().setAttribute("url", urlStr);
			return "index";
		}
	}
	
	/**
	 * 刪除部門
	 * 
	 * @return
	 * @throws WebException
	 */
	public String deleteDept() throws KINGException {
		System.out.println("----deleteDept----------"+getFrmUser().getUserName());
		if(null==getFrmUser()){
			return "home";
		}else {
			dept=deptService.retrieveDept(request.getParameter("id"));
		
			deptService.deleteDept(dept);
			Integer curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage").toString());
			PageRoll p =new PageRoll();
			p.setPageSize(Constants.PAGE_SIZE);
			p.setStartRow(curPage);
			String withsql=" where 1=1 ";
			deptList =deptService.searchDept(p, withsql);
			ServletActionContext.getRequest().setAttribute("page",new PageVo(p.getTotalRows(), curPage, p.getPageSize()));
			String urlStr = "/ordershop/dept/key/list?curPage=";
			ServletActionContext.getRequest().setAttribute("url", urlStr);
			return "index";
		}
	}
	
	/**
	 * 增加部門JSP頁面
	 * 
	 * @return
	 * @throws WebException
	 */
	public String addjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			return "addview";
		}
	}

	/**
	 * 修改部門JSP頁面
	 * 
	 * @return
	 * @throws WebException
	 */
	public String editjsp() throws KINGException {
		if(null==getFrmUser()){
			return "home";
		}else {
			dept=deptService.retrieveDept(request.getParameter("id"));
			return "editview";
		}
	}
	
	
	public IDeptService getDeptService() {
		return deptService;
	}

	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}

	public List<DeptData> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DeptData> deptList) {
		this.deptList = deptList;
	}

	public DeptData getDept() {
		return dept;
	}

	public void setDept(DeptData dept) {
		this.dept = dept;
	}
	
}
