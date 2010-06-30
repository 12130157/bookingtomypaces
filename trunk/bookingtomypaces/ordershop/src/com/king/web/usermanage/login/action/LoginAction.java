package com.king.web.usermanage.login.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.common.Md5Tools;
import com.king.base.FrmAction;
import com.king.base.FrmUser;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;
import com.king.tools.DateTool;
import com.king.web.usermanage.user.data.UserData;
import com.king.web.usermanage.user.service.IUserService;

@ResultPath("/")
//定义具体的页面及其对应的返回值。
@Results({
	@Result(name="index", location="index.jsp", type="redirect"),
	@Result(name="home", location="index/key/home",type="redirectAction"),
	@Result(name="login", location="view/login/login.jsp")
})
public class LoginAction extends FrmAction{

	private IUserService userService;
	private String name;
	private String pwd;
	
	/**
	 * 1.进入登陆页面
	 * @return
	 * @throws KINGException
	 */
	public String login() throws KINGException {
		System.out.println("------logined222222222--------");
		return "login";
	}
	
	/**
	 * 2.登陆操作
	 * @return
	 * @throws KINGException
	 */
	public String logined() throws KINGException {
		System.out.println("------logined11111111111---------");
		String result = "login";
		name="admin";
		pwd="888";
		//UserData u = userService.login(name, Md5Tools.encode(pwd));
		UserData u = userService.login("admin", Md5Tools.encode("888"));
		if (null == u) {
			// setUerror(false);
			request.setAttribute("error", "用户名或密码错");// 用户名或密码错
			return result;
		} else {
			if (1 == u.getStatus()) {
				request.setAttribute("error", "用户已过期或被锁定,请联系管理员!");// 用户已过期或被锁定,请联系管理员!
				return result;
			} else {
				int b = userService.userExistRole(Integer.parseInt(u.getId()));
				if (b<1) {
					request.setAttribute("error", "你没有权限登录,请联系管理员!");// 你没有权限登录,请联系管理员!
			 		return result;
				} else {
					String ip = ServletActionContext.getRequest().getRemoteAddr(); // 获得来路IP
					
					userService.loginLogUser(ip, DateTool.getStringDate(),Integer.parseInt(u.getId()));

					// session记录用户
					//ActionContext.getContext().getSession().put(IConstant.USER_SESSION_KEY, u);
					sessionMap.put(Constants.SESSION_SYSTEM_USER, new FrmUser(u.getDeptId(),u.getId(),u.getUserName(),u.getPassWord(),u.getStatus(),u.getRealName(),u.getMobile(),u.getAreaId(),u.getShopId(),u.getIsHeadOffice(),u.getLastTime(),u.getLastIp()));
					return "home";

				}
			}
		}
	}

	/**---------------------------get()-set()-----------------------------**/	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

}
