	//һ���˵� begin	
	function edit_jsp(id){
		var url_str="menu/editjsp_fatherMenu.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫ����?");
	}
	
	function update_down(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫע��?");
	}
	
	function del(id){
		var url_str="menu/del_fatherMenu.action?searchValue['id']="+id;
		operate(url_str,"��ȷ��Ҫɾ��?");
	}
	
	//�����˵� begin
	function edit_child_jsp(id){
		var url_str="menu/editjsp_childMenu.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_child_up(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫ����?");
	}
	
	function update_child_down(id,stateValue){
		var url_str="menu/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫע��?");
	}
	
	function del_child(id){
		var url_str="menu/del_childMenu.action?searchValue['id']="+id;
		operate(url_str,"��ȷ��Ҫɾ��?");
	}
	
	//����
	function add(){
	    
	     if((document.getElementById("searchValue['menu_name']")).value==''){
			    alert("�˵����Ʋ���Ϊ��,����������!");
			    return false;
			 }
	     if(document.getElementById("searchValue['state']").value==2){
			 if((document.getElementById("searchValue['href_url']")).value==''){
			    alert("������Դ����Ϊ��,����������!");
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