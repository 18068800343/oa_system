package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.NoPrjWorkhoursP;

public interface NoPrjWorkhoursPDao {

	int addNoPrjWorkhoursP(@Param("workhoursP")List<NoPrjWorkhoursP> workhoursP);

	int deleteNoPrjWorkhoursPByNpId(@Param("id")String id);

	List<NoPrjWorkhoursP> selectNoPrjWorkhoursPByNpId(@Param("npId")String npId);

}
