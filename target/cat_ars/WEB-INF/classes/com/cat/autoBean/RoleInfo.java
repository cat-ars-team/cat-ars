package com.cat.autoBean;

import java.util.Date;

public class RoleInfo {
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private String roleMark;

    private Integer isspecial;

    private Integer createby;

    private Date createtime;

    private Integer updateby;

    private Date updatetime;

    private Integer delflag;

    private Double amount;

    private Double rolerate;

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

    public Integer getIsspecial() {
        return isspecial;
    }

    public void setIsspecial(Integer isspecial) {
        this.isspecial = isspecial;
    }

    public Integer getCreateby() {
        return createby;
    }

    public void setCreateby(Integer createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getUpdateby() {
        return updateby;
    }

    public void setUpdateby(Integer updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Integer getDelflag() {
        return delflag;
    }

    public void setDelflag(Integer delflag) {
        this.delflag = delflag;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getRolerate() {
        return rolerate;
    }

    public void setRolerate(Double rolerate) {
        this.rolerate = rolerate;
    }
}