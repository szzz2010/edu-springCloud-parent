package com.haohao.asset.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	/**
	 * @author:abner
	 */
	@RequestMapping({"/home/init","/"})
	public String init() {
		return "home/init";
	}

	@RequestMapping({"/home/newhome"})
	public String newHome() {
		return "home/newHome";
	}
}
