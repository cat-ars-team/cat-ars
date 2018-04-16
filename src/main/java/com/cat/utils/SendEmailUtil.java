package com.cat.utils;

import java.io.InputStream;
import java.util.Properties;


public class SendEmailUtil{

    public SendEmailUtil (){

    }
	public void run() {
 
	}
	
	/**
	 * 发送邮件
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @param toAddress 接受的邮件地址
	 * @param fileAffixPath 附件路径
	 */
	public void send(String subject, String toAddress, String content, String fileAffixPath){
 		try{
 			
 			InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email.properties");
 			Properties properties = new Properties();
 			properties.load(inputStream);
 			
 			String hostName = properties.getProperty("hostName");
 			String fromAddress = properties.getProperty("fromAddress");
 			String fromPwd = properties.getProperty("fromPwd");
 			
			EmailHandle emailHandle = new EmailHandle(hostName);
			emailHandle.setFrom(fromAddress);
			emailHandle.setNeedAuth(true);
			emailHandle.setSubject(subject);
			emailHandle.setBody(content);
			emailHandle.setTo(toAddress);
			emailHandle.setFrom(fromAddress);
			if(!"".equals(fileAffixPath) && fileAffixPath != null){
				emailHandle.addFileAffix(fileAffixPath);	//附件文件路径
			}
			emailHandle.setNamePass(fromAddress, fromPwd);
		
			emailHandle.sendEmail();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public static void main(String []args){
		String subject = "Activat Your Cat GCI WeChat Account (Catch!)";
		String content = "<a href='http://www.baidu.com'>这里是百度首页</a>";
		String toAddress = "jiang.jia@mjoule.com.cn";
		SendEmailUtil send = new SendEmailUtil();
		send.send(subject, toAddress, content, "");
	}

}
