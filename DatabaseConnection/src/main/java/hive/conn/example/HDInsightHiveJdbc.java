package hive.conn.example;

import dataBase.BaseDAO;
import java.sql.*;

public class HDInsightHiveJdbc {
  public static void main(String[] args) throws SQLException {


    //Variables to hold statements, connection, and results
    Connection conn=null;
    Statement stmt = null;
    ResultSet res = null;
    BaseDAO DAO = new BaseDAO();

    try
    { 
        System.out.println("Connecting..");
      //Get the connection using the BaseDAO class
      conn = DAO.getConnection();
 
      //Retrieve data from the table
      String sql = "SELECT * from Climate LIMIT 5";
      
      System.out.println("Running the query: \"SELECT * from Climate LIMIT 5\"");
      stmt = conn.createStatement();
      System.out.println("\nRetrieving data:");

      res = stmt.executeQuery(sql);

      while (res.next()) {
        System.out.println("Column0 => "+res.getString(1)+" Column1 => "+res.getString(2) + " Column2 => "+res.getString(3) +" Column3 => "+res.getString(4));
      }
      System.out.println("\nHive queries completed successfully!");
    }

    //Catch exceptions
    catch (SQLException e )
    {
      e.getMessage();
      e.printStackTrace();
      System.exit(1);
    }
   
    //Close connections
    finally {
      if (res!=null) res.close();
      if (stmt!=null) stmt.close();
      DAO.closeConnection();
    }
  }
}
