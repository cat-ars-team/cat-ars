package com.cat.service;

import com.cat.bean.NusgoFlow;

public interface INusgoFlowService {
	public int add(NusgoFlow info);
	
	public int updatebyproid(NusgoFlow info);
	
	public NusgoFlow getbyproid(NusgoFlow info);
}
