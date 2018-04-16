package com.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.NusgoFlow;
import com.cat.dao.INusgoFlowDAO;
import com.cat.dao.INusgoprojectinfoDAO;
import com.cat.service.INusgoFlowService;


@Service
@Transactional
public class NusgoFlowServiceImpl implements INusgoFlowService {

	@Autowired
	private INusgoFlowDAO flowDao;
	
	@Override
	public int add(NusgoFlow info) {
		// TODO Auto-generated method stub
		return flowDao.add(info);
	}

	@Override
	public int updatebyproid(NusgoFlow info) {
		// TODO Auto-generated method stub
		return flowDao.updatebyproid(info);
	}

	@Override
	public NusgoFlow getbyproid(NusgoFlow info) {
		// TODO Auto-generated method stub
		return flowDao.getbyproid(info);
	}

}
