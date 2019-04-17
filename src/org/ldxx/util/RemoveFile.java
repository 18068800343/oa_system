package org.ldxx.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.ldxx.bean.Accessory;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.FbContract;
import org.ldxx.service.AccessoryService;
import org.ldxx.service.CjContractService;
import org.ldxx.service.SubContractService;
import org.ldxx.service.TaskService;
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
	
	/*@Test
	public void aaaa(){
		File f=new File("D://abcd//aaa//ceshi.txt");
		File f2=new File("D://abcd//bbb//ceshi.txt");
		f.renameTo(f2);
	}*/
	
	
	
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
