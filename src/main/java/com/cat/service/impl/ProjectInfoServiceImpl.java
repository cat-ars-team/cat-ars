package com.cat.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ISFProjectFlow;
import com.cat.bean.LevelInfo;
import com.cat.bean.ProjectCustInfo;
import com.cat.bean.ProjectInfo; 
import com.cat.bean.UserInfo;
import com.cat.dao.IISFProjectFlowDAO;
import com.cat.dao.IProcDAO;
import com.cat.dao.IProjectCustInfoDAO;
import com.cat.dao.IProjectInfoDAO; 
import com.cat.dao.IRoleInfoDAO;
import com.cat.service.ILevelInfoService;
import com.cat.service.IProjectInfoService;
import com.cat.utils.DateUtil;
import com.cat.utils.Result;




@Service
@Transactional
public class ProjectInfoServiceImpl implements IProjectInfoService  {
	
	@Autowired
	private IProjectInfoDAO projectdao;
	
	
	@Autowired
	private IISFProjectFlowDAO flowdao;
	
	@Autowired
	private IRoleInfoDAO roledao;
	
	@Autowired
	private ILevelInfoService levelService;
	
	@Autowired
	private IProcDAO procdao;
	
	@Autowired
	private IProjectCustInfoDAO custdao;
	
	
	 
	
	public List<ProjectInfo> list(ProjectInfo bean) {
		// TODO Auto-generated method stub
		List<ProjectInfo> list=projectdao.list(bean);
		for (ProjectInfo projectInfo : list) {
			Date proTime = DateUtil.StringToDate(projectInfo.getProtime(), "yyyy-MM-dd");
			if(DateUtil.getDayInRange(proTime, new Date()) > 60){
				projectInfo.setIsCanBxzlSub(1);
			}else{
				projectInfo.setIsCanBxzlSub(0);
			}
		}
		return projectdao.list(bean);
	}
	
	
	public long getcount(ProjectInfo bean){
		
		return projectdao.getcount(bean);
	}


	@Override
	public int add(ProjectInfo pi) {
		// TODO Auto-generated method stub
		return projectdao.add(pi);
	}
	
	
	
