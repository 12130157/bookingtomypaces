//检查登陆用户名是否重复
function isExistName(){
	//alert();
	var name=document.getElementById("userName").value;
	//alert(name);
	if(name!=""){
		UserData.findByProperty(name,function (count) {
			if(count>0){
				document.getElementById("_userName").innerHTML="<font color='red'>該用戶帳號已經存在</font>";
				document.getElementById("_isexist").value="1";
				document.getElementById("_userName").focus();
				return false;
			}else{
				var un1=/[A-Za-z0-9]+$/;
				var username1=name.replace(/\s+/g,"");
				
				if(!un1.test(username1)){
					document.getElementById("_userName").innerHTML="<font color='red'>登錄帳號只能為數字字母</font>";
					document.getElementById("_userName").focus();
					return false;
				}else{
					document.getElementById("_isexist").value="0";
					document.getElementById("_userName").innerHTML="<font color='blue'>用戶帳號可以使用</font>";
				}
			}
		});
	}
}



function checkf(){
	if(document.getElementById("_isexist").value==1){
		document.getElementById("userName").focus();
		return false;
	}
	if((document.getElementsByName("userName"))[0].value==''){	
	    alert("登錄帳號不能為空,請重新輸入!");
	    document.getElementsByName("userName")[0].focus();
	    return false;
	 }else{
			var un1=/[A-Za-z0-9]+$/;
			var username1=document.getElementById("userName").value.replace(/\s+/g,"");
			
			if(!un1.test(username1)){
				document.getElementById("_userName").innerHTML="<font color='red'>登錄帳號只能為數字字母</font>";
				document.getElementById("_userName").focus();
				return false;
			}else{
				document.getElementById("_isexist").value="0";
				document.getElementById("_userName").innerHTML="<font color='blue'>該用戶帳號可以使用</font>";
			}
		}
	if((document.getElementsByName("passWord"))[0].value==''){	
	    alert("請輸入密碼!");
	    document.getElementsByName("passWord")[0].focus();
	    return false;
	 }else{
			var reg2=/[A-Za-z0-9]+$/;
			var password1=((document.getElementsByName("passWord"))[0].value).replace(/\s+/g,"");
			
			if(!reg2.test(password1)){
				alert("密碼只能為數字字母");
				document.getElementsByName("passWord")[0].focus();
				return false;
			}
			if(password1.length<6){
				alert("密碼過於簡單，長度要求大於6");
				document.getElementsByName("passWord")[0].focus();
				return false;
			}
			if(password1.length>20){
				alert("密碼過長，長度要求小於20");
				document.getElementsByName("passWord")[0].focus();
				return false;
			}
		}
	if((document.getElementsByName("mobile"))[0].value==''){	
	    alert("手機不能為空,請重新輸入!");
	    document.getElementsByName("mobile")[0].focus();
	    return false;
	 }else{
			var reg2=/[0-9]+$/;
			var mob=(document.getElementsByName("mobile")[0].value).replace(/\s+/g,"");
			
			if(!reg2.test(mob)){
				alert("手機只能為數字");
				document.getElementsByName("mobile")[0].focus();
				return false;
			}
			
		}
	if((document.getElementsByName("realName"))[0].value==''){
	    alert("請輸入姓名!");
	    
	    document.getElementsByName("realName")[0].focus();
	    return false;
	 }
	
	if(document.getElementById("deptId").value==0){
		alert("請選擇所屬部門!");
		//document.getElementById("deptId").focus();
	    return false;
	}
	if(document.getElementById("shopId").value==0){
		alert("請選擇所屬店鋪!");
		//document.getElementById("storeId").focus();
	    return false;
	}
	if(document.getElementById("areaId").value==0){
		alert("請選擇所屬區域!");
		//document.getElementById("areaId").focus();
	    return false;
	}
}
