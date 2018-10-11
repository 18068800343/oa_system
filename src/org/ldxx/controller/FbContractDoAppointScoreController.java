package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.FbContractDoAppointScore;
import org.ldxx.service.FbContractDoAppointScoreService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fbScore")
public class FbContractDoAppointScoreController {

	@Autowired
	private FbContractDoAppointScoreService service;
	
	@RequestMapping("addFbContractDoAppointScoreBySave")
	@ResponseBody
	public int addFbContractDoAppointScoreBySave(FbContractDoAppointScore FbContractDoAppoint){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		FbContractDoAppoint.setFcdId(id);
		int i=service.addFbContractDoAppointScore(FbContractDoAppoint);
		return i;
	}
	
	@RequestMapping("addFbContractDoAppointScoreBySubmit")
	@ResponseBody
	public int addFbContractDoAppointScoreBySubmit(FbContractDoAppointScore FbContractDoAppoint){
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		FbContractDoAppoint.setFcdId(id);
		int i=service.addFbContractDoAppointScore(FbContractDoAppoint);
		return i;
	}
	
	@RequestMapping("selectFbContractDoAppointScore")
	@ResponseBody
	public List<FbContractDoAppointScore> selectFbContractDoAppointScore(){
		return service.selectFbContractDoAppointScore();
	}
	
}
