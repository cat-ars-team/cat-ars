/**
 * 
 */
package com.cat.utils;

import com.cat.utils.SendEmailUtil;

/**
 * <p>zhcz</p>
 * 发送E-mail线程类
 */
public class SendEmailThread extends Thread {
	
	/** 邮件主题 */
	private String subject;
	/** 发送邮件地址 */
	private String emailAddress;
	/** 邮件内容 */
	private String msgContent;
	/** 附件路径 */
	private String fileAffixPath;

	public SendEmailThread(){}
	
	/**
	 * 发送E-mail线程类构造方法
	 * @param subject 邮件主题 
	 * @param emailAddress 发送邮件地址
	 * @param msgContent 邮件内容
	 */
	public SendEmailThread(String subject, String emailAddress, String msgContent){
		this.subject = subject;
		this.emailAddress = emailAddress;
		this.msgContent = msgContent;
	}
	
	/**
	 * 发送E-mail线程类构造方法
	 * @param subject 邮件主题 
	 * @param emailAddress 发送邮件地址
	 * @param msgContent 邮件内容
	 * @param fileAffixPath 附件路径
	 */
	public SendEmailThread(String subject, String emailAddress, String msgContent, String fileAffixPath ){
		this.subject = subject;
		this.emailAddress = emailAddress;
		this.msgContent = msgContent;
		this.fileAffixPath = fileAffixPath;
	}
	
	public void run(){
		new SendEmailUtil().send(subject, emailAddress, msgContent, fileAffixPath);
	}
	
}
