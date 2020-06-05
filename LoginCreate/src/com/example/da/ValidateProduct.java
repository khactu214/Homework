package com.example.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ValidateProduct {
    public static boolean insertProduct(String name, String pro){
        boolean st = true;
        try{
            Class.forName("com.mysql.jbdc.Driver");
            Connection con = DriverManager.getConnection("jbdc:mysql://localhost/127.0.0.1/phpMyadmin 5.0.2","root","");
            PreparedStatement ps = con.prepareStatement("insert into product (name ,pro) values(?,?)");
            ps.setString(1,name);
            ps.setString(2,pro);
            ps.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
}
