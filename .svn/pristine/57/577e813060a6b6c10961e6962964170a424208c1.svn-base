package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.BidProject;

public interface ConstructionProjectDao {

	List<BidProject> selectAllcPrj();

	int addcPrj(@Param("bidProject")BidProject bidProject);

	int deletecPrj(@Param("bpId")String bpId);

	int updatecPrj(@Param("bidProject")BidProject bidProject);

	int updatecPrjBidById(@Param("bidProject")BidProject bidProject);

}
