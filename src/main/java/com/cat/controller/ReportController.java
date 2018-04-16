package com.cat.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.service.IReportService;

/**
 * 
 * <p>Title:ReportController </p>
 * <p>Description:报表管理的控制器</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
@Controller
@RequestMapping("/report/")
public class ReportController {

	@Autowired
	private IReportService reportservice;
	
	/**
	 * 按月份统计薪资发放情况
	 * @return
	 */
	@RequestMapping("salaryMonth.do")
	public String salaryMonthReport(Model model,String type){
		
		List<Map> list = reportservice.salaryMonthReport();
		
		model.addAttribute("list", list);
		
		if("column".equals(type)){
			return "report/report_salarymonth_column";
		}else if("line".equals(type)){
			return "report/report_salarymonth_line";
		}else{
			return "report/report_salarymonth";
		}
	}
	
	/**
	 * 按月份统计报销信息
	 * @param model
	 * @param type
	 * @return
	 */
	@RequestMapping("expenseMonth.do")
	public String expenseMonthReport(Model model,String type){
		
		List<Map> list = reportservice.expenseMonthReport();
		
		model.addAttribute("list", list);
		
		if("column".equals(type)){
			return "report/report_expense_column";
		}else if("spline".equals(type)){
			return "report/report_expense_spline";
		}else{
			return "report/report_expense";
		}
		
	}
	
	/**
	 * 根据费用名称统计报销金额
	 * @param model
	 * @param type
	 * @return
	 */
	@RequestMapping("expenseCost.do")
	public String expenseCostReport(Model model,String type){
		
		List<Map> list = reportservice.expenseCostReport();
		
		model.addAttribute("list", list);
		
		if("pie".equals(type)){
			return "report/report_expensecost_pie";
		}else if("column".equals(type)){
			return "report/report_expensecost_column";
		}else if("spline".equals(type)){
			return "report/report_expensecost_spline";
		}else{
			return "report/report_expensecost";
		}
		
	}
	
}
