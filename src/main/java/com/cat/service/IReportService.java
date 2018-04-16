package com.cat.service;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title:IReportService </p>
 * <p>Description:报表业务逻辑借口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IReportService {

	/**
	 * 按月份统计薪资发放情况
	 * @return
	 */
	public List<Map> salaryMonthReport();
	
	/**
	 * 按月份统计报销情况
	 * @return
	 */
	public List<Map> expenseMonthReport();

	/**
	 * 根据费用名称统计报销金额
	 * @return
	 */
	public List<Map> expenseCostReport();
}
