package sedevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button_pay;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment frame = new Payment();
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
	public Payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 634);
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
		scrollPane.setBounds(29, 31, 657, 487);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cart ID", "Бүтээгдэхүүний ID", "Нэр", "Тоо ширхэг", "Үнэ", "Нийт"
			}
		));
		
		JLabel lblNewLabel = new JLabel("Payment ID");
		lblNewLabel.setBounds(729, 38, 96, 14);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(729, 63, 96, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Нийт");
		lblNewLabel_1.setBounds(729, 118, 49, 14);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(729, 143, 96, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Бэлэн");
		lblNewLabel_2.setBounds(729, 203, 49, 14);
		panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(729, 228, 96, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Хариулт");
		lblNewLabel_3.setBounds(729, 289, 49, 14);
		panel.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(729, 314, 96, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		button_pay = 
				new JButton("Төлөх");
		button_pay.setBackground(new Color(255, 128, 64));
		button_pay.setBounds(729, 440, 137, 23);
		panel.add(button_pay);
	}
}
