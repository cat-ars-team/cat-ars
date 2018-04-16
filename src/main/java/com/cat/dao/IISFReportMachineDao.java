package com.cat.dao;

import java.util.List;

import com.cat.bean.ISFReportInfoVM;
import com.cat.bean.ISFReportMachine;

public interface IISFReportMachineDao {
	public List<ISFReportMachine> listNewMachine(ISFReportInfoVM report );
	
	public List<ISFReportMachine> listOldMachine(ISFReportInfoVM report);
}
