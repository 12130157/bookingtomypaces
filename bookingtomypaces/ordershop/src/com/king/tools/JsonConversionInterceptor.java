/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.tools;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.king.base.FrmAction;
import com.king.common.exception.KINGException;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class JsonConversionInterceptor implements Interceptor{
	
	
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub  
		if(actionInvocation.getAction() instanceof FrmAction){
		HttpServletResponse response = ((FrmAction)actionInvocation.getAction()).getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();
		String value=null;
		strToJson(actionInvocation);
		
		try{
			value = actionInvocation.invoke();
			jsonToStr(actionInvocation);
		}catch(KINGException ex){
			ex.printStackTrace();
			//setJson("{success:true}");
			printWriter.println("{success:false,KINGException:'"+ex.getMessage()+"'}");
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			return value;
		}
		}else{
			String result = actionInvocation.invoke();
			return result;
		}
	}
	/**
	 * 前置拦截方法，用于将页面传过来的json串转换成JSONObject或JSONArray
	 * @param actionInvocation
	 */
	public void strToJson(ActionInvocation actionInvocation){
		if(actionInvocation.getAction() instanceof FrmAction){
		HttpServletRequest request = ((FrmAction)actionInvocation.getAction()).getRequest();
		String jsonData=request.getParameter("jsonData");
		if(jsonData!=null && jsonData.trim().length()!=0){
			//返回值可能是数组，也可能是一个对象，首先判断是否是数组，如果取数组出错，那么取为对象。
			Object rv  = null;
			try{
				rv = JSONArray.fromObject(jsonData);
			}catch(Exception ex){
				rv = JSONObject.fromObject(jsonData);
			}
			
				((FrmAction)(actionInvocation.getAction())).setJson(rv);
	
		}
		else{
			return;
		}
		}else{
			//如果Action没有声明FrmAction作为父类，那么就没有setJson方法
			return;
		}
	}
	/**
	 * 后置拦截方法，用于将后台传过来的JSON实体转换成字符串	
	 * @param actionInvocation
	 */
	public void jsonToStr(ActionInvocation actionInvocation){
		if(actionInvocation.getAction() instanceof FrmAction){
		HttpServletRequest request = ((FrmAction)actionInvocation.getAction()).getRequest();
		HttpServletResponse response = ((FrmAction)actionInvocation.getAction()).getResponse();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
//		request.setAttribute("i18n_locale", request.getLocale().toString());
		try {
			PrintWriter printWriter = response.getWriter();
			//如果Action继承了FrmAction作为父类，那么判断是数组还是对象，转换后向页面输出字符串
				Object json = ((FrmAction) (actionInvocation
						.getAction())).getJson();
				if(json != null){
					if(json instanceof String){
						printWriter.println(json);
					}
					else if(json instanceof JSONObject){
						JSONObject jsonObject = (JSONObject)json;
						printWriter.println(jsonObject.toString());
					} else if (json instanceof JSONArray) {
						JSONArray jsonArray = (JSONArray) json;
						printWriter.println(jsonArray.toString());
					}else{
						return;
					}
				}
				else{
					return;
				}
		
			//如果Action没有声明FrmAction作为父类，那么就没有getJson方法，将参数作为attribute传递
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		else{
			return;
		}
		
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
