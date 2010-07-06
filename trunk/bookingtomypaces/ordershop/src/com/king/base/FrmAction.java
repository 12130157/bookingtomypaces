/**    
*   
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.king.common.cache.CacheUtil;
import com.king.common.exception.IKINGException;
import com.king.common.exception.KINGError;
import com.king.tools.Constants;
import com.king.tools.DateTool;
import com.king.tools.PageRoll;

public abstract class FrmAction implements SessionAware, ServletRequestAware,
		ServletResponseAware {
	
	protected String key = null;

	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	protected Object json = null;

	public Object getJson() {
		return json;
	}


	public void setJson(Object json) {
		this.json = json;
	}


	public HttpServletRequest getRequest() {
		return request;
	}


	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public Map<Object, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<Object, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}

	/**
	 * 内置的request对象，由容器注入。
	 */
	protected HttpServletRequest request;
	/**
	 * 内置的response对象，由容器注入。
	 */
	protected HttpServletResponse response;
	/**
	 * 内置的session对象，由容器注入。
	 */
	protected Map<Object, Object> sessionMap;

	/**
	 * 设置Session Map对象，由容器调用。
	 * 
	 * @param att
	 *            被设置的Session Map对象。
	 * 
	 */
	public void setSession(Map att) {
		this.sessionMap = att;
	}

	/**
	 * 设置HttpServletRequest实例，由容器调用
	 * 
	 * @param request
	 *            被设置的HttpServletRequest实例
	 * 
	 * 
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 设置response实例，供容器调用
	 * 
	 * @param response
	 *            被设置的HttpServletResponse实例
	 * 
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	/**
	 * 将列表转化为json串
	 * @param pageRoll 分页控件
	 * @param list 结果列表
	 * @param containDate 是否包含日期
	 * @return
	 */
	protected String getListJsonStr(PageRoll pageRoll,List list){
		StringBuffer sb = new StringBuffer();
		//处理无值的情况
		if(list==null||list.size()==0){
			sb.append("{'items':[]");
			sb.append(",'results':");
			sb.append(pageRoll.getTotalRows());
			sb.append("}");
			return sb.toString();
		}
		//以下处理有值的情况
		JSONArray jsonArray=null;
		//此处是否是否存在日期类型
		boolean containDate=false;
		Field[] fields = list.get(0).getClass().getDeclaredFields();
		for(Field field:fields){
			if(field.getType().getName().equals("java.util.Date")){
				containDate = true;
				break;
			}
		}
		if(containDate){
			try{
			jsonArray= DateTool.getJSONArray(list,"yyyy-MM-dd");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else{
		    jsonArray = JSONArray.fromObject(list);
		}
		//以下获取cache配置项目，实现自动转换。
		String className = list.get(0).getClass().getSimpleName();
		//此处只是需要配置哪个字段采用哪个cache，专供后台使用。
		//String cacheName = className.replaceFirst("Data","Cache");
		//System.out.println("cacheName:"+cacheName);
		JSONArray names=null;
		Map objectCacheMap = CacheUtil.getInstance().dataCache.getDataMap("ObjectCacheMap");
		
		for(int i=0;i<jsonArray.size();i++){
			JSONObject oneRecord = jsonArray.getJSONObject(i);
			if(names==null){
				names = oneRecord.names();
			}
			for(int j=0;j<names.size();j++){
				Object name = names.get(j);
				//System.out.println("name:"+name);
				String attrCacheName = (String)objectCacheMap.get(className+"."+name);
				if(attrCacheName==null) {
					continue;
				}
				//取得属性cache
				Map attrCache = CacheUtil.getInstance().dataCache.getDataMap(attrCacheName);
				//json值
				Object jsonValue = oneRecord.get(name);
				
				Object captionValue = attrCache.get(jsonValue+"");
				//System.out.println(className+"."+name+"'s cache is "+attrCacheName+":caption of "+jsonValue+" is "+captionValue);
				//替换值
				oneRecord.put(name,captionValue);
			}
		}
		
		//JSONArray names = jsonArray.getJSONObject(0).pu;
		//System.out.println("names:"+names);
		sb.append("{'items':");
		if(jsonArray!=null){
			sb.append(jsonArray.toString());
		}
		sb.append(",'results':");
		sb.append(pageRoll.getTotalRows());
		sb.append("}");
		
		return sb.toString();
		
	}
	/**
	 * 打印系统异常。当异常为KINGException异常时，需要取出
	 * 真正的异常堆栈信息
	 * @param e
	 * 		需要打印的异常
	 */
	public void printException(Exception e) {
		if(e instanceof IKINGException) {
			((KINGError)e).getErrorRoot().printStackTrace();
		}else {
			e.printStackTrace();
		}	
	}
	/**
	 * 从缓存中获取值
	 * @param cacheName
	 * 		缓存名字
	 * @param key
	 * 		键值
	 * @return
	 * 		对应的value
	 */
	public String getValueFromCache(String cacheName, String key) {
		if(key == null) {
			return null;
		}
		return (String)CacheUtil.getInstance().getCacheMap(cacheName).get(key);
	}
	/**
	 * 从缓存中获取值
	 * @param cacheName
	 * 		缓存名字
	 * @param key
	 * 		键值，Integer类型
	 * @return
	 * 		对应的value
	 */
	public String getValueFromCache(String cacheName, Integer key) {
		if(key == null) {
			return null;
		}
		return getValueFromCache(cacheName, key.toString());
	}
	
	/**
	 * 从Session中获取当前登陆用户对象。
	 * @return
	 */
	public FrmUser getFrmUser(){
		FrmUser frmUser = (FrmUser)sessionMap.get(Constants.SESSION_SYSTEM_USER);
		return frmUser;
	}
}
