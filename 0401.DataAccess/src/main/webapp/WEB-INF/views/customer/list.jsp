<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<title>다락방서점</title>

<script type="text/javascript">
	$(document).ready(function() {
		$("tbody tr").click(function() {
			$('.selected').removeClass('selected');
			$(this).addClass("selected");

			var customerid = $('#customerid', this).html();

			location.href = "detail?customerid=" + customerid;//+ "&div=" + 1;//div=1는 managerview
		});

	});
</script>

</head>
<body>
	<br />
	<div class="container">
		<div class="form-group">
			<!-- 고객 검색 -->
			<form action="search" class="navbar-form">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search"
						name="name">
					<div class="input-group-btn">
						<button class="btn btn-default" type="submit">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</div>
				</div>
			</form>

		</div>
		<br />
		<h2>고객목록</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>주소</th>
					<th>연락처</th>
					<th>이메일</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td id="customerid">${customer.customerid }</td>
						<td>${customer.id }</td>
						<td>${customer.name }</td>
						<td>${customer.address}${customer.address2}</td>
						<td>${customer.phone}</td>
						<td>${customer.email}</td>
						<td><a href="delete?customerid=${customer.customerid}"><button
									class="btn btn-primary btn-sm">삭제</button></a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>		
			
		<div class="form-group">
			<a href="customer_save">회원가입</a>
		</div>
		<br />
		
	</div>
</html>