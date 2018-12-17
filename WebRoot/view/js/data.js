/*var treeData = [
	{id:1,title:'一级菜单',pid:0},
	{id:2,title:'一级菜单02',pid:1},
	{id:7,title:'一级菜单03',pid:1},
	{id:8,title:'一级菜单04',pid:1},
	{id:3,title:'二级菜单',pid:2},
	{id:4,title:'二级单01',pid:2},
	{id:5,title:'二级单02',pid:2},
	{id:6,title:'二级单03',pid:3},
]*/
var treeData =[
	{id: "Pa+", pid: 0, title: "个人任务菜单栏"},
	{id: "Pb+", pid: 0, title: "行政事务菜单栏"},
	{id: "Pc+", pid: 0, title: "财务管理菜单栏"},
	{id: "Pd+", pid: 0, title: "经营管理菜单栏"},
	{id: "Pe+", pid: 0, title: "生产管理菜单栏"},
	{id: "Pf+", pid: 0, title: "检测二部菜单栏"},
	{id: "Pg+", pid: 0, title: "薪酬管理菜单栏"},
	{id: "Ph+", pid: 0, title: "质量安全管理菜单栏"},
	{id: "Pi+", pid: 0, title: "科研管理菜单栏"},
	{id: "Pj+", pid: 0, title: "档案管理菜单栏"},
	{id: "Pk+", pid: 0, title: "综合查询菜单栏"},
	{id: "Pl+", pid: 0, title: "基础数据管理菜单栏"},
	{id: "Pm+", pid: 0, title: "系统管理菜单栏"},
	{id: "Paa+", pid: "Pa+", title: "待办事项菜单栏"},
	{id: "Pab+", pid: "Pa+", title: "已办事项菜单栏"},
	{id: "Pac+", pid: "Pa+", title: "业务催办菜单栏"},
	{id: "Pad+", pid: "Pa+", title: "业务办理通知菜单栏"},
	{id: "Pba+", pid: "Pb+", title: "通知公告菜单栏"},
	{id: "Pbb+", pid: "Pb+", title: "项目印章管理菜单栏"},
	{id: "Pbc+", pid: "Pb+", title: "成果文件用印管理菜单栏"},
	{id: "Pbd+", pid: "Pb+", title: "培训管理菜单栏"},
	{id: "Pca+", pid: "Pc+", title: "财务收款菜单栏"},
	{id: "Pcb+", pid: "Pc+", title: "项目款认领菜单栏"},
	{id: "Pcc+", pid: "Pc+", title: "财务还款菜单栏"},
	{id: "Pcd+", pid: "Pc+", title: "开票申请菜单栏"},
	{id: "Pda+", pid: "Pd+", title: "项目跟踪菜单栏"},
	{id: "Pdb+", pid: "Pd+", title: "项目投标菜单栏"},
	{id: "Pdc+", pid: "Pd+", title: "经营目标管理菜单栏"},
	{id: "Pea+", pid: "Pe+", title: "任务单管理菜单栏"},
	{id: "Peb+", pid: "Pe+", title: "预算管理菜单栏"},
	{id: "Pec+", pid: "Pe+", title: "合同管理菜单栏"},
	{id: "Ped+", pid: "Pe+", title: "材料采购管理菜单栏"},
	{id: "Pee+", pid: "Pe+", title: "进度管理菜单栏"},
	{id: "Pef+", pid: "Pe+", title: "项目成本预警菜单栏"},
	{id: "Peg+", pid: "Pe+", title: "项目工时管理菜单栏"},
	{id: "Peh+", pid: "Pe+", title: "施工报表菜单栏"},
	{id: "Pei+", pid: "Pe+", title: "项目结算审计菜单栏"},
	{id: "Pfa+", pid: "Pf+", title: "检测二部任务单管理菜单栏"},
	{id: "Pfb+", pid: "Pf+", title: "检测二部财务收款菜单栏"},
	{id: "Pfc+", pid: "Pf+", title: "检测二部项目款认领菜单栏"},
	{id: "Pga+", pid: "Pg+", title: "职务等级体系菜单栏"},
	{id: "Pgb+", pid: "Pg+", title: "项目规模及人员要求菜单栏"},
	{id: "Pgc+", pid: "Pg+", title: "员工薪酬结构菜单栏"},
	{id: "Pgd+", pid: "Pg+", title: "年度奖金菜单栏"},
	{id: "Pha+", pid: "Ph+", title: "项目安全管理菜单栏"},
	{id: "Phb+", pid: "Ph+", title: "公司安全管理菜单栏"},
	{id: "Pia+", pid: "Pi+", title: "科研管理经营管理菜单栏"},
	{id: "Pib+", pid: "Pi+", title: "科研管理过程管理菜单栏"},
	{id: "Pja+", pid: "Pj+", title: "档案交接菜单栏"},
	{id: "Pjb+", pid: "Pj+", title: "经营文档资料菜单栏"},
	{id: "Pjc+", pid: "Pj+", title: "施工文档资料菜单栏"},
	{id: "Pjd+", pid: "Pj+", title: "检测评估资料菜单栏"},
	{id: "Pje+", pid: "Pj+", title: "设计文件资料菜单栏"},
	{id: "Pjf+", pid: "Pj+", title: "维修加固设计资料菜单栏"},
	{id: "Pjg+", pid: "Pj+", title: "科技文档资料菜单栏"},
	{id: "Pjh+", pid: "Pj+", title: "档案统计表菜单栏"},
	{id: "Pka+", pid: "Pk+", title: "公司经营情况总览菜单栏"},
	{id: "Pkb+", pid: "Pk+", title: "部门经营情况总览菜单栏"},
	{id: "Pkc+", pid: "Pk+", title: "项目综合查询菜单栏"},
	{id: "Pla+", pid: "Pl+", title: "项目类型管理菜单栏"},
	{id: "Plb+", pid: "Pl+", title: "项目规模管理菜单栏"},
	{id: "Plc+", pid: "Pl+", title: "成本科目管理菜单栏"},
	{id: "Pld+", pid: "Pl+", title: "合作单位管理菜单栏"},
	{id: "Ple+", pid: "Pl+", title: "采购供应商管理菜单栏"},
	{id: "Plf+", pid: "Pl+", title: "材料类型管理菜单栏"},
	{id: "Plg+", pid: "Pl+", title: "系数管理菜单栏"},
	{id: "Pma+", pid: "Pm+", title: "组织机构管理菜单栏"},
	{id: "Pmb+", pid: "Pm+", title: "职务管理菜单栏"},
	{id: "Pmc+", pid: "Pm+", title: "职务等级管理菜单栏"},
	{id: "Pmd+", pid: "Pm+", title: "人员用户管理菜单栏"},
	{id: "Pme+", pid: "Pm+", title: "角色管理菜单栏"},
	{id: "Pmf+", pid: "Pm+", title: "权限管理菜单栏"},
	{id: "Pmg+", pid: "Pm+", title: "流程管理菜单栏"},
	{id: "Pmh+", pid: "Pm+", title: "短信通知查询菜单栏"},
	{id: "Pmi+", pid: "Pm+", title: "短信通知管理菜单栏"},
	{id: "Paaa+", pid: "Paa+", title: "待办事项业务办理"},
	{id: "Paba+", pid: "Pab+", title: "已办事项查看办理业务"},
	{id: "Pabb+", pid: "Pab+", title: "已办事项删除"},
	{id: "Pabc+", pid: "Pab+", title: "已办事项撤回"},
	{id: "Paca+", pid: "Pac+", title: "业务催办通知催办"},
	{id: "Pbaa+", pid: "Pba+", title: "公司通知公告新建"},
	{id: "Pbab+", pid: "Pba+", title: "公司通知公告查看详细信息"},
	{id: "Pbac+", pid: "Pba+", title: "公司通知公告修改"},
	{id: "Pbad+", pid: "Pba+", title: "部门通知公告新建"},
	{id: "Pbae+", pid: "Pba+", title: "部门通知公告查看详细信息"},
	{id: "Pbaf+", pid: "Pba+", title: "部门通知公告修改"},
	{id: "Pbba+", pid: "Pbb+", title: "刻制申请填报"},
	{id: "Pbbb+", pid: "Pbb+", title: "刻制申请查看详细信息"},
	{id: "Pbbc+", pid: "Pbb+", title: "刻制申请修改"},
	{id: "Pbbd+", pid: "Pbb+", title: "使用管理填报"},
	{id: "Pbbe+", pid: "Pbb+", title: "使用管理查看详细信息"},
	{id: "Pbbf+", pid: "Pbb+", title: "使用管理修改"},
	{id: "Pbca+", pid: "Pbc+", title: "成果文件用印填报"},
	{id: "Pbcb+", pid: "Pbc+", title: "成果文件用印查看详细信息"},
	{id: "Pbcc+", pid: "Pbc+", title: "成果文件用印修改"},
	{id: "Pbda+", pid: "Pbd+", title: "外出培训申请菜单栏"},
	{id: "Pbdb+", pid: "Pbd+", title: "外部培训申请菜单栏"},
	{id: "Pbdc+", pid: "Pbd+", title: "内部培训申请菜单栏"},
	{id: "Pbdd+", pid: "Pbd+", title: "培训资料管理菜单栏"},
	{id:"Pcaa+",pid:"Pca+",title:"财务收款新建"},
	{id:"Pcab+",pid:"Pca+",title:"财务收款查看详细信息"},
	{id:"Pcba+",pid:"Pcb+",title:"项目款未认领查看详细信息"},
	{id:"Pcbb+",pid:"Pcb+",title:"项目款已认领查看详细信息"},
	{id:"Pcca+",pid:"Pcc+",title:"财务还款新建"},
	{id:"Pccb+",pid:"Pcc+",title:"财务还款查看详细信息"},
	{id:"Pcda+",pid:"Pcd+",title:"开票申请新建"},
	{id:"Pcdb+",pid:"Pcd+",title:"开票申请查看详细信息"},
	{id:"Pcdc+",pid:"Pcd+",title:"开票申请补录发票编号"},
	{id:"Pdaa+",pid:"Pda+",title:"项目跟踪单新建"},
	{id:"Pdab+",pid:"Pda+",title:"项目跟踪单查看详细信息"},
	{id:"Pdac+",pid:"Pda+",title:"项目跟踪单修改"},
	{id:"Pdad+",pid:"Pda+",title:"项目跟踪日志新建"},
	{id:"Pdae+",pid:"Pda+",title:"项目跟踪日志查看详细信息"},
	{id:"Pdaf+",pid:"Pda+",title:"项目跟踪日志修改"},
	{id:"Pdba+",pid:"Pdb+",title:"投标审批单菜单栏"},
	{id:"Pdbb+",pid:"Pdb+",title:"项目风险评估菜单栏"},
	{id:"Pdbc+",pid:"Pdb+",title:"开标记录菜单栏"},
	{id:"Pdbd+",pid:"Pdb+",title:"中标项目移交菜单栏"},
	{id:"Pdbe+",pid:"Pdb+",title:"投标项目列表菜单栏"},
	{id:"Pdca+",pid:"Pdc+",title:"经营目标管理新建"},
	{id:"Pdcb+",pid:"Pdc+",title:"经营目标管理导入开票记录"},
	{id:"Pdcc+",pid:"Pdc+",title:"经营目标管理查看详细信息"},
	{id:"Pdcd+",pid:"Pdc+",title:"经营目标管理修改"},
	{id:"Pdce+",pid:"Pdc+",title:"经营目标管理拆解公司指标"},
	{id:"Peaa+",pid:"Pea+",title:"任务单管理填报"},
	{id:"Peab+",pid:"Pea+",title:"任务单管理查看详细信息"},
	{id:"Peac+",pid:"Pea+",title:"任务单管理修改"},
	{id:"Pead+",pid:"Pea+",title:"任务单管理项目中止"},
	{id:"Peae+",pid:"Pea+",title:"任务单管理项目重启"},
	{id:"Peba+",pid:"Peb+",title:"预算管理新建"},
	{id:"Pebb+",pid:"Peb+",title:"预算管理查看详细信息"},
	{id:"Pebc+",pid:"Peb+",title:"预算管理修改"},
	{id:"Peca+",pid:"Pec+",title:"承接合同管理菜单栏"},
	{id:"Pecb+",pid:"Pec+",title:"分包合同管理菜单栏"},
	{id:"Pecc+",pid:"Pec+",title:"采购合同管理菜单栏"},
	{id:"Pecd+",pid:"Pec+",title:"借款合同管理菜单栏"},
	{id:"Pece+",pid:"Pec+",title:"其他合同管理菜单栏"},
	{id:"Pecf+",pid:"Pec+",title:"分包合同付款菜单栏"},
	{id:"Pecg+",pid:"Pec+",title:"合同履约菜单栏"},
	{id:"Peda+",pid:"Ped+",title:"材料采购申请菜单栏"},
	{id:"Pedb+",pid:"Ped+",title:"公司材料管理菜单栏"},
	{id:"Pedc+",pid:"Ped+",title:"项目材料管理菜单栏"},
	{id:"Peea+",pid:"Pee+",title:"进度管理填报"},
	{id:"Peeb+",pid:"Pee+",title:"进度管理查看详细信息"},
	{id:"Pefa+",pid:"Pef+",title:"项目成本预警查看详细信息"},
	{id:"Pefb+",pid:"Pef+",title:"项目成本预警录入原因"},
	{id:"Pega+",pid:"Peg+",title:"项目工时管理填报"},
	{id:"Pegb+",pid:"Peg+",title:"项目工时管理删除"},
	{id:"Pegc+",pid:"Peg+",title:"项目工时管理查看详细信息"},
	{id:"Pegd+",pid:"Peg+",title:"项目工时管理修改 "},
	{id:"Peha+",pid:"Peh+",title:"项目施工日志菜单栏"},
	{id:"Pehb+",pid:"Peh+",title:"项目周报菜单栏"},
	{id:"Pehc+",pid:"Peh+",title:"项目月报菜单栏"},
	{id:"Peia+",pid:"Pei+",title:"项目结算审计填报"},
	{id:"Peib+",pid:"Pei+",title:"项目结算审计查看详细信息"},
	{id:"Pfaa+",pid:"Pfa+",title:"检测二部任务单管理导入新签合同"},
	{id:"Pfab+",pid:"Pfa+",title:"检测二部任务单管理导入上月合同"},
	{id:"Pfac+",pid:"Pfa+",title:"检测二部任务单管理查看详细信息"},
	{id:"Pfad+",pid:"Pfa+",title:"检测二部任务单管理删除"},
	{id:"Pfba+",pid:"Pfb+",title:"检测二部财务收款导入收款项目"},
	{id:"Pfbb+",pid:"Pfb+",title:"检测二部财务收款查看详细信息"},
	{id:"Pfca+",pid:"Pfc+",title:"检测二部项目款已认领查看详细信息"},
	{id:"Pfcb+",pid:"Pfc+",title:"检测二部项目款未认领查看详细信息"},
	{id:"Pjaa+",pid:"Pja+",title:"档案交接接收人签字"},
	{id:"Pjab+",pid:"Pja+",title:"档案交接查看详细信息"},
	{id:"Pjba+",pid:"Pjb+",title:"经营文档资料删除"},
	{id:"Pjbb+",pid:"Pjb+",title:"经营文档资料查看详细信息"},
	{id:"Pjbc+",pid:"Pjb+",title:"经营文档资料修改"},
	{id:"Pjca+",pid:"Pjc+",title:"施工文档资料删除"},
	{id:"Pjcb+",pid:"Pjc+",title:"施工文档资料查看详细信息"},
	{id:"Pjcc+",pid:"Pjc+",title:"施工文档资料修改"},
	{id:"Pjda+",pid:"Pjd+",title:"检测评估资料删除"},
	{id:"Pjdb+",pid:"Pjd+",title:"检测评估资料查看详细信息"},
	{id:"Pjdc+",pid:"Pjd+",title:"检测评估资料修改"},
	{id:"Pjea+",pid:"Pje+",title:"设计文件资料删除"},
	{id:"Pjeb+",pid:"Pje+",title:"设计文件资料查看详细信息"},
	{id:"Pjec+",pid:"Pje+",title:"设计文件资料修改"},
	{id:"Pjfa+",pid:"Pjf+",title:"维修加固设计资料删除"},
	{id:"Pjfb+",pid:"Pjf+",title:"维修加固设计资料修改"},
	{id:"Pjfc+",pid:"Pjf+",title:"维修加固设计资料查看详细信息"},
	{id:"Pjga+",pid:"Pjg+",title:"科技文档资料删除"},
	{id:"Pjgb+",pid:"Pjg+",title:"科技文档资料查看详细信息"},
	{id:"Pjgc+",pid:"Pjg+",title:"科技文档资料修改"},
	{id:"Pjha+",pid:"Pjh+",title:"档案统计表查看详细信息"},
	{id:"Plaa+",pid:"Pla+",title:"项目类型管理新建一级类型"},
	{id:"Plab+",pid:"Pla+",title:"项目类型管理删除一级类型"},
	{id:"Plac+",pid:"Pla+",title:"项目类型管理修改一级类型"},
	{id:"Plad+",pid:"Pla+",title:"项目类型管理新建二级类型"},
	{id:"Plae+",pid:"Pla+",title:"项目类型管理删除二级类型"},
	{id:"Plaf+",pid:"Pla+",title:"项目类型管理修改二级类型"},
	{id:"Plba+",pid:"Plb+",title:"项目规模管理修改项目规模"},
	{id:"Plca+",pid:"Plc+",title:"成本科目管理新建一级科目"},
	{id:"Plcb+",pid:"Plc+",title:"成本科目管理删除一级科目"},
	{id:"Plcc+",pid:"Plc+",title:"成本科目管理修改一级科目"},
	{id:"Plcd+",pid:"Plc+",title:"成本科目管理新建二级科目"},
	{id:"Plce+",pid:"Plc+",title:"成本科目管理删除二级科目"},
	{id:"Plcf+",pid:"Plc+",title:"成本科目管理修改二级科目"},
	{id:"Plda+",pid:"Pld+",title:"合作单位管理新建"},
	{id:"Pldb+",pid:"Pld+",title:"合作单位管理导出Excel文件"},
	{id:"Pldc+",pid:"Pld+",title:"合作单位管理删除"},
	{id:"Pldd+",pid:"Pld+",title:"合作单位管理查看详细信息"},
	{id:"Plde+",pid:"Pld+",title:"合作单位管理修改"},
	{id:"Plea+",pid:"Ple+",title:"采购供应商管理新建"},
	{id:"Pleb+",pid:"Ple+",title:"采购供应商管理导出Excel文件"},
	{id:"Plec+",pid:"Ple+",title:"采购供应商管理删除"},
	{id:"Pled+",pid:"Ple+",title:"采购供应商管理查看详细信息"},
	{id:"Plee+",pid:"Ple+",title:"采购供应商管理修改"},
	{id:"Plfa+",pid:"Plf+",title:"材料类型管理新建材料类型"},
	{id:"Plfb+",pid:"Plf+",title:"材料类型管理删除材料类型"},
	{id:"Plfc+",pid:"Plf+",title:"材料类型管理修改材料类型"},
	{id:"Plga+",pid:"Plg+",title:"系数管理新建系数"},
	{id:"Plgb+",pid:"Plg+",title:"系数管理删除系数"},
	{id:"Plgc+",pid:"Plg+",title:"系数管理修改系数"},
	{id:"Pmaa+",pid:"Pma+",title:"组织机构管理新建组织机构"},
	{id:"Pmab+",pid:"Pma+",title:"组织机构管理删除组织机构"},
	{id:"Pmac+",pid:"Pma+",title:"组织机构管理修改组织机构"},
	{id:"Pmba+",pid:"Pmb+",title:"职务管理新建职务"},
	{id:"Pmbb+",pid:"Pmb+",title:"职务管理删除职务"},
	{id:"Pmbc+",pid:"Pmb+",title:"职务管理修改职务"},
	{id:"Pmca+",pid:"Pmc+",title:"职务等级管理新建职务等级"},
	{id:"Pmcb+",pid:"Pmc+",title:"职务等级管理删除职务等级"},
	{id:"Pmcc+",pid:"Pmc+",title:"职务等级管理修改职务等级"},
	{id:"Pmcd+",pid:"Pmc+",title:"职务等级管理新建岗位职务"},
	{id:"Pmce+",pid:"Pmc+",title:"职务等级管理删除岗位职务"},
	{id:"Pmcf+",pid:"Pmc+",title:"职务等级管理修改岗位职务"},
	{id:"Pmda+",pid:"Pmd+",title:"人员用户管理新建"},
	{id:"Pmdb+",pid:"Pmd+",title:"人员用户管理删除"},
	{id:"Pmdc+",pid:"Pmd+",title:"人员用户管理修改"},
	{id:"Pmdd+",pid:"Pmd+",title:"人员用户管理查看详细信息"},
	{id:"Pmea+",pid:"Pme+",title:"角色管理分配角色"},
	{id:"Pmeb+",pid:"Pme+",title:"角色管理新建角色"},
	{id:"Pmfa+",pid:"Pmf+",title:"权限管理修改"},
	{id:"Pmga+",pid:"Pmg+",title:"流程管理新建流程管理"},
	{id:"Pmgb+",pid:"Pmg+",title:"流程管理修改流程"},
	{id:"Pmgc+",pid:"Pmg+",title:"流程管理删除流程"},
	{id:"Pmgd+",pid:"Pmg+",title:"流程管理新建步骤"},
	{id:"Pmge+",pid:"Pmg+",title:"流程管理修改步骤"},
	{id:"Pmgf+",pid:"Pmg+",title:"流程管理删除步骤"},
	{id:"Pmha+",pid:"Pmh+",title:"短信通知查询重发短信通知"},
	{id:"Pmia+",pid:"Pmi+",title:"短信通知管理确定通知"},
	{id:"Pbdaa+",pid:"Pbda+",title:"外出培训申请填报"},
	{id:"Pbdab+",pid:"Pbda+",title:"外出培训申请查看详细信息"},
	{id:"Pbdac+",pid:"Pbda+",title:"外出培训申请修改"},
	{id:"Pbdba+",pid:"Pbdb+",title:"外部培训申请填报"},
	{id:"Pbdbb+",pid:"Pbdb+",title:"外部培训申请查看详细信息"},
	{id:"Pbdbc+",pid:"Pbdb+",title:"外部培训申请修改"},
	{id:"Pbdca+",pid:"Pbdc+",title:"内部培训申请填报"},
	{id:"Pbdcb+",pid:"Pbdc+",title:"内部培训申请查看详细信息"},
	{id:"Pbdcc+",pid:"Pbdc+",title:"内部培训申请修改"},
	/*{id:"Pbdda+",pid:"Pbdd+",title:"培训资料管理填报"},
	{id:"Pbddb+",pid:"Pbdd+",title:"培训资料管理查看详细信息"},
	{id:"Pbddc+",pid:"Pbdd+",title:"培训资料管理修改"},
	{id:"Pdbaa+",pid:"Pdba+",title:"投标审批单新建"},
	{id:"Pdbab+",pid:"Pdba+",title:"投标审批单查看详细信息"},
	{id:"Pdbac+",pid:"Pdba+",title:"投标审批单修改"},
	{id:"Pdbad+",pid:"Pdba+",title:"投标审批单删除"},
	{id:"Pdbba+",pid:"Pdbb+",title:"项目风险评估新建"},
	{id:"Pdbbb+",pid:"Pdbb+",title:"项目风险评估查看详细信息"},
	{id:"Pdbbc+",pid:"Pdbb+",title:"项目风险评估修改"},
	{id:"Pdbca+",pid:"Pdbc+",title:"开标记录新建"},
	{id:"Pdbcb+",pid:"Pdbc+",title:"开标记录查看详细信息"},
	{id:"Pdbcc+",pid:"Pdbc+",title:"开标记录修改"},
	{id:"Pdbda+",pid:"Pdbd+",title:"中标项目移交新建"},
	{id:"Pdbdb+",pid:"Pdbd+",title:"中标项目移交查看详细信息"},
	{id:"Pdbdc+",pid:"Pdbd+",title:"中标项目移交修改"},
	{id:"Pdbea+",pid:"Pdbe+",title:"投标项目列表新建"},
	{id:"Pdbeb+",pid:"Pdbe+",title:"投标项目列表导出excel文件"},
	{id:"Pdbec+",pid:"Pdbe+",title:"投标项目列表查看详细信息"},
	{id:"Pdbed+",pid:"Pdbe+",title:"投标项目列表修改"},
	{id:"Pdbee+",pid:"Pdbe+",title:"投标项目列表删除"},
	{id:"Pecaa+",pid:"Peca+",title:"承接合同管理填报"},
	{id:"Pecab+",pid:"Peca+",title:"承接合同管理查看详细信息"},
	{id:"Pecac+",pid:"Peca+",title:"承接合同管理合同变更"},
	{id:"Pecad+",pid:"Peca+",title:"承接合同管理合同取消"},
	{id:"Pecae+",pid:"Peca+",title:"承接合同管理查看取消原因"},
	{id:"Pecaf+",pid:"Peca+",title:"承接合同管理合同重启"},
	{id:"Pecba+",pid:"Pecb+",title:"分包合同管理填报"},
	{id:"Pecbb+",pid:"Pecb+",title:"分包合同管理查看详细信息"},
	{id:"Pecbc+",pid:"Pecb+",title:"分包合同管理合同变更"},
	{id:"Pecbd+",pid:"Pecb+",title:"分包合同管理合同取消"},
	{id:"Pecbe+",pid:"Pecb+",title:"分包合同管理查看合同取消原因"},
	{id:"Pecbf+",pid:"Pecb+",title:"分包合同管理合同重启"},
	{id:"Pecca+",pid:"Pecc+",title:"采购合同管理填报"},
	{id:"Peccb+",pid:"Pecc+",title:"采购合同管理查看详细信息"},
	{id:"Peccc+",pid:"Pecc+",title:"采购合同管理合同变更"},
	{id:"Peccd+",pid:"Pecc+",title:"采购合同管理合同取消"},
	{id:"Pecce+",pid:"Pecc+",title:"采购合同管理查看合同取消原因"},
	{id:"Peccf+",pid:"Pecc+",title:"采购合同管理合同重启"},
	{id:"Pecda+",pid:"Pecd+",title:"借款合同管理填报"},
	{id:"Pecdb+",pid:"Pecd+",title:"借款合同管理查看详细信息"},
	{id:"Pecdc+",pid:"Pecd+",title:"借款合同管理合同变更"},
	{id:"Pecdd+",pid:"Pecd+",title:"借款合同管理合同取消"},
	{id:"Pecde+",pid:"Pecd+",title:"借款合同管理查看合同取消原因"},
	{id:"Pecdf+",pid:"Pecd+",title:"借款合同管理合同重启"},
	{id:"Pecea+",pid:"Pece+",title:"其他合同管理填报"},
	{id:"Peceb+",pid:"Pece+",title:"其他合同管理查看详细信息"},
	{id:"Pecec+",pid:"Pece+",title:"其他合同管理合同变更"},
	{id:"Peced+",pid:"Pece+",title:"其他合同管理合同取消"},
	{id:"Pecee+",pid:"Pece+",title:"其他合同管理查看合同取消原因"},
	{id:"Pecef+",pid:"Pece+",title:"其他合同管理合同重启"},
	{id:"Pecfa+",pid:"Pecf+",title:"分包合同付款填报"},
	{id:"Pecfb+",pid:"Pecf+",title:"分包合同付款查看详细信息"},
	{id:"Pecfc+",pid:"Pecf+",title:"分包合同付款合同变更"},
	{id:"Pecga+",pid:"Pecg+",title:"合同履约承接合同菜单栏"},
	{id:"Pecgb+",pid:"Pecg+",title:"合同履约材料分包合同菜单栏"},
	{id:"Pecgc+",pid:"Pecg+",title:"合同履约劳务分包合同菜单栏"},
	{id:"Pedaa+",pid:"Peda+",title:"材料采购申请填报"},
	{id:"Pedab+",pid:"Peda+",title:"材料采购申请查看详细信息"},
	{id:"Pedba+",pid:"Pedb+",title:"公司材料管理材料入库菜单栏"},
	{id:"Pedbb+",pid:"Pedb+",title:"公司材料管理材料出库菜单栏"},
	{id:"Pedbc+",pid:"Pedb+",title:"公司材料管理结余管理菜单栏"},
	{id:"Pedbd+",pid:"Pedb+",title:"公司材料管理废旧品处理菜单栏"},
	{id:"Pedbe+",pid:"Pedb+",title:"公司材料管理统计花销费用菜单栏"},
	{id:"Pedbf+",pid:"Pedb+",title:"公司材料管理退货菜单栏"},
	{id:"Pedca+",pid:"Pedc+",title:"项目材料管理材料入库菜单栏"},
	{id:"Pedcb+",pid:"Pedc+",title:"项目材料管理材料出库菜单栏"},
	{id:"Pedcc+",pid:"Pedc+",title:"项目材料管理结余管理菜单栏"},
	{id:"Pedcd+",pid:"Pedc+",title:"项目材料管理废旧品处理菜单栏"},
	{id:"Pehaa+",pid:"Peha+",title:"项目施工日志填报"},
	{id:"Pehab+",pid:"Peha+",title:"项目施工日志删除"},
	{id:"Pehac+",pid:"Peha+",title:"项目施工日志修改"},
	{id:"Pehad+",pid:"Peha+",title:"项目施工日志查看详细信息"},
	{id:"Pehba+",pid:"Pehb+",title:"项目周报填报"},
	{id:"Pehbb+",pid:"Pehb+",title:"项目周报删除"},
	{id:"Pehbc+",pid:"Pehb+",title:"项目周报查看详细信息"},
	{id:"Pehbd+",pid:"Pehb+",title:"项目周报修改"},
	{id:"Pehca+",pid:"Pehc+",title:"项目月报填报"},
	{id:"Pehcb+",pid:"Pehc+",title:"项目月报删除"},
	{id:"Pehcc+",pid:"Pehc+",title:"项目月报查看详细信息"},
	{id:"Pehcd+",pid:"Pehc+",title:"项目月报修改"},
	{id:"Pecgaa+",pid:"Pecga+",title:"合同履约承接合同合同交工履约申请填报"},
	{id:"Pecgab+",pid:"Pecga+",title:"合同履约承接合同合同交工履约申请查看详细信息"},
	{id:"Pecgac+",pid:"Pecga+",title:"合同履约承接合同合同竣工履约申请填报"},
	{id:"Pecgad+",pid:"Pecga+",title:"合同履约承接合同合同竣工履约申请查看详细信息"},
	{id:"Pecgba+",pid:"Pecgb+",title:"合同履约材料分包合同履约评价填报"},
	{id:"Pecgbb+",pid:"Pecgb+",title:"合同履约材料分包合同履约评价查看详细信息"},
	{id:"Pecgbc+",pid:"Pecgb+",title:"合同履约材料分包合同履约评价修改"},
	{id:"Pecgbd+",pid:"Pecgb+",title:"合同履约材料分包合同采购结算申请填报"},
	{id:"Pecgbe+",pid:"Pecgb+",title:"合同履约材料分包合同采购结算申请查看详细信息"},
	{id:"Pecgbf+",pid:"Pecgb+",title:"合同履约材料分包合同采购结算申请修改"},
	{id:"Pecgbg+",pid:"Pecgb+",title:"合同履约材料分包合同采购合同履约填报"},
	{id:"Pecgbh+",pid:"Pecgb+",title:"合同履约材料分包合同采购合同履约导出打印"},
	{id:"Pecgbi+",pid:"Pecgb+",title:"合同履约材料分包合同采购合同履约查看详细信息"},
	{id:"Pecgbj+",pid:"Pecgb+",title:"合同履约材料分包合同采购合同履约修改"},
	{id:"Pecgca+",pid:"Pecgc+",title:"合同履约劳务分包合同履约评价填报"},
	{id:"Pecgcb+",pid:"Pecgc+",title:"合同履约劳务分包合同履约评价查看详细信息"},
	{id:"Pecgcc+",pid:"Pecgc+",title:"合同履约劳务分包合同分包结算申请填报"},
	{id:"Pecgcd+",pid:"Pecgc+",title:"合同履约劳务分包合同分包结算申请查看详细信息"},
	{id:"Pecgce+",pid:"Pecgc+",title:"合同履约劳务分包合同分包合同履约填报"},
	{id:"Pecgcf+",pid:"Pecgc+",title:"合同履约劳务分包合同分包合同履约导出打印"},
	{id:"Pecgcg+",pid:"Pecgc+",title:"合同履约劳务分包合同分包合同履约查看详细信息"},
	{id:"Pedbaa+",pid:"Pedba+",title:"公司材料管理材料入库填报"},
	{id:"Pedbab+",pid:"Pedba+",title:"公司材料管理材料入库查看详细信息"},
	{id:"Pedbba+",pid:"Pedbb+",title:"公司材料管理材料出库填报"},
	{id:"Pedbbb+",pid:"Pedbb+",title:"公司材料管理材料出库查看详细信息"},
	{id:"Pedbca+",pid:"Pedbc+",title:"公司材料管理结余管理查看详细信息"},
	{id:"Pedbcb+",pid:"Pedbc+",title:"公司材料管理结余管理结余转出"},
	{id:"Pedbda+",pid:"Pedbd+",title:"公司材料管理废旧品处理填报"},
	{id:"Pedbdb+",pid:"Pedbd+",title:"公司材料管理废旧品处理查看详细信息"},
	{id:"Pedbfa+",pid:"Pedbf+",title:"公司材料管理退货填报"},
	{id:"Pedbfb+",pid:"Pedbf+",title:"公司材料管理退货查看详细信息"},
	{id:"Pedcaa+",pid:"Pedca+",title:"项目材料管理材料入库收货确认"},
	{id:"Pedcab+",pid:"Pedca+",title:"项目材料管理材料入库查看详细信息"},
	{id:"Pedcba+",pid:"Pedcb+",title:"项目材料管理材料出库填报"},
	{id:"Pedcbb+",pid:"Pedcb+",title:"项目材料管理材料出库查看详细信息"},
	{id:"Pedcca+",pid:"Pedcc+",title:"项目材料管理结余管理结余确认"},
	{id:"Pedccb+",pid:"Pedcc+",title:"项目材料管理结余管理结余利用"},
	{id:"Pedcda+",pid:"Pedcd+",title:"项目材料管理废旧品处理填报"},
	{id:"Pedcdb+",pid:"Pedcd+",title:"项目材料管理废旧品处理查看详细信息"},*/
]