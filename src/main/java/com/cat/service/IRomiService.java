package com.cat.service;

import com.cat.bean.Romi;

public interface IRomiService {
	public int add(Romi info);
	public int delete(Romi info);
	
	public Romi getbyproid(Romi info);
}
