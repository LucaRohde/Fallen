package application.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.util.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CharacterCreatorWindowController {

	public static Main main;

	File theChosenOne= null;
	
	@FXML
	private Label header = new Label();
	@FXML
	private Label nameLabel = new Label();
	@FXML
	private Label classLabel = new Label();
	@FXML
	private Label raceLabel = new Label();

	@FXML
	private TextField nameTextField = new TextField();
	
	@FXML
	private ChoiceBox classChoiceBox = new ChoiceBox();
	@FXML
	private ChoiceBox raceChoiceBox = new ChoiceBox();
	
	@FXML
	private Button saveButton = new Button();
	
	
	@FXML
	private void saveButtonAction() {
		//Creates file by name of Char
		try {
			FileHandler.createFile("entities/characters/playable_characters/"+nameTextField.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add(nameTextField.getText());
		arrayList.add(classChoiceBox.getValue().toString());
		arrayList.add(raceChoiceBox.getValue().toString());
		
		//Writes stuff in file that was just created
		try {
			FileHandler.writeInFile("entities/characters/playable_characters/"+nameTextField.getText(), arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() {
		header.setText("Erstelle deinen Helden");
		nameLabel.setText("Name:");
		classLabel.setText("Klasse");
		raceLabel.setText("Rasse:");
		
		nameTextField.setText("Name");
		
		classChoiceBox.setItems(FileHandler.getNameOfFilesInFolder("entities/classes"));
		raceChoiceBox.setItems(FileHandler.getNameOfFilesInFolder("entities/races"));
		
		saveButton.setText("Editieren");
	}

	public static void setMain(Main main) {
		CharacterCreatorWindowController.main = main;

	}

	
}
