package org.ldxx.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class LoopJobListener implements ServletContextListener {
	public static ScheduledThreadPoolExecutor schedule;
    public LoopJobListener() {
    	 schedule = new ScheduledThreadPoolExecutor(6);
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
    	
    }

    public void contextInitialized(ServletContextEvent arg0)  {
    	long waitTime = 21600;
//    	long waitTime = 60;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		Date nowDate = new Date();
		String nowDateStr = simpleDateFormat.format(nowDate).substring(0, 10);
		System.out.println(nowDateStr);
	      try {
			Date date = simpleDateFormat.parse(nowDateStr+" 23:00:00");
			waitTime = (date.getTime()-nowDate.getTime())/1000;
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    System.out.println(waitTime);
    	schedule.scheduleWithFixedDelay(new AutoDataBase(), waitTime, 86400, TimeUnit.SECONDS);
    }
}
