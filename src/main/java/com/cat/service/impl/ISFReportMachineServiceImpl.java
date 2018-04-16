package com.cat.service.impl;

import java.util.List;
 





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ISFReportInfoVM;
import com.cat.bean.ISFReportMachine;
import com.cat.dao.IISFReportMachineDao;
import com.cat.service.IISFReportMachineService;


@Service
@Transactional
public class ISFReportMachineServiceImpl implements IISFReportMachineService {

	@Autowired
	private IISFReportMachineDao machineDao;
	
	
	
	@Override
	public List<ISFReportMachine> listNewMachine(ISFReportInfoVM report) {
		// TODO Auto-generated method stub
		return machineDao.listNewMachine(report);
	}

	@Override
	public List<ISFReportMachine> listOldMachine(ISFReportInfoVM report) {
		// TODO Auto-generated method stub
		return machineDao.listOldMachine(report);
	}

	
		
}
