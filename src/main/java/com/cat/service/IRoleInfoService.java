package com.cat.service;

import java.util.List;

import javax.management.relation.Role;

import com.cat.bean.RoleInfo;

/**
 * 
 * <p>Title:RoleInfoService </p>
 * <p>Description:角色管理的业务逻辑处理接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IRoleInfoService {

	/**
	 * 添加角色信息
	 * @param info
	 */
	public void add(RoleInfo info);
	
	/**
	 * 修改角色信息
	 * @param info
	 */
	public void update(RoleInfo info);
	
	/**
	 * 根据条件查询角色信息
	 * @param info 查询条件
	 * @return
	 */
	public List<RoleInfo> list(RoleInfo info);
	
	/**
	 * 获取总记录数
	 * @param info
	 * @return
	 */
	public long getcount(RoleInfo info);
	
	/**
	 * 根据条件查询角色信息
	 * @param info
	 * @return
	 */
	public RoleInfo getInfo(RoleInfo info);
	
	/**
	 * 根据编号删除
	 * @param roleId
	 */
	public void delete(Integer[] roleId);
	
	public List<RoleInfo> getall();
}
