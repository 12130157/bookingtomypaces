	//一级菜单 begin	
	function edit_jsp(id){
		var url_str="menu/editjsp_fatherMenu.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要启用?");
	}
	
	function update_down(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要注销?");
	}
	
	function del(id){
		var url_str="menu/del_fatherMenu.action?searchValue['id']="+id;
		operate(url_str,"您确定要删除?");
	}
	
	//二级菜单 begin
	function edit_child_jsp(id){
		var url_str="menu/editjsp_childMenu.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_child_up(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要启用?");
	}
	
	function update_child_down(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"您确定要注销?");
	}
	
	function del_child(id){
		var url_str="menu/del_childMenu.action?searchValue['id']="+id;
		operate(url_str,"您确定要删除?");
	}
	
	//公共
	function add(){
	    
	     if((document.getElementById("searchValue['menu_name']")).value==''){
			    alert("菜单名称不能为空,请重新输入!");
			    return false;
			 }
	     if(document.getElementById("searchValue['state']").value==2){
			 if((document.getElementById("searchValue['href_url']")).value==''){
			    alert("链接资源不能为空,请重新输入!");
			    return false;
			 	}	
	     }
		 document.forms[0].submit();
   }

	function view(id){
		var url_str="menu/view_fatherMenu.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	
	function find_childMenuList(id){
		var url_str="menu/find_childMenuList.action?searchValue['father_menu']="+id;
		goURL3(url_str);
	}
	
	function addjsp_childMenu(father_id){
		var url_str="menu/addjsp_childMenu.action?searchValue['father_menu']="+father_id;
		goURL3(url_str);
	}
	/**
	function show_menu(){
		//alert(document.getElementById("searchValue['state']").value);
		if(document.getElementById("searchValue['state']").value==2){
			document.getElementById('show_menu').style.display = '';
			document.getElementById('show_menu2').style.display = '';
		}else{
			document.getElementById('show_menu').style.display = 'none';
			document.getElementById('show_menu2').style.display = 'none';
		}
   }
	**/