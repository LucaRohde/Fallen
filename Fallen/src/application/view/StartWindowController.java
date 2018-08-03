package application.view;

import java.io.IOException;

import application.Main;
import application.util.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class StartWindowController {

	public static Main main;

	public StartWindowController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	private Label header = new Label("The Fallen");

	@FXML
	private Button changeHeaderButton = new Button("�ndere �berschrift");

	@FXML
	private void changeHeaderButtonAction() {

		try {
			header.setText(
					FileHandler.readOutString("Test")
					);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() {
		header.setText("The Fallen");
		changeHeaderButton.setText("�ndere �berschrift");
	}

	public static void setMain(Main main) {
		StartWindowController.main = main;

	}
}
