package sedevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	int xx, xy;
	private void contentPaneMousePressed(java.awt.event.MouseEvent e) {
		xx=e.getX();
		xy=e.getY();
	}
	private void contentPaneMouseDragged(java.awt.event.MouseEvent e) {
		int x=e.getXOnScreen();
		int y=e.getYOnScreen();
		this.setLocation(x-xy, y-xy);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 664);
		contentPane = new JPanel();
		
		contentPane.setBackground(new Color(225, 113, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(91, 122, 77, 26);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(151, 125, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Нэр");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(91, 187, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 184, 187, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Үнэ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(91, 244, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(151, 241, 187, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Зураг\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(91, 300, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Browse\r\n");
		btnNewButton.setBounds(151, 296, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Хадгалах\r\n");
		btnNewButton_1.setBounds(151, 386, 226, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("X\r\n");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false); 
			}
		});
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_4.setBounds(818, 11, 49, 31);
		contentPane.add(lblNewLabel_4);
	}
}
