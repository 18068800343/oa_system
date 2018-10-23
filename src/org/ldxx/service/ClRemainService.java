package org.ldxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.ClRemain;
import org.ldxx.bean.CompanyMateriaOut;
import org.ldxx.bean.GsClOut;
import org.ldxx.bean.outRemain;

public interface ClRemainService {

	public int addClRemain(List<ClRemain> cr);
	
	public List<GsClOut> 	selectGsClOutById(String id);
	
	public int remainUse(CompanyMateriaOut cm);
	
	public int updateClRemain(List<outRemain> out);

	public List<ClRemain> selectClRemainById(String id);
	
}
