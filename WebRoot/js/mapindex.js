/**
 * 地图对象
 * @type BMap
 */
var map ;
/**
 *  地图上悬浮查询标签
 * @type MyLable
 */
var label;
/**
 * 判断鼠标是否在label上
 * @type Boolean
 */
var isOnLabel=false;
/**
 * 默认标记大小
 * @type BMap.Size
 */
var markerSize=new BMap.Size(40,50);
/**
 * 蓝色标记
 * @type BMap.Icon
 */
var blueMarker=new BMap.Icon("img/blue.png",markerSize);
/**
 * 绿色标记
 * @type BMap.Icon
 */
var greenMarker=new BMap.Icon("img/green.png",markerSize);
/**
 * 红色标记
 * @type BMap.Icon
 */
var redMarker=new BMap.Icon("../../../bridge/plug-in/image/red.png",markerSize);

// 用于存放常用搜索的三个变量
/**
 * 桥梁分类
 * @type 
 */
var bridgeCategory=[] ;
/**
 * 桥梁类别
 * @type 
 */
var bridgeType =[];
/**
 * 桥梁技术状况
 * @type 
 */
var evaluationLevel=[] ;
/**
 * 道路编号
 * @type 
 */
var roadNo;
/**
 * 当前页
 */
var page;
/**
 * 总数
 */ 
var count;

/**
 * 用于存放地图上点与桥梁id的关联
 * @type 
 */
var points;

var pt = new BMap.Point(119.422383,33.048314);
var bluemarker = new BMap.Marker(pt,{icon:blueMarker});
var greenmarker = new BMap.Marker(pt,{icon:greenMarker});

/**
 *  创建地图控件
 */
function init() {
	map= new BMap.Map("map",{minZoom:4,maxZoom:18}); 
	//map.centerAndZoom("南京", 12);  // 初始化地图,设置中心点坐标和地图级别
	map.centerAndZoom("兴化", 8);
	map.enableScrollWheelZoom(true);		// 设置滚轮缩放
	var top_left_navigation = new BMap.NavigationControl();  // 左上角，添加默认缩放平移控件	
	map.addControl(top_left_navigation);  
	map.addControl(new BMap.ScaleControl());// 比例尺控件
	var stCtrl = new BMap.PanoramaControl(); //构造全景控件
	stCtrl.setOffset(new BMap.Size(20, 20));
	map.addControl(stCtrl);//添加全景控件

	// 搜索的初始化
	var controlHtml="<div class='xz_select'  style='top:0'> " +
		"<div class='xz_select_title'> 请搜索 <i class='iconfont icon-zhongdianzhishi'></i>"
	+ "</div> <div class='xz_select_content'> <ul> <li>桥梁分类： " +
		"<a href='#' onclick='addPoint()'>特大桥</a> " +
		"| <a href='#' onclick='addPoint()'>大桥</a> | " +
		"<a href='#' onclick='addPoint()'>中桥</a> |" +
		" <a href='#' onclick='addPoint()'>小桥</a>" +
		"</li> <li>桥梁类型：" +
        " <a href='#'>梁桥</a> "+"| <a href='#'>拱桥</a> |"+" <a href='#'>悬索桥</a> |" +
        " <a href='#'>斜拉桥</a> |"+" <a href='#'>组合桥</a> ";
	// 从数据表中获取桥梁类型的code和name

		   	controlHtml=controlHtml.substring(0,controlHtml.length-1);
		   	controlHtml+="</li> <li>桥梁技术状况：<a href='#'> 一类</a> |<a href='#'> 二类</a> | "
								+ "<a href='#'>三类</a> | <a href='#'>四类</a> | "
								+ "<a href='#'>五类</a> | <a href='#'>未评定</a></li> </ul> </div> </div>";
			// 创建控件
			var myControl = new MyControl(controlHtml);
			// 添加到地图当中
			map.addControl(myControl);
			// 常用搜索框的隐藏图标
			$('.xz_select_title').click(function(){
				$('.xz_select').hide();
			});

	
	
	// 添加自定义覆盖物(查询框)
	//var labelHtml="<img src='../../../bridge/plug-in/image/cx.png' style='cursor:pointer;' />";
   // label=new MyLabel(labelHtml,null,{x:-20,y:-40});
	//labelInit();
	// 自定义覆盖物没法设置禁止删除，只能这样每次重新初始化
	//map.addEventListener("clearoverlays", function() {
	   // labelInit();
	//});
	
}

