import jdbc.DBConnection;

import java.util.ArrayList;

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

public class ShowResultServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        
        Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String user_id = request.getParameter("user_id");
        System.out.println("user_id: " + user_id);
		
		ArrayList<beans.Beans> list = new ArrayList<>();

		DBConnection dbc = new DBConnection();
		
		try {
			cn = dbc.getConnection();
			
			cn.setAutoCommit(false);
			
			String sql = "SELECT result_id, user_id, TO_CHAR(meal_date, 'YYYY-MM-DD'), meal_calories, bmr, tdee, result FROM results WHERE user_id = ? ORDER BY meal_date";
			
			st = cn.prepareStatement(sql);

			st.setString(1, user_id);

			rs = st.executeQuery();
			
			while (rs.next()) {
				beans.Beans beans = new beans.Beans();
				
				beans.setResult_id(rs.getInt(1));
                beans.setUser_id(rs.getInt(2));
                beans.setMeal_date(rs.getString(3));
                beans.setMeal_calories(rs.getFloat(4));
                beans.setBmr(rs.getFloat(5));
                beans.setTdee(rs.getFloat(6));
                beans.setResult(rs.getString(7));
	
				list.add(beans);
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
		
		request.setAttribute("result", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result");
		
		dispatcher.forward(request,response);
    }
}
