<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/ClientInfoData.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/lhgcore/lhgcore.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lhgcore/lhgdialog.js"></script>

<jsp:include page="../../head.jsp" />
<title>客戶資料增加</title>

</head>
<body class="maintable">
<s:form action="add"  method="post"  theme="simple" >
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料增加</div>
    </div>
    <div class="dclass_container_content1">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
		  <tr>
            <td class="formtd" colspan="4"><span class="fontred">客戶</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">客戶編號:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.clientNum" type="text" class="inputform" value="" onBlur="javascript:isExistName();"><div id="_client_num" >由字母、数字、下划线组成(4-20位)</div></td>
			<td class="formtitle" width="15%">地區:</td>
            <td class="formtd" width="35%"><input name="clientinfodata.areaName" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">公司</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">公司名稱:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.companyName" type="text" class="inputform" value=""></td>
			<td class="formtitle">公司簡稱:<span class="fontred">*</span></td>
            <td class="formtd"><input name="clientinfodata.companyShortname" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">公司電話:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.compPhone" type="text" class="inputform" value=""></td>
			<td class="formtitle">公司傳真:</td>
            <td class="formtd"><input name="clientinfodata.compFax" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">E-MAIL:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.e_mail" type="text" class="inputform" value=""></td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.linkmanOne" type="text" class="inputform" value=""></td>
			<td class="formtitle">聯繫人[2]:</td>
            <td class="formtd"><input name="clientinfodata.linkmanTwo" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人電話[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.phoneOne" type="text" class="inputform" value=""></td>
			<td class="formtitle">聯繫人電話[2]:</td>
            <td class="formtd"><input name="clientinfodata.phoneTwo" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">職位[1]:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.jobOne" type="text" class="inputform" value=""></td>
			<td class="formtitle">職位[2]:</td>
            <td class="formtd"><input name="clientinfodata.jobTwo" type="text" class="inputform" value=""> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">地址[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <textarea name="clientinfodata.addressOne" class="inputformtext" style="width:90%;"></textarea></td>
			<td class="formtitle">地址[2]:</td>
            <td class="formtd"><textarea name="clientinfodata.addressTwo" class="inputformtext" style="width:90%;"></textarea> </td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">其他</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">付款限期:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.prompt" type="text" class="inputform" value="0">日</td>
			<td class="formtitle">享受折扣:</td>
            <td class="formtd"><input name="clientinfodata.rebate" type="text" class="inputform" value="0">% </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">負責員工:</td>
            <td width="35%" class="formtd"> 
            	<input id="clientinfodata.functionary" name="clientinfodata.functionary" type="text" class="inputform" value="">  
            	<input id="clientinfodata.functionaryUserId" name="clientinfodata.functionaryUserId" type="hidden" class="inputform" value="">          
            	<input id="c" type="button" name="bc" class="btn1" value="選 擇" onclick="openDialog('open_userlist','員工列表','<%=request.getContextPath()%>/user/key/open_user_list',800,500);" />       	          	
            </td>
			<td class="formtitle">狀態:</td>
            <td class="formtd">
            	<select type="text" name="clientinfodata.state" >
                	<option value=0 selected>啟用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>			 
          </tr>
		  <tr>
            <td class="formtitle">備註:</td>
            <td colspan="3" class="formtd"><textarea name="clientinfodata.remark" class="inputformtext"></textarea></td>
          </tr>
   
     </table>
    <div class="dclass_bt">
    	<input type="button" name="bc" class="btn1" value="保 存" onclick="javascript:add();" />
		<input type="button" name="fh" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
</html>