/**
 * 
 */
package com.cat.utils;



/**
 * <p>zhucz</p>
 *邮件工具类
 */
public class EmailText {

	public static final String LSHM = "E001";
	public static final String WTC = "E002";
	public static final String ECIM = "E003";
	public static final String CEL = "E004";
	public static final String ISF_MANAGER = "E005";
	public static final String FACTORY_MANAGER = "E006";
	public static final String mJoule = "E007";
	public static final String CALL_CANTER = "E008";
	public static final String YMT = "E009";
	public static final String MIND_SHARE = "E010";
	public static final String FACTORY_SZ = "E011";
	public static final String FACTORY_XZ = "E012";
	
	
	/** 邮件内容 */
	private static String emailText = "";
	/** 邮件内容公共部分 */
	private static String commonText = "<br />谢谢！<br />"
									 + "卡特代理商报销平台<br />"
									 + "www.catdealer.cn";
	
	public static String emailTextStyle(String emailContent){
		String emailContentStyle = "<DIV style='border:2px solid #57779E;padding:10px;width:500px;'>"
								 + emailContent
								 + "</DIV>";
		return emailContentStyle;
	} 
	
	/**
	 * 创建ISF项目少于30人时，发邮件给Annie提醒审批
	 * @param agntId 代理商ID
	 * @param proId 项目ID
	 * @param proDate 项目日期
	 * @return
	 */
	public static String createISF_LessThan_ToISFManager(String dear, String agntId, String proId, String proDate){
		emailText = "Dear " + dear + ",<br /><br />"
				  +	"代理商<u>" + agntId + "</u>提交了一个少于30人的ISF项目需要您审批，项目ID为<br />"
				  + "<u>" + proId + "</u>，项目日期为：<u>" + proDate + "</u>，请登录平台进行审<br />"
				  + "批操作。<br />"
				  + commonText;
		return emailText;
	}
	
	/**
	 * 代理商上传客户名单时，客户人数小于30人但申请项目时不小于30人
	 * @param agntId 代理商ID
	 * @param proId 项目ID
	 * @param proDate 项目日期
	 * @return
	 */
	public static String createISF_LessThan_ToISFManagers(String dear, String agntId, String proId, String proDate){
		emailText = "Dear " + dear + ",<br /><br />"
				  +	"代理商<u>" + agntId + "</u>提交了项目ID为"
				  + "<u>" + proId + "</u>的客户名单，项目日期为：<br /><br /><u>" + proDate + "</u>，客户人数小于30人但申请项目时不小于30人，请知<br /><br />悉。<br /><br />如有疑问，请及时联系代理商。<br />"
				  + commonText;
		return emailText;
	}
	
	public static String createISF_MoreThan_ToISFManager(String dear, String agntId, String proId, String proDate){
	    emailText = "Dear " + dear + ",<br /><br />" + "代理商<u>" + agntId + "</u>提交了一个大于500人的ISF项目需要您审批，项目ID为<br />" + 
	      "<u>" + proId + "</u>，项目日期为：<u>" + proDate + "</u>，请登录平台进行审<br />" + "批操作。<br />" + commonText;
	    return emailText;
	}
	
	public static String moreISF_ToAgnt(String dear, String proId, String result, String toPerson){
	    emailText = "Dear " + dear + ",<br /><br />" + 
	      "您提交的大于500人的ISF项目<u>" + proId + "</u>，<u>" + result + "</u>CAT GCI的审批，<br />" + 
	      "如有需要，请与" + toPerson + "联系。<br />" + 
	      commonText;
	    return emailText;
	}
	
	/**
	 * ISF审批完成后，发审批结果给代理商
	 * @param proId 项目ID
	 * @param result 审批结果
	 * @param toPerson 邮件接受者
	 * @return
	 */
	public static String examineISF_ToAgnt(String dear, String proId, String result, String toPerson){
		emailText = "Dear " + dear + ",<br /><br />"
			      + "您提交的少于30人的ISF项目<u>" + proId + "</u>，<u>" + result + "</u>CAT GCI的审批，<br />"
				  + "如有需要，请与" + toPerson + "联系。<br />"
				  + commonText;
		return emailText;
	}
	
