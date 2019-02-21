var orderUrl = 'https://shop.hbhk.com.cn';
/**
 * 判空
 * @param {Object} str	
 */
function isEmpty(str) {
	if(str == null || typeof(str) == 'undefined' || str == 'null' || str == '(null)' || str == '<null>' || str == 'undefined' || str == 'NULL' || str == undefined || str.length == 0) {
		return true;
	}
	if(typeof(str) == 'string' && str.replace(/(^s*)|(s*$)/g, "").length == 0) {
		return true;
	}
	if(typeof(str) == 'number' && str == 0) {
		return true;
	}
	return false;
}

/**
 * MUI按鈕倒計時
 * @param {Object} t
 * @param {Object} obj
 * @param {Object} waitMessage
 */
function disableWait(t, obj, waitMessage) {
	var objTag = obj.tagName.toLowerCase();
	if(objTag !== "input" && objTag != "button" && objTag != "span") {
		return;
	}

	var v = objTag !== "input" ? obj.innerText : obj.value;
	var i = setInterval(function() {
		if(t > 0) {
			switch(objTag) {
				case "input":
					obj.value = (--t) + waitMessage;
					break;
				case "button":
					obj.innerText = (--t) + waitMessage;
					break;
				case "span":
					obj.innerText = (--t) + waitMessage;
					break;
				default:
					break;
			}
			obj.disabled = true;
			obj.classList.add("code-disabled");
		} else {
			window.clearInterval(i);
			switch(objTag) {
				case "input":
					obj.value = v;
					break;
				case "button":
					obj.innerText = v;
					break;
				case "span":
					obj.innerText = v;
					break;
				default:
					break;
			}
			obj.disabled = false;
			obj.classList.remove("code-disabled");
			mui(obj).button('reset');
		}
	}, 1000);
}

/**
 * 獲取get傳參
 * @param {Object} name
 */
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	} else {
		return null;
	}
}

/**
 * 以JSON的形式格式化參數
 * @param {Object} formId
 */
function serializeJson(formId) {
	var params = $("#" + formId).serializeArray();
	var list = {};
	$.each(params, function(i, field) {
		list[field.name] = field.value;
	});
	return list;
}

/**
 * 去除空格
 * @param {Object} testStr
 */
function iGetInnerText(testStr) {
	var resultStr = testStr.replace(/\ +/g, ""); //去掉空格
	resultStr = testStr.replace(/[ ]/g, ""); //去掉空格
	resultStr = testStr.replace(/[\r\n]/g, ""); //去掉回车换行
	return resultStr;
}

/**
 * 選擇照片
 */
function clickGallery(param) {
	plus.gallery.pick(function(path) {
		plus.zip.compressImage({
			src: path,
			dst: "_doc/chat/gallery/" + path,
			quality: 20,
			overwrite: true
		}, function(e) {
			cutImage(e.target, param);
		}, function(err) {
			console.error("压缩失败：" + err.message);
		});

	}, function(err) {});
};

/**
 * 調用攝像頭
 */
function clickCamera(param) {
	var cmr = plus.camera.getCamera();
	var res = cmr.supportedImageResolutions[0];
	var fmt = cmr.supportedImageFormats[0];
	cmr.captureImage(function(path) {
		plus.io.resolveLocalFileSystemURL(path, function(entry) {
			var localUrl = entry.toLocalURL();
			plus.zip.compressImage({
				src: localUrl,
				dst: "_doc/chat/camera/" + localUrl,
				quality: 20,
				overwrite: true
			}, function(e) {
				cutImage(e.target, param);
			}, function(err) {
				console.log("压缩失败：  " + err.message);
			});
		});
	}, function(err) {
		console.error("拍照失败：" + err.message);
	}, {
		index: 1
	});
};

/**
 * 裁剪圖片
 * @param {Object} path
 */
function cutImage(path, param) {
	mui.openWindow({
		url: 'cropper.html',
		id: 'cropper',
		extras: {
			path: path,
			type: param
		},
		show: {
			aniShow: 'zoom-fade-in',
			duration: 800
		},
		waiting: {
			autoShow: true
		}
	});
}

/**       
 * 对Date的扩展，将 Date 转化为指定格式的String       
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符       
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:       
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423       
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04       
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04       
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04       
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18       
 */
