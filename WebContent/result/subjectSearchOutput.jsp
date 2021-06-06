<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = (String)request.getAttribute("result");
		if(result !=null) {
			out.print(result);
		}else{
	
	%>
	${subject.id } / ${subject.title } / ${subject.count} / ${subject.prof } / 
	<%} %>
	<br>
</body>
</html>