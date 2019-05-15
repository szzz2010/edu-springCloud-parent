package com.haohao.asset.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorPageController {

	
	@RequestMapping("/500")
	public String error_500(){
		return "error/error_500";
	}
	
	@RequestMapping("/403")
	public String error_403(){
		return "error/error_403";
	}
	
	@RequestMapping("/404")
	public String error_404(){
		return "error/error_404";
	}
	@RequestMapping("/401")
	public String error_401(){
		return "redirect:/login/init";
	}
}
