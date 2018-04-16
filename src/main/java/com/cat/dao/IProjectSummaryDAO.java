package com.cat.dao;

import com.cat.bean.ProjectSummary;

public interface IProjectSummaryDAO {
	public int add(ProjectSummary bean);
	
	public int delete(ProjectSummary bean);
	
	public Double gettotalbx(ProjectSummary bean);
	
	public ProjectSummary getbyproid(ProjectSummary bean);
}
