/** 
 * @fileoverview DTabs.js 文件定义JavaScript TAB选项卡组件功能实现。
 * 相关参考文档如下：<br />
 * http://stilbuero.de/jquery/tabs_3/ <br />
 * http://ui.jquery.com/repository/latest/demos/functional/#ui.tabs<br />
 * http://docs.jquery.com/UI/Tabs
 * @version 0.1 
 * @author 曹春城 <br />
 * CopyRight 广州市道一信息技术有限公司 2008
 */


/**
 * @class JavaScript  TAB选项卡控件类。<br />
 * 此类功能包括：<br />
 * TAB选项卡控件实现。
 * @constructor 构造函数
 * @throws MemoryException 如果没有足够的内存
 * @return 返回 DCalendarClass 对象
 */
function DTabsClass(){
	/**
	 * @private 私有函数
	 * 初始化设置params参数集参数值
	 * @param params Array 参数集 参数必须 是
	 * @return 无
	 * @type void
	 */
	var paramsDefault = function(params){
		 function param_default(pname, def) { 
		 	if (typeof params[pname] == "undefined"){
		 		params[pname] = def; 
		 	}
		 };
		 param_default("tabsid",null);//Tabs id
		 param_default("arrtabs",new Array());//Tabs数据集
		 
		 param_default("tabsclass","");// Tabs 样式
		 
		 param_default("height","toggle");//滑动效果
		 param_default("opacity","toggle");//淡入淡出效果
		 param_default("duration","normal");//淡入淡出效果速度
		 param_default("event","click");//定义Tabs事件
		 param_default("unselect",false);//选中选项卡单击是否隐藏选项卡，默认值：false 不隐藏，true表示隐藏
		 param_default("selected",0); //初始化TAB选项卡时是否全部隐藏,null：表示全部隐藏,0：表示选中第一个选项卡
	}
	/**
	 * HTML方式创建TAB选项卡，根据params参数集的设置 <br />
	 * params参数集详细说明如下：<br />
	 * tabsid : "" String TAB选项卡ID 参数必须 是<br />
	 * height : "toggle" String 滑动效果["show","toggle"] 默认值:toggle 参数必须 否<br />
	 * opacity : "toggle" String 淡入淡出效果["hide","show","toggle"] 默认值:toggle 参数必须 否<br />
	 * duration : "normal" String 渐入效果显示速度["hide","slow","normal","fast"]设置 默认值：normal 参数必须 否 <br />
	 * event ": "click" String 定义Tabs事件["click","mouseover"] 默认值：click 参数必须 否 <br />
	 * unselect : false boolean 选中选项卡单击是否隐藏选项卡，默认值：false 不隐藏，true表示隐藏 参数必须 否 <br />
	 * selected : 0 int 初始化TAB选项卡时是否全部隐藏,null：表示全部隐藏,0：表示选中第一个选项卡 参数必须 否
	 * @param params Object[] 参数集 参数必须 是
	 * @return 创建成功返回jquery.ui.tabs的tabs对象,失败返回空
	 * @type Tabs
	 */
	this.htmltabs = function(params){
		paramsDefault(params);
		if(params.tabsid != null){
			if(params.height == 'toggle' && params.opacity == 'toggle'){
				return $('#' + params.tabsid + ' > ul').tabs({
					fx:{height : params.height,
						opacity : params.opacity,
						duration : params.duration
					},
					event : params.event,
					unselect : params.unselect,
					selected : params.selected
				});
			}else{
				return $('#' + params.tabsid + ' > ul').tabs({
					fx:[null,{height : params.height,
						opacity : params.opacity,
						duration : params.duration
					}],
					event : params.event,
					unselect : params.unselect,
					selected : params.selected
				});
			}
		}
		return ''
	}
	/**
	 * JavaScript方式创建TAB选项卡，根据params参数集的设置 <br />
	 * params参数集详细说明如下：<br />
	 * tabsid : "" String TAB选项卡ID 参数必须 是<br />
	 * arrtabs : [] Array<{@link DTabsBean}> TAB选项卡数据集 参数必须 是<br />
	 * tabsclass : "" String TAB选项卡样式 参数必须 否<br />
	 * height : "toggle" String 滑动效果["show","toggle"] 默认值:toggle 参数必须 否<br />
	 * opacity : "toggle" String 淡入淡出效果["hide","show","toggle"] 默认值:toggle 参数必须 否<br />
	 * duration : "normal" String 渐入效果显示速度["hide","slow","normal","fast"]设置 默认值：normal 参数必须 否 <br />
	 * event ": "click" String 定义Tabs事件["click","mouseover"] 默认值：click 参数必须 否 <br />
	 * unselect : false boolean 选中选项卡单击是否隐藏选项卡，默认值：false 不隐藏，true表示隐藏 参数必须 否 <br />
	 * selected : 0 int 初始化TAB选项卡时是否全部隐藏,null：表示全部隐藏,0：表示选中第一个选项卡 参数必须 否
	 * @param params Object[] 参数集 参数必须 是
	 * @return 创建成功返回jquery.ui.tabs的tabs对象,失败返回空
	 * @type Tabs
	 */
	this.jstabs = function(params){
		paramsDefault(params);
		if(params.tabsid != null){
			createTabs(params.tabsid,params.arrtabs,params.tabsclass);
			if(params.height == 'toggle' && params.opacity == 'toggle'){
				return $('#' + params.tabsid + ' > ul').tabs({
					fx:{height : params.height,
						opacity : params.opacity,
						duration : params.duration
					},
					event : params.event,
					unselect : params.unselect,
					selected : params.selected
				});
			}else{
				return $('#' + params.tabsid + ' > ul').tabs({
					fx:[null,{height : params.height,
						opacity : params.opacity,
						duration : params.duration
					}],
					event : params.event,
					unselect : params.unselect,
					selected : params.selected
				});
			}
		}
		return '';
	}
	/**
	 * @private 私有函数 
	 * 创建TAB选项卡
	 * @param tabsid String TAB选项卡id 参数必须 是
	 * @param arrtabs [] Array<{@link DTabsBean}> TAB选项卡数据集 参数必须 是
	 * @param navclass String TAB选项卡样式 参数必须 否
	 * @param conclass String TAB选项卡内容显示样式 参数必须 否
	 * @return 创建成功返回true，创建失败返回false
	 * @type boolean
	 */
	var createTabs = function(tabsid,arrtabs,tabsclass){
		if( arrtabs == '' || arrtabs == 'undefined'){
			return false
		}
		if( arrtabs.length < 1){
			return false;
		}
		try{
			var i = 0;
			//TAB样式
			if(tabsclass != ''){
				document.write('<div id="' + tabsid + '" class="' + tabsclass + '" >');
			}else{
				document.write('<div id="' + tabsid + '">');
			}
			document.write('<ul>');
			
			for(i = 0; i < arrtabs.length; i ++){
				var dTabsBean = arrtabs[i];
				if(dTabsBean.getTabsUrl() != ''){
					document.write('<li><a href="' + dTabsBean.getTabsUrl() + '"><span>' + dTabsBean.getTabsName() + '</span></a></li>');
				}else{
					document.write('<li><a href="#' + dTabsBean.getTabsId() + '"><span>' + dTabsBean.getTabsName() + '</span></a></li>');
				}
			}
			document.write('</ul>');
			//TAB选项卡内容显示
			document.write('<div>');
			for(i = 0; i < arrtabs.length; i ++){
				var dTabsBean = arrtabs[i];
				if(dTabsBean.getTabsUrl() == ''){
					document.write('<div id="' + dTabsBean.getTabsId() + '">');
					document.write(dTabsBean.getContent());
					document.write('</div>');
				}
			}
			document.write('</div>');
			
			document.write('</div>');
		}catch(ex){
			alert('Ex:=创建Tabs失败！');
			return false;
		}
		return true;
	}
	/**
	 * 创建TAB选项卡的数据集，
	 * 返回Array {@link DTabsBean}，
	 * 如果初始化数据失败返回空数据的Array对象。
	 * @param params 树形菜单
	 * @return 返回一个数组对象，数组存放DTabsBean对象。
	 * @type Array
	 */
	this.initDTabsData = function(params){
		var dtabsArray = new Array();
		
		if( params == '' || params == 'undefined'){
			return dtabsArray
		}
		if( params.length < 1){
			return dtabsArray;
		}
		try{
			var i = 0;
			for(i = 0; i < params.length; i ++){
				var dTabsBean = new DTabsBean();
				dTabsBean.init(params[i].pid,params[i].pname,params[i].purl,params[i].pcontent);
				dtabsArray[i] = dTabsBean;
			}
		}catch(ex){
			alert("ex:创建TAB选项卡数据集出错!");
			dtabsArray = new new Array();
		}
		//alert('dtabsArray.length :=' + dtabsArray.length);
		return dtabsArray;
	}
	/**
	 * 在HTML界面上动态添加一个TAB选项卡，
	 * 如果当前选中的选项卡为第一个选项卡时，插入的选项卡是在选项卡的最后追加。
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param url String TAB选项URL 参数必须 是
	 * @param tabsname String TAB选项名称 参数必须 是
	 * @param index int 在TAB选项卡第几个追加新的选项卡 0表示最后一个选项卡之后追加 默认在最后的选项卡后添加 参数必须 否
	 * @return 无
	 * @type void
	 */
	this.addTabs = function(tabs,url,tabsname,index){
		
		if(index == '' || index == null || index == 'undefined'){
			tabs.tabs('add','#' + url,tabsname);
		}else{
			tabs.tabs('add','#' + url,tabsname,index);
		}
	}
	/**
	 * 在HTML界面上动态的删除一个TAB选项卡
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int 要删除的TAB选项卡的index 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.remove = function(tabs,index){
		var total = this.getLength(tabs);
		if(0 <= index && index < total){
			tabs.tabs('remove',index);
		}
	}
	/**
	 * 获取HTML界面上TAB选项卡的总数
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @return 返回HTML界面上TAB选项卡的总数
	 * @type int
	 */
	this.getLength = function(tabs){
		return tabs.tabs('length');
	}
	/**
	 * 设置TAB选项卡可用，
	 * index = -1 设置所有的TAB选项卡可用。
	 * index从0开始算起，即0表示第一个选项卡
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int TAB选项卡index 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.enableTabs = function(tabs,index){
		var total = this.getLength(tabs);
		if(index == -1){
			for(var i = 0; i < total; i ++){
				tabs.tabs('enable',i);
			}
		}else{
			if(0 <= index && index < total){
				tabs.tabs('enable',index);
			}
		}
	}
	/**
	 * 设置TAB选项卡不可用，
	 * index = -1 设置所有的TAB选项卡不可用，
	 * index从0开始算起，即0表示第一个选项卡，
	 * 如果index的选项卡的是选中的，则不可以设置为不可用，此函数不起作用。
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int TAB选项卡index 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.disableTabs = function(tabs,index){
		var total = this.getLength(tabs);
		if(index == -1){
			for(var i = 0; i < total; i ++){
				tabs.tabs('disable',i);
			}
		}else{
			if(0 <= index && index < total){
				tabs.tabs('disable',index);
			}
		}
	}
	/**
	 * 选中某一选项卡，
	 * index从0开始算起，即0表示第一个选项卡。
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int TAB选项卡index 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.selectTabs = function(tabs,index){
		var total = this.getLength(tabs);
		if(0 <= index && index < total){
			tabs.tabs('select',index);
		}
	}
	/**
	 * 重新加载TAB选项卡的内容，
	 * index从0开始算起，即0表示第一个选项卡。
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int TAB选项卡index 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.loadTabs = function(tabs,index){
		var total = this.getLength(tabs);
		if(0 <= index && index < total){
			tabs.tabs('load',index);
		}
	}
	/**
	 * 设置TAB选项卡的URL，
	 * index从0开始算起，即0表示第一个选项卡。
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @param index int TAB选项卡index 参数必须 是
	 * @param url String TAB选项卡URL 参数必须 是
	 * @return 无
	 * @type void
	 */
	this.setTabsURL = function(tabs,index,url){
		var total = this.getLength(tabs);
		if(0 <= index && index < total){
			tabs.tabs('url',index,url);
			this.loadTabs(tabs,index);
		}
	}
	/**
	 * 获取当前被选中的Tabs的index
	 * @param tabs Tabs 已经创建的Tabs对象 参数必须 是
	 * @return 返回当前被选中的Tabs的index
	 * @type int
	 */
	this.getSelectedIndex = function(tabs){
		return tabs.data('selected.tabs');
	}
}


