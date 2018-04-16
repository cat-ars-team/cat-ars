package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ProjectDetail;
import com.cat.dao.IProjectDetailDAO;
import com.cat.service.IProjectDetailService;


@Service
@Transactional
public class ProjectDetailServiceImpl implements IProjectDetailService {

	@Autowired
	private IProjectDetailDAO detailDAO; 
	
	
	@Override
	public int add(ProjectDetail detail) {
		// TODO Auto-generated method stub
		return detailDAO.add(detail);
	}


	@Override
	public int delete(ProjectDetail detail) {
		// TODO Auto-generated method stub
		return detailDAO.delete(detail);
	}


	@Override
	public ProjectDetail getbyproid(ProjectDetail detail) {
		// TODO Auto-generated method stub
		return detailDAO.getbyproid(detail);
	}

}
