package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.NoPrjWorkhours;

public interface NoPrjWorkhoursDao {

	int addNoPrjWorkhours(@Param("no")NoPrjWorkhours no);

	int deleteNoPrjWorkhours(@Param("id")String id);

	int updateNoPrjWorkhours(@Param("no")NoPrjWorkhours no);

	List<NoPrjWorkhours> selectNoPrjWorkhours();

}
