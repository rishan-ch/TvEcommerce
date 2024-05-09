package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cart;
import service.CartDAO;

/**
 * Servlet implementation class CartItemRemove
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/removeItem" })
public class CartItemRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemRemove() {
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
        
        ArrayList<Cart> cartList = (ArrayList<Cart>) request.getSession(false).getAttribute("cartList");

        
        int productIdToRemove = Integer.parseInt(request.getParameter("productId"));

        
        CartDAO cartDAO = new CartDAO();
        cartDAO.removeItemFromCart(cartList, productIdToRemove);

        
        response.sendRedirect("cart");
    }

}
