package com.parkhelp.controller.main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;
import com.parkhelp.main.MainLZC;
import com.parkhelp.util.SpringFxmlLoader;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class MainController {
	public static int viedoState=0;//是否从新加载视屏0为Y，1No
	@FXML 
	private Pane viedo;
	@FXML
	private Pane system;
	@FXML
	private Pane tab3;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private  Label mainLabel;
	@FXML
	private Button min;
	@FXML
	private Button close;
	Timer timer = new Timer();
	public void initialize() {
		// spring 加载
		try {
			SpringFxmlLoader.load();
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("spring");
			alert.setHeaderText(e.getMessage());
			alert.showAndWait();
		}
		ininvideo();
		setMainLabel();  
		ininImageview();
	}
	//main top
	public void ininImageview() {
		min.setOnMouseEntered(new EventHandler<Event>() {
			public void handle(Event arg0) { 
				min.setStyle("-fx-background-color: #921AFF");
			}
		});
		min.setOnMouseExited(new EventHandler<Event>() {
			public void handle(Event arg0) { 
				min.setStyle("-fx-background-color: #9999CC");
			}
		});
		min.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				MainLZC.mainStage.setIconified(true);
			}
		});
		close.setOnMouseEntered(new EventHandler<Event>() {
			public void handle(Event arg0) { 
				close.setStyle("-fx-background-color: #FF0000");
			}
		});
		close.setOnMouseExited(new EventHandler<Event>() {
			public void handle(Event arg0) { 
				close.setStyle("-fx-background-color: #EA0000");
			}
		});
		close.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("提示");
				alert.setHeaderText("你确认要直接退出系统吗？");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					MainLZC.mainStage.hide();
					//com.parkhelp.eparking.api.WTY_EX.INSTANCE.WTY_QuitSDK();
					System.exit(-1);
				} else {
					//System.out.println("no");
				}
			}
		});
		
		viedo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				ininvideo();
			}
		});
		
		system.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					AnchorPane child = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/com/parkhelp/view/system/system.fxml"));
					List list = anchorPane.getChildren();
					Toolkit kit = Toolkit.getDefaultToolkit();
				    Dimension  screensize= kit. getScreenSize();
					child.setPrefHeight(screensize. height);
					child.setPrefWidth(screensize. width);
					if (list.size() > 0) {
						anchorPane.getChildren().remove(0);
					}
					anchorPane.getChildren().addAll(child);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		tab3.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					AnchorPane child = (AnchorPane) FXMLLoader.load(getClass()
							.getResource("/com/parkhelp/view/billing/billingMain.fxml"));
					List list = anchorPane.getChildren();
					Toolkit kit = Toolkit.getDefaultToolkit();
				    Dimension  screensize= kit. getScreenSize();
					child.setPrefHeight(screensize. height);
					child.setPrefWidth(screensize. width);
					if (list.size() > 0) {
						anchorPane.getChildren().remove(0);
					}
					anchorPane.getChildren().addAll(child);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	
		
	
	}
	
	
	//自动更新时间
	public void setMainLabel() {
		timer.schedule(new TimerTask() {
			public void run() {
				Platform.runLater(new Runnable() {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
					String time = sdf.format(new Date());
					public void run() {
						mainLabel.setText(time);
					}
				});
				setMainLabel();
			}
		}, 1000);// 设定指定的时间time,此处为1000毫秒
	}
	
	
	private void ininvideo(){
		try {
			AnchorPane child = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/com/parkhelp/view/video/video4.fxml"));
			List list = anchorPane.getChildren();
			Toolkit kit = Toolkit.getDefaultToolkit();
		    Dimension  screensize= kit. getScreenSize();
			child.setPrefHeight(screensize. height-180);
			child.setPrefWidth(screensize. width);
			if (list.size() > 0) {
				anchorPane.getChildren().remove(0);
			}
			anchorPane.getChildren().addAll(child);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
