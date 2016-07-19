/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alunos
 */
public class BaseDAO {
    Connection conn=null;
    static final String  CLUSTERNAME = "mycluster87";
    static final String CLUSTERADMIN = "admin";
    static final String CLUSTERPASSWORD = "Spzx1k74!!";
    
    public Connection getConnection(){
    
    try
    {
      //Load the HiveServer2 JDBC driver
      Class.forName("org.apache.hive.jdbc.HiveDriver");

      //Create the connection string
      // Note that HDInsight always uses the external port 443 for SSL secure
      //  connections, and will direct it to the hiveserver2 from there
      //  to the internal port 10001 that Hive is listening on.
      String connectionQuery = String.format(
        "jdbc:hive2://%s.azurehdinsight.net:443/default;ssl=true?hive.server2.transport.mode=http;hive.server2.thrift.http.path=/hive2",
        CLUSTERNAME);

      //Get the connection using the cluster admin user and password
      conn = DriverManager.getConnection(connectionQuery,CLUSTERADMIN,CLUSTERPASSWORD);  
    }
 
    catch(Exception ex)
    {
      System.out.println("Exceção na conexão: \n");
      ex.printStackTrace();
    }
    
    return conn;
    
}

public void closeConnection(){
    try{
    conn.close();
    }
    catch (SQLException e )
    {
      System.out.println("Exceção no encerramento da conexão: \n");
      e.printStackTrace();
    }
    
    
}

}