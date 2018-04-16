package com.cat.bean;

import java.util.Date;


public class ISFProjectFlow {
	 private String proid;

	    private Integer bxstatus;

	    private Integer issubbxzl;

	    private Integer issubcustinfo;

	    private Integer issubreceipt;

	    private Integer specialstatus;

	    private Integer issubjbxx;

	    public Integer getIssubjbxx() {
			return issubjbxx;
		}

		public void setIssubjbxx(Integer issubjbxx) {
			this.issubjbxx = issubjbxx;
		}

		private Integer createby;

	    private Date createtime;

	    private Integer updateby;

	    private Date updatetime;

	    public String getProid() {
	        return proid;
	    }

	    public void setProid(String proid) {
	        this.proid = proid;
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
	}