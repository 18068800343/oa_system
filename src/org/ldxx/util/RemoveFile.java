package org.ldxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.FbContract;
import org.ldxx.bean.User;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
import org.ldxx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@Component
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class RemoveFile {

	/*public static RemoveFile INSTANCE; 
	@PostConstruct // 第三步  
    public void init() {  
		INSTANCE = this;
        INSTANCE.sDao=this.sDao;
        INSTANCE.tDao=this.tDao;
        INSTANCE.cjDao=this.cjDao;
        INSTANCE.aDao=this.aDao;
    } */
	@Autowired
	private SubContractService sService;
	@Autowired
	private TaskService tService;
	@Autowired
	private CjContractService cjService;
	@Autowired
	private AccessoryService aService;
	@Autowired
	private UserService uService;
	
	@Test
	public void aaaa() throws FileNotFoundException{
		List<CjContract> list=new ArrayList<>();
		Workbook  hssfWorkbook=null;
		String file="C://Users//hp//Desktop//华通人员.xlsx";
		File f=new File(file);
		InputStream is=new FileInputStream(f);
		try {
			hssfWorkbook = WorkbookFactory.create(is);  
		} catch (Exception e) {
			e.printStackTrace();
		}  
		List<User> uList=new ArrayList<>();
		
		
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	try {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if(hssfRow!=null){
						Cell colum1 = hssfRow.getCell(1);  //姓名
						Cell colum2 = hssfRow.getCell(2);  //性别
						Cell colum3 = hssfRow.getCell(3);  //职称
						Cell colum4 = hssfRow.getCell(4);  //身份证
						Cell colum5 = hssfRow.getCell(5);//学历
						Cell colum6 = hssfRow.getCell(6);//毕业学院
						Cell colum7 = hssfRow.getCell(7);//专业
						Cell colum8 = hssfRow.getCell(9);//入职时间
						Cell colum9 = hssfRow.getCell(10);//电话
						
						User user=new User();
						String uName=getValue(colum1);
						String sex=getValue(colum2);
						String zhic=getValue(colum3);
						String ID=getValue(colum4);
						String xueli=getValue(colum5);
						String school=getValue(colum6);
						String zhuanye=getValue(colum7);
						String time=getValue(colum8);
						String phone=getValue(colum9);
						time=time.replace(".", "-");
						user.setuName(uName);
						user.setSex(sex);
						user.setPosition(zhic);
						user.setCardId(ID);
						user.setDiploma(xueli);
						user.setSchool(school);
						user.setSpecialty(zhuanye);
						user.setEntryTime(time);
						user.setPhoneNo(phone);
						uList.add(user);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} 
                }  
            } 
        	
        	for(int i=0;i<uList.size();i++){
        		uService.updateUserInfoByuName(uList.get(i));
        	}
        
	}
	
	
	@SuppressWarnings("static-access")  
    private String getValue(Cell colum1) {
		 if(null!=colum1){
			if (colum1.getCellType() == colum1.CELL_TYPE_BOOLEAN) {  
				 // 返回布尔类型的值  
				 return String.valueOf(colum1.getBooleanCellValue());  
			 } else if (colum1.getCellType() == colum1.CELL_TYPE_NUMERIC) {  
				 // 返回数值类型的值
							 NumberFormat nf = NumberFormat.getInstance();
							 String s = nf.format(colum1.getNumericCellValue());
					//		 String s =String.valueOf(colum1.getNumericCellValue());
							 //这种方法对于自动加".0"的数字可直接解决
							 //但如果是科学计数法的数字就转换成了带逗号的，例如：12345678912345的科学计数法是1.23457E+13，经过这个格式化后就变成了字符串“12,345,678,912,345”，这也并不是想要的结果，所以要将逗号去掉
							 if (s.indexOf(",") >= 0) {
								 s = s.replace(",", "");
							 }
							 return s; 
			 } else { 
				 // 返回字符串类型的值  
				 return String.valueOf(colum1.getStringCellValue());  
			} 
		 }else{
			 return "";
		 }
        } 
	
	
	@Test
	public void rmFile(){
		List<CjContract> cjList=cjService.selectIdAndName();
		File file=new File("C://Users//hp//Desktop//all");
		String path="C://Users//hp//Desktop//new_all";
		File [] fileList=file.listFiles();
		for(int i=0;i<cjList.size();i++){
			String cjId=cjList.get(i).getCjId();
			String cjNo=cjList.get(i).getContractNo();
			String uuid=new TimeUUID().getTimeUUID();
			for(int ii=0;ii<fileList.length;ii++){
				String fileName=fileList[ii].getName();
				if(fileName.contains(cjNo)){
					List<Accessory> aList=new ArrayList<>();
					Accessory accessory=new Accessory();
					accessory.setaId(cjId);
					accessory.setAcUrl(uuid+File.separator+fileName);
					accessory.setAcName(fileName);
					accessory.setaType("承接合同文本");
					aList.add(accessory);
					int iii=aService.addAccessory(aList);
					if(iii>0){
						File f3=new File(path+File.separator+uuid);
						if(!f3.exists()){
							f3.mkdirs();
						}
						String path2=path+File.separator+uuid+File.separator+fileName;
						fileList[ii].renameTo(new File(path2));
					}else{
						System.out.println(cjNo);
					}
					
				}
			}
		}
		
		List<FbContract> fbList=sService.getFBNameAndNo();
		for(int j=0;j<fbList.size();j++){
			String fbId=fbList.get(j).getFbId();
			String fbNo=fbList.get(j).getFbNo();
			String uuid=new TimeUUID().getTimeUUID();
			for(int jj=0;jj<fileList.length;jj++){
				String fileName=fileList[jj].getName();
				if(fileName.contains(fbNo)){
					List<Accessory> aList=new ArrayList<>();
					Accessory accessory=new Accessory();
					accessory.setaId(fbId);
					accessory.setAcUrl(uuid+File.separator+fileName);
					accessory.setAcName(fileName);
					accessory.setaType("分包合同文本");
					aList.add(accessory);
					int jjj=aService.addAccessory(aList);
					if(jjj>0){
						File f3=new File(path+File.separator+uuid);
						if(!f3.exists()){
							f3.mkdirs();
						}
						String path2=path+File.separator+uuid+File.separator+fileName;
						fileList[jj].renameTo(new File(path2));
					}else{
						System.out.println(fbNo);
					}
					
				}
			}
		}
	}
	
	
}
