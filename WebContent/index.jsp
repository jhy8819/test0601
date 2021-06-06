<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<h3>YongIn LMS</h3>

	
	<form action="login.do" method="post" name="form1">
		I       D:<input type="text" name="id" /> <br>
		PASSWORD :<input type="password" name="pwd" /><br>
		<input type="radio" name="job" value="prof" />Professor
		<input type="radio" name="job" value="student"/>Student
		<br> 
		<input type="submit" value="로그인" />
	</form>	
	
	
	
	
</body>
</html>