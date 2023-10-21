package com.davaa.desktop.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.davaa.desktop.guest.SignUp;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;

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
	
	public void ActionButton( String btn_name ) {
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
			        this.dispose();
				}
			}
		}
	}
}
