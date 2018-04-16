package com.cat.bean;

import java.util.Date;

/**
 * 
 * <p>Title:AuditHistory </p>
 * <p>Description:审核历史记录实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 *    audit_id             int not null auto_increment,
   expense_id           int,
   user_id              int,
   audit_time           datetime,
   audit_state          varchar(5),
   audit_desc           varchar(1000),
 */
public class AuditHistory {

	//审核记录编号
	private Integer auditId;
	
	//报销单编号
	private Integer expenseId;
	
	//审核人编号
	private  Integer userId;
	
	//审核时间
	private Date auditTime;
	
	//审核状态
	private String auditState;
	
	//审核描述
	private String auditDesc;

	public Integer getAuditId() {
		return auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getAuditDesc() {
		return auditDesc;
	}

	public void setAuditDesc(String auditDesc) {
		this.auditDesc = auditDesc;
	}
	
	
}
