package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ProjectSummary;
import com.cat.dao.IProjectSummaryDAO;
import com.cat.service.IProjectSummaryService;


@Service
@Transactional
public class ProjectSummaryServiceImpl implements IProjectSummaryService{
	
	
	@Autowired
	private IProjectSummaryDAO summaryDAO;

	@Override
	public int add(ProjectSummary bean) {
		// TODO Auto-generated method stub
		return summaryDAO.add(bean);
	}

	@Override
	public ProjectSummary getbyproid(ProjectSummary bean) {
		// TODO Auto-generated method stub
		return summaryDAO.getbyproid(bean);
	}

	@Override
	public int delete(ProjectSummary bean) {
		// TODO Auto-generated method stub
		return summaryDAO.delete(bean);
	}

	@Override
	public Double gettotalbx(ProjectSummary bean) {
		// TODO Auto-generated method stub
		return summaryDAO.gettotalbx(bean);
	}

}
