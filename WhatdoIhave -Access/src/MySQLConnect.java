import java.sql.*;
import javax.swing.*;
public class MySQLConnect {
Connection conn = null;
public static Connection ConnectDb(){

    try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    //"C:\\Users\\WhatdoIhave -Access\\quetengodb.accdb","root","" you replace it with your database's direction" 
    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\WhatdoIhave -Access\\quetengodb.accdb");
    return conn;
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;

    }
}
}