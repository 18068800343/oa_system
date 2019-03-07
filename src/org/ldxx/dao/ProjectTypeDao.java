package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Dictionary;
import org.ldxx.bean.DictionaryFirst;

public interface ProjectTypeDao {
	//新建一级项目类型
	int addOneProjectType(@Param("dictionaryFirst")DictionaryFirst dictionaryFirst);
	
	//删除一级项目类型下的所有二级项目类型
	int deleteOne_TwoPrj(String idFirst);
	
	//删除一级项目类型
	int deleteOnePrj(String idFirst);
	
	//修改一级项目类型
	int updateFirstPrj(@Param("dictionaryFirst")DictionaryFirst dictionaryFirst);
	
	//查所有一级项目类型
	List<DictionaryFirst> selectAllFirstPrj();
	
	//添加二级项目类型
	int addTwoPrj(@Param("dictionary")Dictionary dictionary);
	
	//删除二级项目类型
	int deleteTwoPrj(String dId);
	
	//修改二级项目类型
	int updateTwoPrj(@Param("dictionary")Dictionary dictionary);

	//查所有二级项目类型
	List<Dictionary> selectAllTwoPrj();

	//查看一级项目类型下的所有二级项目
	List<Dictionary> selectOne_TwoPrj(String idFirst);


	//查看所有一级成本科目
	List<DictionaryFirst> selectAllFirstcostSubjects();

	DictionaryFirst selectOneIdByName(@Param("nameFirst")String nameFirst);

	public List<Dictionary> selectAllSecond();
	
	public List<Dictionary> selectSecondPrjType(@Param("type")String type);
	
}
