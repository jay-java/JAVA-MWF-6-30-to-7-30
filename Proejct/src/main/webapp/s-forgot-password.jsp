<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="header.jsp"%>
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
			<span class="bg-secondary pr-3">Seller Forgot Password</span>
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
						
						<div class="control-group">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Your Email" required="required"
								data-validation-required-message="Please enter your email" />
							<p class="help-block text-danger"></p>
						</div>
						<div>
							<button class="btn btn-primary py-2 px-4" type="submit"
								name="action" value="getotp" id="sendMessageButton">Get OTP</button>
						</div>
					</form>
					<br>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->

</body>
</html>