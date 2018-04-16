package com.cat.bean;

/**
 * 
 * <p>Title:MenuInfo </p>
 * <p>Description:菜单管理的实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public class MenuInfo {

	/**
	 * 菜单编号
	 */
	private Integer menuId;
	
	/**
	 * 菜单的父级id
	 */
	private Integer prentMenuId;
	
	/**
	 * 父级菜单名称
	 */
	private String prentName;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单URL地址
	 */
	private String menuUrl;
	
	

	public String getPrentName() {
		return prentName;
	}

	public void setPrentName(String prentName) {
		this.prentName = prentName;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getPrentMenuId() {
		return prentMenuId;
	}

	public void setPrentMenuId(Integer prentMenuId) {
		this.prentMenuId = prentMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	
	
	
}
