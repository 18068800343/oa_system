package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.ldxx.bean.BackUpDataBase;
import org.ldxx.dao.AutoBackUpDataBaseDao;
import org.ldxx.util.CMDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class AutoBackUpDataBaseController {

	
	@Autowired
	private AutoBackUpDataBaseDao dao;
	
	@Scheduled(cron = "0 0 23 * * ?")
	private void test(){
		System.out.println("准备运行备份命令");
		String path = CMDUtil.buildSqlBack();
		if(path==null){
			System.out.println("备份文件创建失败！");
		}else{
			BackUpDataBase bd = new BackUpDataBase();
			bd.setCreatetime( new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			bd.setCreateuser("系统");
			bd.setMemo("系统自动备份");
			bd.setPath(path);
			dao.insertDataBaseBack(bd);
 			System.out.println(path);
		}
	}

}
