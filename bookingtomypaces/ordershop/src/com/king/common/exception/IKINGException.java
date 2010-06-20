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

public interface IKINGException {
	public String getErrorCode();
	
	public HashMap getParameters();
	
	public Exception getErrorRoot();
	
	public String getErrorName();
	
	public String getErrorCause();
	
	public String getErrorSolution();
	
	public String getMessage();	
}
