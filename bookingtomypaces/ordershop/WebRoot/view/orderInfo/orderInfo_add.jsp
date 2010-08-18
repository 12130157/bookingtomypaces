<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/orderInfo/orderInfo.js"  ></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/dwr/interface/ClientInfoData.js"></script>

<script type="text/javascript" src="<%=request.getContextPath()%>/js/lhgcore/lhgcore.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/lhgcore/lhgdialog.js"></script>

<jsp:include page="../../head.jsp" />
<title>訂單管理</title>
</head>

<body class="maintable">

<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客户资料</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
<s:form action="add" method="post" namespace="/order_info">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" >
			<tr>
				 <td width="5%"  >客戶編號:</td>
				 <td width="15%" >
				 	<input type="text" class="inputsearch" name="orderclientinfo.clientNum"  value=""/>
				 	<input id="c" type="button" name="bc"  value="選 擇" onclick="openDialog('open_clientlist','客戶列表','<%=request.getContextPath()%>/client_info/key/openClientInfoList',800,550);" />  
				 </td>
				 <td width="5%"  >手提:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.clientMobile" value=""/></td>
				 <td width="5%"  >開單店鋪:</td>
				 <td width="15%" >
				 <input type="text" class="inputsearch" name="orderinfodata.operatStoreName"  value=""/>
				 <input type="hidden" class="inputsearch" name="orderinfodata.operatStoreId"  value=""/>
				 <input type="hidden" class="inputsearch" name="operatStore_shortName"  value=""/>
				 <input id="d" type="button" name="bd"  value="選 擇" onclick="openDialog('open_storelist','店鋪列表','<%=request.getContextPath()%>/store/key/open_store_list',800,500);" />
				 </td>
				 <td width="5%"  >急件:</td>
				 <td width="12%" ><input type="checkbox" name="orderinfodata.isUrgentMail" value="" /></td>
				 <td colspan="2" rowspan="4"> 客戶評價:<br/>
				 	<textarea name="orderclientinfo.clientAppraise" class="inputformtext" style="width:50%;"></textarea>
				 </td>
			</tr>
			<tr>
				 <td width="5%"  >公司名稱:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.clientCompName"  value=""/></td>
				 <td width="5%"  >公司電話:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.clientCompPhone" value=""/></td>
				 <td width="5%"  >參考編號:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.writeOrderNum"  value=""/></td>
				 <td width="5%"  >起貨日期:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.startGoodsTime" value=""/></td>
				 
			</tr>
			<tr>
				 <td width="5%"  >聯絡人:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderinfodata.clientLinkman"  value=""/></td>
				 <td width="5%"  >公司傳真:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderclientinfo.clientCompFax" value=""/></td>
				 <td width="5%"  >公司郵箱:</td>
				 <td width="12%" ><input type="text" class="inputsearch" name="orderclientinfo.clientE_mail"  value=""/></td>
				 <td width="5%"  ></td>
				 <td width="12%" ></td>
				
			</tr>
			<tr>
				 <td width="5%"  >公司地址:</td>
				 <td  colspan="3" ><textarea name="orderclientinfo.clientCompAddress" class="inputformtext" style="width:92%;height:95%"></textarea></td>
				
				 <td width="5%"  >備註:</td>
				 <td  colspan="3"><textarea name="orderclientinfo.clientRemark" class="inputformtext" style="width:92%;height:95%"></textarea></td>
				
				
			</tr>
		</table>	
	</div>
	</div>
</div>


