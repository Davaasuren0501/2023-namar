package seDesktop.client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.DAO;
import model.Basket;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageProducts extends JFrame {
	
	int xx, xy;
	DefaultTableModel model;
	int rowIndex;

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textfield_name;
	private JTextField textfield_price;
	private JButton btnDelete_1;
	private JLabel lblamount_total;
	
	private int selectedrow;
	private int amount_total = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageProducts frame = new ManageProducts();
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
	public ManageProducts() {
//		model.addRow((Vector<?>) Main.my_basket);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				for(double i=0.1; i<=1.0; i+=0.1) {
					String s = "" + i;
					float f = Float.parseFloat(s);
					this.setOpacity(f);
				}
			}

			private void setOpacity(float f) {
				// TODO Auto-generated method stub
				
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 635);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(225, 113, 0));
		panel.setBounds(0, 0, 900, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 99, 596, 459);
		panel.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.addColumn("Зураг");
		model.addColumn("Бүтээгдэхүүний нэр");
		model.addColumn("Үнэ");
		model.addColumn("Тоо ширхэг");
		model.addColumn("Нийт үнэ");
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		for (Basket basket : Main.my_basket) {
			int total = basket.getTotal();
			model.addRow(new Object[]{basket.getImage(), basket.getName(), basket.getPrice() , basket.getQuantity(), total});
			amount_total = amount_total + total;
			
		}
		ListSelectionModel selectionModel = table.getSelectionModel();
		
		JLabel lblNewLabel = new JLabel("Бүтээгдэхүүний нэр");
		lblNewLabel.setBounds(680, 99, 136, 14);
		panel.add(lblNewLabel);
		
		textfield_name = new JTextField();
		textfield_name.setBounds(680, 124, 153, 20);
		panel.add(textfield_name);
		textfield_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" Тоо ширхэг");
		lblNewLabel_1.setBounds(680, 158, 105, 14);
		panel.add(lblNewLabel_1);
		
		textfield_price = new JTextField();
		textfield_price.setBounds(680, 183, 153, 20);
		panel.add(textfield_price);
		textfield_price.setColumns(10);
		
		ListSelectionListener selectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // Get the selected row index
                	
                	System.out.println( "=========================================" );
                	System.out.println( "------call--------" );
                	int rowCount = table.getRowCount();
                	int total = 0;
                	for (int row = 0; row < rowCount; row++) {
                        Object value = table.getValueAt(row, 4);
                        System.out.println(value + "\t");
                        total = total + Integer.parseInt(value.toString());
                    }
                	amount_total = total;
                	lblamount_total.setText(total + " ₮");
                	System.out.println( "=========================================" );
                    int selectedRow = table.getSelectedRow();
                    if( selectedRow >= 0 ) {
                        System.out.println("Selected Row: " + selectedRow);
                        selectedrow = selectedRow;
                        Object name = table.getValueAt(selectedRow, 1);
                        Object qty = table.getValueAt(selectedRow, 3);
                        textfield_name.setText(name.toString());
                        textfield_price.setText(qty.toString());
                    }
                    
                }
            }
        };
		selectionModel.addListSelectionListener(selectionListener);
		
		JButton btnUpdate = new JButton("Засварлах");
		btnUpdate.setBackground(new Color(255, 128, 64));
		btnUpdate.setBounds(715, 263, 118, 23);
		panel.add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( textfield_price.getText().length() > 0 ) {
                    Object price_unit = table.getValueAt(selectedrow, 2);
					int qty = Integer.parseInt(textfield_price.getText());
					int price = Integer.parseInt(price_unit.toString());
			        model.setValueAt(qty, selectedrow, 3);
			        model.setValueAt(qty* price, selectedrow, 4);
			        textfield_price.setText("");
			        textfield_name.setText("");
			        model.fireTableDataChanged();
				}
		        		        
			}
		});
		
		JButton btnDelete = new JButton("Устгах");
		btnDelete.setBackground(new Color(255, 128, 64));
		btnDelete.setBounds(715, 228, 118, 23);
		panel.add(btnDelete);

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( "select row index: " + selectedrow  );
				if( textfield_price.getText().length() > 0 && selectedrow >= 0  ) {
			        model.removeRow(selectedrow);

			        textfield_price.setText("");
			        textfield_name.setText("");
			        model.fireTableDataChanged();
				}
		        		        
			}
		});
		
		btnDelete_1 = new JButton("Захиалах");
		btnDelete_1.setForeground(Color.WHITE);
		btnDelete_1.setBackground(new Color(38, 162, 105));
		btnDelete_1.setBounds(680, 523, 153, 34);
		panel.add(btnDelete_1);
		
		JLabel lblNewLabel_2 = new JLabel("Нийт үнэ");
		lblNewLabel_2.setBounds(680, 480, 76, 14);
		panel.add(lblNewLabel_2);
		
		lblamount_total = new JLabel(amount_total+ " ₮");
		lblamount_total.setBounds(757, 480, 76, 14);
		panel.add(lblamount_total);
		
		JLabel lblNewLabel_3 = new JLabel("Миний захиалга");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel_3.setBounds(353, 39, 212, 34);
		panel.add(lblNewLabel_3);
		

		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowcount = model.getRowCount();
				if( rowcount > 0 ) {

					int option = JOptionPane.showConfirmDialog(contentPane, "Та захиалга өгөхдөө итгэлтэй байна уу ?", "Анхааруулга", JOptionPane.YES_NO_OPTION);
					if (option == JOptionPane.YES_OPTION) {

				        LocalDateTime currentDateTime = LocalDateTime.now();
				        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				        String formattedDateTime = currentDateTime.format(formatter);
						System.out.println( "----------- to order -----------" );
						System.out.println( "amount_total -> " + amount_total );
						System.out.println( "date  -> " + formattedDateTime );
						
						DAO dao = new DAO();
						int id_insert_order = dao.CreateSaleOrderNew(amount_total, formattedDateTime);
						if( id_insert_order > 0) {
							for (int row = 0; row < model.getRowCount(); row++) {
								String name = model.getValueAt(row, 1).toString();
								String price = model.getValueAt(row, 2).toString();
								String qty = model.getValueAt(row, 3).toString();
								String unit_price = model.getValueAt(row, 3).toString();
								System.out.println( "name--->" + name +"   price--->"+price+" qty---> " + qty + " unit_price --->"+unit_price );
								int rowCount = dao.CreateSaleOrderLineNew(id_insert_order,name,price, qty,""+unit_price );
								System.out.println( "create sale order line  " + rowCount );
							}

							JOptionPane.showMessageDialog(contentPane,"Таны захиалгыг амжилттай үүсгэлээ. Таны захиалгын дугаар " + id_insert_order);
							Start window = new Start();
							window.frmLogin.setVisible(true);
							window.frmLogin.pack();
							window.frmLogin.setLocationRelativeTo(null);
							Change();
//							start_panel.setVisible(true);
							
						} else {
							JOptionPane.showMessageDialog(contentPane,"Уучлаарай, Захиалга үүсгэхэд алдаа гарлаа.");
						}
	                }
				} else {
					JOptionPane.showMessageDialog(contentPane,"Уучлаарай, Та захиалах бүтээгдэхүүн сонгоогүй байна.");
				}
			}
		});
	}
	public void Change() {
		this.dispose();
		Start.mainframe.dispose();
	}
}