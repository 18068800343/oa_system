package org.ldxx.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.CgCl;
import org.ldxx.bean.CgContract;
import org.ldxx.bean.CompanyMateriaIn;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.CompanyMaterialInCl;
import org.ldxx.bean.CurrentFlow;
import org.ldxx.bean.FlowHistroy;
import org.ldxx.bean.OrganizationManagement;
import org.ldxx.bean.Task;
import org.ldxx.bean.User;
import org.ldxx.bean.clfbCgcontractPerformance;
import org.ldxx.service.GsMaterialInService;
import org.ldxx.util.ExportData;
import org.ldxx.util.FlowUtill;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import net.sf.json.JSONObject;

/**
 * 公司材料入库
 * @author hp
 *
 */
@RequestMapping("gsMaterialIn")
@Controller
public class GsMaterialInController {
	
	@Autowired
	private GsMaterialInService gmService;
	
	@RequestMapping("/getGsMaterialIn")//初始化所有的信息
	@ResponseBody
	public List<CompanyMateriaIn> getGsMaterialIn(){
		return gmService.getGsMaterialIn();
	}
	
	@RequestMapping("/selectGsMaterialIn")//通过出库状态查找信息
	@ResponseBody
	public List<CompanyMateriaIn> selectGsMaterialIn(String outState){
		return gmService.selectGsMaterialIn(outState);
	}
	
