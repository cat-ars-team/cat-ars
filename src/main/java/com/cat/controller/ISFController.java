package com.cat.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cat.bean.AreaRole;
import com.cat.bean.ISFProjectFlow;
import com.cat.bean.LevelInfo;
import com.cat.bean.ProjectCustInfo;
import com.cat.bean.ProjectDetail;
import com.cat.bean.ProjectFile;
import com.cat.bean.ProjectInfo; 
import com.cat.bean.ProjectSummary;
import com.cat.bean.RoleInfo;
import com.cat.bean.Romi;
import com.cat.bean.UserInfo;
import com.cat.service.IAreaRoleService;
import com.cat.service.IISFProjectFlowService;
import com.cat.service.ILevelInfoService;
import com.cat.service.IProcService;
import com.cat.service.IProjectCustInfoService;
import com.cat.service.IProjectDetailService;
import com.cat.service.IProjectFileService;
import com.cat.service.IProjectInfoService;
import com.cat.service.IProjectSummaryService;
import com.cat.service.IRoleInfoService;
import com.cat.service.IRomiService;
import com.cat.utils.DateUtil;
import com.cat.utils.FileUtil;
import com.cat.utils.Page;
import com.cat.utils.Result;




@Controller
@RequestMapping("/ISF/")
public class ISFController extends Page {
	
	
	@Autowired
	private IProjectInfoService projectService;
	
	@Autowired
	private IProjectCustInfoService  proCustService;
	
	@Autowired
	private IRoleInfoService roleService;
	
	@Autowired
	private IISFProjectFlowService isfFlowService;
	
	@Autowired
	private IProcService procService;
	
	@Autowired
	private IAreaRoleService areaService;
	
	@Autowired
	private ILevelInfoService levelService;
	
	@Autowired
	private IRomiService romiService;
	
	@Autowired
	private IProjectSummaryService proSummaryService;
	
	@Autowired
	private IProjectFileService proFileService;
	
	@Autowired
	private IProjectDetailService proDetailService;
	

	
		
		@RequestMapping("list.do")
		public String listAll(ProjectInfo bean,HttpServletRequest request, Model model ) {
			 
				UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
				if(bean == null){
					bean = new ProjectInfo();
				}
							
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
				
				model.addAttribute("list", projectService.list(bean));
				
				model.addAttribute("projectadd",bean);
				// 总记录数
				model.addAttribute("total", projectService.getcount(bean));
											
						
			return "ISF/ISF_list";
		}
		
		
		
