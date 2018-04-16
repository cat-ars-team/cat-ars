package com.cat.bean;

/**
 * 
 * <p>Title:RoleMenuInfo </p>
 * <p>Description:角色菜单关系实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public class RoleMenuInfo {

	/**
	 * 关系编号
	 */
	private Integer roleMenuId;
	
	/**
	 * 菜单编号
	 */
	private Integer menuId;
	
	/**
	 * 角色编号
	 */
	private Integer roleId;

	public Integer getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(Integer roleMenuId) {
		this.roleMenuId = roleMenuId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
}
