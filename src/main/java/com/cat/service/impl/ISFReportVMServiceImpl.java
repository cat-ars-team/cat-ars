package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ISFReportInfoVM;
import com.cat.dao.IISFReportVMDAO;
import com.cat.service.IISFReportVMService;

@Service
@Transactional
public class ISFReportVMServiceImpl implements IISFReportVMService {

	@Autowired
	private IISFReportVMDAO isfReportDao;
	
	@Override
	public List<ISFReportInfoVM> list(ISFReportInfoVM report) {
		// TODO Auto-generated method stub
		return isfReportDao.list(report);
	}

	@Override
	public List<ISFReportInfoVM> listTotal(ISFReportInfoVM report) {
		// TODO Auto-generated method stub
		return isfReportDao.listTotal(report);
	}

	@Override
	public Long getcount(ISFReportInfoVM report) {
		// TODO Auto-generated method stub
		return isfReportDao.getcount(report);
	}
	
}
