package com.cat.service;

import com.cat.bean.ProjectDetail;

public interface IProjectDetailService {
	
	public int add(ProjectDetail detail);
	
	public int delete(ProjectDetail detail);
	
	public ProjectDetail getbyproid(ProjectDetail detail);
}
