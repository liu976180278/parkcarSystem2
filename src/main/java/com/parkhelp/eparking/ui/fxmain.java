package com.parkhelp.eparking.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class fxmain extends Application{

	@Override
	public void start(Stage stage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
		Scene scene = new Scene(root); 
		stage.setScene(scene);
		stage.setTitle("aa");
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
