package JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataInputServlet extends HttpServlet {
  protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException {
    Connection cn = null;
    ResultSet rs = null;
    PreparedStatement st = null;
    String gender = req.getParameter("gender");
    int age = Integer.parseInt(req.getParameter("age"));
    float height = Float.parseFloat(req.getParameter("height"));
    float weight = Float.parseFloat(req.getParameter("weight"));
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
      cn.setAutoCommit(false);
      String sql = "INSERT INTO bmr_users VALUES(?,?,?,?)";
      st = cn.prepareStatement(sql);

      st.setString(1, gender);
      st.setInt(2, age);
      st.setFloat(3, height);
      st.setFloat(4, weight);
      st.executeUpdate();
      cn.commit();

    }catch(ClassNotFoundException e) {
      e.printStackTrace();
    }catch(SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        if(rs != null) {
          rs.close();
        }
        if(st != null) {
          st.close();
        }
        if(cn != null) {
          cn.close();
        }
      }catch(SQLException e) {
        e.printStackTrace();
      }
    }
  }
}