package com.cat.dao;

import java.util.List;

import com.cat.bean.Nusgoprojectinfo;

public interface INusgoprojectinfoDAO {
	public List<Nusgoprojectinfo> list(Nusgoprojectinfo bean);
	
	public Nusgoprojectinfo getByProid(Nusgoprojectinfo bean);

	public int add(Nusgoprojectinfo bean) ;
	
	public int update(Nusgoprojectinfo bean) ;
	
	public int listCount(Nusgoprojectinfo bean) ;
	
	
}
