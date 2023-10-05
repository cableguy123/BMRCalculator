package jdbc;
<<<<<<< HEAD

=======
>>>>>>> 94fe0c62b676f6510e87a0ca9f4b6545a206d10e

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBConnection {
  Connection cn = null;
  ResultSet rs = null;
  Statement st = null;
  public DBConnection() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","bmr","bmrpass");
    }catch(ClassNotFoundException e) {
      e.printStackTrace();
    }catch(SQLException e) {
      e.printStackTrace();
    }catch(Exception e) {
      e.printStackTrace();
    }finally {
      System.out.println("Successful");
    }
    
  }
  public Connection getConnection() {
    return cn;
  }
}
