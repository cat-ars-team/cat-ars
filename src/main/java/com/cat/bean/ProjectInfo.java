package com.cat.bean;

import java.util.Date;

import com.cat.utils.BaseBean;

public class ProjectInfo extends BaseBean {
    private Integer id;

    private String proid;

    private String protype;

    private String roleid;

    private String level;

    private String custcount;

    private String protime;

    private String proprovince;

    private String procity;

    private String ratiYn;

    private Date createtime;

    private String createby;

    private Date updatetime;

    private String updateby;

    private String custState;

    private String factId;

    private String totalcust;

    private String appreim;
    
    private Integer isspecilal;
    
    private Integer isnusgo;
    
    private String remark;
   
    
    
    public Integer getIsnusgo() {
        return isnusgo;
    }

    public void setIsnusgo(Integer isnusgo) {
        this.isnusgo = isnusgo;
    }
    
    
    // 以下都爲狀態
    private Integer bxstatus;
	private Integer issubbxzl;
    private Integer issubcustinfo;
    private Integer issubreceipt;
    private Integer specialstatus;
    private Integer issubjbxx;
    
    private Integer  isCanBxzlSub;
    
    public Integer getIsCanBxzlSub() {
		return isCanBxzlSub;
	}

	public void setIsCanBxzlSub(Integer isCanBxzlSub) {
		this.isCanBxzlSub = isCanBxzlSub;
	}

	public Integer getIssubjbxx() {
		return issubjbxx;
	}
	public void setIssubjbxx(Integer issubjbxx) {
		this.issubjbxx = issubjbxx;
	}
	public Integer getBxstatus() {
  		return bxstatus;
  	}
  	public void setBxstatus(Integer bxstatus) {
  		this.bxstatus = bxstatus;
  	}
  	public Integer getIssubbxzl() {
  		return issubbxzl;
  	}
  	public void setIssubbxzl(Integer issubbxzl) {
  		this.issubbxzl = issubbxzl;
  	}
  	public Integer getIssubcustinfo() {
  		return issubcustinfo;
  	}
  	public void setIssubcustinfo(Integer issubcustinfo) {
  		this.issubcustinfo = issubcustinfo;
  	}
  	public Integer getIssubreceipt() {
  		return issubreceipt;
  	}
  	public void setIssubreceipt(Integer issubreceipt) {
  		this.issubreceipt = issubreceipt;
  	}
  	public Integer getSpecialstatus() {
  		return specialstatus;
  	}
  	public void setSpecialstatus(Integer specialstatus) {
  		this.specialstatus = specialstatus;
  	}

    public Integer getIsspecilal() {
		return isspecilal;
	}

	public void setIsspecilal(Integer isspecilal) {
		this.isspecilal = isspecilal;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getProtype() {
        return protype;
    }

    public void setProtype(String protype) {
        this.protype = protype;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCustcount() {
        return custcount;
    }

    public void setCustcount(String custcount) {
        this.custcount = custcount;
    }

    public String getProtime() {
        return protime;
    }

    public void setProtime(String protime) {
        this.protime = protime;
    }

    public String getProprovince() {
        return proprovince;
    }

    public void setProprovince(String proprovince) {
        this.proprovince = proprovince;
    }

    public String getProcity() {
        return procity;
    }

    public void setProcity(String procity) {
        this.procity = procity;
    }

    public String getRatiYn() {
        return ratiYn;
    }

    public void setRatiYn(String ratiYn) {
        this.ratiYn = ratiYn;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getCustState() {
        return custState;
    }

    public void setCustState(String custState) {
        this.custState = custState;
    }

    public String getFactId() {
        return factId;
    }

    public void setFactId(String factId) {
        this.factId = factId;
    }

    public String getTotalcust() {
        return totalcust;
    }

    public void setTotalcust(String totalcust) {
        this.totalcust = totalcust;
    }

    public String getAppreim() {
        return appreim;
    }

    public void setAppreim(String appreim) {
        this.appreim = appreim;
    }
    
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}