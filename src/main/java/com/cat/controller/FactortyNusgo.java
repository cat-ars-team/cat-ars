package com.cat.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cat.bean.AreaRole;
import com.cat.bean.NusgoFlow;
import com.cat.bean.Nusgoprojectinfo;
import com.cat.bean.UserInfo;
import com.cat.service.INusgoFlowService;
import com.cat.service.INusgoprojectinfoService;
import com.cat.service.IProcService;
import com.cat.utils.Page;
import com.cat.utils.Result;




@Controller
@RequestMapping("/FactoryNusgo/")
public class FactortyNusgo extends Page {
	
	@Autowired
	private INusgoprojectinfoService nusgoService;
	
	@Autowired
	private IProcService procService;
	
	@Autowired
	private INusgoFlowService flowService;
	
	@RequestMapping("list.do")
	public String listAll(Nusgoprojectinfo bean,HttpServletRequest request, Model model ) {
		 
			UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			if(bean == null){
				bean = new Nusgoprojectinfo();
			}
			bean.setProtype("FactoryNUSGO");
						
			String roleName = currentUserInfo.getRoleName();//"WTC"; 
			AreaRole areaRole=new AreaRole();
			
				bean.setRoleid(roleName);
				areaRole.setRolename(currentUserInfo.getRoleName());
							
			//model.addAttribute("provincelist", areaService.provincelist(areaRole));
			// 分页信息
			this.initPage(request);
			// 起始记录
			bean.setStart(this.getPageNo());
			
			// 每页显示记录数
			bean.setLength(PAGE_NUM_BIG);
			 
			List<Nusgoprojectinfo> listNusgoprojectinfos=nusgoService.list(bean);
			model.addAttribute("list", listNusgoprojectinfos );	
			model.addAttribute("projectadd",bean);
			// 总记录数
			model.addAttribute("total", nusgoService.listCount(bean));
										
					
		return "Factory/NUSGO_list";
	}
	
	
	@RequestMapping("batchadd.do")
	public String batchadd(Nusgoprojectinfo bean,HttpServletRequest request, Model model ) {
		
		return listAll(null,request,model);
	}
	
