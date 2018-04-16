package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.CostInfo;
import com.cat.dao.ICostInfoDAO;
import com.cat.service.ICostInfoService;
import com.cat.utils.Comm;

@Service
@Transactional
public class CostInfoServiceImpl implements ICostInfoService {

	@Autowired
	private ICostInfoDAO costdao;

	public void add(CostInfo info) {
		costdao.add(info);

	}

	@Transactional(readOnly = true)
	public List<CostInfo> list(CostInfo info) {
		condition(info);
		return costdao.list(info);
	}

	@Transactional(readOnly = true)
	public long getcount(CostInfo info) {
		condition(info);
		return costdao.getcount(info);
	}

	public void condition(CostInfo info) {
		if (info != null) {
			if (info.getCostName() != null && !info.getCostName().equals("")) {
				info.setCostName("%" + info.getCostName() + "%");
			}
		}

	}

	public CostInfo getInfo(CostInfo info) {
		// TODO Auto-generated method stub
		return costdao.getCostInfo(info);
	}

	public void update(CostInfo info) {
		costdao.update(info);
		
	}

	public void delete(Integer[] costIds) {
		for(Integer costId:costIds){
			CostInfo info = new CostInfo();
			info.setCostId(costId);
			info.setCostMark(Comm.MARK_NO);
			costdao.update(info);
		}
		
	}

}
