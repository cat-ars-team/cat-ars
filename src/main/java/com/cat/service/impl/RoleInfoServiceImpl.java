package com.cat.service.impl;

import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.RoleInfo;
import com.cat.dao.IRoleInfoDAO;
import com.cat.service.IRoleInfoService;
import com.cat.utils.Comm;

/**
 * 
 * <p>Title:RoleInfoServiceImpl </p>
 * <p>Description:角色管理业务逻辑的实现类</p>
 * <p>Company:xxxx</p>
 * 
 * @author 老牛
 * @version 1.0
 */
@Service
@Transactional
public class RoleInfoServiceImpl implements IRoleInfoService {

	@Autowired
	private IRoleInfoDAO roledao;

	public void add(RoleInfo info) {
		roledao.add(info);

	}

	public List<RoleInfo> list(RoleInfo info) {
		condition(info);
		// TODO Auto-generated method stub
		return roledao.list(info);
	}

	public long getcount(RoleInfo info) {
		condition(info);
		return roledao.getcount(info);
	}
	
	/**
	 * 查询条件
	 * @param info
	 */
	public void condition(RoleInfo info){
		if (info != null) {
			info.setRoleMark(Comm.MARK_YES);
			if (info.getRoleName() != null && !info.getRoleName().equals("")) {
				info.setRoleName("%"+info.getRoleName()+"%");	
			}

		}
	}

	public RoleInfo getInfo(RoleInfo info) {
		// TODO Auto-generated method stub
		return roledao.getInfo(info);
	}

	public void update(RoleInfo info) {
		roledao.update(info);
		
	}

	public void delete(Integer[] roleId) {
		for(Integer id:roleId){
			RoleInfo info = new RoleInfo();
			info.setRoleId(id);
			//修改无效标示
			info.setRoleMark(Comm.MARK_YES);
			
			//其实删除做的是修改
			roledao.update(info);
		}
		
	}

	@Override
	public List<RoleInfo> getall() {
		// TODO Auto-generated method stub
		return roledao.getall();
	}

}
