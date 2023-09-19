package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
  Connection cn;
  public DBConnection(String user,String password) {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,password);
      System.out.println("ê⁄ë±äÆóπ");
    }catch(ClassNotFoundException e) {
      e.printStackTrace();
    }catch(SQLException e) {
      e.printStackTrace();
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
  public Connection getCn() {
    return cn;
  }
}
