package com.cat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.dao.IReportDAO;
import com.cat.service.IReportService;

@Service
@Transactional
public class ReportServiceImpl implements IReportService {

	@Autowired
	private IReportDAO dao;
	
	public List<Map> salaryMonthReport() {
		// TODO Auto-generated method stub
		return dao.salaryMonthReport();
	}

	public List<Map> expenseMonthReport() {
		// TODO Auto-generated method stub
		return dao.expenseMonthReport();
	}

	public List<Map> expenseCostReport() {
		// TODO Auto-generated method stub
		return dao.expenseCostReport();
	}

}
