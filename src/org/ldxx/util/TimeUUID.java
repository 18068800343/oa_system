package org.ldxx.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TimeUUID {

	public String getTimeUUID(){
		UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1];
	}
	
	public String getPrjCode(String code,int count){
		String prjCode="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
		String year=sdf.format(new Date());
		String y=String.valueOf(count);
		if(y.length()==1){
			y="000"+y;
		}else if(y.length()==2){
			y="00"+y;
		}else if(y.length()==3){
			y="0"+y;
		}
		prjCode=year+y+code;
		return prjCode;
	}
	
	public static void main(String[] args) {
		TimeUUID uuid=new TimeUUID();
		String aa=uuid.getPrjCode("A1", 80);
		System.out.println(aa);
	}
}
