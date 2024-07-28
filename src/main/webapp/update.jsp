<%@page import="Models.studentmodel"%>
<%@page import="Dbconnection.studentdb"%>
<%@page import="Services.studentservice"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String pinno=request.getParameter("pinno");
studentservice service=new studentservice(studentdb.conn());
studentmodel s=service.getbystu(pinno);
%>
<form action="update" method="post">
<input type="text" placeholder="Enter your name" name="name" value="<%=s.getName()%>">
<input type="text" placeholder="Enter your email" name="email" value="<%=s.getEmail()%>">
<input type="text" placeholder="Enter your branch" name="branch" value="<%=s.getBranch()%>">
<input type="hidden" placeholder="Enter your pinno" name="pinno" value="<%=s.getPinno()%>">
<button>Update</button>
</form>
</body>
</html>