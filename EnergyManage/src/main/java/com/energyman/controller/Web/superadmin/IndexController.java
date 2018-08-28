package com.energyman.controller.Web.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/superadmin")
public class IndexController {

	@RequestMapping("/index")
	public ModelAndView toSuperAdminindex(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("superadmin/index");
		return modelAndView;
	}
}
