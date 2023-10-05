package jdbc;

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
        String user_id = req.getParameter("user_id");
        System.out.println("user_id: " + user_id);
        DBConnection dbc = new DBConnection();
        try {
                cn = dbc.getConnection();
                cn.setAutoCommit(false);

                String sql = "UPDATE bmr_users SET user_gender = ?, user_age = ?, user_height = ?, user_weight = ? WHERE user_id = ?";
                st = cn.prepareStatement(sql);

                st.setString(1, gender);
                st.setString(2, age);
                st.setString(3, height);
                st.setString(4, weight);
                st.setString(5, user_id);
                System.out.println(gender);
                System.out.println(age);
                System.out.println(height);
                System.out.println(weight);
                st.executeUpdate();
                cn.commit();

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
        
        res.sendRedirect("main?user_id=" + user_id);
    }
}