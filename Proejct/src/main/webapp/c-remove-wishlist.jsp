<%@page import="dao.WIshListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int wid = Integer.parseInt(request.getParameter("wid"));
WIshListDao.removerProduct(wid);
response.sendRedirect("c-wishlist.jsp");
%>
</body>
</html>