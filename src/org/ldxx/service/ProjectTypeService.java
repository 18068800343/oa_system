package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Dictionary;
import org.ldxx.bean.DictionaryFirst;

public interface ProjectTypeService {

	int addOneProjectType(DictionaryFirst dictionaryFirst);
	
	int deleteFirstPrj(String idFirst);
	
	int updateFirstPrj(DictionaryFirst dictionaryFirst);
	
	List<DictionaryFirst> selectAllFirstPrj();
	
	int addTwoPrj(Dictionary dictionary);
	
	int deleteTwoPrj(String dId);
	
	int updateTwoPrj(Dictionary dictionary);

	List<Dictionary> selectAllTwoPrj();

	List<Dictionary> selectOne_TwoPrj(String idFirst);

	int addFirstcostSubjects(DictionaryFirst dictionaryFirst);

	List<DictionaryFirst> selectAllFirstcostSubjects();

	DictionaryFirst selectOneIdByName(String nameFirst);
	
	public List<Dictionary> selectAllSecond();

}
