package com.cat.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title:IReportDAO </p>
 * <p>Description:报表管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IReportDAO {
	
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
	 * 根据费用类别统计报销金额
	 * @return
	 */
	public List<Map> expenseCostReport();
}