function closePoint(){
    $('.xz_select').hide();

    hideRslt();

}

function addPoint(){
    $('.xz_select').hide();
    showRslt();
    map.clearOverlays();
    var pt = new BMap.Point(119.422383,33.048314);
    map.addOverlay(bluemarker);
    // var marker = new BMap.Marker(pt,{icon:blueMarker});
    // bluemarker.addEventListener("infowindowclose", changeBlue);
    var opts = {
        title  : '宝应运河三桥3',      // 标题
        width  : 350,             // 宽度
        height : 180,              // 高度
        panel  : "panel",         // 检索结果面板
        enableAutoPan : true,     // 自动平移
        enableSendToPhone :false,		// 发送到手机功能
    };
    var sContent = "<div style='margin:0;line-height:20px;padding:2px;'>" +
        "<img style='float:right;margin:4px' id='bridgeImg' src='img/baoying.png' width='150' height='120'  title='宝应运河三桥'/>" +
        "所在地：江苏省扬州市宝应县<br/><br/>管养单位：扬州市宝应县公路管理站<br/></br>桥梁等级：2"+
        "</div>";
    var infoWindow = new BMap.InfoWindow(sContent,opts);
    bluemarker.addEventListener("infowindowclose", function () {
        map.clearOverlays();
        map.addOverlay(bluemarker);
    });
    bluemarker.addEventListener("click", function(){

        map.clearOverlays();
        map.addOverlay(greenmarker);

        // greenmarker.addEventListener("click", function () {
        //     closeInfo(pt);
			// this.openInfoWindow(infoWindow);
        // });
        greenmarker.addEventListener("infowindowclose", function () {
            map.clearOverlays();
            map.addOverlay(bluemarker);
        });
        greenmarker.openInfoWindow(infoWindow,pt);
        // bluemarker.openInfoWindow(infoWindow);
         //showInfo(pt);
    });


}

/**
 * label功能初始化
 */
function labelInit(){
	map.addOverlay(label);
	label.hide();
	label.addEventListener("click",function(e){
		label.hide();
		$("#bridgeName").val("");
		map.clearOverlays();
		roadNo=label.roadName;
		searchBridgeInfo("road");
	});
	// 给鼠标添加停靠事件
	label.addEventListener("mouseover",function(e){
		isOnLabel=true;
	});
	label.addEventListener("mouseout",function(e){
		isOnLabel=false;
	});
}


$(function(){
	init();

	//searchRoadPointInfo(null);

	// 控制结果块显示隐藏
	$(".btn_left").toggle(function(event){
					showRslt();
				},
				function(event)
				{
					hideRslt();
	 			}
	 );

	$('.btn_select').click(function(){
	// 给常用搜索添加点击事件	
		if($('.xz_select').is(':hidden')){
			$('.xz_select').show();
		}else{
			$('.xz_select').hide();
		}
		
	});	


});
/**
 * 初始化常用搜索参数
 */
function initSearch(){
		bridgeCategory=[] ;
		bridgeType =[];
		evaluationLevel=[] ;
		$("a").css("background","#fff").css("color","#7993df");
}

// 展示结果
function showRslt(){
	var www2=$('.content_map_title').width()-350;
	$(".left_map").animate({width:"285px"},200,function(e){// 回调里再改变宽度，防止marker错位
		$("#map").width(www2);
	});
	$(".look_map").animate({width:www2},200);
	$('.w_close').show();

}
// 显示全图
function hideRslt(){
	$(".left_map,#list-item").animate({width:"0%"},200,function(e){
		var www=$('.content_map_title').width();
		$("#map").width(www);
	});
	$(".look_map").animate({width:www},200);
}











