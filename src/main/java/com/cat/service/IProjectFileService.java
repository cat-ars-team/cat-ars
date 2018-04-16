package com.cat.service;

import com.cat.bean.ProjectFile;

public interface IProjectFileService {
	public int add (ProjectFile file);

	public ProjectFile getbyproid(ProjectFile file);
	
	public int delete(ProjectFile file);
}
