package com.davaa.desktop.client.product;
import java.sql.*;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.davaa.desktop.client.list.List;
import com.davaa.desktop.database.PostgreSQLConnection;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductList extends JFrame implements List {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSearch;
		
	private DefaultTableModel model = new DefaultTableModel( new String[] { "ID", "Name", "Uom", "Qty", "Price" }, 0); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
 		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		ActionRequst();
		InitComponent();
	}

	@Override	
	public void InitComponent() {

		table = new JTable();

		table.setModel(model);
		
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
		setBounds(100, 100, 715, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		JLabel lblCustomerList = new JLabel("Product List");
		lblCustomerList.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCustomerList.setBounds(290, 12, 135, 23);
		contentPane.add(lblCustomerList);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 692, 356);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionSearch( txtSearch.getText());
			}
		});
		btnNewButton.setBounds(622, 47, 82, 37);
		contentPane.add(btnNewButton);
	}

	
	@Override
	public void ActionRow( int rowId ) {
        System.out.println("Selected ID: " + rowId);
        ProductForm form = new ProductForm(rowId);
		form.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void ActionSearch( String data ) {
        System.out.println("Search: " + data);
		ProductList form = new ProductList( );
		form.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void ActionButton() {
		ProductForm form = new ProductForm();
		form.setVisible(true);
		this.dispose();
	}

	@Override
	public void ActionRequst() {
		
    	String query = "Select * from product ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
            ActionFormat( resultSet );
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		
	}
	
	private void ActionFormat(ResultSet resultSet ) {
		if( resultSet != null ) {
			try {
				while (resultSet.next()) {
					int id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String uom = resultSet.getString("uom");
					String tax = resultSet.getString("tax");
					String price = resultSet.getString("price");
					System.out.println( "id " + id + " name-"+name+ " uom-"+uom+" tax-"+tax );
					model.addRow(new Object[] { id, name, uom, tax, price });
				}
			}catch (SQLException ex) {
	            System.out.print( ex );
	        }
		}
	} 
}
