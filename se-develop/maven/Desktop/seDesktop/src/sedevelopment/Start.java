package sedevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class Start  {

	private JFrame frmLogin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					Start window = new Start();
					window.frmLogin.setVisible(true);
					window.frmLogin.pack();
					window.frmLogin.setLocationRelativeTo(null);
				
			}
		});
	}

	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setPreferredSize(new Dimension(900, 600));
		frmLogin.setTitle("Login");
		frmLogin.setBounds(0, 0, 900, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(900, 600));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 900, 600);
		panel.setLayout(null);
		frmLogin.getContentPane().add(panel);
		
		JPanel Left = new JPanel();
		Left.setMinimumSize(new Dimension(500, 400));
		Left.setBounds(0, 0, 900, 600);
		panel.add(Left);
		Left.setLayout(null);
		
		JButton btnNewButton = new JButton("Захиалах");
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		btnNewButton.setBounds(138, 355, 244, 39);
		Left.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Main mainframe = new Main();
					mainframe.setVisible(true);
					mainframe.pack();
					mainframe.setLocationRelativeTo(null);
					frmLogin.dispose();				
			}
		});
		btnNewButton.setBackground(new Color(253, 208, 23));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setLayout(null);
		
		JLabel start_zurag = new JLabel("New label");
		start_zurag.setBounds(0, 0, 900, 600);
		start_zurag.setIcon(new ImageIcon(Start.class.getResource("/sedevelopment/R (1).jpg")));
		Left.add(start_zurag);
		
		JLabel intro_price = new JLabel("28,000T");
		intro_price.setForeground(new Color(253, 208, 23));
		intro_price.setFont(new Font("Bodoni MT Black", Font.BOLD, 54));
		intro_price.setBounds(138, 189, 350, 135);
		start_zurag.add(intro_price);
		
		JLabel decor = new JLabel("11:00 - 14:00 хооронд \r\n");
		decor.setForeground(new Color(253, 208, 23));
		decor.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		start_zurag.add(decor);
		decor.setBackground(new Color(253, 208, 23));
		decor.setBounds(138, 129, 244, 88);
		
		JLabel lblNewLabel = new JLabel("Найзууд багц");
		start_zurag.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(253, 208, 23));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblNewLabel.setBounds(138, 195, 244, 20);
	}
}