	/**
	 * 代理商提交客户名单后，给Call center发提醒
	 * @param proId 项目ID
	 * @return
	 */
	public static String submitCustomInfo_ToCallCenter(String dear, String proId){
		emailText = "Dear " + dear + ",<br /><br />"
				  + "项目<u>" + proId + "</u>已在平台中提交了客户名单，请及时下载回访。<br />"
				  + commonText;
		return emailText;
	}
	
	/**
	 * Call center回访后，将该项目的回访情况（参与率和跟进率）发给代理商
	 * @param proId
	 * @param costomPartakePercent
	 * @param agntFollowUpPercent
	 * @param toPerson
	 * @return
	 */
	public static String visit_ToAgnt(String dear, String proId, String costomPartakePercent, String agntFollowUpPercent, String toPerson){
		emailText = "Dear " + dear + ",<br /><br />"
			      + "项目LSHM120130902008的回访情况为：客户参与率：<u>" + NumberUtil.precentFormat(costomPartakePercent) + "</u>，代理商跟进<br />"
				  + "率：<u>" + NumberUtil.precentFormat(agntFollowUpPercent) + "</u>。<br />"
				  + "如有疑问，请及时与" + toPerson + "联系。<br />"
				  + commonText;
		return emailText;
	}
	
	/**
	 * 将报销的审批结果（包含批准报销备注）发给代理商
	 * @param proId 项目ID
	 * @param result 报销批准结果
	 * @param toPerson 邮件接收人
	 * @return
	 */
	public static String examineExpense_ToAgnt(String dear, String proId, String result, String remark, String toPerson){
		emailText = "Dear " + dear + ",<br /><br />"
				  + "项目<u>" + proId + "</u>的报销审批结果为：<u>" + result + "</u>，批准报销备注为：<br />"
		          + "<u>" + remark + "</u>，请及时登录平台进行查看。<br />"
		          + "如有疑问，请及时与" + toPerson + "联系。<br />"
		          + commonText;
		return emailText;
	}
	
	/**
	 * 创建工厂项目，给Cat和工厂发邮件
	 * @param agntId 代理商ID
	 * @param proId 项目ID
	 * @param visitDate 参观日期
	 * @param applyPersonNum 申请人数
	 * @return
	 */
	public static String createFactory_ToCAT_Factory(String dear, String agntId, String proId, String visitDate, String applyPersonNum){
		emailText = "Dear " + dear + ",<br /><br />"
				  + "代理商<u>" + agntId + "</u>提交了一个徐州工厂参观的申请，项目ID为<br />"
				  + "<u>" + proId + "</u>，参观日期为：<u>" + visitDate + "</u>，申请人数为：<u>" + applyPersonNum + "</u>人，<br />"
				  + "请进行相应准备。<br />"
				  + "如有疑问，请及时与" + agntId + "联系。<br />"
				  + commonText;
		return emailText;
	}
	
	/**
	 * 创建省级广告推广项目，给Cat发邮件，通知去审批该项目
	 * @param agntId 代理商ID
	 * @param proId 项目ID
	 * @return
	 */
	public static String createAdvert_ToCAT(String dear, String agntId, String proId){
		emailText = "Dear " + dear + ",<br /><br />"
				  + "代理商<u>" + agntId + "</u>提交了一个省级广告推广项目<u>" + proId + "</u>，请及时登<br />"
		          + "录平台进行查看及审批。<br />"
		          + commonText;
		return emailText;
	}
	
	/**
	 * 一年四个报销截止日，在第二天发邮件提醒Annie进行批准操作
	 * @return
	 */
	public static String send_ToISFManager(){
		emailText = "Dear Annie Deng,<br /><br />"
				  + "各代理商已于昨天（上季度报销截止日）完成上季度ISF项目的报销资料<br />"
				  + "录入工作，请及时登录平台进行报销批准操作。<br />"
				  + commonText;
		return emailText;
	}
}
