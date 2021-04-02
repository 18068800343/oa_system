package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ContractWork;
import org.ldxx.bean.ContractWorkTask;
import org.ldxx.bean.Task;

public interface ContractWorkDao {

	public int addContractWork(@Param("work")ContractWork work);
	
	public List<ContractWork> selectContractWork(@Param("type")String type,@Param("status")String status);
	
	public List<ContractWork> selectContractWork2(@Param("type")String type);
	
	public ContractWork selectContractWorkByNo(@Param("no")String no);
	
	public ContractWork getContractMoney(@Param("no")String no);

	public ContractWork selectContractWorkByid(@Param("id")String id);

	public ContractWork selectContractWorkBytaskNoAndCno(@Param("no")String no, @Param("type")String type);
	
	public int updateContractWork2(@Param("work")ContractWork work);
	
	public int updateContractWork3(@Param("work")ContractWork work);

	public List<ContractWork> selectContractWorkByprjNo(@Param("pNo")String pNo,@Param("type")String type);

	public List<ContractWork> selectContractWorkByCjNo(String cjNo);
	
	public List<ContractWork> selectContractWorkByCjNoStatusIn12(@Param("cjNo")String cjNo,@Param("type")String type);

	public int addContractWorkTask(@Param("task")Task task,@Param("id")String id);
	public List<ContractWorkTask> selectContractWorkTaskBycwid(@Param("id")String id);

	public int getCount(@Param("id")String id, @Param("prjId")String prjId);

	public int updateContractWorkTask(@Param("task")Task task,@Param("id")String id);
}
