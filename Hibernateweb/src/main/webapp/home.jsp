<%@page import="dao.UserDao"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Hello, world!</title>
</head>
<body>
	<%
	List<User> list = new UserDao().getAllUser();
	%>
	
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">name</th>
					<th scope="col">contact</th>
					<th scope="col">Address</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
			<%for(User u :list){ %>
				<tr>
					<th scope="row"><%=u.getId() %></th>
					<td><%=u.getName() %></td>
					<td><%=u.getContact() %></td>
					<td><%=u.getAddress() %></td>
					<td><%=u.getEmail() %></td>
					<td><%=u.getPassword() %></td>
					<td><a href="s-user.jsp?id=<%=u.getId()%>">Edit</a></td>
					<td><a href="delete.jsp?id=<%=u.getId()%>">delete</a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>