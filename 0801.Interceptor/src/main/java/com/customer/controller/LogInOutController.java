package com.customer.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.customer.dto.LoginResult;
import com.customer.form.Login;
import com.customer.service.CustomerService;


@Controller
public class LogInOutController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getForm(@ModelAttribute("login") Login login) {

		return "login";
	}

	//1.일반로그인처리
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login") Login login, HttpSession session, Model model) {
		
		LoginResult loginResult = customerService.getLoginResult(login, session);

		model.addAttribute("message", loginResult.getMessage());

		return "result";
	}
	//2.ajax로그인처리
	@RequestMapping(value = "/login_ajax", method = RequestMethod.POST)
	public String login_ajax(@ModelAttribute("login") Login login, HttpSession session, Model model) {
		
		LoginResult loginResult = customerService.getLoginResult(login, session);
		
		model.addAttribute("loginResult", loginResult);
		
		return "loginResult";
	}

	//3.ajax+rest : loginResult.jsp가 없어도 실행
	@RequestMapping(value = "/login_rest", method = RequestMethod.POST, produces="application/xml")
	public @ResponseBody LoginResult login_rest(@ModelAttribute("login") Login login, HttpSession session, Model model) {
		
		LoginResult loginResult = customerService.getLoginResult(login, session);
					
		return loginResult;
	}	
	
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {

		session.removeAttribute("member");

		return "redirect:/";
	}


	@RequestMapping(value = "/private", method = RequestMethod.GET)
	public String goPrivate() {
		return "private";
	}


	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public String goPublic() {
		return "public";
	}
		
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String goResult() {
		return "result";
	}
}
