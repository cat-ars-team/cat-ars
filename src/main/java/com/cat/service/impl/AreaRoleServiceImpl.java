package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.AreaRole;
import com.cat.dao.IAreaRoleDAO;
import com.cat.service.IAreaRoleService;


@Service
@Transactional
public class AreaRoleServiceImpl implements IAreaRoleService {
	
	@Autowired
	private IAreaRoleDAO areadao;
	

	@Override
	public List<AreaRole> provincelist(AreaRole info) {
		// TODO Auto-generated method stub
		return areadao.provincelist(info);
	}

	@Override
	public List<AreaRole> citylist(AreaRole info) {
		// TODO Auto-generated method stub
		return areadao.citylist(info);
	}

	@Override
	public AreaRole getprovinceName(AreaRole info) {
		// TODO Auto-generated method stub
		return areadao.getprovinceName(info);
	}

	@Override
	public AreaRole getCityName(AreaRole info) {
		// TODO Auto-generated method stub
		return areadao.getCityName(info);
	}

}
