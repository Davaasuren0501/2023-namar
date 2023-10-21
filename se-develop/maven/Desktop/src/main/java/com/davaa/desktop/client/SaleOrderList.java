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

public class SaleOrderList extends JFrame {

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
					SaleOrderList frame = new SaleOrderList();
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
	public SaleOrderList() {
		
		table = new JTable();
		DefaultTableModel model = new DefaultTableModel(
			    new String[] { "ID", "Name", "Partner", "Date", "Total", "State" }, 0); 

		table.setModel(model);
		String query = "Select * from sale_order ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        int id = resultSet.getInt("id");
		        String name = resultSet.getString("name");
		        String partner = resultSet.getString("partner_name");
		        String date = resultSet.getString("date");
		        String total = resultSet.getString("total");
		        String state = resultSet.getString("state");
		        System.out.println( "id " + id + " name-"+name+ " partner-"+partner+" date-"+date );
			        model.addRow(new Object[] { id, name, partner, date, total, state });
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


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 692, 356);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnNew = new JButton("New ");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(622, 47, 82, 37);
		contentPane.add(btnNewButton);
	}
	private void ActionRow( int rowId ) {
        // System.out.println("Selected ID: " + rowId);
        // SaleOrderForm form = new SaleOrderForm(rowId);
		// form.setVisible(true);
		// this.dispose();
	}
	private void ActionSearch( String data ) {
        System.out.println("Search: " + data);
		SaleOrderList form = new SaleOrderList( );
		form.setVisible(true);
		this.dispose();
	}
	private void ActionButton() {
		SaleOrderForm form = new SaleOrderForm();
		form.setVisible(true);
		this.dispose();
	}
}
