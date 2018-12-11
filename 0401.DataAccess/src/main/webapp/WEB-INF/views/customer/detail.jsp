<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>다락방서점</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
	
<!-- 우편번호찾기 : http://postcode.map.daum.net/guide -->
<!-- 다음 우편번호 서비스 open api 사용 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="resources/js/daumPostcode.js"></script>
	
</head>
<body>
	<div class="container">
		<h2>회원정보</h2>
		<form action="update" method="post">
			<input type="text" name="customerid" value="${customer.customerid}" hidden="hidden" />
			
			<div class="form-group">
				<input type="text" class="form-control input-lg" name="id"
					value="${customer.id}" placeholder="아이디를 입력하세요."  disabled="disabled" >
			</div>
								
			<div class="form-group">
				<input type="password" class="form-control input-lg" name="password" value="${customer.password }"
					placeholder="비밀번호를 입력하세요.">
			</div>
			
			<div class="form-group">
				<input type="password" class="form-control input-lg" name="repassword" value="${customer.password }"
					placeholder="확인 비밀번호를 입력하세요.">
			</div>

			<div class="form-group">
				<input type="text" class="form-control input-lg" name="name"
					value="${customer.name }" placeholder="이름을 입력하세요.">
			</div>


			<!-- 다음 우편번호 서비스 open api 사용 -->
			<div class="form-group form-inline">
				<div class="form-group">
					<input type="text" class="form-control input-lg"
						id="sample6_postcode" name="postcode"
						value="${customer.postcode }" placeholder="우편번호">
				</div>
				<div class="form-group">
					<input type="button" class="btn btn-primary btn-lg"
						onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
				</div>
			</div>

			<div class="form-group">
				<input type="text" class="form-control input-lg"
					id="sample6_address" name="address" value="${customer.address }"
					placeholder="주소">
			</div>
			<div class="form-group">
				<input type="text" class="form-control input-lg"
					id="sample6_address2" name="address2" value="${customer.address2 }"
					placeholder="상세주소를 입력하세요">
			</div>

			<div class="form-group">
				<input type="tel" class="form-control input-lg" name="phone"
					value="${customer.phone }" placeholder="폰번호 입력하세요.">
			</div>

			<div class="form-group">
				<input type="email" class="form-control input-lg" name="email"
					value="${customer.email }" placeholder="이메일을 입력하세요.">
			</div>
			<div class="form-group">
				<button type="submit" name="update" value="update" class="btn btn-primary btn-lg">수정</button>
			</div>
		</form>
	</div>
</body>
</html>