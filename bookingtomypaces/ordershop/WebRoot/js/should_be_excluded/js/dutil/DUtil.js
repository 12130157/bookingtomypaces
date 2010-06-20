var DUtil={
	checkboxToggle:function(controllerCheckbox,targetCheckboxes){
		if(controllerCheckbox && targetCheckboxes){
			if(targetCheckboxes.length==null)
				targetCheckboxes=[targetCheckboxes];			
			for (i = 0; i < targetCheckboxes.length; i=i+1) {
			   targetCheckboxes[i].checked = controllerCheckbox.checked;
			}
		}
	},
	trim:function(str){
		if(str){
			str=str.replace(/^\s*|\s*$/g,"");;
		}
		return str;
	},
	appendClass:function(tag,className){
		tag.className=(tag.className.length>0?tag.className+" ":"")+className;

	},
	removeClass:function(tag,className){
		var re = new RegExp("(?:^|\\s)"+className+"(?=\\s|$)","g") 
		tag.className = tag.className.replace(re,"");
	}
};