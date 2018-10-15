/**
 * <p>Title: MaterialDemandController.java</p>
 * <p>Description: 华通桥涵管理系统</p>
 * <p>Company: 环水信息技术有限公司</p>
 * @author 马潇霄
 * @version 1.0 创建时间：2018年10月12日 下午4:38:32
 */

package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.MaterialDemand;
import org.ldxx.service.MaterialDemandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("md")
public class MaterialDemandController {

	@Autowired
	private MaterialDemandService service;
	
	@RequestMapping("/selectMaterialDemandById")
	@ResponseBody
	public List<MaterialDemand> selectMaterialDemandById(String id){
		return service.selectMaterialDemandById(id);
	}
	
}
