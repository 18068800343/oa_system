package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.ArtificialBudget;
import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.CostBudget;
import org.ldxx.dao.ArtificialBudgetDao;
import org.ldxx.dao.BudgetFpplicationFormDao;
import org.ldxx.dao.CostBudgetDao;
import org.ldxx.dao.EnterpriseDao;
import org.ldxx.service.BudgetFpplicationFormService;
import org.ldxx.util.TimeUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BudgetFpplicationFormServiceImpl implements BudgetFpplicationFormService {

	@Autowired
	private BudgetFpplicationFormDao bdao;
	
	@Autowired
	private CostBudgetDao cdao;
	
	@Autowired
	private ArtificialBudgetDao adao;

	@Override
	public int saveBudge(BudgetFpplicationForm budge) {
		List<CostBudget> costBudget = budge.getCostBudget();
		List<ArtificialBudget> artificialBudget = budge.getArtificialBudget();
		for (int i = 0; i < costBudget.size(); i++) {
			costBudget.get(i).setCbId(budge.getBfId());
		}
		for (int ii = 0; ii < artificialBudget.size(); ii++) {
			artificialBudget.get(ii).setaId(budge.getBfId());
		}
		int i=cdao.addCostBudget(costBudget);
		if(i>0){
			i=adao.addArtificialBudget(artificialBudget);
			if(i>0){
				i=bdao.saveBudge(budge);
			}
		}
		return i;
	}

	@Override
	public int deleteBudgeById(String id) {
		int i = cdao.deleteCostBudgetById(id);
		if(i>0){
			i=adao.deleteArtificialBudgetById(id);
			if(i>0){
				i=bdao.deleteBudgeById(id);
			}
		}
		return i;
	}

	@Override
	public int updateBudge(BudgetFpplicationForm budge) {
		int i=cdao.deleteCostBudgetById(budge.getBfId());
		List<CostBudget> costBudget = budge.getCostBudget();
		for (int ii = 0; ii < costBudget.size(); ii++) {
			costBudget.get(ii).setCbId(budge.getBfId());
		}
		i=adao.deleteArtificialBudgetById(budge.getBfId());
		List<ArtificialBudget> artificialBudget = budge.getArtificialBudget();
		for(int iii=0;iii<artificialBudget.size();iii++){
			artificialBudget.get(iii).setaId(budge.getBfId());
		}
		if(i>0){
			i=bdao.updateBudge(budge);
			if(i>0){
				i=cdao.addCostBudget(budge.getCostBudget());
				i=adao.addArtificialBudget(budge.getArtificialBudget());
			}
		}
		return i;
	}

	@Override
	public List<BudgetFpplicationForm> selectBudgeByStatus(String status) {
		return bdao.selectBudgeByStatus(status);
	}

	@Override
	public BudgetFpplicationForm selectBudgeById(String id) {
		BudgetFpplicationForm budge=bdao.selectBudgeById(id);
		List<CostBudget> costBudget=cdao.selectCostBudgetById(id);
		if(costBudget.size()>0){
			budge.setCostBudget(costBudget);
		}
		List<ArtificialBudget> artificialBudget=adao.selectArtificialBudgetById(id);
		if(artificialBudget.size()>0){
			budge.setArtificialBudget(artificialBudget);
		}
		return budge;
	}

	@Override
	public int changeStateById(String bfId) {
		return bdao.changeStateById(bfId);
	}

	@Override
	public List<BudgetFpplicationForm> selectBudgeHistory(String no) {
		return bdao.selectBudgeHistory(no);
	}

	@Override
	public int countNo() {
		return bdao.countNo();
	}

	@Override
	public BudgetFpplicationForm selectBudgeByNo(String no) {
		return bdao.selectBudgeByNo(no);
	}

	@Override
	public BudgetFpplicationForm selectBudgeByName(String name) {
		return bdao.selectBudgeByName(name);
	}

	@Override
	public float getBudgeCost(String department,String year) {
		return bdao.getBudgeCost(department,year);
	}
}
