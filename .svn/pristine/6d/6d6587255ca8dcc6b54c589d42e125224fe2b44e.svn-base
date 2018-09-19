package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.OutTrain;
import org.ldxx.service.OutTrainService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("outTrain")
public class OutTrainController {

	@Autowired
	private OutTrainService oservice;
	
	@RequestMapping("/addOutTrainBySave")
	@ResponseBody
	public int addOutTrainBySave(OutTrain outTrain){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		outTrain.setOtId(id);
		int i=oservice.addOutTrain(outTrain);
		return i;
	}
	
	@RequestMapping("/addOutTrainBySubmit")
	@ResponseBody
	public int addOutTrainBySubmit(OutTrain outTrain){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		outTrain.setOtId(id);
		int i=oservice.addOutTrain(outTrain);
		return i;
	}
	
	
	@RequestMapping("/deleteOutTrain")
	@ResponseBody
	public int deleteOutTrain(String id){
		return oservice.deleteOutTrain(id);
	}
	
	
	@RequestMapping("/updateOutTrainBySave")
	@ResponseBody
	public int updateOutTrainBySave(OutTrain outTrain){
		return oservice.updateOutTrain(outTrain);
	}
	
	@RequestMapping("/updateOutTrainBySubmit")
	@ResponseBody
	public int updateOutTrainBySubmit(OutTrain outTrain){
		return oservice.updateOutTrain(outTrain);
	}
	
	
	@RequestMapping("/selectOutTrain")
	@ResponseBody
	public List<OutTrain> selectOutTrain(){
		return oservice.selectOutTrain();
	}
}
