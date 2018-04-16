package com.cat.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.bean.MenuInfo;
import com.cat.bean.RoleInfo;
import com.cat.bean.RoleMenuInfo;
import com.cat.service.IAnthorityService;
import com.cat.service.IMenuInfoService;
import com.cat.service.IRoleInfoService;
import com.cat.utils.Page;

/**
 * 
 * <p>Title:AnthorityController </p>
 * <p>Description:权限管理的控制器</p>
 * <p>Company:xxxx</p>
 * @author 老牛
 * @version 1.0
 */
@Controller
@RequestMapping("/anthority/")
public class AnthorityController extends Page{

	/**
	 * 角色管理的业务逻辑接口
	 */
	@Autowired
	private IRoleInfoService roleservice;
	
	/**
	 * 菜单管理的业务逻辑接口
	 */
	@Autowired
	private IMenuInfoService menuservice;
	
	/**
	 * 权限管理的业务逻辑接口
	 */
	@Autowired
	private IAnthorityService anservice;
	
	/**
	 * 查询角色
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
		
		return "anthority/anthority_list";
	}
	
	/**
	 * 权限变更
	 * @return
	 */
	@RequestMapping("loadchange.do")
	public String loadchange(RoleInfo info,Model model){
		
		//角色信息
		RoleInfo role = roleservice.getInfo(info);
		model.addAttribute("role", role);
		
		//查询所有的菜单信息
		List<MenuInfo> list = menuservice.list(null);
		model.addAttribute("list", list);
		
		//查询已有权限
		RoleMenuInfo rminfo = new RoleMenuInfo();
		rminfo.setRoleId(info.getRoleId());
		List<RoleMenuInfo> rmlist = anservice.list(rminfo);
		model.addAttribute("rmlist", rmlist);
		
		return "anthority/anthority_change";
		
	}
	
	/**
	 * 权限变更
	 * @return
	 */
	@RequestMapping("change.do")
	public String change(Integer roleId,Integer[] menuIds,Model model,HttpServletRequest request){
		
	
		try {
			anservice.add(roleId, menuIds);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errorinfo", "变更失败");
		}
		
		
		return list(null,model,request);
	}
	
}
