package jdbc;


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
      cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
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
