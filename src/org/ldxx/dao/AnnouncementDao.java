package org.ldxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.ldxx.bean.Announcement;

public interface AnnouncementDao {

	public int addAnnouncement(@Param("announcement")Announcement announcement);
	
	public int deleteAnnouncement(@Param("id")String id);
	
	public int updateAnnouncement(@Param("announcement")Announcement announcement);
	
	public List<Announcement> selectAnnouncement(@Param("type")String type,@Param("status")String status);
}
