package org.ldxx.util;
import rtx.RTXSvrApi;   
public class SendSms{
    
	public int sendMessage(String receivers,String title,String msg,String type,String delayTime){
		int iRet= -1;
    	RTXSvrApi  RtxsvrapiObj = new RTXSvrApi();   
    	if( RtxsvrapiObj.Init()){
        		iRet = RtxsvrapiObj.sendNotify(receivers,title,msg, type,delayTime);
        		if (iRet == 0){
        			System.out.println("成功");
        		}else{
        			System.out.println("失败");
        		}

        	}
        	RtxsvrapiObj.UnInit();
        	return iRet;
	}
}
