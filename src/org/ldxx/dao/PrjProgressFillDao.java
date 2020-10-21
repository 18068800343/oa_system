package org.ldxx.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.PrjProgressFill;
import org.ldxx.bean.PrjProgressFillCj;
import org.ldxx.bean.PrjProgressFillFb;
import org.ldxx.bean.PrjProgressFillInfo;

public interface PrjProgressFillDao {

	public int addPrjProgressFill(@Param("ppf")PrjProgressFill ppf);
	
	public int addPrjProgressFillInfo(@Param("ppfi")List<PrjProgressFillInfo> ppfi);
	
	public List<PrjProgressFill> selectPrjProgressFill(@Param("status")String status);
	
	public PrjProgressFill selectPrjProgressFillById(@Param("id")String id);
	
	public List<PrjProgressFillInfo> selectPrjProgressFillInfo(@Param("id")String id,@Param("type")String type);
	
	public PrjProgressFill selectLastPrjProgressFill(@Param("no")String no);
	
	public PrjProgressFillInfo getLastByDepartmentAndId(@Param("id")String id,@Param("department")String department);

	public int addPrjProgressFillCj(@Param("ppcj")PrjProgressFillCj ppcj);
	
	/*public PrjProgressFillCj cjBq(@Param("ppfId")String ppfId,@Param("cjId")String cjId);*/
	
	public List<PrjProgressFillCj> selectPrjProgressFillCjById(@Param("id")String id);
	
	public List<PrjProgressFill> selectPrjProgressFillByStatus(@Param("status")int status);
	
	public int updateStatusAndDesc(@Param("status")int status,@Param("infos")String infos,@Param("id")String id);

	public List<PrjProgressFill> selectDistinctTaskNo(@Param("year")String year);
	
	public PrjProgressFill getCost(@Param("no")String no);
	
	public BigDecimal getDepartmentCost(@Param("department")String department,@Param("id")String id);
	
	public int countOfDepartmentCost(@Param("department")String department,@Param("id")String id);

	public List<PrjProgressFill> selectPrjProgressFillByYear(@Param("status")String status,@Param("y") String y);
	
	public PrjProgressFill selectAllCostAndJd(@Param("no")String taskNo);
	
	public List<PrjProgressFill> selectDepartmentIncome(@Param("department")String department,@Param("start")String start,@Param("end")String end);
	
	public PrjProgressFillInfo selectYearCostByDepartment(@Param("department")String department,@Param("year")String year);

	public List<PrjProgressFill> selectThisTimeIncomeByDepartment(@Param("department")String department,@Param("time")String time);
	
	public List<PrjProgressFill> selectThisTimeIncomeByDepartmentAndPrjType(@Param("department")String department,@Param("time")String time,@Param("type")String type);

	public List<PrjProgressFill> selectNewest();
	
	public int updatePrjProgressFill(@Param("ppf")PrjProgressFill ppf);
	
	public int deletePrjProgressFillInfoById(@Param("id")String id);
	
	public int deletePrjProgressFillCjById(@Param("id")String id);
	
	public int deletePrjProgressFillFbById(@Param("id")String id);
	
	public int updateAllIncomeAndCost(@Param("ppf")PrjProgressFill ppf);
	
	public CjContract selectCjContractAndPrjProgressFillCj(@Param("no")String no);
	
	public int addPrjProgressFillFb(@Param("fb")List<PrjProgressFillFb> fb);
	
	public PrjProgressFillFb selectPrjProgressFillFbByFbId(@Param("id")String id);
	
	public PrjProgressFillCj selectPrjProgressFillCjIncomeBq(@Param("id")String id,@Param("bq")String bq);
	
	public int selectPrjProgressFillCjCountByIdAndBq(@Param("id")String id,@Param("bq")String bq);
	
	public int updatePrjProgressFillCjByIdAndBq(@Param("cj")PrjProgressFillCj cj);
	
	public PrjProgressFillInfo selectPrjProgressFillInfoTotalByTaskAndDept(@Param("no")String no,@Param("dept")String dept);
	
	public List<PrjProgressFillFb> selectPrjProgressFillFbByPpfId(@Param("id")String id);
	
	public PrjProgressFill selectGsIncomeByTime(@Param("time")String time);//通过时间查询公司累计收入
	
	public PrjProgressFill selectGsIncomeByTimeAndDept(@Param("time")String time,@Param("dept")String dept);//通过时间和部门查询公司累计收入
	
	public PrjProgressFill selectDeptIncomeByTimeAndType(@Param("time")String time,@Param("dept")String dept,@Param("type")String type);//通过时间和项目类型查询公司累计收入

	public PrjProgressFill selectTotalIncome(@Param("dept")String dept,@Param("start")String start,@Param("end")String end);

	public PrjProgressFill selectNewPlanByTaskNo(@Param("no")String no);
	
	public PrjProgressFillFb selectNewFbInfoByFbId(@Param("no")String no);

	public List<PrjProgressFill> getmoneyYuanByDepartmentAndDate(@Param("nowStr")String nowStr,@Param("time") String time);

	public BigDecimal getSummoneyYuan(@Param("nowStr")String nowStr,@Param("time") String time);

	public int updateBackState(@Param("backState")String backState,@Param("id") String id);

	public int updateStatusById(@Param("status")int status,@Param("id") String id);
	
	public int getCountLatelyMonthFirstppf(@Param("taskNo")String taskNo,@Param("thisTime")String thisTime);
	
	public PrjProgressFill getLatelyMonthFirstppf(@Param("taskNo")String taskNo);
}
