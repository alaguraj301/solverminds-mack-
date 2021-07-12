package seleniumpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQL {

	private static String dbusername;
    private static String dbpassword;

    //Should be defined as jdbc:mysql://host:port/database name
    private static String databaseURLTesting= "jdbc:mysql://192.168.11.201:3306/mackproc";
    private static String databaseURLSTAGE= "jdbc:mysql://192.168.104.75:3306/mackproc";
    private static String databaseURLPRODUCTION= "jdbc:mysql://192.168.104.75:3306/mackproc";


    public static String executeSQLQuery(String testEnv, String sqlQuery) {
        String connectionUrl="";
        Connection connection;
        String resultValue = "";
        ResultSet rs;

        //To connect with QA Database
        if(testEnv.equalsIgnoreCase("Testing")){
            connectionUrl = databaseURLTesting;
            dbusername = "Read";
            dbpassword = "R#@d1234";
        }
        //To connect with Stage Database
        else if(testEnv.equalsIgnoreCase("Staging")) {
            connectionUrl = databaseURLSTAGE;
            dbusername = "Read";
            dbpassword = "R#@d123";
        }

        //To connect with Production Database
        else if(testEnv.equalsIgnoreCase("PRODUCTION")) {
            connectionUrl = databaseURLPRODUCTION;
            dbusername = "Read";
            dbpassword = "R#@d123";
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
            if(connection!=null) {
                System.out.println("Connected to the database...");
            }else {
                System.out.println("Database connection failed to "+testEnv+" Environment");
            }
            Statement stmt = connection.createStatement();
            rs=stmt.executeQuery(sqlQuery);

            try {
                while(rs.next()){
                    resultValue = rs.getString(1).toString();
                    
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch (NullPointerException err) {
                System.out.println("No Records obtained for this specific query");
                err.printStackTrace();
            }
            connection.close();

        }catch(SQLException sqlEx) {
            System.out.println( "SQL Exception:" +sqlEx.getStackTrace());
        }
        return resultValue;
    }


    



}
