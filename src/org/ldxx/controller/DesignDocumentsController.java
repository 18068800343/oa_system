package org.ldxx.controller;

import java.util.List;

import org.ldxx.bean.DesignDocuments;
import org.ldxx.service.DesignDocumentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 新建设计文件资料
 * @author hp
 */
@RequestMapping("DesignDocuments")
@Controller
public class DesignDocumentsController {
	
	@Autowired
	private DesignDocumentsService service;
	
	@RequestMapping("/selectDesignDocuments")
	@ResponseBody
	public List<DesignDocuments> selectDesignDocuments(){
		return service.selectDesignDocuments();
	}

}
