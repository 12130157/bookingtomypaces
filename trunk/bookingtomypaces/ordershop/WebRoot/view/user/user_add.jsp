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
<title>用戶资料增加</title>
</head>

<body class="maintable">
<s:form action="addUser"  method="post"  theme="simple" onsubmit="return checkf(this);">
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶资料增加</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         
		   <tr>
            <td width="16%" class="formtitle">登錄帳號:<span class="fontred">*</span></td>
            <td width="34%" class="formtd" > <div><span><input id="userName" name="userdata.userName" type="text" class="inputform"  onBlur="javascript:isExistName();" /></span>
            	<span id="_userName" ><font color="red">*</font> 由字母、数字、下划线组成(4-20位)</span></div>
            </td>
            <td width="16%"  class="formtitle">姓名:<span class="fontred">*</span></td>
            <td width="34%" class="formtd"><input id="realName"  name="userdata.realName" type="text" class="inputform" value=""> </td>
			 
          </tr>
		   <tr>           
            <td class="formtitle">密码:<span class="fontred">*</span></td>
            <td class="formtd"><input id="passWord"  name="userdata.passWord" type="password" class="inputform" ></td>
			<td class="formtitle">手機:<span class="fontred">*</span></td>
            <td class="formtd"><input id="mobile"  name="userdata.mobile" type="text" class="inputform" ></td>
          </tr>
          <tr>
            <td class="formtitle">状态:</td>
            <td class="formtd"> 
            	<select type="text" name="userdata.status" >
                	<option value=0 selected>使用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>
            <td class="formtitle">所屬部門:<span class="fontred">*</span></td>
            <td class="formtd"> 
            	<s:select list="deptMap" id="deptId"  name="userdata.deptId"   headerKey="0" headerValue="未選擇" emptyOption="false" ></s:select>
            </td>
			 
           
          </tr>
          <tr>
            <td class="formtitle">所屬區域:<span class="fontred">*</span></td>
            <td class="formtd"> 
            	<s:select list="areaMap" id="areaId" name="userdata.areaId"  headerKey="0" headerValue="未選擇" emptyOption="false"  ></s:select>
            </td>
            <td class="formtitle">所屬店鋪:<span class="fontred">*</span></td>
            <td class="formtd"> 
            	<s:select list="storeMap" id="storeId" name="userdata.shopId"  headerKey="0" headerValue="未選擇" emptyOption="false"  ></s:select>
            </td>
          </tr>
          <tr>
            
            <td class="formtitle">直屬總店:</td>
             <td class="formtd"> 
             <input type="radio" value="1" name="userdata.isHeadOffice">是
             <input type="radio" value="2" name="userdata.isHeadOffice" checked>否
            	
            </td>
            <td class="formtd" colspan="2"> 
            	&nbsp;
            </td>
          </tr>
         
		 <!-- <tr>
            <td class="formtitle">备注:</td>
            <td colspan="3" class="formtd"><textarea name="userdata.memo" class="inputformtext"></textarea></td>
          </tr>
          --> 
         
		  
		  
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="submit" name="bt" class="btn1" value="保 存"  />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
<script language="javascript" type="text/javascript">

</script>
</html>