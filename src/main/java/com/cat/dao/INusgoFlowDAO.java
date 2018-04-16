package com.cat.dao;

import java.util.List;

import com.cat.bean.NusgoFlow;

public interface INusgoFlowDAO {
	
	public int add(NusgoFlow info);
	
	public int updatebyproid(NusgoFlow info);
	
	public NusgoFlow getbyproid(NusgoFlow info);
}
