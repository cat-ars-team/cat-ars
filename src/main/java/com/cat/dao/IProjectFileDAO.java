package com.cat.dao;

import com.cat.bean.ProjectFile;

public interface IProjectFileDAO {
	
	public int add (ProjectFile file);
	
	public int delete (ProjectFile file);

	public ProjectFile getbyproid(ProjectFile file);

}
