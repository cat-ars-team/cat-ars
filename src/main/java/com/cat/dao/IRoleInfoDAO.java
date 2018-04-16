package com.cat.dao;

import java.util.List;

import javax.management.relation.Role;

import com.cat.bean.RoleInfo;

/**
 * 
 * <p>Title:RoleInfoDAO </p>
 * <p>Description:角色管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IRoleInfoDAO {

	/**
	 * 添加角色
	 * @param info
	 * @return
	 */
	public int add(RoleInfo info);
	
	/**
	 * 修改角色
	 * @param info
	 * @return
	 */
	public int update(RoleInfo info);
	
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
	 * @param info 查询条件
	 * @return
	 */
	public RoleInfo getInfo(RoleInfo info);
	
	public List<RoleInfo> getall();
}
