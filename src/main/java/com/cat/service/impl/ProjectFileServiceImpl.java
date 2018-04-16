package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ProjectFile;
import com.cat.dao.IProjectFileDAO;
import com.cat.service.IProjectFileService;


@Service
@Transactional
public class ProjectFileServiceImpl implements IProjectFileService {

	
	@Autowired
	private IProjectFileDAO fileDAO;
	
	
	@Override
	public int add(ProjectFile file) {
		// TODO Auto-generated method stub
		return fileDAO.add(file);
	}

	@Override
	public ProjectFile getbyproid(ProjectFile file) {
		// TODO Auto-generated method stub
		return fileDAO.getbyproid(file);
	}

	@Override
	public int delete(ProjectFile file) {
		// TODO Auto-generated method stub
		return fileDAO.delete(file);
	}

}
