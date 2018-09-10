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

	@FXML
	private Label header = new Label("The Fallen");

	@FXML
	private Button editButton = new Button();

	@FXML
	private Button createCharButton = new Button();

	@FXML
	private void editButtonAction() {

		main.loadScene("view/EditWindow.fxml");

	}

	@FXML
	private void createCharakterButtonAction() {

		main.loadScene("view/CharacterCreatorWindow.fxml");

	}

	@FXML
	private void initialize() {
		header.setText("The Fallen");
		editButton.setText("Editieren");
		createCharButton.setText("Erstelle Charakter");
	}

	public static void setMain(Main main) {
		StartWindowController.main = main;

	}
}
