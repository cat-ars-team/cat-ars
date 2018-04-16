package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.Romi;
import com.cat.dao.IRomiDAO;
import com.cat.service.IRomiService; 


@Service
@Transactional
public class RomiServiceImpl implements IRomiService {
	
	@Autowired
	private IRomiDAO romidao;

	@Override
	public int add(Romi info) {
		// TODO Auto-generated method stub
		return romidao.add(info);
	}

	@Override
	public int delete(Romi info) {
		// TODO Auto-generated method stub
		return romidao.delete(info);
	}

	@Override
	public Romi getbyproid(Romi info) {
		// TODO Auto-generated method stub
		return romidao.getbyproid(info);
	}

	

}
