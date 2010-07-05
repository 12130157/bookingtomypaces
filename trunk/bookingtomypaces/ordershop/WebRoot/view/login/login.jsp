<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BannerShop Integration Platform</title>
<link href="<%=request.getContextPath()%>/css/style.css" type="text/css" rel="stylesheet">
<style type="text/css">
<!--
.style1 {
	font-size: 18px;
	font-weight: bold;
	color: #000000;
}
.style2 {font-size: 16px}
.style3 {color: #FFFFFF}
-->
</style>
</head>
<script language="javascript" type="text/javascript">
	
	function userlogin(){
	   // alert((document.getElementById("loginUserInfo.username")).value)
		//window.location.href="default.html";
		if((document.getElementById("name")).value==''){
		    alert("請輸入用戶帳號!");
 			//document.loginForm.username.focus();
 			return false;
		}
		//if(isChinese(document.loginForm.username.value)){
 		//	alert("用户名只能是字母和数字,请重新输入!");
 		//	document.loginForm.username.focus();
 		//	return false;
 		//}
 		if((document.getElementById("pwd")).value == ''){
 			alert("請輸入密碼!");
 			//document.loginForm.loginUserInfo.password.focus();
 			return false;
	 	}
 		//if(isChinese(document.loginForm.userpw.value)){
 		//	alert("密码只能是字母和数字,请重新输入!");
 		//	document.loginForm.userpw.focus();
 		//	return false;
 		//}
 		//document.forms[0].action="<%=request.getContextPath()%>/user_login/key/logined";
 		document.forms[0].action="<%=request.getContextPath()%>/login/key/logined";
		document.forms[0].submit();
	}
</script>
<s:if test="str_msg!=''&&str_msg!=null">
 <%out.write("<script>alert('"+request.getAttribute("str_msg")+"')</script>"); %>
</s:if>
<body scroll="no">
<s:form action="user_login/key/home" method="post" >
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" valign="middle"><table width="100%" height="340" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td height="90" align="center"><table width="498" height="95" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" valign="bottom"><p class="style1 style2">BannerShop Integration Platform</p>
              <p class="style1">&nbsp;</p></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td height="144" align="center" valign="bottom" background="<%=request.getContextPath()%>/images/loginbg1.gif"><span class="style3"></span><img src="<%=request.getContextPath()%>/images/loginimg.jpg" width="498" height="141"></td>
      </tr>
      <tr>
        <td align="center" valign="top"><table width="498" height="120" border="0" cellpadding="0" cellspacing="0" background="<%=request.getContextPath()%>/images/loginbg2.gif">
          <tr>
            <td width="25" align="left"><img src="<%=request.getContextPath()%>/images/loginline1.gif" width="1" height="122"></td>
            <td valign="top"><table width="260" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td height="5" colspan="3"></td>
                </tr>
              <tr>
                <td colspan="2"><table width="200" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="50" height="30" class="fontorange" style="color:#ff6600; font-weight:bold;">帳號:</td>
                    <td>
					   <s:textfield name="name" cssClass="inputlogin" theme="simple"></s:textfield>
                    </td>
                  </tr>
                  <tr>
                    <td height="30" class="fontorange" style="color:#ff6600; font-weight:bold;">密碼:</td>
                    <td>    <s:password name="pwd" cssClass="inputlogin"  theme="simple" onkeydown="if(event.keyCode==13)return userlogin();"></s:password>  </td>
                  </tr>
                  <tr>
                    <td colspan="2" align="right"  class="fontorange" style="color:red;  font-weight:bold;">
                    <s:property value='error' />
                    </td>
                  </tr>
                </table></td>
                <td width="60" align="center"><img src="<%=request.getContextPath()%>/images/btnlogin1.gif" width="47" height="43" border="0" style="cursor: pointer" border="0" onClick="userlogin();"></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table>
      <p>&nbsp;</p>
      <p>&nbsp;</p>
      <p>&nbsp;</p></td>
  </tr>
</table>
</s:form>
</body>
</html>