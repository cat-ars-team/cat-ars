package com.cat.dao;

import java.util.List;

import com.cat.bean.RoleInfo;
import com.cat.bean.UserInfo;

/**
 * 
 * <p>Title:IUserInfoDAO </p>
 * <p>Description:用户管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface IUserInfoDAO {

	/**
	 * 添加用户信息
	 * @param user 用户信息
	 * @return 返回影响的行数
	 */
	public int add(UserInfo user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int update(UserInfo user);
	
	/**
	 * 根据条件查询用户信息
	 * @param user
	 * @return
	 */
	public UserInfo getUser(UserInfo user);
	
	/**
	 * 根据条件查询用户角色信息
	 * @param info 查询条件
	 * @return
	 */
	public List<UserInfo> list(UserInfo info);
	
	/**
	 * 获取总记录数
	 * @param info
	 * @return
	 */
	public long getcount(UserInfo info);
	
	/**
	 * 根据账号密码查询用户信息
	 * @param info
	 * @return
	 */
	public UserInfo login(UserInfo info);
	
}
