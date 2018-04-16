package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cat.bean.ProjectCustInfo;
import com.cat.dao.IProjectCustInfoDAO;

public class testCust {
	
	@Autowired
	private IProjectCustInfoDAO  proCustDao;
	
	
	@Test
	public void test1()
	{	
		List<ProjectCustInfo> list = proCustDao.GetListByProID("LSHM120130826002");
		
	}
	

	
	

	//System.out.println();
}
