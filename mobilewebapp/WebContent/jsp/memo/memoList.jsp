<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>메모리스트</title>
<style>
	#select {
	  font-size: 20px;
	}
</style>		
</head>
<body>
	<h3>Memo List</h3>
	
	<form action="memo_search" method="post">
		이름을 넣으세요.<input type="text" name="name" />
		<input type="submit" value="검색"/>
	</form>
	
	<c:if test="${empty memos}">
		<hr />
		검색된 결과가 존재하지 않습니다.
		<hr/>
	</c:if>
	<c:if test="${!empty memos}">
		<table>
			<tr>
				<td>메모번호</td>
				<td>이름</td>
				<td>나이</td>
				<!-- <td>상세보기</td> -->
			</tr>
			<c:forEach var="memo" items="${memos}">
				<tr>
					<td>${memo.memoid}</td>
					<td><a href="memo_detail?memoid=${memo.memoid}">${memo.name}</a></td>
					<td>${memo.age}</td>
					<%-- <td><a href="memo_detail?memoid=${memo.memoid}">상세보기</a></td> --%>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<!--페이지 처리 부분  -->
	<c:if test="${pageGroupResult.beforePage}">
		<a href="memo_req_list?reqPage=${pageGroupResult.groupStartNumber-1}">《 </a> 
	</c:if>
	
	<c:forEach var="index" begin="${pageGroupResult.groupStartNumber}" end="${pageGroupResult.groupEndNumber}">		
		<c:choose>
			<c:when test="${pageGroupResult.selectPageNumber==index}">			
				<span id="select"><a href="memo_req_list?reqPage=${index}">${index}</a></span>
			</c:when>
			<c:otherwise>
				<a href="memo_req_list?reqPage=${index}">${index}</a>
			</c:otherwise>
		</c:choose>
				
	</c:forEach>
	
	<c:if test="${pageGroupResult.afterPage}"> 
		<a href="memo_req_list?reqPage=${pageGroupResult.groupEndNumber+1}"> 》</a>
	</c:if>
	
	<br />
	<br />
	<a href="memo_input">메모저장</a>
</body>
</html>






