package com.cat.dao;

import java.util.List;

import com.cat.bean.ProjectCustInfo;
import com.cat.bean.ProjectInfo;

 

public interface IProjectCustInfoDAO {
	
	public List<ProjectCustInfo> GetListByProID(ProjectCustInfo bean);
	
	public int add(ProjectCustInfo info);
	
	public int delete(ProjectCustInfo info);
	
	public long getcount(String proid);
}
