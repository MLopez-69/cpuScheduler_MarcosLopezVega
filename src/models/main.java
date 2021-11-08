package models;

import controller.mainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class main extends Application{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
				Pane mainPane=(Pane) FXMLLoader.load(main.class.getResource("/views/mainView.fxml"));
				primaryStage.setScene(new Scene(mainPane));
				primaryStage.show();
	}

	

}
