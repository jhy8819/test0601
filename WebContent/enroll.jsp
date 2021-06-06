<%@page import="test.vo.TestVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>강좌 등록</h3>
	<form action="enroll.do" method="post">
	ID    : <input type="text" name="id"/> <br>
	TITLE : <input type="text" name="title"/> <br>
	# of Student : <input type="text" name="count" /> <br>
	Professor : <input type="text" name="prof" /> <br>
	<input type="submit" value="Enroll" />
	
</form>


<%@include file="homeMenu.jsp" %>
</body>
</html>