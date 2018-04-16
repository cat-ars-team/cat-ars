package com.cat.dao;

import java.util.List;

import com.cat.bean.SalaryPayment;

/**
 * 
 * <p>Title:ISalaryPaymentDAO </p>
 * <p>Description:薪资管理的数据访问接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface ISalaryPaymentDAO {

	/**
	 * 添加薪资发放记录
	 * @param sp 发放记录
	 * @return 返回影响的行数
	 */
	public int add(SalaryPayment sp);
	
	/**
	 * 查询所有的薪资
	 * @param sp 查询条件
	 * @return
	 */
	public List<SalaryPayment> list(SalaryPayment sp);
	
	/**
	 * 返回总记录数
	 * @param sp
	 * @return
	 */
	public Long getcount(SalaryPayment sp);
}
