package com.cat.service;

import java.util.List;

import com.cat.bean.ProjectCustInfo;
import com.cat.bean.ProjectInfo;


public interface IProjectCustInfoService {
	
	// 根据用项目ID 获取所有用户
	public List<ProjectCustInfo> GetListByProID(ProjectCustInfo bean);
	
	public int add(ProjectCustInfo info);
	
	public int delete(ProjectCustInfo info);
	
	public long getcount(String proid);
}
