import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login_name = request.getParameter("user");
        String login_password = request.getParameter("pass");

        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");
            cn.setAutoCommit(false);

            
            String checkDuplicateSql = "SELECT COUNT(*) FROM bmr_users WHERE login_name = ?";
            st = cn.prepareStatement(checkDuplicateSql);
            st.setString(1, login_name);
            rs = st.executeQuery();

            rs.next();
            int rowCount = rs.getInt(1);
            if (rowCount > 0) {
              response.getWriter().println("<script>alert('This ID already exists'); window.location = 'createUser.jsp';</script>");
            }
            
            String insertUserSql = "INSERT INTO bmr_users (user_id, login_name, login_password) VALUES (user_id_seq.NEXTVAL, ?, ?)";
            st = cn.prepareStatement(insertUserSql);
            st.setString(1, login_name);
            st.setString(2, login_password);

            int rowsAffected = st.executeUpdate();
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
}
