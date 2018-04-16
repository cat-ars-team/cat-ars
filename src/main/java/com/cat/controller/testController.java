package com.cat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cat.bean.Test;
import com.cat.service.ITestService;

@Controller
@RequestMapping("/test/")
public class testController {
	
	@Autowired
	private ITestService testService;
	
	@RequestMapping("/testbg/")
	public String testbg() {
		return "ISF/testbg";
	}
	
	 
	@RequestMapping("sstest.do")
	public String sstest() {
		return "ISF/SSTest";
	}
	
	/** 
     * 三级联动 
     *  
     * @throws IOException 
     */  
    @RequestMapping("search.do")  
    private ModelAndView search(HttpServletRequest request, HttpServletResponse response, ModelAndView model) throws IOException {  
        response.setCharacterEncoding("UTF-8");  
        String flag = request.getParameter("flag");  
        List<Test> list = null;  
        JSONArray jsonarray = null;  
          
        if (flag.equals("getOne")) {  
            list = testService.findOne();  
        } else {  
            String strParId = request.getParameter("parId");  
            list = strParId.equals("")?null:testService.findTwoAndThree(Integer.parseInt(request.getParameter("parId")));  
        }  
        jsonarray = JSONArray.fromObject(list);  
        PrintWriter out = response.getWriter();  
        out.print(jsonarray.toString());  
        out.flush();  
        out.close();  
        model.addObject("list", list);  
        model.setViewName("ISF/SSTest");  
        return model;  
    }  
  

	
	
}
