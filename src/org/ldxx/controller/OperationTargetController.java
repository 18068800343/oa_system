package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import org.ldxx.bean.DepartmentTarget;
import org.ldxx.bean.MonthTarget;
import org.ldxx.bean.OperationTarget;
import org.ldxx.service.DepartmentTargetService;
import org.ldxx.service.MonthTargetService;
import org.ldxx.service.OperationTargetService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("operationTarget")
public class OperationTargetController {

	@Autowired
	private OperationTargetService oservice;
	
	@Autowired
	private DepartmentTargetService dservice;
	
	@Autowired
	private MonthTargetService mservice;
	
	@RequestMapping("/addOperationTargetBySave")
	@ResponseBody
	public int addOperationTargetBySave(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/addOperationTargetBySubmit")
	@ResponseBody
	public int addOperationTargetBySubmit(OperationTarget target){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		target.setOtId(id);
		int i=oservice.addOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/deleteOperationTarget")
	@ResponseBody
	public int deleteOperationTarget(String id){
		int i=oservice.deleteOperationTargetById(id);
		return i;
	}
	
	@RequestMapping("/updateOperationTargetBySave")
	@ResponseBody
	public int updateOperationTargetBySave(OperationTarget target){
		int i=oservice.updateOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/updateOperationTargetBySubmit")
	@ResponseBody
	public int updateOperationTargetBySubmit(OperationTarget target){
		int i=oservice.updateOperationTarget(target);
		return i;
	}
	
	@RequestMapping("/selectOperationTarget")
	@ResponseBody
	public List<OperationTarget> selectOperationTarget(){
		List<OperationTarget> list=oservice.selectOperationTarget();
		return list;
	}
	
	/***********************************************部门指标**************************************************/
	@RequestMapping("/orNotSplit")
	@ResponseBody
	public int orNotSplit(String id){
		int i=dservice.orNotSplit(id);
		return i;
	}
	
	@RequestMapping("/addDepartmentTargetBySave")/*分解公司指标*/
	@ResponseBody
	public int addDepartmentTargetBySave(@RequestBody List<DepartmentTarget> dTarget){
		String otId=dTarget.get(0).getOtId();
		int a=dservice.orNotSplit(otId);
		if(a==0){
			TimeUUID uuid=new TimeUUID();
			for(int i=0;i<dTarget.size();i++){
				String id=uuid.getTimeUUID();
				dTarget.get(i).settId(id);
			}
			a=dservice.addDepartmentTarget(dTarget);
		}else{
			a=dservice.updateDepartmentTarget(dTarget);
		}
		return a;
	}
	
	
	@RequestMapping("/selectDepartmentTarget")/*查看公司指标下部门指标列表*/
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTarget(String id){
		List<DepartmentTarget> list=dservice.selectDepartmentTarget(id);
		return list;
	}
	
	@RequestMapping("/selectDepartmentTargetByOmId")/*各部门指标列表*/
	@ResponseBody
	public List<DepartmentTarget> selectDepartmentTargetByOmId(String id){
		List<DepartmentTarget> list=dservice.selectDepartmentTargetByOmId(id);
		return list;
	}
	
	@RequestMapping("/addMonthTargetBySave")/*分解部门月指标*/
	@ResponseBody
	public int addMonthTargetBySave(@RequestBody List<MonthTarget> target){
		String otId=target.get(0).getOtId();
		int i=mservice.orNotSplit(otId);
		if(i>0){
			i=mservice.updateMonthTarget(target);
		}else{
			i=mservice.addMonthTarget(target);
		}
		return i;
	}
	
	@RequestMapping("/selectMonthTargetById")/*查看部门月指标列表*/
	@ResponseBody
	public List<MonthTarget> selectMonthTargetByIdAndType(String tId){
		List<MonthTarget> list=mservice.selectMonthTargetById(tId);
		return list;
	}
	
	@RequestMapping("/getCorporationTarget")
	@ResponseBody
	public List<MonthTarget> getCorporationTarget(String id){
		List<MonthTarget> targetArray=new ArrayList<>();
		int i=mservice.ifTarget(id);
		if(i==0){
			
		}else{
			MonthTarget monthTarget=new MonthTarget();
			float targetSumOfList=0;
			float target2SumOfList=0;
			float target3SumOfList=0;
			List<MonthTarget> list=mservice.selectMonthTargetByMonthSum(id, 1);
			for(int a=0;a<list.size();a++){
				float target=list.get(a).getContractAmount();
				targetSumOfList=targetSumOfList+target;
				float target2=list.get(a).getRevenueTarget();
				target2SumOfList=target2SumOfList+target2;
				float target3=list.get(a).getCollectionTarget();
				target3SumOfList=target3SumOfList+target3;
			}
			monthTarget.setMonth(1);
			monthTarget.setContractAmount(targetSumOfList);
			monthTarget.setRevenueTarget(target2SumOfList);
			monthTarget.setCollectionTarget(target3SumOfList);
			targetArray.add(monthTarget);
			
			MonthTarget monthTarget2=new MonthTarget();
			float targetSumOfList2=0;
			float target2SumOfList2=0;
			float target3SumOfList2=0;
			List<MonthTarget> list2=mservice.selectMonthTargetByMonthSum(id, 2);
			for(int a=0;a<list2.size();a++){
				float target=list2.get(a).getContractAmount();
				targetSumOfList2=targetSumOfList2+target;
				float target2=list2.get(a).getRevenueTarget();
				target2SumOfList2=target2SumOfList2+target2;
				float target3=list2.get(a).getCollectionTarget();
				target3SumOfList2=target3SumOfList2+target3;
			}
			monthTarget2.setMonth(2);
			monthTarget2.setContractAmount(targetSumOfList2);
			monthTarget2.setRevenueTarget(target2SumOfList2);
			monthTarget2.setCollectionTarget(target3SumOfList2);
			targetArray.add(monthTarget2);
			
			MonthTarget monthTarget3=new MonthTarget();
			float targetSumOfList3=0;
			float target2SumOfList3=0;
			float target3SumOfList3=0;
			List<MonthTarget> list3=mservice.selectMonthTargetByMonthSum(id, 3);
			for(int a=0;a<list3.size();a++){
				float target=list3.get(a).getContractAmount();
				targetSumOfList3=targetSumOfList3+target;
				float target2=list3.get(a).getRevenueTarget();
				target2SumOfList3=target2SumOfList3+target2;
				float target3=list3.get(a).getCollectionTarget();
				target3SumOfList3=target3SumOfList3+target3;
			}
			monthTarget3.setMonth(3);
			monthTarget3.setContractAmount(targetSumOfList3);
			monthTarget3.setRevenueTarget(target2SumOfList3);
			monthTarget3.setCollectionTarget(target3SumOfList3);
			targetArray.add(monthTarget3);
			
			MonthTarget monthTarget4=new MonthTarget();
			float targetSumOfList4=0;
			float target2SumOfList4=0;
			float target3SumOfList4=0;
			List<MonthTarget> list4=mservice.selectMonthTargetByMonthSum(id, 4);
			for(int a=0;a<list4.size();a++){
				float target=list4.get(a).getContractAmount();
				targetSumOfList4=targetSumOfList4+target;
				float target2=list4.get(a).getRevenueTarget();
				target2SumOfList4=target2SumOfList4+target2;
				float target3=list4.get(a).getCollectionTarget();
				target3SumOfList4=target3SumOfList4+target3;
			}
			monthTarget4.setMonth(4);
			monthTarget4.setContractAmount(targetSumOfList4);
			monthTarget4.setRevenueTarget(target2SumOfList4);
			monthTarget4.setCollectionTarget(target3SumOfList4);
			targetArray.add(monthTarget4);
			
			MonthTarget monthTarget5=new MonthTarget();
			float targetSumOfList5=0;
			float target2SumOfList5=0;
			float target3SumOfList5=0;
			List<MonthTarget> list5=mservice.selectMonthTargetByMonthSum(id, 5);
			for(int a=0;a<list5.size();a++){
				float target=list5.get(a).getContractAmount();
				targetSumOfList5=targetSumOfList5+target;
				float target2=list5.get(a).getRevenueTarget();
				target2SumOfList5=target2SumOfList5+target2;
				float target3=list5.get(a).getCollectionTarget();
				target3SumOfList5=target3SumOfList5+target3;
			}
			monthTarget5.setMonth(5);
			monthTarget5.setContractAmount(targetSumOfList5);
			monthTarget5.setRevenueTarget(target2SumOfList5);
			monthTarget5.setCollectionTarget(target3SumOfList5);
			targetArray.add(monthTarget5);
			
			MonthTarget monthTarget6=new MonthTarget();
			float targetSumOfList6=0;
			float target2SumOfList6=0;
			float target3SumOfList6=0;
			List<MonthTarget> list6=mservice.selectMonthTargetByMonthSum(id, 6);
			for(int a=0;a<list6.size();a++){
				float target=list6.get(a).getContractAmount();
				targetSumOfList6=targetSumOfList6+target;
				float target2=list6.get(a).getRevenueTarget();
				target2SumOfList6=target2SumOfList6+target2;
				float target3=list6.get(a).getCollectionTarget();
				target3SumOfList6=target3SumOfList6+target3;
			}
			monthTarget6.setMonth(6);
			monthTarget6.setContractAmount(targetSumOfList6);
			monthTarget6.setRevenueTarget(target2SumOfList6);
			monthTarget6.setCollectionTarget(target3SumOfList6);
			targetArray.add(monthTarget6);
			
			MonthTarget monthTarget7=new MonthTarget();
			float targetSumOfList7=0;
			float target2SumOfList7=0;
			float target3SumOfList7=0;
			List<MonthTarget> list7=mservice.selectMonthTargetByMonthSum(id, 7);
			for(int a=0;a<list7.size();a++){
				float target=list7.get(a).getContractAmount();
				targetSumOfList7=targetSumOfList7+target;
				float target2=list7.get(a).getRevenueTarget();
				target2SumOfList7=target2SumOfList7+target2;
				float target3=list7.get(a).getCollectionTarget();
				target3SumOfList7=target3SumOfList7+target3;
			}
			monthTarget7.setMonth(7);
			monthTarget7.setContractAmount(targetSumOfList7);
			monthTarget7.setRevenueTarget(target2SumOfList7);
			monthTarget7.setCollectionTarget(target3SumOfList7);
			targetArray.add(monthTarget7);
			
			MonthTarget monthTarget8=new MonthTarget();
			float targetSumOfList8=0;
			float target2SumOfList8=0;
			float target3SumOfList8=0;
			List<MonthTarget> list8=mservice.selectMonthTargetByMonthSum(id, 8);
			for(int a=0;a<list8.size();a++){
				float target=list8.get(a).getContractAmount();
				targetSumOfList8=targetSumOfList8+target;
				float target2=list8.get(a).getRevenueTarget();
				target2SumOfList8=target2SumOfList8+target2;
				float target3=list8.get(a).getCollectionTarget();
				target3SumOfList8=target3SumOfList8+target3;
			}
			monthTarget8.setMonth(8);
			monthTarget8.setContractAmount(targetSumOfList8);
			monthTarget8.setRevenueTarget(target2SumOfList8);
			monthTarget8.setCollectionTarget(target3SumOfList8);
			targetArray.add(monthTarget8);
			
			MonthTarget monthTarget9=new MonthTarget();
			float targetSumOfList9=0;
			float target2SumOfList9=0;
			float target3SumOfList9=0;
			List<MonthTarget> list9=mservice.selectMonthTargetByMonthSum(id, 9);
			for(int a=0;a<list9.size();a++){
				float target=list9.get(a).getContractAmount();
				targetSumOfList9=targetSumOfList9+target;
				float target2=list9.get(a).getRevenueTarget();
				target2SumOfList9=target2SumOfList9+target2;
				float target3=list9.get(a).getCollectionTarget();
				target3SumOfList9=target3SumOfList9+target3;
			}
			monthTarget9.setMonth(9);
			monthTarget9.setContractAmount(targetSumOfList9);
			monthTarget9.setRevenueTarget(target2SumOfList9);
			monthTarget9.setCollectionTarget(target3SumOfList9);
			targetArray.add(monthTarget9);
			
			MonthTarget monthTarget10=new MonthTarget();
			float targetSumOfList10=0;
			float target2SumOfList10=0;
			float target3SumOfList10=0;
			List<MonthTarget> list10=mservice.selectMonthTargetByMonthSum(id, 10);
			for(int a=0;a<list10.size();a++){
				float target=list10.get(a).getContractAmount();
				targetSumOfList10=targetSumOfList10+target;
				float target2=list10.get(a).getRevenueTarget();
				target2SumOfList10=target2SumOfList10+target2;
				float target3=list10.get(a).getCollectionTarget();
				target3SumOfList10=target3SumOfList10+target3;
			}
			monthTarget10.setMonth(10);
			monthTarget10.setContractAmount(targetSumOfList10);
			monthTarget10.setRevenueTarget(target2SumOfList10);
			monthTarget10.setCollectionTarget(target3SumOfList10);
			targetArray.add(monthTarget10);
			
			MonthTarget monthTarget11=new MonthTarget();
			float targetSumOfList11=0;
			float target2SumOfList11=0;
			float target3SumOfList11=0;
			List<MonthTarget> list11=mservice.selectMonthTargetByMonthSum(id, 11);
			for(int a=0;a<list11.size();a++){
				float target=list11.get(a).getContractAmount();
				targetSumOfList11=targetSumOfList11+target;
				float target2=list11.get(a).getRevenueTarget();
				target2SumOfList11=target2SumOfList11+target2;
				float target3=list11.get(a).getCollectionTarget();
				target3SumOfList11=target3SumOfList11+target3;
			}
			monthTarget11.setMonth(11);
			monthTarget11.setContractAmount(targetSumOfList11);
			monthTarget11.setRevenueTarget(target2SumOfList11);
			monthTarget11.setCollectionTarget(target3SumOfList11);
			targetArray.add(monthTarget11);
			
			MonthTarget monthTarget12=new MonthTarget();
			float targetSumOfList12=0;
			float target2SumOfList12=0;
			float target3SumOfList12=0;
			List<MonthTarget> list12=mservice.selectMonthTargetByMonthSum(id, 12);
			for(int a=0;a<list12.size();a++){
				float target=list12.get(a).getContractAmount();
				targetSumOfList12=targetSumOfList12+target;
				float target2=list12.get(a).getRevenueTarget();
				target2SumOfList12=target2SumOfList12+target2;
				float target3=list12.get(a).getCollectionTarget();
				target3SumOfList12=target3SumOfList12+target3;
			}
			monthTarget12.setMonth(12);
			monthTarget12.setContractAmount(targetSumOfList12);
			monthTarget12.setRevenueTarget(target2SumOfList12);
			monthTarget12.setCollectionTarget(target3SumOfList12);
			targetArray.add(monthTarget12);
		}
		return targetArray;
	}
	
}
