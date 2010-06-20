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
<title>人员资料增加</title>
</head>

<body class="maintable">
<s:form action="addUserInfo"  method="post"  theme="simple" onsubmit="return check(this);">
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">人员资料增加</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         
		   <tr>
            <td class="formtitle">姓名:<span class="fontred">*</span></td>
            <td class="formtd" colspan="3"> <input id="userName" name="userName" type="text" class="inputformadd"  onBlur="javascript:isExistName();">
            	<div id="_userName" ><font color="red">*</font> 由字母、数字、下划线组成(4-20位)</div>
            </td>
          </tr>
		   <tr>           
            <td width="20%" class="formtitle">密码:<span class="fontred">*</span></td>
            <td width="30%" class="formtd"> <input name="userdata.passWord" type="text" class="inputform" value=""></td>
			<td class="formtitle">所属部门:<span class="fontred">*</span></td>
            <td class="formtd"><input name="userdata.unitId" type="text" class="inputform" value=""> </td>
			 
          </tr>
          <tr>
            <td class="formtitle">状态:</td>
            <td class="formtd"> 
            	<select type="text" name="userdata.status" >
                	<option value=0 selected>使用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>
            <td class="formtitle">地点:</td>
            <td class="formtd"><input name="textfield5" type="text" class="inputform" value=""></td>
          </tr>
		  <tr>
            <td class="formtitle">备注:</td>
            <td colspan="3" class="formtd"><textarea name="textarea" class="inputformtext"></textarea></td>
          </tr>
         
         
		  
		   <tr>
		     <td colspan="4" class="formtitle"><span class="fontred">
									
					    </span>
				</td>
				</tr>
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="button" class="btn1" value="保 存" onclick="useradd();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">
	
	function useradd(){
 		document.forms[0].action="<%=request.getContextPath()%>/user/key/add";
		document.forms[0].submit();
	}
</script>
</html>