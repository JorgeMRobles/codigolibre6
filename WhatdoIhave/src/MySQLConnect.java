import java.sql.*;
import javax.swing.*;

public class MySQLConnect {
Connection conn = null;
public static Connection ConnectDb(){

    try{
    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
    /*"C:\\Users\\WhatdoIhave\\quetengodb.accdb","root","" you replace it with your 
     * database's direction, XAMPP user, and XAMPP password
    as this form "direction, user, password" 
    */
    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\WhatdoIhave\\quetengodb.accdb","root","");
    return conn;
    }catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;

    }
}
}