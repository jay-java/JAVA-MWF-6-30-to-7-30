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
			<span class="bg-secondary pr-3">Customer Register</span>
		</h2>
		<div class="row px-xl-5">
			<div class="col-lg-7 mb-5">
				<div class="contact-form bg-light p-30">
					<div id="success"></div>
					<form action="CustomerController" method="post">
						<div class="control-group">
							<input type="text" class="form-control" id="name"
								placeholder="Your Name" name="name" required="required"
								data-validation-required-message="Please enter your name" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="text" class="form-control" id="name"
								placeholder="Your contact" name="contact" required="required"
								data-validation-required-message="Please enter your contact" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="text" class="form-control" id="name"
								placeholder="Your address" name="address" required="required"
								data-validation-required-message="Please enter your address" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="email" class="form-control" id="email"
								placeholder="Your Email" name="email" required="required"
								data-validation-required-message="Please enter your email" />
							<p class="help-block text-danger"></p>
						</div>
						<div class="control-group">
							<input type="text" class="form-control" id="subject"
								placeholder="Password" name="password" required="required"
								data-validation-required-message="Please enter a subject" />
							<p class="help-block text-danger"></p>
						</div>
					
						<div>
							<button class="btn btn-primary py-2 px-4" type="submit" name="action" value="register"
								id="sendMessageButton">Register</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- Contact End -->

</body>
</html>