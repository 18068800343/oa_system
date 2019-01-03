package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Announcement;
import org.ldxx.bean.FbContract;

public interface AnnouncementDao {

	public int addAnnouncement(@Param("announcement")Announcement announcement);
	
	public int deleteAnnouncement(@Param("id")String id);
	
	public int updateAnnouncement(@Param("announcement")Announcement announcement);
	
	public List<Announcement> selectAnnouncement(@Param("type")String type,@Param("status")String status);
	
	public List<Announcement> selectAnnouncement2(@Param("type")String type,@Param("status")String status,@Param("department")String department);

	public Announcement selectAnnouncementById(@Param("id")String id);
	
	List<FbContract> selectHuankuanFbByTaskNo(@Param("taskNo")String taskNo);
}