		/**
		 * 根据项目名称获取 客户ID
		 * 
		 * @return
		 */
		@RequestMapping("custlist.do")
		public String GetCustByProID(Model model,HttpServletRequest request,ProjectInfo pro) {


			ProjectInfo projectInfo=projectService.getByProID(pro);

			ProjectCustInfo custInfo=new ProjectCustInfo();
			custInfo.setProid(pro.getProid());
			
			// 分页信息
			this.initPage(request);
			// 起始记录
			custInfo.setStart(this.getPageNo());
			// 每页显示记录数
			custInfo.setLength(20);
			
			List<ProjectCustInfo> list = proCustService.GetListByProID(custInfo);
		
		
			
			model.addAttribute("custlist", list);
			model.addAttribute("pro", projectInfo);
 			model.addAttribute("custUploadDate", list.get(0).getCreatetime());
			model.addAttribute("total", proCustService.getcount(custInfo.getProid()));

			return "ISF/ISF_Cust_List";
		}
		
		
		@RequestMapping("provinceChange.do")
		public String GetCityByProvince(ProjectInfo bean,HttpServletRequest request, Model model) {
			
			

			return "ISF/ISF_Cust_List";
		}
		
		
		
		
		
		
		@RequestMapping("add.do")
		public String add(ProjectInfo projectInfo, Model model,  HttpServletRequest request ) {
			Result result=new Result();
			result.setFlag(1);

			StringBuffer warmString=new StringBuffer();
			try {
				
				Integer errocount=0;
				UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
				
				
				if ("".equals(projectInfo.getRoleid()) || 
						"".equals(projectInfo.getProtime())|| 
						"".equals(projectInfo.getLevel())|| 
						"".equals(projectInfo.getCustcount())||
						"".equals(projectInfo.getProcity())||
						"".equals(projectInfo.getProcity())
						) {
					result.setFlag(0);
					warmString.append("请补全关键信息！");
				}
				else if (DateUtil.getDayInRange(DateUtil.StringToDate(projectInfo.getProtime(), "yyyy-MM-dd"), new Date()) <1) {
					result.setFlag(0);
					warmString.append("当天项目不能提交！");
					 
				}  
				else {
					
				
					
				
				// 获取角色名称
				String roleName =currentUserInfo.getRoleName();//"WTC"; 
			 
				String level=projectInfo.getLevel();
				
				Map<String, Object> parms = new HashMap<String, Object>();  
		        parms.put("ProTypeStr", "ISF");  
		        parms.put("RoleNameStr", roleName);  
		        parms.put("ProID", new String());  
		        procService.getproid(parms); 
				
				
				String proID= parms.get("ProID").toString();
				int custcount= Integer.parseInt(projectInfo.getCustcount());
				projectInfo.setProtype("ISF");
				
				// 赋值 角色(代理商)
				if(roleName != null && !"".equals(roleName)){				
					projectInfo.setRoleid(roleName);				
				}
			
				// 赋值 ProID 项目编号
				if(proID != null && !"".equals(proID)){				
					projectInfo.setProid(proID); 			
				}
				
				
				// 级别
					
				if(custcount < 30){				//如果人数小于30人,级别设置为[Tier4],状态设置为[未审核]
					projectInfo.setIsspecilal(1);
					projectInfo.setLevel("4");				
					 
					if(!"4".equals(level)){
						result.setFlag(0);
						warmString.append( "活动人数与级别不匹配 \\n");
					}
					warmString.append("提示：人数少于30人需审批!"   + "\\n");
				}else if(custcount> 500){		//如果人数大于500,直接退出
					projectInfo.setIsspecilal(1);
					projectInfo.setLevel("1");
					 
				 
					if(!"1".equals(level)){
						result.setFlag(0);
						warmString.append( "活动人数与级别不匹配\\n");
						 
					}
					warmString.append("提示：人数大于500人需审批!"   + "\\n");
				}else{
					//根据客户人数获取级别信息
					LevelInfo levelInfo = levelService.GetLevelByCustNum(custcount);
					String levelid = levelInfo.getLevelId().trim();
					
					projectInfo.setIsspecilal(0);
					projectInfo.setLevel(levelInfo.getLevelId());
					//获取到用户Excel级别与标准级别对比,如果对应,则插入数据库,否则,不插入,并给予提示
					if(!levelid.equals(level)){
						result.setFlag(0);
						warmString.append( "活动人数与级别不匹配 ! \\n");		
					}
				}
					
				
					 
						//客户人数
						
						
						//项目日期
						
						//省份
						
						//城市
						
						// 是否包含政府人员
						
				
				if (result.getFlag()==1) {
				
						projectInfo.setCreatetime(new Date());
						projectInfo.setCreateby(currentUserInfo.getUserId().toString());
						
						ISFProjectFlow flow=new ISFProjectFlow();
						flow.setProid(proID);
						flow.setSpecialstatus(1);
						if (custcount<30 || custcount>500) {
							flow.setSpecialstatus(0);
						}
						
						flow.setIssubcustinfo(0);
						flow.setIssubjbxx(0);
						flow.setIssubbxzl(0);
						flow.setIssubreceipt(0);
						flow.setBxstatus(0);
						
						flow.setCreateby(currentUserInfo.getUserId());
						flow.setCreatetime(new Date());
						
						isfFlowService.add(flow);
						projectService.add(projectInfo);
						warmString.append(proID);
				} 
			}
								
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
		
		
		//批量导入项目
		@RequestMapping("batchAdd.do")
		public String ImportProject(@RequestParam(value="file",required=false)MultipartFile file, ProjectInfo proInfo,HttpServletRequest request, Model model,HttpSession session){
				
			try {
				//上传文件
				//file.transferTo(targerfile);
				UserInfo currentUser=(UserInfo) request.getSession().getAttribute("user");
				System.out.println(file.getSize());
				Result result= projectService.batchAdd(file.getInputStream(), currentUser);
				if (result.getFlag()==1) {
					model.addAttribute("errorinfo", "导入成功！ \\n"+result.getMessageStr());
				}else {
					model.addAttribute("errorinfo", "导入失败！ \\n"+result.getMessageStr());
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("errorinfo", "导入失败！\\n");
			}
			return listAll(null,request,model);
		}
		
	 
		
		@RequestMapping("importCust.do")
		public String ImportCust(@RequestParam(value="file",required=false)MultipartFile file, HttpServletRequest request, Model model ){
			String importproid = request.getParameter ("importproid");//获取到jsp中的值
			//上传地址
			/*String path = request.getSession().getServletContext().getRealPath("\\upload\\");
			System.out.println(path);
			System.out.println(file.getSize());
				
			String filename = file.getOriginalFilename();
			
			File targerfile = new File(path,new Date()+filename);*/
			Result result=new Result();
				
			try {
				//上传文件
				//file.transferTo(targerfile);
				
				ProjectInfo pro=new ProjectInfo();
				pro.setProid(importproid);
				pro=projectService.getByProID(pro);
			
				UserInfo currentUser=(UserInfo) request.getSession().getAttribute("user");
				System.out.println(file.getSize());
				  result= projectService.custAdd(file.getInputStream(), currentUser,pro);
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
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setFlag(0);
				result.setMessageStr("网络异常，请联系管理员！\\n" );
			}
			
			model.addAttribute("resultModel",result);
			return listAll(null,request,model);
		}
		
		
		
		@RequestMapping("delete.do")
		public String deleteByProID(ProjectInfo bean,HttpServletRequest request, Model model ) {
			Result result=new Result();
			result.setFlag(1);
			try {
				projectService.delete(bean);
				
				ISFProjectFlow flow=new ISFProjectFlow();
				flow.setProid(bean.getProid());
				isfFlowService.delete(flow);
				result.setMessageStr("操作成功！");
			} catch (Exception e) {
				e.printStackTrace();
				result.setFlag(0);
				result.setMessageStr("网络异常,请联系管理员！");
			}
			
			model.addAttribute("resultModel",result);
			return listAll(null,request,model); 
		}
		
		
		@RequestMapping("specialApprove.do")
		public String specialApprove(ProjectInfo bean,HttpServletRequest request, Model model ) {
			Result result=new Result();
			result.setFlag(1);
			try {
				UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
							
				ISFProjectFlow flow=new ISFProjectFlow();
				flow.setProid(bean.getProid());
				flow.setSpecialstatus(1);
				isfFlowService.update(flow);
				result.setMessageStr( "审批成功！\\n");
				
			} catch (Exception e) {
				e.printStackTrace();
				result.setFlag(0);
				result.setMessageStr( "网络异常，请联系管理员！");
			}
			
			model.addAttribute("resultModel",result);
			return listAll(null,request,model); 
		}
		
		@RequestMapping("jbxxload.do")
		public String jbxxload(ProjectInfo bean,HttpServletRequest request, Model model ) {
			 
			bean=projectService.getByProID(bean);
				
			AreaRole area=new AreaRole();
			area.setRolename(bean.getRoleid());
			area.setAreaid(bean.getProprovince());		
			bean.setProprovince( areaService.getprovinceName(area).getAreaname());
			
			area.setAreaid(bean.getProcity());
			bean.setProcity(areaService.getCityName(area).getAreaname());
			
			
			
			LevelInfo levelInfo=new LevelInfo();
			levelInfo.setLevelId(bean.getLevel());
			levelInfo=levelService.getbylevel(levelInfo);
						
			model.addAttribute("Project", bean);
			model.addAttribute("levelInfo",levelInfo);
			
			return "ISF/ISF_jbxx";  
		}
		
		
		
		@RequestMapping("jbxx.do")
		public String jbxx(ProjectInfo bean,ProjectDetail proDetail,ProjectSummary proSum,@RequestParam(value="files") MultipartFile[] files,HttpServletRequest request, Model model ) {
			String err="";
			Result result=new Result();
			result.setFlag(1);
			
			
			
			UserInfo currentUser=(UserInfo) request.getSession().getAttribute("user");
			
			ProjectInfo	currentproject= new ProjectInfo();
			currentproject.setProid(proDetail.getProId());
			currentproject=projectService.getByProID(currentproject);
			
			
			
			//步骤二：项目详情
			proSummaryService.delete(proSum);
			//projectSummary
			proSum.setProType(currentproject.getProtype());
			proSum.setRolename(currentproject.getRoleid());
			
			RoleInfo roleInfo=new RoleInfo();
			roleInfo.setRoleId(currentUser.getRoleId());
			roleInfo=roleService.getInfo(roleInfo);
			
			double totalMoney=Double.parseDouble(proSum.getTotalCust());
			double  bxRate=(double)roleInfo.getRolerate();
			
			proSum.setCreatetime(new Date());
			proSum.setCreateby(currentUser.getUserId().toString());
			
			double currentBX=totalMoney*bxRate;
			
			//已经用掉的
			double yyAmount= (double) proSummaryService.gettotalbx(proSum);
			if (roleInfo.getAmount()<(yyAmount+currentBX)) {
				result.setFlag(0);
				result.setMessageStr("预算不足！您的预算额度剩余："+(roleInfo.getAmount()-yyAmount)+"元");
			}else {
				
				/*此处涉及 
				 * projectsummary
				 * projectfile
				 * projectdetail
				 * isfproject_flow
				 * */
				proSum.setAppReim(Double.toString(currentBX));
				proSummaryService.add(proSum);
				
				//删除原始数据
				ProjectFile projectF=new ProjectFile();
				projectF.setProId(proDetail.getProId());
				proFileService.delete(projectF);
				
				String dir = request.getSession().getServletContext().getRealPath("/fileFolder/bxzl") ;
				String proid=proDetail.getProId();
				
				//步骤一：活动图片  发票PDF 的保存
				if(files!=null && files.length>0){ 
				    //循环获取file数组中得文件 
				    for(int i = 0;i<files.length;i++){ 
				    ProjectFile proFileToSave=new ProjectFile();
				    MultipartFile file = files[i]; 
				      
				    //保存文件
				    String fileRename=proid+DateUtil.toString(new Date(), "yyyyMMddHHmmssSSS")+FileUtil.getExtention(file.getOriginalFilename());
				    String filePath = dir + "/" + fileRename;
				    File desFile = new File(filePath);  
				    if(!desFile.getParentFile().exists()){  
				          desFile.mkdirs();  
				      }  
				    try {
				    	  file.transferTo(desFile);  
					} catch (Exception e) {
						// TODO: handle exception
						err=e.getMessage();
					}
				     
				    
				    if("JPG".equals( FileUtil.getExtention(file.getOriginalFilename()).toUpperCase())){
				    	  	proFileToSave.setFieldType("bxzltp");	//文件类型[图片]
					}else{
							proFileToSave.setFieldType("bxzlfp");	//文件类型[发票]
					}
				      
				      	proFileToSave.setFieldId(proid + proFileToSave.getFieldType() + DateUtil.toString(new Date(), "yyyyMMddHHmmssSSS"));
				      	proFileToSave.setFieldName(fileRename);
				      	proFileToSave.setFieldArc("/fileFolder/bxzl/" + fileRename);	//存储位置
				      	proFileToSave.setUploadTime(new Date());
				      	proFileToSave.setProId(proid);
				      	proFileToSave.setCreateby(currentUser.getUserId());
				      	proFileToSave.setCreatetime(new Date());
				      
				      	proFileService.add(proFileToSave);
				    } 
				    
				  } 
				
				//步骤三：项目信息汇总的 保存
				//projectSummary add
				proDetailService.delete(proDetail);
				proDetail.setRolename(currentproject.getRoleid());
				proDetail.setCreateby(currentUser.getUserId());
				proDetail.setCreatetime(new Date());
				proDetailService.add(proDetail);
				try {
				//步骤四 项目工作流 进度的修改
				// 修改 projectflow
				ISFProjectFlow flow=new ISFProjectFlow();
				flow.setProid(proDetail.getProId());
				
					flow=isfFlowService.getByProID(flow);
				
				flow.setIssubjbxx(1);
				flow.setUpdateby(currentUser.getUserId());
				flow.setUpdatetime(new Date());
				isfFlowService.update(flow);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			model.addAttribute("jbxxResult", result);
			if (result.getFlag()==0) {
				  return jbxxload(bean,request,model); 
			}else {
				model.addAttribute("Project", currentproject);
				return "ISF/ISF_romi"; 
			}
			
			
			 
		}
		
		
		@RequestMapping("romiload.do")
		public String romi(ProjectInfo bean,HttpServletRequest request, Model model ) {

			bean=projectService.getByProID(bean);
			LevelInfo levelInfo=new LevelInfo();
			levelInfo.setLevelId(bean.getLevel());
			levelInfo=levelService.getbylevel(levelInfo);
						
			model.addAttribute("Project", bean);
			model.addAttribute("levelInfo",levelInfo);
			
			return "ISF/ISF_romi";  
			
			 
		}
		
		
		@RequestMapping("romiadd.do")
		public String romiadd(Romi romiEntity,ProjectInfo pro,HttpServletRequest request, Model model ) {
			Result result=new Result();
			result.setFlag(1);
			try {
				ProjectSummary pros=new ProjectSummary();
				if (romiEntity!=null) {
					pros.setProId(romiEntity.getProId());	
				}else {
					pros.setProId(pro.getProid());	
				}
				pros=proSummaryService.getbyproid(pros);
		
			
		
					
				romiService.delete(romiEntity);
				romiService.add(romiEntity);	
				
				pro=new ProjectInfo();
				pro.setProid(romiEntity.getProId());
				pro=projectService.getByProID(pro);
				
				
				//步骤四 项目工作流 进度的修改
				// 修改 projectflow
				ISFProjectFlow flow1=new ISFProjectFlow();
				flow1.setProid(romiEntity.getProId());
				flow1=isfFlowService.getByProID(flow1);
				flow1.setIssubbxzl(1);
				
				
				String err="";
				
				if (Integer.parseInt(romiEntity.getRegisCust()) != Integer.parseInt(pro.getCustcount())) {
					err+="客户人数不匹配！\\n"+romiEntity.getRegisCust()+pro.getCustcount();
				}
				else {
					
					int issucess=isfFlowService.update(flow1);
					result.setMessageStr("添加成功！\\n可报销"+pros.getAppReim()+"元");
				}
				
				
				/*model.addAttribute("Project", pro);
				model.addAttribute("romi", romiEntity);*/
			/*	model.addAttribute("err", err+"ROMI.proid:"+romiEntity.getProId()+";romi.currCust"+romiEntity.getCurrCust()+";dodCustnum"+romiEntity.getDodCustnum());*/
				model.addAttribute("err", err);
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				result.setMessageStr("网络异常，请联系管理员！"+e.getMessage());
			}
			
			model.addAttribute("romiResult", result);
			
			return listAll(null,request,model);
		}
		
		

		@RequestMapping("approve.do")
		public String approvebx( ProjectInfo pro,HttpServletRequest request, Model model ) {
			UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			
			Result result=new Result();
			result.setFlag(1);
			
			try {
				if (pro != null && !"".equals(pro.getProid()) &&  pro.getBxstatus()!=0	) {
					ProjectInfo toaddPro=new ProjectInfo();
					toaddPro.setUpdateby(currentUserInfo.getUserId().toString());
					toaddPro.setUpdatetime(new Date());
					toaddPro.setProid(pro.getProid());
					toaddPro.setRemark(pro.getRemark());
					projectService.update(toaddPro);
					
					// 修改 projectflow
					ISFProjectFlow flow1=new ISFProjectFlow();
					flow1.setProid(pro.getProid());
					flow1=isfFlowService.getByProID(flow1);
					flow1.setBxstatus(pro.getBxstatus());
					isfFlowService.update(flow1);
					
					result.setMessageStr("flowProID:"+flow1.getProid()+";flowBxStatus:"+flow1.getBxstatus()+";beizhu:"+toaddPro.getRemark());
				}
				else {
					result.setMessageStr("请将信息补充完整！");
				}
	 
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				result.setMessageStr("网络异常，请联系管理员！"+e.getMessage());
			}
			
			model.addAttribute("approveResult", result);
			
			return listAll(null,request,model);
		}
		
		
		
		
		//下载客户模板
		@RequestMapping("downtemplateCust.do")
		public void downCustTem(HttpServletRequest request, Model model,HttpServletResponse response){
			String path = request.getSession().getServletContext().getRealPath("\\Download\\");
			String fileName = "ISF_客户名单导入模板.xls";
	        try {  
	        	 
	            // 上传位置  
	            String fileSaveRootPath = path;  
	            // 得到要下载的文件  
	           // File file = new File(fileSaveRootPath + "\\" + fileName);   
	            // 设置响应头，控制浏览器下载该文件  
	            response.setHeader("content-disposition", "attachment;filename=" +URLEncoder.encode( fileName, "UTF-8"));
	            // 读取要下载的文件，保存到文件输入流  
	            FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);  
	            
	            System.out.print (fileSaveRootPath + "\\" + fileName);
	            // 创建输出流  
	            OutputStream out = response.getOutputStream();  
	            // 创建缓冲区  
	            byte buffer[] = new byte[1024];  
	            int len = 0;  
	            // 循环将输入流中的内容读取到缓冲区当中  
	            while ((len = in.read(buffer)) > 0) {  
	                // 输出缓冲区的内容到浏览器，实现文件下载  
	                out.write(buffer, 0, len);  
	            }  
	            // 关闭文件输入流  
	            in.close();  
	            // 关闭输出流  
	            out.close();  
	            //下载完成，删除文件
	           // file.delete();
	        } catch (Exception e) {  

	        }  
	   
	        
	    }
		
		//下载批量上传项目模板
		@RequestMapping("downtemplatePro.do")
		public void downProTem(HttpServletRequest request, Model model,HttpServletResponse response){
			String path = request.getSession().getServletContext().getRealPath("\\Download\\");
			String fileName="ISF_项目批量导入模板.xls"; 
	        
	        try {  
	            // 上传位置  
	            String fileSaveRootPath = path;  
	            // 得到要下载的文件  
	           // File file = new File(fileSaveRootPath + "\\" + fileName);   
	            // 设置响应头，控制浏览器下载该文件  
	            response.setHeader("content-disposition", "attachment;filename=" +URLEncoder.encode( fileName, "UTF-8"));
	            // 读取要下载的文件，保存到文件输入流  
	            FileInputStream in = new FileInputStream(fileSaveRootPath + "\\" + fileName);  
	            
	            System.out.print (fileSaveRootPath + "\\" + fileName);
	            // 创建输出流  
	            OutputStream out = response.getOutputStream();  
	            // 创建缓冲区  
	            byte buffer[] = new byte[1024];  
	            int len = 0;  
	            // 循环将输入流中的内容读取到缓冲区当中  
	            while ((len = in.read(buffer)) > 0) {  
	                // 输出缓冲区的内容到浏览器，实现文件下载  
	                out.write(buffer, 0, len);  
	            }  
	            // 关闭文件输入流  
	            in.close();  
	            // 关闭输出流  
	            out.close();  
	            //下载完成，删除文件
	           // file.delete();
	        } catch (Exception e) {  

	        }  
	   
	        
	    }
		
		
		//省市关联查询
		@RequestMapping("search.do")  
		private ModelAndView search(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException {  
			 UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			 
			 response.setCharacterEncoding("UTF-8");  
		        String flag = request.getParameter("flag");  
		        
		        List<AreaRole> list = null;  
		        
		        JSONArray jsonarray = null;  
		        AreaRole areaRole=new AreaRole();  
		        areaRole.setRolename(currentUserInfo.getRoleName());
		        if (flag.equals("getOne")) { 
		        	
		            list = areaService.provincelist(areaRole);  
		        } else {  
		            //String strParId = request.getParameter("parId");  
		           // list = strParId.equals("")?null:testService.findTwoAndThree(Integer.parseInt(request.getParameter("parId")));
		            areaRole.setParentid( request.getParameter("parId"));
		            list = areaService.citylist(areaRole);  
		        }  
		        jsonarray = JSONArray.fromObject(list);  
		        PrintWriter out = response.getWriter();  
		        out.print(jsonarray.toString());  
		        out.flush();  
		        out.close();  
		        //model.addObject("list", list);  
		        model.setViewName("ISF/ISF_list");  
		        return model;  
		    }  
		 
		 
		 @RequestMapping("getallroles.do")  
		private ModelAndView getallroles(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException {  
			 UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
			 
			 	response.setCharacterEncoding("UTF-8");  
		      //  String flag = request.getParameter("flag");  
			 
		        JSONArray jsonarray = null;  
		         List<RoleInfo>   list = roleService.getall();  
		         
		        jsonarray = JSONArray.fromObject(list);  
		        PrintWriter out = response.getWriter();  
		        out.print(jsonarray.toString());  
		        out.flush();  
		        out.close();  
		        //model.addObject("list", list);  
		        model.setViewName("ISF/ISF_list");  
		        return model;  
		    }  
		
		 
		 @RequestMapping("subreceipt.do")  
			private String subreceipt(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {  
				 UserInfo currentUserInfo=(UserInfo) request.getSession().getAttribute("user");
				 
				  	String proid = request.getParameter("subReceiptProid");  
			      //步骤四 项目工作流 进度的修改
					// 修改 projectflow
				  	try {
					ISFProjectFlow flow1=new ISFProjectFlow();
					flow1.setProid( proid);
					
						flow1=isfFlowService.getByProID(flow1);
					
					flow1.setUpdateby(currentUserInfo.getUserId());
					flow1.setUpdatetime(new Date());
					flow1.setIssubreceipt(1);
					isfFlowService.update(flow1);
				  	} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 	 
			        return listAll(null,request,model);
			    }  
		
	
}
