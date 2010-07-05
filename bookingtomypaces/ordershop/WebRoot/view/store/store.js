function isExistName(){
	//alert();
	var name=document.getElementById("name").value;
	//alert(name);
	if(name!=""){
		StoreData.findByProperty(name,function (count) {
			if(count>0){
				document.getElementById("_name").innerHTML="<font color='red'>该店鋪名稱已存在</font>";
				document.getElementById("_isexist").value="1";
				document.getElementById("name").focus();
				return false;
			}else{
				document.getElementById("_isexist").value="0";
				document.getElementById("_name").innerHTML="<font color='blue'>该店鋪名稱可以使用</font>";
			}
		});
	}
}

function checkf(){
	if((document.getElementsByName("name"))[0].value==''){	
	    alert("店鋪名稱不能為空,請重新輸入!");
	    document.getElementsByName("name")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("shortName"))[0].value==''){	
	    alert("英文簡稱不能為空,請重新輸入!");
	    document.getElementsByName("shortName")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("address"))[0].value==''){	
	    alert("店鋪地址不能為空,請重新輸入!");
	    document.getElementsByName("address")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("managerName"))[0].value==''){	
	    alert("店長姓名不能為空,請重新輸入!");
	    document.getElementsByName("managerName")[0].focus();
	    return false;
	 }
	if((document.getElementsByName("managerMobile"))[0].value==''){	
	    alert("店長電話不能為空,請重新輸入!");
	    document.getElementsByName("managerMobile")[0].focus();
	    return false;
	 }
}