<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<img alt="mario" src="resources/img/mario.jpg">

<br />
<h1> 1. Controller 메소드  호출하는 방법</h1>
<a href="a">@RequestMapping(value = "/a", method = RequestMethod.GET):request01()</a><br />
<a href="a/b">@RequestMapping(value = "/a/b", method = RequestMethod.GET):request02()</a><br />
<a href="c">@RequestMapping(value = "/c", method = RequestMethod.GET):request03()</a><br />
<form action="c" method="post">
	@RequestMapping(value = "/c", method = RequestMethod.POST):request04()
	<input type="submit" value="request04()">
</form>

<h1> 2. 페이지 호출 방법</h1>
<a href="viewEx/v01">메소드 리턴형이 String 형인 경우 : 리턴값이 뷰 논리적 이름이 됨</a><br />
<a href="viewEx/v02">메소드 리턴형이 void인 경우 : url(value 값이) 부터가 뷰 논리적 이름이 됨</a><br />
<a href="viewEx/v03">메소드 리턴형이 참조형인 경우(String 형 제외) : url(value 값이) 부터가 뷰 논리적 이름이 됨</a><br />
</body>
</html>
