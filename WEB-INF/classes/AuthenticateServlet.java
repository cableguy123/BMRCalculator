import jdbc.DataInputServlet;

import java.io.DataInput;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        String name1 = null;
        String pass1 = null;


        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");

            cn.setAutoCommit(false);

            String sql = "SELECT * FROM bmr_users WHERE user_id = 2";

            st = cn.createStatement();

            rs = st.executeQuery(sql);

            while (rs.next()) {
              name1 = rs.getString(2); // im..
              pass1 = rs.getString(3);
              System.out.println(name1);
              System.out.println(pass1);
            }
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

        if(name.equals(name1) && pass.equals(pass1)) {
            HttpSession session = req.getSession();
            session.setAttribute("token", "OK");
        }
        RequestDispatcher reqDispatcher = req.getRequestDispatcher("/data_input");
        reqDispatcher.forward(req, res);
 }
}