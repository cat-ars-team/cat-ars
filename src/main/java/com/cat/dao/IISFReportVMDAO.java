package com.cat.dao;

import java.util.List;

import com.cat.bean.ISFReportInfoVM;



public interface IISFReportVMDAO {
	
	/*查询明细*/
	public List<ISFReportInfoVM> list( ISFReportInfoVM report);
	
	/*查询明细*/
	public Long getcount(ISFReportInfoVM report);
	
	/*查询总计*/
	public List<ISFReportInfoVM> listTotal(ISFReportInfoVM report );
}
