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