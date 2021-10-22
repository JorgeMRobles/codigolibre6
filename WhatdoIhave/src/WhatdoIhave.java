import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class WhatdoIhave extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	Color specialcolor = new Color (124, 246, 154);
	Color specialcolor2 = new Color (78, 198, 107);
	Color specialcolor3 = new Color (8, 133, 39);
	private JTextField NombreField;
	private JTextField CantidadField;
	private JTextField LugarField;
	
	String conString = "jdbc:mysql://Localhost/quetengodb";
	String usernombre = "root";
	String password = "";
	
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
	
	private void retrieve()
    {
     DefaultTableModel dm = new CRUD().getData();
     table.setModel(dm);
    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhatdoIhave frame = new WhatdoIhave();
					frame.setVisible(true);				 
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WhatdoIhave() {
		setTitle("What do I have!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel paneltable = new JPanel();
		paneltable.setBounds(0, 0, 493, 455);
		contentPane.add(paneltable);
		paneltable.setBackground(specialcolor);
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Id");
	    model.addColumn("Nombre");
	    model.addColumn("Cantidad");
	    model.addColumn("Lugar");
	    table.setModel(model);
	    table.setBounds(49, 45, 402, -44);
		contentPane.add(table);
		table.setBackground(Color.LIGHT_GRAY);
	    table.setForeground(Color.black);
	    Font font = new Font("",1,15);
	    table.setFont(font);
	    table.setRowHeight(20);
	    table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }

			private void tableMouseClicked(MouseEvent evt) {
				String nombre = table.getValueAt(table.getSelectedRow(), 1).toString();
		        String cant = table.getValueAt(table.getSelectedRow(), 2).toString();
		        String lugar = table.getValueAt(table.getSelectedRow(), 3).toString();
		        NombreField.setText(nombre);
		        CantidadField.setText(cant);
		        LugarField.setText(lugar);
			}
        });
	    JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(285, 0, 495, 200);
	    paneltable.add(pane);
	    
	    String[] dato = new String[4];
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    Connection conn = DriverManager.getConnection("jdbc:mysql://Localhost/quetengodb","root","");
			    String query1="select * from quetengotable ORDER BY nombre ASC";
			    Statement st = conn.createStatement();
			    ResultSet rs = st.executeQuery(query1);
			    
			    while(rs.next()) {
			    	dato[0] = rs.getString(1);
			    	dato[1] = rs.getString(2);
			    	dato[2] = rs.getString(3);
			    	dato[3] = rs.getString(4);
			    	model.addRow(dato);
			    }
			    } catch (ClassNotFoundException e) {
			    	// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		conn=MySQLConnect.ConnectDb();
		getContentPane().setBackground(specialcolor);
		
		JPanel panel = new JPanel();
		panel.setBounds(503, 0, 183, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBackground(specialcolor2);
		
		NombreField = new JTextField();
		NombreField.setBounds(72, 40, 86, 20);
		panel.add(NombreField);
		NombreField.setColumns(10);
		
		CantidadField = new JTextField();
		CantidadField.setBounds(72, 71, 86, 20);
		panel.add(CantidadField);
		CantidadField.setColumns(10);
		
		LugarField = new JTextField();
		LugarField.setBounds(72, 102, 86, 20);
		panel.add(LugarField);
		LugarField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(16, 43, 46, 14);
		panel.add(lblNombre);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 74, 62, 14);
		panel.add(lblCantidad);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(16, 105, 46, 14);
		panel.add(lblLugar);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setBounds(10, 142, 163, 14);
		panel.add(lblMensaje);
		
		JPanel panelbtn = new JPanel();
		panelbtn.setBounds(0, 167, 123, 110);
		panel.add(panelbtn);
		panelbtn.setBackground(specialcolor3);
		panelbtn.setLayout(null);
		
		JButton btnAñadir = new JButton("Add");
		btnAñadir.setBounds(10, 11, 100, 23);
		panelbtn.add(btnAñadir);
		btnAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	addBtnActionPerformed(evt);
            }

			private void addBtnActionPerformed(ActionEvent evt) {
				
				if (new CRUD().add(NombreField.getText(), CantidadField.getText(), LugarField.getText())) {
					lblMensaje.setText("Inserted");

			            NombreField.setText("");
			            CantidadField.setText("");
			            LugarField.setText("");
			            
			            retrieve();
			        } else {
			            JOptionPane.showMessageDialog(null, "Didn't work");
			        }
			}
        });
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	updateBtnActionPerformed(evt);
            }

			private void updateBtnActionPerformed(ActionEvent evt) {
				int index = table.getSelectedRow();
		        String id = table.getValueAt(index, 0).toString();

		        if (new CRUD().update(id, NombreField.getText(), CantidadField.getText(), LugarField.getText())) {
		        	lblMensaje.setText("Updated");

		            NombreField.setText("");
		            CantidadField.setText("");
		            LugarField.setText("");

		            retrieve();
		        } else {
		            JOptionPane.showMessageDialog(null, "Didn't work");
		            }
			}
        });
		btnUpdate.setBounds(10, 45, 100, 23);
		panelbtn.add(btnUpdate);
		
		JButton btnEliminar = new JButton("Delete");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				 DeleteActionPerformed(evt);
			}

			private void DeleteActionPerformed(ActionEvent evt) {
				 String[] options = {"Yes", "No"};
			        int answ = JOptionPane.showOptionDialog(null, "Are you sure do you want to erase it?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

			        if (answ == 0) {
			            int index = table.getSelectedRow();
			            String id = table.getValueAt(index, 0).toString();

			            if (new CRUD().delete(id)) {
			            	lblMensaje.setText("Deleted");

			                //CLEAR TXT
			                NombreField.setText("");
			                CantidadField.setText("");
			                LugarField.setText("");

			           retrieve();
			            } else
			            {
			                JOptionPane.showMessageDialog(null, "Didn't work");
			            }

			        }
				
			}
		});
		btnEliminar.setBounds(10, 74, 100, 21);
		panelbtn.add(btnEliminar);
		
		JButton btnSumar = new JButton("+");
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumarBtnActionPerformed(e);
				updateBtnActionPerformed(e);
			}

			private void sumarBtnActionPerformed(ActionEvent e) {
				int suma = Integer.parseInt(CantidadField.getText()) + 1;
				String sumastr = String.valueOf(suma);
				CantidadField.setText(sumastr);
			}
			private void updateBtnActionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
		        String id = table.getValueAt(index, 0).toString();

		        if (new CRUD().update(id, NombreField.getText(), CantidadField.getText(), LugarField.getText())) {
		            lblMensaje.setText("Uploaded");

		            NombreField.setText("");
		            CantidadField.setText("");
		            LugarField.setText("");

		            retrieve();
		        } else {
		            JOptionPane.showMessageDialog(null, "Didn't work");
		            }
			}
		});
		btnSumar.setBounds(503, 334, 76, 113);
		contentPane.add(btnSumar);
		
		JButton btnRestar = new JButton("-");
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restarBtnActionPerformed(e);
				updateBtnActionPerformed(e);
			}

			private void restarBtnActionPerformed(ActionEvent e) {
				int resta = Integer.parseInt(CantidadField.getText()) - 1;
				if (Integer.parseInt(CantidadField.getText()) <= 0) {
					resta = 0;
				}
				String restastr = String.valueOf(resta);
				CantidadField.setText(restastr);
			}
			private void updateBtnActionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
		        String id = table.getValueAt(index, 0).toString();

		        if (new CRUD().update(id, NombreField.getText(), CantidadField.getText(), LugarField.getText())) {
		        	lblMensaje.setText("Uploaded");

		            NombreField.setText("");
		            CantidadField.setText("");
		            LugarField.setText("");

		            retrieve();
		        } else {
		            JOptionPane.showMessageDialog(null, "Didn't work");
		            }
			}
		});
		btnRestar.setBounds(589, 334, 76, 113);
		contentPane.add(btnRestar);
		}	
}

