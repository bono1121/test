package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.customer.dto.Customer;
import com.customer.search.condition.CustomerCondition;
import com.customer.service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "/customer_save", method = RequestMethod.GET)
	public String getForm(@ModelAttribute("customer") Customer customer) {


		return "insert";
	}

	@RequestMapping(value = "/customer_save", method = RequestMethod.POST)
	public String add(@ModelAttribute("customer") Customer customer, Model model) {
		System.out.println(customer.toString());
		
		String result = customerService.saveCustomer(customer);

		model.addAttribute("message", result);

		//return "result";
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ModelAttribute("customers")
	public List<Customer> list() {

		List<Customer> customers = customerService.getCustomers();

		return customers;
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ModelAttribute
	public Customer detail(@RequestParam String customerid) {

		Customer customer = customerService.getCustomerByCustomerId(Integer.parseInt(customerid));
		return customer;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateCustomer(@ModelAttribute Customer customer, Model model) {
		System.out.println("update " + customer.toString());

		String result = customerService.updateCustomer(customer);

		model.addAttribute("message", result);
		
		//return "result";
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteCustomer(@RequestParam int customerid, Model model) {

		String result = customerService.deleteCustomer(customerid);

		model.addAttribute("message", result);
		
		//return "result";
		return "redirect:/customer/list";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@ModelAttribute("customerCondition") CustomerCondition customerCondition, Model model) {

		if (customerCondition.getName() == null)
			return null;

		List<Customer> customers = customerService.getCustomersByName(customerCondition.getName());
		model.addAttribute("customers", customers);

		return "list";
	}

	@RequestMapping(value = "/idcheck", method = RequestMethod.GET)
	public String idCheck(@RequestParam String id, Model model) {

		int resultCount = customerService.getIdCheckResult(id);

		boolean result = true;
		
		if (resultCount > 0) {
			// 아이디가 존재하는 경우 사용 못하게 false
			result = false;
		}
		
		model.addAttribute("useTF", result);
		
		return "idcheck";
	}
}