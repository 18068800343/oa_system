package org.ldxx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.CjContract;
import org.ldxx.bean.KpApplication;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.Task;
import org.ldxx.service.CjContractService;
import org.ldxx.service.KpApplicationService;
import org.ldxx.service.PrjProgressFillService;
import org.ldxx.service.TaskService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("kp")
public class KpApplicationController {

	@Autowired
	private KpApplicationService service;
	@Autowired
	private PrjProgressFillService pService;
	@Autowired
	private TaskService tService;
	@Autowired
	private CjContractService cService;
	
	@RequestMapping("/addKpApplicationBySave")
	@ResponseBody
	public int addKpApplicationBySave(KpApplication kp){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int i=service.addKpApplication(kp);
		return i;
	}
	
	@RequestMapping("/addKpApplicationBySubmit")
	@ResponseBody
	public int addKpApplicationBySubmit(KpApplication kp){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		kp.setKpId(id);
		int i=service.addKpApplication(kp);
		return i;
	}
	
	@RequestMapping("/selectKpApplication")
	@ResponseBody
	public List<KpApplication> selectKpApplication(String status){
		 List<KpApplication> list=service.selectKpApplication(status);
		 return list;
	}
	
	@RequestMapping("/getAllMoney")
	@ResponseBody
	public float getAllMoney(String contractNo,String prjNo){
		float all=service.getAllMoney(contractNo, prjNo);
		return all;
	}
	
	@RequestMapping("/buleFpNo")
	@ResponseBody
	public int buleFpNo(String no,String id){
		int i=service.buleFpNo(no, id);
		return i;
	}
	
	@RequestMapping("/getKpNo")
	@ResponseBody
	public List<KpApplication> getKpNo(String no){
		List<KpApplication> list=service.getKpNo(no);
		return list;
	}
	
	@RequestMapping("/getAllKpMoneyByFpNo")
	@ResponseBody
	public KpApplication getAllKpMoneyByFpNo(String no){
		KpApplication kp=service.getAllKpMoneyByFpNo(no);
		return kp;
	}
	
	@RequestMapping("/getPrjPlan")
	@ResponseBody
	public Map<String,Object> getPrjPlan(String nos,String contractNo){
		Map<String,Object> map=new HashMap<String, Object>();
		String jindu="";
		float jd=0; 
		if(nos.indexOf(",")>0){
			float sumMoney=0;
			CjContract cj=cService.selectCjContractByNo(contractNo);
			float contractMoney=cj.getContractMoney();
			for(int i=0;i<nos.split(",").length;i++){
				PrjProgressFill pf=pService.selectLastPrjProgressFill(nos.split(",")[i]);
				Task t=tService.selectIdByNo(nos.split(",")[i]);
				float prjMoney=t.getPrjEstimateMoney();
				String allMoney=pf.getAllMoney().replace("%", "");
				float am=Float.valueOf(allMoney);
				sumMoney=sumMoney+(prjMoney*am)/100;
			}
			float jd2=(sumMoney/contractMoney)*100;
			jindu=jd2+"%";
		}else{
			PrjProgressFill pf=pService.selectLastPrjProgressFill(nos);
			jindu=pf.getAllMoney();
		}
		map.put("jindu", jindu);
		return map;
	}
	
}
