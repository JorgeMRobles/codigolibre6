import java.sql.*;
import javax.swing.*;

public class MySQLConnect {
Connection conn = null;
public static Connection ConnectDb(){

    try{
    /*"C:\\Users\\WhatdoIhave\\quetengodb","root","" you replace it with your 
     * database's direction, XAMPP user, and XAMPP password
    as this form "direction, user, password" 
    */
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost/quetengodb","root","");
    return conn;
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;

    }
}
}