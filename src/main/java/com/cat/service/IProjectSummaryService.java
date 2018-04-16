package com.cat.service;

import com.cat.bean.ProjectSummary;

public interface IProjectSummaryService {
	
	public int add(ProjectSummary bean);
	
	public int delete(ProjectSummary bean);
	
	public Double gettotalbx(ProjectSummary bean);
	
	public ProjectSummary getbyproid(ProjectSummary bean);
}
