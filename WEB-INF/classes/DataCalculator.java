import java.io.IOException;
import java.io.PrintWriter;

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
    req.setAttribute("age",age);
    req.setAttribute("height", height);
    req.setAttribute("weight", weight);

    PrintWriter out = res.getWriter();
    if(age >= 122 || age <= 3) {
      if(height >= 280 || height <= 40 && weight >= 240) {
      out.println("<script type='text/javascript'>");
      out.println(
        "alert('Please Re-Enter All!  Age Range 4 ~ 121,Height Range 41~279,Weight Range 0~239');"
      );
      out.println("history.back();");
      out.println("</script>");  
      }
      out.println("<script type='text/javascript'>");
      out.println(
        "alert('Please Re-Enter Age!  Range 4 ~ 121');"
      );
      out.println("history.back();");
      out.println("</script>");
    }else if(height >= 280 || height <= 40) {
      if(weight >= 240)  {
        out.println("<script type='text/javascript'>");
       out.println(
        "alert('Please Re-Enter Weight!  Weight Range 0~239 This Height? ');"
      );
      out.println("history.back();");
      out.println("</script>");
      }
      out.println("<script type='text/javascript'>");
       out.println(
        "alert('Please Re-Enter Height!  Range 41~279');"
      );
      out.println("history.back();");
      out.println("</script>");
    }else if(weight >= 240) {
      if(height >= 280 || height <= 40) {
         out.println("<script type='text/javascript'>");
       out.println(
        "alert('Please Re-Enter Height  Height Range 41~279');"
      );
      out.println("history.back();");
      out.println("</script>");
      }
      out.println("<script type='text/javascript'>");
       out.println(
        "alert('Please Re-Enter Weight!  Weight Range 0~239');"
      );
      out.println("history.back();");
      out.println("</script>");
    }else {
      RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
      dispatcher.forward(req, res);
    }
  }

}
