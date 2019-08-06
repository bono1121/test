<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>메모 디테일</title>
</head>
<body>
	<h4>상세보기</h4>
	<form action="memo_update" method="post">
		<input type="hidden"   name="memoid" value="${memo.memoid}" /><br />
		<input type="text"   placeholder="이름을 입력하세요." name="name" value="${memo.name}"/><br />
		<input type="text"  placeholder="나이를 입력하세요." name="age" value="${memo.age}"/><br />
		<input type="submit" class="btn btn-primary form-control" value="수정">				
	</form>
	<a href="memo_delete?memoid=${memo.memoid}">삭제</a>
</body>
</html>






