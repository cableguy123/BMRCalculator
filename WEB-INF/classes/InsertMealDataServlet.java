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
		IsValidCalories isValid = new IsValidCalories();
		DBConnection dbc = new DBConnection();

		String message = null;
		String user_id = req.getParameter("user_id");
        System.out.println("user_id: " + user_id);

		try {
			cn = dbc.getConnection();

			cn.setAutoCommit(false);

			String sql = "SELECT user_gender, user_age, user_height, user_weight FROM bmr_users where user_id = ?";

			st = cn.prepareStatement(sql);

			st.setString(1, user_id);
			
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

			if(isValid.isValidCalories(calories)) {
				sql = "INSERT INTO results VALUES(result_id_seq.nextval, ?, sysdate, ?, ?, ?, ?)";
				
				st = cn.prepareStatement(sql);
					
				st.setString(1, user_id);
				st.setString(2, calories);
				st.setString(3, Double.toString(bmr));
				st.setString(4, Double.toString(tdee));
				st.setString(5, result);
		
				st.executeUpdate();
			
				res.sendRedirect("showresultservlet?user_id=" + user_id);

			} else {
				System.out.println("Please input calories between 0 and 5000.");
				message = "Please input calories between 0 and 5000.";
				
				req.setAttribute("message", message);
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("main");
				
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
