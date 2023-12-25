package sedevelopment;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.awt.Rectangle;
import java.awt.FlowLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import model.Basket;


public class Main extends JFrame {

	private JPanel contentPane;
	
	private PanelBagts panelbagts;
	private PanelKombo panelkombo;
	private PanelDan paneldan;
	private PanelBeverages panelbeverages;
	private PanelDesserts paneldesserts;

	protected JLabel jTxtTime;

	protected JLabel jTxtDate;
	private JTable table;	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					Main main1 = new Main();
					main1.setVisible(true);
					main1.pack();
					main1.setLocationRelativeTo(null);
				
			}
		});
	}
	
	public Main() {
		setPreferredSize(new Dimension(900, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelbagts = new PanelBagts();
		panelbagts.setBounds(0, 0, 722, 575);
		panelbagts.setBackground(new Color(255, 255, 255));
		panelkombo = new PanelKombo();
		panelkombo.setBounds(0, 0, 698, 575);
		paneldan = new PanelDan();
		paneldan.setBounds(0, 0, 703, 575);
		panelbeverages = new PanelBeverages();
		panelbeverages.setBounds(228, 5, 93, 24);
		paneldesserts = new PanelDesserts();
		paneldesserts.setBounds(326, 5, 85, 24);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 900, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel Right = new JPanel();
		Right.setBackground(new Color(255, 0, 0));
		Right.setBounds(0, 0, 200, 600);
		panel.add(Right);
		Right.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/sedevelopment/logo (1).png")));
		lblNewLabel.setBounds(26, 11, 100, 88);
		Right.add(lblNewLabel);
		
		JPanel panel_bagts = new JPanel();
		panel_bagts.addMouseListener(new PanelButtonMouseAdapter(panel_bagts){
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelbagts);
			}
		});
		panel_bagts.setBackground(new Color(230, 0, 0));
		panel_bagts.setBounds(0, 120, 200, 30);
		Right.add(panel_bagts);
		panel_bagts.setLayout(null);
		
		JLabel text_bagts = new JLabel("Багц\r\n\r\n");
		text_bagts.setForeground(new Color(255, 255, 255));
		text_bagts.setBounds(12, 5, 125, 13);
		text_bagts.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_bagts.add(text_bagts);
		
		JPanel panel_kombo = new JPanel();
		panel_kombo.addMouseListener(new PanelButtonMouseAdapter(panel_kombo) {
		public void mouseClicked(MouseEvent e) {
			menuClicked(panelkombo);
		}
		});
		panel_kombo.setBackground(new Color(255, 0, 0));
		panel_kombo.setBounds(0, 150, 200, 30);
		Right.add(panel_kombo);
		panel_kombo.setLayout(null);
		
		JLabel tetx_kombo = new JLabel("Комбо\r\n \r\n");
		tetx_kombo.setForeground(new Color(255, 255, 255));
		tetx_kombo.setBounds(12, 5, 92, 13);
		tetx_kombo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_kombo.add(tetx_kombo);
		
		JPanel panel_dan = new JPanel();
		panel_dan.addMouseListener(new PanelButtonMouseAdapter(panel_dan) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneldan);
			}
		});
		panel_dan.setBackground(new Color(255, 0, 0));
		panel_dan.setBounds(0, 180, 200, 30);
		Right.add(panel_dan);
		panel_dan.setLayout(null);
		
		JLabel text_dan = new JLabel("Дангаараа\r\n");
		text_dan.setForeground(new Color(255, 255, 255));
		text_dan.setBounds(12, 5, 119, 13);
		text_dan.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_dan.add(text_dan);
		
		JPanel panel_beverages = new JPanel();
		panel_beverages.addMouseListener(new PanelButtonMouseAdapter(panel_beverages) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelbeverages);
			}
		});
		panel_beverages.setBackground(new Color(255, 0, 0));
		panel_beverages.setBounds(0, 210, 200, 30);
		Right.add(panel_beverages);
		panel_beverages.setLayout(null);
		
		JLabel text_beverages = new JLabel("Уух юм");
		text_beverages.setForeground(new Color(255, 255, 255));
		text_beverages.setBounds(12, 5, 65, 13);
		text_beverages.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_beverages.add(text_beverages);
		
		JPanel panel_desserts = new JPanel();
		panel_desserts.addMouseListener(new PanelButtonMouseAdapter(panel_desserts) {
			public void mouseClicked(MouseEvent e) {
				menuClicked(paneldesserts);
			}
		});
		panel_desserts.setBackground(new Color(255, 0, 0));
		panel_desserts.setBounds(0, 240, 200, 30);
		Right.add(panel_desserts);
		panel_desserts.setLayout(null);
		
		JLabel text_desserts = new JLabel("Амттан\r\n");
		text_desserts.setForeground(new Color(255, 255, 255));
		text_desserts.setBounds(12, 5, 83, 13);
		text_desserts.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		panel_desserts.add(text_desserts);
		
		JPanel Left = new JPanel();
		Left.setBackground(new Color(255, 255, 255));
		Left.setBounds(200, 25, 690, 541);
		panel.add(Left);
		Left.setLayout(null);
		
		JPanel up = new JPanel();
		up.setBackground(new Color(255, 128, 64));
		up.setBounds(200, 0, 700, 25);
		panel.add(up);
		up.setLayout(null);
		
		JLabel sags = new JLabel("Сагс");
		sags.setIcon(new ImageIcon(Main.class.getResource("/sedevelopment/icons8-basket-24 (1).png")));
		sags.setBounds(300, 6, 88, 14);
		up.add(sags);
		
		
		
		JLabel jTxtDate = new JLabel("New label");
		jTxtDate.setBounds(510, 6, 49, 14);
		up.add(jTxtDate);
		
		
		JLabel jTxtTime = new JLabel("New label");
		jTxtTime.setBounds(596, 6, 49, 14);
		up.add(jTxtTime);
		
		
		
		Left.add(panelbagts);
		Left.add(panelkombo);
		Left.add(paneldan);
		/*Left.add(panelbeverages);
		Left.add(paneldesserts);*/
		
		menuClicked(panelbagts);
		panelbagts.setLayout(null);
		
		JButton button_addtosags = new JButton("Төлөх");
		button_addtosags.setBackground(new Color(255, 128, 64));
		button_addtosags.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_addtosags.setBounds(499, 471, 160, 23);
		panelbagts.add(button_addtosags);
		
		
	}
	public void menuClicked(JPanel panel) {
		panelbagts.setVisible(false);
		panelkombo.setVisible(false);
		paneldan.setVisible(false);
		panelbeverages.setVisible(false);
		paneldesserts.setVisible(false);
		
		panel.setVisible(true);

	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}

		
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(230, 0, 0));
			
		}
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(255, 0, 0));
		}
		
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(230, 255, 255));

			
		}
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(230, 0, 0));
	
		}		
	}
}
