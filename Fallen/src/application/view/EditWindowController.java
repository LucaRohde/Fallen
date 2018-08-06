package application.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import application.Main;
import application.util.FileHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditWindowController {

	public static Main main;

	public EditWindowController() {
		// TODO Auto-generated constructor stub
	}

	

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
			FileHandler.writeInFile("Test", arrayList);
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
		saveButton.setText("Speichern");
		
		//Gets text of the File into the textArea
		try {
			for (int i = 0; i < FileHandler.readOutString("Test").size(); i++) {
				text.setText(text.getText()+FileHandler.readOutString("Test").get(i)+"\n");
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
