import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    // TODO Auto-generated method stub
    HttpSession session = ((HttpServletRequest) req).getSession();
    String flag = (String) session.getAttribute("token");
    if(flag == null) {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
      dispatcher.forward(req, res);
    }else {
      chain.doFilter(req, res);
    }
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub
    
  }
}