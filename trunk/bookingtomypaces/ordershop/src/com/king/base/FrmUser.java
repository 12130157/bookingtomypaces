/**    
* 
* 版本信息：   
* 日期：2010-4-20   
* Copyright @ Corporation 2010    
* 迈步科技 版权所有   
*   
*/
package com.king.base;

public class FrmUser {
	/**
	 * 部门ID
	 */
	private int unitId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
	/**
	 * 用户密码 
	 */
	private String passWord;
	/**
	 * 状态 
	 */
	private int status;
	/**   
	 * unitId   
	 *   
	 * @return  the unitId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public int getUnitId() {
		return unitId;
	}
	/**   
	 * @param unitId the unitId to set   
	 */
	public void setUnitId(int unitId) {
		this.unitId = unitId;
	}
	/**   
	 * userId   
	 *   
	 * @return  the userId   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getUserId() {
		return userId;
	}
	/**   
	 * @param userId the userId to set   
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**   
	 * userName   
	 *   
	 * @return  the userName   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getUserName() {
		return userName;
	}
	/**   
	 * @param userName the userName to set   
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**   
	 * passWord   
	 *   
	 * @return  the passWord   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public String getPassWord() {
		return passWord;
	}
	/**   
	 * @param passWord the passWord to set   
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	/**   
	 * status   
	 *   
	 * @return  the status   
	 * @since   CodingExample Ver(编码范例查看) 1.0   
	 */
	
	public int getStatus() {
		return status;
	}
	/**   
	 * @param status the status to set   
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	  
	/**   
	* 创建一个新的实例 FrmUser.   
	*   
	* @param unitId
	* @param userId
	* @param userName
	* @param passWord
	* @param status   
	*/
	public FrmUser(int unitId, String userId, String userName, String passWord,
			int status) {
		this.unitId = unitId;
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.status = status;
	}
	
	
	
	
		
}
