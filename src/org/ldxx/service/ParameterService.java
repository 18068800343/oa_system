package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.Parameter;

public interface ParameterService {

	List<Parameter> selectParameter();

	int addParameter(Parameter p);

	int deleteParameter(String id);

	int updateParameter(Parameter p);

}
