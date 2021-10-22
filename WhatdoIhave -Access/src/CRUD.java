import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class CRUD {

    String conString = "jdbc:mysql://Localhost/quetengodb";
    String usernombre = "root";
    String password = "";
    
    //INSERT INTO DB
    public Boolean add(String nombre, String cant, String lugar) {
        String sql = "INSERT INTO quetengotable(nombre,cantidad,lugar) VALUES('" + nombre + "','" + cant + "','" + lugar + "')";

        try {
            Connection con = DriverManager.getConnection(conString, usernombre, password);
            Statement s = con.prepareStatement(sql);

            s.execute(sql);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //RETRIEVE DATA
    public DefaultTableModel getData() {
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("Id");
        dm.addColumn("Nombre");
        dm.addColumn("Cantidad");
        dm.addColumn("Lugar");

        String sql = "SELECT * FROM quetengotable ORDER BY nombre ASC";

        try {
            Connection con = DriverManager.getConnection(conString, usernombre, password);
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
            	String id = rs.getString(1);
                String nombre = rs.getString(2);
                String cant = rs.getString(3);
                String lugar = rs.getString(4);

                dm.addRow(new String[]{id, nombre, cant, lugar});
            }

            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }

    //UPDATE DATA
    public Boolean update(String id, String nombre, String cant, String lugar) {
        String sql = "UPDATE quetengotable SET nombre ='" + nombre + "',cantidad='" + cant + "',lugar='" + lugar + "' WHERE ID='" + id + "'";

        try {
            Connection con = DriverManager.getConnection(conString, usernombre, password);
            Statement s = con.prepareStatement(sql);

            s.execute(sql);

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //DELETE DATA
    public Boolean delete(String id)
    {
        String sql="DELETE FROM quetengotable WHERE ID ='"+id+"'";

        try
        {
            Connection con=DriverManager.getConnection(conString, usernombre, password);
            Statement s=con.prepareStatement(sql);

            s.execute(sql);

            return true;

        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

}