package com.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.LevelInfo;
import com.cat.dao.ILevelInfoDAO;
import com.cat.service.ILevelInfoService;


@Service
@Transactional
public class LevelInfoServiceImpl implements ILevelInfoService {

	
	@Autowired
	private ILevelInfoDAO levelDao;
	
	
	@Override
	public List<LevelInfo> list() {
		// TODO Auto-generated method stub
		return levelDao.list();
	}
	
	
	
	
	// 根据用户人数 获取 等级
	public LevelInfo GetLevelByCustNum(int personNum) {
		LevelInfo levelInfo = new LevelInfo();
		try {
			List<LevelInfo> list = levelDao.list();
			
			for (LevelInfo level : list) {
				if(personNum >= Integer.parseInt(level.getCustNum1()) && personNum <=Integer.parseInt( level.getCustNum2())){
					levelInfo = level;
				}else if (personNum<=30) {
					if ("4".equals(level.getLevelId())) {
						levelInfo=level;
					}
				}else if (personNum>=500) {
					if ("1".equals(level.getLevelId())) {
						levelInfo=level;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levelInfo;
	}




	@Override
	public LevelInfo getbylevel(LevelInfo bean) {
		// TODO Auto-generated method stub
		return levelDao.getbylevel(bean);
	}
	
	
	
	
	

}
