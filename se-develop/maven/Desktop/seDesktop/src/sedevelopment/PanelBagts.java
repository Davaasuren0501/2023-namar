package sedevelopment;

import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JTextField;


public class PanelBagts extends JPanel {
	private JTextField textField_id;
	private JTextField textField_name;
	private JTextField textField_quantity;
	private JTextField textField_total;
	
	
	
	public PanelBagts() {
		
		setBackground(new Color(192, 192, 192));
		setForeground(new Color(255, 0, 0));
		setLayout(null);
		setVisible(true);
		
		
		
		JPanel bagtsbox1 = new JPanel();
		bagtsbox1.setForeground(new Color(255, 0, 0));
		bagtsbox1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox1.setBackground(new Color(255, 255, 255));
		bagtsbox1.setBounds(25, 46, 130, 220);
		add(bagtsbox1);
		bagtsbox1.setLayout(null);
		
		JLabel ner = new JLabel("Зингер багц");
		ner.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner.setBounds(20, 121, 134, 14);
		bagtsbox1.add(ner);
		JLabel price = new JLabel("21,000₮");
		price.setFont(new Font("Tahoma", Font.BOLD, 12));
		price.setForeground(new Color(255, 0, 0));
		price.setBounds(20, 135, 49, 14);
		bagtsbox1.add(price);
		
		
		
		JLabel imagebox1 = new JLabel("New label");
		imagebox1.setBounds(30, 30, 60, 80);
		bagtsbox1.add(imagebox1);
		imagebox1.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/227p33vk (1).png")));
		
		JLabel lblNewLabel = new JLabel("Ширхэг");
		lblNewLabel.setBounds(20, 161, 49, 14);
		bagtsbox1.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 158, 30, 20);
		bagtsbox1.add(spinner);
		
