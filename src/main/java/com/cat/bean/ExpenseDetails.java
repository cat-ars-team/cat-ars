package com.cat.bean;

/**
 * 
 * <p>Title:ExpenseDetails</p>
 * <p>Description:报销明细实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 *    expense_details_id   int not null auto_increment,
   expense_id           int,
   cost_id              int,
   expense_details_amount double,
 */
public class ExpenseDetails {

	//报销明细编号
	private Integer expenseDetailsId;
	
	//报销单
	private Integer expenseId;
	
	//费用
	private Integer costId;
	
	//报销具体金额
	private Double expenseDetailsAmount;

	public Integer getExpenseDetailsId() {
		return expenseDetailsId;
	}

	public void setExpenseDetailsId(Integer expenseDetailsId) {
		this.expenseDetailsId = expenseDetailsId;
	}

	public Integer getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public Double getExpenseDetailsAmount() {
		return expenseDetailsAmount;
	}

	public void setExpenseDetailsAmount(Double expenseDetailsAmount) {
		this.expenseDetailsAmount = expenseDetailsAmount;
	}
	
	
}