/**
 * @class JavaScript TAB选项卡实体类。<br />
 * 此类功能包括：<br />
 * TAB选项卡实体实现。
 * @constructor 构造函数
 * @throws MemoryException 如果没有足够的内存
 * @return 返回 DCalendarClass 对象
 */
function DTabsBean(){
	/**
	 * TAB选项卡ID
	 * @type String
	 */
	var tabsId;
	/**
	 * 获取TAB选项卡ID
	 * @return 返回TAB选项卡ID
	 * @type String
	 */
	this.getTabsId = function(){
		return tabsId;
	}
	/**
	 * TAB选项卡名称
	 * @type String
	 */
	var tabsName;
	/**
	 * 获取TAB选项卡名称
	 * @return 返回TAB选项卡名称
	 * @type String
	 */
	this.getTabsName = function(){
		return tabsName;
	}
	/**
	 * TAB选项卡URL
	 * @type String
	 */
	var tabsUrl = '';
	/**
	 * 获取TAB选项卡URL
	 * @return 返回TAB选项卡URL
	 * @type String
	 */
	this.getTabsUrl = function(){
		return tabsUrl;
	}
	/**
	 * TAB选项卡显示内容
	 */
	var content;
	/**
	 * 获取TAB选项卡显示内容
	 * @return 返回TAB选项卡显示内容
	 * @type String
	 */
	this.getContent = function(){
		return content;
	}
	/**
	 * 初始化设置TAB选项卡Bean对象中的属性值
	 * @return 无
	 * @type void
	 */
	this.init = function(pid,pname,purl,pcontent){
		tabsId = pid;
		tabsName = pname;
		tabsUrl = purl;
		content = pcontent;
	}
}
/**
 * @ignore 
 * 树形菜单组件类实例对象,即引入DTabs.js文件，
 * 可以通过DTabs.XXX()的方式使用树形菜单组件。
 */
var DTabs = new DTabsClass();


