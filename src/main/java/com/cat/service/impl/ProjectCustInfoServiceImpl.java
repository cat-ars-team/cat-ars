package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ProjectCustInfo;
import com.cat.dao.IProjectCustInfoDAO;
import com.cat.service.IProjectCustInfoService; 

@Service
@Transactional
public class ProjectCustInfoServiceImpl implements IProjectCustInfoService {

	@Autowired
	private IProjectCustInfoDAO  proCustDao;
	
	@Override
	public List<ProjectCustInfo> GetListByProID(ProjectCustInfo bean) {
		
		return proCustDao.GetListByProID(bean);
	}

	@Override
	public int add(ProjectCustInfo info) {
		// TODO Auto-generated method stub
		return proCustDao.add(info);
	}

	@Override
	public int delete(ProjectCustInfo info) {
		// TODO Auto-generated method stub
		return proCustDao.delete(info);
	}

	@Override
	public long getcount(String proid) {
		// TODO Auto-generated method stub
		return proCustDao.getcount(proid);
	}
	
	

}
