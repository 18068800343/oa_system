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
	
	public String getClCode(String omNo,int count){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		String year=sdf.format(new Date());
		String y=String.valueOf(count);
		if(y.length()==1){
			y="000"+y;
		}else if(y.length()==2){
			y="00"+y;
		}
		String clCode=year+omNo+y;
		return clCode;
	}
	//投标人(ZS、HT、HH)+项目类型（JC、SG、SJ、EPC、QT）+年月+流水号（按年，3位）
	public String getSerialNumber(String bidder,String type,int count){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMM");
		String year=sdf.format(new Date());
		String y=String.valueOf(count);
		if(y.length()==1){
			y="00"+y;
		}else if(y.length()==2){
			y="0"+y;
		}else if(y.length()==3){
			y="0"+y;
		}
		String PrjNo=bidder+type+year+y;
		return PrjNo;
	}
	//用户编码
	public String getUserCode(int count){
		String y=String.valueOf(count);
		if(y.length()==1){
			y="000"+y;
		}else if(y.length()==2){
			y="00"+y;
		}else if(y.length()==3){
			y="0"+y;
		}
		String userCode="U"+y+"#";
		return userCode;
	}
	
	public static String getTimeByFmt(String fmt,Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(fmt);
		return simpleDateFormat.format(date);
	}
	public static void main(String[] args) {
		TimeUUID uuid=new TimeUUID();
		String aa=uuid.getPrjCode("", 80);
		System.out.println(aa);
	}
}
