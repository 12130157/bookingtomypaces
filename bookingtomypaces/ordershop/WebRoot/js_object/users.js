	function edit_jsp(id){
		var url_str="users/editjsp_users.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="users/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫ����?");
	}
	
	function update_down(id,stateValue){
		var url_str="users/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫע��?");
	}
	
	function del(id){
		var url_str="users/del_users.action?searchValue['id']="+id;
		operate(url_str,"��ȷ��Ҫɾ��?");
	}
		
	function add(){
	     if(isChinese((document.getElementById("searchValue['username']")).value)){
			alert("�û��ʺŲ���Ϊ����,����������!");
			//document.getElementById("searchValue['cp_id']")).focus();
			return false;
		 }
		 if((document.getElementById("searchValue['password']")).value==''){
		    alert("�û����벻��Ϊ��,����������!");
		    return false;
		 }
		  if((document.getElementById("searchValue['real_name']")).value==''){
		    alert("�û����Ʋ���Ϊ��,����������!");
		    return false;
		 }
		  if((document.getElementById("searchValue['cp_id']")).value==''){
			    alert("�û������̼Ҳ���Ϊ��,����������!");
			    return false;
		}
	document.forms[0].submit();
   }

	function view(id){
		var url_str="users/view_users.action?searchValue['id']="+id;
		goURL3(url_str);
	}