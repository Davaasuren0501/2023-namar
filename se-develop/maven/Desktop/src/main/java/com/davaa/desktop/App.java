package com.davaa.desktop;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.*;

import com.davaa.desktop.client.ClientMain;
import com.davaa.desktop.database.PostgreSQLConnection;
import com.davaa.desktop.guest.Login;

public class App extends JFrame {

	private static final long serialVersionUID = 1L;
	public static double latitude = 47.91886785844874;
	public static double longitude = 106.91751029702353;

	public static ResourceBundle rb;
	public static  JDesktopPane desktopPane = new JDesktopPane();

	public static void main(String[] args) {

		Locale.setDefault(new Locale("en","EN"));
		App.rb = ResourceBundle.getBundle("com/davaa/desktop/utils/resource_bundle");

	 	PostgreSQLConnection.CreateTables();
		SwingUtilities.invokeLater(() -> {
//			JFrame frame = new JFrame("My Desktop App");
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame.setSize(800, 500);
//
//			frame.add(desktopPane);
//			frame.add(Login.initComponents());
//			desktopPane.add(SignIn.getPage());
//
//			frame.setVisible(true);
//
			Login LoginFrame = new Login();
			LoginFrame.setVisible(true);
//			LoginFrame.pack();
//			LoginFrame.setLocationRelativeTo(null);

//			ClientMain pageClientMain = new ClientMain();
//			pageClientMain.setVisible(true);
//			pageClientMain.pack();
//			pageClientMain.setLocationRelativeTo(null);
		});
	}
}
