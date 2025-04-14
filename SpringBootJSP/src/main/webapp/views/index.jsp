<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	hello this index page
	<form action="save" method="post">
		<table>
			<tr>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td><input type="text" name="contact"></td>
			</tr>
			<tr>
				<td><input type="submit" name="action" value="register">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>