Date.prototype.pattern = function(fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份
		"d+": this.getDate(), //日
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时
		"H+": this.getHours(), //小时
		"m+": this.getMinutes(), //分
		"s+": this.getSeconds(), //秒
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度
		"S": this.getMilliseconds() //毫秒
	};
	var week = {
		"0": "/u65e5",
		"1": "/u4e00",
		"2": "/u4e8c",
		"3": "/u4e09",
		"4": "/u56db",
		"5": "/u4e94",
		"6": "/u516d"
	};
	if(/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if(/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
	}
	for(var k in o) {
		if(new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}

/**
 * 
 * @param {Object} mask
 */
Date.prototype.format = function(mask) {
	var d = this;
	var zeroize = function(value, length) {
		if(!length) length = 2;
		value = String(value);
		for(var i = 0, zeros = ''; i < (length - value.length); i++) {
			zeros += '0';
		}
		return zeros + value;
	};

	return mask.replace(/"[^"]*"|'[^']*'|\b(?:d{1,4}|m{1,4}|yy(?:yy)?|([hHMstT]+)?|[lLZ])\b/g, function($0) {
		switch($0) {
			case 'd':
				return d.getDate();
			case 'dd':
				return zeroize(d.getDate());
			case 'ddd':
				return ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'][d.getDay()];
			case 'dddd':
				return ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'][d.getDay()];
			case 'M':
				return d.getMonth() + 1;
			case 'MM':
				return zeroize(d.getMonth() + 1);
			case 'MMM':
				return ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'][d.getMonth()];
			case 'MMMM':
				return ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'][d.getMonth()];
			case 'yy':
				return String(d.getFullYear()).substr(2);
			case 'yyyy':
				return d.getFullYear();
			case 'h':
				return d.getHours() % 12 || 12;
			case 'hh':
				return zeroize(d.getHours() % 12 || 12);
			case 'H':
				return d.getHours();
			case 'HH':
				return zeroize(d.getHours());
			case 'm':
				return d.getMinutes();
			case 'mm':
				return zeroize(d.getMinutes());
			case 's':
				return d.getSeconds();
			case 'ss':
				return zeroize(d.getSeconds());
			case 'l':
				return zeroize(d.getMilliseconds(), 3);
			case 'L':
				var m = d.getMilliseconds();
				if(m > 99) m = Math.round(m / 10);
				return zeroize(m);
			case 'tt':
				return d.getHours() < 12 ? 'am' : 'pm';
			case 'TT':
				return d.getHours() < 12 ? 'AM' : 'PM';
			case 'Z':
				return d.toUTCString().match(/[A-Z]+$/);
			default:
				return $0.substr(1, $0.length - 2);
		}
	});
};

/**
 * 计算天数差的函数，通用  
 * @param {Object} sDate1
 * @param {Object} sDate2
 */
function DateDiff(sDate1, sDate2) {
	var aDate, oDate1, oDate2, iDays
	aDate = sDate1.split("-")
	oDate1 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0])
	aDate = sDate2.split("-")
	oDate2 = new Date(aDate[1] + '/' + aDate[2] + '/' + aDate[0])
	iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24)
	return iDays;
}

/**
 * 判斷json是都未空
 * @param {Object} json
 */
function isEmptyJson(json) {
	for(var obj in json) {
		if(!isEmpty(json[obj])) {
			return false;
		}
	}
	return true;
}

/**
 * 清除json
 * @param {Object} json
 */
function clearJson(json) {
	for(var obj in json) {
		json[obj] = "";
	}
	return json;
}

/**
 * 字符串转JSON
 * @param {Object} code
 * @param {Object} name
 */
function str2json(code, F) {
	var names = name.split(",");
	var codes = code.split(",");
	var list = [];
	for(var i = 0; i < names.length; i++) {
		var json = {};
		json["name"] = names[i];
		json["code"] = codes[i];
		list[i] = json;
	}
	return list;
}
var titleLenght = function(name) {
	if(name.length > 0) {
		var nameTxt = name.substring(0, 25) + "..."
	}
	return nameTxt;
}

function txt() {
	var groom = "";
	for(var i = 0, tj; tj = res.out_json.recommendList[i++];) {
		groom += '<li class="one_groom"><div class="flex" style="width: 2.1rem;"><div class="groom"><img src="' + tj.imagePath + '" alt="" /></div><div class="groom_right"><h3 class="txt" style="margin-bottom: 0.13rem;">' +
			txtLenght(tj.name) + '</h3><span class="money" style="display: block;">¥' + tj.changePoints + '积分</span><span class="num">月销' + tj.saleNumber + '笔·' + tj.goodRate + '%好评</span></div></div></li>'
	}
	$(".scrollX").empty().append(groom);
}
/**
 * 返回json數據
 * @param {Object} json
 */
function isJson(json) {
	if(typeof(json) == 'object') {
		return json;
	} else {
		return eval("(" + json + ")");
	}
}

function localHref(arrowd) {
	var qs = (arrowd.length > 0 ? arrowd.substring(1) : ""),
		//保存数据的对象
		args = {},
		//取得每一项
		items = qs.length ? qs.split("&") : [],
		item = null,
		name = null,
		value = null,
		//在 for 循环中使用
		i = 0,
		len = items.length;
	//逐个将每一项添加到 args 对象中
	for(i = 0; i < len; i++) {
		item = items[i].split("=");
		name = decodeURIComponent(item[0]);
		value = decodeURIComponent(item[1]);
		if(name.length) {
			args[name] = value;
		}
	}
	return args
}
/**
 * 填充from表單內容
 * @param {Object} el
 * @param {Object} data
 */
function setFromValues(el, data) {
	for(var p in data) {
		el.find(":input[name='" + p + "']").val(data[p]);
	}
}

/**
 * 比較日期大小
 * @param {Object} date1
 * @param {Object} date2
 */
function compariDate(date1, date2) {
	return((new Date(date1.replace(/-/g, "\/"))) > (new Date(date2.replace(/-/g, "\/"))));
}