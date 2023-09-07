import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataCalculator extends HttpServlet{
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
     req.setCharacterEncoding("UTF-8");
     String gender = req.getParameter("gender");
     int age = Integer.parseInt(req.getParameter("age"));
     int height = Integer.parseInt(req.getParameter("height"));
     int weight = Integer.parseInt(req.getParameter("weight"));
      
    
    req.setAttribute("gender", gender);
    if(gender.isEmpty() == true) {
        System.out.println("First,Input Gender!");
    }
    req.setAttribute("age",age);
    req.setAttribute("height", height);
    req.setAttribute("weight", weight);
    


    RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
    dispatcher.forward(req, res);
  }

}
