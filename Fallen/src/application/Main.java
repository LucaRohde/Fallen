package application;
	
import java.io.IOException;

import application.view.StartWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			primaryStage.setScene(loadScene("view/StartWindow.fxml"));
			primaryStage.show();
			controllerUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	//Diese Methode lädt die gewünschte FXML
	public Scene loadScene(String path) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource(path));

				BorderPane border = (BorderPane) loader.load();
				
				Scene scene = new Scene(border);
				return scene;

		} catch (IOException e) {
			
			//Nur wenn es nicht klappt wird ein Border Pane mit ERROR geladen
			e.printStackTrace();
			return new Scene(new BorderPane(new Label("Error")));
		}

	}//Referenziert die Main in den Controllern
	public void controllerUpdate() {
		StartWindowController.setMain(this);
	}
}