/**
 * 回车搜索
 * @param {} event
 */
function isEnter(event){
	if(event.keyCode==13){
		searchBridgeInfo('init');
	}
}

/**
 * 查询桥梁信息
 */
function searchBridgeInfo(p){
   if(p=="init"||p=="road"){
	  	initSearch();
		if(p=="init"){
			roadNo="";
		}
		p=0;
	}else if(p<0||p*10>count){
	   return
   }
    page=p;
	var bridgeName = $("#bridgeName").val();
	var params = {
		"bridgeName" : bridgeName,
		"bridgeCategory" : bridgeCategory.toString(),
		"bridgeType" : bridgeType.toString(),
		"evaluationLevel" : evaluationLevel.toString(),
		"page":page,
		"roadNo":roadNo
	};
	$.ajax({
		   type: "POST",
		   url: "index.do?result",
		   data: params,
		   dataType:"json",
		   success: function(data){
				    //showRslt();
			 		var str = "";
			 		count=data[0].count;
			 		mapData=data[0].noPageList;
			 		data=data[0].list;
			   if(data!=null && data!=""){
				    showRslt();
		     		$.each(data,function(index,item){
		     			var address=item.address;
		     			var addressStr="";
		     			if(address.length>=2){
		     				addressStr+=area_array[address.substr(0,2)];
		     			}
		     			if(address.length>=4){
		     				addressStr+=l_arr[address.substr(0,4)];
		     			}
		     			if(address.length>=6){
		     				addressStr+=sub_arr[address.substr(0,4)][address.substr(0,6)];
		     			}
		     			item.address=addressStr;
						str += "<li class='left_map_li_"+(index+1)+"' onclick='showPointByBridgeId(\""+item.id+"\")'>";
         				str += "<div class='left_p1'><a href='bridgeBaseInfo.do?initBridgeView&bridgeId="+item.id+"&flag=1' target='_blank'>"+item.bridgeName+"</a></div>";
            			str += "<div class='left_p2'><img src='../../../bridge/plug-in/image/sanwei.png'/><a href='javascript:void(0)' onclick='window.open(\"index.do?toBim\")' style='padding-left:5px'>三维</a></div>";
             			str += "<p class='left_p3'>所在地:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "+item.address+"</p>";
             			str += "<p class='left_p4'>管养单位：&nbsp;&nbsp;"+item.deptName+"</p>";
         				str += "</li>";
			 		});
			 		if(count>10){
		     			str+="<li  style='width:100%; text-align: center; margin-bottom:5px;' ><span class='page' onclick='searchBridgeInfo("+(page-1)+")'><上一页 </span>"+
			     		(page+1)+"/"+parseInt(count/10+1)+
		     			"<span class='page' onclick='searchBridgeInfo("+(page+1)+")'> 下一页></span></li>";
			 		}
			 		$("#list-item").html(str);
			 		TINY.scroller.init('left_map','list-item','scrollbar','scroller','buttonclick');
				 	addMarker(mapData);
			 		
			   }
			   else{
				   map.clearOverlays();
				   $("#list-item").html("");
				   alertMsg("未找到符合条件的桥梁信息");
				   hideRslt();
			   }
		   },
	   	   error :function(XMLHttpRequest, textStatus,e){
				alert("error"+e);
		   	}
		}); 	
}

function clickLeft(){
    var opts = {
        title  : '宝应运河三桥',      // 标题
        width  : 350,             // 宽度
        height : 200,              // 高度
        panel  : "panel",         // 检索结果面板
        enableAutoPan : true,     // 自动平移
        enableSendToPhone :false,		// 发送到手机功能
    }
    var sContent = "<div style='margin:0;line-height:20px;padding:2px;'>" +
        "<img style='float:right;margin:4px' id='bridgeImg' src='img/baoying.png' width='150' height='120'  title='宝应运河三桥'/>" +
        "所在地：江苏省扬州市宝应县<br/><br/>管养单位：扬州市宝应县公路管理站<br/></br>桥梁等级：2"+
        "</div>";
    var infoWindow = new BMap.InfoWindow(sContent,opts);
    map.clearOverlays();
    map.addOverlay(greenmarker);
    greenmarker.addEventListener("infowindowclose", function () {
        map.clearOverlays();
        map.addOverlay(bluemarker);
    });
    greenmarker.openInfoWindow(infoWindow,pt);
}
function showPointByBridgeId(bridgeId){
	var marker=points[bridgeId];
	showInfo(marker.getPosition(),marker.bridgeData);
	map.panTo(marker.getPosition());
}
/**
 * 获取道路点信息
 */
