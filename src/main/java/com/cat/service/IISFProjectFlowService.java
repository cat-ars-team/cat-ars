package com.cat.service;

import com.cat.bean.ISFProjectFlow;

public interface IISFProjectFlowService {
	
	public int add(ISFProjectFlow bean) throws Exception;
	
	public int update(ISFProjectFlow bean) throws Exception;
	
	public int delete(ISFProjectFlow bean) throws Exception;
	
	public ISFProjectFlow getByProID(ISFProjectFlow bean) throws Exception;
	
}
