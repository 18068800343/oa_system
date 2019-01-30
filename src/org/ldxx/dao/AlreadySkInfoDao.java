package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkOmInfo;

public interface AlreadySkInfoDao {


	int addAlreadySkOmInfo(@Param("skOmInfo")AlreadySkOmInfo skOmInfo);

	int addAlreadyRenling(@Param("ar")AlreadyRenling ar);

	AlreadyRenling getyirenlingfpMoneyByKpno(@Param("kpno")String kpno);

	AlreadyRenling getyirenlingfpMoneyByskno(@Param("skNo")String skNo);

	List<AlreadyRenling> selectAlreadyRenling(@Param("seachPrjName")String seachPrjName,@Param("seachMainDepartment") String seachMainDepartment);

	List<AlreadyRenling> selectAlreadySkBySkno(@Param("skno")String skno);

	int deleteAlreadyRenlingById(@Param("rId")String rId);

	int deleteAlreadySkOmInfoByrId(@Param("rId")String rId);
	
	public AlreadyRenling selectGsRenlingByTime(@Param("time")String time);//通过时间查询公司全部认领金额
	
	public AlreadyRenling selectDeptRenlingByTime(@Param("time")String time,@Param("dept")String dept);//通过时间查询部门全部认领金额

	public AlreadyRenling selectDeptRenlingByTimeAndType(@Param("time")String time,@Param("dept")String dept,@Param("type")String type);//通过时间和项目类型查询全部认领金额

	public AlreadyRenling selectDeptRenlingByStartAndEndTime(@Param("start")String start,@Param("end")String end,@Param("dept")String dept);//通过开始时间结束时间查询部门已认领金额

	public double getAllSkByTaskNo(@Param("no")String no);
}
