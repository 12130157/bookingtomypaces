	function edit_jsp(id){
		var url_str="dic/editjsp_dic.action?searchValue['id']="+id;
		goURL3(url_str);
	}
	function update_up(id,stateValue){
		var url_str="dic/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫ����?");
	}
	
	function update_down(id,stateValue){
		var url_str="dic/update_valid.action?searchValue['id']="+id+"&searchValue['valid']="+stateValue;
		operate(url_str,"��ȷ��Ҫע��?");
	}
	
	function del(id){
		var url_str="dic/del_dic.action?searchValue['id']="+id;
		operate(url_str,"��ȷ��Ҫɾ��?");
	}
		
	function add(){
	     if(!isNumeric((document.getElementById("searchValue['cp_id']")).value)){
			alert("�����̱��ֻ��������,����������!");
			//document.getElementById("searchValue['cp_id']")).focus();
			return false;
		 }
		 if((document.getElementById("searchValue['cp_name']")).value==''){
		    alert("���������Ʋ���Ϊ��,����������!");
		    return false;
		 }
		 if((document.getElementById("searchValue['cp_show_index']")).value!=''){
		   if(!isNumeric((document.getElementById("searchValue['cp_show_index']")).value)){
			alert("��������ʾ�����ֻ��������,����������!");
			//document.getElementById("searchValue['cpid']")).focus();
			return false;
		   }
		 }
		  if((document.getElementById("searchValue['cp_owner']")).value==''){
		    alert("������������̨����Ϊ��,����������!");
		    return false;
		 }
		 if((document.getElementById("searchValue['cp_owner_show_index']")).value!=''){
		   if(!isNumeric((document.getElementById("searchValue['cp_owner_show_index']")).value)){
			alert("��̨��ʾ�����ֻ��������,����������!");
			//document.getElementById("searchValue['cpid']")).focus();
			return false;
		   }
	 }		 
	document.forms[0].submit();
   }

	function view(id){
		var url_str="dic/view_dic.action?searchValue['id']="+id;
		goURL3(url_str);
	}