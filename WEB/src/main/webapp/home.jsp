<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% User u = null;
	if(session.getAttribute("data")!=null){
		u = (User)session.getAttribute("data");
	}
	else{
		response.sendRedirect("login.jsp");
	}
%>
Welcome, 
<h2>Name : <%=u.getName() %></h2>
<%-- <h2>Contact : <%=u.getContact() %></h2>
<h2>Address : <%=u.getAddress() %></h2>
<h2>Email : <%=u.getEmail() %></h2>
<h2>Password : <%=u.getPassword() %></h2> --%>


<%List<User> list  = UserDao.getAllUsers(); %>
<%out.print(list); %>

</body>
</html>