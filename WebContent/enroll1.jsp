<%@page import="test.vo.TestVO" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h3>과목 검색</h3>
<form action="search.do" method="post">
	ID: <input type="text" name="id"/>
	<input type="hidden" name="job" value="update" />
	<input type="submit" value="Search" />
</form>

	<%
	TestVO subject = (TestVO)request.getAttribute("subject");
	if(subject != null) {
	%>
	<h3>강좌 등록</h3>
	<form action="enrollstu.do" method="post">
	ID : ${subject.id } / Title : ${subject.title } / Count : ${subject.count } /Prof : ${subject.prof }
	<input type="submit" value="Enrollment" />
	
	</form>
	
	<%}else{ %>
	${result } <p>
	<%} %>
	
</body>
</html>