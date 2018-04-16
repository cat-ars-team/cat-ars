package com.cat.service;

import java.util.List;

import com.cat.bean.LevelInfo;

public interface ILevelInfoService {
	public List<LevelInfo> list();
	
	public LevelInfo GetLevelByCustNum(int personNum) ;
	
	public LevelInfo getbylevel(LevelInfo bean) ;
}
