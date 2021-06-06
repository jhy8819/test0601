<%@page import="test.vo.TestVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
  table {
    width: 100%;
    border-top: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border-bottom: 1px solid #444444;
    padding: 10px;
    text-align: center;
  }
</style>
<title>Insert title here</title>
</head>
<body>
<h3>강좌 리스트</h3>
	<% ArrayList<TestVO> list = (ArrayList<TestVO>) request.getAttribute("list"); 
	if(!list.isEmpty()) {  %>
	   <table>
	   		<tr><th>ID</th><th>Title</th><th>학생 수</th><th>담당교수</th>
			
			<%   for(int i=0; i<list.size(); i++){   
			       TestVO subject = list.get(i);   %>
			       
			        <tr><td><%=subject.getId() %></td>
			            <td><%=subject.getTitle() %></td>
			            <td><%=subject.getCount() %></td>
			            <td><%=subject.getProf() %> </td>
			       </tr>
			       
			<%   }
    }else{
 	   out.print("");
    }
	%>
	  </table>
	  
	<p>
	------------------------------------------
	</p>
	<a href="/test0601/menu.jsp">Home</a>
</body>
</html>