package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.bean.Test;
import com.cat.dao.ITestDAO;
import com.cat.service.ITestService;
 
@Service("testService")
public class TestServiceImpl implements ITestService {
	 
	@Autowired
	private ITestDAO testMapper;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return testMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Test record) {
		return testMapper.insert(record);
	}

	@Override
	public int insertSelective(Test record) {
		return testMapper.insertSelective(record);
	}

	@Override
	public Test selectByPrimaryKey(Integer id) {
		return testMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Test record) {
		return testMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Test record) {
		return testMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Test> findOne() {
		return testMapper.findOne();
	}

	@Override
	public List<Test> findTwoAndThree(Integer parId) {
		return testMapper.findTwoAndThree(parId);
	}
	
	
	
	

}