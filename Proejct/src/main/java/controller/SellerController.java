package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.SellerDao;
import model.Seller;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			Seller u = new Seller();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String email = request.getParameter("email");
			boolean flag = SellerDao.checkEmail(email);
			if(flag == false) {
				SellerDao.insertUser(u);
				response.sendRedirect("s-login.jsp");
			}
			else {
				request.setAttribute("msg", "Account already exist with this email");
				request.getRequestDispatcher("s-register.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login")) {
			Seller u = new Seller();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			boolean flag = SellerDao.checkEmail(request.getParameter("email"));
			if(flag == true) {
				Seller u1= SellerDao.userLogin(u);
				if(u1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("s-home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("s-login.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "OOPS! Account not exist.");
				request.getRequestDispatcher("s-login.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("update")) {
			Seller u = new Seller();
			u.setId(Integer.parseInt(request.getParameter("id")));
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			SellerDao.updateSellerProfile(u);
			HttpSession session = request.getSession();
			session.setAttribute("data", u);
			request.getRequestDispatcher("s-home.jsp").forward(request, response);
		}
	}

}
