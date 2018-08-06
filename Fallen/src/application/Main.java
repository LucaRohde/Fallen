package application;
	
import java.io.File;
import java.io.IOException;

import application.util.FileHandler;
import application.view.EditWindowController;
import application.view.StartWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	public Stage primaryStage;
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			this.primaryStage=primaryStage;
			this.primaryStage.setScene(loadScene("view/StartWindow.fxml"));
			this.primaryStage.show();
			controllerUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		FileHandler.fileChooser.setInitialDirectory(new File("src/application/resource/") );
		launch(args);
	}
	
	
	//Loads the wanted FXML-needs full path
	public Scene loadScene(String path) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(path));

				BorderPane border = (BorderPane) loader.load();
				
				Scene scene = new Scene(border);
				updatePrimaryStage(scene);
				return scene;

		} catch (IOException e) {
			
			//If something went wrong it loads an error
			e.printStackTrace();
			return new Scene(new BorderPane(new Label("Error")));
		}

	}//Referenziert die Main in den Controllern
	public void controllerUpdate() {
		StartWindowController.setMain(this);
		EditWindowController.setMain(this);
	}
	
	//Sets up Primary Stage and shows it
	public void updatePrimaryStage(Scene scene) {
		

		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
}
