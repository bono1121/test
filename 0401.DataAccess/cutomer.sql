create table customer(
	customerid number primary key, 
	id varchar2(50), 
	name varchar2(50), 
	password varchar2(50), 
	postcode varchar2(50),
	address varchar2(100), 
	address2 varchar2(500), 
	phone varchar2(100), 
	email varchar2(100)s
);

create sequence seqCustomer;

--git 테스트1