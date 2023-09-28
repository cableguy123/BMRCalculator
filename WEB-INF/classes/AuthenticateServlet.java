import java.io.IOException;
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
import javax.servlet.http.HttpSession;

public class AuthenticateServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("user");
        String pass = req.getParameter("pass");
        String name1 = null;
        String pass1 = null;
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");

            String sql = "SELECT LOGIN_NAME, LOGIN_PASSWORD FROM bmr_users WHERE LOGIN_NAME = ?";
            st = cn.prepareStatement(sql);
            st.setString(1, name);

            rs = st.executeQuery();

            while (rs.next()) {
                name1 = rs.getString("LOGIN_NAME");
                pass1 = rs.getString("LOGIN_PASSWORD");

                if (pass.equals(pass1)) {
                    HttpSession session = req.getSession();
                    session.setAttribute("token", "OK");

                    String selectData = "SELECT user_gender, user_age, user_height, user_weight FROM bmr_users WHERE LOGIN_NAME = ?";
                    try (PreparedStatement dataStatement = cn.prepareStatement(selectData)) {
                        dataStatement.setString(1, name);
                        ResultSet dataResult = dataStatement.executeQuery();

                        
                        if (dataResult.next()) {
                            do {
                        
                                String userGender = dataResult.getString("user_gender");
                                int userAge = dataResult.getInt("user_age");
                                float userHeight = dataResult.getFloat("user_height");
                                float userWeight = dataResult.getFloat("user_weight");
                                System.out.println(userGender);
                                System.out.println(userAge);
                                System.out.println(userHeight);
                                System.out.println(userWeight);
                                if(userGender == null || userAge == 0 && userHeight == 0.0 || userWeight == 0.0) {
                                  RequestDispatcher dispatcher = req.getRequestDispatcher("/data_input.jsp");
                                  dispatcher.forward(req, res);
                                }else {
                                  RequestDispatcher dispatcher = req.getRequestDispatcher("/main.jsp");
                                  dispatcher.forward(req, res);
                                }
                            } while (dataResult.next());
                        } 
                    }
                }
            }

            
            RequestDispatcher reqDispatcher = req.getRequestDispatcher("/login.jsp");
            reqDispatcher.forward(req, res);
            return;

        } catch (ClassNotFoundException | SQLException e) {
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
