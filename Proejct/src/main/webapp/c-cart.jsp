<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="c-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



	<!-- Cart Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<div class="col-lg-12 table-responsive mb-5">
				<table
					class="table table-light table-borderless table-hover text-center mb-0">
					<thead class="thead-dark">
						<tr>
							<th>Products</th>
							<th>Price</th>
							<th>Quantity</th>
							<th>Total</th>
							<th>Remove</th>
						</tr>
					</thead>
					<tbody class="align-middle">
					<%int net_price = 0; %>
						<%
						List<Cart> list = CartDao.getCartByCusId(s.getId());
						%>
						<%
						for (Cart c : list) {
							net_price = net_price+c.getTotal_price();
						%>
						<%
						Product p = ProductDao.getProductByPid(c.getPid());
						%>
						<tr>
							<td class="align-middle"><img
								src="product image/<%=p.getImage()%>" alt=""
								style="width: 50px;"> <%=p.getPname()%></td>
							<td class="align-middle">Rs. <%=p.getPprice()%></td>
							<td class="align-middle">
								<div>
									<form action="CartController" method="get">
										<input type="hidden" name="cart_id" value="<%=c.getCart_id() %>">
										<input type="hidden" name="pid" value="<%=c.getPid() %>">
										<input type="hidden" name="pprice" value="<%=c.getPprice() %>">
										<input type="number" name="qty" value="<%=c.getQty()%>" onchange="this.form.submit();">
									</form>
								</div>
							</td>
							<td class="align-middle">Rs. <%=c.getTotal_price()%></td>
							<td class="align-middle"><button
									class="btn btn-sm btn-danger">
									<i class="fa fa-times"></i>
								</button></td>
						</tr>
						<%
						}
						%>
					</tbody>

				</table>
				<div class="col-lg-6">

					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Cart Summary</span>
					</h5>
					<div class="bg-light p-30 mb-5">
						<div class="border-bottom pb-2">
							<div class="d-flex justify-content-between mb-3">
								<h6>Subtotal</h6>
								<h6>Rs. <%out.print(net_price); %></h6>
							</div>
							<div class="d-flex justify-content-between">
								<h6 class="font-weight-medium">Shipping</h6>
								<h6 class="font-weight-medium">$10</h6>
							</div>
						</div>
						<div class="pt-2">
							<div class="d-flex justify-content-between mt-2">
								<h5>Total</h5>
								<h5>Rs. <%out.print(net_price); %></h5>
							</div>
							<button
								class="btn btn-block btn-primary font-weight-bold my-3 py-3">Proceed
								To Checkout</button>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- Cart End -->

</body>
</html>