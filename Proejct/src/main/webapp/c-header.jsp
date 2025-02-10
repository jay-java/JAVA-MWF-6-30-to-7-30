<%@page import="dao.CartDao"%>
<%@page import="model.Cart"%>
<%@page import="dao.WIshListDao"%>
<%@page import="model.WishList"%>
<%@page import="java.util.List"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MultiShop - Online Shop Website Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="Free HTML Templates" name="keywords">
<meta content="Free HTML Templates" name="description">

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap"
	rel="stylesheet">

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/animate/animate.min.css" rel="stylesheet">
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- Customized Bootstrap Stylesheet -->
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);

	Customer s = null;
	if (session.getAttribute("data") != null) {
		s = (Customer) session.getAttribute("data");
	} else {
		response.sendRedirect("c-login.jsp");
	}
	%>
	<!-- Navbar Start -->
	<div class="container-fluid bg-dark mb-30">
		<div class="row px-xl-5">
			
			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-0">
					<a href="" class="text-decoration-none d-block d-lg-none"> <span
						class="h1 text-uppercase text-dark bg-light px-2">Multi</span> <span
						class="h1 text-uppercase text-light bg-primary px-2 ml-n1">Shop</span>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav mr-auto py-0">
							<a href="c-home.jsp" class="nav-item nav-link active">Home</a> 
							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown">Product <i
									class="fa fa-angle-down mt-1"></i></a>
								<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
									<a href="s-upload-product.jsp" class="dropdown-item">Electronics</a>
									<a href="s-manage-product.jsp" class="dropdown-item">Furniture</a>
									<a href="s-manage-product.jsp" class="dropdown-item">Clothes</a>
									<a href="s-manage-product.jsp" class="dropdown-item">Footware</a>
								</div>
							</div>
							<div class="nav-item dropdown">
								<a href="#" class="nav-link dropdown-toggle"
									data-toggle="dropdown"><%=s.getName() %> <i
									class="fa fa-angle-down mt-1"></i></a>
								<div class="dropdown-menu bg-primary rounded-0 border-0 m-0">
									<a href="s-profile.jsp" class="dropdown-item">Profile</a> <a
										href="s-change-password.jsp" class="dropdown-item">Change Password</a> <a
										href="s-logout.jsp" class="dropdown-item">Logout</a>
								</div>
							</div>
						</div>
						<div class="navbar-nav ml-auto py-0 d-none d-lg-block">
						<%
					List<WishList> list1 = WIshListDao.getWishLIstByCusID(s.getId());
					%>
							<a href="c-wishlist.jsp" class="btn px-0"> <i
								class="fas fa-heart text-primary"></i> <span
								class="badge text-secondary border border-secondary rounded-circle"
								style="padding-bottom: 2px;"><%out.print(list1.size()); %></span>
							<%List<Cart> list2 = CartDao.getCartByCusId(s.getId()); %>
							</a> <a href="c-cart.jsp" class="btn px-0 ml-3"> <i
								class="fas fa-shopping-cart text-primary"></i> <span
								class="badge text-secondary border border-secondary rounded-circle"
								style="padding-bottom: 2px;"><%out.print(list2.size()); %></span>
							</a>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->



	<!-- <!-- Footer Start -->
	<!-- <div class="container-fluid bg-dark text-secondary mt-5 pt-5">
		<div class="row px-xl-5 pt-5">
			<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
				<h5 class="text-secondary text-uppercase mb-4">Get In Touch</h5>
				<p class="mb-4">No dolore ipsum accusam no lorem. Invidunt sed
					clita kasd clita et et dolor sed dolor. Rebum tempor no vero est
					magna amet no</p>
				<p class="mb-2">
					<i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Street,
					New York, USA
				</p>
				<p class="mb-2">
					<i class="fa fa-envelope text-primary mr-3"></i>info@example.com
				</p>
				<p class="mb-0">
					<i class="fa fa-phone-alt text-primary mr-3"></i>+012 345 67890
				</p>
			</div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Quick Shop</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a
								class="text-secondary" href="#"><i
								class="fa fa-angle-right mr-2"></i>Contact Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">My Account</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Home</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Our Shop</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shop Detail</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Shopping Cart</a> <a
								class="text-secondary mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Checkout</a> <a
								class="text-secondary" href="#"><i
								class="fa fa-angle-right mr-2"></i>Contact Us</a>
						</div>
					</div>
					<div class="col-md-4 mb-5">
						<h5 class="text-secondary text-uppercase mb-4">Newsletter</h5>
						<p>Duo stet tempor ipsum sit amet magna ipsum tempor est</p>
						<form action="">
							<div class="input-group">
								<input type="text" class="form-control"
									placeholder="Your Email Address">
								<div class="input-group-append">
									<button class="btn btn-primary">Sign Up</button>
								</div>
							</div>
						</form>
						<h6 class="text-secondary text-uppercase mt-4 mb-3">Follow Us</h6>
						<div class="d-flex">
							<a class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-twitter"></i></a> <a
								class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-facebook-f"></i></a> <a
								class="btn btn-primary btn-square mr-2" href="#"><i
								class="fab fa-linkedin-in"></i></a> <a
								class="btn btn-primary btn-square" href="#"><i
								class="fab fa-instagram"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row border-top mx-xl-5 py-4"
			style="border-color: rgba(256, 256, 256, .1) !important;">
			<div class="col-md-6 px-xl-0">
				<p class="mb-md-0 text-center text-md-left text-secondary">
					&copy; <a class="text-primary" href="#">Domain</a>. All Rights
					Reserved. Designed by <a class="text-primary"
						href="https://htmlcodex.com">HTML Codex</a>
				</p>
			</div>
			<div class="col-md-6 px-xl-0 text-center text-md-right">
				<img class="img-fluid" src="img/payments.png" alt="">
			</div>
		</div>
	</div> -->

	<!-- Back to Top -->
	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="mail/jqBootstrapValidation.min.js"></script>
	<script src="mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="js/main.js"></script>
</body>
</html>