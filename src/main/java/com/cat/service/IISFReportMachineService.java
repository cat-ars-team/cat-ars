package com.cat.service;

import java.util.List;

import com.cat.bean.ISFReportInfoVM;
import com.cat.bean.ISFReportMachine;



public interface IISFReportMachineService {
	
	public List<ISFReportMachine> listNewMachine(ISFReportInfoVM report);
	
	public List<ISFReportMachine> listOldMachine(ISFReportInfoVM report);
}
