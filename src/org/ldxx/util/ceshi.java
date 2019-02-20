package org.ldxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.Cooperator;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task;
import org.ldxx.bean.Task2;
import org.ldxx.bean.User;
import org.ldxx.dao.CjContractDao;
import org.ldxx.dao.CooperatorDao;
import org.ldxx.dao.ReceiveMoneyDao;
import org.ldxx.dao.TaskDao;
import org.ldxx.dao.UserDao;
import org.ldxx.service.CjContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ceshi {

	public static ceshi INSTANCE; 
	@PostConstruct // 第三步  
    public void init() {  
        INSTANCE = this;
        INSTANCE.uDao=this.uDao;
        INSTANCE.cDao=this.cDao;
        INSTANCE.tDao=this.tDao;
    } 
	
	@Autowired
	private UserDao uDao;
	@Autowired
	private CooperatorDao cDao;
	@Autowired
	private TaskDao tDao;
	@Autowired
	private CjContractDao cjDao;
	
	public void readXls() throws IOException {  
		List<Task> list=new ArrayList<>();
		Workbook  hssfWorkbook=null;
		String file="C://Users//hp//Desktop//ceshi.xlsx";
		File f=new File(file);
		InputStream is=new FileInputStream(f);
		try {
			hssfWorkbook = WorkbookFactory.create(is);  
		} catch (Exception e) {
			e.printStackTrace();
		}  
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	try {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if(hssfRow!=null){
						Task t2=new Task();
						TimeUUID uuid=new TimeUUID();
						Cell colum1 = hssfRow.getCell(2);  
						Cell colum2 = hssfRow.getCell(4);  
						Cell colum3 = hssfRow.getCell(5);  
						Cell colum4 = hssfRow.getCell(6);  
						Cell colum5 = hssfRow.getCell(7);
						Cell colum6 = hssfRow.getCell(8);
						String tNo=getValue(colum1);
						String prjName=getValue(colum2);
						String yezhu=getValue(colum3);
						String time=getValue(colum4);
						String stratTime="";
						String endTime="";
						if(time.trim()!=null&&!time.trim().equals("")){
							stratTime=time.split("-")[0];
							endTime=time.split("-")[1];
							stratTime.replaceAll(".", "-");
							endTime.replaceAll(".", "-");
						}
						
						String man=getValue(colum5);
						String money=getValue(colum6);
						float m=0;
						if(money!=""){
							BigDecimal bigDecimal = new BigDecimal(money);
							BigDecimal bigDecimal2 = new BigDecimal("10000");
							BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
							m = (float) bigDecimalMultiply.doubleValue();
						}
						String prjId=uuid.getTimeUUID();
						
						t2.setPrjId(prjId);
						t2.setPrjName(prjName);
						t2.setPrjNo(tNo);
						t2.setPrjOwnerUnit(yezhu);
						t2.setMainPrjLeader(man);
						t2.setContractMoney(m);
						t2.setPrjStartTime(stratTime);
						t2.setPrjEndTime(endTime);
						t2.setPrjManagementModel("自营");
						t2.setPrjCompany("华通");
						list.add(t2);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
                }  
            } 
       for(int i=0;i<list.size();i++){
    	   String yz=list.get(i).getPrjOwnerUnit();
    	   Cooperator cc=INSTANCE.cDao.selectCooperatorByCcName(yz);
    	   String cId="";
    	   if(cc!=null){
    		   cId=cc.getCcId();
    	   }
    	   list.get(i).setPrjOwnerUnit(cId);
    	   
    	   String fzr=list.get(i).getMainPrjLeader();
    	   User u=INSTANCE.uDao.getUserByUname(fzr);    	   
    	   String uId="";
    	   if(u!=null){
    		   uId=u.getUserId();
    	   }
    	   list.get(i).setMainPrjLeader(uId);
    	   INSTANCE.tDao.addTask(list.get(i));
       } 
       
       
    }  
	
	
	public void readXls2() throws IOException {  
		List<CjContract> list=new ArrayList<>();
		Workbook  hssfWorkbook=null;
		String file="C://Users//hp//Desktop//统计华通1-5年的项目.xlsx";
		File f=new File(file);
		InputStream is=new FileInputStream(f);
		try {
			hssfWorkbook = WorkbookFactory.create(is);  
		} catch (Exception e) {
			e.printStackTrace();
		}  
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	try {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if(hssfRow!=null){
						CjContract cj=new CjContract();
						TimeUUID uuid=new TimeUUID();
						Cell colum1 = hssfRow.getCell(0);  
						Cell colum2 = hssfRow.getCell(1);  
						Cell colum3 = hssfRow.getCell(2);  
						Cell colum4 = hssfRow.getCell(3);  
						Cell colum5 = hssfRow.getCell(4);
						Cell colum6 = hssfRow.getCell(5);
						Cell colum7 = hssfRow.getCell(6);
						
						String prjName=getValue(colum1);
						String prjNo=getValue(colum2);
						String cjName=getValue(colum3);
						String cjNo=getValue(colum4);
						String money=getValue(colum5);
						String yezhu=getValue(colum6);
						String info=getValue(colum7);
						System.out.println(prjNo);
						float m=0;
						if(money!=""){
							BigDecimal bigDecimal = new BigDecimal(money);
							BigDecimal bigDecimal2 = new BigDecimal("10000");
							BigDecimal bigDecimalMultiply = bigDecimal.multiply(bigDecimal2);
							m = (float) bigDecimalMultiply.doubleValue();
						}
						String cjId=uuid.getTimeUUID();
						cj.setCjId(cjId);
						cj.setPrjName(prjName);
						cj.setTaskCode(prjNo);
						cj.setContractName(cjName);
						cj.setContractNo(cjNo);
						cj.setCcName(yezhu);
						cj.setContractMoney(m);
						cj.setReceieveMoneyCondition(info);
						list.add(cj);
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
                }  
            } 
       for(int i=0;i<list.size();i++){
    	   String yz=list.get(i).getCcName();
    	   Cooperator cc=INSTANCE.cDao.selectCooperatorByCcName(yz);
    	   String cId="";
    	   if(cc!=null){
    		   cId=cc.getCcId();
    	   }
    	   list.get(i).setContractNameJia(cId);
    	   
    	   INSTANCE.cjDao.addCjContract(list.get(i));
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
		//		 NumberFormat nf = NumberFormat.getInstance();
		//		 String s = nf.format(colum1.getNumericCellValue());
				 String s =String.valueOf(colum1.getNumericCellValue());
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
}
