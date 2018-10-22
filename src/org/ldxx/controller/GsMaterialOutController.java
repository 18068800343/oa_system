package org.ldxx.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.dao.CgContractDao;
import org.ldxx.service.GsClOutService;
import org.ldxx.service.GsMaterialOutService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公司材料出库
 * @author hp
 *
 */

@RequestMapping("gsMaterialOut")
@Controller
public class GsMaterialOutController {
	
	@Autowired
	private GsMaterialOutService service;
	@Autowired
	private GsClOutService gservice;
	@Autowired
	private CgContractDao cdao;
	
	@RequestMapping("/selectGsMaterialOut")
	@ResponseBody
	public List<CompanyMateriaOut> selectGsMaterialOut(){
		return service.selectGsMaterialOut();
	}
	
	
	@RequestMapping("/addGsMaterialOutSave")
	@ResponseBody
	public Map<String,Object> addGsMaterialOutSave(@RequestBody List<CompanyMateriaOut> cm){
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id = uuid.getTimeUUID();
		CompanyMateriaOut materiaOut = cm.get(0);
		materiaOut.setCmoId(id);
		int i=service.addGsMaterialOutSave(materiaOut);
		map.put("result", i);
		map.put("CompanyMateriaOut", materiaOut);
		return map;
	}
	
	@RequestMapping("/selectXmMaterialOutByNo")
	@ResponseBody
	public List<CompanyMateriaOut> selectXmMaterialOutByNo(String no){
		List<CompanyMateriaOut> list=service.selectXmMaterialOutByNo(no);
		return list;
	}
	
	@RequestMapping("/selectAllXmMaterialOut")
	@ResponseBody
	public List<CompanyMateriaOut> selectAllXmMaterialOut(){
		List<CompanyMateriaOut> list=service.selectAllXmMaterialOut();
		return list;
	}
	
	
	@RequestMapping("/selectNoByName")
	@ResponseBody
	public Map<String,Object> selectNoByName(String name){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNoByName(name);
		List<GsClOut> list=gservice.selectClListByName(name);
		map.put("cmList", list);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectNameByNo")
	@ResponseBody
	public Map<String,Object> selectNameByNo(String no){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNameByNo(no);
		List<GsClOut> list=gservice.selectClListByNo(no);
		map.put("cmList", list);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/updateStatus")
	@ResponseBody
	public int updateStatus(CompanyMateriaOut out,@RequestParam MultipartFile [] file){
		String id=out.getCmoId();
		if(file!=null){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"oa"+File.separator+"CompanyMateriaOut"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String acUrl=url+File.separator+acName;
				File acFile=new File(acUrl);
				accessory.setaId(id);
				accessory.setAcName(acName);
				accessory.setAcUrl(acUrl);
				list.add(accessory);
				try {
					file[i].transferTo(acFile);
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
			out.setAccessory(list);
		}
		int i=service.updateStatus(out);
		return i;
	}
	
	@RequestMapping("/selectCompanyMateriaOutForEnd")
	@ResponseBody
	public List<CompanyMateriaOut> selectCompanyMateriaOutForEnd(String no){
		List<CompanyMateriaOut> list=service.selectCompanyMateriaOutForEnd(no);
		return list;
	}

	@RequestMapping("/selectCompanyMateriaOutForWaste")
	@ResponseBody
	public List<CompanyMateriaOut> selectCompanyMateriaOutForWaste(String no){
		List<CompanyMateriaOut> list=service.selectCompanyMateriaOutForWaste(no);
		return list;
	}
	
	@RequestMapping("/selectCgIdAndName")
	@ResponseBody
	public List<CompanyMateriaOut> selectCgIdAndName(){
		List<CompanyMateriaOut> list=service.selectCgIdAndName();
		return list;
	}
	
	@RequestMapping("/selectCgListByName")
	@ResponseBody
	public Map<String,Object> selectCgListByName(String name){
		Map<String,Object> map=new HashMap<>();
		List<CgContract> cg=cdao.getCGNoByName(name);
		List<CompanyMateriaOut> cm=service.selectTaskByName(name);
		map.put("cg", cg);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectCgListByNo")
	@ResponseBody
	public Map<String,Object> selectCgListByNo(String no){
		Map<String,Object> map=new HashMap<>();
		List<CgContract> cg=cdao.getCGNameByNo(no);
		List<CompanyMateriaOut> cm=service.selectTaskByNo(no);
		map.put("cg", cg);
		map.put("cm", cm);
		return map;
	}
	
	@RequestMapping("/selectPrjNoAndCl")
	@ResponseBody
	public Map<String,Object> selectPrjNoAndCl(String cgNo,String cgName,String name){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNoByName(name);
		List<GsClOut> gc=gservice.selectClListByIds2(cgNo, cgName, name);
		map.put("cm", cm);
		map.put("gc", gc);
		return map;
	}
	
	@RequestMapping("/selectPrjNameAndCl")
	@ResponseBody
	public Map<String,Object> selectPrjNameAndCl(String cgNo,String cgName,String no){
		Map<String,Object> map=new HashMap<>();
		CompanyMateriaOut cm=service.selectNameByNo(no);
		List<GsClOut> gc=gservice.selectClListByIds(cgNo, cgName, no);
		map.put("cm", cm);
		map.put("gc", gc);
		return map;
	}
}
