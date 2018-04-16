package com.cat.bean;

import com.cat.utils.BaseBean;

/**
 * 
 * <p>Title:CostInfo </p>
 * <p>Description:费用管理的实体类</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 * cost_id           
   cost_name           
   cost_desc          
   cost_mark           
 */
public class CostInfo extends BaseBean{

	/**
	 * 编号
	 */
	private Integer costId;
	
	/**
	 * 费用名称
	 */
	private String costName;
	
	/**
	 * 费用描述
	 */
	private String costDesc;
	
	/**
	 * 费用的标示
	 */
	private String costMark;

	public Integer getCostId() {
		return costId;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public String getCostDesc() {
		return costDesc;
	}

	public void setCostDesc(String costDesc) {
		this.costDesc = costDesc;
	}

	public String getCostMark() {
		return costMark;
	}

	public void setCostMark(String costMark) {
		this.costMark = costMark;
	}

	@Override
	public String toString() {
		return "CostInfo [costId=" + costId + ", costName=" + costName + ", costDesc=" + costDesc + ", costMark="
				+ costMark + "]";
	}
	
	
}
