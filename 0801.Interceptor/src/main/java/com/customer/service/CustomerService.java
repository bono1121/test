package com.customer.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.dto.Customer;
import com.customer.dto.LoginResult;
import com.customer.form.Login;
import com.customer.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public LoginResult getLoginResult(Login login, HttpSession session) {
		// 입력한 id를 가진 고객명수 검색 (아이디는 중복이 안되니 무조건 0 아니면 1)
		int custoemrCount = customerRepository.selectCntById(login.getId());

		LoginResult loginResult = new LoginResult();
		
		// 1.id 존재하는 경우
		if (custoemrCount > 0) {
			// 해당하는 id를 가진 고객정보 검색
			Customer selectCustomer = customerRepository.selectById(login.getId());

			// 1)패스워드 일치
			if (login.getPassword().equals(selectCustomer.getPassword())) {

				session.setAttribute("member", selectCustomer);

				loginResult.setResult(true);
				loginResult.setMessage(selectCustomer.getId() + "님 안녕하세요");
				

			// 2)패스워드 불일치
			} else {
				loginResult.setMessage("비밀번호가 일치하지 않습니다.");
			}

			// 2.id 존재하지 않는 경우
		} else {
			loginResult.setMessage("존재하지 않는 아이디 입니다.");
		}
		
		return loginResult;
	}	
}