<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">订购清单</div>
    </div>
    <div class="dclass_container_content">
	<!--内容开始-->

	<div class="actions">
		<input name="searchValue['productNumber']" type="hidden" value="0"/>
		<input name="Submit1" type="button" class="btn1" value="选择产品" onclick="openMerch();" />		
	</div>	
	</div>	
	<div class="dclass_container_content1">
	<table class="dclass_data"  id="productTable">
		<thead>
			<tr>
			
				<th width="8%">类型</th>	
				<th >产品名称</th>		
				<th >尺寸</th>	
				<th width="8%">单价</th>
				<th width="8%">数量</th>
				<th width="8%">折扣率</th>
				<th width="8%">金额</th>
				<th width="10%" align="center">操作</th>
			</tr>
		</thead>
		<tbody id="productTbody"></tbody>
	</table>

	<div class="dclass_pager">		
		<span class="dclass_pager_sum">总净金额：HKD 
		<input type="text" class="inputformdate2" name="orderinfodata.orderAmount" readonly="readonly"  value="0" style="background-color:#ECF5FC; border: 0; color: red" /></span>
	</div>
	<!--内容结束-->
</div>
</div>

<br style="line-height:5px;"/>
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">交貨信息</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">
		<table width="100%" border="0" cellpadding="0" cellspacing="1" >
			<tr>
				 <td width="5%"  >送貨方式:</td>
				 <td width="17%" >
				 	<select name="orderinfodata.deliverType" id="deliverType"  onchange="show_ms();" style="width:105px" >
					<option value="2">送貨</option>
					<option value="1">自取</option>
					</select>
				 </td>
				 <td width="5%"  ></td>
				 <td width="17%" ></td>
				 <td width="5%"  ></td>
				 <td width="17%" ></td>
				 <td width="5%"  ></td>
				 <td width="17%" ></td>
				
			</tr>
			<tbody style="display: " id="deliverMsg">
			<tr>
				 <td width="5%"  >送貨店:</td>
				 <td width="17%" >
				 	<select name="orderclientinfo.deliverStoreId"  style="width:105px" size="1">
				 	<s:iterator  value="storeList" status="flag" >
						<option value="<s:property value="id"/>"><s:property value="name"/></option>
					</s:iterator>
					</select>
				 </td>
				 <td width="5%"  >送貨日期:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverDate" value=""/></td>
				 <td width="5%"  > 送貨地區:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverArea"  value=""/></td>
				 <td width="5%"  >送貨費:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverCash" value=""/>(HKD)</td>
			
			</tr>
			<tr>
				 <td width="5%"  >送貨公司:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverCompany"  value=""/></td>
				 <td width="5%"  >聯絡人:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverMan" value=""/></td>
				 <td width="5%"  >聯絡電話:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverPhone"  value=""/></td>
				 <td width="5%"  >聯絡手提:</td>
				 <td width="17%" ><input type="text" class="inputsearch" name="orderclientinfo.deliverMobile" value=""/></td>
				
			</tr>
			<tr>
				 <td width="5%"  >送貨地址:</td>
				 <td  colspan="3"><textarea name="orderclientinfo.deliveAddress" class="inputformtext" style="width:78%;height:95%"></textarea></td>
				
				 <td width="5%"  >備註:</td>
				 <td colspan="3" ><textarea name="orderclientinfo.deliverRemark" class="inputformtext" style="width:78%;height:95%"></textarea></td>

			</tr>
			</tbody>
		</table>	
	</div>
	</div>
</div>

<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">确定下单</div>
    </div>
    <div class="dclass_container_content">
	
		<table>
			<tr>
			
				 <td ><input type="checkbox" name="isSms" value="" />sms通知客户&nbsp;&nbsp;&nbsp;</td>

				 <td >选择sms平台:<select name="smsType">
					<option>所有</option>
					<option>观塘</option>
					<option>旺角</option>
					<option>弯仔</option>
					</select>
					&nbsp;&nbsp;&nbsp;</td>
					<td >sms通知号码:<input  type="text" class="inputsearch" name="clientMobile" value=""/></td>
			</tr>
		</table>	
	<div class="actions">
			<input name="Submit" type="button" class="btn1" value="确定下单"  onclick="add();" />		
		</div>	
