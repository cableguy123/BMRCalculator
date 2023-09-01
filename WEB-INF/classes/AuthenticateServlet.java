import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("user");
        String pass = req.getParameter("pass");

        if(name.equals("yung") && pass.equals("123")) {
            HttpSession session = req.getSession();
            session.setAttribute("token", "OK");
        } else if(name.equals("im") && pass.equals("123")) {
            HttpSession session = req.getSession();
            session.setAttribute("token", "OK");
        }

        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/data_input");
        reqDispatcher.forward(req, res);

    }

}
