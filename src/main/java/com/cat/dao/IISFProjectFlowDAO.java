package com.cat.dao;

import com.cat.bean.ISFProjectFlow;

public interface IISFProjectFlowDAO {
	
	
	public int add(ISFProjectFlow bean);
	
	public int update(ISFProjectFlow bean);
	
	public int delete(ISFProjectFlow bean);
	
	public ISFProjectFlow getByProID(ISFProjectFlow bean);

}
