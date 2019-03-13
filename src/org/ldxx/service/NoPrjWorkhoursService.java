package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.NoPrjWorkhours;

public interface NoPrjWorkhoursService {

	int addNoPrjWorkhours(NoPrjWorkhours no);

	int deleteNoPrjWorkhours(String id);

	int updateNoPrjWorkhours(NoPrjWorkhours no);

	List<NoPrjWorkhours> selectNoPrjWorkhours();

}
