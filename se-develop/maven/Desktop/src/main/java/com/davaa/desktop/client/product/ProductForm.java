package com.davaa.desktop.client.product;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.davaa.desktop.client.list.Form;
import com.davaa.desktop.database.PostgreSQLConnection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;

public class ProductForm extends JFrame implements Form {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblProductForm;
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
//					ProductForm frame = new ProductForm(1);  
					ProductForm frame = new ProductForm();  
			 		frame.setVisible(true); 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ProductForm( int id_selected ) {	
		UpdateView( id_selected );
		ActionRequestUpdate( id_selected );	
	}

	/**
	 * Create the frame.
	 */
	public ProductForm() {
		MainView();
	}

	@Override
	public void MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 53, 70, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();;
		textField.setBounds(28, 73, 202, 40);
		textField.setColumns(10);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 160, 202, 40);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(28, 139, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblUom = new JLabel("Uom");
		lblUom.setBounds(303, 53, 70, 15);
		contentPane.add(lblUom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 73, 202, 40);
		contentPane.add(textField_2);
		
		JLabel lblName_1_1 = new JLabel("Qty");
		lblName_1_1.setBounds(303, 139, 120, 15);
		contentPane.add(lblName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 160, 202, 40);
		contentPane.add(textField_3);
		
		JLabel lblNewProduct = new JLabel("New Product");
		lblNewProduct.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewProduct.setBounds(209, 12, 152, 29);
		contentPane.add(lblNewProduct);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBounds(28, 230, 477, 54);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
            	System.out.println("call new button");
            	ActionCreate();
            }
        });
	}
	
	@Override
	public void UpdateView( int id_selected ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(28, 49, 70, 15);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(28, 69, 202, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(28, 156, 202, 40);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(28, 135, 70, 15);
		contentPane.add(lblPrice);
		
		JLabel lblUom = new JLabel("Uom");
		lblUom.setBounds(303, 49, 70, 15);
		contentPane.add(lblUom);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(303, 69, 202, 40);
		contentPane.add(textField_2);
		
		JLabel lblName_1_1 = new JLabel("Qty");
		lblName_1_1.setBounds(303, 135, 120, 15);
		contentPane.add(lblName_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(303, 156, 202, 40);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(28, 228, 477, 54);
		contentPane.add(btnNewButton);
		
		btnDelete = new JButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setBounds(28, 314, 477, 54);
		contentPane.add(btnDelete);
		
		lblProductForm = new JLabel("Product form");
		lblProductForm.setFont(new Font("Dialog", Font.BOLD, 15));
		lblProductForm.setBounds(211, 12, 139, 25);
		contentPane.add(lblProductForm);
		
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
	}
	
	@Override
	public void ActionRequestNew() {

	}
	
	@Override
	public void ActionRequestUpdate( int id_selected ) {
		
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
	
	@Override
	public void ActionUpdateAndDelete(String action, int id_select ) {
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

	@Override
	public void ActionCreate() {
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
				ChangeList();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't create product");
			}
			
		} else {
			JOptionPane.showMessageDialog(contentPane,"Please fill in all");
		}
	}

	@Override
	public void ChangeList() {
		ProductList productlist = new ProductList( );
		productlist.setVisible(true);
		this.dispose();
	}
}
