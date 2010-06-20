package com.king.web.usermanage.login.action;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.apache.struts2.convention.annotation.Results;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.king.tools.Constants;


@ResultPath("/")
@Results(
		@Result(name="index", location="index.jsp", type="redirect")
)

public class LogoutAction extends FrmAction{

	/**
	 * 1.注销登陆
	 * @return
	 * @throws KINGException
	 */
	public String index() throws KINGException {
		sessionMap.put(Constants.SESSION_SYSTEM_USER, null);
		return "index";
	}
}
