(function(window){
	$.ajax({
		type:"post",
		url:getContextPath()+"/login/getUser",
		data:{
		},
		success:function(json){
			if(json!=null &&json!=""){
				var arr = json.uPermissions.split(',');
				console.log(arr);
				for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					$("."+arr2+"").show();
				}
			}else{
				
			}
		}
	});
	//1	个人任务菜单栏	Pa+
	$(".Pa").hide();
	
	//2	待办事项菜单栏	Paa+
	$(".Paa").hide();
	
	//3	待办事项业务办理	Paaa+
	$(".Paaa").hide();
	
	//4	已办事项菜单栏	Pab+
	$(".Pab").hide();
	
	//5	已办事项查看办理业务	Paba+
	$(".Paba").hide();
	
	//6	已办事项删除	Pabb+
	$(".Pabb").hide();
	
	//7	已办事项撤回	Pabc+
	$(".Pabc").hide();
	
	//8	业务催办菜单栏	Pac+
	$(".Pac").hide();
	
	//9	业务催办通知催办	Paca+
	$(".Paca").hide();
	
	//10	业务办理通知菜单栏	Pad+
	$(".Pad").hide();
	
	//11	行政事务菜单栏	Pb+
	$(".Pb").hide();
	
	//12	通知公告菜单栏	Pba+
	$(".Pba").hide();
	
	//13	公司通知公告新建	Pbaa+
	$(".Pbaa").hide();
	
	//14	公司通知公告查看详细信息	Pbab+
	$(".Pbab").hide();
	
	//15	公司通知公告修改	Pbac+
	$(".Pbac").hide();
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/login/getUser",
		data:{
		},
		success:function(json){
			if(json!=null &&json!=""){
				var arr = json.uPermissions.split(',');
				
				for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					//console.log(arr2);
					if(arr2=='Pbab'){
						$(".Pbab").show();
						break
					}else{
						$(".Pbab").hide();
					}
				}
				for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					//console.log(arr2);
					if(arr2=='Pbac'){
						$(".Pbac").show();
						break
					}else{
						$(".Pbac").hide();
					}
				}
			}else{
				
			}
		}
	});
	
	//16	部门通知公告新建	Pbad+
	$(".Pbad").hide();
	
	//17	部门通知公告查看详细信息	Pbae+
	$(".Pbae").hide();
	
	//18	部门通知公告修改	Pbaf+
	$(".Pbaf").hide();
	
	$.ajax({
		type:"post",
		url:getContextPath()+"/login/getUser",
		data:{
		},
		success:function(json){
			if(json!=null &&json!=""){
				var arr = json.uPermissions.split(',');
				
				for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					//console.log(arr2);
					if(arr2=='Pbae'){
						$(".Pbae").show();
						break
					}else{
						$(".Pbae").hide();
					}
				}
				for(var i=0;i<arr.length;i++){
					var arr2 = arr[i].replace("+","");
					//console.log(arr2);
					if(arr2=='Pbac'){
						$(".Pbaf").show();
						break
					}else{
						$(".Pbaf").hide();
					}
					
				}
			}else{
				
			}
		}
	});
	
	//19	项目印章管理菜单栏	Pbb+
	$(".Pbb").hide();
	
	//20	刻制申请填报	Pbba+
	$(".Pbba").hide();
	//21	刻制申请查看详细信息	Pbbb+
	$(".Pbbb").hide();
	//22	刻制申请修改	Pbbc+
	$(".Pbbc").hide();
	//23	使用管理填报	Pbbd+
	$(".Pbbd").hide();
	//24	使用管理查看详细信息	Pbbe+
	$(".Pbbe").hide();
	//25	使用管理修改	Pbbf+
	$("Pbbf").hide();
	//26	成果文件用印管理菜单栏	Pbc+
	$(".Pbc").hide();
	//27	成果文件用印填报	Pbca+
	$(".Pbca").hide();
	//28	成果文件用印查看详细信息	Pbcb+
	$(".Pbcb").hide();
	//29	成果文件用印修改	Pbcc+
	$(".Pbcc").hide();
	//30	培训管理菜单栏	Pbd+
	$(".Pbd").hide();
	//31	外出培训申请菜单栏	Pbda+
	$(".Pbda").hide();
	//32	外出培训申请填报	Pbdaa+
	$(".Pbdaa").hide();
	//33	外出培训申请查看详细信息	Pbdab+
	$(".Pbdab").hide();
	//34	外出培训申请修改	Pbdac+
	$(".Pbdac").hide();
	//35	外部培训申请菜单栏	Pbdb+
	$(".Pbdb").hide();
	//36	外部培训申请填报	Pbdba+
	$(".Pbdba").hide();
	//37	外部培训申请查看详细信息	Pbdbb+
	$(".Pbdbb").hide();
	//38	外部培训申请修改	Pbdbc+
	$(".Pbdbc").hide();
	//39	内部培训申请菜单栏	Pbdc+
	$(".Pbdc").hide();
	//40	内部培训申请填报	Pbdca+
	$(".Pbdca").hide();
	//41	内部培训申请查看详细信息	Pbdcb+
	$(".Pbdcb").hide();
	//42	内部培训申请修改	Pbdcc+
	$(".Pbdcc").hide();
	//43	培训资料管理菜单栏	Pbdd+
	$("Pbdd").hide();
	//44	培训资料管理填报	Pbdda+
	$(".Pbdda").hide();
	//45	培训资料管理查看详细信息	Pbddb+
	$(".Pbddb").hide();
	//46	培训资料管理修改	Pbddc+
	$(".Pbddc").hide();
	//47	财务管理菜单栏	Pc+
	$(".Pc").hide();
	//48	财务收款菜单栏	Pca+
	$(".Pca").hide();
	//49	财务收款新建	Pcaa+
	$(".Pcaa").hide();
	//50	财务收款查看详细信息	Pcab+
	$(".Pcab").hide();
	//51	项目款认领菜单栏	Pcb+
	$(".Pcb").hide();
	///52	项目款未认领查看详细信息	Pcba+
	$(".Pcba").hide();
	//53	项目款已认领查看详细信息	Pcbb+
	$(".Pcbb").hide();
	//54	财务还款菜单栏	Pcc+
	$(".Pcc").hide();
	//55	财务还款新建	Pcca+
	$(".Pcca").hide();
	//56	财务还款查看详细信息	Pccb+
	$(".Pccb").hide();
	//57	开票申请菜单栏	Pcd+
	$(".Pcd").hide();
	//58	开票申请新建	Pcda+
	$(".Pcda").hide();
	//59	开票申请查看详细信息	Pcdb+
	$(".Pcdb").hide();
	//60	开票申请补录发票编号	Pcdc+
	$(".Pcdc").hide();
	//61	经营管理菜单栏	Pd+
	$(".Pd").hide();
	//62	项目跟踪菜单栏	Pda+
	$(".Pda").hide();
	//63	项目跟踪单新建	Pdaa+
	$(".Pdaa").hide();
	///64	项目跟踪单查看详细信息	Pdab+
	$(".Pdab").hide();
	//65	项目跟踪单修改	Pdac+
	$(".Pdac").hide();
	//66	项目跟踪日志新建	Pdad+
	$(".Pdad").hide();
	//67	项目跟踪日志查看详细信息	Pdae+
	$(".Pdae").hide();
	//68	项目跟踪日志修改	Pdaf+
	$(".Pdaf").hide();
	//69	项目投标菜单栏	Pdb+
	$(".Pdb").hide();
	//70	投标审批单菜单栏	Pdba+
	$(".Pdba").hide();
	//71	投标审批单新建	Pdbaa+
	$(".Pdbaa").hide();
	//72	投标审批单查看详细信息	Pdbab+
	$(".Pdbab").hide();
	//73	投标审批单修改	Pdbac+
	$(".Pdbac").hide();
	//74	投标审批单删除	Pdbad+
	$(".Pdbad").hide();
	//75	项目风险评估菜单栏	Pdbb+
	$(".Pdbb").hide();
	//76	项目风险评估新建	Pdbba+
	$(".Pdbba").hide();
	//77	项目风险评估查看详细信息	Pdbbb+
	$(".Pdbbb").hide();
	//78	项目风险评估修改	Pdbbc+
	$(".Pdbbc").hide();
	//79	开标记录菜单栏	Pdbc+
	$(".Pdbc").hide();
	//80	开标记录新建	Pdbca+
	$(".Pdbca").hide();
	//81	开标记录查看详细信息	Pdbcb+
	$(".Pdbcb").hide();
	//82	开标记录修改	Pdbcc+
	$(".Pdbcc").hide();
	//83	中标项目移交菜单栏	Pdbd+
	$(".Pdbd").hide();
	//84	中标项目移交新建	Pdbda+
	$(".Pdbda").hide();
	//85	中标项目移交查看详细信息	Pdbdb+
	$(".Pdbdb").hide();
	//86	中标项目移交修改	Pdbdc+
	$(".Pdbdc").hide();
	//87	投标项目列表菜单栏	Pdbe+
	$(".Pdbe").hide();
	//88	投标项目列表新建	Pdbea+
	$(".Pdbea").hide();
	//89	投标项目列表导出excel文件	Pdbeb+
	$("Pdbeb").hide();
	//90	投标项目列表查看详细信息	Pdbec+
	$("Pdbec").hide();
	//91	投标项目列表修改	Pdbed+
	$(".Pdbed").hide();
	//92	投标项目列表删除	Pdbee+
	$(".Pdbee").hide();
	//93	经营目标管理菜单栏	Pdc+
	$(".Pdc").hide();
	//94	经营目标管理新建	Pdca+
	$(".Pdca").hide();
	//95	经营目标管理导入开票记录	Pdcb+
	$(".Pdcb").hide();
	//96	经营目标管理查看详细信息	Pdcc+
	$(".Pdcc").hide();
	//97	经营目标管理修改	Pdcd+
	$(".Pdcd").hide();
	//98	经营目标管理拆解公司指标	Pdce+
	$(".Pdce").hide();
	//99	生产管理菜单栏	Pe+
	$(".Pe").hide();
	//100	任务单管理菜单栏	Pea+
	$(".Pea").hide();
	//101	任务单管理填报	Peaa+
	$(".Peaa").hide();
	//102	任务单管理查看详细信息	Peab+
	$("Peab").hide();
	//103	任务单管理修改	Peac+
	$(".Peac").hide();
	//104	任务单管理项目中止	Pead+
	$(".Pead").hide();
	//105	任务单管理项目重启	Peae+
	$(".Peae").hide();
	//106	预算管理菜单栏	Peb+
	$(".Peb").hide();
	//107	预算管理新建	Peba+
	$(".Peba").hide();
	//108	预算管理查看详细信息	Pebb+
	$(".Pebb").hide();
	//109	预算管理修改	Pebc+
	$(".Pebc").hide();
	//110	合同管理菜单栏	Pec+
	$(".Pec").hide();
	//111	承接合同管理菜单栏	Peca+
	$(".Peca").hide();
	//112	承接合同管理填报	Pecaa+
	$(".Pecaa").hide();
	//113	承接合同管理查看详细信息	Pecab+
	$(".Pecab").hide();
	//114	承接合同管理合同变更	Pecac+
	$(".Pecac").hide();
	//115	承接合同管理合同取消	Pecad+
	$(".Pecad").hide();
	//116	承接合同管理查看取消原因	Pecae+
	$(".Pecae").hide();
	//117	承接合同管理合同重启	Pecaf+
	$(".Pecaf").hide();
	//118	分包合同管理菜单栏	Pecb+
	$(".Pecb").hide();
	//119	分包合同管理填报	Pecba+
	$(".Pecba").hide();
	//120	分包合同管理查看详细信息	Pecbb+
	$(".Pecbb").hide();
	//121	分包合同管理合同变更	Pecbc+
	$(".Pecbc").hide();
	//122	分包合同管理合同取消	Pecbd+
	$(".Pecbd").hide();
	//123	分包合同管理查看合同取消原因	Pecbe+
	$(".Pecbe").hide();
	//124	分包合同管理合同重启	Pecbf+
	$(".Pecbf").hide();
	//125	采购合同管理菜单栏	Pecc+
	$(".Pecc").hide();
	//126	采购合同管理填报	Pecca+
	$(".Pecca").hide();
	//127	采购合同管理查看详细信息	Peccb+
	$(".Peccb").hide();
	//128	采购合同管理合同变更	Peccc+
	$(".Peccc").hide();
	//129	采购合同管理合同取消	Peccd+
	$(".Peccd").hide();
	//130	采购合同管理查看合同取消原因	Pecce+
	$(".Pecce").hide();
	//131	采购合同管理合同重启	Peccf+
	$(".Peccf").hide();
	//132	借款合同管理菜单栏	Pecd+
	$(".Pecd").hide();
	//133	借款合同管理填报	Pecda+
	$(".Pecda").hide();
	//134	借款合同管理查看详细信息	Pecdb+
	$(".Pecdb").hide();
	//135	借款合同管理合同变更	Pecdc+
	$(".Pecdc").hide();
	//136	借款合同管理合同取消	Pecdd+
	$(".Pecdd").hide();
	//137	借款合同管理查看合同取消原因	Pecde+
	$(".Pecde").hide();
	//138	借款合同管理合同重启	Pecdf+
	$(".Pecdf").hide();
	//139	其他合同管理菜单栏	Pece+
	$(".Pece").hide();
	//140	其他合同管理填报	Pecea+
	$(".Pecea").hide();
	//141	其他合同管理查看详细信息	Peceb+
	$(".Peceb").hide();
	//142	其他合同管理合同变更	Pecec+
	$(".Pecec").hide();
	//143	其他合同管理合同取消	Peced+
	$(".Peced").hide();
	//144	其他合同管理查看合同取消原因	Pecee+
	$(".Pecee").hide();
	//145	其他合同管理合同重启	Pecef+
	$(".Pecef").hide();
	//146	分包合同付款菜单栏	Pecf+
	$(".Pecf").hide();
	//147	分包合同付款填报	Pecfa+
	$(".Pecfa").hide();
	//148	分包合同付款查看详细信息	Pecfb+
	$(".Pecfb").hide();
	//149	分包合同付款合同变更	Pecfc+
	$(".Pecfc").hide();
	//150	合同履约菜单栏	Pecg+
	$(".Pecg").hide();
	//151	合同履约承接合同菜单栏	Pecga+
	$(".Pecga").hide();
	//152	合同履约承接合同合同交工履约申请填报	Pecgaa+
	$(".Pecgaa").hide();
	//153	合同履约承接合同合同交工履约申请查看详细信息	Pecgab+
	$(".Pecgab").hide();
	//154	合同履约承接合同合同竣工履约申请填报	Pecgac+
	$(".Pecgac").hide();
	//155	合同履约承接合同合同竣工履约申请查看详细信息	Pecgad+
	$(".Pecgad").hide();
	//156	合同履约材料分包合同菜单栏	Pecgb+
	$(".Pecgb").hide();
	//157	合同履约材料分包合同履约评价填报	Pecgba+
	$(".Pecgba").hide();
	//158	合同履约材料分包合同履约评价查看详细信息	Pecgbb+
	$(".Pecgbb").hide();
	//159	合同履约材料分包合同履约评价修改	Pecgbc+
	$(".Pecgbc").hide();
	//160	合同履约材料分包合同采购结算申请填报	Pecgbd+
	$(".Pecgbd").hide();
	//161	合同履约材料分包合同采购结算申请查看详细信息	Pecgbe+
	$(".Pecgbe").hide();
	//162	合同履约材料分包合同采购结算申请修改	Pecgbf+
	$(".Pecgbf").hide();
	//163	合同履约材料分包合同采购合同履约填报	Pecgbg+
	$(".Pecgbg").hide();
	//164	合同履约材料分包合同采购合同履约导出打印	Pecgbh+
	$("Pecgbh").hide();
	//165	合同履约材料分包合同采购合同履约查看详细信息	Pecgbi+
	$(".Pecgbi").hide();
	//166	合同履约材料分包合同采购合同履约修改	Pecgbj+
	$(".Pecgbj").hide();
	//167	合同履约劳务分包合同菜单栏	Pecgc+
	$(".Pecgc").hide();
	//168	合同履约劳务分包合同履约评价填报	Pecgca+
	$(".Pecgca").hide();
	//169	合同履约劳务分包合同履约评价查看详细信息	Pecgcb+
	$(".Pecgcb").hide();
	//170	合同履约劳务分包合同分包结算申请填报	Pecgcc+
	$(".Pecgcc").hide();
	//171	合同履约劳务分包合同分包结算申请查看详细信息	Pecgcd+
	$(".Pecgcd").hide();
	//172	合同履约劳务分包合同分包合同履约填报	Pecgce+
	$(".Pecgce").hide();
	//173	合同履约劳务分包合同分包合同履约导出打印	Pecgcf+
	$(".Pecgcf").hide();
	//174	合同履约劳务分包合同分包合同履约查看详细信息	Pecgcg+
	$(".Pecgcg").hide();
	//175	材料采购管理菜单栏	Ped+
	$(".Ped").hide();
	//176	材料采购申请菜单栏	Peda+
	$(".Peda").hide();
	//177	材料采购申请填报	Pedaa+
	$(".Pedaa").hide();
	//178	材料采购申请查看详细信息	Pedab+
	$(".Pedab").hide();
	//179	公司材料管理菜单栏	Pedb+
	$(".Pedb").hide();
	//180	公司材料管理材料入库菜单栏	Pedba+
	$(".Pedba").hide();
	//181	公司材料管理材料入库填报	Pedbaa+
	$(".Pedbaa").hide();
	//182	公司材料管理材料入库查看详细信息	Pedbab+
	$(".Pedbab").hide();
	//183	公司材料管理材料出库菜单栏	Pedbb+
	$(".Pedbb").hide();
	//184	公司材料管理材料出库填报	Pedbba+
	$(".Pedbba").hide();
	//185	公司材料管理材料出库查看详细信息	Pedbbb+
	$(".Pedbbb").hide();
	//186	公司材料管理结余管理菜单栏	Pedbc+
	$(".Pedbc").hide();
	//187	公司材料管理结余管理查看详细信息	Pedbca+
	$(".Pedbca").hide();
	//188	公司材料管理结余管理结余转出	Pedbcb+
	$(".Pedbcb").hide();
	//189	公司材料管理废旧品处理菜单栏	Pedbd+
	$(".Pedbd").hide();
	///190	公司材料管理废旧品处理填报	Pedbda+
	$(".Pedbda").hide();
	//191	公司材料管理废旧品处理查看详细信息	Pedbdb+
	$(".Pedbdb").hide();
	//192	公司材料管理统计花销费用菜单栏	Pedbe+
	$(".Pedbe").hide();
	//193	公司材料管理退货菜单栏	Pedbf+
	$(".Pedbf").hide();
	//194	公司材料管理退货填报	Pedbfa+
	$(".Pedbfa").hide();
	///195	公司材料管理退货查看详细信息	Pedbfb+
	$(".Pedbfb").hide();
	//196	项目材料管理菜单栏	Pedc+
	$(".Pedc").hide();
	//197	项目材料管理材料入库菜单栏	Pedca+
	$(".Pedca").hide();
	//198	项目材料管理材料入库收货确认	Pedcaa+
	$(".Pedcaa").hide();
	//199	项目材料管理材料入库查看详细信息	Pedcab+
	$(".Pedcab").hide();
	//200	项目材料管理材料出库菜单栏	Pedcb+
	$(".Pedcb").hide();
	//201	项目材料管理材料出库填报	Pedcba+
	$(".Pedcba").hide();
	//202	项目材料管理材料出库查看详细信息	Pedcbb+
	$(".Pedcbb").hide();
	//203	项目材料管理结余管理菜单栏	Pedcc+
	$(".Pedcc").hide();
	//204	项目材料管理结余管理结余确认	Pedcca+
	$(".Pedcca").hide();
	//205	项目材料管理结余管理结余利用	Pedccb+
	$(".Pedccb").hide();
	//206	项目材料管理废旧品处理菜单栏	Pedcd+
	$(".Pedcd").hide();
	//207	项目材料管理废旧品处理填报	Pedcda+
	$(".Pedcda").hide();
	//208	项目材料管理废旧品处理查看详细信息	Pedcdb+
	$(".Pedcdb").hide();
	//209	进度管理菜单栏	Pee+
	$(".Pee").hide();
	//210	进度管理填报	Peea+
	$(".Peea").hide();
	//211	进度管理查看详细信息	Peeb+
	$(".Peeb").hide();
	//212	项目成本预警菜单栏	Pef+
	$(".Pef").hide();
	//213	项目成本预警查看详细信息	Pefa+
	$(".Pefa").hide();
	//214	项目成本预警录入原因	Pefb+
	$(".Pefb").hide();
	//215	项目工时管理菜单栏	Peg+
	$(".Peg").hide();
	//216	项目工时管理填报	Pega+
	$(".Pega").hide();
	//217	项目工时管理删除	Pegb+
	$(".Pegb").hide();
	//218	项目工时管理查看详细信息	Pegc+
	$(".Pegc").hide();
	//219	项目工时管理修改 	Pegd+
	$(".Pegd").hide();
	//220	施工报表菜单栏	Peh+
	$(".Peh").hide();
	//221	项目施工日志菜单栏	Peha+
	$(".Peha").hide();
	//222	项目施工日志填报	Pehaa+
	$(".Pehaa").hide();
	//223	项目施工日志删除	Pehab+
	$(".Pehab").hide();
	//224	项目施工日志修改	Pehac+
	$(".Pehac").hide();
	//225	项目施工日志查看详细信息	Pehad+
	$(".Pehad").hide();
	//226	项目周报菜单栏	Pehb+
	$(".Pehb").hide();
	//227	项目周报填报	Pehba+
	$(".Pehba").hide();
	//228	项目周报删除	Pehbb+
	$(".Pehbb").hide();
	//229	项目周报查看详细信息	Pehbc+
	$(".Pehbc").hide();
	//230	项目周报修改	Pehbd+
	$(".Pehbd").hide();
	//231	项目月报菜单栏	Pehc+
	$(".Pehc").hide();
	//232	项目月报填报	Pehca+
	$(".Pehca").hide();
	//233	项目月报删除	Pehcb+
	$(".Pehcb").hide();
	//234	项目月报查看详细信息	Pehcc+
	$(".Pehcc").hide();
	//235	项目月报修改	Pehcd+
	$(".Pehcd").hide();
	//236	项目结算审计菜单栏	Pei+
	$(".Pei").hide();
	//237	项目结算审计填报	Peia+
	$(".Peia").hide();
	//238	项目结算审计查看详细信息	Peib+
	$(".Peib").hide();
	//239	检测二部菜单栏	Pf+
	$(".Pf").hide();
	//240	检测二部任务单管理菜单栏	Pfa+
	$(".Pfa").hide();
	//241	检测二部任务单管理导入新签合同	Pfaa+
	$(".Pfaa").hide();
	//242	检测二部任务单管理导入上月合同	Pfab+
	$(".Pfab").hide();
	//243	检测二部任务单管理查看详细信息	Pfac+
	$(".Pfac").hide();
	//244	检测二部任务单管理删除	Pfad+
	$(".Pfad").hide();
	//245	检测二部财务收款菜单栏	Pfb+
	$(".Pfb").hide();
	//246	检测二部财务收款导入收款项目	Pfba+
	$(".Pfba").hide();
	//247	检测二部财务收款查看详细信息	Pfbb+
	$(".Pfbb").hide();
	//248	检测二部项目款认领菜单栏	Pfc+
	$(".Pfc").hide();
	//249	检测二部项目款已认领查看详细信息	Pfca+
	$(".Pfca").hide();
	//250	检测二部项目款未认领查看详细信息	Pfcb+
	$(".Pfcb").hide();
	//251	薪酬管理菜单栏	Pg+
	$(".Pg").hide();
	//252	职务等级体系菜单栏	Pga+
	$(".Pga").hide();
	//253	项目规模及人员要求菜单栏	Pgb+
	$(".Pgb").hide();
	//254	员工薪酬结构菜单栏	Pgc+
	$(".Pgc").hide();
