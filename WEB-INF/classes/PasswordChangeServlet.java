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

public class PasswordChangeServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		req.setCharacterEncoding("UTF-8");
		
        Connection cn = null;
        PreparedStatement st = null;
		ResultSet rs = null;
				
		String old_password = req.getParameter("old_password");
		String new_password = req.getParameter("new_password");
		String new_password_confirm = req.getParameter("new_password_confirm");
        String db_old_password = null;
		
		System.out.println("Parameter_old_password: " + old_password);
		System.out.println("Parameter_new_password: " + new_password);
        System.out.println("Parameter_new_password_confirm:" + new_password_confirm);
		
		String message;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");

			cn.setAutoCommit(false);

			String sql = "SELECT login_password FROM bmr_users WHERE user_id = 2";

			st = cn.prepareStatement(sql);

			System.out.println("SQL: " + sql);

			rs = st.executeQuery();
			
			while (rs.next()) {
				db_old_password = rs.getString(1);
				System.out.println("DB_old_password: " + db_old_password);
			}

			rs = null;

			if(old_password.equals(db_old_password) && new_password.equals(new_password_confirm)) {

				sql = "UPDATE bmr_users SET login_password = ? WHERE user_id = 2";
				
				st = cn.prepareStatement(sql);
					
				st.setString(1, new_password);
		
				st.executeUpdate();

				System.out.println("Password changed.");
				message = "Password changed";
			
				req.setAttribute("message", message);
			
				RequestDispatcher dispatcher = req.getRequestDispatcher("main");
			
				dispatcher.forward(req,res);

			} else if(old_password.equals(db_old_password) == false || new_password.equals(new_password_confirm) == false) {
			
				System.out.println("Password change fail. Password not match.");
				message = "Password change fail. Password not match";
				
				req.setAttribute("message", message);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("account");

				dispatcher.forward(req,res);

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
	}
}
