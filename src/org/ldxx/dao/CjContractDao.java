package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.CjContract;
import org.ldxx.bean.CjDeptSplitMoney;
import org.ldxx.bean.CjSplitMoney;

public interface CjContractDao {

	public int addCjContract(@Param("cj")CjContract cj);
	
	public int updateCjContract(@Param("cj")CjContract cj);
	
	public List<CjContract> selectCjContractByStatus(@Param("status")String status,@Param("startMin") String startMin,@Param("startMax") String startMax,@Param("endMin") String endMin,@Param("endMax") String endMax,@Param("mainDp") String mainDp,@Param("xbDp") String xbDp,@Param("contractMoneyMin") Double contractMoneyMin,@Param("contractMoneyMax") Double contractMoneyMax,@Param("zdMoneyMin") Double zdMoneyMin,@Param("zdMoneyMax") Double zdMoneyMax);
	
	public CjContract selectCjContractById(@Param("id")String id);
	
	public int deleteCjContract(@Param("id")String id);
	
	public List<CjContract> selectIdAndName();
	
	public List<CjContract> selectContractNoById(@Param("id")String id);
	
	public List<CjContract> selectContractByTaskNo(@Param("no")String no);
	
	public List<CjContract> selectCjByName(@Param("name")String name);
	
	public List<CjContract> selectCjByNo(@Param("no")String no);
	
	public List<CjContract> selectCjHistory(@Param("no")String no);
	
	public int countNo(@Param("year")String year);

	public List<CjContract> selectNameAndNo();

	public CjContract selectCjContractByName(@Param("name")String name);

	public CjContract selectCjContractByNo(@Param("no")String no);
	
	public List<CjContract> selectCjContractByTaskNo(@Param("no")String no);

	public int addCjSplitMoneySave(@Param("cs") List<CjSplitMoney> cs);

	public List<CjSplitMoney> selectCjSplitMoneyById(@Param("id")String id);

	public CjContract selectCjByCjNo(@Param("no")String no);
	
	public List<CjContract> selectNoAndMoneyByDepartment(@Param("department")String department,@Param("year")String year);

	public List<CjContract> selectCjContractMoneyBySignTime(@Param("time")String time);
	
	public CjContract getCjContractMainDepartmentLeader(@Param("no")String no);

	public int updateHistoryById(@Param("id")String id);

	public int updateHistoryNow(@Param("id")String id);
	
	public int deleteCjSplitMoneyById(@Param("id")String id);
	
	public int addCjDeptSplitMoney(@Param("dept")List<CjDeptSplitMoney> dept);
	
	public List<CjDeptSplitMoney> selectCjDeptSplitMoney(@Param("id")String id,@Param("dept")String dept);

	public CjContract selectCjContractLikeTaskNo(@Param("no")String no);
	
	public int updateCjContractMoney(@Param("no")String no,@Param("money")Double money);
	
	public CjContract selectCjContractLikeTaskCode(@Param("no")String no);
	
	public int updateCjNoById(@Param("no")String no,@Param("id")String id);
	
	public String CreateContractNumOrder(@Param("type")String type,@Param("year")String year);
	
}
