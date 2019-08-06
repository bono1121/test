<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>메모 등록 폼</title>
		
		<!-- bootstrap 준비완료 -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>		
	
	</head>
	<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			
			<div class="col-sm-6"><br />
			
			<h3 class="jumbotron text-center bg-info text-light" style="margin-bottom:0">메모 저장</h3><br />
			<form method="post" action="memo_save">
				<input type="text"  class="form-control" placeholder="이름을 입력하세요." name="name"/><br />
				<input type="text" class="form-control" placeholder="나이를 입력하세요." name="age"/><br />
				<input type="submit" class="btn btn-primary form-control" value="메모 등록">		
			</form>
			</div>
			
			<div class="col-sm-3"></div>
		</div>
	</div>	
	</body>
</html>

<!-- memoForm.jsp -->