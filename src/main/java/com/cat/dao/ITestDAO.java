package com.cat.dao;

import java.util.List;

import com.cat.bean.Test;

public interface ITestDAO {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
    
    List<Test> findOne();
    
    List<Test> findTwoAndThree(Integer parId);
}
