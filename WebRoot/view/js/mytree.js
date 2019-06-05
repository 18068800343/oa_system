;(function($){
	var myTree = function(){
		var bodyHeight = window.screen.height;
		var initData =function(){
			$("#first").tree({
				method:"get",
				url:"./index.json",
				loadFilter:function(data){
					console.log(data)
					var newData = [];
					for(var i=0;i<data.length;i++){
						console.log(data[i].name)
						if(data[i].name ==  1){
//							显示
							newData.push(data[i])
							return newData
						}
					}
					return data;
				},
			        onClick:function(node){
			        	console.log(node)
					addTap(node.id,node.text,node.url)
				}
			})
			
			
		}
		function convert (row) {
			console.log(row)
		}
  	  var addTap = function(id,name,url){
  		    console.log(id);
			console.log(name);
			console.log(url);
/*			if($("#home-content").tabs('exists',name)){
				$('#home-content').tabs('select', name);
				console.log("#home-content")
				
			}else if(url){
				var str = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
				$('.home-content').tabs('add',{
					title:name,
					content:str,
					closable:true
				});
			}*/
			console.log($("#homecontent").html())
		}
		return{
			init:function(){
				//初始化tree
				initData();
			}
		}
	}();
	myTree.init();
})(jQuery);
