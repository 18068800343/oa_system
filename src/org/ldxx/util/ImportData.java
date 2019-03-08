package org.ldxx.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.ldxx.bean.CompanyCost;
import org.ldxx.bean.FinancialTables;
import org.ldxx.bean.ReceiveMoney;
import org.ldxx.bean.SecondCompanyCost;
import org.ldxx.bean.TDepartment;
import org.ldxx.bean.Task2;
import org.ldxx.bean.WxCost;
import org.ldxx.dao.ReceiveMoneyDao;
import org.ldxx.mapper.NodeActorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImportData {
	
	public static ImportData INSTANCE; 
	
	@PostConstruct // 第三步  
    public void init() {  
        INSTANCE = this;
        INSTANCE.receiveMoneyDao=this.receiveMoneyDao;
    } 
	
	@Autowired
	ReceiveMoneyDao receiveMoneyDao;
	
	public Map<String,Object> readXls(InputStream is, String time) throws IOException {  
		Map<String,Object> map=new HashMap<String, Object>();
		Workbook  hssfWorkbook=null;
		
		
		try {
			hssfWorkbook = WorkbookFactory.create(is);  
		} catch (Exception e) {
			e.printStackTrace();
		}  
        List<Task2> t = new ArrayList<Task2>();
        List<TDepartment> d = new ArrayList<TDepartment>();
        // 循环工作表Sheet  
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {  
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
            if (hssfSheet == null) {  
                continue;  
            }  
            // 循环行Row  
            for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	try {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if(hssfRow!=null){
						int cells=hssfRow.getPhysicalNumberOfCells();
						Task2 t2=new Task2();
						TDepartment td=new TDepartment();
						TimeUUID uuid=new TimeUUID();
						Cell colum1 = hssfRow.getCell(0);  
						Cell colum2 = hssfRow.getCell(1);  
						Cell colum3 = hssfRow.getCell(2);  
						Cell colum4 = hssfRow.getCell(3);  
						Cell colum5 = hssfRow.getCell(4);
						Cell colum6 = hssfRow.getCell(5);
						Cell colum7 = hssfRow.getCell(6);
						String tNo=getValue(colum1);
						boolean flag=true;
						if(t.size()>0){
							for(int i=0;i<t.size();i++){
								String no=t.get(i).gettNo();
								if(no.equals(tNo)){
									flag=false;
									break;
								}else{
									flag=true;
								}
							}
						}
						String val5 = getValue(colum5);
						if(val5.contains(time)){
							if(flag==true){
								t2.settId(uuid.getTimeUUID());
								t2.settNo(tNo);
								t2.settName(getValue(colum2));
								t2.settType(getValue(colum4));
								t2.settDate(val5);
								t2.settDesc(getValue(colum7));
								t.add(t2);
							}
							td.settNo(getValue(colum1));
							td.setdName(getValue(colum6));
							td.setdMoney(Float.valueOf(getValue(colum3)));
							d.add(td);
						}
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
                }  
            } 
        map.put("t2", t);
        map.put("department", d);
        return map;  
    }  
	
	public List<TDepartment> readXls2(InputStream is) throws IOException, ParseException {  
		 List<TDepartment> list=new ArrayList<>();
		Workbook  hssfWorkbook=null;
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
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM");
            SimpleDateFormat sdf2=new SimpleDateFormat("yyyy/MM/dd");
    		String time=sdf.format(new Date());
    		String year=time.split("/")[0];
    		int month=Integer.valueOf(time.split("/")[1]);
    		String startTime="";
    		if(month!=1){
    			startTime=year+"/"+(month-1)+"/01";
    		}else{
    			int newYear=Integer.valueOf(year);
    			startTime=(newYear-1)+"/12/01";
    		}
    		String endTime=time+"/01";
    		float start=sdf2.parse(startTime).getTime();
    		float end=sdf2.parse(endTime).getTime();
    		
    		Calendar calendar = new GregorianCalendar(1900,0,-1);  
            Date d = calendar.getTime(); 
            // 循环行Row  
            for (int rowNum = 2; rowNum <hssfSheet.getLastRowNum(); rowNum++) {  
            	Row hssfRow = hssfSheet.getRow(rowNum);
                int cells=hssfRow.getPhysicalNumberOfCells();
               
                TDepartment td=new TDepartment();
                
                Cell colum1 = hssfRow.getCell(0);  
                Cell colum2 = hssfRow.getCell(1); 
                Cell colum3 = hssfRow.getCell(3);  
                Cell colum4 = hssfRow.getCell(4);  
                Cell colum5 = hssfRow.getCell(5);
                String fillTime=getValue(colum5);
                if(!"".equals(fillTime)&&null!=fillTime){
                	Date dd = DateUtils.addDays(d,Integer.valueOf(fillTime)); 
                	
                	float fill=dd.getTime();
                	Date date = new Date();
                	if (colum5.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                		date = colum5.getDateCellValue();
                	}
                	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                	
                	if(fill>start&&fill<end){
                		String date1 = simpleDateFormat.format(date);
                		td.settNo(getValue(colum1));
                		td.setdName(getValue(colum4));
                		td.settName(getValue(colum2));
                		td.setdIncome(Float.valueOf(getValue(colum3)));
                		td.setDate(date1);
                		list.add(td);
                	}
                }
            }  
        } 
        return list;  
    }  
	
	
	public List<WxCost> readXls3(InputStream is) throws IOException {  //外协费用导入
		Workbook  hssfWorkbook=null;
		List<WxCost> list=new ArrayList<>();
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
            for (int rowNum = 2; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
            	try {
					Row hssfRow = hssfSheet.getRow(rowNum);
					if(hssfRow!=null){
						int cells=hssfRow.getPhysicalNumberOfCells();
						if(cells>18){
							WxCost wx=new WxCost();
							Cell colum1 = hssfRow.getCell(3);  //项目编号列
							Cell colum2 = hssfRow.getCell(4);  //项目名称列
							Cell colum3 = hssfRow.getCell(6);  //客户名称
							Cell colum4 = hssfRow.getCell(8);  //部门名称
							Cell colum5 = hssfRow.getCell(10);  //借贷
							Cell colum6 = hssfRow.getCell(13);  //金额
							
							String no=getValue(colum1);
							String name=getValue(colum2);
							name=name.replace("【工程项目：", "").replace("】", "");
							String wxName=getValue(colum3);
							wxName=wxName.replace("【客商：", "").replace("】", "");
							String dept=getValue(colum4);
							if(dept.equals("工程公司")){
								dept="工程建设一部";
							}
							String type=getValue(colum5);
							String wxCost=getValue(colum6);
							if(wxCost.equals("")){
								wxCost="0";
							}
							wxCost=wxCost.replace(",", "").replace("，", "");
							if(!name.equals("")&&type.equals("借")){
								TimeUUID uuid=new TimeUUID();
								String id=uuid.getTimeUUID();
								wx.setWxId(id);
								wx.setPrjNo(no);
								wx.setPrjName(name);
								wx.setWxCost(Double.valueOf(wxCost));
								wx.setWxName(wxName);
								wx.setDept(dept);
								list.add(wx);
							}
						}
						
					}
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
                }  
            } 
        return list;  
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

	 //检测二部财务收款
	 public Map<String,Object> fR2readXls(InputStream is, String time) throws IOException {  
			Map<String,Object> map=new HashMap<String, Object>();
			Workbook  hssfWorkbook=null;
			try {
				hssfWorkbook = WorkbookFactory.create(is);  
			} catch (Exception e) {
				e.printStackTrace();
			}  
			List<FinancialTables> t = new ArrayList<FinancialTables>();
	        // 循环工作表Sheet  
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) { 
	            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
	            if (hssfSheet == null) {  
	                continue;  
	            }  
	            // 循环行Row  
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
	            	Row hssfRow = hssfSheet.getRow(rowNum);
	                int cells=hssfRow.getPhysicalNumberOfCells();
	                
	                FinancialTables ft=new FinancialTables();
	                TimeUUID uuid=new TimeUUID();
	                Cell colum1 = hssfRow.getCell(0);  
	                Cell colum2 = hssfRow.getCell(1);  
	                Cell colum3 = hssfRow.getCell(2);  
	                Cell colum4 = hssfRow.getCell(3); 
	                Cell colum5 = hssfRow.getCell(4);
	                Cell colum6 = hssfRow.getCell(5);
	                
	                String tNo=getValue(colum1);
	                boolean flag=true;
	                /*if(t.size()>0){
	                	for(int i=0;i<t.size();i++){
	                    	String no=t.get(i).gettNo();
	                    	if(no.equals(tNo)){
	                    		flag=false;
	                    		break;
	                    	}else{
	                    		flag=true;
	                    	}
	                    }
	                }*/
	                String val6 = getValue(colum6);
	                if(flag==true&&val6.contains(time)){
	                	ft.settId(uuid.getTimeUUID());
	                	ft.settNo(tNo);
	                	ft.settName(getValue(colum2));
	                	ft.settDepartment(getValue(colum3));
	                	ft.settCollectionValue(Float.valueOf(getValue(colum4)==""?"0":getValue(colum4)));
	                	ft.settDesc(getValue(colum5));
	                	ft.settTime(val6);
	                    t.add(ft);
	                }
	                }  
	            } 
	        map.put("fR2", t);
	        return map;  
	    }
	 
	 //检测二部财务收款
	 public  Map<String,Object> readExcelShouKuan(InputStream is) throws IOException { 
			Map<String,Object> map=new HashMap<String, Object>();
			Workbook  hssfWorkbook=null;
			try {
				hssfWorkbook = WorkbookFactory.create(is);  
			} catch (Exception e) {
				e.printStackTrace();
			}  
			List<ReceiveMoney> t = new ArrayList<ReceiveMoney>();
	        // 循环工作表Sheet  
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) { 
	            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
	            if (hssfSheet == null) {  
	                continue;  
	            }  
	            // 循环行Row  
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
	            	Row hssfRow = hssfSheet.getRow(rowNum);
	                int cells=hssfRow.getPhysicalNumberOfCells();
	                
	                ReceiveMoney ft=new ReceiveMoney();
	                Cell colum1 = hssfRow.getCell(0);  
	                Cell colum2 = hssfRow.getCell(1);  
	                Cell colum3 = hssfRow.getCell(2);  
	                Cell colum4 = hssfRow.getCell(3);  
	                Cell colum5 = hssfRow.getCell(4);
	                boolean flag=true;
	                /*if(t.size()>0){
	                	for(int i=0;i<t.size();i++){
	                    	String no=t.get(i).gettNo();
	                    	if(no.equals(tNo)){
	                    		flag=false;
	                    		break;
	                    	}else{
	                    		flag=true;
	                    	}
	                    }
	                }*/
	                if(flag==true){
	                	ft.setRmId(new TimeUUID().getTimeUUID());
	                	int a = INSTANCE.receiveMoneyDao.countSkNo();
	                	ft.setSkNo("SK"+new TimeUUID().getClCode("", a));
	                	//付款单位
	                	ft.setCcName(getValue(colum1));
	                	//到账金额
	                	ft.setReceiveMoney(Double.valueOf(getValue(colum2)));
	                	//备注
	                	
	                	ft.setRmDesc(getValue(colum3));
	                	
	                	Date date = new Date();
	                	 if (colum4.getCellType() == Cell.CELL_TYPE_NUMERIC) {
	                		 date = colum4.getDateCellValue();
                		 }
	                	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(" yyyy-mm-dd");
	                	//收款日期
	                	ft.setRmTime(simpleDateFormat.format(date));
	                	//记录人
	                	ft.setDoPerson(getValue(colum5));
	                    t.add(ft);
	                }
	                }  
	            } 
	        map.put("fR2", t);
	        return map;  
	    }
	 
	 //检测二部直接成本
	 public  Map<String,Object> readExcelSecondCompanyCost(InputStream is, String time) throws IOException { 
			Map<String,Object> map=new HashMap<String, Object>();
			Workbook  hssfWorkbook=null;
			try {
				hssfWorkbook = WorkbookFactory.create(is);  
			} catch (Exception e) {
				e.printStackTrace();
			}  
			List<SecondCompanyCost> t = new ArrayList<SecondCompanyCost>();
	        // 循环工作表Sheet  
	        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) { 
	            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
	            if (hssfSheet == null) {  
	                continue;  
	            }  
	            // 循环行Row  
	            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
	            	Row hssfRow = hssfSheet.getRow(rowNum);
	                int cells=hssfRow.getPhysicalNumberOfCells();
	                
	                SecondCompanyCost ft=new SecondCompanyCost();
	                Cell colum1 = hssfRow.getCell(0);  
	                Cell colum2 = hssfRow.getCell(1);  
	                Cell colum3 = hssfRow.getCell(2);  
	                Cell colum4 = hssfRow.getCell(3);  
	                Cell colum5 = hssfRow.getCell(4);
	                Cell colum6 = hssfRow.getCell(5);
	                boolean flag=true;
	                /*if(t.size()>0){
	                	for(int i=0;i<t.size();i++){
	                    	String no=t.get(i).gettNo();
	                    	if(no.equals(tNo)){
	                    		flag=false;
	                    		break;
	                    	}else{
	                    		flag=true;
	                    	}
	                    }
	                }*/
	                String val6 = getValue(colum6);
	                if(flag==true&&val6.contains(time)){
	                	ft.setId(new TimeUUID().getTimeUUID());
	                	ft.setXuhao(getValue(colum1));
	                	ft.setCompanyName(getValue(colum2));
	                	ft.setTaskCode(getValue(colum3));
	                	ft.setDepartName(getValue(colum4));
	                	ft.setMoney(Float.valueOf((getValue(colum5))));
	                	ft.setDate(val6);
	                    t.add(ft);
	                }
	                }  
	            } 
	        map.put("fR2", t);
	        return map;  
	    }
	 public  Map<String,Object> readExcelCompanyCost(InputStream is) throws IOException { 
		 Map<String,Object> map=new HashMap<String, Object>();
		 Workbook  hssfWorkbook=null;
		 try {
			 hssfWorkbook = WorkbookFactory.create(is);  
		 } catch (Exception e) {
			 e.printStackTrace();
		 }  
		 List<CompanyCost> t = new ArrayList<CompanyCost>();
		 // 循环工作表Sheet  
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) { 
			 Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);  
			 if (hssfSheet == null) {  
				 continue;  
			 }  
			 // 循环行Row  
			 for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {  
				 Row hssfRow = hssfSheet.getRow(rowNum);
				 if (hssfRow == null) {  
					 continue;  
				 }  
				 int cells=hssfRow.getPhysicalNumberOfCells();
				 
				 CompanyCost ft=new CompanyCost();
				 
				 Cell colum1 = hssfRow.getCell(1);  
				 
				 String c2 = getValue(colum1);
				 if("".equals(colum1)||null==colum1||!isNumeric(c2)){
					 continue;
				 }
				 Cell colum2 = hssfRow.getCell(2);  
				 Cell colum3 = hssfRow.getCell(3);  
				 Cell colum4 = hssfRow.getCell(4);  
				 Cell colum5 = hssfRow.getCell(5);
				 Cell colum6 = hssfRow.getCell(6);
				 Cell colum9 = hssfRow.getCell(9);
				 boolean flag=true;
					 /*if(t.size()>0){
	                	for(int i=0;i<t.size();i++){
	                    	String no=t.get(i).gettNo();
	                    	if(no.equals(tNo)){
	                    		flag=false;
	                    		break;
	                    	}else{
	                    		flag=true;
	                    	}
	                    }
	                }*/
					 if(flag==true){
						 ft.setId(new TimeUUID().getTimeUUID());
						 ft.setXuhao(getValue(colum1));
						 String cc3 = getValue(colum3);
						 ft.setTaskCode(cc3);
						 if(cc3.startsWith("0")){
							 ft.setType("0");
						 }else{
							 ft.setType("1");
						 }
						 ft.setPrjName(getValue(colum4));
						 String cc6 = getValue(colum6);
						 if(!"".equals(cc6)){
							 cc6 = cc6.replace("：", ":");
							 if(cc6.contains("宿迁分公司")){
						     cc6 = cc6.replace("宿迁分公司", "工程建设二部");
							 }
							 if(cc6.contains(":")){
								String[] strings =  cc6.split(":");
								String nowStr = strings[1];
								if(nowStr.endsWith("】")){
									nowStr = nowStr.substring(0, nowStr.length()-1);
								}
								 ft.setDepartName(nowStr);
							 }
						 }
						 String cc9 = getValue(colum9).trim();
						 if(!"".equals(cc9)){
							 cc9 = cc9.replace(" ", "").replace("，", "").replace(",","");
							 if(cc3.startsWith("0")){
								 ft.setMoney(Double.valueOf((cc9)));
							 }else{
								 ft.setMoney2(Double.valueOf((cc9)));
							 }
						 }else{
							 ft.setMoney(null);
							 ft.setMoney2(null);
						 }
						 t.add(ft);
					 }
			 }  
		 } 
		 map.put("fR2", t);
		 return map;  
	 }
    public static boolean isNumeric(String str){
       Pattern pattern = Pattern.compile("[0-9]*");
       Matcher isNum = pattern.matcher(str);
       if(!isNum.matches() ){
           return false;
       }
       return true;
    }
}
