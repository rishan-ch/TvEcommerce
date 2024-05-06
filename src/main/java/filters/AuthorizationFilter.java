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

public class AuthorizationFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String role = (String) request.getSession().getAttribute("role");

		if (role != null && role.equals("admin")) {


			
			if (request.getRequestURI().endsWith("addProduct")) {
				
				request.getRequestDispatcher("addProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("deleteProduct")) {
			
				request.getRequestDispatcher("deleteProduct").forward(request, response);
			}
			else if (request.getRequestURI().endsWith("admin")) {
				
				request.getRequestDispatcher("admin").forward(request, response);
			}
			else if ( request.getRequestURI().endsWith("editProduct")) {
				
				request.getRequestDispatcher("editProduct").forward(request, response);
			}
			else if ( request.getRequestURI().endsWith("updateProduct")) {
				
				request.getRequestDispatcher("updateProduct").forward(request, response);
			}
			else if (!request.getRequestURI().endsWith("admin")) {
				
				response.sendRedirect(request.getContextPath() + "/admin");
			}
			else
			{
				request.getRequestDispatcher("admin").forward(request, response);
			}
		} 
		else if (role != null && role.equals("user")) 
		{


			if (request.getRequestURI().endsWith("logout"))
			{
				request.getRequestDispatcher("logout").forward(request, response);
			}
			else if (role != null && role.equals("user") && !request.getRequestURI().endsWith("home")) {

				response.sendRedirect(request.getContextPath() + "/home");
			}
			else 
			{

				
				request.getRequestDispatcher("home").forward(request, response);
			}
		}
		else

		{
			chain.doFilter(request, response);
		}
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
