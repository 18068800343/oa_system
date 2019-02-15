package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.TechnicalDocumentation;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.TechnicalDocumentationDao;
import org.ldxx.service.TechnicalDocumentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TechnicalDocumentationServiceImpl implements TechnicalDocumentationService {
	
	@Autowired
	private TechnicalDocumentationDao dao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<TechnicalDocumentation> selectTechnicalDocumentation() {
		return dao.selectTechnicalDocumentation();
	}

	@Override
	public int addConstructionDocumentsSave(TechnicalDocumentation td) {
		int i=dao.addConstructionDocumentsSave(td);
		if(i>0){
			List<Accessory> accessory1 = td.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = td.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = td.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = td.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = td.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = td.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = td.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = td.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = td.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = td.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = td.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = td.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = td.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
			List<Accessory> accessory14= td.getAccessory14();
			if(accessory14!=null&&accessory14.size()>0){
				i=adao.addAccessory(accessory14);
			}
			List<Accessory> accessory15= td.getAccessory15();
			if(accessory15!=null&&accessory15.size()>0){
				i=adao.addAccessory(accessory15);
			}
			List<Accessory> accessory16= td.getAccessory16();
			if(accessory16!=null&&accessory16.size()>0){
				i=adao.addAccessory(accessory16);
			}
			List<Accessory> accessory17= td.getAccessory17();
			if(accessory17!=null&&accessory17.size()>0){
				i=adao.addAccessory(accessory17);
			}
		}
		return i;
	}

	@Override
	public int deleteTechnicalDocumentation(String id) {
		int i=dao.deleteTechnicalDocumentation(id);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
				if(i>0){
					String path="D:"+File.separator+"oa"+File.separator+"TechnicalDocumentation"+File.separator+id;
					File f=new File(path);
					String[]  tempList  =  f.list();
					for(int a=0;a<tempList.length;a++){
						String path2=path+File.separator+tempList[a];
						File f2=new File(path2);
						f2.delete();
					}
					f.delete();
				}
			}
		}
		return i;
	}

	@Override
	public TechnicalDocumentation selectTechnicalDocumentationById(String id) {
		return dao.selectTechnicalDocumentationById(id);
	}

	@Override
	public int updateTechnicalDocumentationSave(TechnicalDocumentation td) {
		/*int i=dao.updateTechnicalDocumentationSave(td);
		if(i>0){*/
		int i=0;
			List<Accessory> accessory1 = td.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = td.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = td.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = td.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = td.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = td.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = td.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = td.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = td.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = td.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = td.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = td.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = td.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
			List<Accessory> accessory14= td.getAccessory14();
			if(accessory14!=null&&accessory14.size()>0){
				i=adao.addAccessory(accessory14);
			}
			List<Accessory> accessory15= td.getAccessory15();
			if(accessory15!=null&&accessory15.size()>0){
				i=adao.addAccessory(accessory15);
			}
			List<Accessory> accessory16= td.getAccessory16();
			if(accessory16!=null&&accessory16.size()>0){
				i=adao.addAccessory(accessory16);
			}
			List<Accessory> accessory17= td.getAccessory17();
			if(accessory17!=null&&accessory17.size()>0){
				i=adao.addAccessory(accessory17);
			}
		//}
		return i;
	}

}
