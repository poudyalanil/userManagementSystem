/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author goani
 */
public class JdbcRegisterService {
    private static String driver = "com.mysql.cj.jdbc.Driver";
    // metrix the name of database created
    private static String url = "jdbc:mysql://localhost:3306/metrix?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String username = "root";
    private static String password = ""; 
    
    
    public static void userRegister(User user){
        
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,username,password);
            String sql = "INSERT INTO user (firstname,middlename,lastname,address,email,password) VALUES (?,?,?,?,?,?);";
            PreparedStatement ps =  con.prepareStatement(sql);
            
            ps.setString(1,user.getFirst_name());
            ps.setString(2,user.getMiddle_name());
            ps.setString(3,user.getLast_name());
            ps.setString(4,user.getAddress());
            ps.setString(5,user.getEmail());
            ps.setString(6,user.getPassword2());
            
            ps.executeUpdate();
            
            return;
            
        }catch(Exception e){
           System.out.println(e);
        }
        
        
    }
    
}
