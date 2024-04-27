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

        if (role != null) {
            if (role.equals("admin")) {
                // Redirect to admin page for admin role
                response.sendRedirect(request.getContextPath() + "/admin");
            } else if (role.equals("user")) {
                // Redirect to home page for user role
                response.sendRedirect(request.getContextPath() + "/home");
            }
        } else {
            // If role is not set, continue with the filter chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }
}
