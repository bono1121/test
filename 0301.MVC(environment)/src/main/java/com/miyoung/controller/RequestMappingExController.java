package com.miyoung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RequestMappingExController {
		
	
	@RequestMapping(value = "/a", method = RequestMethod.GET)
	public String request01(Model model) {
		
		model.addAttribute("requestMethodName", "RequestMappingExController:request01()" );
		
		return "reqeustResult";
	}
	
	@RequestMapping(value = "/a/b", method = RequestMethod.GET)
	public String request02(Model model) {
		
		model.addAttribute("requestMethodName", "RequestMappingExController:request02()" );
		
		return "reqeustResult";
	}
	
	@RequestMapping(value = "/c", method = RequestMethod.GET)
	public String request03(Model model) {
		
		model.addAttribute("requestMethodName", "RequestMappingExController:request03()" );
		
		return "reqeustResult";
	}
	
	@RequestMapping(value = "/c", method = RequestMethod.POST)
	public String request04(Model model) {
		
		model.addAttribute("requestMethodName", "RequestMappingExController:request04()" );
		
		return "reqeustResult";
	}	
	
}
