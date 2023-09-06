import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {

<<<<<<< HEAD
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    // TODO Auto-generated method stub
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession();
    String token = (String) session.getAttribute("/login.jsp");
    String requestURI = (String) session.getAttribute("/login.jsp");
    if (requestURI.endsWith("/data_input.jsp")) {
      if (token == null || !token.equals("OK")) {
          response.sendRedirect(request.getContextPath() + "/login.jsp");
          return;
      }
=======
    public void init(FilterConfig config) throws ServletException {}

    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();

        String flag = (String)session.getAttribute("token");

        if(flag == null) {
            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/login");
            reqDispatcher.forward(req, res);
        } else {
            chain.doFilter(req, res);
        }
>>>>>>> 91dd9cea597945736a107075e1f75a13594b71e1
    }
}