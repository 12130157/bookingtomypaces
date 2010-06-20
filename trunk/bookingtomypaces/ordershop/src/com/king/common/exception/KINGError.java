/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.common.exception;

import java.util.HashMap;

import com.king.base.SpringContextHelper;
import com.king.common.cache.ExceptionCache;

public class KINGError extends RuntimeException implements IKINGException{

	private String errorCode = null;
	
	private HashMap parameters = new HashMap();
	
	private Exception errorRoot = null;
	
	private String errorName = null;
	
	private String errorCause = null;
	
	private String errorSolution = null;
	
	public KINGError(String code, String cause, String name, String solution) {
		this.errorCode = code;
		this.errorCause = cause;
		this.errorName = name;
		this.errorSolution = solution;
	}
	
	public KINGError(Exception errorRoot){
		this.errorRoot=errorRoot;
	}
	
	public KINGError(String errorCode) {
		this.errorCode = errorCode;
		make();
	}
	
	public KINGError(String errorCode, String parameters) {
		this.errorCode = errorCode.trim();
		parameters = parameters + ";";
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(
				parameters.trim(), ";");
		String element = null;
		int colonIndex = -1;
		while (tokens.hasMoreElements()) {
			element = tokens.nextToken();
			colonIndex = element.indexOf(":");
			this.parameters.put(element.substring(0, colonIndex), element
					.substring(colonIndex + 1));
		}
		make();
	}
	
	public KINGError(String errorCode, Exception errorRoot) {
		//this.printStackTrace();
		this.errorCode = errorCode.trim();
		this.errorRoot = errorRoot;
		make();
	}
	
	public KINGError(String errorCode, String parameters,
			Exception errorRoot){
		this.errorCode = errorCode.trim();
		this.errorRoot = errorRoot;
		java.util.StringTokenizer tokens = new java.util.StringTokenizer(
				parameters.trim(), ";");
		String element = null;
		int colonIndex = -1;
		while (tokens.hasMoreElements()) {
			element = tokens.nextToken();
			colonIndex = element.indexOf(":");
			this.parameters.put(element.substring(0, colonIndex), element
					.substring(colonIndex));
		}
		make();
	}
	
	public String getErrorCode() {
		return this.errorCode;
	}
	
	public HashMap getParameters() {
		return this.parameters;
	}
	
	public Exception getErrorRoot() {
		return this.errorRoot;
	}
	
	public String getErrorName() {
		return this.errorName;
	}
	
	public String getErrorCause() {
		return this.errorCause;
	}
	
	public String getErrorSolution() {
		return this.errorSolution;
	}
	
	public String toString() {
		StringBuffer rv = new StringBuffer();
		rv.append(errorCode);
		if (errorName != null) {
			rv.append("_");
			rv.append(errorName);
		}
		if (errorCause != null) {
			rv.append("_");
			rv.append(errorCause);
		}
		if (errorSolution != null) {
			rv.append("_");
			rv.append(errorSolution);
		}
		return rv.toString();
	}
	
	public String getMessage(){
		return toString();
	}
	
	private void make() {
		ExceptionCache exCache = (ExceptionCache)SpringContextHelper.getBean("exceptionCache");
		KINGError ex = exCache.getError(errorCode);
		if (ex == null){
			ex = new KINGError(errorCode,"","","");
			exCache.updateCache(errorCode, ex);
			try{
				exCache.saveCache();
			}catch(KINGError vwpEx){
				vwpEx.printStackTrace();
			}
			catch(Exception ex1){
				ex1.printStackTrace();
			}
		}
		errorName = ex.getErrorName();
		errorCause = ex.getErrorCause();
		errorSolution = ex.getErrorSolution();
		Object[] keys = parameters.keySet().toArray();
		for (int i = 0; i < keys.length; i++) {
			Object value = parameters.get(keys[i]);
			String indexStr = "[" + keys[i] + "]";
			int index = errorCause.indexOf(indexStr);

			while (index != -1) {
				errorCause = errorCause.substring(0, index) + value
						+ errorCause.substring(index + indexStr.length());
				index = errorCause.indexOf(indexStr);
			}
			index = errorSolution.indexOf(indexStr);
			while (index != -1) {
				errorSolution = errorSolution.substring(0, index) + value
						+ errorSolution.substring(index + indexStr.length());
				index = errorSolution.indexOf(indexStr);
			}

		}
	}
}
