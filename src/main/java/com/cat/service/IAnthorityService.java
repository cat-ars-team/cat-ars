package com.cat.service;

import java.util.List;
import java.util.Map;

import com.cat.bean.RoleMenuInfo;

/**
 * 
 * <p>Title:IAnthorityService </p>
 * <p>Description:权限管理的业务逻辑接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IAnthorityService {

	/**
	 * 添加
	 * @param roleId
	 * @param menuIds
	 */
	public void add(Integer roleId,Integer[] menuIds);
	
	/**
	 * 根据角色编号查询已经选择的菜单编号
	 * @param info
	 * @return
	 */
	public List<RoleMenuInfo> list(RoleMenuInfo info);
	
	/**
	 * 根据角色编号查询菜单信息
	 * @param roleId
	 * @return
	 */
	public List<Map> getMenuList(Integer roleId);
	
}
