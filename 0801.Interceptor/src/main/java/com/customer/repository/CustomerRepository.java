package com.customer.repository;

import com.customer.dto.Customer;

public interface CustomerRepository {

	Customer selectById(String id);
	int selectCntById(String id);

}
