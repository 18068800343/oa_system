package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.OtherContract;

public interface OtherContractDao {

	public int addOtherContract(@Param("other")OtherContract other);
	
	public int deleteOtherContract(@Param("id")String id);
	
	public List<OtherContract> selectOtherContract(@Param("status")String status);
	
	public int updateOtherContract(@Param("other")OtherContract other);
	
	public List<OtherContract> selectCjHistory(@Param("no")String no);
	
	public int countNo(@Param("year")String year);

	public OtherContract selectOtherContractById(@Param("id")String id);

	public OtherContract selectOtherContractByNo(@Param("no")String no);
	
	public List<OtherContract> selectOtherContractMoneyBySignTime(@Param("time")String time);
	
	public List<OtherContract> selectOtherContractMoneyBySignTimeAndDepartment(@Param("time")String time,@Param("department")String department);

	public int updateHistoryById(@Param("id")String id);

	public int updateHistoryNow(@Param("id")String id);
	
	public int updateOnoById(@Param("id")String id,@Param("no")String no);

	public List<OtherContract> selectOtherContract2();
}
