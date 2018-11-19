package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.DesignDocuments;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.DesignDocumentsDao;
import org.ldxx.service.DesignDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DesignDocumentsServiceImpl implements DesignDocumentsService {
	
	@Autowired
	private DesignDocumentsDao dao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<DesignDocuments> selectDesignDocuments() {
		return dao.selectDesignDocuments();
	}

	@Override
	public int addDesignDocumentsSave(DesignDocuments dd) {
		int i=dao.addDesignDocumentsSave(dd);
		if(i>0){
			List<Accessory> accessory1 = dd.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = dd.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = dd.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = dd.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = dd.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = dd.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = dd.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = dd.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = dd.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = dd.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = dd.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = dd.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = dd.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
			List<Accessory> accessory14 = dd.getAccessory14();
			if(accessory14!=null&&accessory14.size()>0){
				i=adao.addAccessory(accessory14);
			}
			List<Accessory> accessory15 = dd.getAccessory15();
			if(accessory15!=null&&accessory15.size()>0){
				i=adao.addAccessory(accessory15);
			}
			List<Accessory> accessory16 = dd.getAccessory16();
			if(accessory16!=null&&accessory16.size()>0){
				i=adao.addAccessory(accessory16);
			}
			List<Accessory> accessory17 = dd.getAccessory17();
			if(accessory17!=null&&accessory17.size()>0){
				i=adao.addAccessory(accessory17);
			}
			List<Accessory> accessory18 = dd.getAccessory18();
			if(accessory18!=null&&accessory18.size()>0){
				i=adao.addAccessory(accessory18);
			}
			List<Accessory> accessory19 = dd.getAccessory19();
			if(accessory19!=null&&accessory19.size()>0){
				i=adao.addAccessory(accessory19);
			}
			List<Accessory> accessory20 = dd.getAccessory20();
			if(accessory20!=null&&accessory20.size()>0){
				i=adao.addAccessory(accessory20);
			}
			List<Accessory> accessory21 = dd.getAccessory21();
			if(accessory21!=null&&accessory21.size()>0){
				i=adao.addAccessory(accessory21);
			}
			List<Accessory> accessory22= dd.getAccessory22();
			if(accessory22!=null&&accessory22.size()>0){
				i=adao.addAccessory(accessory22);
			}
			List<Accessory> accessory23 = dd.getAccessory23();
			if(accessory23!=null&&accessory23.size()>0){
				i=adao.addAccessory(accessory23);
			}
			List<Accessory> accessory24 = dd.getAccessory24();
			if(accessory24!=null&&accessory24.size()>0){
				i=adao.addAccessory(accessory24);
			}
			List<Accessory> accessory25 = dd.getAccessory25();
			if(accessory25!=null&&accessory25.size()>0){
				i=adao.addAccessory(accessory25);
			}
			List<Accessory> accessory26 = dd.getAccessory26();
			if(accessory26!=null&&accessory26.size()>0){
				i=adao.addAccessory(accessory26);
			}
			List<Accessory> accessory27 = dd.getAccessory27();
			if(accessory27!=null&&accessory27.size()>0){
				i=adao.addAccessory(accessory27);
			}
			List<Accessory> accessory28 = dd.getAccessory28();
			if(accessory28!=null&&accessory28.size()>0){
				i=adao.addAccessory(accessory28);
			}
			List<Accessory> accessory29 = dd.getAccessory29();
			if(accessory29!=null&&accessory29.size()>0){
				i=adao.addAccessory(accessory29);
			}
			List<Accessory> accessory30 = dd.getAccessory30();
			if(accessory30!=null&&accessory30.size()>0){
				i=adao.addAccessory(accessory30);
			}
			List<Accessory> accessory31 = dd.getAccessory31();
			if(accessory31!=null&&accessory31.size()>0){
				i=adao.addAccessory(accessory31);
			}
			List<Accessory> accessory32 = dd.getAccessory32();
			if(accessory32!=null&&accessory32.size()>0){
				i=adao.addAccessory(accessory32);
			}
			List<Accessory> accessory33 = dd.getAccessory33();
			if(accessory33!=null&&accessory33.size()>0){
				i=adao.addAccessory(accessory33);
			}
			List<Accessory> accessory34 = dd.getAccessory34();
			if(accessory34!=null&&accessory34.size()>0){
				i=adao.addAccessory(accessory34);
			}
			List<Accessory> accessory35 = dd.getAccessory35();
			if(accessory35!=null&&accessory35.size()>0){
				i=adao.addAccessory(accessory35);
			}
			List<Accessory> accessory36 = dd.getAccessory36();
			if(accessory36!=null&&accessory36.size()>0){
				i=adao.addAccessory(accessory36);
			}
			List<Accessory> accessory37 = dd.getAccessory37();
			if(accessory37!=null&&accessory37.size()>0){
				i=adao.addAccessory(accessory37);
			}
			List<Accessory> accessory38 = dd.getAccessory38();
			if(accessory38!=null&&accessory38.size()>0){
				i=adao.addAccessory(accessory38);
			}
			List<Accessory> accessory39 = dd.getAccessory39();
			if(accessory39!=null&&accessory39.size()>0){
				i=adao.addAccessory(accessory39);
			}
		}
		return i;
	}

	@Override
	public int deleteDesignDocuments(String id) {
		int i=dao.deleteDesignDocuments(id);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
			}
		}
		return i;
	}

	@Override
	public DesignDocuments selectDesignDocumentsById(String id) {
		return dao.selectDesignDocumentsById(id);
	}

}
