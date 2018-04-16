package com.cat.service;

import java.util.List;

import com.cat.bean.MenuInfo;

/**
 * 
 * <p>Title:IMenuInfoService </p>
 * <p>Description:菜单管理的业务逻辑接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IMenuInfoService {

	/**
	 * 查询所有的菜单信息
	 * @param info
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo info);
	
	/**
	 * 根据条件查询菜单信息
	 * @param info
	 * @return
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 添加菜单信息
	 * @param info
	 */
	public void add(MenuInfo info);
	
	/**
	 * 修改菜单信息
	 * @param info
	 */
	public void update(MenuInfo info);
	
	/**
	 * 根据编号删除菜单信息
	 * @return
	 */
	public void delete(MenuInfo info);
	
	/**
	 * 根据菜单父级编号查询菜单信息
	 * @param prentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer prentMenuId);
	
}
