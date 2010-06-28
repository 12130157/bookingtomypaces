	function edit_jsp(id){
		var url_str="editjsp?id="+id;
		//var url_str="client_info/key/editjsp?id="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="cpinfo/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您確定要啟用?");
	}
	
	function update_down(id,stateValue){
		var url_str="cpinfo/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您確定要註銷?");
	}
	
		
	function add(){
		if((document.getElementById("clientinfodata.client_num")).value==''){
		    alert("客戶編號不能為空,請重新輸入!");
		    return false;
		 }
		 if((document.getElementById("clientinfodata.company_name")).value==''){
		    alert("公司名稱不能為空,請重新輸入!");
		    return false;
		 }
		 if((document.getElementById("clientinfodata.company_shortname")).value==''){
			    alert("公司簡稱不能為空,請重新輸入!");
			    return false;
			 }
		 if((document.getElementById("clientinfodata.comp_phone")).value==''){
			    alert("公司電話不能為空,請重新輸入!");
			    return false;
			 }
		 if((document.getElementById("clientinfodata.linkman_one")).value==''){
			    alert("聯繫人[1]不能為空,請重新輸入!");
			    return false;
			 }
		 if((document.getElementById("clientinfodata.phone_one")).value==''){
			    alert("聯繫人電話[1]不能為空,請重新輸入!");
			    return false;
			 }
		 if((document.getElementById("clientinfodata.address_one")).value==''){
			    alert("地址[1]不能為空,請重新輸入!");
			    return false;
			 }
		
		 //if((document.getElementById("searchValue['cp_show_index']")).value!=''){
		 //  if(!isNumeric((document.getElementById("searchValue['cp_show_index']")).value)){
		//	alert("合作商显示排序号只能是数字,请重新输入!");
		//	//document.getElementById("searchValue['cpid']")).focus();
		//	return false;
		 //  }
		// }
		
		 
	document.forms[0].submit();
  }

	function view(id){
		//var url_str="client_info/key/view?id="+id;
		var url_str="view?id="+id;
		openLink_auto(url_str,'650','550');
		//goURL3(url_str);
	}
	
	//检查客户编号是否重复
	function isExistName(){
		//alert();
		var name=document.getElementById("clientinfodata.client_num").value;
		///alert(name);
		if(name!=""){
			ClientInfoData.findByProperty(name,function (count) {
				if(count>0){
					document.getElementById("_client_num").innerHTML="<font color='red'>該客戶編號已存在</font>";
					document.getElementById("_isexist").value="1";
					document.getElementById("_client_num").focus();
					return false;
				}else{
					var un1=/[A-Za-z0-9]+$/;
					var username1=(name).replace(/\s+/g,"");
					
					if(!un1.test(username1)){
						document.getElementById("_client_num").innerHTML="<font color='red'>客戶編號只能为数字、字母</font>";
						return false;
					}else{
						document.getElementById("_isexist").value="0";
						document.getElementById("_client_num").innerHTML="<font color='blue'>客戶編號可以使用</font>";
					}
				}
			});
		}
	}	
	
	function selectAll() {
  		//var select = document.page_form.selectButton ;
		select = document.getElementsByName("selectButton") ;
  		if(select[0].checked==true){
  			for (var i=0;i<document.getElementsByName("checkbox").length;i++) {
				 var temp=document.getElementsByName("checkbox")[i];
				 if(temp.disabled==false)
					temp.checked=true ;
			}
  		}else{
  			for (var i=0;i<document.getElementsByName("checkbox").length;i++) {
				var temp=document.getElementsByName("checkbox")[i];
				temp.checked=false ;
			}
  		}
	}
  
	function del(){
	      var checkboxvalus=document.getElementsByName("checkbox");
		  if(typeof(checkboxvalus) != "undefined"){
				  var choosesize=0;
				  for(var i=0;i<checkboxvalus.length;i++){
					  if( checkboxvalus[i].checked == true)
						  choosesize+=1;
				  }
				  if(choosesize==0){
				  		alert("請選擇至少一條要刪除的資料！");
					    return ;
				  }else{
				  	 flag = confirm("您確定要刪除嗎？");
				  	 if(flag){
				  		 document.forms[0].action="del";
						 document.forms[0].submit();
					 }else{
					 	return false;
					 }
				  }
		  }
   } 