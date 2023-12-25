package sedevelopment;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class PanelDan extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelDan() {
		
		setBackground(new Color(255, 255, 255));
		setForeground(new Color(255, 0, 0));
		setLayout(null);
		setVisible(true);
		
		
		JPanel danbox1 = new JPanel();
		danbox1.setBounds(25, 46, 130, 220);
		danbox1.setLayout(null);
		danbox1.setForeground(Color.RED);
		danbox1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		danbox1.setBackground(Color.WHITE);
		add(danbox1);
		
		JLabel ner = new JLabel("Мини комбо");
		ner.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner.setBounds(20, 121, 134, 14);
		danbox1.add(ner);
		
		JLabel price = new JLabel("11,000₮");
		price.setForeground(Color.RED);
		price.setFont(new Font("Tahoma", Font.BOLD, 12));
		price.setBounds(20, 135, 49, 14);
		danbox1.add(price);
		
		JButton addBasket = new JButton("Сагсанд хийх");
		addBasket.setBackground(Color.RED);
		addBasket.setBounds(20, 186, 80, 23);
		danbox1.add(addBasket);
		
		JLabel imagebox1 = new JLabel("New label");
		imagebox1.setIcon(new ImageIcon(PanelKombo.class.getResource("/sedevelopment/combo1 (1).png")));
		imagebox1.setBounds(30, 30, 60, 80);
		danbox1.add(imagebox1);
		
		JLabel lblNewLabel = new JLabel("Ширхэг");
		lblNewLabel.setBounds(20, 161, 49, 14);
		danbox1.add(lblNewLabel);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(70, 158, 30, 20);
		danbox1.add(spinner);
		
		JPanel danbox1_1 = new JPanel();
		danbox1_1.setLayout(null);
		danbox1_1.setForeground(Color.RED);
		danbox1_1.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		danbox1_1.setBackground(Color.WHITE);
		danbox1_1.setBounds(184, 46, 130, 220);
		add(danbox1_1);
		
		JLabel ner_1 = new JLabel("Мини комбо");
		ner_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_1.setBounds(20, 121, 134, 14);
		danbox1_1.add(ner_1);
		
		JLabel price_1 = new JLabel("11,000₮");
		price_1.setForeground(Color.RED);
		price_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_1.setBounds(20, 135, 49, 14);
		danbox1_1.add(price_1);
		
		JButton addBasket_1 = new JButton("Сагсанд хийх");
		addBasket_1.setBackground(Color.RED);
		addBasket_1.setBounds(20, 186, 80, 23);
		danbox1_1.add(addBasket_1);
		
		JLabel imagebox1_1 = new JLabel("New label");
		imagebox1_1.setBounds(30, 30, 60, 80);
		danbox1_1.add(imagebox1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Ширхэг");
		lblNewLabel_1.setBounds(20, 161, 49, 14);
		danbox1_1.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(70, 158, 30, 20);
		danbox1_1.add(spinner_1);
		
		JPanel danbox1_2 = new JPanel();
		danbox1_2.setLayout(null);
		danbox1_2.setForeground(Color.RED);
		danbox1_2.setBorder(new LineBorder(new Color(128, 128, 128), 1, true));
		danbox1_2.setBackground(Color.WHITE);
		danbox1_2.setBounds(347, 46, 130, 220);
		add(danbox1_2);
		
		JLabel ner_2 = new JLabel("Мини комбо");
		ner_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		ner_2.setBounds(20, 121, 134, 14);
		danbox1_2.add(ner_2);
		
		JLabel price_2 = new JLabel("11,000₮");
		price_2.setForeground(Color.RED);
		price_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		price_2.setBounds(20, 135, 49, 14);
		danbox1_2.add(price_2);
		
		JButton addBasket_2 = new JButton("Сагсанд хийх");
		addBasket_2.setBackground(Color.RED);
		addBasket_2.setBounds(20, 186, 80, 23);
		danbox1_2.add(addBasket_2);
		
		JLabel imagebox1_2 = new JLabel("New label");
		imagebox1_2.setBounds(30, 30, 60, 80);
		danbox1_2.add(imagebox1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Ширхэг");
		lblNewLabel_2.setBounds(20, 161, 49, 14);
		danbox1_2.add(lblNewLabel_2);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(70, 158, 30, 20);
		danbox1_2.add(spinner_2);
		
		
	}

}
