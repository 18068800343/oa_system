(function(window){
	$.ajax({
		type:"post",
		url:getContextPath()+"/login/getUser",//用户权限数组
		
		data:{
		},
		success:function(json){
			if(json!=null &&json!=""){
			var arr;
			var arr2 =[];
			if(json.uPermissions!=null&&json.uPermissions!=""){
				arr = json.uPermissions.split(',');
			}
			$.ajax({
				type:"post",
				url:getContextPath()+"/permissions/getAllPermissions",
				data:{},
				success:function(json2){
					
					for(var a=0;a<json2.list.length;a++){
						arr2.push(json2.list[a].coding)
					}
					if(arr!=null&&arr!=""){
						for(var i=0;i<arr.length;i++){
							userbm=arr[i];
							for(var j=0;j<arr2.length;j++){
								var qbbm=arr2[j]
								if(qbbm.indexOf(userbm)>=0){
									var c=$.inArray(userbm,arr2);
									arr2.splice($.inArray(userbm,arr2),1);
								}
								
							}
						}
						
					}
						//要删除的集合
					//console.log(arr2)	
						for(var j=0;j<arr2.length;j++){
									var arr4 = arr2[j].replace("+","");
									$("."+arr4+"").hide();
									$("."+arr4+"").closest("li").remove();//通过编码 点 remove
									
						}
					}
			    });
			/*	for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					$("."+arr2+"").show();
				}*/
			}else{
				
			}
		}
	});

	

	
	
})(window);


