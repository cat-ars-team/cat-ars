package com.cat.bean;

import java.util.Date;

public class Romi {
	private Integer id;
	    private String agntId;		//	代理商ID
	    private String proId;		//	项目ID
	    private String currCust;	//	现有客户
	    private String potenCust;	//	新的潜在客户
	    private String regisCust;	//	签到客户
	    private String newSaleld;	//	新的销售线索
	    private String saleldConrate;	//销售线索转化率
	    private String discMac;		//识别商机
	    private String deteQua;		//资质判断
	    private String formPlan;	//制定计划
	    private String deveProg;	//制定方案
	    private String openOppor;	//开启商机
	    private String winOrder;	//赢单GCI
	    private String lostSales;	//失单
	    private String noTrans;		//无交易
	    private String totalMac;	//产生的商机总数
	    private String macGenRate;	//商机产生率
	    private String dodCustnum;	//现场交付定金客户的数量
	    
	    private Date createtime;	//
	    private Integer createby;	//
	    private Date updatetime;	//
	    private Integer updateby;	//
	    private String winOrders;	//赢单BCP

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getAgntId() {
	        return agntId;
	    }

	    public void setAgntId(String agntId) {
	        this.agntId = agntId;
	    }

	    public String getProId() {
	        return proId;
	    }

	    public void setProId(String proId) {
	        this.proId = proId;
	    }

	    public String getCurrCust() {
	        return currCust;
	    }

	    public void setCurrCust(String currCust) {
	        this.currCust = currCust;
	    }

	    public String getPotenCust() {
	        return potenCust;
	    }

	    public void setPotenCust(String potenCust) {
	        this.potenCust = potenCust;
	    }

	    public String getRegisCust() {
	        return regisCust;
	    }

	    public void setRegisCust(String regisCust) {
	        this.regisCust = regisCust;
	    }

	    public String getNewSaleld() {
	        return newSaleld;
	    }

	    public void setNewSaleld(String newSaleld) {
	        this.newSaleld = newSaleld;
	    }

	    public String getSaleldConrate() {
	        return saleldConrate;
	    }

	    public void setSaleldConrate(String saleldConrate) {
	        this.saleldConrate = saleldConrate;
	    }

	    public String getDiscMac() {
	        return discMac;
	    }

	    public void setDiscMac(String discMac) {
	        this.discMac = discMac;
	    }

	    public String getDeteQua() {
	        return deteQua;
	    }

	    public void setDeteQua(String deteQua) {
	        this.deteQua = deteQua;
	    }

	    public String getFormPlan() {
	        return formPlan;
	    }

	    public void setFormPlan(String formPlan) {
	        this.formPlan = formPlan;
	    }

	    public String getDeveProg() {
	        return deveProg;
	    }

	    public void setDeveProg(String deveProg) {
	        this.deveProg = deveProg;
	    }

	    public String getOpenOppor() {
	        return openOppor;
	    }

	    public void setOpenOppor(String openOppor) {
	        this.openOppor = openOppor;
	    }

	    public String getWinOrder() {
	        return winOrder;
	    }

	    public void setWinOrder(String winOrder) {
	        this.winOrder = winOrder;
	    }

	    public String getLostSales() {
	        return lostSales;
	    }

	    public void setLostSales(String lostSales) {
	        this.lostSales = lostSales;
	    }

	    public String getNoTrans() {
	        return noTrans;
	    }

	    public void setNoTrans(String noTrans) {
	        this.noTrans = noTrans;
	    }

	    public String getTotalMac() {
	        return totalMac;
	    }

	    public void setTotalMac(String totalMac) {
	        this.totalMac = totalMac;
	    }

	    public String getMacGenRate() {
	        return macGenRate;
	    }

	    public void setMacGenRate(String macGenRate) {
	        this.macGenRate = macGenRate;
	    }

	    public String getDodCustnum() {
	        return dodCustnum;
	    }

	    public void setDodCustnum(String dodCustnum) {
	        this.dodCustnum = dodCustnum;
	    }

	    public Date getCreatetime() {
	        return createtime;
	    }

	    public void setCreatetime(Date createtime) {
	        this.createtime = createtime;
	    }

	    public Integer getCreateby() {
	        return createby;
	    }

	    public void setCreateby(Integer createby) {
	        this.createby = createby;
	    }

	    public Date getUpdatetime() {
	        return updatetime;
	    }

	    public void setUpdatetime(Date updatetime) {
	        this.updatetime = updatetime;
	    }

	    public Integer getUpdateby() {
	        return updateby;
	    }

	    public void setUpdateby(Integer updateby) {
	        this.updateby = updateby;
	    }

	    public String getWinOrders() {
	        return winOrders;
	    }

	    public void setWinOrders(String winOrders) {
	        this.winOrders = winOrders;
	    }

		@Override
		public String toString() {
			return "Romi [id=" + id + ", agntId=" + agntId + ", proId=" + proId
					+ ", currCust=" + currCust + ", potenCust=" + potenCust
					+ ", regisCust=" + regisCust + ", newSaleld=" + newSaleld
					+ ", saleldConrate=" + saleldConrate + ", discMac="
					+ discMac + ", deteQua=" + deteQua + ", formPlan="
					+ formPlan + ", deveProg=" + deveProg + ", openOppor="
					+ openOppor + ", winOrder=" + winOrder + ", lostSales="
					+ lostSales + ", noTrans=" + noTrans + ", totalMac="
					+ totalMac + ", macGenRate=" + macGenRate + ", dodCustnum="
					+ dodCustnum + ", createtime=" + createtime + ", createby="
					+ createby + ", updatetime=" + updatetime + ", updateby="
					+ updateby + ", winOrders=" + winOrders + "]";
		}
	    
	    
	}