import jdbc.DBConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

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
		String user_id = req.getParameter("user_id");
        System.out.println("user_id: " + user_id);

		DBConnection dbc = new DBConnection();
		
		try {
			cn = dbc.getConnection();

			cn.setAutoCommit(false);

			String sql = "SELECT login_password FROM bmr_users WHERE user_id = ?";

			st = cn.prepareStatement(sql);

			st.setString(1, user_id);

			rs = st.executeQuery();
			
			while (rs.next()) {
				db_old_password = rs.getString(1);
				System.out.println("DB_old_password: " + db_old_password);
			}

			rs = null;

			if(old_password.equals(db_old_password) && new_password.equals(new_password_confirm)) {

				sql = "UPDATE bmr_users SET login_password = ? WHERE user_id = ?";
				
				st = cn.prepareStatement(sql);
					
				st.setString(1, new_password);
				st.setString(2, user_id);
		
				st.executeUpdate();

				System.out.println("Password changed.");
				message = "Password changed. ";
			
				req.setAttribute("message", message);
			
				RequestDispatcher dispatcher = req.getRequestDispatcher("main");
			
				dispatcher.forward(req,res);

			} else if(old_password.equals(db_old_password) == false) {
			
				System.out.println("Password change fail. Old password not match. ");
				message = "Password change fail. Old password not match. ";
				
				req.setAttribute("message", message);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("account");

				dispatcher.forward(req,res);

			} else if(new_password.equals(new_password_confirm) == false) {
			
				System.out.println("Password change fail. New password and new password confirm not match. ");
				message = "Password change fail. New password and new password confirm not match. ";
				
				req.setAttribute("message", message);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("account");

				dispatcher.forward(req,res);

			}

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
