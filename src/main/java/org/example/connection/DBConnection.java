package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection=null;
    public static Connection getConnection()  {//database ile islemek ucun olan metod
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/project-jdbc","root","07102002Vezife");
            System.out.println("Connection to database has succesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("database connection closed succesfully");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
