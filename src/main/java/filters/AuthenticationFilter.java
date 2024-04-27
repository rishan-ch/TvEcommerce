package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    String requestUrl = request.getRequestURI();
	    HttpSession session = request.getSession(false);
	    
	    System.out.println("Filter hit");
	    System.out.println("Request URL: " + requestUrl);
	    System.out.println("Session: " + session);
	    
	    if (requestUrl.endsWith(".css")) {
	        chain.doFilter(request, response);
	        return;
	    }

	    if (requestUrl.endsWith("/") || requestUrl.endsWith("login") || requestUrl.endsWith("register")
	            || requestUrl.endsWith("logout") || requestUrl.endsWith("profile") || requestUrl.endsWith("admin") || requestUrl.endsWith("view")) {
	        if (session == null) {
	            System.out.println("Session is null, forwarding to login");
	            request.getRequestDispatcher("/login").forward(request, response);
	            return;
	        } else if (session.getAttribute("email") == null) {
	            System.out.println("Email is null, redirecting to login");
	            response.sendRedirect(request.getContextPath() + "/login");
	            return;
	        } else {
	            System.out.println("Both session and email are available, forwarding to home");
	            request.getRequestDispatcher("/home").forward(request, response);
	            return;
	        }
	    }

	    
	}


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
