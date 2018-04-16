package com.cat.bean;

import java.util.Date;

import com.cat.utils.BaseBean;

/**
 * 
 * <p>Title:RoleInfo </p>
 * <p>Description:角色管理的实体类</p>
 * <p>Company:北风网</p>
 * @author 老牛
 * @version 1.0
 */
public class RoleInfo extends BaseBean{

	//角色编号
	private Integer roleId;
	
	//角色名称
	private String roleName;
	
	//角色描述
	private String roleDesc;
	
	//标示
	private String roleMark;
	
	
	private Date createTime;
	
	private Integer createBy;
	
	private Date updateTime;
	
	private Integer updateBy;
	
	private Integer delFlag;
	
	private Double amount;
	
	 private Double rolerate;
	
	
	public Double getRolerate() {
		return rolerate;
	}

	public void setRolerate(Double rolerate) {
		this.rolerate = rolerate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}

	

	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRoleMark() {
		return roleMark;
	}

	public void setRoleMark(String roleMark) {
		this.roleMark = roleMark;
	}
	
	
}
