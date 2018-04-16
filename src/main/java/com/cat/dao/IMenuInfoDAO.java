package com.cat.dao;

import java.util.List;

import com.cat.bean.MenuInfo;

/**
 * 
 * <p>Title:IMenuInfoDAO </p>
 * <p>Description:菜单管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IMenuInfoDAO {

	/**
	 * 查询菜单信息
	 * @param menu
	 * @return
	 */
	public List<MenuInfo> list(MenuInfo menu);
	
	/**
	 * 根据条件查询菜单信息
	 * @param info
	 * @return
	 */
	public MenuInfo getInfo(MenuInfo info);
	
	/**
	 * 添加菜单信息
	 * @param info 菜单信息
	 * @return
	 */
	public int add(MenuInfo info);
	
	/**
	 * 修改菜单信息
	 * @param info
	 * @return
	 */
	public int update(MenuInfo info);
	
	/**
	 * 根据编号删除菜单信息
	 * @param info
	 * @return
	 */
	public int delete(MenuInfo info);
	
	/**
	 * 根据菜单父级编号查询菜单信息
	 * @param prentMenuId
	 * @return
	 */
	public List<MenuInfo> getMenuList(Integer prentMenuId);
}
