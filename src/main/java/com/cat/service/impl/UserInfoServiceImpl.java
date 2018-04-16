package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.bean.UserInfo;
import com.cat.dao.IUserInfoDAO;
import com.cat.service.IUserInfoService;
import com.cat.utils.Comm;

@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {

	@Autowired
	private IUserInfoDAO userdao;

	public void add(UserInfo user) {
		userdao.add(user);

	}

	public UserInfo getUser(UserInfo user) {
		// TODO Auto-generated method stub
		return userdao.getUser(user);
	}

	public List<UserInfo> list(UserInfo info) {
		condition(info);	
		return userdao.list(info);
	}

	public long getcount(UserInfo info) {
		condition(info);
		return userdao.getcount(info);
	}

	/**
	 * 查询条件
	 * 
	 * @param user
	 */
	public void condition(UserInfo user) {
		if (user != null) {
			if (user.getUserName() != null && !user.getUserName().equals("")) {
				user.setUserName("%"+user.getUserName()+"%");
			}

		}
	}

	public void update(UserInfo user) {
		userdao.update(user);
		
	}

	public void delete(Integer[] userId) {
		
		for(Integer id:userId){
			UserInfo info = new UserInfo();
			info.setUserId(id);
			info.setUserMark(Comm.MARK_NO);
			
			userdao.update(info);
			
		}
		
	}

	public UserInfo isLogin(UserInfo user) {
		// TODO Auto-generated method stub
		return userdao.login(user);
	}

}
