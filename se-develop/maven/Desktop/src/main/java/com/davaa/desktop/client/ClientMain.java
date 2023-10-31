package com.davaa.desktop.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.davaa.desktop.guest.Login;
import com.davaa.desktop.App;
import com.davaa.desktop.client.customer.CustomerList;
import com.davaa.desktop.client.product.ProductList;
import com.davaa.desktop.client.sale_order.SaleOrderList;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JSlider;

public class ClientMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
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
	public ClientMain() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 813, 597);
//		
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(new CardLayout(0, 0));
//		
//		JPanel panel = new JPanel();
//		contentPane.add(panel, "name_2862262833425");
//		panel.setLayout(null);
		
		InitComponent();
	}
	

	private void InitComponent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 345);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, "name_3180173449798");
		panel.setLayout(null);

		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(317, 114, 102, 101);
        
		panel.add(btnCustomer);

		JButton btnSaleOrder = new JButton("Sale order");
		btnSaleOrder.setBounds(30, 114, 118, 101);
		panel.add(btnSaleOrder);

		JButton btnProduct = new JButton("Product");
		btnProduct.setBounds(179, 114, 113, 101);
		panel.add(btnProduct);
		
		JLabel lblNewLabel = new JLabel("User Menu");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(247, 36, 254, 57);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ActionButton( "exit" );
			}
		});
		btnNewButton.setIcon(new ImageIcon("/home/davaa/Downloads/icon (1).png"));
		btnNewButton.setBounds(446, 114, 113, 101);
		panel.add(btnNewButton);
		btnCustomer.setText(App.rb.getString("customer"));
		btnSaleOrder.setText(App.rb.getString("sale_order"));
		btnProduct.setText(App.rb.getString("product"));
		btnNewButton.setText(App.rb.getString("exit"));
		lblNewLabel.setText(App.rb.getString("user_menu"));
		
		JButton btnNewButton_1 = new JButton(App.rb.getString("language"));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("/home/davaa/Downloads/icon_glo.png"));
		btnNewButton_1.setBounds(30, 12, 96, 45);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(App.rb.getString("language"));
				if( App.rb.getString("language").equals("En") ) {
					System.out.println("change mn");
					Locale.setDefault(new Locale("mn","MN"));
					App.rb = ResourceBundle.getBundle("com/davaa/desktop/utils/resource_bundle");
				} else {
					System.out.println("change en");
					Locale.setDefault(new Locale("en","EN"));
					App.rb = ResourceBundle.getBundle("com/davaa/desktop/utils/resource_bundle");
				}
				btnNewButton_1.setText(App.rb.getString("language"));
				btnCustomer.setText(App.rb.getString("customer"));
				btnSaleOrder.setText(App.rb.getString("sale_order"));
				btnProduct.setText(App.rb.getString("product"));
				btnNewButton.setText(App.rb.getString("exit"));
				lblNewLabel.setText(App.rb.getString("user_menu"));
			}
		});
		panel.add(btnNewButton_1);
		


		btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                ActionButton( "customer" );
            }
        });


		btnSaleOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                ActionButton( "sale_order" );
            }
        });


		btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent event) {
                ActionButton( "product" );
            }
        });
	}
	private void ActionButton( String btn_name ) {
		if(btn_name == "sale_order" ) {
			SaleOrderList pageSaleOrder = new SaleOrderList();
			pageSaleOrder.setVisible(true);
		} else {
			if( btn_name == "customer" ) {
				CustomerList pageCustomer = new CustomerList();
				pageCustomer.setVisible(true);
			} else {
				if( btn_name == "product" ) {
					ProductList pageProduct = new ProductList( );
					pageProduct.setVisible(true);
				} else {
					Login pageLogin = new Login( );
					pageLogin.setVisible(true);
			        this.dispose();
				}
			}
		}
	}
}
