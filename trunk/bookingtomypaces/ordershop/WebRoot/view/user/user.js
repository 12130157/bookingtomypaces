//检查登陆用户名是否重复
function isExistName(){
	//alert();
	var name=document.getElementById("userName").value;
	//alert(name);
	if(name!=""){
		UserData.findByProperty(name,function (count) {
			if(count>0){
				document.getElementById("_userName").innerHTML="<font color='red'>该用户名已存在</font>";
				document.getElementById("_isexist").value="1";
				document.getElementById("_userName").focus();
				return false;
			}else{
				var un1=/[A-Za-z0-9]+$/;
				var username1=(name).replace(/\s+/g,"");
				
				if(!un1.test(username1)){
					document.getElementById("_userName").innerHTML="<font color='red'>登陆名只能为数字字母</font>";
					return false;
				}else{
					document.getElementById("_isexist").value="0";
					document.getElementById("_userName").innerHTML="<font color='blue'>用户名可以使用</font>";
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
	 }
	if((document.getElementsByName("passWord"))[0].value==''){	
	    alert("密码不能為空,請重新輸入!");
	    document.getElementsByName("passWord")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("mobile"))[0].value==''){	
	    alert("手機不能為空,請重新輸入!");
	    document.getElementsByName("mobile")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("realName"))[0].value==''){
	    alert("姓名不能為空,請重新輸入!");
	    
	    document.getElementsByName("realName")[0].focus();
	    return false;
	 }
	
	if(document.getElementById("deptId").value==0){
		alert("請選擇所屬部門!");
		//document.getElementById("deptId").focus();
	    return false;
	}
	if(document.getElementById("storeId").value==0){
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