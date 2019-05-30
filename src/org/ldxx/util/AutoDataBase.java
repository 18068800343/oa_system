package org.ldxx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.ldxx.bean.BackUpDataBase;
import org.ldxx.dao.AutoBackUpDataBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoDataBase implements Runnable{

public static AutoDataBase INSTANCE; 
	
	@PostConstruct // 第三步  
    public void init() {  
        INSTANCE = this;
        INSTANCE.dao=this.dao;
    } 
	
	@Autowired
	private AutoBackUpDataBaseDao dao;
	
	@Override
	public void run() {
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
			INSTANCE.dao.insertDataBaseBack(bd);
 			System.out.println(path);
		}
	}

	public static void main(String[] args) {
		new Thread(new AutoDataBase()).start();
	}
}
