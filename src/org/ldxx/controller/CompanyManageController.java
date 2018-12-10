/**
 * <p>Title: CompanyManageController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年12月10日 下午1:54:29
 */

package org.ldxx.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
* @ClassName: CompanyManageController 
* @Description: 公司经营情况
* @author zhaohui
* @date 2018年12月10日 下午1:54:29 
*  
*/
@Controller
@RequestMapping("/")
public class CompanyManageController {

	@RequestMapping("/selectCompanyManage")
	@ResponseBody
	public Map<String,Object> selectCompanyManage(String endTime){
		Map<String,Object> map=new HashMap<String, Object>();
		String year=endTime.split("-")[0];
		String startTime=year+"-01-01 00:00:01";
		endTime=endTime=" 23:59:59";
		
		return map;
	}
	
}
