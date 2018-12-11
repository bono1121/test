package com.customer.mapper;

import com.customer.dto.Customer;


public interface CustomerMapper{
	
	Customer findById(String id);
	//아이디 중복체크시 필요한 메소드
	int findCntById(String id);


}
