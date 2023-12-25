package sedevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ManageProducts extends JFrame {
	
	int xx, xy;
	DefaultTableModel model;
	int rowIndex;

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textfield_name;
	private JTextField textfield_price;

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
		scrollPane.setBounds(100, 45, 671, 374);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Нэр", "Үнэ", "Зураг"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Бүтээгдэхүүний нэр");
		lblNewLabel.setBounds(134, 444, 104, 14);
		panel.add(lblNewLabel);
		
		textfield_name = new JTextField();
		textfield_name.setBounds(134, 469, 153, 20);
		panel.add(textfield_name);
		textfield_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Үнэ");
		lblNewLabel_1.setBounds(136, 511, 49, 14);
		panel.add(lblNewLabel_1);
		
		textfield_price = new JTextField();
		textfield_price.setBounds(134, 547, 153, 20);
		panel.add(textfield_price);
		textfield_price.setColumns(10);
		
		JButton btnUpdate = new JButton("Засварлах");
		btnUpdate.setBackground(new Color(255, 128, 64));
		btnUpdate.setBounds(360, 468, 89, 23);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Устгах");
		btnDelete.setBackground(new Color(255, 128, 64));
		btnDelete.setBounds(360, 546, 89, 23);
		panel.add(btnDelete);
	}
}
