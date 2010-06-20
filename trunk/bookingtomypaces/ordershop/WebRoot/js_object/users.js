	function edit_jsp(id){
		var url_str="users/editjsp_users.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="users/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要启用?");
	}
	
	function update_down(id,stateValue){
		var url_str="users/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要注销?");
	}
	
	function del(id){
		var url_str="users/del_users.action?searchValue['id']="+id;
		operate(url_str,"您确定要删除?");
	}
		
	function add(){
	     if(isChinese((document.getElementById("searchValue['username']")).value)){
			alert("用户帐号不能为中文,请重新输入!");
			//document.getElementById("searchValue['cp_id']")).focus();
			return false;
		 }
		 if((document.getElementById("searchValue['password']")).value==''){
		    alert("用户密码不能为空,请重新输入!");
		    return false;
		 }
		  if((document.getElementById("searchValue['real_name']")).value==''){
		    alert("用户名称不能为空,请重新输入!");
		    return false;
		 }
		  if((document.getElementById("searchValue['cp_id']")).value==''){
			    alert("用户所属商家不能为空,请重新输入!");
			    return false;
		}
	document.forms[0].submit();
   }

	function view(id){
		var url_str="users/view_users.action?searchValue['id']="+id;
		goURL3(url_str);
	}