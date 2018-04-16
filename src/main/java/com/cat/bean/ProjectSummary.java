package com.cat.bean;

import java.util.Date;

public class ProjectSummary {
	 private Integer id;               
	 private String proId;            //项目ID	   
	 private String rolename;         //代理商ID  
	 private String proType;          //项目类型 
	 private String proLevel;         //级别        
	 private String custNum;          //客户人数    
	 private String proDate;          //项目时间    
	 private String proPlace;         //所在省      
	 private String proPlaced;        //所在城市    
	 private String prdcSupp;         //产品支持    
	 private String macMang;          //设备管理    
	 private String demoMac;          //样机        
	 private String ratUsed;          //租赁二手    
	 private String catFl;            //卡特融资租赁
	 private Date createtime;         //创建时间    
	 private String createby;         //创建ID      
	 private Date updatetime;         //创建人ID    
	 private String updateby;         //修改时间    
	 private String totalCust;        //项目总花费  
	 private String appReim= "0";		//报销金额      



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProLevel() {
        return proLevel;
    }

    public void setProLevel(String proLevel) {
        this.proLevel = proLevel;
    }

    public String getCustNum() {
        return custNum;
    }

    public void setCustNum(String custNum) {
        this.custNum = custNum;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getProPlace() {
        return proPlace;
    }

    public void setProPlace(String proPlace) {
        this.proPlace = proPlace;
    }

    public String getProPlaced() {
        return proPlaced;
    }

    public void setProPlaced(String proPlaced) {
        this.proPlaced = proPlaced;
    }

    public String getPrdcSupp() {
        return prdcSupp;
    }

    public void setPrdcSupp(String prdcSupp) {
        this.prdcSupp = prdcSupp;
    }

    public String getMacMang() {
        return macMang;
    }

    public void setMacMang(String macMang) {
        this.macMang = macMang;
    }

    public String getDemoMac() {
        return demoMac;
    }

    public void setDemoMac(String demoMac) {
        this.demoMac = demoMac;
    }

    public String getRatUsed() {
        return ratUsed;
    }

    public void setRatUsed(String ratUsed) {
        this.ratUsed = ratUsed;
    }

    public String getCatFl() {
        return catFl;
    }

    public void setCatFl(String catFl) {
        this.catFl = catFl;
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

    public String getTotalCust() {
        return totalCust;
    }

    public void setTotalCust(String totalCust) {
        this.totalCust = totalCust;
    }

    public String getAppReim() {
        return appReim;
    }

    public void setAppReim(String appReim) {
        this.appReim = appReim;
    }
}