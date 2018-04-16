package com.cat.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.bean.SalaryPayment;
import com.cat.dao.ISalaryPaymentDAO;
import com.cat.service.ISalaryPaymentService;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Service
@Transactional
public class SalaryPaymentServiceImpl implements ISalaryPaymentService {

	@Autowired
	private ISalaryPaymentDAO spdao;

	public void add(SalaryPayment sp) {
		spdao.add(sp);

	}

	public List<SalaryPayment> list(SalaryPayment sp) {

		if (sp != null) {
			if (sp.getUserName() != null && !sp.getUserName().equals("")) {
				sp.setUserName("%"+sp.getUserName()+"%");
			}
		}

		return spdao.list(sp);
	}

	public Long getcount(SalaryPayment sp) {

		if (sp != null) {
			if (sp.getUserName() != null && !sp.getUserName().equals("")) {
				sp.setUserName("%"+sp.getUserName()+"%");
			}
		}
		return spdao.getcount(sp);
	}

	public void addAll(InputStream is)throws Exception {
		
			Workbook book = Workbook.getWorkbook(is);
			Sheet sheet = book.getSheet(0);
			System.out.println(sheet.getColumns());
			System.out.println(sheet.getRows());
			
			for(int i=1;i<sheet.getRows();i++){
				SalaryPayment sp = new SalaryPayment();
				
				//用户编号
				Cell idcell = sheet.getCell(0, i); 
				Integer userId = Integer.parseInt(idcell.getContents());
				sp.setUserId(userId);
				
				//发放时间
				Cell timecell = sheet.getCell(2, i); 
				String time = timecell.getContents();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date paymentTime = sdf.parse(time);
				sp.setPaymentTime(paymentTime);
				
				//发放金额
				Cell moneycell = sheet.getCell(3, i); 
				Double paymentMoney =  Double.parseDouble(moneycell.getContents());
				sp.setPaymentMoney(paymentMoney);
				spdao.add(sp);
			
				
			}
			
			
			
		
		
		
	}

}
