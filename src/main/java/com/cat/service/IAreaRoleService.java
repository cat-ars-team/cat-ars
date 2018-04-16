package com.cat.service;

import java.util.List;

import com.cat.bean.AreaRole;

public interface IAreaRoleService {

	
		//获取 省份
		public List<AreaRole> provincelist(AreaRole info);
		
		// 根据省份 获得城市
		public List<AreaRole> citylist(AreaRole info);
		
		
		public AreaRole getprovinceName(AreaRole info);
		
		public AreaRole getCityName (AreaRole info);
}
