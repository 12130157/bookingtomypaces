﻿/*!
 * lhgcore Dialog Plugin v3.1.3
 * Date : 2010-06-12 15:09:11
 * Copyright (c) 2009 - 2010 By Li Hui Gang
 */
(function(a){function x(){return a.browser.ie?a.browser.i7?"":"javascript:''":"javascript:void(0);"}function y(){v||(v=999);return++v}function B(){var h=a.root(l);a(u).css({width:Math.max(h.scrollWidth,h.clientWidth||0)-1+"px",height:Math.max(h.scrollHeight,h.clientHeight||0)-1+"px"})}a.ui=a.ui||{};for(var m=window,u,l,s,v,C=0;m.parent!=m;)m=m.parent;l=m.document;a.fn.fixie6png=function(){for(var h=a("*",this),t,c=0,d=h.length;c<d;c++){t=a(h[c]).css("backgroundImage");if(t.indexOf(".png")!==-1){t=t.replace(/url\(|"|\)/g,"");h[c].style.backgroundImage="none";h[c].runtimeStyle.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+t+"',sizingMethod='scale')"}}};a.ui.getScrollSize=function(h){h=h||window;if("pageXOffset"in h)return{x:h.pageXOffset||0,y:h.pageYOffset||0};else{h=a.root(h.document);return{x:h.scrollLeft||0,y:h.scrollTop||0}}};a.ui.getClientSize=function(h){h=a.root((h||window).document);return{w:h.clientWidth||0,h:h.clientHeight||0}};a.fn.dialog=function(h){var t=false;if(this[0])t=new a.ui.dialog(h,this[0]);return t};a.ui.dialog=function(h,t){var c=this,d=this.opt=a.extend({height:300,width:400,id:"lhgdlgId",event:"click",link:false,btns:true,fixed:false,drag:true,resize:true,top:"center",left:"center",title:"lhgdialog",regDragWindow:[]},h||{});if(d.SetTopWindow){m=d.SetTopWindow;l=m.document}if(C===0){if(a.browser.ie&&!a.browser.i7)try{l.execCommand("BackgroundImageCache",false,true)}catch(D){}C+=1}iframe=a.browser.ie&&!a.browser.i7?'<iframe hideFocus="true" frameborder="0" src="'+x()+'" style="position:absolute;z-index:-1;width:100%;height:100%;top:0px;left:0px;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0)"></iframe>':"";s||(s=a('<div id="lhgdig_cDiv" style="position:absolute;top:0px;left:0px;border:1px solid #000;background-color:#999;display:none;"></div>',l).css("opacity",0.3).appendTo("body").bind("contextmenu",function(b){b.preventDefault()})[0]);this.SetIFramePage=function(){var b;if(d.html)b=typeof d.html==="string"?'<div id="lhgdig_inbox" class="lhgdig_inbox" style="display:none">'+d.html+"</div>":'<div id="lhgdig_inbox" class="lhgdig_inbox" style="display:none"></div>';else if(d.page)b=['<iframe frameborder="0" src="',d.page,'" scrolling="auto" id="lhgfrm" style="display:none;width:100%;height:100%;"></iframe>'].join("");return['<div id="',d.id,'" class="lhgdig" style="width:',d.width,"px;height:",d.height,'px;"><table border="0" cellspacing="0" cellpadding="0"><tr><td class="lhgdig_leftTop"></td><td id="lhgdig_drag" class="lhgdig_top"><div class="lhgdig_title"><span id="lhgdig_icon" class="lhgdig_icon"></span>',d.title,'</div><div id="lhgdig_xbtn" class="lhgdig_xbtn"></div></td><td class="lhgdig_rightTop"></td></tr><tr><td class="lhgdig_left" id="lhgdigLeft"></td><td><table border="0" cellspacing="0" cellpadding="0"><tr><td id="lhgdig_content" class="lhgdig_content">',b,'<div id="throbber" class="lhgdig_throbber"><span id="lhgdig_load">loading...</span></div></td></tr>',d.btns?'<tr><td id="lhgdig_btns" class="lhgdig_btns"><div id="lhgdig_bDiv" class="lhgdig_bDiv"></div></td></tr>':"",'</table></td><td class="lhgdig_right"></td></tr><tr><td class="lhgdig_leftBottom"></td><td class="lhgdig_bottom"></td><td id="lhgdig_drop" class="lhgdig_rightBottom"></td></tr></table>',iframe,"</div>"].join("")};this.ShowDialog=function(){if(!a("#"+d.id,l)[0]){d.cover&&this.ShowCover();var b=d.fixed&&(!a.browser.ie||a.browser.i7)?"fixed":"absolute",e=this.SetIFramePage();this.dlg=a(e,l).css({position:b,zIndex:y()}).appendTo(l.body)[0];this.iPos(this.dlg,d.top,d.left,d.fixed);this.setDialog(this.dlg);d.drag&&this.initDrag(a("#lhgdig_drag",this.dlg)[0]);d.resize&&this.initSize(a("#lhgdig_drop",this.dlg)[0]);if(a.browser.ie&&!a.browser.i7)(a("html",l).css("ie6PngRepair")==="true"?true:false)&&a(this.dlg).fixie6png();this.lhgDigxW=a("#lhgdigLeft",this.dlg)[0].offsetWidth*2;this.reContentSize(this.dlg);d.html&&d.cusfn&&d.cusfn();if(d.html){a("#throbber",this.dlg).css("display","none");a("#lhgdig_inbox",this.dlg)[0].style.display="inline-block"}}};this.iPos=function(b,e,i,j){var n=a.ui.getClientSize(m),o=a.ui.getScrollSize(m),g=b.offsetWidth,p=b.offsetHeight;if(j){if(a.browser.ie&&!a.browser.i7){a("html",l).addClass("lhgdig_ie6_fixed");a('<div class="lhgdig_warp"></div>',l).appendTo(l.body).append(b).css("zIndex",y())}lx=0;rx=n.w-g;cx=(rx-20)/2;ty=0;by=n.h-p;cy=(by-20)/2}else{lx=o.x;cx=o.x+(n.w-g-20)/2;rx=o.x+n.w-g;ty=o.y;cy=o.y+(n.h-p-20)/2;by=o.y+n.h-p}switch(i){case"center":i=cx;break;case"left":i=lx;break;case"right":i=rx;break;default:if(j)i-=o.x;i=i;break}switch(e){case"center":e=cy;break;case"top":e=ty;break;case"bottom":e=by;break;default:if(j)e-=o.y;e=e;break}a(b).css({top:e+"px",left:i+"px"})};this.setDialog=function(b){this.win=window;this.top=m;a(b).bind("contextmenu",function(e){e.preventDefault()}).bind("mousedown",c.setIndex);a("#lhgdig_xbtn",b).hover(function(){a(this).addClass("lhgdig_xbtnover")},function(){a(this).removeClass("lhgdig_xbtnover")}).click(c.cancel);d.html&&d.html.nodeType&&a("#lhgdig_inbox",b).append(d.html);this.regWindow=[window];d.regDragWindow.length>0&&this.regWindow.push(d.regDragWindow);m!=window&&this.regWindow.push(m);if(d.page){this.infrm=a("#lhgfrm",b)[0];if(!d.link){this.inwin=this.infrm.contentWindow;this.infrm.dg=this}a(this.infrm).bind("load",function(){if(!c.opt.link){a(a.browser.ie?this.contentWindow.document:this.contentWindow).bind("mousedown",c.setIndex);c.regWindow.push(this.contentWindow)}a("#throbber",c.dlg)[0].style.display="none";this.style.display="block"})}};this.reContentSize=function(b){var e=a("#lhgdig_drag",b)[0].offsetHeight,i=a("#lhgdig_drop",b)[0].offsetHeight,j=this.lhgDigxW,n=d.btns?a("#lhgdig_btns",b)[0].offsetHeight:0;j=parseInt(b.style.width,10)-j;e=parseInt(b.style.height,10)-e-i-n;a("#lhgdig_content",b).css({width:j+"px",height:e+"px"});d.html&&a("#lhgdig_inbox",b).css({width:j+"px",height:e+"px"});this.SetLoadLeft()};this.reDialogSize=function(b,e){a(this.dlg).css({width:b+"px",height:e+"px"});this.reContentSize(this.dlg)};this.initDrag=function(b){function e(f){f={x:f.screenX,y:f.screenY};g={x:g.x+(f.x-j.x),y:g.y+(f.y-j.y)};j=f;if(d.rang){if(g.x<r.x)g.x=r.x;if(g.y<r.y)g.y=r.y;if(g.x>n)g.x=n;if(g.y>o)g.y=o}a(s).css({left:g.x+"px",top:g.y+"px"})}function i(){for(var f=0,k=p.length;f<k;f++){a(p[f].document).unbind("mousemove",e);a(p[f].document).unbind("mouseup",i)}a.browser.ie&&s.releaseCapture();s.style.display="none";b=j=null;c.opt.fixed?a(c.dlg).css({left:g.x-r.x+"px",top:g.y-r.y+"px"}):a(c.dlg).css({left:g.x+"px",top:g.y+"px"})}var j,n,o,g,p=this.regWindow,q,r;a(b).bind("mousedown",function(f){if(f.target.id!=="lhgdig_xbtn"){q=a.ui.getClientSize(m);r=a.ui.getScrollSize(m);var k=c.dlg.offsetLeft,w=c.dlg.offsetTop,z=c.dlg.clientWidth,A=c.dlg.clientHeight;g=c.opt.fixed?{x:k+r.x,y:w+r.y}:{x:k,y:w};j={x:f.screenX,y:f.screenY};n=c.opt.fixed?q.w-z:q.w+r.x-z;o=c.opt.fixed?q.h-A:q.h+r.y-A;a(s).css({width:z-2+"px",height:A-2+"px",left:g.x+"px",top:g.y+"px",zIndex:parseInt(v,10)+2,display:""});k=0;for(w=p.length;k<w;k++){a(p[k].document).bind("mousemove",e);a(p[k].document).bind("mouseup",i)}f.preventDefault();a.browser.ie&&s.setCapture()}})};this.initSize=function(b){function e(f){f={x:f.screenX,y:f.screenY};q={w:f.x-j.x,h:f.y-j.y};if(q.w<200)q.w=200;if(q.h<100)q.h=100;a(s).css({width:q.w+"px",height:q.h+"px",top:g.y+"px",left:g.x+"px"})}function i(){for(var f=0,k=p.length;f<k;f++){a(p[f].document).unbind("mousemove",e);a(p[f].document).unbind("mouseup",i)}a.browser.ie&&s.releaseCapture();c.reDialogSize(q.w,q.h);s.style.display="none";b=j=null}var j,n,o,g,p=this.regWindow,q,r;a(b).bind("mousedown",function(f){o=c.dlg.clientWidth;n=c.dlg.clientHeight;q={w:o,h:n};a.ui.getClientSize(m);r=a.ui.getScrollSize(m);var k=c.dlg.offsetLeft,w=c.dlg.offsetTop;g=c.opt.fixed?{x:k+r.x,y:w+r.y}:{x:k,y:w};j={x:f.screenX-o,y:f.screenY-n};a(s).css({width:o-2+"px",height:n-2+"px",left:g.x+"px",top:g.y+"px",zIndex:parseInt(v,10)+2,display:""});k=0;for(w=p.length;k<w;k++){a(p[k].document).bind("mousemove",e);a(p[k].document).bind("mouseup",i)}f.preventDefault();a.browser.ie&&s.setCapture()})};this.setIndex=function(b){if(c.opt.fixed&&a.browser.ie&&!a.browser.i7){a(c.dlg).parent()[0].style.zIndex=parseInt(v,10)+1;v=parseInt(a(c.dlg).parent()[0].style.zIndex,10)}else{c.dlg.style.zIndex=parseInt(v,10)+1;v=parseInt(c.dlg.style.zIndex,10)}b.stopPropagation()};this.SetLoadLeft=function(){var b=(a("#lhgdig_content",this.dlg)[0].offsetWidth-a("#lhgdig_load",this.dlg)[0].offsetWidth)/2;a("#lhgdig_load",this.dlg)[0].style.left=b+"px"};this.addBtn=function(b,e,i){if(a("#"+b,this.dlg)[0])a("#"+b,this.dlg).html("<em>"+e+"</em>").click(i);else{b=a('<a id="'+b+'" class="lhgdig_button" href="javascript:void(0)" hidefocus="true"><em>'+e+"</em></a>",l).click(i)[0];a("#lhgdig_bDiv",this.dlg).append(b)}};this.removeBtn=function(b){a("#"+b,this.dlg)[0]&&a("#"+b,this.dlg).remove()};this.reload=function(b,e){b=b||window;c.cancel();b.location.href=e?e:b.location.href};this.ShowCover=function(){if(!u){var b=['<div style="position:absolute;top:0px;left:0px;background-color:#fff;">',iframe,"</div>"].join("");u=a(b,l).css("opacity",0.5).appendTo(l.body)[0]}a(m).bind("resize",B);B();a(u).css({display:"",zIndex:y()})};this.cancel=function(){var b=a("#lhgfrm",c.dlg)[0];if(b){c.opt.link||a(b.contentWindow).unbind("load");b.src=x()}c.regWindow=[];if(c.opt.fixed&&a.browser.ie&&!a.browser.i7){a("html",l).removeClass("lhgdig_ie6_fixed");a(c.dlg).parent().remove()}else a(c.dlg).remove();c.dlg=null;if(u)if(c.opt.parent&&c.opt.parent.opt.cover)u.style.zIndex=parseInt(c.opt.parent.dlg.style.zIndex,10)-1;else u.style.display="none"};this.cleanDialog=function(){if(c.dlg){var b=a("#lhgfrm",c.dlg)[0];if(b){c.opt.link||a(b.contentWindow).unbind("load");b.src=x()}if(c.opt.fixed&&a.browser.ie&&!a.browser.i7){a("html",l).removeClass("lhgdig_ie6_fixed");a(c.dlg).parent().remove()}else a(c.dlg).remove();c.dlg=null}};a(window).bind("unload",this.cleanDialog);t&&a(t).bind(d.event,function(){c.ShowDialog()})};a(window).bind("unload",function(){a(s).remove();s=null;if(u){a(u).remove();u=null}})})(lhgcore);