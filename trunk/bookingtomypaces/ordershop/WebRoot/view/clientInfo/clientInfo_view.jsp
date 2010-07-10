<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>客戶資料</title>
</head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>
<body class="maintable">
<s:form action="edit"  method="post"  theme="simple" >
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
		  <tr>
            <td class="formtd" colspan="4"><span class="fontred">客戶</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">客戶編號:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.clientNum }</td>
			<td class="formtitle" width="15%">地區:</td>
            <td class="formtd" width="35%">${clientinfodata.areaName }</td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">公司</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">公司名稱:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.companyName }</td>
			<td class="formtitle">公司簡稱:<span class="fontred">*</span></td>
            <td class="formtd">${clientinfodata.companyShortname }</td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">公司電話:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.compPhone }</td>
			<td class="formtitle">公司傳真:</td>
            <td class="formtd">${clientinfodata.compFax }</td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">E-MAIL:</td>
            <td width="35%" class="formtd">${clientinfodata.e_mail }</td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.linkmanOne }</td>
			<td class="formtitle">聯繫人[2]:</td>
            <td class="formtd">${clientinfodata.linkmanTwo }</td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人電話[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.phoneOne }</td>
			<td class="formtitle">聯繫人電話[2]:</td>
            <td class="formtd">${clientinfodata.phoneTwo }</td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">職位[1]:</td>
            <td width="35%" class="formtd">${clientinfodata.jobOne }</td>
			<td class="formtitle">職位[2]:</td>
            <td class="formtd">${clientinfodata.jobTwo }</td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">地址[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd">${clientinfodata.addressOne }</td>
			<td class="formtitle">地址[2]:</td>
            <td class="formtd">${clientinfodata.addressTwo }</td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">其他</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">付款限期:</td>
            <td width="35%" class="formtd">${clientinfodata.prompt }日</td>
			<td class="formtitle">享受折扣:</td>
            <td class="formtd">${clientinfodata.rebate }% </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">負責員工:</td>
            <td width="35%" class="formtd">${clientinfodata.functionary }</td>
			<td class="formtitle">狀態:</td>
            <td class="formtd">
            	<select type="text" name="clientinfodata.status" >
                	<option value=0 selected>啟用</option>
                	<option value=1 >禁用</option>
                </select>
            </td>			 
          </tr>
		  <tr>
            <td class="formtitle">備註:</td>
            <td colspan="3" class="formtd">${clientinfodata.remark }</td>
          </tr>   
           <tr>           
            <td width="15%" class="formtitle">創建時間:</td>
            <td width="35%" class="formtd">${clientinfodata.createTime }</td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
     </table>
    <div style="padding:0.3em; text-align:center">
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
</html>