function searchRoadPointInfo(roadNos){
	var param=null==roadNos?null:{"roadNos":roadNos.toString()};
	$.ajax({
		type:"POST",
		url:"index.do?getRoadPoints",
		dataType:"json",
		data:param,
		success:function(data){
			if(""!=data){
				var roads=data.road;
				$.each(roads,function(index,item){
					var arr=item.points;
					var len=arr.length;
					var points=[];
					for(var i=0;i<len;i++){
						var point=new BMap.Point(arr[i][0],arr[i][1]);
						points.push(point);
					}
					var road=new BMap.Polyline(points,{
						strokeColor:"#ffff33", 
						strokeWeight:6});
					road.addEventListener("mouseover",overFun);
					road.addEventListener("mouseout",outFun);
					road.roadName=item.roadName;
					road.setStrokeOpacity(0.001);
					road.disableMassClear();
					if(null!=roadNos){
						road.setStrokeOpacity(1);
						road.enableMassClear();
						road.removeEventListener("mouseover",overFun);
						road.removeEventListener("mouseout",outFun);
					}
					map.addOverlay(road);
				})
			}else{
				alertMsg("未找到道路信息");
			}
		},
		error :function(XMLHttpRequest, textStatus,e){
			alert("error"+e);
	   	}
	});
}
// 计时器
var t;
/**
 * 鼠标覆盖道路后高亮显示，持续一秒显示查询按钮、取消隐藏查询按钮的判断
 */
function overFun(e){
	var road=e.target;
	road.setStrokeOpacity(1);
	clearInterval(t);
	t=setTimeout(getBridgesByRoad(e),1000);
}
/**
 * 鼠标移开后隐藏，并取消计时、移开一秒后隐藏查询按钮
 */
function outFun(e){
	var road=e.target;
	// 居然不能用0标示透明。。
	road.setStrokeOpacity(0.001);
	clearTimeout(t);
	t=setInterval(function(){
		if(!isOnLabel){
			label.hide();
			clearInterval(t);
			}
		},1000);
}

/**
 * 查询相关桥梁
 */ 
function getBridgesByRoad(e){
	return function(){
				label.setPosition(e.point);
				label.show();
				label.roadName=e.target.roadName;
	}
}


/**
 * 在地图上添加标注
 */
function addMarker(data){
	map.clearOverlays();
	var roadNos=[];
	points=new Object();
	$.each(data,function(index,item){
        var bl=item.bridgeLocation.split(",");
        var roadNo=item.roadNo;
        if(-1==getIndexFromArr(roadNos,roadNo)){
        	roadNos.push(roadNo);
        }
        var level=item.level;
        //默认使用蓝色标记
        var markerIcon=blueMarker;
        if(level==4||level==5){//4,5级使用红色标记
        	markerIcon=redMarker;
        }else if(level==3){//三级使用绿色标记
        	markerIcon=greenMarker;
        }
		var marker = new BMap.Marker(new BMap.Point(bl[0],bl[1]),{icon:markerIcon});
		marker.addEventListener("click", showInfoOfBridge);
		points[item.id]=marker;
		var address=item.address;
		// 地址的解析：2位是省，4位是市，6位是县
		if(address.match(/^\d+$/)){
			var addressStr="";
			if(address.length>=2){
				addressStr+=area_array[address.substr(0,2)];
			}
			if(address.length>=4){
				addressStr+=l_arr[address.substr(0,4)];
			}
			if(address.length>=6){
				addressStr+=sub_arr[address.substr(0,4)][address.substr(0,6)];
			}
			item.address=addressStr;
		}
		marker.bridgeData=item;
		map.addOverlay(marker); 
		if(index == 0){
			map.panTo(marker.getPosition());
		}
	});
	//if(roadNos.length>0){
		//searchRoadPointInfo(roadNos);
	//}	
}
/**
 * 点击Marker后显示对应桥梁信息
 */