//	255	年度奖金菜单栏	Pgd+
	$(".Pgd").hide();
//	256	质量安全管理菜单栏	Ph+
	$(".Ph").hide();
	//257	项目安全管理菜单栏	Pha+
	$(".Pha").hide();
	//258	公司安全管理菜单栏	Phb+
	$(".Phb").hide();
	//259	科研管理菜单栏	Pi+
	$(".Pi").hide();
	//260	科研管理经营管理菜单栏	Pia+
	$(".Pia").hide();
	//261	科研管理过程管理菜单栏	Pib+
	$(".Pib").hide();
	//262	档案管理菜单栏	Pj+
	$(".Pj").hide();
	//263	档案交接菜单栏	Pja+
	$(".Pja").hide();
	//264	档案交接接收人签字	Pjaa+
	$(".Pjaa").hide();
	//265	档案交接查看详细信息	Pjab+
	$(".Pjab").hide();
	//266	经营文档资料菜单栏	Pjb+
	$(".Pjb").hide();
	//267	经营文档资料删除	Pjba+
	$(".Pjba").hide();
	//268	经营文档资料查看详细信息	Pjbb+
	$(".Pjbb").hide();
	//269	经营文档资料修改	Pjbc+
	$(".Pjbc").hide();
	//270	施工文档资料菜单栏	Pjc+
	$(".Pjc").hide();
	//271	施工文档资料删除	Pjca+
	$(".Pjca").hide();
	//272	施工文档资料查看详细信息	Pjcb+
	$(".Pjcb").hide();
	//273	施工文档资料修改	Pjcc+
	$(".Pjcc").hide();
	//274	检测评估资料菜单栏	Pjd+
	$(".Pjd").hide();
	//275	检测评估资料删除	Pjda+
	$(".Pjda").hide();
	//276	检测评估资料查看详细信息	Pjdb+
	$(".Pjdb").hide();
	//277	检测评估资料修改	Pjdc+
	$(".Pjdc").hide();
	//278	设计文件资料菜单栏	Pje+
	$(".Pje").hide();
	//279	设计文件资料删除	Pjea+
	$(".Pjea").hide();
	//280	设计文件资料查看详细信息	Pjeb+
	$(".Pjeb").hide();
	//281	设计文件资料修改	Pjec+
	$(".Pjec").hide();
	//282	维修加固设计资料菜单栏	Pjf+
	$(".Pjf").hide();
	//283	维修加固设计资料删除	Pjfa+
	$(".Pjfa").hide();
	//284	维修加固设计资料修改	Pjfb+
	$(".Pjfb").hide();
	//285	维修加固设计资料查看详细信息	Pjfc+
	$(".Pjfc").hide();
	//286	科技文档资料菜单栏	Pjg+
	$(".Pjg").hide();
	//287	科技文档资料删除	Pjga+
	$(".Pjga").hide();
	//288	科技文档资料查看详细信息	Pjgb+
	$(".Pjgb").hide();
	//289	科技文档资料修改	Pjgc+
	$(".Pjgc").hide();
	//290	档案统计表菜单栏	Pjh+
	$(".Pjh").hide();
	//291	档案统计表查看详细信息	Pjha+
	$(".Pjha").hide();
	//292	综合查询菜单栏	Pk+
	$(".Pk").hide();
	//293	公司经营情况总览菜单栏	Pka+
	$(".Pka").hide();
	///294	部门经营情况总览菜单栏	Pkb+
	$(".Pkb").hide();
	///295	项目综合查询菜单栏	Pkc+
	$(".Pkc").hide();
	//296	基础数据管理菜单栏	Pl+
	$(".Pl").hide();
	//297	项目类型管理菜单栏	Pla+
	$(".Pla").hide();
	//298	项目类型管理新建一级类型	Plaa+
	$(".Plaa").hide();
	//299	项目类型管理删除一级类型	Plab+
	$(".Plab").hide();
	//300	项目类型管理修改一级类型	Plac+
	$(".Plac").hide();
	//301	项目类型管理新建二级类型	Plad+
	$(".Plad").hide();
	//3/02	项目类型管理删除二级类型	Plae+
	$(".Plae").hide();
	//303	项目类型管理修改二级类型	Plaf+
	$(".Plaf").hide();
	//304	项目规模管理菜单栏	Plb+
	$(".Plb").hide();
	//305	项目规模管理修改项目规模	Plba+
	$(".Plba").hide();
	//306	成本科目管理菜单栏	Plc+
	$(".Plc").hide();
	//307	成本科目管理新建一级科目	Plca+
	$(".Plca").hide();
	//308	成本科目管理删除一级科目	Plcb+
	$(".Plcb").hide();
	//309	成本科目管理修改一级科目	Plcc+
	$(".Plcc").hide();
	//310	成本科目管理新建二级科目	Plcd+
	$(".Plcd").hide();
	//311	成本科目管理删除二级科目	Plce+
	$(".Plce").hide();
	//312	成本科目管理修改二级科目	Plcf+
	$(".Plcf").hide();
	//313	合作单位管理菜单栏	Pld+
	$(".Pld").hide();
	//314	合作单位管理新建	Plda+
	$(".Plda").hide();
	//315	合作单位管理导出Excel文件	Pldb+
	$(".Pldb").hide();
	//316	合作单位管理删除	Pldc+
	$(".Pldc").hide();
	//317	合作单位管理查看详细信息	Pldd+
	$(".Pldd").hide();
	//318	合作单位管理修改	Plde+
	$(".Plde").hide();
	//319	采购供应商管理菜单栏	Ple+
	$(".Ple").hide();
	//320	采购供应商管理新建	Plea+
	$(".Plea").hide();
	//321	采购供应商管理导出Excel文件	Pleb+
	$(".Pleb").hide();
	//322	采购供应商管理删除	Plec+
	$(".Plec").hide();
	//323	采购供应商管理查看详细信息	Pled+
	$(".Pled").hide();
	//324	采购供应商管理修改	Plee+
	$(".Plee").hide();
	//325	材料类型管理菜单栏	Plf+
	$(".Plf").hide();
	//326	材料类型管理新建材料类型	Plfa+
	$(".Plfa").hide();
	//327	材料类型管理删除材料类型	Plfb+
	$(".Plfb").hide();
	//328	材料类型管理修改材料类型	Plfc+
	$(".Plfc").hide();
	//329	系数管理菜单栏	Plg+
	$(".Plg").hide();
	//330	系数管理新建系数	Plga+
	$(".Plga").hide();
	//331	系数管理删除系数	Plgb+
	$(".Plgb").hide();
	//332	系数管理修改系数	Plgc+
	$(".Plgc").hide();
	//333	系统管理菜单栏	Pm+
	$(".Pm").hide();
	//334	组织机构管理菜单栏	Pma+
	$(".Pma").hide();
	///335	组织机构管理新建组织机构	Pmaa+
	$(".Pmaa").hide();
	//336	组织机构管理删除组织机构	Pmab+
	$(".Pmab").hide();
	//337	组织机构管理修改组织机构	Pmac+
	$(".Pmac").hide();
	//338	职务管理菜单栏	Pmb+
	$(".Pmb").hide();
	//339	职务管理新建职务	Pmba+
	$(".Pmba").hide();
	//340	职务管理删除职务	Pmbb+
	$(".Pmbb").hide();
	//341	职务管理修改职务	Pmbc+
	$(".Pmbc").hide();
	//342	职务等级管理菜单栏	Pmc+
	$(".Pmc").hide();
	//343	职务等级管理新建职务等级	Pmca+
	$(".Pmca").hide();
	//344	职务等级管理删除职务等级	Pmcb+
	$(".Pmcb").hide();
	//345	职务等级管理修改职务等级	Pmcc+
	$(".Pmcc").hide();
	//346	职务等级管理新建岗位职务	Pmcd+
	$(".Pmcd").hide();
	//347	职务等级管理删除岗位职务	Pmce+
	$(".Pmce").hide();
	//348	职务等级管理修改岗位职务	Pmcf+
	$(".Pmcf").hide();
	//349	人员用户管理菜单栏	Pmd+
	$(".Pmd").hide();
	//350	人员用户管理新建	Pmda+
	$(".Pmda").hide();
	//351	人员用户管理删除	Pmdb+
	$(".Pmdb").hide();
	//352	人员用户管理修改	Pmdc+
	$(".Pmdc").hide();
	//353	人员用户管理查看详细信息	Pmdd+
	$(".Pmdd").hide();
	//354	角色管理菜单栏	Pme+
	$(".Pme").hide();
	//355	角色管理分配角色	Pmea+
	$(".Pme").hide();
	///356	角色管理新建角色	Pmeb+
	$(".Pmeb").hide();
	///357	权限管理菜单栏	Pmf+
	$(".Pmf").hide();
	///358	权限管理修改	Pmfa+
	$(".Pmfa").hide();
	///359	流程管理菜单栏	Pmg+
	$(".Pmg").hide();
	///360	流程管理新建流程管理	Pmga+
	$(".Pmga").hide();
	//361	流程管理修改流程	Pmgb+
	$(".Pmgb").hide();
	//362	流程管理删除流程	Pmgc+
	$(".Pmgc").hide();
	//363	流程管理新建步骤	Pmgd+
	$(".Pmgd").hide();
	//364	流程管理修改步骤	Pmge+
	$(".Pmge").hide();
	///365	流程管理删除步骤	Pmgf+
	$(".Pmgf").hide();
	//366	短信通知查询菜单栏	Pmh+
	$(".Pmh").hide();
	//367	短信通知查询重发短信通知	Pmha+
	$(".Pmha").hide();
	//368	短信通知管理菜单栏	Pmi+
	$(".Pmi").hide();
	//369	短信通知管理确定通知	Pmia+
	$(".Pmia").hide();

	
    
})(window);


