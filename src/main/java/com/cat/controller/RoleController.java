package com.cat.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.bean.RoleInfo;
import com.cat.bean.UserInfo;
import com.cat.service.IRoleInfoService;
import com.cat.utils.Comm;
import com.cat.utils.Page;


/**
 * 
 * <p>Title:RoleController </p>
 * <p>Description:角色管理的控制器</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
@Controller
@RequestMapping("/role/")
public class RoleController extends Page{

	@Autowired
	private IRoleInfoService roleservice;
	
	/**
	 * 查询角色信息
	 * @return
	 */
	@RequestMapping("list.do")
	public String list(RoleInfo info,Model model,HttpServletRequest request){
		
		if(info==null){
			info = new RoleInfo();
		}
		//分页信息
		this.initPage(request);
		//起始记录
		info.setStart(this.getPageNo());
		//每页显示记录数
		info.setLength(PAGE_NUM_BIG);
		model.addAttribute("list", roleservice.list(info));
		//总记录数
		model.addAttribute("total", roleservice.getcount(info));
		
		return "role/role_list";
	}
	
	/**
	 * 加载添加页面
	 * @return
	 */
	@RequestMapping("loadadd.do")
	public String loadAdd(){
	
		return "role/role_add";
	}
	
	/**
	 * 添加角色
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("add.do")
	public String add(RoleInfo info,Model model,HttpServletRequest request,HttpSession session){
		
		try {
			if(info==null){
				info = new RoleInfo();
			}
			info.setRoleMark(Comm.MARK_NO);
			 
			UserInfo currentUserInfo=(UserInfo) session.getAttribute("user");		
			info.setCreateBy(currentUserInfo.getUserId());
			info.setDelFlag(0);
			info.setCreateTime(new Date());
		 
			roleservice.add(info);
		} catch (Exception e) {
			model.addAttribute("errorinfo", "角色添加失败");
			e.printStackTrace();
		}
		info =null;
		return list(info,model,request);
	}
	
	/**
	 * 加载修改页面
	 * @param info
	 * @param model
	 * @return
	 */
	@RequestMapping("loadupdate.do")
	public String loadUpdate(RoleInfo info,Model model){
		
		//查询角色信息
		model.addAttribute("role", roleservice.getInfo(info));
		
		return "role/role_update";
	}
	
	/**
	 * 修改角色信息
	 * @param info
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("update.do")
	public String update(RoleInfo info,Model model,HttpServletRequest request){
		
		try {
			roleservice.update(info);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "角色修改失败");
		}
	
		return list(null,model,request);
	}
	
	/**
	 * 删除角色信息
	 * @param roleid
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	public String delete(Integer[] roleId,Model model,HttpServletRequest request){
		
		try {
			roleservice.delete(roleId);;
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			model.addAttribute("errorinfo", "角色修改失败");
		}
		
		return list(null,model,request);
	}
}
