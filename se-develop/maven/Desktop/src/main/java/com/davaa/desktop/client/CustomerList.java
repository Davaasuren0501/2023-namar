package com.davaa.desktop.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.davaa.desktop.database.PostgreSQLConnection;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CustomerList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList frame = new CustomerList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 692, 356);
		contentPane.add(scrollPane);
		

		
		table = new JTable();
		
		DefaultTableModel model = new DefaultTableModel(
			    new String[] { "ID", "Name", "Phone", "Address", "Tax" }, 0); 

		table.setModel(model);
		scrollPane.setViewportView(table);

		String query = "Select * from customer ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        int id = resultSet.getInt("id");
		        String name = resultSet.getString("name");
		        String phone = resultSet.getString("phone");
		        String address = resultSet.getString("address");
		        String tax = resultSet.getString("tax");
		        System.out.println( "id " + id + " name-"+name+ " phone-"+phone+" address-"+address );
			        model.addRow(new Object[] { id, name, phone, address, tax });
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		
		table.getSelectionModel().addListSelectionListener(e->{
			if (!e.getValueIsAdjusting()) {
		        int selectedRow = table.getSelectedRow();
		        if (selectedRow >= 0) {
		            // Get the ID from the selected row
		            int selectedID = (int) model.getValueAt(selectedRow, 0);
	                ActionRow(selectedID);
		        }
		    }
		});
		
		JButton btnNew = new JButton("New ");

		btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
            	System.out.println("call new button");
                ActionButton();
            }
        });
		btnNew.setBounds(12, 47, 117, 37);
		contentPane.add(btnNew);
		
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Search ...");
		txtSearch.setBounds(193, 47, 421, 37);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
//		btnNewButton.setIcon(new ImageIcon("/home/davaa/source/2023-namar/se-develop/maven/icon_2.jpg"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(622, 47, 82, 37);
		contentPane.add(btnNewButton);
	}
	private void ActionRow( int rowId ) {
        System.out.println("Selected ID: " + rowId);
        CustomerForm form = new CustomerForm(rowId);
		form.setVisible(true);
		this.dispose();
	}
	private void ActionSearch( String data ) {
        System.out.println("Search: " + data);
		CustomerForm form = new CustomerForm( );
		form.setVisible(true);
		this.dispose();
	}
	private void ActionButton() {
		CustomerForm form = new CustomerForm();
		form.setVisible(true);
		this.dispose();
	}
}
