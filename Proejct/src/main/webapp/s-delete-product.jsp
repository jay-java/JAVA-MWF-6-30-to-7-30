<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int pid = Integer.parseInt(request.getParameter("id"));
ProductDao.deleteProductByPid(pid);
response.sendRedirect("s-manage-product.jsp");
%>
</body>
</html>