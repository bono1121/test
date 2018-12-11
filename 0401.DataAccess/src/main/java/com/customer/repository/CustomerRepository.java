package com.customer.repository;

import java.util.List;

import com.customer.dto.Customer;

public interface CustomerRepository {

	List<Customer> selectAll();		
	Customer selectByCustomerId(int id);
	Customer selectById(String id);
	//아이디 중복체크시 필요한 메소드
	int selectCntById(String id);
	List<Customer> selectByName(String name);
	
	int insert(Customer customer);		
	int update(Customer customer);
	int delete(int id);
}
