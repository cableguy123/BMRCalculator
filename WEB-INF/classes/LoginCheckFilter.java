import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.http.HttpSession;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'destroy'");
  }

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
    }

    chain.doFilter(req, res);


  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'init'");
  }

}