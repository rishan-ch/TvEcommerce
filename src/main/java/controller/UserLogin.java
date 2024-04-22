package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserDAO;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/login" })
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		dao = new UserDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("data is coming to servlet");
		String loginForm = request.getParameter("login");
		if (loginForm != null) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");
			
			try {
				if (email.equals("admin") && password.equals("admin123")) {
//					HttpSession session = request.getSession();
//					session.setAttribute("username", username);
//					session.setAttribute("role", "admin");
//					session.setMaxInactiveInterval(5 * 60);
//					response.sendRedirect(request.getContextPath()+"/admin");
				}

				else {
					boolean isSuccess = dao.studentLogin(email, password);
					if (isSuccess) {
						HttpSession session = request.getSession();
						session.setAttribute("email", email);
						//session.setAttribute("role", "user");
						session.setMaxInactiveInterval(5 * 60);
						response.sendRedirect(request.getContextPath()+"/home");
					} else {
						request.setAttribute("error", "invalid username or password");
						doGet(request, response);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			doGet(request, response);
		}

	}

}
