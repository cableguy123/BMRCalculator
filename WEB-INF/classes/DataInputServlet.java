import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInputServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
     req.setCharacterEncoding("text/html; charset=Windows-31J");

     String gender = req.getParameter("gender");
     int age = Integer.parseInt(req.getParameter("age"));
     int height = Integer.parseInt(req.getParameter("height"));
     int weight = Integer.parseInt(req.getParameter("weight"));
      
    req.setAttribute("gender", gender);
    req.setAttribute("age",age);
    req.setAttribute("height", height);
    req.setAttribute("weight", weight);

    // Gender<input type="radio" name="gender" value="M">Male
    // <input type="radio" name="gender" value="F">Female<br>
    RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
    dispatcher.forward(req, res);
    

     



  }
}
