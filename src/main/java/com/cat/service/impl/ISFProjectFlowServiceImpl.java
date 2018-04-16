package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.bean.ISFProjectFlow;
import com.cat.dao.IISFProjectFlowDAO;
import com.cat.service.IISFProjectFlowService;

@Service
public class ISFProjectFlowServiceImpl implements IISFProjectFlowService {

	@Autowired
	private IISFProjectFlowDAO isfFlowDao;
	
	
	@Override
	public int add(ISFProjectFlow bean) throws Exception{
		// TODO Auto-generated method stub
		return isfFlowDao.add(bean);
	}
	
	
	@Override
	public int update(ISFProjectFlow bean) throws Exception  {
		// TODO Auto-generated method stub
		 
		return isfFlowDao.update(bean);
	}


	@Override
	public ISFProjectFlow getByProID(ISFProjectFlow bean) throws Exception {
		// TODO Auto-generated method stub
		return isfFlowDao.getByProID(bean);
	}


	@Override
	public int delete(ISFProjectFlow bean) throws Exception{
		// TODO Auto-generated method stub
		return isfFlowDao.delete(bean);
	}
	
}
