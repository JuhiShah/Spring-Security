<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/security/tags" prefix="ss" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 style="color: green;">Welcome,<ss:authentication property="name"/><ss:authentication property="authorities"/></h2>
<br/><br/>
<ss:authorize access="hasRole('ADMIN')">
all crud process access<br>
</ss:authorize>
<ss:authorize access="hasRole('USER')">
access for only reading<br>
</ss:authorize>
<a href="logout"> Logout</a>

</body>
</html>