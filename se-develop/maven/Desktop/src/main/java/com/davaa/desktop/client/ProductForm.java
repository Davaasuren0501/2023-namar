package com.davaa.desktop.client;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.davaa.desktop.database.PostgreSQLConnection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();  
			 		frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ProductForm( int id_selected ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 29, 70, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(28, 49, 202, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 136, 202, 40);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(28, 115, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblUom = new JLabel("Uom");
		lblUom.setBounds(303, 29, 70, 15);
		contentPane.add(lblUom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 49, 202, 40);
		contentPane.add(textField_2);
		
		JLabel lblName_1_1 = new JLabel("Qty");
		lblName_1_1.setBounds(303, 115, 120, 15);
		contentPane.add(lblName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 136, 202, 40);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(28, 197, 477, 54);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setBounds(28, 263, 477, 54);
		contentPane.add(btnDelete);
		
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
            	System.out.println("call update button");
            	ActionUpdateAndDelete( "update",id_selected  );
            }
        });
		
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
            	System.out.println("call delete button");
            	ActionUpdateAndDelete( "delete",id_selected  );
            }
        });
		
    	String query = "Select * from product where id = ? ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id_selected);
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        int id = resultSet.getInt("id");
		        String name = resultSet.getString("name");
		        String uom = resultSet.getString("uom");
		        String tax = resultSet.getString("tax");
		        String price = resultSet.getString("price");
		        textField.setText(name);
		        textField_1.setText(price);
		        textField_2.setText(uom);
		        textField_3.setText(tax);
		        System.out.println( "id " + id + " name-"+name+ " uom-"+uom+" tax-"+tax );
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
	}

	/**
	 * Create the frame.
	 */
	public ProductForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 29, 70, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(28, 49, 202, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 136, 202, 40);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(28, 115, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblUom = new JLabel("Uom");
		lblUom.setBounds(303, 29, 70, 15);
		contentPane.add(lblUom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 49, 202, 40);
		contentPane.add(textField_2);
		
		JLabel lblName_1_1 = new JLabel("Qty");
		lblName_1_1.setBounds(303, 115, 120, 15);
		contentPane.add(lblName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 136, 202, 40);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(28, 242, 477, 54);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
            	System.out.println("call new button");
                ActionButton();
            }
        });
	}
	private void ActionUpdateAndDelete(String action, int id_select ) {
		if( action == "update" ) {

			int result = PostgreSQLConnection.UpdateProduct(
					textField.getText()
					, textField_2.getText()
					, textField_1.getText()
					, textField_3.getText() 
					, id_select
			);
			
			if( result > 0 ) {
                JOptionPane.showMessageDialog(contentPane,"Update product");
                ProductList productlist = new ProductList( );
                productlist.setVisible(true);
                this.dispose();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't update product");
			}
		} else {

			int result = PostgreSQLConnection.DeleteProduct(
					id_select
			);
			
			if( result > 0 ) {
                JOptionPane.showMessageDialog(contentPane,"Deleted product");
                ProductList productlist = new ProductList( );
                productlist.setVisible(true);
                this.dispose();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't delete product");
			}
		}
	}
	private void ActionButton() {
		if(textField.getText().length() > 0 && textField_1.getText().length() > 0 && textField_2.getText().length() > 0 && textField_3.getText().length() > 0 ) {
			System.out.println( "product name : " + textField.getText() );
			System.out.println( "product price : " + textField_1.getText() );
			System.out.println( "product uom : " + textField_2.getText() );
			System.out.println( "product tax : " + textField_3.getText() );
			int result = PostgreSQLConnection.CreateProductNew(
					textField.getText()
					, textField_2.getText()
					, textField_1.getText()
					, textField_3.getText()  
			);
			
			if( result > 0 ) {
                JOptionPane.showMessageDialog(contentPane,"Create product");
                ProductList productlist = new ProductList( );
                productlist.setVisible(true);
                this.dispose();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't create product");
			}
			
		} else {
			JOptionPane.showMessageDialog(contentPane,"Please fill in all");
		}
	}
}
