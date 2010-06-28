<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>客戶資料修改</title>
</head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>
<body class="maintable">
<s:form action="edit"  method="post"  theme="simple" >
<input id="_isexist" type="hidden" value="0" />
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料修改</div>
    </div>
    <div class="dclass_container_content">
	<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#9FD6FF">
		  <tr>
            <td class="formtd" colspan="4"><span class="fontred">客戶</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">客戶編號:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> 
            <input name="clientinfodata.id" type="hidden" class="inputform" value="${clientinfodata.id}" >
            <input name="clientinfodata.client_num" type="hidden" class="inputform" value="${clientinfodata.client_num }" >
            ${clientinfodata.client_num }
            </td>
			<td class="formtitle" width="15%">地區:</td>
            <td class="formtd" width="35%"><input name="clientinfodata.area_name" type="text" class="inputform" value="${clientinfodata.area_name }"> </td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">公司</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">公司名稱:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.company_name" type="text" class="inputform" value="${clientinfodata.company_name }"></td>
			<td class="formtitle">公司簡稱:<span class="fontred">*</span></td>
            <td class="formtd"><input name="clientinfodata.company_shortname" type="text" class="inputform" value="${clientinfodata.company_shortname }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">公司電話:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.comp_phone" type="text" class="inputform" value="${clientinfodata.comp_phone }"></td>
			<td class="formtitle">公司傳真:</td>
            <td class="formtd"><input name="clientinfodata.comp_fax" type="text" class="inputform" value="${clientinfodata.comp_fax }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">E-MAIL:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.e_mail" type="text" class="inputform" value="${clientinfodata.e_mail }"></td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.linkman_one" type="text" class="inputform" value="${clientinfodata.linkman_one }"></td>
			<td class="formtitle">聯繫人[2]:</td>
            <td class="formtd"><input name="clientinfodata.linkman_two" type="text" class="inputform" value="${clientinfodata.linkman_two }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">聯繫人電話[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <input name="clientinfodata.phone_one" type="text" class="inputform" value="${clientinfodata.phone_one }"></td>
			<td class="formtitle">聯繫人電話[2]:</td>
            <td class="formtd"><input name="clientinfodata.phone_two" type="text" class="inputform" value="${clientinfodata.phone_two }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">職位[1]:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.job_one" type="text" class="inputform" value="${clientinfodata.job_one }"></td>
			<td class="formtitle">職位[2]:</td>
            <td class="formtd"><input name="clientinfodata.job_two" type="text" class="inputform" value="${clientinfodata.job_two }"> </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">地址[1]:<span class="fontred">*</span></td>
            <td width="35%" class="formtd"> <textarea name="clientinfodata.address_one" class="inputformtext" style="width:90%;">${clientinfodata.address_one }</textarea></td>
			<td class="formtitle">地址[2]:</td>
            <td class="formtd"><textarea name="clientinfodata.address_two" class="inputformtext" style="width:90%;">${clientinfodata.address_two }</textarea> </td>			 
          </tr>
          <tr>
            <td class="formtd" colspan="4"><span class="fontred">其他</span></td>
          </tr>	
          <tr>           
            <td width="15%" class="formtitle">付款限期:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.prompt" type="text" class="inputform" value="${clientinfodata.prompt }">日</td>
			<td class="formtitle">享受折扣:</td>
            <td class="formtd"><input name="clientinfodata.rebate" type="text" class="inputform" value="${clientinfodata.rebate }">% </td>			 
          </tr>
          <tr>           
            <td width="15%" class="formtitle">負責員工:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.functionary" type="text" class="inputform" value="${clientinfodata.functionary }"></td>
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
            <td colspan="3" class="formtd"><textarea name="clientinfodata.remark" class="inputformtext">${clientinfodata.remark }</textarea></td>
          </tr>   
           <tr>           
            <td width="15%" class="formtitle">創建時間:</td>
            <td width="35%" class="formtd"> <input name="clientinfodata.create_time" type="text" class="inputform" value="${clientinfodata.create_time }"></td>
			<td class="formtitle"></td>
            <td class="formtd"></td>			 
          </tr>
     </table>
    <div style="padding:0.3em; text-align:center">
    	<input type="button" class="btn1" value="保 存" onclick="add();" />
		<input type="button" class="btn1" value="返 回" onclick="javascript:history.back();" /> 
	</div>
	</div>
</div>
</s:form>
</body>
</html>