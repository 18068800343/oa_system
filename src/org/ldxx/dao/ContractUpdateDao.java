package org.ldxx.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractUpdate;

public interface ContractUpdateDao {

	public int addContractUpdate(@Param("cu")List<ContractUpdate> cu);
	
	public int updateContractUpdate(@Param("cu")ContractUpdate cu);
	
	public ContractUpdate selectContractUpdateByPrjNoAndDept(@Param("no")String no,@Param("dept")String dept);
	
	public ContractUpdate selectGsContractMoneyByTime(@Param("time")String time);//通过时间查询公司新签合同额
	
	public ContractUpdate selectDeptContractMoneyByTime(@Param("time")String time,@Param("dept")String dept);//通过时间查询部门新签合同额
	
	public ContractUpdate selectDeptContractMoneyByTimeAndType(@Param("time")String time,@Param("dept")String dept,@Param("type")String type);//通过时间和项目类型查询新签合同额

	public ContractUpdate selectDeptContractMoneyByStartAndEndTime(@Param("start")String start,@Param("end")String end,@Param("dept")String dept);//查询部门开始时间与结束时间之间的合同额
}
