package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.Customer;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public Customer getCustomerByCustomerId(int customerid) {
		Customer customer = customerRepository.selectByCustomerId(customerid);
		return customer;
	}
	
	public Customer getCustomerById(String id) {
		Customer customer = customerRepository.selectById(id);
		return customer;
	}

	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.selectAll();
		return customers;
	}

	public List<Customer> getCustomersByName(String name) {
		
		List<Customer> customers = customerRepository.selectByName(name);

		return customers;
	}

	public String saveCustomer(Customer customer) {
		int count = customerRepository.insert(customer);
		
		String result = "가입실패";
		
		if (count > 0) {
			result = "가입성공";
		} 
		
		return result;
	}

	public String updateCustomer(Customer customer) {
			
		int count = customerRepository.update(customer);
		
		String result = "수정실패";
		
		if (count > 0) {
			result = "수정성공";
		} 
		
		return result;
	}

	public String deleteCustomer(int id) {
		
		int count = customerRepository.delete(id);
		
		String result = "삭제실패";
		
		if (count > 0) {
			result = "삭제성공";
		} 
		
		return result;
	}
	
	public int getIdCheckResult(String id){
		
		return customerRepository.selectCntById(id);		
	}
}
