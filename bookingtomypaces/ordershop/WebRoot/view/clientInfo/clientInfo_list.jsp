<%@ page language="java"  contentType="text/html; charset=utf-8"%>
<%@ page isELIgnored="false"%> 
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tools" uri="/tools-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../head.jsp" />
<title>客戶資料管理</title>
</head>
<script type="text/javascript"  src="<%=request.getContextPath()%>/view/clientInfo/clientInfo.js"  ></script>
<link href="<%=request.getContextPath()%>/css/style_guide.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">
function changeTD(tdidx,select_id) {	
		
		var num = 3 + 2;
		for(var i=1;i<=num;i++){
			if(tdidx != i){
				//alert("i=="+i)
				if(document.getElementById("tb_title"+i))
					document.getElementById("tb_title"+i).className='guide_tab01';
					//$("#tb_title"+i).css("guide_tab01");
				if(document.getElementById("tb_span"+i))
					$("#tb_span"+i).hide();
			}
			else{
				//alert("i else=="+i)
				document.getElementById("tb_title"+i).className='guide_tab01_o';
				$("#tb_title"+tdidx).show();			
				$("#tb_span"+tdidx).show();
			}
		}
		if(tdidx >= 4){
			alert("tdidx >= 4=="+tdidx)
			 $("#ratingTable").hide();
		    var obj;
		    obj=document.getElementById("kpiview_iframe"+tdidx);
		    obj.src="kpiview.do?action=kpiview&id="+select_id+"&topage=min&kpi_num="+tdidx; 
		    document.getElementById("kpiview_iframe"+tdidx).location.reload();
		    //document.frames("kpiview_iframe"+tdidx).document.getElementById("kpiview_iframe"+tdidx).location.reload();
			SetPWinHeight1("kpiview_iframe"+tdidx);
		}	

		if(tdidx == 1){
			alert("tdidx == 1")
			$("#ratingTable").show();
			document.getElementById("ratingIframe").contentWindow.showQuesRating('${qusinfo.qid}','');	
		}
		if(tdidx == 3){
			alert("tdidx == 3")
			$("#ratingTable").hide();
		}
	}
</script>
<body class="maintable">

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="guide_kuang_tl"></td>
		<td class="guide_kuang_tc">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td id="tb_title1" class="guide_tab01_o" onClick="changeTD(1,'');SetPWinHeight('');">战略分析</td>
					<td id="tb_title3" class="guide_tab01" style="display:none" onClick="changeTD(3,'');SetPWinHeight('');">武器仓库</td>
					
					<td id="tb_title4" class="guide_tab01" style="display:none"  ondblclick="closeKpiTD(4);" title="中高端客户流失率（累计3个月ARPU<50元）">
						<span onClick="changeTD(4,10006);SetPWinHeight('');">
						&nbsp;&nbsp;&nbsp;
										中高端...
									
						&nbsp;&nbsp;
						</span>
						<img src="/kit/images/btn_closetab.gif" onMouseMove="this.src='/kit/images/btn_closetab_o.gif'" onMouseOut="this.src='/kit/images/btn_closetab.gif'" onClick="closeKpiTD(4);"/>
					</td>
					
					<td id="tb_title5" class="guide_tab01" style="display:none"  ondblclick="closeKpiTD(5);" title="中高端客户离网率">
						<span onClick="changeTD(5,10007);SetPWinHeight('');">
						&nbsp;&nbsp;&nbsp;
										中高端...
									
						&nbsp;&nbsp;
						</span>
						<img src="/kit/images/btn_closetab.gif" onMouseMove="this.src='/kit/images/btn_closetab_o.gif'" onMouseOut="this.src='/kit/images/btn_closetab.gif'" onClick="closeKpiTD(5);"/>
					</td>
					
					<td>&nbsp;</td>
				</tr>
			</table>
		</td>
		<td class="guide_kuang_tr"></td>
	</tr>
