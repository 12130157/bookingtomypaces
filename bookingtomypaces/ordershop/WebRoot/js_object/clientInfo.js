	function edit_jsp(id){
		var url_str="cpinfo/editjsp_cpinfo.action?searchValue['id']="+id;
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
	
	function del(id){
		var url_str="cpinfo/del_cpinfo.action?searchValue['id']="+id;
		operate(url_str,"您確定要刪除?");
	}
		
	function add(){
	     if(!isNumeric((document.getElementById("searchValue['cp_id']")).value)){
			alert("合作商编号只能是数字,请重新输入!");
			//document.getElementById("searchValue['cp_id']")).focus();
			return false;
		 }
		 if((document.getElementById("searchValue['cp_name']")).value==''){
		    alert("合作商名称不能为空,请重新输入!");
		    return false;
		 }
		 if((document.getElementById("searchValue['cp_show_index']")).value!=''){
		   if(!isNumeric((document.getElementById("searchValue['cp_show_index']")).value)){
			alert("合作商显示排序号只能是数字,请重新输入!");
			//document.getElementById("searchValue['cpid']")).focus();
			return false;
		   }
		 }
		  if((document.getElementById("searchValue['cp_owner']")).value==''){
		    alert("合作商所属电台不能为空,请重新输入!");
		    return false;
		 }
		 if((document.getElementById("searchValue['cp_owner_show_index']")).value!=''){
		   if(!isNumeric((document.getElementById("searchValue['cp_owner_show_index']")).value)){
			alert("电台显示排序号只能是数字,请重新输入!");
			//document.getElementById("searchValue['cpid']")).focus();
			return false;
		   }
	 }		 
	document.forms[0].submit();
  }

	function view(id){
		var url_str="cpinfo/view_cpinfo.action?searchValue['id']="+id;
		goURL3(url_str);
	}