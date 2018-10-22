package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.GsClOut;

public interface GsClOutService {

	List<GsClOut> selectClByNo(String no);
	
	List<GsClOut> selectClListByNo(String no);
	
	List<GsClOut> selectClListByName(String name);
	
	int updateRemain(String id,int remain);
	
	List<GsClOut> selectClListByIds(String cgNo,String cgName,String taskNo);
	
	List<GsClOut> selectClListByIds2(String cgNo,String cgName,String name);
}
