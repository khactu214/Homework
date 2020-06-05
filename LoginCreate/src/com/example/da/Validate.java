package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
    public static boolean checkUser(String username,String password){
        boolean st = false;
        try{
            Class.forName("com.mysql.jbdc.Driver");
            Connection con = DriverManager.getConnection("jbdc:mysql://localhost/127.0.0.1/phpMyadmin 5.0.2","root","");
            PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
}
