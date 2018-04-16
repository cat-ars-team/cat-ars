package com.cat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.RoleMenuInfo;
import com.cat.dao.IAnthorityDAO;
import com.cat.service.IAnthorityService;

@Service
@Transactional
public class AnthorityServiceImpl implements IAnthorityService {

	@Autowired
	private IAnthorityDAO andao;

	public void add(Integer roleId, Integer[] menuIds) {

		//先删除
		andao.delete(roleId);
		
		//后添加
		for (Integer menuId : menuIds) {
			RoleMenuInfo info = new RoleMenuInfo();
			info.setRoleId(roleId);
			info.setMenuId(menuId);
			andao.add(info);

		}

	}

	public List<RoleMenuInfo> list(RoleMenuInfo info) {
		// TODO Auto-generated method stub
		return andao.list(info);
	}

	public List<Map> getMenuList(Integer roleId) {
		// TODO Auto-generated method stub
		return andao.getMenuList(roleId);
	}

}
