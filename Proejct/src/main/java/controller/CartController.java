package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;
import dao.ProductDao;
import model.Cart;
import model.Product;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cart_id = Integer.parseInt(request.getParameter("cart_id"));
		int pid  = Integer.parseInt(request.getParameter("pid"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		Cart c = new Cart();
		c.setCart_id(cart_id);
		c.setQty(qty);
		c.setTotal_price(qty*pprice);
		CartDao.updatecart(c);
		response.sendRedirect("c-cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("addtocart")) {
			Cart c = new Cart();
			c.setCus_id(Integer.parseInt(request.getParameter("cus_id")));
			int pid = Integer.parseInt(request.getParameter("pid"));
			c.setPid(pid);
			Product p= ProductDao.getProductByPid(pid);
			c.setQty(1);
			c.setPprice(p.getPprice());
			c.setTotal_price(p.getPprice());
			c.setNet_price(p.getPprice());
			c.setPayment_status("pending");
			CartDao.insertINtoCart(c);
			response.sendRedirect("c-home.jsp");
		}
		
	}

}
