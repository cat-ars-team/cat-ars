package com.cat.service;

import java.io.InputStream;
import java.util.List;

import com.cat.bean.Nusgoprojectinfo; 
import com.cat.bean.UserInfo;
import com.cat.utils.Result;

public interface INusgoprojectinfoService {

	public List<Nusgoprojectinfo> list(Nusgoprojectinfo bean); 
	
	public int add(Nusgoprojectinfo bean) ;
	
	public int update(Nusgoprojectinfo bean) ;
	
	public Nusgoprojectinfo getByProid(Nusgoprojectinfo bean);
	
	public int listCount(Nusgoprojectinfo bean) ;
	
	public Result custAdd (InputStream is,UserInfo currentUser,Nusgoprojectinfo pro)throws Exception ;
}
