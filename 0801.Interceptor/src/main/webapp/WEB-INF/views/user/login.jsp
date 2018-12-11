<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<script src="resources/js/login.js"></script>

</head>
<body>
	<div class="container">
		<h2>로그인</h2>
		
		<form id="login"><!--ajax 처리  -->
		<!-- <form action="login" method="post"> --> <!-- 일반처리 -->
			<div class="form-group">
				<input type="text" class="form-control input-lg" id="id" name="id"
					placeholder="아이디를 입력하세요.">
			</div>
			<div class="form-group">
				<input type="password" class="form-control input-lg" id="pwd" name="password"
					placeholder="비밀번호를 입력하세요." >
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg">로그인</button>
			</div>
		</form>			
	</div>
	
	<!-- 로그인 실패시 메세지 출력 -->			
	<c:if test="${resultMessage!=null}">
		<script type="text/javascript">
			alert("${resultMessage}");
		</script>
	</c:if>	
</body>
</html>
