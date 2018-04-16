package com.cat.utils;

/**
 * 
 * <p>
 * Title:Comm
 * </p>
 * <p>
 * Description:公共类
 * </p>
 * <p>
 * Company:xxxx
 * </p>
 * 
 * @author 老牛
 * @version 1.0
 */
public class Comm {

	// 有效
	public final static String MARK_YES = "1";
	// 无效
	public final static String MARK_NO = "0";

	// 报销单状态
	// 报销但作废
	public final static String EXPPENSE_STATE_DELETE = "del";
	// 报销单初始状态
	public final static String EXPPENSE_STATE_ZERO = "0";
	// 部门经理审核
	public final static String EXPPENSE_STATE_ONE = "1";
	// 部门经理审核不通过
	public final static String EXPPENSE_STATE_REONE = "-1";
	// 部门经理审核通过,财务经理审核
	public final static String EXPPENSE_STATE_TWO = "2";
	// 财务经理审核不通过
	public final static String EXPPENSE_STATE_RETWO = "-2";
	// 财务经理审核通过
	public final static String EXPPENSE_STATE_OK = "3";
}