</div>
</div>
</s:form>
<script language="javascript" type="text/javascript">
function txtchange(typeName,varTable,varTbody,rowId){
//alert("ss")
 	var inputNum = typeName + "_num_" + rowId;
 	var inputUPrice = typeName + "_uprice_" + rowId;
	var inputPercent = typeName + "_percent_" + rowId;
	var inputAllPrice = typeName + "_allPrice_" + rowId;
 //alert(inputNum)
//alert(document.getElementsByName(inputNum)[0].value;)
//alert(document.getElementsByName(inputNum)[0].value)
	document.getElementsByName(inputAllPrice)[0].value=(document.getElementsByName(inputNum)[0].value)*(document.getElementsByName(inputUPrice)[0].value)
	str_sumprice('product','productTable','productTbody');
}
function add(){
	//(document.getElementsByName("searchValue['productNumber']"))[0].value=document.getElementById('productTable').rows.length - 1;
	//alert((document.getElementsByName("searchValue['productNumber']")).value)
	//if((document.getElementById('productTable').rows.length - 1)==0){
	//	    alert("您尚未选择产品,请选择!");
	//	    return false;
	//}
	document.forms[0].submit();
}
function openMerch() { 
    openLink_m('<%=request.getContextPath()%>/order/open_productList.html');
}

	//设置题目信息
function setMultiSubjectId(ids,names,sizes,prices){
	//addRow(subject,subjectTable,subjectTbody,id,name)
	
	
	var inputIds = getIds('product','productTable');
	for(var i = 0; i < ids.length; i ++){
		if(inputIds.indexOf(ids[i]) == -1){
		   //alert(ids[i]+names[i]+sizes[i]+prices[i])
			addRow('product','productTable','productTbody',ids[i],names[i],sizes[i],prices[i]);
		}
	}
	str_sumprice('product','productTable','productTbody');
}

function str_sumprice(typeName,varTable,varTbody){
     var tableObj=document.getElementById(varTable);
	 var tableLength = tableObj.rows.length - 1;
	 var currentLength = tableObj.rows.length;
	 var tableBodyObj=document.getElementById(varTbody);
     //var rowObj=document.getElementById(typeName+rowId);
     var sum_price=0;
     	    for(var i = 1; i <= tableLength ; i ++){
			 var delRowObj=document.getElementById(typeName + i);
			// if(i != rowId){
				var inputAllPrice = typeName + "_allPrice_" + i;
			 	sum_price = sum_price+parseInt(document.getElementsByName(inputAllPrice)[0].value);
			// }
		}
		//document.getElementsByName("sumprice")[0].value=sum_price;
		(document.getElementsByName("searchValue['sum_price']"))[0].value=sum_price;

}

