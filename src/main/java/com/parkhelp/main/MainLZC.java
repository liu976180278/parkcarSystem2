package com.parkhelp.main;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class MainLZC extends Application {
	public static Stage mainStage;
	@Override
	public void start(Stage stage) throws Exception {
		mainStage = stage;
		Parent root = FXMLLoader.load(MainLZC.class
				.getResource("/com/parkhelp/view/main/main.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("main.css").toExternalForm());
		stage.setScene(scene);
		stage.initStyle(StageStyle.TRANSPARENT);// 去点windows自带的框
		stage.setTitle("停车帮");
		stage.setMaximized(true);
		stage.getIcons().add(
				new Image(getClass().getResourceAsStream(
						"/com/parkhelp/image/main/main.png")));
		// 监听主窗口关闭事件
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent arg0) {
				System.exit(0);
			}
		});
		stage.show();
		// 全屏
		// stage.setFullScreen(true);
	}

	public static void main(String[] args) {
		launch(args);
	}

}
