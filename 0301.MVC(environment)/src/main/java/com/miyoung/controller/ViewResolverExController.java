package com.miyoung.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miyoung.model.Customer;


@Controller
@RequestMapping("/viewEx/*")
public class ViewResolverExController {
		
	@RequestMapping(value = "/v01", method = RequestMethod.GET)
	public String view01(Model model) {
		
		model.addAttribute("requestMethodName", "ViewResolverExController:view01()" );
		
		return "viewEx/v01";
	}
	
	
	@RequestMapping(value = "/v02", method = RequestMethod.GET)
	public void view02(Model model) {
		
		model.addAttribute("requestMethodName", "ViewResolverExController:view02()" );		
	}
	

	@RequestMapping(value = "/v03", method = RequestMethod.GET)
	public List<Customer> view03(Model model) {
		
		List<Customer> list = new ArrayList<Customer>();
		
		list.add(new Customer("1", "임미영"));
		list.add(new Customer("2", "허세람"));
		
		model.addAttribute("requestMethodName", "ViewResolverExController:view03()" );
		
		return list;
		
	}
}
