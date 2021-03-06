package org.ldxx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.ldxx.bean.ArtificialBudget;
import org.ldxx.bean.BudgetFpplicationForm;
import org.ldxx.bean.BudgetMainMaterial;
import org.ldxx.bean.CostBudget;
import org.ldxx.dao.ArtificialBudgetDao;
import org.ldxx.dao.BudgetFpplicationFormDao;
import org.ldxx.dao.BudgetMainMaterialDao;
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
	@Autowired
	private BudgetMainMaterialDao mainMaterialdao;

	@Override
	public int saveBudge(BudgetFpplicationForm budge) {
		int  i=bdao.saveBudge(budge);
		if(i>0){
			List<CostBudget> costBudget = budge.getCostBudget();
			if(costBudget.size()!=0){
				for (int k = 0; k < costBudget.size(); k++) {
					costBudget.get(k).setCbId(budge.getBfId());
				}
				i=cdao.addCostBudget(costBudget);
			}
			List<BudgetMainMaterial> budgetMainMaterial = budge.getBudgetMainMaterial();
			if(budgetMainMaterial.size()!=0){
				for(int j=0;j<budgetMainMaterial.size();j++){
					budgetMainMaterial.get(j).setbId(budge.getBfId());
				}
				i=mainMaterialdao.addBudgetMainMaterial(budgetMainMaterial);
			}
			/*List<ArtificialBudget> artificialBudget = budge.getArtificialBudget();
			if(artificialBudget.size()!=0){
				for (int ii = 0; ii < artificialBudget.size(); ii++) {
					artificialBudget.get(ii).setaId(budge.getBfId());
				}
			}
			i=adao.addArtificialBudget(artificialBudget);*/
		}
		return i;
	}

	@Override
	public int deleteBudgeById(String id) {
		int i=bdao.deleteBudgeById(id);
		if(i>0){
			//i=adao.deleteArtificialBudgetById(id);
			i = cdao.deleteCostBudgetById(id);
			i=mainMaterialdao.deleteBudgetMainMaterialById(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateBudge(BudgetFpplicationForm budge) {
		/*i=adao.deleteArtificialBudgetById(budge.getBfId());
		List<ArtificialBudget> artificialBudget = budge.getArtificialBudget();
		for(int iii=0;iii<artificialBudget.size();iii++){
			artificialBudget.get(iii).setaId(budge.getBfId());
		}*/
		int i=bdao.updateBudge(budge);
		if(i>0){
			cdao.deleteCostBudgetById(budge.getBfId());
			List<CostBudget> costBudget = budge.getCostBudget();
			if(costBudget.size()>0&&costBudget!=null){
				for (int ii = 0; ii < costBudget.size(); ii++) {
					costBudget.get(ii).setCbId(budge.getBfId());
				}
				cdao.addCostBudget(costBudget);
			}
			//i=adao.addArtificialBudget(budge.getArtificialBudget());
			mainMaterialdao.deleteBudgetMainMaterialById(budge.getBfId());
			List<BudgetMainMaterial> budgetMainMaterial = budge.getBudgetMainMaterial();
			if(budgetMainMaterial!=null&&budgetMainMaterial.size()>0){
				for(int k=0;k<budgetMainMaterial.size();k++){
					budgetMainMaterial.get(k).setbId(budge.getBfId());
				}
				mainMaterialdao.addBudgetMainMaterial(budgetMainMaterial);
			}
		}
		return i;
	}

	@Override
	public BudgetFpplicationForm selectBudgeById(String id) {
		BudgetFpplicationForm budge=bdao.selectBudgeById(id);
		List<CostBudget> costBudget=cdao.selectCostBudgetById(id);
		if(costBudget.size()>0){
			budge.setCostBudget(costBudget);
		}
		/*List<ArtificialBudget> artificialBudget=adao.selectArtificialBudgetById(id);
		if(artificialBudget.size()>0){
			budge.setArtificialBudget(artificialBudget);
		}*/
		List<BudgetMainMaterial> budgetMainMaterial = mainMaterialdao.selectBudgetMainMaterialById(id);
		if(budgetMainMaterial.size()>0){
			budge.setBudgetMainMaterial(budgetMainMaterial);
		}
		return budge;
	}

	@Override
	public List<BudgetFpplicationForm> selectBudgeHistory(String no) {
		return bdao.selectBudgeHistory(no);
	}

	@Override
	public int countNo(String year) {
		year="%"+year+"%";
		return bdao.countNo(year);
	}

	@Override
	public BudgetFpplicationForm selectBudgeByNo(String no) {
		BudgetFpplicationForm budge = new BudgetFpplicationForm();
		try {
			budge = bdao.selectBudgeByNoAllCost(no);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(budge!=null){
			List<CostBudget> costBudget=cdao.selectCostBudgetById(budge.getBfId());
			if(costBudget!=null){
				budge.setCostBudget(costBudget);
			}
			List<BudgetMainMaterial> budgetMainMaterial = mainMaterialdao.selectBudgetMainMaterialById(budge.getBfId());
			if(budgetMainMaterial!=null){
				budge.setBudgetMainMaterial(budgetMainMaterial);
			}
		}
		return budge;
	}

	@Override
	public BudgetFpplicationForm selectBudgeByName(String name) {
		BudgetFpplicationForm budge = bdao.selectBudgeByName(name);
		if(budge!=null){
			List<CostBudget> costBudget=cdao.selectCostBudgetById(budge.getBfId());
			if(costBudget.size()>0){
				budge.setCostBudget(costBudget);
			}
			List<BudgetMainMaterial> budgetMainMaterial = mainMaterialdao.selectBudgetMainMaterialById(budge.getBfId());
			if(budgetMainMaterial.size()>0){
				budge.setBudgetMainMaterial(budgetMainMaterial);
			}
		}
		return budge;
	}

	@Override
	public BigDecimal getBudgeCost(String department,String year) {
		return bdao.getBudgeCost(department,year);
	}

	@Override
	public BudgetFpplicationForm getAllCost(String no) {
		return bdao.getAllCost(no);
	}

	@Override
	public List<BudgetFpplicationForm> selectBudgeByStatus(String status, String timeMin, String timeMax, BigDecimal costMin,
			BigDecimal costMax) {
		return bdao.selectBudgeByStatus(status, timeMin, timeMax, costMin, costMax);
	}

	@Override
	public int updateHistoryById(String id) {
		int i=bdao.updateHistoryById(id);
		//if(i>0){
			i=bdao.changeStateById(id);
		//}
		return i;
	}

	@Override
	public CostBudget selectNwCostByTaskNo(String no,String type) {
		return bdao.selectNwCostByTaskNo(no,type);
	}

	@Override
	public List<CostBudget> selectNwCostByTaskNoAndDept(String no, String type) {
		return bdao.selectNwCostByTaskNoAndDept(no, type);
	}

	@Override
	public int updateBfNoById(String id, String code) {
		return bdao.updateBfNoById(id,code);
	}

	@Override
	public String CreateBudgetNumOrder(String year) {
		return bdao.CreateBudgetNumOrder(year);
	}

	@Override
	public List<BudgetFpplicationForm> selectBudgeByStatus2(String status, String timeMin, String timeMax,
			BigDecimal costMin, BigDecimal costMax) {
		return bdao.selectBudgeByStatus2(status,timeMin,timeMax,costMin,costMax);
	}

	@Override
	public BigDecimal getSumAllCost(String no) {
		// TODO Auto-generated method stub
		return bdao.getSumAllCost(no);
	}

	@Override
	public int taskNoisExist(String no) {
		// TODO Auto-generated method stub
		return bdao.taskNoisExist(no);
	}

	@Override
	public int xgtaskNoisExist(String taskNo, String bfId) {
		// TODO Auto-generated method stub
		return bdao.xgtaskNoisExist(taskNo,bfId);
	}

}
