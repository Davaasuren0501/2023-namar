package com.davaa.desktop.client.sale_order;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import com.davaa.desktop.client.list.Form;
import com.davaa.desktop.database.PostgreSQLConnection;

import java.util.ArrayList;

import java.time.LocalDateTime;

public class SaleOrderForm extends JFrame implements Form {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_2;
	private JLabel lblQty, lblAmount;
	private JLabel lblProduct;
	private JLabel lblAddProduct;
	private JLabel lblPrice;
	private JTextField textField;
	private JLabel lblTotal;
	private JComboBox<String> comboBoxMain, comboBoxPopup;
	private JButton btnSaleOrder;
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
//					SaleOrderForm frame = new SaleOrderForm();
					SaleOrderForm frame = new SaleOrderForm(1);
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
		ActionRequestNew();
		MainView();
	}

	public SaleOrderForm( int id_selected ) {
		UpdateView(id_selected);
		ActionRequestUpdate(id_selected);
		ActionGet(id_selected);
		ActionRequestNew();
	}

	@Override	
	public void MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBackground(Color.GREEN);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBounds(367, 416, 117, 25);
		
		comboBoxMain = new JComboBox();
		contentPane.add(btnCreate);
		contentPane.add(comboBoxMain);
		
		comboBoxMain.setModel(comboBoxModelPartner);
		comboBoxMain.setBounds(312, 44, 172, 24);
		
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
		
		JLabel lblTotalAmount = new JLabel("Amount Total : ");
		lblTotalAmount.setBounds(32, 368, 117, 15);
		contentPane.add(lblTotalAmount);
		
		JLabel lblName_1_1 = new JLabel("Total : ");
		lblName_1_1.setBounds(292, 389, 70, 15);
		contentPane.add(lblName_1_1);
		
		JLabel lblName_2_1 = new JLabel("0.0 $");
		lblName_2_1.setBounds(146, 368, 70, 15);
		contentPane.add(lblName_2_1);
		
		JLabel lblName_2_1_1 = new JLabel("10.0 %");
		lblName_2_1_1.setBounds(366, 368, 70, 15);
		contentPane.add(lblName_2_1_1);
		
		lblTotal = new JLabel("0.0 $");
		lblTotal.setBounds(366, 389, 70, 15);
		contentPane.add(lblTotal);
		
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
		lblTotal.setText(""+(countAmount+countAmount*10/100) + " $");

		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionCreate();
			}
		});
	}
	
	@Override	
	public void UpdateView(int id_selected) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setBackground(Color.GREEN);
		btnupdate.setForeground(Color.WHITE);
		btnupdate.setBounds(367, 416, 117, 25);
		contentPane.add(btnupdate);
		
		JButton btnback = new JButton("Back to list");
		btnback.setBounds(32, 416, 117, 25);
		contentPane.add(btnback);
		
		btnSaleOrder = new JButton("Sale Order");
		btnSaleOrder.setBounds(200, 416, 117, 25);
		contentPane.add(btnSaleOrder);
		btnSaleOrder.setBackground(Color.BLUE);
		btnSaleOrder.setForeground(Color.WHITE);
		
		comboBoxMain = new JComboBox();
		contentPane.add(comboBoxMain);
		
		comboBoxMain.setModel(comboBoxModelPartner);
		comboBoxMain.setBounds(312, 44, 172, 24);
		
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
		
		JLabel lblTotalAmount = new JLabel("Amount Total : ");
		lblTotalAmount.setBounds(32, 368, 117, 15);
		contentPane.add(lblTotalAmount);
		
		JLabel lblName_1_1 = new JLabel("Total : ");
		lblName_1_1.setBounds(292, 389, 70, 15);
		contentPane.add(lblName_1_1);
		
		lblAmount = new JLabel("0.0 $");
		lblAmount.setBounds(146, 368, 70, 15);
		contentPane.add(lblAmount);
		
		JLabel lblName_2_1_1 = new JLabel("10.0 %");
		lblName_2_1_1.setBounds(366, 368, 70, 15);
		contentPane.add(lblName_2_1_1);
		
		lblTotal = new JLabel("0.0 $");
		lblTotal.setBounds(366, 389, 70, 15);
		contentPane.add(lblTotal);
		
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
            	PopUp();
			}
		});

		int countAmount=0;
		for (int row = 0; row < model.getRowCount(); row++) {
	        Object cellValue = model.getValueAt(row, 3);
	        countAmount+=((Number) cellValue).intValue();
		}
		System.out.println("count " + countAmount + " $");
		lblAmount.setText(""+countAmount+ " $");
		lblTotal.setText(""+(countAmount+countAmount*10/100) + " $");

		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ActionCreate();
			}
		});

		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actionback();
			}
		});
		btnSaleOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String state = btnSaleOrder.getText();
				System.out.println(state);
				ActionUpdateState(state, id_selected);
			}
		});
	}
	@Override
	public void ActionUpdateAndDelete(String action, int id_select ) {

	}

	@Override
	public void ChangeList() {
		SaleOrderList soList = new SaleOrderList();
		soList.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void ActionCreate() {
		System.out.println( "Customer name -->" + comboBoxMain.getSelectedItem() );
		System.out.println( "Sale Order name -->" + textField_1.getText() );
		System.out.println( "Sale Order total -->" + lblTotal.getText() );
		LocalDateTime currentDateTime = LocalDateTime.now();
		System.out.println("Current Date and Time: " + currentDateTime);
		int id_sale_order = PostgreSQLConnection.CreateSaleOrderNew(textField_1.getText(),comboBoxMain.getSelectedItem().toString(), lblTotal.getText(),currentDateTime.toString() );
		System.out.println( "create sale order " + id_sale_order );
		if( id_sale_order > 0 ) {
			for (int row = 0; row < model.getRowCount(); row++) {
				String name = model.getValueAt(row, 0).toString();
				String price = model.getValueAt(row, 1).toString();
				String qty = model.getValueAt(row, 2).toString();
				int unit_price= ((Number) model.getValueAt(row, 3)).intValue();
				System.out.println( "name--->" + name +"   price--->"+price+" qty---> " + qty + " unit_price --->"+unit_price );
				int rowCount = PostgreSQLConnection.CreateSaleOrderLineNew(id_sale_order,name,price, qty,""+unit_price );
				System.out.println( "create sale order line  " + rowCount );
			}
			
			JOptionPane.showMessageDialog(contentPane,"Create sale order");
			ChangeList();
		} else {
			JOptionPane.showMessageDialog(contentPane,"Sorry, Can't create sale order");
		}
	}

	@Override
	public void ActionRequestNew() {
		String query = "Select * from product ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        String price = resultSet.getString("price");
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
		        comboBoxModelPartner.addElement(name);
		    }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
	}
	private void ActionGet(int id_selected) {
		int total_line = 0;
    	String queryLine = "Select * from sale_order_line where order_id = ? ";
    	System.out.print(queryLine);
    	try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst1 = con.prepareStatement(queryLine)){
    		pst1.setInt(1, id_selected);
    		ResultSet resultSet2 = pst1.executeQuery();
	    	System.out.println(resultSet2);
            while (resultSet2.next()) {
		        String name = resultSet2.getString("name");
		        String price = resultSet2.getString("price");
		        String qty = resultSet2.getString("qty");
		        String total_unit = resultSet2.getString("total_unit");
		        total_line += Integer.valueOf(total_unit);
		        System.out.println( "name = "+name + " total = " + total_unit + " qty = "+ qty  + "total " + total_line);
		        lblAmount.setText( "" +total_line );
				model.addRow(new Object[] { name, price,qty, total_unit });
		    }
	    	System.out.println("sda");
    	}catch (SQLException ex) {
            System.out.println( ex );
        }
    	System.out.println(queryLine);
	}
	@Override
	public void ActionRequestUpdate( int id_selected ) {
		
    	String query = "Select * from sale_order where id = ? ";
		try (Connection con = DriverManager.getConnection(PostgreSQLConnection.db_url, PostgreSQLConnection.db_user, PostgreSQLConnection.db_password);
	             PreparedStatement pst = con.prepareStatement(query)) {
			pst.setInt(1, id_selected);
            ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
		        String name = resultSet.getString("name");
		        String total = resultSet.getString("total");
		        String partner_name = resultSet.getString("partner_name");
		        String state = resultSet.getString("state");
		        System.out.println( "name = "+name + " total = " + total + " partner = "+ partner_name );
		        textField_1.setText(name);
		        lblTotal.setText(total);
		        lblAmount.setText( "25 " + "$" );
		        if( state.equals("Draft") ) {
		        	btnSaleOrder.setText( "Quotation" );
		        } else {
		        	if( state.equals("Quotation") ) {
			        	btnSaleOrder.setText( "Sale Order" );
		        	} else {
			        	if( state.equals("Sale Order") ) {
				        	btnSaleOrder.setText( "Delivery" );
			        	} else {
				        	if( state.equals("Delivery") ) {
					        	btnSaleOrder.setText( "Done" );
				        	} else {
				        		if( state.equals("Done") ) {
				        			contentPane.remove(btnSaleOrder);
				        		}
				        	}
			        	}
		        	}
		        }
		        comboBoxModelPartner.addElement(partner_name);
		    }
			
        } catch (SQLException ex) {
            System.out.print( ex );
        }
	}

	private void  PopUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBoxPopup = new JComboBox();
		comboBoxPopup.setBounds(25, 77, 229, 33);
		comboBoxPopup.setModel(comboBoxModel);
		contentPane.add(comboBoxPopup);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(25, 222, 229, 33);
		contentPane.add(textField_2);
		
		JButton btnAddProduct = new JButton("Add");
		btnAddProduct.setBounds(25, 277, 229, 33);
		contentPane.add(btnAddProduct);
		
		lblQty = new JLabel("Qty");
		lblQty.setBounds(25, 195, 70, 15);
		contentPane.add(lblQty);
		
		lblProduct = new JLabel("Product name");
		lblProduct.setBounds(25, 51, 130, 15);
		contentPane.add(lblProduct);
		
		lblAddProduct = new JLabel("Add product");
		lblAddProduct.setBounds(95, 12, 130, 15);
		contentPane.add(lblAddProduct);
		
		lblPrice = new JLabel("Price");
		lblPrice.setBounds(25, 130, 70, 15);
		contentPane.add(lblPrice);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(25, 150, 229, 33);
		contentPane.add(textField);
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionPopUpButton();
			}
		});
	}
	
	private void ActionPopUpButton() {
		System.out.println("call add product button");
		System.out.println(comboBoxPopup.getSelectedItem());
		System.out.println(textField.getText());
		System.out.println(textField_2.getText());
		int priceUnit = Integer.parseInt(textField.getText()) * Integer.parseInt(textField_2.getText());
//            	System.out.println(priceUnit);
//            	String str = "" + priceUnit;
		model.addRow(new Object[] { comboBoxPopup.getSelectedItem().toString(), textField.getText(),textField_2.getText(), priceUnit });
		MainView();
	}
	
	private void Actionback() {
		SaleOrderList pagesolist = new SaleOrderList();
		pagesolist.setVisible(true);
		this.dispose();
	}
	private void ActionUpdateState(String state_o, int id_selected) {
		String query = "UPDATE sale_order SET state = ? WHERE id = ?";
        try {
            PreparedStatement pst = PostgreSQLConnection.con.prepareStatement(query);
            pst.setString(1, state_o);
            pst.setInt(2, id_selected);
            int rowCount = pst.executeUpdate();
            if( rowCount > 0 ) {
            	JOptionPane.showMessageDialog(contentPane,"Update state");
            	this.dispose();
            	SaleOrderForm form = new SaleOrderForm(id_selected);
            	form.setVisible(true);
            }
        } catch (SQLException ex) {
            System.out.print( ex );
        }
	}
}
