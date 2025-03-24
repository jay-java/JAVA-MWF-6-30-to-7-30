<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num = (Integer) request.getAttribute("num");
	%>
	<%=num%>

	<%
	List<User> list = (List) request.getAttribute("list");
	%>
	<%=list%>

	<%
	for (User u : list) {
	%>
	<h1><%=u%></h1>
	<%
	}
	%>

<h3>${list }</h3>
<c:forEach items="${list }" var="u">
<h3>${u }</h3>
</c:forEach>

</body>
</html>