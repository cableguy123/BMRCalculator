package JDBC;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement st = null;
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");
        String height = req.getParameter("height");
        String weight = req.getParameter("weight");
        PrintWriter out = res.getWriter();
        if (gender.isEmpty()) {
          out.println("<script type='text/javascript'>");
          out.println("alert('Please Selected Your Gender');");
          out.println("history.back();");
          out.println("</script>");
      } else if (Integer.parseInt(age) >= 122 || Integer.parseInt(age) <= 3) {
          out.println("<script type='text/javascript'>");
          out.println("alert('Please Re-Enter Age!  Range 4 ~ 121');");
          out.println("history.back();");
          out.println("</script>");
      } else if (Float.parseFloat(height) >= 280 || Float.parseFloat(height) <= 40) {
          out.println("<script type='text/javascript'>");
          out.println("alert('Please Re-Enter Height!  Range 41~279');");
          out.println("history.back();");
          out.println("</script>");
          if (Float.parseFloat(weight) >= 240) {
              out.println("<script type='text/javascript'>");
              out.println("alert('Please Re-Enter Weight!  Weight Range 0~239 This Height?');");
              out.println("history.back();");
              out.println("</script>");
          }
      } else if (Float.parseFloat(weight) >= 240) {
          out.println("<script type='text/javascript'>");
          out.println("alert('Please Re-Enter Weight!  Weight Range 0~239');");
          out.println("history.back();");
          out.println("</script>");
          if (Float.parseFloat(height) >= 280 || Float.parseFloat(height) <= 40) {
              out.println("<script type='text/javascript'>");
              out.println("alert('Please Re-Enter Height  Height Range 41~279');");
              out.println("history.back();");
              out.println("</script>");
          }
      }else {
            System.out.println(gender + "\t" + age + "\t" + height + "\n" + weight);
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "info", "pro");
                cn.setAutoCommit(false);

                String sql = "UPDATE bmr_users SET user_gender = ?, user_age = ?, user_height = ?, user_weight = ? WHERE user_id = 2";
                st = cn.prepareStatement(sql);

                st.setString(1, gender);
                st.setString(2, age);
                st.setString(3, height);
                st.setString(4, weight);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(height);
                System.out.println(weight);
                st.executeUpdate();
                cn.commit();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                    if (st != null) {
                        st.close();
                    }
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
        dispatcher.forward(req, res);
    }
}
