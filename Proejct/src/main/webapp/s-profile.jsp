<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="s-header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Contact Start -->
	<div class="container-fluid">
		<h2
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">Seller Register</span>
		</h2>
		<%
		String msg = (String) request.getAttribute("msg");
		%>
		<%
		if (msg != null) {
		%>
		<h4
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">
				<%
				out.print(msg);
				%>
			</span>
		</h4>
		<%
		}
		%>
		<div class="row px-xl-5">
			<div class="col-lg-7 mb-5">
				<div class="contact-form bg-light p-30">
					<div id="success"></div>
					<form action="SellerController" method="post">
					<input type="hidden" name="id" value="<%=s.getId()%>">
						<div class="control-group">
							<input type="text" class="form-control" id="name"
								value="<%=s.getName()%>" name="name" required="required"
								data-validation-required-message="Please enter your name" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="text" class="form-control" id="name"
								value="<%=s.getContact()%>" name="contact" required="required"
								data-validation-required-message="Please enter your contact" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="text" class="form-control" name="address" id="name"
								value="<%=s.getAddress()%>" required="required"
								data-validation-required-message="Please enter your address" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="email" class="form-control" name="email" id="email"
								value="<%=s.getEmail()%>" required="required"
								data-validation-required-message="Please enter your email" />
							<p class="help-block text-danger"></p>
						</div>
					
						<div>
							<button class="btn btn-primary py-2 px-4" type="submit"
								name="action" value="update" id="sendMessageButton">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->
</body>
</html>