package sedevelopment;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class PanelKombo extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelKombo() {
		
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 0, 0));
		setLayout(null);
		setVisible(true);
		
		
		JPanel combobox1 = new JPanel();
		combobox1.setBounds(25, 46, 130, 220);
		combobox1.setLayout(null);
		combobox1.setForeground(Color.RED);
		combobox1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		combobox1.setBackground(Color.WHITE);
		add(combobox1);
		
		JLabel ner = new JLabel("Мини комбо");
		ner.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner.setBounds(20, 121, 134, 14);
		combobox1.add(ner);
		
		JLabel price = new JLabel("11,000₮");
		price.setForeground(Color.RED);
		price.setFont(new Font("Tahoma", Font.BOLD, 12));
		price.setBounds(20, 135, 49, 14);
		combobox1.add(price);
		
		JButton addBasket = new JButton("Сагсанд хийх");
		addBasket.setBackground(Color.RED);
		addBasket.setBounds(20, 186, 80, 23);
		combobox1.add(addBasket);
		
		JLabel imagebox1 = new JLabel("New label");
		imagebox1.setIcon(new ImageIcon(PanelKombo.class.getResource("/sedevelopment/combo1 (1).png")));
		imagebox1.setBounds(30, 30, 60, 80);
		combobox1.add(imagebox1);
		
		JLabel lblNewLabel = new JLabel("Ширхэг");
		lblNewLabel.setBounds(20, 161, 49, 14);
		combobox1.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 158, 30, 20);
		combobox1.add(spinner);
		
		JPanel combobox2 = new JPanel();
		combobox2.setLayout(null);
		combobox2.setForeground(Color.RED);
		combobox2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		combobox2.setBackground(Color.WHITE);
		combobox2.setBounds(185, 46, 130, 220);
		add(combobox2);
		
		JLabel ner_1 = new JLabel("Тахианы комбо");
		ner_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_1.setBounds(20, 121, 134, 14);
		combobox2.add(ner_1);
		
		JLabel price_1 = new JLabel("11,000₮");
		price_1.setForeground(Color.RED);
		price_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_1.setBounds(20, 135, 49, 14);
		combobox2.add(price_1);
		
		JButton addBasket_1 = new JButton("Сагсанд хийх");
		addBasket_1.setBackground(Color.RED);
		addBasket_1.setBounds(20, 186, 80, 23);
		combobox2.add(addBasket_1);
		
		JLabel imagebox1_1 = new JLabel("New label");
		imagebox1_1.setIcon(new ImageIcon(PanelKombo.class.getResource("/sedevelopment/combo2 (1).png")));
		imagebox1_1.setBounds(30, 30, 60, 80);
		combobox2.add(imagebox1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ширхэг");
		lblNewLabel_1.setBounds(20, 161, 49, 14);
		combobox2.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(70, 158, 30, 20);
		combobox2.add(spinner_1);
		
		JPanel combobox3 = new JPanel();
		combobox3.setLayout(null);
		combobox3.setForeground(Color.RED);
		combobox3.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		combobox3.setBackground(Color.WHITE);
		combobox3.setBounds(345, 46, 130, 220);
		add(combobox3);
		
		JLabel ner_2 = new JLabel("Твистер комбо");
		ner_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_2.setBounds(20, 121, 134, 14);
		combobox3.add(ner_2);
		
		JLabel price_2 = new JLabel("11,000₮");
		price_2.setForeground(Color.RED);
		price_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_2.setBounds(20, 135, 49, 14);
		combobox3.add(price_2);
		
		JButton addBasket_2 = new JButton("Сагсанд хийх");
		addBasket_2.setBackground(Color.RED);
		addBasket_2.setBounds(20, 186, 80, 23);
		combobox3.add(addBasket_2);
		
		JLabel imagebox1_2 = new JLabel("New label");
		imagebox1_2.setIcon(new ImageIcon(PanelKombo.class.getResource("/sedevelopment/combo3 (1).png")));
		imagebox1_2.setBounds(30, 30, 60, 80);
		combobox3.add(imagebox1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ширхэг");
		lblNewLabel_2.setBounds(20, 161, 49, 14);
		combobox3.add(lblNewLabel_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(70, 158, 30, 20);
		combobox3.add(spinner_2);
		
		JPanel combobox4 = new JPanel();
		combobox4.setLayout(null);
		combobox4.setForeground(Color.RED);
		combobox4.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		combobox4.setBackground(Color.WHITE);
		combobox4.setBounds(25, 283, 130, 220);
		add(combobox4);
		
		JLabel ner_3 = new JLabel("Зингер багц");
		ner_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_3.setBounds(20, 121, 134, 14);
		combobox4.add(ner_3);
		
		JLabel price_3 = new JLabel("21,000₮");
		price_3.setForeground(Color.RED);
		price_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_3.setBounds(20, 135, 49, 14);
		combobox4.add(price_3);
		
		JButton addBasket_3 = new JButton("Сагсанд хийх");
		addBasket_3.setBackground(Color.RED);
		addBasket_3.setBounds(20, 186, 80, 23);
		combobox4.add(addBasket_3);
		
		JLabel imagebox1_3 = new JLabel("New label");
		imagebox1_3.setBounds(30, 30, 60, 80);
		combobox4.add(imagebox1_3);
		
		JLabel lblNewLabel_3 = new JLabel("Ширхэг");
		lblNewLabel_3.setBounds(20, 161, 49, 14);
		combobox4.add(lblNewLabel_3);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(70, 158, 30, 20);
		combobox4.add(spinner_3);
		
		JPanel combobox5 = new JPanel();
		combobox5.setLayout(null);
		combobox5.setForeground(Color.RED);
		combobox5.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		combobox5.setBackground(Color.WHITE);
		combobox5.setBounds(185, 283, 130, 220);
		add(combobox5);
		
		JLabel ner_4 = new JLabel("Зингер багц");
		ner_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_4.setBounds(20, 121, 134, 14);
		combobox5.add(ner_4);
		
		JLabel price_4 = new JLabel("21,000₮");
		price_4.setForeground(Color.RED);
		price_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_4.setBounds(20, 135, 49, 14);
		combobox5.add(price_4);
		
		JButton addBasket_4 = new JButton("Сагсанд хийх");
		addBasket_4.setBackground(Color.RED);
		addBasket_4.setBounds(20, 186, 80, 23);
		combobox5.add(addBasket_4);
		
		JLabel imagebox1_4 = new JLabel("New label");
		imagebox1_4.setBounds(30, 30, 60, 80);
		combobox5.add(imagebox1_4);
		
		JLabel lblNewLabel_4 = new JLabel("Ширхэг");
		lblNewLabel_4.setBounds(20, 161, 49, 14);
		combobox5.add(lblNewLabel_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(70, 158, 30, 20);
		combobox5.add(spinner_4);
		

	}

}