package com.cat.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.dao.IProcDAO;
import com.cat.service.IProcService;


@Service
@Transactional
public class ProcServiceImpl implements IProcService {

	@Autowired
	private IProcDAO procDao;
	
	@Override
	public void getproid(Map<String, Object> parms) {
		 
		procDao.getproid(parms);
		
	}

}
