package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.OutTrainAll;
import org.ldxx.service.OutTrainAllService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("OutTrainAll")
public class OutTrainAllController {

	@Autowired
	private OutTrainAllService oservice;
	
	@RequestMapping("/addOutTrainAllBySave")
	@ResponseBody
	public int addOutTrainAllBySave(OutTrainAll trainAll){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		trainAll.setOtaId(id);
		return oservice.addOutTrainAll(trainAll);
	}
	
	@RequestMapping("/addOutTrainAllBySubmit")
	@ResponseBody
	public int addOutTrainAllBySubmit(OutTrainAll trainAll){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		trainAll.setOtaId(id);
		return oservice.addOutTrainAll(trainAll);
	}
	
	@RequestMapping("/deleteOutTrainAll")
	@ResponseBody
	public int deleteOutTrainAll(String id){
		return oservice.deleteOutTrainAll(id);
	}
	
	
	@RequestMapping("/updateOutTrainAllBySave")
	@ResponseBody
	public int updateOutTrainAllBySave(OutTrainAll trainAll){
		return oservice.updateOutTrainAll(trainAll);
	}
	
	@RequestMapping("/updateOutTrainAllBySubmit")
	@ResponseBody
	public int updateOutTrainAllBySubmit(OutTrainAll trainAll){
		return oservice.updateOutTrainAll(trainAll);
	}
	
	@RequestMapping("/selectOutTrainAll")
	@ResponseBody
	public List<OutTrainAll> selectOutTrainAll(){
		return oservice.selectOutTrainAll();
	}
}
