<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<jsp:include page="../../head.jsp" />
<script type='text/javascript' src='<%=request.getContextPath()%>/dwr/util.js'></script>
<script type='text/javascript' src="<%=request.getContextPath()%>/js/utiltools.js"></script>
<script type="text/javascript">
function setValue(){
var obj = document.all;
var s="";
for (i = 0; i < obj.length; i++) {
if(obj[i].checked) s = s + obj[i].value + ",";
}
s = s.substring(0,s.length-1);
s = "<input type='hidden' name='funId' value='"+s+"' />";
document.getElementById("cdata").innerHTML = s;
//alert(s);
}
</script>

<title>用戶組權限增加</title>
</head>

<body class="maintable">
<s:form action="addRole"  method="post"  theme="simple" onsubmit="return check(this);">
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">用戶組權限增加</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
         
		  <tr>
              <td width="10%" bgcolor="#FFFFFF" class="backwhite">角色名稱</td>
              <td width="90%" bgcolor="#FFFFFF" class="backwhite">
                <input type="text" name="name" /><div id="cdata" style="display:none"></div>              </td>
              </tr>
            <tr>
              <td bgcolor="#FFFFFF" class="backwhite">角色說明</td>
              <td bgcolor="#FFFFFF" class="backwhite"><label>
                <textarea name="memo" cols="30" rows="3"></textarea>
              </label></td>
              </tr>
            <tr>
              <td valign="top" bgcolor="#FFFFFF" class="backwhite">功能列表</td>
              <td bgcolor="#FFFFFF" class="backwhite">
			  <input type="checkbox" id="all" value="0" onclick="checkbox.select('all');setValue();" />全部功能<br /><br />
              <s:iterator id="f" value="funList.{?#this.perfunc==0}">
              <input type="checkbox" id="<s:property value='id' />m" onclick="checkbox.selectAll('<s:property value='id' />s','<s:property value='id' />m');setValue();" value="<s:property value='id' />" /><s:property value="funcname" /><br /><br />
              
              <s:iterator value="funList.{?#this.perfunc==#f.id}">
              
              <s:if test="null!=url">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="<s:property value='id' />c" name="<s:property value='perfunc' />s" onclick="checkbox.selectMax('<s:property value='perfunc' />s','<s:property value='#f.id' />m');setValue();" value="<s:property value='id' />" /><s:property value="funcname" /><br /><br />
              </s:if>
              </s:iterator>
              </s:iterator>
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
 		document.forms[0].action="<%=request.getContextPath()%>/role/key/addRole";
		document.forms[0].submit();
	}
</script>
</html>