function changeGreen(e){
    map.clearOverlays();
    greenmarker.addEventListener("mouseout", changeBlue);
    greenmarker.addEventListener("click", showInfoOfBridge);
    map.addOverlay(greenmarker);
}
function changeBlue(e){
    map.clearOverlays();
    //bluemarker.addEventListener("click", showInfoOfBridge);
    map.addOverlay(bluemarker);
}

function showInfoOfBridge(e){
    map.clearOverlays();
    bluemarker.addEventListener("infowindowclose", changeBlue);
    greenmarker.addEventListener("infowindowclose", changeBlue);
    map.addOverlay(greenmarker);
    var point=e.target.getPosition();
	showInfo(point);
}

/**
 * 显示相关信息
 * @param {} point
 * @param {} pointData
 */
function showInfo(point){
	 var content = "<div style='margin:0;line-height:20px;padding:2px;'>" +
	 "<img style='float:right;margin:4px' id='bridgeImg' src='baoying.png' width='150' height='120'  title='宝应运河三桥'/>" +
        "所在地：江苏省扬州市宝应县<br/><br/>管养单位：扬州市宝应县公路管理站<br/></br>桥梁等级：2"+
      "</div>";
    	var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
    			title  : '宝应运河三桥1',      // 标题
    			width  : 350,             // 宽度
    			height : 140,              // 高度
    			panel  : "panel",         // 检索结果面板
    			enableAutoPan : true,     // 自动平移
    			enableSendToPhone :false,		// 发送到手机功能
    			searchTypes   :[
// BMAPLIB_TAB_SEARCH, //周边检索
// BMAPLIB_TAB_TO_HERE, //到这里去
// BMAPLIB_TAB_FROM_HERE //从这里出发
    			]
    		});
    	searchInfoWindow.open(point);
}

function closeInfo(point){
    var content = "<div style='margin:0;line-height:20px;padding:2px;'>" +
        "<img style='float:right;margin:4px' id='bridgeImg' src='baoying.png' width='150' height='120'  title='宝应运河三桥'/>" +
        "所在地：江苏省扬州市宝应县<br/><br/>管养单位：扬州市宝应县公路管理站<br/></br>桥梁等级：2"+
        "</div>";
    var searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
        title  : '宝应运河三桥2',      // 标题
        width  : 350,             // 宽度
        height : 140,              // 高度
        panel  : "panel",         // 检索结果面板
        enableAutoPan : true,     // 自动平移
        enableSendToPhone :false,		// 发送到手机功能
        searchTypes   :[
// BMAPLIB_TAB_SEARCH, //周边检索
// BMAPLIB_TAB_TO_HERE, //到这里去
// BMAPLIB_TAB_FROM_HERE //从这里出发
        ]
    });
    searchInfoWindow.close(point);
}


/**
 * 给隐藏域添加值
 */

 function setValueForHidden(string){
 	//通过jQuery兼容event对象
 	 var e=window.event||arguments.callee.caller.arguments[0];//兼容火狐
 	 var target=$.event.fix(e).target;
	 var str = string.split(",");
	 var perStr = str[0];
	 var senStr = str[1];
	 var index=getIndexFromArr(this[perStr],senStr);
	 if(-1==index){
	 	this[perStr].push(senStr);
	 	target.style.background="#4c89c8";
	 	target.style.color="#fff";
	 }else{
	 	this[perStr].splice(index,1);
	 	target.style.background="#fff";
	 	target.style.color="#7993df";
	 }
	 searchBridgeInfo(0);
	 }