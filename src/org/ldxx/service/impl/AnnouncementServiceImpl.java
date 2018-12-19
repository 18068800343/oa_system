package org.ldxx.service.impl;

import java.util.List;

import org.ldxx.bean.Accessory;
import org.ldxx.bean.Announcement;
import org.ldxx.dao.AccessoryDao;
import org.ldxx.dao.AnnouncementDao;
import org.ldxx.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired
	private AnnouncementDao adao;
	
	@Autowired
	private AccessoryDao dao;
	
	@Transactional
	@Override
	public int addAnnouncement(Announcement announcement) {
		int i=adao.addAnnouncement(announcement);
		if(i>0){
			List<Accessory> accessory=announcement.getAccessory();
			if(accessory !=null){
				i=dao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Transactional
	@Override
	public int deleteAnnouncement(String id) {
		int i=adao.deleteAnnouncement(id);
		if(i>0){
			i=dao.deleteAccessory(id);
		}
		return i;
	}

	@Transactional
	@Override
	public int updateAnnouncement(Announcement announcement) {
		int i=adao.updateAnnouncement(announcement);
		if(i>0){
			List<Accessory> accessory=announcement.getAccessory();
			if(accessory !=null){
				i=dao.addAccessory(accessory);
			}
		}
		return i;
	}

	@Override
	public List<Announcement> selectAnnouncement(String type,String status) {
		return adao.selectAnnouncement(type,status);
	}

	@Override
	public int deleteAccessory(String id) {
		return dao.deleteAccessory(id);
	}

	@Override
	public List<Accessory> selectAccessory(String id) {
		return dao.selectAccessoryById(id);
	}

	@Override
	public int deleteAccessoryByIdAndName(Accessory accessory) {
		return dao.deleteAccessoryByIdAndName(accessory);
	}

	@Override
	public Announcement selectAnnouncementById(String id) {
		return adao.selectAnnouncementById(id);
	}

}
