package org.ldxx.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.BorrowContract;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CgOtherContract;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjSplitMoney;
import org.ldxx.bean.Enterprise;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.LianYing;
import org.ldxx.bean.Task;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.BorrowContractService;
import org.ldxx.service.CgContractService;
import org.ldxx.service.CgOtherContractService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.LianYingService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("showDetailsPanel")
public class ShowDetails {
	
	@Autowired
	private TaskService tService;
	@Autowired
	private EnterpriseDao edao;
	@Autowired
	private CjContractService cjCService;
	@Autowired
	private CjContractDao cjCdao;
	@Autowired
	private SubContractService scService;
	@Autowired
	private CgContractService cgcService;
	@Autowired
	private CgOtherContractService cgocService;
	@Autowired
	private BorrowContractService borrowservice;
	@Autowired
	private LianYingService lianYingservice;
	
	
	@RequestMapping("/task")
	@ResponseBody
	public Map<String,Object> selectTaskByPrjNo(String prjNo){
		Map<String,Object> map = new HashMap<String,Object>();
		String prjId=tService.selectIdByTaskNo(prjNo);
		Task task = tService.selectTaskById(prjId);
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		List<Enterprise> enterprise;
		if(null!=task){
			enterprise=edao.selectEnterpriseById(task.getPrjId());
			result = 1;
			if(null!=enterprise)
			{
				task.setEnterprise(enterprise);
			}
			map.put("task",task);
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
	
	@RequestMapping("/cjContract")
	@ResponseBody
	public Map<String,Object> selectcjContractByPrjNo(String cjCNo){
		Map<String,Object> map = new HashMap<String,Object>();
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		List<CjSplitMoney> list;
		CjContract cjc=cjCService.selectCjByCjNo(cjCNo);
		if(null!=cjc)
		{
			list = cjCdao.selectCjSplitMoneyById(cjc.getCjId());
			if(null!=list){
				cjc.setCjSplitMoney(list);
			}
			map.put("cjc",cjc);
			result = 1;
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
	
	
	@RequestMapping("/fbContract")
	@ResponseBody
	public Map<String,Object> selectfbContractByPrjNo(String fbNo){
		Map<String,Object> map = new HashMap<String,Object>();
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		FbContract fbc=scService.selectFbContractShowByFbNo(fbNo);
		if(null!=fbc)
		{
			map.put("fbc",fbc);
			result=1;
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
	
	
	@RequestMapping("/cgContract")
	@ResponseBody
	public Map<String,Object> selectcgContractByPrjNo(String cgNo){
		Map<String,Object> map = new HashMap<String,Object>();
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		CgContract cgc = cgcService.selectCgContractShowByCgNo(cgNo);
		if(null!=cgc)
		{
			map.put("cgc",cgc);
			result=1;
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
	@RequestMapping("/cgoContract")
	@ResponseBody
	public Map<String,Object> selectcgoContractByPrjNo(String cgoNo){
		Map<String,Object> map = new HashMap<String,Object>();
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		CgOtherContract cgoc = cgocService.selectCgOtherContractShowByCgoNo(cgoNo);
		if(null!=cgoc)
		{
			map.put("cgoc",cgoc);
			result=1;
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
	
	@RequestMapping("/getBorrowContractBybNo")//通过借款合同号查
	@ResponseBody
	public BorrowContract getBorrowContractBybNo(String bno){
		return borrowservice.getBorrowContractBybNo(bno);
	}
	
	@RequestMapping("/selectLianYingByNo")
	@ResponseBody
	public Map<String,Object> selectLianYingByNo(String no){
		Map<String,Object> map = new HashMap<String,Object>();
		LianYing ly=lianYingservice.getLianYingBylyNo(no);
		//设定个返回值，1为成功，0为失败，-1为未找到编号数据
		int result = 0; 
		if(null!=ly)
		{
			map.put("ly",ly);
			result=1;
		}else{
			result = -1;
		}
		map.put("result", result);
		return map;
	}
}