	public Result custAdd(InputStream is,UserInfo currentUser,ProjectInfo pro)throws Exception {
		Result result=new Result();
		result.setFlag(1);
		//错误信息
		StringBuffer erroString= new StringBuffer();
		
		Workbook book = Workbook.getWorkbook(is);
		Sheet sheet = book.getSheet(0);
		System.out.println(sheet.getColumns());
		System.out.println(sheet.getRows());
		
		List<ProjectCustInfo> listToAddInfos=new ArrayList<ProjectCustInfo>();
		String roleName =currentUser.getRoleName();
		int rownums=sheet.getRows()-1;
		
		
		
		 if ( rownums>1) {	
			 pro.setLevel( levelService.GetLevelByCustNum(rownums).getLevelId());
			for (int i = 1; i < sheet.getRows(); i++) {
				ProjectCustInfo custInfo=new ProjectCustInfo();
				
				//客户名称	感兴趣设备（挖机/非挖机/未定）	购买意向是否在6个月之内？（是/否）	手机号码
				Date dtnowDate=new Date();
				
				Cell custNameCell = sheet.getCell(0, i); 
				String custName = custNameCell.getContents().trim();
				
				Cell macTypeCell = sheet.getCell(1, i); 
				String macType = macTypeCell.getContents().trim();
				
				Cell inSixMonthCell = sheet.getCell(2, i); 
				String inSixMonth = inSixMonthCell.getContents().trim();
				
				Cell phoneCell = sheet.getCell(3, i); 
				String phone = phoneCell.getContents().trim();
				
				if (!"".equals(custName)&&!"".equals(macType)&&!"".equals(inSixMonth)&&!"".equals(phone)) {
					custInfo.setProid(pro.getProid());
					
					custInfo.setCustname(custName);
					custInfo.setMacConn(macType);
					custInfo.setCustmobile(phone);
					custInfo.setBuyYn(inSixMonth);
					custInfo.setCreateby(  currentUser.getUserId().toString());
					custInfo.setCreatetime(dtnowDate);
					
					listToAddInfos.add(custInfo);
				}
				else {
					result.setFlag(0);
					erroString.append("第"+i+"行,信息不完整！ <br />");
				}
			}
		 }else {
				result.setFlag(0);
				erroString.append("你上传的附件为空！");
			}
		
		 if (result.getFlag()==1) {
			
			 //删除当前的用户
			custdao.delete(listToAddInfos.get(0));
			
			for (ProjectCustInfo projectCustInfo : listToAddInfos) {
				custdao.add(projectCustInfo);
			}
			ISFProjectFlow flow=new ISFProjectFlow();
			flow.setProid(pro.getProid());					
			flow=flowdao.getByProID(flow);
			flow.setIssubcustinfo(1);
			flow.setUpdateby(currentUser.getUserId());
			flow.setUpdatetime(new Date());		
			if (rownums>=500 || rownums<=30) {
				flow.setSpecialstatus(0);
			}else {
				flow.setSpecialstatus(1);
			}
			
			flowdao.update(flow);
			
			pro.setCustcount(Integer.toString(listToAddInfos.size()));
			projectdao.update(pro);
		}
		 
		
		 result.setMessageStr(erroString.toString());
		
		return result;
	}
	
	
	
	
	public Result batchAdd(InputStream is,UserInfo currentUser)throws Exception {
		Result result=new Result();
		
		StringBuffer warmString = new StringBuffer();
		StringBuffer erroString= new StringBuffer();
		 
		
		Workbook book = Workbook.getWorkbook(is);
		Sheet sheet = book.getSheet(0);
		System.out.println(sheet.getColumns());
		System.out.println(sheet.getRows());
		
		List<ProjectInfo> listToAddInfos=new ArrayList<ProjectInfo>();
		
		
		String roleName =currentUser.getRoleName();
		
			
		 if (sheet.getRows()>1) {	

			for (int i = 1; i < sheet.getRows(); i++) {
				ProjectInfo projectInfo=new ProjectInfo();
				
				projectInfo.setProtype("ISF");
				
				Cell levelCell = sheet.getCell(0, i); 
				String level = levelCell.getContents().trim();
				
				Cell custNumCell = sheet.getCell(1, i); 
				String custNumStr = custNumCell.getContents().trim();
				
				Cell proTimeCell = sheet.getCell(2, i); 
				String time = proTimeCell.getContents().trim();
			/*	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");*/
				
				
				Cell provinceCell = sheet.getCell(3, i);
				String province = provinceCell.getContents().trim();
				
				Cell cityCell = sheet.getCell(4, i); 
				String city = cityCell.getContents().trim();
				
				if ("".equals(level) || "".equals(custNumStr) || "".equals(time)|| "".equals(province)|| "".equals(city)) {
					erroString.append( "*第"+(i+1)+"行：请补全重要信息!"   + "<br />");
					break;
				}else {
					projectInfo.setCustcount(custNumStr);
					
					if(Integer.parseInt(custNumStr) < 30){				//如果人数小于30人,级别设置为[Tier4],状态设置为[未审核]
						projectInfo.setIsspecilal(1);
						projectInfo.setLevel("4");
						
						warmString.append("第"+(i+1)+"行:");
						if(!"Tier4".equals(level)){
							warmString.append( "活动人数与级别不匹配");
							continue;
						}
						warmString.append("(人数少于30人需审批)!"   + "<br />");
					}else if(Integer.parseInt(custNumStr) > 500){		//如果人数大于500,直接退出
						projectInfo.setIsspecilal(1);
						projectInfo.setLevel("1");
						 
						warmString.append("第"+(i+1)+"行:");
						if(!"Tier1".equals(level)){
							warmString.append( "活动人数与级别不匹配");
							continue;
						}
						warmString.append("(人数大于500人需审批)!"   + "<br />");
					}else{
						//根据客户人数获取级别信息
						LevelInfo levelInfo = levelService.GetLevelByCustNum(Integer.parseInt(custNumStr));
						String levelName = levelInfo.getLevelName().trim();
						
						projectInfo.setIsspecilal(0);
						projectInfo.setLevel(levelInfo.getLevelId());
						//获取到用户Excel级别与标准级别对比,如果对应,则插入数据库,否则,不插入,并给予提示
						if(!levelName.equals(level)){
							warmString.append( "第"+(i+1)+"行：活动人数与级别不匹配 ! <br />");
							continue;
						}
					}
				}
				
				projectInfo.setProprovince(province);
				projectInfo.setProcity(province);
						
				listToAddInfos.add(projectInfo);
			} //for end	 
				 
				
				/*if(agnId != null && !"".equals(agnId)){
					upi2013001.setAgnId(agnId);
				}
				//upi2013001.setProId(DateUtils.toString(new Date(), "yyyyMMddHHmmssSSS"));				//目前随机器生成时间戳,后续修改
				
				List<UPI2013004> listUPI004 = this.getUPI004ByAreaName(list.get(3).trim(), agnId);
				String areaId = "";
				String areadId = "";
				if(listUPI004.size() > 0){
					for (int j = 0; j < listUPI004.size(); j++) {
						if (listUPI004.get(j).getAreaname().equals(list.get(3).trim())) {
							areaId = listUPI004.get(j).getAreaid();
							List<UPI2013004> listUPI004Aread = this.getUPI004ByAreaName(list.get(4).trim(), agnId);
							for (int k = 0; k < listUPI004Aread.size(); k++) {
								if(listUPI004Aread.get(k).getBelogid().equals(areaId)){
									areadId = listUPI004Aread.get(k).getAreaid();
								}
							}
						}
					}
				}else{
					msg.append("地域超出所负责范围!" + list + "<br />");
					continue;
				}
				proIdInt++;
				String PROID = agnId + "1" + DateUtils.toString(new Date(), "yyyyMMdd") + this.formatStr("000", proIdInt);
				upi2013001.setProId(PROID);
				upi2013001.setProType("ISF");		//项目类型
				upi2013001.setLevel(levelId);		//级别
				if(num != null && !"".equals(num)){
					num = num.trim();
				}
				upi2013001.setCustNum(num);				//客户人数
				upi2013001.setProTime(list.get(2));		//项目时间

				upi2013001.setProArea(areaId);		//项目省份		list.get(3)
				upi2013001.setProAread(areadId);	//项目城市		list.get(4)
				
				upi2013001.setRatiYn(state);			//审核状态
				upi2013001.setCustState("0");			//是否导入客户信息
				upi2013001.setInsTime(new Date());		//插入时间
				upi2013001.setInsEmp(log2013001.getUserId());
				
				genericDAOService.save(upi2013001);
			}
			List<LOG2013002> log002 = this.findEmailByUserID(log2013001.getUserId());
			for (int i = 0; i < log002.size(); i++) {
				String email = log002.get(i).getEMail();
				if(email != null && !"".equals(email)){
					new Thread(new SendEmailThread("项目申请", email, msg.toString())).start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}else {
		erroString.append("*您上传的Excel是空的");
	}
		
		if ("".equals(erroString.toString())) {
			result.setFlag(1);
			result.setMessageStr(warmString.toString());
				
			for (ProjectInfo projectInfo : listToAddInfos) {
				projectInfo.setRoleid(currentUser.getRoleName());
				
				
				Map<String, Object> parms = new HashMap<String, Object>();  
		        parms.put("ProTypeStr", "ISF");  
		        parms.put("RoleNameStr", currentUser.getRoleName());  
		        parms.put("ProID", new String());  
		        procdao.getproid(parms); 
				 
				projectInfo.setProid(parms.get("ProID").toString());
				projectInfo.setProtype("ISF");
				projectInfo.setRoleid(currentUser.getRoleName());
				projectInfo.setCreateby(currentUser.getUserId().toString());
				projectInfo.setCreatetime(new Date());
				projectdao.add(projectInfo);		
				
				
				// 工作流添加
				ISFProjectFlow flow=new ISFProjectFlow();
				flow.setProid(projectInfo.getProid()); 			
				
				
				if (Integer.parseInt( projectInfo.getCustcount())<30 || Integer.parseInt( projectInfo.getCustcount())>500) {
					flow.setSpecialstatus(0);
				}else {
					flow.setSpecialstatus(1);
				}
				
				flow.setIssubcustinfo(0);
				flow.setIssubjbxx(0);
				flow.setIssubbxzl(0);
				flow.setIssubreceipt(0);
				flow.setBxstatus(0);
				
				flow.setCreateby(currentUser.getUserId());
				flow.setCreatetime(new Date());
				flowdao.add(flow);
			}
		}else {
			result.setFlag(0);
			result.setMessageStr(erroString.toString()+warmString.toString());
		}
		
		
		return result;
		
		
		
		
}

	@Override
	public int delete(ProjectInfo info) {
		// TODO Auto-generated method stub
		return projectdao.delete(info);
	}


	@Override
	public ProjectInfo getByProID(ProjectInfo bean) {
		// TODO Auto-generated method stub
		return projectdao.getByProID(bean);
	}


	@Override
	public int update(ProjectInfo pi) {
		// TODO Auto-generated method stub
		return projectdao.update(pi);
	}

 
	

}