	@RequestMapping("/addGsMaterialInSave")//添加保存
	@ResponseBody
	public Map<String,Object> addGsMaterialInSave(String gsclIn,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("gsInCl", CompanyMaterialInCl.class);
		map2.put("accessory", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(gsclIn);
		CompanyMateriaIn cm=(CompanyMateriaIn) JSONObject.toBean(jsonObject, CompanyMateriaIn.class,map2);
		
		Map<String,Object> map=new HashMap<>();
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cm.setCmId(id);
		
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("公司材料收货单");
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.addGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	
	
	@RequestMapping("/addGsMaterialInSubmit")//添加提交
	@ResponseBody
	public Map<String,Object> addGsMaterialInSubmit(String gsclIn,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Object> map=new HashMap<>();
		Map<String,Class> map2=new HashMap<>();
		map2.put("gsInCl", CompanyMaterialInCl.class);
		map2.put("accessory", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(gsclIn);
		CompanyMateriaIn cm=(CompanyMateriaIn)JSONObject.toBean(jsonObject, CompanyMateriaIn.class,map2);
		
		TimeUUID uuid=new TimeUUID();
		String id=uuid.getTimeUUID();
		cm.setCmId(id);
		
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(path);
				if(!f.exists()){
					f.mkdirs();
				}
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("公司材料收货单");
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.addGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	
	@RequestMapping("/updateGsMaterialInSave")//修改保存
	@ResponseBody
	public Map<String,Object> updateGsMaterialInSave(String gsclIn,@RequestParam("file") MultipartFile [] file) throws IllegalStateException, IOException{
		Map<String,Class> map2=new HashMap<>();
		map2.put("gsInCl", CompanyMaterialInCl.class);
		map2.put("accessory", Accessory.class);
		JSONObject jsonObject=JSONObject.fromObject(gsclIn);
		CompanyMateriaIn cm=(CompanyMateriaIn)JSONObject.toBean(jsonObject, CompanyMateriaIn.class,map2);
		
		Map<String,Object> map=new HashMap<>();
		String id = cm.getCmId();
		String path="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
		File f=new File(path);
		if(!f.exists()){
			f.mkdirs();
		}
		if(file.length>0){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String fileName=file[i].getOriginalFilename();
				String filePath=path+File.separator+fileName;
				File f2=new File(filePath);
				file[i].transferTo(f2);
				accessory.setaId(id);
				accessory.setAcName(fileName);
				accessory.setAcUrl(filePath);
				accessory.setaType("公司材料收货单");
				list.add(accessory);
			}
			cm.setAccessory(list);
		}
		int i=gmService.updateGsMaterialInSave(cm);
		map.put("result", i);
		map.put("CompanyMateriaIn", cm);
		return map;
	}
	
	@RequestMapping("/selectGsClInById")
	@ResponseBody
	public CompanyMateriaIn selectGsClInById(String id){
		return gmService.selectGsClInById(id);
	}
	
	
	@RequestMapping("/updateOutStateById")//通过id修改出库状态
	@ResponseBody
	public int updateOutStateById(String id,String outstate){
		return gmService.updateOutStateById(id,outstate);
	}
	
	@RequestMapping("/selectXmMaterialByNo")//通过任务单号和出库状态查找项目材料信息(公司出库)
	@ResponseBody
	public List<CompanyMateriaIn> selectXmMaterialByNo(String taskNo,String outstate){
		String no="%"+taskNo+"%";
		return gmService.selectXmMaterialByNo(no,outstate);
	}
	
	@RequestMapping("/selectXmInByNo")//通过任务单号、出库状态以及当前登录人的部门查找项目材料信息(项目入库列表用到,联查项目的主协办部门只要包含当前人的部门就能查看)
	@ResponseBody
	public List<CompanyMateriaIn> selectXmInByNo(String taskNo,String outstate,HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		String no="%"+taskNo+"%";
		return gmService.selectXmInByNo(no,outstate,useromId);
	}
	
	@RequestMapping("/updateXmState")//项目入库的收货确认
	@ResponseBody
	public int updateXmState(CompanyMateriaIn gsIncl,@RequestParam MultipartFile [] file){
		String id=gsIncl.getCmId();
		if(file!=null){
			List<Accessory> list=new ArrayList<>();
			for(int i=0;i<file.length;i++){
				Accessory accessory=new Accessory();
				String acName=file[i].getOriginalFilename();
				String url="D:"+File.separator+"oa"+File.separator+"gsMaterialIn"+File.separator+id;
				File f=new File(url);
				if(!f.exists()){
					f.mkdirs();
				}
				String acUrl=url+File.separator+acName;
				File acFile=new File(acUrl);
				accessory.setaId(id);
				accessory.setAcName(acName);
				accessory.setAcUrl(acUrl);
				accessory.setaType("项目材料收货单");
				list.add(accessory);
				try {
					file[i].transferTo(acFile);
				} catch (Exception e) {
					e.printStackTrace();
					return 0;
				}
			}
			gsIncl.setAccessory(list);
		}
		int i=gmService.updateXmState(gsIncl);
		return i;
	}
	
	@RequestMapping("/selectAllXmReceivedGoods")//获取项目材料已收货的项目名及合同名(材料出库用到)
	@ResponseBody
	public List<CompanyMateriaIn> selectAllXmReceivedGoods(HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		return gmService.selectAllXmReceivedGoods(useromId);
	}
	
	@RequestMapping("/selectAlearyRemain")//获取已结余的所有项目信息
	@ResponseBody
	public List<CompanyMateriaIn> selectAlearyRemain(){
		return gmService.selectAlearyRemain();
	}
	
	
	@RequestMapping("/selectGsClInBytaskNo")//通过任务单号查找公司已经出库和项目已收货的材料信息（材料出库用到）
	@ResponseBody
	public List<CompanyMaterialInCl> selectGsClInBytaskNo(String no){
		return gmService.selectGsClInBytaskNo(no);
	}
	
	@RequestMapping("/selectMateriaOutForEnd")//通过任务单号和结余状态来获取项目材料已收货的所有项目（项目材料结余用到）
	@ResponseBody
	public List<CompanyMateriaIn> selectMateriaOutForEnd(String taskno,String type,HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		String no="%"+taskno+"%";
		return gmService.selectMateriaOutForEnd(no,type,useromId);
	}
	
	@RequestMapping("/selectGsMateriaOutForEnd")//通过任务单号和remainType!=0获取项目材料已收货的所有项目(公司材料结余)
	@ResponseBody
	public List<CompanyMateriaIn> selectGsMateriaOutForEnd(String taskno){
		String no="%"+taskno+"%";
		return gmService.selectGsMateriaOutForEnd(no);
	}
	
	@RequestMapping("/selectGsMateriaOutForEnd2")//通过任务单号和remainType!=0获取项目材料已收货的所有项目(项目材料结余已结余用到)
	@ResponseBody
	public List<CompanyMateriaIn> selectGsMateriaOutForEnd2(String taskno,HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		String no="%"+taskno+"%";
		return gmService.selectGsMateriaOutForEnd2(no,useromId);
	}
	
	
	@RequestMapping("/selectGsRemainOut")//通过outState和getStatus和remainType三种状态查询信息(公司材料结余可转出的)
	@ResponseBody
	public List<CompanyMateriaIn> selectGsRemainOut(String outState,String getStatus,String remainType){
		return gmService.selectGsRemainOut(outState,getStatus,remainType);
	}
	
	@RequestMapping("/updateremainType")//公司结余确认
	@ResponseBody
	public int updateremainType(String id,String type){
		return gmService.updateremainType(id,type);
	}
	
	
	@RequestMapping("/selectcgNotaskNoPrjName")//初始化采购合同号、采购合同名、任务单号、项目名 
	@ResponseBody
	public List<CompanyMateriaIn> selectcgNotaskNoPrjName(){
		return gmService.selectcgNotaskNoPrjName();
	}
	
	@RequestMapping("/selecttaskNoPrjNameBycgNo")//通过采购合同号查找采购合同名、任务单号、项目名 、材料名称、材料类型、规格型号、单位、金额
	@ResponseBody
	public List<CompanyMateriaIn> selecttaskNoPrjNameBycgNo(String cgNo){
		return gmService.selecttaskNoPrjNameBycgNo(cgNo);
	}
	
	@RequestMapping("/selectcgNotaskNoPrjNameBycgName")//通过采购合同名查找采购合同号、任务单号、项目名 、材料名称、材料类型、规格型号、单位、金额
	@ResponseBody
	public List<CompanyMateriaIn> selectcgNotaskNoPrjNameBycgName(String cgName){
		return gmService.selectcgNotaskNoPrjNameBycgName(cgName);
	}
	
	/*@RequestMapping("/updateMaterialbuyUnitAndManufacturer")//修改材料的来货单位及生产厂家
	@ResponseBody
	public int updateMaterialbuyUnitAndManufacturer(String id,String unit,String manufacturer){
		return gmService.updateMaterialbuyUnitAndManufacturer(id,unit,manufacturer);
	}*/
	
	@RequestMapping("/selectBytaskNo")//通过任务单的得到运费和id,再通过id 查材料费用
	@ResponseBody
	public List<CompanyMateriaIn> selectBytaskNo(String no){
		no="%"+no+"%";
		return gmService.selectBytaskNo(no);
	}
	
	@RequestMapping("/selectByoutStateAndgetState")//通过出库状态和确认收货状态来查(公司出库用到)
	@ResponseBody
	public List<CompanyMateriaIn> selectByoutStateAndgetState(String outstate,String getstate){
		return gmService.selectByoutStateAndgetState(outstate,getstate);
	}
	
	@RequestMapping("/selectBygetDepartment")//通过部门来查询项目入库已收货的信息(统计花销部门有用到)
	@ResponseBody
	public List<CompanyMateriaIn> selectBygetDepartment(String getDepartment){
		getDepartment="%"+getDepartment+"%";
		return gmService.selectBygetDepartment(getDepartment);
	}
	
	@RequestMapping("/selectAlreadySure")//项目材料入库的已确认收货
	@ResponseBody
	public List<CompanyMateriaIn> selectAlreadySure(String getstate,HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		return gmService.selectAlreadySure(getstate,useromId);
	}
	
	@RequestMapping("/selectXmInBybm")//通过部门来查询当前登录人的部门查找项目材料信息(项目入库列表用到,联查项目的主协办部门只要包含当前人的部门就能查看)
	@ResponseBody
	public List<CompanyMateriaIn> selectXmInBybm(String getDepartment,HttpSession session){
		User user = (User) session.getAttribute("user");
		String useromId=user.getOmId();
		getDepartment="%"+getDepartment+"%";
		return gmService.selectXmInBybm(getDepartment,useromId);
	}
	
}
