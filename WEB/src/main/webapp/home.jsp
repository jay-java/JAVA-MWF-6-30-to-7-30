<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
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
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	User u = null;
	if (session.getAttribute("data") != null) {
		u = (User) session.getAttribute("data");
	} else {
		response.sendRedirect("login.jsp");
	}
	%>
	Welcome,
	<h1><%=u.getName()%></h1>
	<%-- <h2>Contact : <%=u.getContact() %></h2>
<h2>Address : <%=u.getAddress() %></h2>
<h2>Email : <%=u.getEmail() %></h2>
<h2>Password : <%=u.getPassword() %></h2> --%>


	<%
	List<User> list = UserDao.getAllUsers();
	%>
	<div class="container">

		<table class="table">
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Name</th>
					<th scope="col">Contact</th>
					<th scope="col">Address</th>
					<th scope="col">Email</th>
					<th scope="col">Password</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (User u1 : list) {
				%>
				<tr>
					<th scope="row"><%=u1.getId()%></th>
					<td><%=u1.getName()%></td>
					<td><%=u1.getContact()%></td>
					<td><%=u1.getAddress()%></td>
					<td><%=u1.getEmail()%></td>
					<td><%=u1.getPassword()%></td>
					<td>
						<form action="UserController" method="post">
							<input type="hidden" name="id" value="<%=u1.getId()%>"> <input
								type="submit" name="action" value="edit">
						</form>
					</td>
					<td><a href="UserController?action=delete&id=<%=u1.getId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div class="text-center">
			<a href="logout.jsp">Logout</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>



