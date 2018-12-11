package com.customer.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.dto.Customer;
import com.customer.mapper.AnnotationCustomerMapper;



@Repository("MybatisCustomerRepository")
public class MybatisCustomerRepository implements CustomerRepository {
	
	//일반 Mapper 사용시
	//@Autowired
	//private CustomerMapper mapper;
	
	//@ Mapper 사용시
	@Autowired
	private AnnotationCustomerMapper mapper;
	
	@Override
	public Customer selectById(String id) {

		return mapper.findById(id);
	}	

	@Override
	public int selectCntById(String id) {
	
		return mapper.findCntById(id);		
	}	
	
}