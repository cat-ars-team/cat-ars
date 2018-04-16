package com.cat.service;

import java.util.List;

import com.cat.bean.ISFReportInfoVM;

public interface IISFReportVMService {
	
	public List<ISFReportInfoVM> list(ISFReportInfoVM report);
	
	public Long getcount(ISFReportInfoVM report);
	
	public List<ISFReportInfoVM> listTotal(ISFReportInfoVM report);
}
