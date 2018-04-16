package com.cat.dao;

import com.cat.bean.ProjectDetail;

public interface IProjectDetailDAO {
	
	public int add(ProjectDetail detail);
	
	public int delete(ProjectDetail detail);
	
	public ProjectDetail getbyproid(ProjectDetail detail);
}
