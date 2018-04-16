package com.cat.bean;

import java.util.Date;

import com.cat.utils.BaseBean;

/**
 * 
 * <p>Title:SalaryPayment </p>
 * <p>Description:薪资发放的实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 * 
 *    payment_id           int not null auto_increment,
   user_id              int,
   payment_time         datetime,
   payment_money        double,
 */
public class SalaryPayment extends BaseBean{

	//编号
	private Integer paymentId;
	
	//领取薪资的用户
	private Integer userId;
	
	//领取人姓名
	private String userName;
	
	//发放时间
	private Date paymentTime;
	
	//发放的金额
	private Double paymentMoney;
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Double getPaymentMoney() {
		return paymentMoney;
	}

	public void setPaymentMoney(Double paymentMoney) {
		this.paymentMoney = paymentMoney;
	}

	@Override
	public String toString() {
		return "SalaryPayment [paymentId=" + paymentId + ", userId=" + userId + ", userName=" + userName
				+ ", paymentTime=" + paymentTime + ", paymentMoney=" + paymentMoney + "]";
	}
	
	
	
}
