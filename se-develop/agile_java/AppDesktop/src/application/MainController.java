package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private TextField labelUserName;
    @FXML
    private TextField labelPassword;

    public void handleLoginButton(ActionEvent event) {
    	System.out.print("call");
        System.out.print("\n" + labelUserName.getText());
        System.out.print("\n" + labelPassword.getText());
    }
}
