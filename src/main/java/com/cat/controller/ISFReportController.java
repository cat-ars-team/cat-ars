package com.cat.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.bean.ISFReportInfoVM; 
import com.cat.service.IISFReportMachineService;
import com.cat.service.IISFReportVMService;
import com.cat.utils.Page;


@Controller
@RequestMapping("/ISFReport/")
public class ISFReportController extends Page {
	
	@Autowired
	private IISFReportVMService reportService;
	
	@Autowired
	private IISFReportMachineService machineService;
	
	@RequestMapping("list.do")
	public String list(ISFReportInfoVM bean,Model model,HttpServletRequest request) {

		if (bean == null) {
			bean =new ISFReportInfoVM();
		}
		
		//分页信息
		this.initPage(request);
		//起始记录
		bean.setStart(this.getPageNo());
		//每页显示记录数
		bean.setLength(PAGE_NUM_BIG);
		 
		//总记录数
		model.addAttribute("total", reportService.getcount(bean));
		

		model.addAttribute("list",  reportService.list(bean));
		model.addAttribute("listTotal",  reportService.listTotal(bean));
		
		model.addAttribute("listNewMachine", machineService.listNewMachine(bean));
		model.addAttribute("listOldMachine", machineService.listOldMachine(bean));
		model.addAttribute("iSFReportInfoVM", bean);
		return "ISFReport/ISFReport_list";
	}

}
