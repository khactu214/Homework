package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
    private static Connection connection;

    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if (connection == null){
            Class.forName("com.mysql.jbdc.Driver");
            connection = DriverManager.getConnection("jbdc:mysql://localhost/127.0.0.1/phpMyadmin 5.0.2","root","");
        }
        return connection;
    }
}
