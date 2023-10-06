import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DemoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFrame frame = new DemoFrame();
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
	public DemoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("User Name");
		lblPassword.setBounds(26, 28, 102, 23);
		contentPane.add(lblPassword);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(26, 85, 102, 23);
		contentPane.add(lblPassword_1);
		
		textField = new JTextField();
		textField.setBounds(245, 87, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(245, 30, 114, 19);
		contentPane.add(textField_1);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(134, 181, 158, 46);
		contentPane.add(btnSignIn);
	}
}
