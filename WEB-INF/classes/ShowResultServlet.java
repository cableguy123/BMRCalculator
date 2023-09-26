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
		
		ArrayList<beans.Beans> list = new ArrayList<>();
		
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "bmr", "bmrpass");
			
			cn.setAutoCommit(false);
			
			String sql = "SELECT result_id, user_id, TO_CHAR(meal_date, 'YYYY-MM-DD'), meal_calories, bmr, tdee, result FROM results WHERE user_id = ? ORDER BY meal_date";
			
			st = cn.prepareStatement(sql);

			st.setString(1, "1");

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
		
		request.setAttribute("result", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result");
		
		dispatcher.forward(request,response);
    }
}
