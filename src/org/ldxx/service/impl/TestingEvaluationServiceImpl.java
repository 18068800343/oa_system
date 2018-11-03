package org.ldxx.service.impl;

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
		for(int i=0;i<list.size();i++){
			String id=list.get(i).getTeId();
			List<Accessory> accessory1 = adao.selectAccessoryByIdAndType(id, "项目实际存档目录");
			list.get(i).setAccessory1(accessory1);
			List<Accessory> accessory2 = adao.selectAccessoryByIdAndType(id, "项目特点介绍、关键词");
			list.get(i).setAccessory2(accessory2);
			List<Accessory> accessory3 = adao.selectAccessoryByIdAndType(id, "招投标文件");
			list.get(i).setAccessory3(accessory3);
			List<Accessory> accessory4 = adao.selectAccessoryByIdAndType(id, "合同资料");
			list.get(i).setAccessory4(accessory4);
			List<Accessory> accessory5 = adao.selectAccessoryByIdAndType(id, "出版报告");
			list.get(i).setAccessory5(accessory5);
			List<Accessory> accessory6 = adao.selectAccessoryByIdAndType(id, "计算模型、计算书");
			list.get(i).setAccessory6(accessory6);
			List<Accessory> accessory7 = adao.selectAccessoryByIdAndType(id, "外部评审意见");
			list.get(i).setAccessory7(accessory7);
			List<Accessory> accessory8 = adao.selectAccessoryByIdAndType(id, "校审资料");
			list.get(i).setAccessory8(accessory8);
			List<Accessory> accessory9 = adao.selectAccessoryByIdAndType(id, "技术方案");
			list.get(i).setAccessory9(accessory9);
			List<Accessory> accessory10 = adao.selectAccessoryByIdAndType(id, "重点项目的项目总结");
			list.get(i).setAccessory10(accessory10);
			List<Accessory> accessory11 = adao.selectAccessoryByIdAndType(id, "重点项目质量流程控制文件");
			list.get(i).setAccessory11(accessory11);
			List<Accessory> accessory12 = adao.selectAccessoryByIdAndType(id, "依据设计图纸");
			list.get(i).setAccessory12(accessory12);
			List<Accessory> accessory13 = adao.selectAccessoryByIdAndType(id, "其它");
			list.get(i).setAccessory13(accessory13);
		}
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
		int i=dao.updateTestingEvaluationSave(te);
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
	public int deleteTestingEvaluationById(String id) {
		int i=dao.deleteTestingEvaluationById(id);
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
	
}