	@RequestMapping("addppp.do")
	public String add(Nusgoprojectinfo proInfo, Model model,  HttpServletRequest request ) {
		Result result=new Result();
		
		result.setFlag(1);

		StringBuffer warmString=new StringBuffer();
		try {
			
			Integer errocount=0;
			UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			
			// 获取角色名称
			String roleName =currentUserInfo.getRoleName();//"WTC";
			
			Map<String, Object> parms = new HashMap<String, Object>();  
	        parms.put("ProTypeStr", "FactoryNUSGO");  
	        parms.put("RoleNameStr", roleName);  
	        parms.put("ProID", new String());  
	        procService.getproid(parms); 
			
			
			String proID= parms.get("ProID").toString();
			
			
			proInfo.setProid(proID);
			proInfo.setProtype("FactoryNUSGO");
			proInfo.setRoleid(roleName);
			
			proInfo.setCreateby(currentUserInfo.getUserId().toString());
			proInfo.setCreatedate(new Date());
			
			
			NusgoFlow flow=new NusgoFlow();
			flow.setProid(proID);
			flow.setEventproposal(0);
			flow.setEndoftheevent(0);
			flow.setSalesmanagerFirst(0);
			flow.setAdminFirst(0);
			flow.setMarcommanagerFirst(0);
			flow.setEmailtogcileaderFirst(0);
			flow.setSalesmanagerFirst(0);
			flow.setAdminSecond(0);
			flow.setMarcommanagerSecond(0);
			flow.setGcileaderSecond(0);
			flow.setCreateby(currentUserInfo.getUserId().toString());
			flow.setCreatedate(new Date());
						
			nusgoService.add(proInfo);
			flowService.add(flow);
		
		} catch (Exception e) {
			e.printStackTrace();
			result.setFlag(0);
			warmString.append( "项目添加失败！\\n网络故障，请联系管理员!");
		}
			
		if (result.getFlag()==1) {
			result.setMessageStr("项目添加成功！\\n"+(warmString.toString()==null?"":warmString).toString());
			
		}else {
			result.setMessageStr("项目添加失败,请重新提交！ \\n"+(warmString.toString()==null?"":warmString).toString());
		}
		
		model.addAttribute("proaddResult", result);
		return listAll(null,request,model);

		
	}
	
	
	@RequestMapping("update.do")  
	private String subreceipt(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {  
			 UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			 
			  	String proid = request.getParameter("subReceiptProid");
			  	String approveType = request.getParameter("approveType");
			  	String updatetype = request.getParameter("updatetype"); 
			  	Integer approveValue =0;
			  	if (request.getParameter("approveValue")!=null &&  !"".equals(request.getParameter("approveValue"))) {
			  		approveValue=Integer.parseInt(request.getParameter("approveValue"));
				}
			  	
			  	
				// 修改 projectflow
			  	try {
			  	NusgoFlow flow=new NusgoFlow();
			  	flow.setProid(proid);
			  	flow=flowService.getbyproid(flow);
			  	
			  	/*Nusgolog log=new Nusgolog();
			  
			  	log.setProid(proid);
			  	*/
				
			  	if (updatetype.equals("eventproposal")) {
					flow.setEventproposal(approveValue);
				}else if (updatetype.equals("salesmanagerFirst")) {
					flow.setSalesmanagerFirst(approveValue);
				}
			  	
			  	
			  	if (updatetype.equals("endoftheevent")) {
					flow.setEndoftheevent(approveValue);
				}else if (updatetype.equals("salesmanagerFirst")) {
					flow.setSalesmanagerFirst(approveValue);
				}else if (updatetype.equals("adminFirst")) {
					flow.setAdminFirst(approveValue);
				}else if (updatetype.equals("marcommanagerFirst")) {
					flow.setMarcommanagerFirst(approveValue);
				}else if (updatetype.equals("isemailtogcileaderFirst")) {
					flow.setEmailtogcileaderFirst(1);
				}else if (updatetype.equals("issubzlAfter")) {
					flow.setEndoftheevent(approveValue);
				}else if (updatetype.equals("salesmanagerSecond")) {
					flow.setSalesmanagerSecond(approveValue);
				}else if (updatetype.equals("adminSecond")) {
					flow.setAdminSecond(approveValue);
				}else if (updatetype.equals("marcommanagerSecond")) {
					flow.setMarcommanagerSecond(approveValue);
				}else if (updatetype.equals("gcileaderSecond")) {
					flow.setGcileaderSecond(approveValue);
				}
			  	
			  	flowService.updatebyproid(flow);
			  	
			  	} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 	 
		        return listAll(null,request,model);
		    } 
	
	
	@RequestMapping("EventProposalLoad.do")
	public String EventProposalLoad(HttpServletRequest request, Model model ) {
		
		String proid = request.getParameter("proid");
		Nusgoprojectinfo bean=new Nusgoprojectinfo();
		bean.setProid(proid);
		
		bean=nusgoService.getByProid(bean);
		model.addAttribute("Project", bean);
		return "Factory/NUSGO_EventProposal";  
	}

	
	
	
	@RequestMapping("EventProposal.do")
	public String EventProposal(@RequestParam(value="files") MultipartFile[] files,Nusgoprojectinfo pro, HttpServletRequest request, Model model ){
		
		String importproid = request.getParameter ("importproid");//获取到jsp中的值
	
		
		Result result=new Result();
	
		try {
			//上传文件
			//file.transferTo(targerfile);
			
			
			pro.setProid(pro.getProid());
			nusgoService.update(pro);
			
			NusgoFlow flow=new NusgoFlow();
		  	flow.setProid(pro.getProid());
		  	flow=flowService.getbyproid(flow);
			flow.setEventproposal(1);
			flowService.updatebyproid(flow);
		
			UserInfo currentUser=(UserInfo) request.getSession().getAttribute("user");
			
			//System.out.println(file.getSize());
			
			/*  result= projectService.custAdd(file.getInputStream(), currentUser,pro);
			if (result.getFlag()==1) {
				ISFProjectFlow flow=new ISFProjectFlow();
				flow.setProid(pro.getProid());					
				flow=isfFlowService.getByProID(flow);
				flow.setIssubcustinfo(1);
				flow.setUpdateby(currentUser.getUserId());
				flow.setUpdatetime(new Date());
				
				isfFlowService.update(flow);
				
				result.setMessageStr(  importproid+" 客户信息导入成功！ \\n"+result.getMessageStr());
			}else {
				result.setMessageStr(  importproid+" 客户信息导入失败！ \\n"+importproid+result.getMessageStr());
			}*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setFlag(0);
			result.setMessageStr("网络异常，请联系管理员！\\n" );
		}
		
		model.addAttribute("resultModel",result);
		return listAll(null,request,model);
	}

	
	
	@RequestMapping("TheEndOfEventLoad.do")
	public String TheEndOfEventLoad(HttpServletRequest request, Model model ) {
		
		String proid = request.getParameter("proid");
		Nusgoprojectinfo bean=new Nusgoprojectinfo();
		bean.setProid(proid);
		
		bean=nusgoService.getByProid(bean);
		model.addAttribute("Project", bean);
		return "Factory/NUSGO_EndOfTheEvent";  
	}

	
	
	
	@RequestMapping("TheEndOfEvent.do")
	public String theEndOfevent(@RequestParam(value="files") MultipartFile[] files,Nusgoprojectinfo pro, HttpServletRequest request, Model model ){
		
		String importproid = request.getParameter ("importproid");//获取到jsp中的值
	
		
		Result result=new Result();
	
		try {
			//上传文件
			//file.transferTo(targerfile);
			
			pro.setProid(pro.getProid());
			nusgoService.update(pro);
			
			NusgoFlow flow=new NusgoFlow();
		  	flow.setProid(pro.getProid());
		  	flow=flowService.getbyproid(flow);
			flow.setEndoftheevent(1);
			flowService.updatebyproid(flow);
		
			UserInfo currentUser=(UserInfo) request.getSession().getAttribute("user");
			
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setFlag(0);
			result.setMessageStr("网络异常，请联系管理员！\\n" );
		}
		
		model.addAttribute("resultModel",result);
		return listAll(null,request,model);
	}
	
	
	
	
	

}
