package com.cat.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.ISFProjectFlow;
import com.cat.bean.Nusgoprojectinfo;
import com.cat.bean.ProjectCustInfo;
import com.cat.bean.ProjectInfo;
import com.cat.bean.UserInfo;
import com.cat.dao.INusgoprojectinfoDAO;
import com.cat.dao.IProjectCustInfoDAO;
import com.cat.service.INusgoprojectinfoService;
import com.cat.utils.Result;


@Service
@Transactional
public class NusgoprojectinfoServiceImpl implements INusgoprojectinfoService {

	@Autowired
	private INusgoprojectinfoDAO nusgoDao;
	
	@Autowired
	private IProjectCustInfoDAO custdao;
	
	
	@Override
	public List<Nusgoprojectinfo> list(Nusgoprojectinfo bean) {
		// TODO Auto-generated method stub
		return nusgoDao.list(bean);
	}


	@Override
	public int add(Nusgoprojectinfo bean) {
		// TODO Auto-generated method stub
		return nusgoDao.add(bean);
	}


	@Override
	public Nusgoprojectinfo getByProid(Nusgoprojectinfo bean) {
		// TODO Auto-generated method stub
		return nusgoDao.getByProid(bean);
	}
	
	


	@Override
	public Result custAdd(InputStream is, UserInfo currentUser,Nusgoprojectinfo pro) throws Exception {
		// TODO Auto-generated method stub


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
				erroString.append("您上传的附件为空！");
			}
		
		 if (result.getFlag()==1) {
			
			 //删除当前的用户
			custdao.delete(listToAddInfos.get(0));
			
			for (ProjectCustInfo projectCustInfo : listToAddInfos) {
				custdao.add(projectCustInfo);
			}
		
			//pro.(Integer.toString(listToAddInfos.size()));
			//projectdao.update(pro);
		}
		 
		
		 result.setMessageStr(erroString.toString());
		
		return result;
	}


	@Override
	public int listCount(Nusgoprojectinfo bean) {
		// TODO Auto-generated method stub
		return nusgoDao.listCount(bean);
	}


	@Override
	public int update(Nusgoprojectinfo bean) {
		// TODO Auto-generated method stub
		return nusgoDao.update(bean);
	}
	
	
	 

}
