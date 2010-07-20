<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>

<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/interface/UserData.js'></script>
<script type='text/javascript' src='<%=request.getContextPath()%>/view/user/user.js'></script>
<jsp:include page="../../head.jsp" />
<title>修改密碼</title>
</head>

<body class="maintable">
<s:form action="editpwd"  method="post"  theme="simple" onsubmit="return check(this);">
<input type="hidden" name="userdata.id" value="<s:property value="#session.KING_SYSTEM_USER.userId"/>" />
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">修改密碼</div>
    </div>
    <div class="dclass_container_content1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         
		  
		   <tr>           
            <td class="formtitle">密码:<span class="fontred">*</span></td>
            <td class="formtd"><input name="userdata.passWord" type="password" class="inputform" value="<s:property value="userdata.passWord"/>"></td>
			
            <td class="formtd" colspan="2"></td>
          </tr>
          
         
		  
		  
     </table>
    <div class="dclass_bt">
    	<input type="button" class="btn1" value="保 存" onclick="add();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">
	
	function add(){
 		document.forms[0].action="<%=request.getContextPath()%>/user/key/editpwd";
		document.forms[0].submit();
	}
</script>
</html>