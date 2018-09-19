package org.ldxx.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.ldxx.bean.Supplier;
import org.ldxx.service.SupplierService;
import org.ldxx.util.ExportData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: SupplierController 
* @Description: 供应商
* @author ailun
* @date 2018年8月13日 下午4:13:30 
*  
*/
@RequestMapping("supplier")
@Controller
public class SupplierController {

	@Autowired
	private SupplierService sService;
	
	@RequestMapping("/addSupplier")
	@ResponseBody
	public int addSupplier(@RequestBody List<Supplier> supplier){
		Supplier su=supplier.get(0);
		return sService.addSupplier(su);
	}
	
	@RequestMapping("/deleteSupplier")
	@ResponseBody
	public int deleteSupplier(String id){
		return sService.deleteSupplier(id);
	}
	
	@RequestMapping("/updateSupplier")
	@ResponseBody
	public int updateSupplier(@RequestBody List<Supplier> supplier){
		Supplier su=supplier.get(0);
		return sService.updateSupplier(su);
	}
	
	@RequestMapping("/selectAllSupplier")
	@ResponseBody
	public List<Supplier> selectAllSupplier(){
		return sService.selectAllSupplier();
	}
	
	@RequestMapping("/selectOneSupplier")
	@ResponseBody
	public Supplier selectOneSupplier(String id){
		return sService.selectOneSupplier(id);
	}
	
	@RequestMapping("/exportSupplier")
	@ResponseBody
	public void exportSupplier(HttpServletResponse response) throws Exception{
		String xlsName = "供应商信息表";  
		ExportData exportData=new ExportData();
		List<Supplier> supplier=sService.selectAllSupplier();
		 List<List<String>> dataList=new ArrayList<>();
		for(int i=0;i<supplier.size();i++){
			List<String> data=new ArrayList<>();
			data.add(i+1+"");
			data.add(supplier.get(i).getSpName());
			data.add(supplier.get(i).getSpType());
			data.add(supplier.get(i).getCreditCode());
			data.add(supplier.get(i).getBankNo());
			data.add(supplier.get(i).getBankName());
			data.add(supplier.get(i).getEnterpriseQualification());
			data.add(supplier.get(i).getBusinessLicense());
			data.add(supplier.get(i).getBusinessLicenseTime());
			data.add(supplier.get(i).getCredit());
			data.add(supplier.get(i).getLegalPersonMan());
			data.add(supplier.get(i).getEnterpriseType());
			data.add(supplier.get(i).getEnterpriseAddr());
			data.add(supplier.get(i).getEnterpriseSax());
			data.add(supplier.get(i).getEnterpriseEmail());
			data.add("80");
			dataList.add(data);
		}
		String [] array={"编号","企业名称","类型","社会统一信用代码","银行账户","开户行","企业资质","营业执照","营业执照有效期","信用证明","法人姓名","企业性质","地址","传真","电子邮件","考核得分"};
	        exportData.ExportWithResponse(xlsName,xlsName,  
	        		array.length, array, dataList, response);
	}
	
}