		JButton addBasket = new JButton("Сагсанд хийх");
		addBasket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner.getValue().toString());
				
			}
		});
		addBasket.setBackground(new Color(255, 0, 0));
		addBasket.setBounds(20, 186, 80, 23);
		bagtsbox1.add(addBasket);
		
		
		JPanel bagtsbox2 = new JPanel();
		bagtsbox2.setLayout(null);
		bagtsbox2.setForeground(Color.RED);
		bagtsbox2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox2.setBackground(Color.WHITE);
		bagtsbox2.setBounds(185, 46, 130, 220);
		add(bagtsbox2);
		
		JLabel ner_1 = new JLabel("Филле багц");
		ner_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_1.setBounds(20, 121, 134, 14);
		bagtsbox2.add(ner_1);
		
		JLabel price_1 = new JLabel("22,500₮");
		price_1.setForeground(Color.RED);
		price_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_1.setBounds(20, 135, 49, 14);
		bagtsbox2.add(price_1);
		
		JButton addBasket_1 = new JButton("Сагсанд хийх");
		addBasket_1.setBackground(Color.RED);
		addBasket_1.setBounds(20, 186, 80, 23);
		bagtsbox2.add(addBasket_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(30, 29, 60, 80);
		bagtsbox2.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/zuWBE9U (1).png")));
		
		JLabel lblNewLabel_3 = new JLabel("Ширхэг");
		lblNewLabel_3.setBounds(20, 160, 49, 14);
		bagtsbox2.add(lblNewLabel_3);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(70, 158, 30, 20);
		bagtsbox2.add(spinner_1);
		
		JPanel bagtsbox3 = new JPanel();
		bagtsbox3.setLayout(null);
		bagtsbox3.setForeground(Color.RED);
		bagtsbox3.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox3.setBackground(Color.WHITE);
		bagtsbox3.setBounds(345, 46, 130, 220);
		add(bagtsbox3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/bxQtPYS (1).png")));
		lblNewLabel_2.setBounds(30, 30, 60, 80);
		bagtsbox3.add(lblNewLabel_2);
		
		JLabel ner_2 = new JLabel("Найзууд багц");
		ner_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_2.setBounds(20, 121, 134, 14);
		bagtsbox3.add(ner_2);
		
		JLabel price_2 = new JLabel("28,000₮");
		price_2.setForeground(Color.RED);
		price_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_2.setBounds(20, 135, 49, 14);
		bagtsbox3.add(price_2);
		
		JButton addBasket_2 = new JButton("Сагсанд хийх");
		addBasket_2.setBackground(Color.RED);
		addBasket_2.setBounds(20, 186, 80, 23);
		bagtsbox3.add(addBasket_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Ширхэг");
		lblNewLabel_3_1.setBounds(20, 161, 49, 14);
		bagtsbox3.add(lblNewLabel_3_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(70, 158, 30, 20);
		bagtsbox3.add(spinner_2);
		
		JPanel bagtsbox1_1 = new JPanel();
		bagtsbox1_1.setLayout(null);
		bagtsbox1_1.setForeground(Color.RED);
		bagtsbox1_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox1_1.setBackground(Color.WHITE);
		bagtsbox1_1.setBounds(25, 284, 130, 220);
		add(bagtsbox1_1);
		
		JLabel ner_3 = new JLabel("Тахианы махтай ");
		ner_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_3.setBounds(20, 121, 134, 14);
		bagtsbox1_1.add(ner_3);
		
		JLabel price_3 = new JLabel("15,000₮");
		price_3.setForeground(Color.RED);
		price_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_3.setBounds(20, 135, 49, 14);
		bagtsbox1_1.add(price_3);
		
		JButton addBasket_3 = new JButton("Сагсанд хийх");
		addBasket_3.setBackground(Color.RED);
		addBasket_3.setBounds(20, 186, 80, 23);
		bagtsbox1_1.add(addBasket_3);
		
		JLabel imagebox1_1 = new JLabel("New label");
		imagebox1_1.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/zuWBE9U (1).png")));
		imagebox1_1.setBounds(30, 30, 60, 80);
		bagtsbox1_1.add(imagebox1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Ширхэг");
		lblNewLabel_4.setBounds(20, 161, 49, 14);
		bagtsbox1_1.add(lblNewLabel_4);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(70, 158, 30, 20);
		bagtsbox1_1.add(spinner_3);
		
		JPanel bagtsbox1_2 = new JPanel();
		bagtsbox1_2.setLayout(null);
		bagtsbox1_2.setForeground(Color.RED);
		bagtsbox1_2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox1_2.setBackground(Color.WHITE);
		bagtsbox1_2.setBounds(185, 284, 130, 220);
		add(bagtsbox1_2);
		
		JLabel ner_4 = new JLabel("Миний багц");
		ner_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_4.setBounds(20, 121, 134, 14);
		bagtsbox1_2.add(ner_4);
		
		JLabel price_4 = new JLabel("13,000₮");
		price_4.setForeground(Color.RED);
		price_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_4.setBounds(20, 135, 49, 14);
		bagtsbox1_2.add(price_4);
		
		JButton addBasket_4 = new JButton("Сагсанд хийх");
		addBasket_4.setBackground(Color.RED);
		addBasket_4.setBounds(20, 186, 80, 23);
		bagtsbox1_2.add(addBasket_4);
		
		JLabel imagebox1_2 = new JLabel("New label");
		imagebox1_2.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/227p33vk (1).png")));
		imagebox1_2.setBounds(30, 30, 60, 80);
		bagtsbox1_2.add(imagebox1_2);
		
		JLabel lblNewLabel_5 = new JLabel("Ширхэг");
		lblNewLabel_5.setBounds(20, 161, 49, 14);
		bagtsbox1_2.add(lblNewLabel_5);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(70, 158, 30, 20);
		bagtsbox1_2.add(spinner_4);
		
		JPanel bagtsbox1_3 = new JPanel();
		bagtsbox1_3.setLayout(null);
		bagtsbox1_3.setForeground(Color.RED);
		bagtsbox1_3.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		bagtsbox1_3.setBackground(Color.WHITE);
		bagtsbox1_3.setBounds(345, 284, 130, 220);
		add(bagtsbox1_3);
		
		JLabel ner_5 = new JLabel("Бидний багц");
		ner_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_5.setBounds(20, 121, 134, 14);
		bagtsbox1_3.add(ner_5);
		
		JLabel price_5 = new JLabel("25,000₮");
		price_5.setForeground(Color.RED);
		price_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_5.setBounds(20, 135, 49, 14);
		bagtsbox1_3.add(price_5);
		
		JButton addBasket_5 = new JButton("Сагсанд хийх");
		addBasket_5.setBackground(Color.RED);
		addBasket_5.setBounds(20, 186, 80, 23);
		bagtsbox1_3.add(addBasket_5);
		
		JLabel imagebox1_3 = new JLabel("New label");
		imagebox1_3.setIcon(new ImageIcon(PanelBagts.class.getResource("/sedevelopment/bxQtPYS (1).png")));
		imagebox1_3.setBounds(30, 30, 60, 80);
		bagtsbox1_3.add(imagebox1_3);
		
		JLabel lblNewLabel_6 = new JLabel("Ширхэг");
		lblNewLabel_6.setBounds(20, 161, 49, 14);
		bagtsbox1_3.add(lblNewLabel_6);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(70, 158, 30, 20);
		bagtsbox1_3.add(spinner_5);
		
		JLabel lblId = new JLabel(" Бүтээгдэхүүний ID");
		lblId.setBounds(505, 46, 136, 14);
		add(lblId);
		
		textField_id = new JTextField();
		textField_id.setBounds(505, 71, 136, 20);
		add(textField_id);
		textField_id.setColumns(10);
		
		JLabel label_name = new JLabel("Бүтээгдэхүүний нэр");
		label_name.setBounds(505, 141, 121, 14);
		add(label_name);
		
		textField_name = new JTextField();
		textField_name.setBounds(505, 166, 136, 20);
		add(textField_name);
		textField_name.setColumns(10);
		
		JLabel label_quantity = new JLabel("Тоо ширхэг");
		label_quantity.setBounds(505, 234, 86, 14);
		add(label_quantity);
		
		textField_quantity = new JTextField();
		textField_quantity.setBounds(505, 259, 136, 20);
		add(textField_quantity);
		textField_quantity.setColumns(10);
		
		JLabel label_total = new JLabel("Нийт");
		label_total.setBounds(505, 343, 49, 14);
		add(label_total);
		
		textField_total = new JTextField();
		textField_total.setBounds(505, 368, 96, 20);
		add(textField_total);
		textField_total.setColumns(10);
		

	}
}
