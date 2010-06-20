//检查登陆用户名是否重复
function isExistName(){
	alert();
	var name=document.getElementById("userName").value;
	alert(name);
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