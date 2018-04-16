package com.cat.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.AuditHistory;
import com.cat.bean.ExpenseAccount;
import com.cat.bean.ExpenseDetails;
import com.cat.dao.IExpenseDAO;
import com.cat.service.IExpenseService;
import com.cat.utils.Comm;

@Service
@Transactional
public class ExpenseServiceImpl implements IExpenseService {

	/**
	 * 报销管理的数据访问接口
	 */
	@Autowired
	private IExpenseDAO expdao;

	public void add(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount) {

		// 添加报销单
		expdao.addExpense(ea);

		for (int i = 0; i < costId.length; i++) {
			ExpenseDetails ed = new ExpenseDetails();
			// 获取报销单的编号
			ed.setExpenseId(ea.getExpenseId());
			ed.setCostId(costId[i]);
			ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);

			expdao.addExpenseDetails(ed);
		}

	}
	
	public void update(ExpenseAccount ea, Integer[] costId, Double[] expenseDetailsSmount) {
	
		
		// 添加报销单
		expdao.updateExpenseAccount(ea);

		//先删除以前明细，在重新添加新的明细
		expdao.deleteExpenseDetails(ea.getExpenseId());
		
		for (int i = 0; i < costId.length; i++) {
			ExpenseDetails ed = new ExpenseDetails();
			// 获取报销单的编号
			ed.setExpenseId(ea.getExpenseId());
			ed.setCostId(costId[i]);
			ed.setExpenseDetailsAmount(expenseDetailsSmount[i]);

			expdao.addExpenseDetails(ed);
		}
		
	}

	public List<ExpenseAccount> list(ExpenseAccount ea) {
		condition(ea);
		return expdao.list(ea);
	}

	public long getcount(ExpenseAccount ea) {
		condition(ea);
		return expdao.getcount(ea);
	}

	/**
	 * 查询条件
	 * 
	 * @param ea
	 */
	public void condition(ExpenseAccount ea) {

		if (ea != null) {
			if (ea.getUserName() != null && !ea.getUserName().equals("")) {

				ea.setUserName("%" + ea.getUserName() + "%");
			}

		}

	}

	public ExpenseAccount getExpenseAccount(ExpenseAccount ea) {
		// TODO Auto-generated method stub
		return expdao.getExpenseAccount(ea);
	}

	public List<Map> getExpenseDetailsList(ExpenseAccount ea) {
		// TODO Auto-generated method stub
		return expdao.getExpenseDetailsList(ea);
	}

	public void auditManager(AuditHistory ah) {

		// 订单对象
		ExpenseAccount ea = new ExpenseAccount();
		ea.setExpenseId(ah.getExpenseId());

		// 经理审核不通过
		if (Comm.EXPPENSE_STATE_REONE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPPENSE_STATE_ZERO);
			// 作废
		} else if (Comm.EXPPENSE_STATE_DELETE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPPENSE_STATE_DELETE);
		} else {
			// 审核通过
			ea.setExpenseState(ah.getAuditState());
		}
		// 修改报销单
		expdao.updateExpenseAccount(ea);
		// 添加历史记录
		expdao.addAuditHistory(ah);
	}

	public List<Map> getAuditHistoryList(ExpenseAccount ea) {

		return expdao.getAuditHistoryList(ea);
	}

	public void auditFinance(AuditHistory ah) {

		// 订单对象
		ExpenseAccount ea = new ExpenseAccount();
		ea.setExpenseId(ah.getExpenseId());

		// 财务审核不通过
		if (Comm.EXPPENSE_STATE_RETWO.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPPENSE_STATE_ZERO);
			// 作废
		} else if (Comm.EXPPENSE_STATE_DELETE.equals(ah.getAuditState())) {
			ea.setExpenseState(Comm.EXPPENSE_STATE_DELETE);
		} else {
			// 审核通过
			ea.setExpenseState(ah.getAuditState());
		}
		// 修改报销单
		expdao.updateExpenseAccount(ea);
		// 添加历史记录
		expdao.addAuditHistory(ah);
	}

	public List<ExpenseAccount> getLit(ExpenseAccount ea) {
		
		if(ea!=null){
			if(ea.getUserName()!=null && !ea.getUserName().equals("") ){
				ea.setUserName("%"+ea.getUserName()+"%");
			}
			
		}
		
		return expdao.getLit(ea);
	}

	public Long getCountLong(ExpenseAccount ea) {
		if(ea!=null){
			if(ea.getUserName()!=null && !ea.getUserName().equals("") ){
				ea.setUserName("%"+ea.getUserName()+"%");
			}
			
		}
		return expdao.getCountLong(ea);
	}



}
