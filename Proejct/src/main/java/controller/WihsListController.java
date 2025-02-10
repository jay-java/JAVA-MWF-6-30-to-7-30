package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WIshListDao;
import model.WishList;

/**
 * Servlet implementation class WihsListController
 */
@WebServlet("/WihsListController")
public class WihsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WihsListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("add")) {
			WishList w = new WishList();
			w.setCus_id(Integer.parseInt(request.getParameter("cus_id")));
			w.setPid(Integer.parseInt(request.getParameter("pid")));
			boolean flag = WIshListDao.checkProductForWishList(Integer.parseInt(request.getParameter("cus_id")),
					Integer.parseInt(request.getParameter("pid")));
			
			if(flag == false) {
				WIshListDao.addToWishList(w);
				response.sendRedirect("c-home.jsp");
			}
			else {
				request.setAttribute("msg", "Product already added !");
				request.getRequestDispatcher("c-wishlist.jsp").forward(request, response);
			}
		}
	}

}
