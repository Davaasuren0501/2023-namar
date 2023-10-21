package com.davaa.desktop.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import com.davaa.desktop.database.PostgreSQLConnection;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.BorderLayout;
import java.time.LocalDateTime;
public class SaleOrderForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JLabel lblQty;
	private JLabel lblProduct;
	private JLabel lblAddProduct;
	private JLabel lblPrice;
	private JTextField textField;

	
	DefaultTableModel model = new DefaultTableModel(
		    new String[] { "Name", "Price", "Qty", "Unit Price" }, 0); 

	 DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
	 DefaultComboBoxModel<String> comboBoxModelPartner = new DefaultComboBoxModel<>();
	 ArrayList<String> arrayList = new ArrayList<>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaleOrderForm frame = new SaleOrderForm();
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
	public SaleOrderForm() {
		String query = "Select * from product ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        String price = resultSet.getString("price");
		        // Add elements to the JComboBox
		        comboBoxModel.addElement(name);
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		String query2 = "Select * from customer ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query2)) {
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        // Add elements to the JComboBox
		        comboBoxModelPartner.addElement(name);
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
		MainView();
	}
	
	public void MainView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(367, 416, 117, 25);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(312, 44, 172, 24);
		comboBox.setModel(comboBoxModelPartner);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Partner");
		lblNewLabel.setBounds(312, 23, 102, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 23, 70, 15);
		contentPane.add(lblName);
		
		textField_1 = new JTextField("New");
		textField_1.setColumns(10);
		textField_1.setBounds(32, 45, 117, 24);
		contentPane.add(textField_1);
		
		JLabel lblTax = new JLabel("Tax : ");
		lblTax.setBounds(302, 368, 70, 15);
		contentPane.add(lblTax);
		
		JLabel lblTotal = new JLabel("Amount Total : ");
		lblTotal.setBounds(32, 368, 117, 15);
		contentPane.add(lblTotal);
		
		JLabel lblName_1_1 = new JLabel("Total : ");
		lblName_1_1.setBounds(292, 389, 70, 15);
		contentPane.add(lblName_1_1);
		
		JLabel lblName_2_1 = new JLabel("0.0 $");
		lblName_2_1.setBounds(146, 368, 70, 15);
		contentPane.add(lblName_2_1);
		
		JLabel lblName_2_1_1 = new JLabel("10.0 %");
		lblName_2_1_1.setBounds(366, 368, 70, 15);
		contentPane.add(lblName_2_1_1);
		
		JLabel lblName_2_1_1_1 = new JLabel("0.0 $");
		lblName_2_1_1_1.setBounds(366, 389, 70, 15);
		contentPane.add(lblName_2_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 139, 452, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.setBounds(32, 90, 452, 37);
		contentPane.add(btnAddProduct);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call add product button");
            	PopUp();
			}
		});

		int countAmount=0;
		for (int row = 0; row < model.getRowCount(); row++) {
	        Object cellValue = model.getValueAt(row, 3);
	        countAmount+=((Number) cellValue).intValue();
		}
		System.out.println("count " + countAmount + " $");
		lblName_2_1.setText(""+countAmount+ " $");
		lblName_2_1_1_1.setText(""+(countAmount+countAmount*10/100) + " $");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Customer name -->" + comboBox.getSelectedItem() );
				System.out.println( "Sale Order name -->" + textField_1.getText() );
				System.out.println( "Sale Order total -->" + lblName_2_1_1_1.getText() );
				LocalDateTime currentDateTime = LocalDateTime.now();
		        System.out.println("Current Date and Time: " + currentDateTime);
				int id_sale_order = PostgreSQLConnection.CreateSaleOrderNew(textField_1.getText(),comboBox.getSelectedItem().toString(), lblName_2_1_1_1.getText(),currentDateTime.toString() );
				System.out.println( "create sale order " + id_sale_order );
				if( id_sale_order > 0 ) {
					for (int row = 0; row < model.getRowCount(); row++) {
						String name = model.getValueAt(row, 0).toString();
						String price = model.getValueAt(row, 1).toString();
						String qty = model.getValueAt(row, 2).toString();
						int unit_price= ((Number) model.getValueAt(row, 3)).intValue();
					    System.out.println( "name--->" + name +"   price--->"+price+" qty---> " + qty + " unit_price --->"+unit_price );
						int rowCount = PostgreSQLConnection.CreateSaleOrderLineNew(id_sale_order,name,price, qty,""+unit_price );
					}
					JOptionPane.showMessageDialog(contentPane,"Create sale order");
					List();
				} else {
					JOptionPane.showMessageDialog(contentPane,"Sorry, Can't create sale order");
				}
				
			}
		});
	}
	
	public void List() {
		SaleOrderList soList = new SaleOrderList();
		soList.setVisible(true);
		this.dispose();
	}
	
	public void  PopUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 265, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 75, 229, 33);
		comboBox.setModel(comboBoxModel);
		
		
		
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(12, 220, 229, 33);
		contentPane.add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setBounds(12, 275, 229, 33);
		contentPane.add(btnNewButton_1);
		
		lblQty = new JLabel("Qty");
		lblQty.setBounds(12, 193, 70, 15);
		contentPane.add(lblQty);
		
		lblProduct = new JLabel(" Product name");
		lblProduct.setBounds(12, 48, 130, 15);
		contentPane.add(lblProduct);
		
		lblAddProduct = new JLabel("Add product");
		lblAddProduct.setBounds(84, 12, 130, 15);
		contentPane.add(lblAddProduct);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(12, 128, 70, 15);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 148, 229, 33);
		contentPane.add(textField);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	System.out.println("call add product button");
            	System.out.println(comboBox.getSelectedItem());
            	System.out.println(textField.getText());
            	System.out.println(textField_2.getText());
            	int priceUnit = Integer.parseInt(textField.getText()) * Integer.parseInt(textField_2.getText());
//            	System.out.println(priceUnit);
//            	String str = "" + priceUnit;
		        model.addRow(new Object[] { comboBox.getSelectedItem().toString(), textField.getText(),textField_2.getText(), priceUnit });
            	MainView();
			}
		});
	}
}
