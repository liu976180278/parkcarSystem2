package com.parkhelp.util;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.parkhelp.main.MainLZC;

public class GoUi {
	private static double x;
	private static double y;
	public static Stage goNewUi(String path,String Title) throws IOException{
		final Parent root = FXMLLoader.load(GoUi.class.getResource(
				path));
		Stage stage = new Stage();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle(Title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(MainLZC.mainStage);
		stage.initStyle(StageStyle.TRANSPARENT);//去点windows自带的框
		/*stage.setResizable(false);
		stage.initStyle(StageStyle. UTILITY);//显示x   和不可拖拽一起用*/	
	stage.show();
		return stage;
	}
	
	public static void goOldUi(String path,Pane pane) throws IOException {
		AnchorPane child = (AnchorPane) FXMLLoader.load(GoUi.class.getResource(path));
		List list = pane.getChildren();
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension  screensize= kit. getScreenSize();
		child.setPrefHeight(screensize. height-240);
		child.setPrefWidth(screensize. width-230);
		if (list.size() > 0) {
			pane.getChildren().remove(0);
		}
		pane.getChildren().addAll(child);
	}
	
	public static void dragged(final Node node){
		node.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				 x = node.getScene().getWindow().getX() - arg0.getScreenX();
				 y = node.getScene().getWindow().getY() - arg0.getScreenY();
			}
		});
		node.setOnMouseDragged(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent arg0) {
				node.getScene().getWindow().setX(arg0.getScreenX()+x);
				node.getScene().getWindow().setY(arg0.getScreenY()+y);
			}
		});
		
	}
	
	
}
