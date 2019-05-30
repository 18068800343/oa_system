package org.ldxx.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getDateStrByPattern(String pattern,Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String string = simpleDateFormat.format(date);
		return string;
	}
	
	public static void main(String[] args) {
		
	}
}
