package com.cat.dao;

import java.util.List;

import com.cat.bean.LevelInfo;

public interface ILevelInfoDAO {
	
	
	public List<LevelInfo> list();
	
	public LevelInfo getbylevel(LevelInfo bean) ;
	
}