</table>
<table width="100%" border="0" cellpadding="0" cellspacing="0" height="100%">
	<tr>
		<td class="guide_middle_td">
			
		<!-- que coding start -->
		<span id="tb_span1">
			
		<table width="100%"  border="0" cellspacing="0" cellpadding="0">
			<tr id="inQueFootTR2" style="display:none">
				<td colspan="2"></td>
			</tr>
			
			
			<tr>			
		        <td colspan="2" valign="top" align="center">
		        	<table width="96%"   border="0" cellspacing="0" cellpadding="0">
			              	
			                  	<tr>
				                    <td >
				                    	<img src="/kit/images/icon_gray.gif" width="13" height="13" align="absmiddle" title="无"/>
						        		<a href="javascript:changeTD(4,10006);" title="中高端客户流失率（累计3个月ARPU<50元）">中高端客户流失率（累计3个月ARPU<50元）</a> <span class="font_num">[0.0%]</span>
				                    </td>
			                  	</tr>
			                 
			                  	<tr>
				                    <td >
				                    	<img src="/kit/images/icon_gray.gif" width="13" height="13" align="absmiddle" title="无"/>
						        		<a href="javascript:changeTD(5,10007);" title="中高端客户离网率">中高端客户离网率</a> <span class="font_num">[0.0%]</span>
				                    </td>
			                  	</tr>
			                 
	              </table>
		        </td>
			</tr>
			
			
			<tr>
				<td class="guide_qus_con1" colspan="2">
					1111111
				</td>
			</tr>
			
			
		</table>
        <!-- que coding end -->
        <!-- tool coding start -->
		</span> </td>
	</tr>
</table>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="guide_kuang_bl"></td>
		<td class="guide_kuang_bc"></td>
		<td class="guide_kuang_br"></td>
	</tr>
</table>
<!--
<form action="list" method="post">
<div class="dclass_container dclass_container_collapsible" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料列表</div>
    </div>
    <div class="dclass_container_content">
	<div class="search">		
		<table>
			<tr>
				<td >
				    
					客戶編號/公司簡稱:<input type="text" class="inputsearch" name="find_str" value="${find_str }"/>
					&nbsp;
					<input name="sb" type="submit" class="btn1" value="查 詢" /></td>
			</tr>
		</table>	
	</div>
	
	
	</div>
</div>
<br style="line-height:5px;"/>
<div class="dclass_container" >
	<div class="dclass_container_header" >    	
        <div class="dclass_container_title">客戶資料列表</div>
    </div>
    <div class="dclass_container_content">-->
	<!--内容开始-->
	<!--
	<div class="actions">
		<input name="Submit" type="button" class="btn1" value="新 增" onClick="goURL3('<%=request.getContextPath()%>/client_info/key/addjsp');"/>
		<input name="delbt" type="button" class="btn1" value="刪 除" onClick="del();"/>		
	</div>	
	
	<table class="dclass_data" >
		<thead>
			<tr>
				<th align="center"><input type="checkbox"  name="selectButton" value="checkbox" onclick='return selectAll();'></th>
				<th >客戶編號</th>
				<th >公司簡稱</th>	
				<th >公司電話</th>	
				<th >聯繫人</th>
				<th >聯繫人電話</th>
				<th >地址</th>
				<th >狀態</th>
				<th >操作</th>
			</tr>
		</thead>
		<tdoby>
		<s:iterator  value="clientInfoList" status="flag" >
		<tr title="双击查看详细内容" onDblClick="view('<s:property value="id"/>');">			
			<td align="center"><input type="checkbox" name="checkbox"  value="<s:property value="id"/>"></td>
			<td><a href="#"><s:property value="clientNum"/></a></td>
			<td><s:property value="companyShortname"/></td>
			<td><s:property value="compPhone"/></td>
			<td><s:property value="linkmanOne"/></td>
			<td><s:property value="phoneOne"/></td>
			<td><s:property value="addressOne"/></td>	
			<td>
				<s:if test="0==state">啟用</s:if>
				<s:if test="1==state"><span class="fontred">禁用</span></s:if>
			</td>	
			<td >
				<a href="#" onclick="edit_jsp('<s:property value="id"/>')" class='linkorange'>编辑</a>
				<s:if test="0==state"><a href="#" onclick="update_down('<s:property value="id"/>','1')" class='linkorange'>禁用</a></s:if>
				<s:if test="1==state"><a href="#" onclick="update_up('<s:property value="id"/>','0')" class='linkorange'>啟用</a></s:if>										
			</td>
		</tr>
		</s:iterator>
		<tr>
              <td colspan="9" align="right" class="backwhite" height="30">
              <tools:pageUrl url="${url}" count="${page.count}" curPage="${page.curPage}" pageSize="${page.pageSize}" />			  
			  </td>
      </tr>	
		</tbody>
	</table>
-->
	
	<!--内容结束-->
	<!--
</div>
</div>
</form>
-->
</body>
</html>