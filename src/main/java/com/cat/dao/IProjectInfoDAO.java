package com.cat.dao;

import java.util.List;

import com.cat.bean.ProjectInfo; 
import com.cat.bean.SalaryPayment;

public interface IProjectInfoDAO {
	
	public List<ProjectInfo> list(ProjectInfo bean);
	
	public ProjectInfo getByProID(ProjectInfo bean);
	
	public long getcount(ProjectInfo bean);
	
	
	/**
	 * 添加 项目
	 * @param  项目内容
	 * @return 返回影响的行数
	 */
	public int add(ProjectInfo pi);
	
	public int update(ProjectInfo pi);
	public int delete(ProjectInfo info);
	
}
