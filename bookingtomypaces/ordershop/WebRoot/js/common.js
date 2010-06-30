var flag=false;
function setsearchtr(obj){
	flag = !flag;
	if(flag){
		document.getElementById("mySearch").style.display="none";
		obj.src="../images/titletoonbtn.gif";
		obj.title="展开查询条";
	}else{
		document.getElementById("mySearch").style.display="";
		obj.src="../images/titletooffbtn.gif";
		obj.title="关闭查询条";
	}
}
function main(str1,str2){
		if(str2 == 'off'){
			var id1 = "main"+str1+"_off";
			var id2 = "main_on";
			document.getElementById(id1).style.display='';
			document.getElementById(id2).style.display='none';
			
			var span1 = "span"+str1+"_off";
			var span2 = "span"+str1+"_on";
			document.getElementById(span1).style.display='none';
			document.getElementById(span2).style.display='';
			
		}else{
			var id1 = "main"+str1+"_off";
			var id2 = "main_on";
			document.getElementById(id1).style.display='none';
			document.getElementById(id2).style.display='';
			
			var span1 = "span"+str1+"_off";
			var span2 = "span"+str1+"_on";
			document.getElementById(span1).style.display='';
			document.getElementById(span2).style.display='none';
		}
}

function openLink_m(link){
	if (link!=""){
		var url= link + "";
		var w = 700 ;
		var h = 450 ;
		var winW=w-10;
		var winH=h-30;
		var winX=(window.screen.width-winW-10)/2;
		var winY=(window.screen.height-h-30)/2;
		var openArticle=window.open(url,'','left='+winX+',top='+winY+',width='+winW+',height='+winH+',toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
		openArticle.focus();
	}
}
function openLink_auto(link,ww,wh){
	if (link!=""){
		var url= link + "";
		var w = 700 ;
		var h = 450 ;
		var winW=w-10;
		var winH=h-30;
		var winX=(window.screen.width-winW-10)/2;
		var winY=(window.screen.height-h-30)/2;
		var openArticle=window.open(url,'','left='+winX+',top='+winY+',width='+ww+',height='+wh+',toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
		openArticle.focus();
	}
}

function gotopage(url){
	if(url!=null){
		document.forms[0].action=url;
		document.forms[0].submit();
	}
	
}
function goURL1(myurl){
	//alert(myurl);
	document.webbody.location.href=myurl;
}

function goURL2(myurl){
	//alert(myurl);
	parent.document.webbody.location.href=myurl;
}
function goURL3(myurl){
	//alert(myurl);
	document.location.href=myurl;
}

function linkURL(url) {
	top.mainFrame.focus();
    top.mainFrame.location=url;//url;
}
/**
*
* @param strNum
* @return
*/
function isNumeric(strNum)
{	
	if (myTrim(strNum)=="") return false;
	var i;
	for(i = 0; i < strNum.length; i++)
	{
		var ch = strNum.charAt(i);
		if (ch < '0' || ch > '9') return false;
	}
	return true;
}
function myTrim(str)
{	
   
	var end = false;
	var ch;
	while(!end){
		if (str.length == 0) break;
		ch = str.charAt(0);
		if (ch == ' ')	str = str.substring(1,str.length);
		else end = true;
	}
	end = false;
	while(!end){
		if (str.length == 0) break;
		ch = str.charAt(str.length-1);
		if (ch == ' ')	str = str.substring(0,str.length-1);
		else end = true;
	}
	
	return str;
}

function isChinese(str){
	var chinese_reg = /[^u4e00-u9fa5]+$/;
	if(!chinese_reg.test(str)){
		return false;
	}else{
		return true;
	}
}	
function operate(strUrl,msg){
	if (confirm(msg)){
		if(strUrl!=null){
			document.forms[0].action=strUrl;
			document.forms[0].submit();
		}
	}
}

//获取单选值
function Get_RadioValue(RadioName){
    var obj;    
    obj=document.getElementsByName(RadioName);
    if(obj!=null){
        var i;
        for(i=0;i<obj.length;i++){
            if(obj[i].checked){
                return obj[i].value;            
            }
        }
    }
    return null;
}

//判断是否数字字母
function isWordNum(str){
	var un1=/[A-Za-z0-9]+$/;
	var username1=(str).replace(/\s+/g,"");
	if(!un1.test(username1)){
		return false;
	}
	else{
		return true;
	}
}

//判断是否double数字
function isDoubleNum(str_key)
{
var str = str_key;
if(str.match(/^\+?(:?(:?\d+\.\d+)|(:?\d+))$/)) return true;
else return false;
}

