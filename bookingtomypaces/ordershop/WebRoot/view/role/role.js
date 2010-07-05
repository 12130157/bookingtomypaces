function checkf(){
	if((document.getElementsByName("name"))[0].value==''){	
	    alert("權限組名稱不能為空,請重新輸入!");
	    document.getElementsByName("name")[0].focus();
	    return false;
	 }
	
}