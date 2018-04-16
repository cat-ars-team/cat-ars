package com.cat.service;

import java.io.InputStream;
import java.util.List;

import com.cat.bean.SalaryPayment;

/**
 * 
 * <p>Title:ISalaryPaymentService </p>
 * <p>Description:薪资发放的业务逻辑接口</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
public interface ISalaryPaymentService {

	/**
	 * 添加薪资发放信息
	 * @param sp 薪资方法
	 */
	public void add(SalaryPayment sp);
	
	/**
	 * 导入数据
	 * @param is
	 */
	public void addAll(InputStream is)throws Exception ;
	
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
