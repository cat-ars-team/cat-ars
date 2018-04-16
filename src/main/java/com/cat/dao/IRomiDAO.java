package com.cat.dao;

import com.cat.bean.Romi;

public interface IRomiDAO {
	public int add(Romi info);
	
	public int delete(Romi info);
	
	public Romi getbyproid(Romi bean);
}
