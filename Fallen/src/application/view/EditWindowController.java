package application.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
import application.util.FileHandler;
import javafx.fxml.FXML;
import javafx.fxml.LoadException;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class EditWindowController {

	public static Main main;

	//The Chosen File; it used to be like a brother to you
	File theChosenOne= null;
	
	@FXML
	private Label header = new Label();
	
	@FXML
	private Button saveButton = new Button();

	@FXML
	private Button backButton = new Button();
	
	@FXML
	private TextArea text = new TextArea();
	
	@FXML
	private void saveButtonAction() {
		//Creates an array out of the text area and then converts it into an arrayList to use it in .writeInFile()
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(text.getText().split("\n")));
		
		try {
			FileHandler.writeInFile(theChosenOne.getName(), arrayList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	private void backButtonAction() {
		
		main.loadScene("view/StartWindow.fxml");
		
	}
	
	

	@FXML
	private void initialize() {
		
		theChosenOne= FileHandler.fileChooser.showOpenDialog(main.primaryStage);
		saveButton.setText("Speichern");
		backButton.setText("Zurück");
		header.setText(theChosenOne.getName().replace(".txt", ""));
		
		//Gets text of the File into the textArea
		try {
			for (int i = 0; i < FileHandler.readOutString(theChosenOne.getName()).size(); i++) {
				text.setText(text.getText()+FileHandler.readOutString(theChosenOne.getName()).get(i)+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

	public static void setMain(Main main) {
		EditWindowController.main = main;

	}
}
