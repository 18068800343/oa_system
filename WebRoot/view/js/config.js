var configFun = function(){
	var t = this;
};
configFun.prototype = {
	data:{
		tree:[],
		treeStorage:''//存储的父级树节点
	},
	show:function(reg){
		var t = this;
		if(t.isArray(reg)){
			for(var i=0; i<reg.length; i++){
				reg[i].addClass('show');
				if(reg[i].hasClass('hide')){
					reg[i].removeClass('hide');
				};
			};
		}else{
			reg.addClass('show');
			if(reg.hasClass('hide')){
				reg.removeClass('hide');
			};
		};
	},
	hide:function(reg){
		var t = this;
		if(t.isArray(reg)){
			for(var i=0; i<reg.length; i++){
				reg[i].addClass('hide');
				if(reg[i].hasClass('show')){
					reg[i].removeClass('show');
				};
			};
		}else{
			reg.addClass('hide');
			if(reg.hasClass('show')){
				reg.removeClass('show');
			};
		}
		
	},
	isArray:function(value){
		if (typeof Array.isArray === "function") {
			return Array.isArray(value);
		}else{
			return Object.prototype.toString.call(value) === "[object Array]";
		}
	},
    tree:function(res){
    	var t = this;
    	var type = 0;
    	var data = res.data;
    	var wrapper = $(res.wrapper);
    	var one = [];
    	var next = [];
    	if(typeof(res.type) == 'undefined'){
    		type = 0;
    	}else{
    		type = res.type;
    	};
    	if(typeof(res.check) != 'undefined' && res.check.length > 0){
    		for(var i=0; i<data.length; i++){
    			var id = data[i].id;
    			data[i]['check'] = false;
    			for(var k=0; k<res.check.length; k++){
    				if(id == res.check[k]){
    					data[i]['check'] = true;
    					break;
    				};
    			};
    		};
    	};
    	for(var i=0; i<data.length; i++){
    		if(data[i].pid == 0){
				var fatherHtml = $('<div class="f-treeListWrapper"><div class="f-treeList-line"></div></div>');
				var listHtml = '';
				if(res.type == 0){
					listHtml = $('<div class="f-treeList f-treeListOne">'+
							'<div class="f-treeList-top">'+
							'<div class="f-treeList-old"><span class="f-iconJia"></span></div>'+
							'<div class="f-treeList-title">'+
							'<div class="f-treeList-titleImg"></div>'+
							'<p class="f-treeList-titleP">'+ data[i].title +'</p>'+
							'</div></div></div>');
					};
				if(res.type == 1){
					var radioIconHtml = '<span class="f-iconRadio"></span>';
					if(data[i].check){
						radioIconHtml = '<span class="f-iconRadioTrue"></span>';
					}
					listHtml = $('<div class="f-treeList f-treeListOne">'+
							'<div class="f-treeList-top">'+
							'<div class="f-treeList-old"><span class="f-iconJia"></span></div>'+
							'<div class="f-treeList-title">'+
							'<div class="f-treeList-radio">'+
							radioIconHtml+
							'<input value="'+ data[i].id +'"/>'+
							'</div>'+
							'<div class="f-treeList-titleImg"></div>'+
							'<p class="f-treeList-titleP">'+ data[i].title +'</p>'+
							'</div></div></div>');
				};
				fatherHtml.append(listHtml);
    			wrapper.append(fatherHtml);
    			data[i]['list'] = listHtml;
    			one.push(data[i]);
    		}else{
    			next.push(data[i]);
    		};
    	};
    	for(var i=0; i<one.length; i++){
    		if(i == one.length-1){
    			one[i].list.siblings('.f-treeList-line').eq(0).remove();
    		};
    		(function(k){
    			var selfList = one[k].list;
    			var old = selfList.find('.f-treeList-old').eq(0);
    			old[0].onclick = function(){
	    			var iconDiv = old.children('span').eq(0);
	    			var flagClass = iconDiv.attr('class');
	    			var listWrapper = old.parents('.f-treeList-top').eq(0).siblings('.f-treeListWrapper').eq(0);
	    			old.addClass('f-on');
	    			if(flagClass == 'f-iconJia'){
	    				t.show([listWrapper]);
	    				iconDiv.removeClass(flagClass);
	    				iconDiv.addClass('f-iconJian');
	    			};
	    			if(flagClass == 'f-iconJian'){
	    				t.hide([listWrapper]);
	    				iconDiv.removeClass(flagClass);
	    				iconDiv.addClass('f-iconJia');
	    			};
	    		};
    		})(i);
    		t.treeFor({
    			type:type,
    			data:next,
    			dataHover:one[i]
    		});
    	};
    },
    treeFor:function(res){
    	var t = this;
    	var data = res.data;
    	var dataHover = res.dataHover;
    	var fatherHtml = $('<div class="f-treeListWrapper hide"><div class="f-treeList-lineShu"></div></div>');
    	var listHtml = '';
    	var self = [];//子集
    	var next = [];
    	for(var i=0; i<data.length; i++){
    		if(data[i].pid == dataHover.id){
    			if(res.type == 0){
					listHtml = $('<div class="f-treeList">'+
							'<div class="f-treeList-top">'+
							'<div class="f-treeList-old"><span class="f-iconJia"></span></div>'+
							'<div class="f-treeList-title">'+
							'<div class="f-treeList-titleImg"></div>'+
							'<p class="f-treeList-titleP">'+ data[i].title +'</p>'+
							'</div></div></div>');
				};
				if(res.type == 1){
					var radioIconHtml = '<span class="f-iconRadio"></span>';
					if(data[i].check){
						radioIconHtml = '<span class="f-iconRadioTrue"></span>';
					}
					listHtml = $('<div class="f-treeList">'+
							'<div class="f-treeList-top">'+
							'<div class="f-treeList-old"><span class="f-iconJia"></span></div>'+
							'<div class="f-treeList-title">'+
							'<div class="f-treeList-radio">'+
							radioIconHtml+
							'<input value="'+ data[i].id +'"/>'+
							'</div>'+
							'<div class="f-treeList-titleImg"></div>'+
							'<p class="f-treeList-titleP">'+ data[i].title +'</p>'+
							'</div></div></div>');
				};
				fatherHtml.append(listHtml);
				dataHover.list.append(fatherHtml);
				data[i]['list'] = listHtml;
				self.push(data[i]);
    		}else{
    			next.push(data[i]);
    		}
    	};
    	//判断是否是最底级,不是则继续遍历
    	if(self.length > 0){
    		//遍历所有的子集
    		for(var i=0; i<self.length; i++){
    			t.treeFor({
	    			type:res.type,
	    			data:next,
	    			dataHover:self[i]
	    		});
    		};
    	};
    	if(self.length == 0 && res.dataHover.pid != 0){
    		var selfDom = res.dataHover.list;
    		var selfWrapper = selfDom.parent('.f-treeListWrapper');//底级所在的容器
    		var selfList = selfWrapper.parent('.f-treeList');
    		var fatherOld = selfList.children('.f-treeList-top').eq(0).children('.f-treeList-old').eq(0);
    		var selfNextDom = selfDom.next();
    		var line = $('<div class="f-treeList-lineEnd"></div>');
    		var selfDom_top = selfDom.find('.f-treeList-top').eq(0);
    		var selfDom_old = selfDom.find('.f-treeList-old').eq(0);
    		var selfDom_img = selfDom.find('.f-treeList-titleImg').eq(0).children('span').eq(0);
    		if(typeof(selfNextDom[0]) == 'undefined'){
    			var fatherLine = selfDom.siblings('.f-treeList-lineShu');
    			fatherLine.removeClass(fatherLine.attr('class'));
    			fatherLine.addClass('f-treeList-lineShuEnd');
    		};
    		selfDom_top.prepend(line);
    		selfDom_old.remove();
    		selfDom_img.removeClass(selfDom_img.attr('class'));
    		selfDom_img.addClass('f-iconEnd');
    		//绑定点击事件
    		if(fatherOld.attr('class').indexOf('f-on') == -1){
		  		fatherOld[0].onclick = function(){
    				var iconDiv = fatherOld.children('span').eq(0);
	    			var flagClass = iconDiv.attr('class');
	    			fatherOld.addClass('f-on');
	    			if(flagClass == 'f-iconJia'){
	    				t.show([selfWrapper]);
	    				iconDiv.removeClass(flagClass);
	    				iconDiv.addClass('f-iconJian');
	    			};
	    			if(flagClass == 'f-iconJian'){
	    				t.hide([selfWrapper]);
	    				iconDiv.removeClass(flagClass);
	    				iconDiv.addClass('f-iconJia');
	    			};
    			};
    		};
    		//绑定radio点击事件
    		if(res.type == 1){
    			var radio = selfDom.find('.f-treeList-radio').eq(0);
    			var radio_icon = radio.children('span').eq(0);
    			var radioFather = selfList.children('.f-treeList-top').eq(0).find('.f-treeList-radio').eq(0);
    			var radioFather_icon = radioFather.children('span').eq(0);
    			radio[0].onclick = function(){
    				var radio_father = radio.parents('.f-treeListWrapper');
      				var radio_class = radio_icon.attr('class');
					radio_icon.removeClass(radio_icon.attr('class'));
    				if(radio_class == 'f-iconRadio'){
    					radio_icon.addClass('f-iconRadioTrue');
    					for(var i=0; i<radio_father.length-1; i++){
	    					var radio_father_radio = radio_father.eq(i).siblings('.f-treeList-top').eq(0).find('.f-treeList-radio').eq(0);
	    					var radio_father_radioIcon = radio_father_radio.children('span').eq(0);
	    					radio_father_radioIcon.removeClass(radio_father_radioIcon.attr('class'));
	    					radio_father_radioIcon.addClass('f-iconRadioTrue');
	    				}
    				}else{
    					radio_icon.addClass('f-iconRadio');
    					for(var i=0; i<radio_father.length-1; i++){
	    					var radio_father_radio = radio_father.eq(i).siblings('.f-treeList-top').eq(0).find('.f-treeList-radio').eq(0);
	    					var radio_father_radioIcon = radio_father_radio.children('span').eq(0);
	    					var radio_fatherList = radio_father.eq(i).children('.f-treeList');
	    					var flagNum = 0;
	    					//判断子级是否被选中
	    					for(var k=0; k<radio_fatherList.length; k++){
	    						var radio_fatherList_radio = radio_fatherList.eq(k).children('.f-treeList-top').eq(0).find('.f-treeList-radio').eq(0);
	    						var radio_fatherList_radioIcon = radio_fatherList_radio.children('span').eq(0);
	    						if(radio_fatherList_radioIcon.hasClass('f-iconRadio')){
	    							flagNum++;
	    						};
	    					};
	    					if(flagNum == radio_fatherList.length){
	    						radio_father_radioIcon.removeClass(radio_father_radioIcon.attr('class'));
	    						radio_father_radioIcon.addClass('f-iconRadio');
	    					};
	    				};
    				};
    			};
    			radioFather[0].onclick = function(){
    				var radioFather_class = radioFather_icon.attr('class');
    				var radio_next = selfWrapper.find('.f-treeList-radio');
    				radioFather_icon.removeClass(radioFather_icon.attr('class'));
    				if(radioFather_class == 'f-iconRadio'){
    					radioFather_icon.addClass('f-iconRadioTrue');
    					for(var i=0; i<radio_next.length; i++){
    						var redio_nextIcon = radio_next.eq(i).children('span').eq(0);
    						redio_nextIcon.removeClass(redio_nextIcon.attr('class'));
    						redio_nextIcon.addClass('f-iconRadioTrue');
    					}
    				}else{
    					radioFather_icon.addClass('f-iconRadio');
    					for(var i=0; i<radio_next.length; i++){
    						var redio_nextIcon = radio_next.eq(i).children('span').eq(0);
    						redio_nextIcon.removeClass(redio_nextIcon.attr('class'));
    						redio_nextIcon.addClass('f-iconRadio');
    					}
    				}
    			}
    		}
    	};
    },
    treeJson:function(res){
    	var wrapper = $(res.wrapper);
    	var radio = wrapper.find('.f-treeList-radio');
    	var radioArr = [];
    	for(var i=0; i<radio.length; i++){
    		var radioIcon = radio.eq(i).children('span').eq(0);
    		var radioId = radio.eq(i).children('input').val();
    		if(radioIcon.hasClass('f-iconRadioTrue')){
    			radioArr.push(radioId);
    		};
    	};
    	res.success(radioArr);
    }
};
var config = new configFun();

