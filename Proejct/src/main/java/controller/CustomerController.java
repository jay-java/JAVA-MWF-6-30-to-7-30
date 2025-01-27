package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CustomerDao;
import dao.SellerDao;
import model.Customer;
import model.Seller;
import servicess.EmailService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
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
			Customer u = new Customer();
			u.setName(request.getParameter("name"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			u.setAddress(request.getParameter("address"));
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String email = request.getParameter("email");
			boolean flag = CustomerDao.checkEmail(email);
			if(flag == false) {
				CustomerDao.insertUser(u);
				response.sendRedirect("c-login.jsp");
			}
			else {
				request.setAttribute("msg", "Account already exist with this email");
				request.getRequestDispatcher("c-register.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("login")) {
			Customer u = new Customer();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			boolean flag = CustomerDao.checkEmail(request.getParameter("email"));
			if(flag == true) {
				Customer u1= CustomerDao.userLogin(u);
				if(u1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("c-home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg", "Password is incorrect");
					request.getRequestDispatcher("c-login.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "OOPS! Account not exist.");
				request.getRequestDispatcher("c-login.jsp").forward(request, response);
			}
		}
		
	}

}
