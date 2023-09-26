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

public class InsertMealDataServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		doGet(req, res);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		req.setCharacterEncoding("UTF-8");
		
        Connection cn = null;
        PreparedStatement st = null;
		ResultSet rs = null;
		
        String actLv = req.getParameter("activity_level");
        String calories = req.getParameter("calories");

		String user_gender = null;
		String user_age = null;
		String user_height = null;
		String user_weight = null;
        
        double bmr;
        double tdee;
		String result = null;

		Calculator calc = new Calculator();

		String message = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");

			cn.setAutoCommit(false);

			String sql = "SELECT user_gender, user_age, user_height, user_weight FROM bmr_users where user_id = 1";

			st = cn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				user_gender = rs.getString(1);
				user_age = rs.getString(2);
				user_height = rs.getString(3);
				user_weight = rs.getString(4);
				System.out.println("Gender: " + user_gender + "\t" + "Age: " + user_age + "\t" + "Height: " + user_height + "\t" + "Weight: " + user_weight);
			}

			calc.setBmr(user_gender, user_age, user_height, user_weight);
			calc.setTdee(Integer.parseInt(actLv));
			calc.setResult(Float.parseFloat(calories));
			bmr = calc.getBmr();
			tdee = calc.getTdee();
			result = calc.getResult();
			System.out.println("BMR: " + bmr + "\t" + "TDEE: " + tdee + "\t" + "Result: " + result);

			if(Float.parseFloat(calories) <= 5000) {
				sql = "INSERT INTO results VALUES(result_id_seq.nextval, ?, sysdate, ?, ?, ?, ?)";
				
				st = cn.prepareStatement(sql);
					
				st.setString(1, "1");
				st.setString(2, calories);
				st.setString(3, Double.toString(bmr));
				st.setString(4, Double.toString(tdee));
				st.setString(5, result);
		
				st.executeUpdate();

				/*System.out.println("");
				message = "";*/
			
				req.setAttribute("message", message);
			
				res.sendRedirect("showresultservlet");

			} else if(Float.parseFloat(calories) >= 5000) {
			
				/*System.out.println("");
				message = "";*/
				
				req.setAttribute("message", message);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("main");

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
