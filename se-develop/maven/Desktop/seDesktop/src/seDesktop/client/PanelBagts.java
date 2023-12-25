package seDesktop.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import model.Basket;
import javax.swing.JOptionPane;
public class PanelBagts extends JPanel {
		
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
		JLabel price = new JLabel("21000");
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
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + imagebox1.getIcon() );
				System.out.println( "price " + price.getText() );
				System.out.println( "price " + Integer.parseInt(price.getText()) );
				System.out.println( "ner " + ner.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(imagebox1.getIcon().toString(),ner.getText(), Integer.parseInt(price.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
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
		
		JLabel price_1 = new JLabel("22500");
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
		
		addBasket_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner_1.getValue().toString());
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + lblNewLabel_1.getIcon() );
				System.out.println( "price " + price_1.getText() );
				System.out.println( "ner " + ner_1.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(lblNewLabel_1.getIcon().toString(),ner_1.getText(), Integer.parseInt(price_1.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
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
		
		JLabel price_2 = new JLabel("28000");
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
		
		addBasket_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner_2.getValue().toString());
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + lblNewLabel_2.getIcon() );
				System.out.println( "price " + price_2.getText() );
				System.out.println( "ner " + ner_2.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(lblNewLabel_2.getIcon().toString(),ner_2.getText(), Integer.parseInt(price_2.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
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
		
		JLabel price_3 = new JLabel("15000");
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
		
		addBasket_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner_3.getValue().toString());
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + imagebox1_1.getIcon() );
				System.out.println( "price " + price_3.getText() );
				System.out.println( "ner " + ner_3.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(imagebox1_1.getIcon().toString(),ner_3.getText(), Integer.parseInt(price_3.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JLabel ner_4 = new JLabel("Миний багц");
		ner_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_4.setBounds(20, 121, 134, 14);
		bagtsbox1_2.add(ner_4);
		
		JLabel price_4 = new JLabel("13000");
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
		
		addBasket_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner_4.getValue().toString());
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + imagebox1_2.getIcon() );
				System.out.println( "price " + price_4.getText() );
				System.out.println( "ner " + ner_4.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(imagebox1_2.getIcon().toString(),ner_4.getText(), Integer.parseInt(price_4.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		JLabel ner_5 = new JLabel("Бидний багц");
		ner_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_5.setBounds(20, 121, 134, 14);
		bagtsbox1_3.add(ner_5);
		
		JLabel price_5 = new JLabel("25000");
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
		
		addBasket_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int qty = Integer.parseInt(spinner_4.getValue().toString());
				System.out.println( "========================================" );
				System.out.println( "qty " + qty );
				System.out.println( "imagebox1" + imagebox1_3.getIcon() );
				System.out.println( "price " + price_5.getText() );
				System.out.println( "ner " + ner_5.getText() );
				System.out.println( Main.my_basket );
				System.out.println( "========================================" );
				if(qty > 0) {
					Basket basket = new Basket(imagebox1_3.getIcon().toString(),ner_5.getText(), Integer.parseInt(price_5.getText()), qty );
					Main.my_basket.add(basket);
					System.out.println( Main.my_basket );
					System.out.println( "========================================" );
				} else {
					JOptionPane.showMessageDialog(null, "Бүтээгдэхүүний тоо ширхэг оруулна уу!", "User error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
	}
}
