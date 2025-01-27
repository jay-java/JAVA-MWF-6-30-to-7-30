<%@page import="dao.ProductDao"%>
<%@page import="model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="s-header.jsp"%>
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
							<th>Category</th>
							<th>Description</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<%
					List<Product> list = ProductDao.getProductsBySid(s.getId());
					%>
					<tbody class="align-middle">
					<%for(Product p:list){ %>
						<tr>
							<td class="align-middle"><img src="product image/<%=p.getImage() %>" alt=""
								style="width: 50px;"> <%=p.getPname() %></td>
							<td class="align-middle">Rs. <%=p.getPprice() %></td>
							<td class="align-middle"><%=p.getPqty() %> items</td>
							<td class="align-middle"><%=p.getPcategory() %></td>
							<td class="align-middle"><%=p.getPdesc() %></td>
							<td class="align-middle"><a href="s-single-product.jsp?id=<%=p.getPid() %>" class="btn btn-success">Edit</a></td>
							<td class="align-middle"><a href="s-delete-product.jsp?id=<%=p.getPid() %>" class="btn btn-danger">Delete</a></td>
						</tr>
						<%} %>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Cart End -->
</body>
</html>