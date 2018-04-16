package com.cat.service;

import java.io.InputStream;
import java.util.List;

import com.cat.bean.ProjectInfo;
import com.cat.bean.UserInfo;
import com.cat.utils.Result;

public interface IProjectInfoService  {
	
	public List<ProjectInfo> list(ProjectInfo bean);
	 

	public long getcount(ProjectInfo bean);
	
	
	/**
	 * 添加 项目
	 * @param  项目内容
	 * @return 返回影响的行数
	 */
	public int add(ProjectInfo pi);

	
	public int delete(ProjectInfo info);
	
	
	public Result batchAdd(InputStream is,UserInfo currentUser)throws Exception ;
	
	
	public Result custAdd (InputStream is,UserInfo currentUser,ProjectInfo pro)throws Exception ;
	
	public ProjectInfo getByProID(ProjectInfo bean);
	
	
	public int update(ProjectInfo pi);
	 
}
