function getSYDate(){
	var showDay="";
	var quarterStr = "";
	var quarterNum = "";
	var startDay=new Date();
	var year = startDay.getFullYear();
	var endDate=new Date();
	var array=new Array();
	var oneDate=new Date();
	var twoDate=new Date();
	var thrDate=new Date();
	var forDate=new Date();
	oneDate.setFullYear(year,4,31);
	twoDate.setFullYear(year,7,31);
	thrDate.setFullYear(year,10,30);
	forDate.setFullYear(year,11,15);
	if(startDay <= oneDate){
		quarterNum = "一";
		quarterStr = "5/31";
		showDay = (oneDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= twoDate){
		 quarterNum = "二";
		 quarterStr = "8/31";
		 showDay = (twoDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= thrDate){
		 quarterNum = "三";
		 quarterStr = "11/30";
		 showDay = (thrDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= forDate){
		 quarterNum = "四";
		 quarterStr = "12/15";
		 showDay = -( (startDay-forDate)/(1000*60*60*24) );
	 }else if(startDay > forDate){
		 quarterNum = "一";
		 quarterStr = "5/31";
		 showDay = -( (oneDate-startDay)/(1000*60*60*24) );
	 }
	 showDay = Math.floor(showDay);
	 var datePrompt = "距离第" + quarterNum + "季度报销截止日期" + quarterStr + "还剩" + showDay + "天";
	 $("#showSYDay").text(datePrompt);
}
function getSYDate_en(){
	var showDay="";
	var quarterStr = "";
	var quarterNum = "";
	var startDay=new Date();
	var year = startDay.getFullYear();
	var endDate=new Date();
	var array=new Array();
	var oneDate=new Date();
	var twoDate=new Date();
	var thrDate=new Date();
	var forDate=new Date();
	oneDate.setFullYear(year,4,31);
	twoDate.setFullYear(year,7,31);
	thrDate.setFullYear(year,10,30);
	forDate.setFullYear(year,11,15);
	if(startDay <= oneDate){
		quarterNum = "first";
		quarterStr = "5/31";
		showDay = (oneDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= twoDate){
		 quarterNum = "second";
		 quarterStr = "8/31";
		 showDay = (twoDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= thrDate){
		 quarterNum = "third";
		 quarterStr = "11/30";
		 showDay = (thrDate-startDay)/(1000*60*60*24);
	 }else if(startDay <= forDate){
		 quarterNum = "forth";
		 quarterStr = "12/15";
		 showDay = -( (startDay-forDate)/(1000*60*60*24) );
	 }else if(startDay > forDate){
		 quarterNum = "first";
		 quarterStr = "5/31";
		 showDay = -( (oneDate-startDay)/(1000*60*60*24) );
	 }
	 showDay = Math.floor(showDay);
	 var datePrompt = "It has "+ showDay +" days left since the "+ quarterNum + " quarter of reimbursement deadline on"+ quarterStr;
	alert(datePrompt);
	 $("#showSYDay").text(datePrompt);
}