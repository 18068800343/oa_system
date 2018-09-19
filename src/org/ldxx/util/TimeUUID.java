package org.ldxx.util;

import java.util.UUID;

public class TimeUUID {

	public String getTimeUUID(){
		UUID id=UUID.randomUUID();
        String[] idd=id.toString().split("-");
        return idd[0]+idd[1];
	}
	
	public static void main(String[] args) {
		System.out.println(new TimeUUID().getTimeUUID());
	}
}
