package com.customer.mapper;

import org.apache.ibatis.annotations.Select;

import com.customer.dto.Customer;

public interface AnnotationCustomerMapper{

	
	@Select("SELECT * FROM CUSTOMER WHERE ID=#{id}")
	public Customer findById(String id);
	
	/*아이디 중복체크*/
	@Select("SELECT COUNT(*) AS cnt FROM CUSTOMER WHERE ID=#{id}")
	public int findCntById(String id);

} 