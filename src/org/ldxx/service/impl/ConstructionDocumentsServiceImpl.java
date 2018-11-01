package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.ConstructionDocumentsDao;
import org.ldxx.service.ConstructionDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConstructionDocumentsServiceImpl implements ConstructionDocumentsService {

	@Autowired
	private ConstructionDocumentsDao dao;
	@Autowired
	private AccessoryDao adao;
	

	@Override
	public List<ConstructionDocuments> selectConstructionDocuments() {
		List<ConstructionDocuments> list=dao.selectConstructionDocuments();
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getCdId();
			List<Accessory> accessory1 = adao.selectAccessoryByIdAndType(id, "项目实际存档目录");
			list.get(i).setAccessory1(accessory1);
			List<Accessory> accessory2 = adao.selectAccessoryByIdAndType(id, "项目特点介绍、关键词");
			list.get(i).setAccessory2(accessory2);
			List<Accessory> accessory3 = adao.selectAccessoryByIdAndType(id, "招投标文件");
			list.get(i).setAccessory3(accessory3);
			List<Accessory> accessory4 = adao.selectAccessoryByIdAndType(id, "项目主合同");
			list.get(i).setAccessory4(accessory4);
			List<Accessory> accessory5 = adao.selectAccessoryByIdAndType(id, "开工报告");
			list.get(i).setAccessory5(accessory5);
			List<Accessory> accessory6 = adao.selectAccessoryByIdAndType(id, "项目总结");
			list.get(i).setAccessory6(accessory6);
			List<Accessory> accessory7 = adao.selectAccessoryByIdAndType(id, "计量资料");
			list.get(i).setAccessory7(accessory7);
			List<Accessory> accessory8 = adao.selectAccessoryByIdAndType(id, "设计变更资料");
			list.get(i).setAccessory8(accessory8);
			List<Accessory> accessory9 = adao.selectAccessoryByIdAndType(id, "施工图和竣工图");
			list.get(i).setAccessory9(accessory9);
			List<Accessory> accessory10 = adao.selectAccessoryByIdAndType(id, "开工、过程以及交竣工全部外部审查意见");
			list.get(i).setAccessory10(accessory10);
			List<Accessory> accessory11 = adao.selectAccessoryByIdAndType(id, "首件工程总结");
			list.get(i).setAccessory11(accessory11);
			List<Accessory> accessory12 = adao.selectAccessoryByIdAndType(id, "材料检测资料");
			list.get(i).setAccessory12(accessory12);
			List<Accessory> accessory13 = adao.selectAccessoryByIdAndType(id, "中间报验资料和检验评定资料");
			list.get(i).setAccessory13(accessory13);
			List<Accessory> accessory14 = adao.selectAccessoryByIdAndType(id, "施工日志");
			list.get(i).setAccessory14(accessory14);
			List<Accessory> accessory15 = adao.selectAccessoryByIdAndType(id, "其它");
			list.get(i).setAccessory15(accessory15);
		}
		return list;
	}


	@Override
	public int deleteConstructionDocumentsById(String id) {
		int i=dao.deleteConstructionDocumentsById(id);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
			}
		}
		return i;
	}


	@Override
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}


	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}


	@Override
	public int addConstructionDocumentsSave(ConstructionDocuments cd) {
		int i=dao.addConstructionDocumentsSave(cd);
		if(i>0){
			List<Accessory> accessory1 = cd.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = cd.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = cd.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = cd.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = cd.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = cd.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = cd.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = cd.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = cd.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = cd.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = cd.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = cd.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = cd.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
			List<Accessory> accessory14= cd.getAccessory14();
			if(accessory14!=null&&accessory14.size()>0){
				i=adao.addAccessory(accessory14);
			}
			List<Accessory> accessory15= cd.getAccessory15();
			if(accessory15!=null&&accessory15.size()>0){
				i=adao.addAccessory(accessory15);
			}
		}
		return i;
	}


	@Override
	public int updateConstructionDocumentsSave(ConstructionDocuments cd) {
		int i=dao.updateConstructionDocumentsSave(cd);
		if(i>0){
			List<Accessory> accessory1 = cd.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = cd.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = cd.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = cd.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = cd.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = cd.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = cd.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = cd.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = cd.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = cd.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = cd.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = cd.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = cd.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
			List<Accessory> accessory14= cd.getAccessory14();
			if(accessory14!=null&&accessory14.size()>0){
				i=adao.addAccessory(accessory14);
			}
			List<Accessory> accessory15= cd.getAccessory15();
			if(accessory15!=null&&accessory15.size()>0){
				i=adao.addAccessory(accessory15);
			}
		}
		return i;
	}
}