function addRow(typeName,varTable,varTbody,strId,strName,strSize,strPrice){
     var tableObj=document.getElementById(varTable);
	 var tableLength = tableObj.rows.length - 1;
	 var currentLength = tableObj.rows.length;
	 var inputId = typeName + "_id_" + currentLength;
	 var inputName = typeName + "_name_" + currentLength;
	 var inputSize = typeName + "_size_" + currentLength;
	 var inputUPrice = typeName + "_uprice_" + currentLength;
	 var inputNum = typeName + "_num_" + currentLength;
	 var inputPercent = typeName + "_percent_" + currentLength;
	 var inputAllPrice = typeName + "_allPrice_" + currentLength;
	
	 
     var tableBodyObj=document.getElementById(varTbody);
	 //alert(tableBodyObj)
     var newRowObj=document.createElement("tr");
     newRowObj.id=typeName + currentLength;
     newRowObj.className="listtd" + (currentLength % 2 + 1);
     
     var optionName=document.createElement("td");
     var optionContent=document.createElement("td");
	 var optionSize=document.createElement("td");
	 var optionUPrice=document.createElement("td");
	 var optionNum=document.createElement("td");
	 var optionPercent=document.createElement("td");
	 var optionAllPrice=document.createElement("td");
     var optionDelete=document.createElement("td");
     
     optionName.align="center";
     optionContent.align="left";
	 optionSize.align="left";
	 optionUPrice.align="right";
	 optionNum.align="center";
	 optionPercent.align="center";
	 optionAllPrice.align="right";
     optionDelete.align="center";
     
	 optionName.innerHTML =  currentLength + '<input  name="' + inputId + '" type="hidden" value="' + strId + '" >';
     optionContent.innerHTML = strName + '<input type="hidden" name="' + inputName + '" value="' + strName + '" >';
     optionSize.innerHTML = strSize + '<input type="hidden" name="' + inputSize + '" value="' + strSize + '" >';
     optionUPrice.innerHTML = strPrice + '<input type="hidden" name="' + inputUPrice + '" value="' + strPrice + '" >';
     optionNum.innerHTML = '<input class="inputformdate" align="right" type="text" name="' + inputNum + '" value="1" onchange="txtchange(\'' + typeName + '\',\'' + varTable + '\',\'' + varTbody + '\',' + currentLength + ');">';
     optionPercent.innerHTML = '0.00<input class="inputformdate" align="right" type="hidden" name="' + inputPercent + '" value="0.00" >';
     optionAllPrice.innerHTML ='<input readonly="readonly" class="inputformdate2" align="right"  type="text" name="' + inputAllPrice + '" value="' + strPrice + '" >';
     optionDelete.innerHTML='<a href="#" class="linkorange" onclick="deleteRow(\'' + typeName + '\',\'' + varTable + '\',\'' + varTbody + '\',' + currentLength + ');">删除</a>'; 
     
     newRowObj.appendChild(optionName);
     newRowObj.appendChild(optionContent);
     newRowObj.appendChild(optionSize);
     newRowObj.appendChild(optionUPrice);
     newRowObj.appendChild(optionNum);
     newRowObj.appendChild(optionPercent);
     newRowObj.appendChild(optionAllPrice);
     newRowObj.appendChild(optionDelete);

     tableBodyObj.appendChild(newRowObj);
  }
//deleteRow(subject,subjectTable,subjectTbody,rowId)
//deleteRow(group,groupTable,groupTbody,rowId)
function deleteRow(typeName,varTable,varTbody,rowId){
     var tableObj=document.getElementById(varTable);
	 var tableLength = tableObj.rows.length - 1;
	 var currentLength = tableObj.rows.length;
	 var tableBodyObj=document.getElementById(varTbody);
     var rowObj=document.getElementById(typeName+rowId);
     var inputIds = new Array();
     var inputNames = new Array();
     var varIndex = 0;
	 if(rowId != tableLength){
	    for(var i = rowId; i <= tableLength ; i ++){
			 var delRowObj=document.getElementById(typeName + i);
			 if(i != rowId){
			 	var inputId = typeName + "_id_" + i;
	            var inputName = typeName + "_name_" + i;
			 	inputIds[varIndex] = document.getElementsByName(inputId)[0].value;
			 	inputNames[varIndex] = document.getElementsByName(inputName)[0].value;
			 	varIndex = varIndex + 1;
			 }
			 tableBodyObj.removeChild(delRowObj);
		}
		varIndex = 0;
		for(var i = rowId; i <= tableLength - 1 ; i ++){
			addRow(typeName,varTable,varTbody,inputIds[varIndex],inputNames[varIndex]);
			varIndex = varIndex + 1;
		}
	 }else{
		tableBodyObj.removeChild(rowObj);
	 }
	 str_sumprice('product','productTable','productTbody');
}
function getIds(typeName,varTable){
	var tableObj=document.getElementById(varTable);
	var tableLength = tableObj.rows.length - 1;
	if(tableLength < 1){
		return '';
	}
	var inputIds = ',';
	for(var i = 1; i <= tableLength ; i ++){
	    var inputId = typeName + "_id_" + i;
		inputIds = inputIds + document.getElementsByName(inputId)[0].value + ',';
	}
	return inputIds;
}


 function show_ms()
  {
  	var o=document.getElementById("deliverType");
	var idvalue=o.options[o.selectedIndex].value;
  	if(idvalue=='1'){
  		document.getElementById("deliverMsg").style.display="none";
  	}else if(idvalue=='2'){
  		document.getElementById("deliverMsg").style.display="";
  		
  	}
  }
  
</script>

</body>
</html>