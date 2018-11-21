package org.ldxx.service.impl;

import java.io.File;
import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.ConstructionDocuments;
import org.ldxx.bean.TestingEvaluation;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.TestingEvaluationDao;
import org.ldxx.service.TestingEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestingEvaluationServiceImpl implements TestingEvaluationService {

	@Autowired
	private TestingEvaluationDao dao;
	@Autowired
	private AccessoryDao adao;

	@Override
	public List<TestingEvaluation> selectTestingEvaluation() {
		List<TestingEvaluation> list=dao.selectTestingEvaluation();
		return list;
	}

	@Override
	public int addTestingEvaluationSave(TestingEvaluation te) {
		int i=dao.addTestingEvaluationSave(te);
		if(i>0){
			List<Accessory> accessory1 = te.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = te.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = te.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = te.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = te.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = te.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = te.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = te.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = te.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = te.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = te.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = te.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = te.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
		}
		return i;
	}

	@Override
	public int updateTestingEvaluationSave(TestingEvaluation te) {
		/*int i=dao.updateTestingEvaluationSave(te);
		if(i>0){*/
		int i=0;
			List<Accessory> accessory1 = te.getAccessory1();
			if(accessory1!=null&&accessory1.size()>0){
				i=adao.addAccessory(accessory1);
			}
			List<Accessory> accessory2 = te.getAccessory2();
			if(accessory2!=null&&accessory2.size()>0){
				i=adao.addAccessory(accessory2);
			}
			List<Accessory> accessory3 = te.getAccessory3();
			if(accessory3!=null&&accessory3.size()>0){
				i=adao.addAccessory(accessory3);
			}
			List<Accessory> accessory4 = te.getAccessory4();
			if(accessory4!=null&&accessory4.size()>0){
				i=adao.addAccessory(accessory4);
			}
			List<Accessory> accessory5 = te.getAccessory5();
			if(accessory5!=null&&accessory5.size()>0){
				i=adao.addAccessory(accessory5);
			}
			List<Accessory> accessory6 = te.getAccessory6();
			if(accessory6!=null&&accessory6.size()>0){
				i=adao.addAccessory(accessory6);
			}
			List<Accessory> accessory7 = te.getAccessory7();
			if(accessory7!=null&&accessory7.size()>0){
				i=adao.addAccessory(accessory7);
			}
			List<Accessory> accessory8 = te.getAccessory8();
			if(accessory8!=null&&accessory8.size()>0){
				i=adao.addAccessory(accessory8);
			}
			List<Accessory> accessory9 = te.getAccessory9();
			if(accessory9!=null&&accessory9.size()>0){
				i=adao.addAccessory(accessory9);
			}
			List<Accessory> accessory10 = te.getAccessory10();
			if(accessory10!=null&&accessory10.size()>0){
				i=adao.addAccessory(accessory10);
			}
			List<Accessory> accessory11 = te.getAccessory11();
			if(accessory11!=null&&accessory11.size()>0){
				i=adao.addAccessory(accessory11);
			}
			List<Accessory> accessory12 = te.getAccessory12();
			if(accessory12!=null&&accessory12.size()>0){
				i=adao.addAccessory(accessory12);
			}
			List<Accessory> accessory13 = te.getAccessory13();
			if(accessory13!=null&&accessory13.size()>0){
				i=adao.addAccessory(accessory13);
			}
		//}
		return i;
	}

	@Override
	public int deleteTestingEvaluationById(String id) {
		int i=dao.deleteTestingEvaluationById(id);
		if(i>0){
			List<Accessory> list = adao.selectAccessoryById(id);
			if(list.size()>0&&list!=null){
				i=adao.deleteAccessory(id);
				if(i>0){
					String path="D:"+File.separator+"oa"+File.separator+"TestingEvaluation"+File.separator+id;
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
	public List<Accessory> selectAccessoryById(String id) {
		return adao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return adao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public TestingEvaluation selectTestingEvaluationById(String id) {
		return dao.selectTestingEvaluationById(id);
	}
	
}
