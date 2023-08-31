import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AuthenticateServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
      req.setCharacterEncoding("text/html; charset=Windows-31J");

      String name = req.getParameter("name");
      String pass = req.getParameter("pass");

      req.setAttribute(name,"name");
      req.setAttribute(pass, "pass");

      HttpSession session = req.getSession();
      // Yung,IM id,pwd
      if("test1".equals(name) && "test2".equals(pass)) {
        session.setAttribute("token", "OK");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/data_input.jsp");
        dispatcher.forward(req, res);
      }else if("IM1".equals(name) && "IM2".equals(pass)) { 
        session.setAttribute("token", "OK");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/data_input.jsp");
        dispatcher.forward(req, res);
      }else {
        session.removeAttribute("token");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
        dispatcher.forward(req, res);
      }

  }
}

