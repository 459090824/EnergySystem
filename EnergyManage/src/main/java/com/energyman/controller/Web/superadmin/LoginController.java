package com.energyman.controller.Web.superadmin;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.energyman.bean.Admin;
import com.energyman.service.IAdminService;

@Controller
@RequestMapping("/superadmin")
public class LoginController {
	
	@Resource
	private IAdminService iAdminService;
	
	/**
	 * 显示登录页面
	 * @return
	 */	
	@RequestMapping(value="/signin",method=RequestMethod.GET)
	public ModelAndView sigin(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/signin");
		return modelAndView;		
	} 
	
	/**
	 * 进行登录
	 * @return
	 */
	@RequestMapping(value="/toLogin",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, HttpSession httpSession){
		Map <String,Object> res=new HashMap<String,Object>();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(username+" "+password);
		Admin admin=iAdminService.findAdmin(username, password);
		if(admin != null){
			res.put("success", 1);
			httpSession.setAttribute("user",admin);
		}else{
			res.put("success", 0);
		}
		
		return res;
	}
	
	/**
	 * 进行注销
	 * @param request
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="/toLoginOut",method=RequestMethod.GET)
	public @ResponseBody ModelAndView toLoginOut(HttpServletRequest request, HttpSession httpSession){
		httpSession.removeAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("superadmin/signin");
		return modelAndView;	
	}
 }
