package com.davaa.desktop.client.customer;

import com.davaa.desktop.client.list.Form;
import com.davaa.desktop.database.PostgreSQLConnection;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class CustomerForm extends JFrame implements Form {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					CustomerForm frame = new CustomerForm();
					CustomerForm frame = new CustomerForm(1);
				 	frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerForm( int id_selected ) {
		UpdateView(id_selected);
	}

	/**
	 * Create the frame. 15
	 */
	public CustomerForm() {
		MainView();
	}
	
	@Override
	public void UpdateView( int id_selected ) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 500);
//		setBounds(100, 100, 485, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 74, 191, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(297, 74, 149, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 161, 271, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(352, 161, 94, 35);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call update button");
            	ActionUpdateAndDelete( "update",id_selected  );
			}
		});
		btnNewButton.setBounds(32, 224, 414, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 56, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(297, 56, 70, 15);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 140, 70, 15);
		contentPane.add(lblAddress);
		
		JLabel lblTaxId = new JLabel("Tax ID");
		lblTaxId.setBounds(352, 140, 70, 15);
		contentPane.add(lblTaxId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(32, 297, 414, 50);
		contentPane.add(btnDelete);
		
		JButton btnBack = new JButton("Back to list");
		btnBack.setBounds(32, 370, 414, 50);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call back button");
            	Actionback();
			}
		});
		
		JLabel lblCustomerForm = new JLabel("Customer Form");
		lblCustomerForm.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCustomerForm.setBounds(168, 12, 165, 32);
		contentPane.add(lblCustomerForm);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call delete button");
            	ActionUpdateAndDelete( "delete",id_selected  );
			}
		});
		ActionRequestUpdate(id_selected);
		
	}
	
	@Override
	public void MainView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(32, 63, 191, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(297, 63, 149, 35);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(32, 139, 271, 35);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(352, 139, 94, 35);
		contentPane.add(textField_3);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call update button");
                ActionCreate();
			}
		});
		btnNewButton.setBounds(32, 197, 414, 50);
		contentPane.add(btnNewButton);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 45, 70, 15);
		contentPane.add(lblName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(297, 45, 70, 15);
		contentPane.add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(32, 118, 70, 15);
		contentPane.add(lblAddress);
		
		JLabel lblTaxId = new JLabel("Tax ID");
		lblTaxId.setBounds(352, 118, 70, 15);
		contentPane.add(lblTaxId);
		
		JLabel lblCustomerCreate = new JLabel("New  Customer");
		lblCustomerCreate.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCustomerCreate.setBounds(179, 12, 162, 15);
		contentPane.add(lblCustomerCreate);
	}
	
	@Override
	public void ActionRequestUpdate( int id_selected) {
    	String query = "Select * from customer where id = ? ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id_selected);
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        int id = resultSet.getInt("id");
		        String name = resultSet.getString("name");
		        String phone = resultSet.getString("phone");
		        String address = resultSet.getString("address");
		        String tax = resultSet.getString("tax");
		        textField.setText(name);
		        textField_1.setText(phone);
		        textField_2.setText(address);
		        textField_3.setText(tax);
		        System.out.println( "id " + id + " name-"+name+ " phone-"+phone+" address-"+address );
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
	}
	
	@Override
	public void ActionCreate() {
		if(textField.getText().length() > 0 && textField_1.getText().length() > 0 && textField_2.getText().length() > 0 && textField_3.getText().length() > 0 ) {
			System.out.println( "customer name : " + textField.getText() );
			System.out.println( "customer phone : " + textField_1.getText() );
			System.out.println( "customer address : " + textField_2.getText() );
			System.out.println( "customer tax : " + textField_3.getText() );
			 int result = PostgreSQLConnection.CreateCustomerNew(
			 		textField.getText()
			 		, textField_1.getText()
			 		, textField_2.getText()
			 		, textField_3.getText()
			 );

			if( result > 0 ) {
               JOptionPane.showMessageDialog(contentPane,"Create customer");
			   ChangeList();
			} else {
               JOptionPane.showMessageDialog(contentPane,"Sorry, Can't create customer");
			}
			
		} else {
			JOptionPane.showMessageDialog(contentPane,"Please fill in all");
		}
	}
	@Override
	public void ChangeList() {
		CustomerList customerlist = new CustomerList( );
		customerlist.setVisible(true);
		this.dispose();
	}
	@Override
	public void ActionUpdateAndDelete(String action, int id_select ) {
		if( action == "update" ) {

			int result = PostgreSQLConnection.UpdateCustomer(
					textField.getText()
					, textField_1.getText()
					, textField_2.getText()
					, textField_3.getText() 
					, id_select
			);
			
			if( result > 0 ) {
                JOptionPane.showMessageDialog(contentPane,"Update customer");
                CustomerList customerlist = new CustomerList( );
                customerlist.setVisible(true);
                this.dispose();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't update customer");
			}
		} else {

			int result = PostgreSQLConnection.DeleteCustomer(
					id_select
			);
			
			if( result > 0 ) {
                JOptionPane.showMessageDialog(contentPane,"Deleted customer");
                CustomerList customerlist = new CustomerList( );
                customerlist.setVisible(true);
                this.dispose();
			} else {
                JOptionPane.showMessageDialog(contentPane,"Sorry, Can't delete customer");
			}
		}
	}
	@Override
	public void ActionRequestNew( ) {}
	
	private void Actionback() {
		CustomerList pageCustomerList = new CustomerList();
		pageCustomerList.setVisible(true);
		this.dispose();
	}
}
