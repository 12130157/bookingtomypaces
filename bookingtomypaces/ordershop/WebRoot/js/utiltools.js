
/**
create by mickey 2008-1-7 要结合 dwr/util.js使用(即原形js类库)
*/
if (null == input) {//输入框
	var input = {};
}
/**
功能:清空输入框默认值
id-页面中的唯一ID
data-输入框初始值
*/
input.clear = function (id, data) {
	var d = document.getElementById(id);
	if (data == d.value) {
		d.value = "";
	}
};
/**
功能:取得页面中input的值,并组成由','分割的字符串
*/
input.getValueString = function (name) {
	var obj = document.getElementsByName(name);
	var str = "";
	for (i = 0; i < obj.length; i++) {
		str = str + obj[i].value + ",";
	}
	var len = str.length;
	return str.substr(0, len - 1);
};
/**
obj- 输入对象
msg-提交信息
检查是否输入数字
*/
input.checkNum = function (obj, msg) {
	if (obj.value == "") {
		return;
	}
	if (isNaN(obj.value)) {
		obj.value = "";
		alert(msg);
	}
};
/**
功能：检查是否输入数字，并比较数字大小
id-被比较的对象ID
obj- 输入对象
msg-提交信息
*/
input.checkNumCompare = function (id, obj, msg1, msg2) {
	if (obj.value == "") {
		return;
	}
	if (isNaN(obj.value)) {
		obj.value = "";
		alert(msg1);
	} else {
		if (parseInt($(id).value) > parseInt(obj.value)) {
			obj.value = "";
			alert(msg2);
		}
	}
};
/**
功能：检查字数是否超过限制
obj -输入对象
num -限制数字
*/
input.checkLength = function (obj, num) {
	if (obj.value.replace(/[^\x00-\xff]/g, "**").length > num) {
		return false;
	} else {
		return true;
	}
};
if (null == checkbox) {//多选框
	var checkbox = {};
}
/**
功能:取得页面中checkbox选中的值,并组成由','分割的字符串
name-页面中checkbox的名字
*/
checkbox.getValueString = function (name) {
	var obj = document.getElementsByName(name);
	var str = "";
	for (i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			str = str + obj[i].value + ",";
		}
	}
	var len = str.length;
	return str.substr(0, len - 1);
};
/**
功能:全选/反选
name-页面中checkbox的名字
check-多选控制checkbox的id
*/
checkbox.selectAll = function (name, check) {
	var obj = document.getElementsByName(name);
	//alert(obj.length);
	if ($(check).checked) {
		for (i = 0; i < obj.length; i++) {
			obj[i].checked = true;
		}
	} else {
		for (i = 0; i < obj.length; i++) {
			obj[i].checked = false;
		}
	}
};
/**
功能:根据全选下的子选项,选中全选的checkbox
name-页面中checkbox的名字
check-多选控制checkbox的id
*/
checkbox.selectMax = function (name, check) {
	var obj = document.getElementsByName(name);
	for (i = 0; i < obj.length; i++) {
		if (obj[i].checked) {
			//alert();
			$(check).checked = true;
			break;
		} else {
			$(check).checked = false;
		}
	}
};
/**
功能:选中页面中所有的checkbox
check-多选控制checkbox的id
*/
checkbox.select = function (check) {
	var obj = document.all;
	if ($(check).checked) {
		for (i = 0; i < obj.length; i++) {
			if ("checkbox" == obj[i].type) {
				obj[i].checked = true;
			}
		}
	} else {
		for (i = 0; i < obj.length; i++) {
			if ("checkbox" == obj[i].type) {
				obj[i].checked = false;
			}
		}
	}
};
/**
功能：判断是否有选择一项
name-checkbox名字
msg-提示信息
*/
checkbox.validation = function (name){
   var isCheck=false;
   var obj = document.getElementsByName(name);
   for (i = 0; i < obj.length; i++) {
   if (obj[i].checked) {
   isCheck = true;
   break;
   }
   }
   return isCheck;
};
if (null == radio) {//单选
	var radio = {};
}
/**
功能:取得选中的值
name-页面中radio的名字
*/
radio.getValue = function (name) {
	var v;
	var o = document.getElementsByName(name);
	for (i = 0; i < o.length; i++) {
		if (o[i].checked) {
			v = o[i].value;
		}
	}
	return v;
};
/**
功能:更改radio值为value
name-页面中radio的名字
value-radio的值
*/
radio.setValue = function (name, value) {
	var o = document.getElementsByName(name);
	for (i = 0; i < o.length; i++) {
		if (o[i].value == value) {
			o[i].checked = true;
		}
	}
};
if (null == win) {
	var win = {};
}
/**
功能:相当于window.showModalDialog
url-要打开的地址
arg-要传递的参数
reload-是否刷新父页面
*/
win.openModal = function (url, arg, reload, width, height) {
	window.showModalDialog(url, arg, "dialogWidth:" + width + "px;dialogHeight:" + height + "px;status:no;scrollbars:no");
	if (true == reload) {
		window.location.reload();
	}
};
if (null == sql) {
	var sql = {};
}
/**
功能:得到SQL字符串
tableName-表名字
rows-字段
values-值
*/
sql.getSql = function (tableName, rows, values) {
	var obj = rows.split(",");
	var obj2 = values.split(",");
	var len1 = obj.length;
	var len2 = obj2.length;
	var s1 = "insert into " + tableName + "(";
	for (i = 0; i < len1; i++) {
		s1 = s1 + obj[i] + ",";
	}
	s1 = s1.substr(0, s1.length - 1) + ")";
	var s2 = "";
	for (j = 0; j < len2; j = j + len1) {
		s2 = s2 + s1 + "values(";
		for (k = 0; k < len1; k++) {
			s2 = s2 + obj2[j + k] + ",";
		}
		s2 = s2.substr(0, s2.length - 1) + ");";
	}
	return s2;
};
if (null == string) {
	var string = {};
}
/**
功能:判断源字符串中是否包含特定的字符
str-特定字符
source-源字符串
*/
string.ishad = function (str, source) {
	return source.indexOf(str);
};
/**
功能:返回元素在数组第一次出现的位置
substr-元素
start-开始的位置
*/
Array.prototype.indexOf = function (substr, start) {
	var ta, rt, d = "\x00";
	if (start != null) {
		ta = this.slice(start);
		rt = start;
	} else {
		ta = this;
		rt = 0;
	}
	var str = d + ta.join(d) + d, t = str.indexOf(d + substr + d);
	if (t == -1) {
		return -1;
	}
	rt += str.slice(0, t).replace(/[^\0]/g, "").length;
	return rt;
};
/**
功能:返回元素在数组最后一次出现的位置
substr-元素
start-开始的位置
*/
Array.prototype.lastIndexOf = function (substr, start) {
	var ta, rt, d = "\x00";
	if (start != null) {
		ta = this.slice(start);
		rt = start;
	} else {
		ta = this;
		rt = 0;
	}
	ta = ta.reverse();
	var str = d + ta.join(d) + d, t = str.indexOf(d + substr + d);
	if (t == -1) {
		return -1;
	}
	rt += str.slice(t).replace(/[^\0]/g, "").length - 2;
	return rt;
};
/**
功能:替换数组中的元素
re-正则表达式
rpby-待替换的元素
*/
Array.prototype.replace = function (reg, rpby) {
	var ta = this.slice(0), d = "\x00";
	var str = ta.join(d);
	str = str.replace(reg, rpby);
	return str.split(d);
};
/**
功能:返回与正则表达式查找元素匹配的第一个元素的位置
re-正则表达式
*/
Array.prototype.search = function (reg) {
	var ta = this.slice(0), d = "\x00", str = d + ta.join(d) + d, regstr = reg.toString();
	reg = new RegExp(regstr.replace(/\/((.|\n)+)\/.*/g, "\\0$1\\0"), regstr.slice(regstr.lastIndexOf("/") + 1));
	t = str.search(reg);
	if (t == -1) {
		return -1;
	}
	return str.slice(0, t).replace(/[^\0]/g, "").length;
};
if (null == file) {
	var file = {};
}
/**
功能:动态设置文件上传框
num-上传框个数
name-上传框名称
div-插入页面div名称
*/
file.setUploadField = function (num, name, div) {
	var str = "";
	var inputStr = "&nbsp;&nbsp;<input type='file' name='" + name + "' />";
	if (num == 0) {
		num = 1;
	}
	if (num > 30) {//一次只能上传30个
		num = 30;
		alert("\u4e00\u6b21\u6700\u591a\u53ea\u80fd\u4e0a\u4f2030\u5f20\uff01");
	}
	for (i = 0; i < num; i++) {
		if (i == num - 1) {
			str = str + inputStr;
		} else {
			str = str + inputStr + "<br />";
		}
	}
	//alert(str);
	document.getElementById(div).innerHTML = str;
};
/**
功能:确认是否提交
url-跳转的URL
msg-提示确认信息
*/
function is_yes_or_no(url, msg) {
	var b = confirm(msg);
	if (true == b) {
		location.href = url;
	} else {
		return;
	}
}
/**
功能:四舍五入
num-源目标
n-保存小数点后的位数
*/
function forDight(num, n) {
	num = Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
	return num;
}

