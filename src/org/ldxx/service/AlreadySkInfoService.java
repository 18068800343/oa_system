package org.ldxx.service;

import java.util.List;

import org.ldxx.bean.AlreadyRenling;
import org.ldxx.bean.AlreadySkInfo;

public interface AlreadySkInfoService {

	int addAlreadyRenling(AlreadyRenling ar);

	AlreadyRenling getyirenlingfpMoneyByKpno(String kpno);

}
