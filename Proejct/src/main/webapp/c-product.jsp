<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="c-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String category = (String)request.getParameter("category"); %>
<%List<Product> plist = ProductDao.getProductsByCategory(category); %>
<%out.print(plist); %>
</body>
</html>