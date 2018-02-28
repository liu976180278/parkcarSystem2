package com.parkhelp.controller.system.parkinfo;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.controller.system.ParkInfoController;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.service.system.parkinfo.ParkZoneInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

@Component
public class ZoneUpdateController {
	@Autowired(required = true)
	private ParkZoneInfoService parkZoneInfoService;
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@FXML
	private Label title;
	@FXML
	private TextField zonename;
	@FXML
	private TextField zonefreecount;
	@FXML
	private TextField maxtempcar;
	@FXML
	private TextField id;
	@FXML
	private Label sid;
	@FXML
	private TextField zonecount;
	@FXML
	private TextField vipcarcount;
	@FXML
	private ChoiceBox<String> billingindex_id;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;
	@FXML
	private AnchorPane  zonePane;

	public void initialize() {
		GoUi.dragged(title);
		parkZoneInfoService = (ParkZoneInfoService) SpringFxmlLoader.context
				.getBean("parkZoneInfoServiceImpl");
		parkInfoService = (ParkInfoService) SpringFxmlLoader.context
				.getBean("parkInfoServiceImpl");
		inint();
		click();
	}

	private void click() {
		btnNo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				btnNo.getScene().getWindow().hide();
			}
		});

		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
					try {
						if (ParkInfoController.state3.equalsIgnoreCase("update")) {
							updatePostInfo();
						}else if(ParkInfoController.state3.equalsIgnoreCase("add")){
							addPostInfo();
						}else if(ParkInfoController.state3.equalsIgnoreCase("detail")){
							btnOk.getScene().getWindow().hide();
						}
					} catch (Exception e) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("提示");
						alert.setHeaderText("操作失败");
						alert.showAndWait();
						e.printStackTrace();
					}
			}

			public void addPostInfo() {
				ParkZoneInfo zoneInfo = new ParkZoneInfo();
				zoneInfo.setUpdatetime(new Date());
				zoneInfo.setZonecount(Integer.parseInt(zonecount.getText()));
				zoneInfo.setZonefreecount(Integer.parseInt(zonefreecount.getText()));	
				zoneInfo.setZonename(zonename.getText());
				zoneInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				zoneInfo.setZonecount(Integer.parseInt(zonecount.getText()));
				zoneInfo.setVipcarcount(Integer.parseInt(vipcarcount.getText()));
				zoneInfo.setMaxtempcar(Integer.parseInt(maxtempcar.getText()));
				parkZoneInfoService.add(zoneInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
			
			public void updatePostInfo(){
				ParkZoneInfo zoneInfo = new ParkZoneInfo();
				zoneInfo.setId(ParkInfoController.sid3);
				zoneInfo.setUpdatetime(new Date());
				zoneInfo.setZonecount(Integer.parseInt(zonecount.getText()));
				zoneInfo.setZonefreecount(Integer.parseInt(zonefreecount.getText()));	
				zoneInfo.setZonename(zonename.getText());
				zoneInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				zoneInfo.setZonecount(Integer.parseInt(zonecount.getText()));
				zoneInfo.setVipcarcount(Integer.parseInt(vipcarcount.getText()));
				zoneInfo.setMaxtempcar(Integer.parseInt(maxtempcar.getText()));
				parkZoneInfoService.update(zoneInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
		});
	}

	private void inint() {
		if (!ParkInfoController.state3.equalsIgnoreCase("add")) {
			if (ParkInfoController.state3.equalsIgnoreCase("update")) {
				title.setText("区域信息修改");
			} else {
				title.setText("区域信息详情");
				zonePane.setDisable(true);
			}
			ParkZoneInfo postInfo = parkZoneInfoService
					.findById(ParkInfoController.sid3);
			zonename.setText(postInfo.getZonename());
			zonefreecount.setText(postInfo.getZonefreecount()+"");
			maxtempcar.setText(postInfo.getMaxtempcar()+"");
			id.setText(postInfo.getId());
			id.setEditable(false);
			zonecount.setText(postInfo.getZonecount()+"");
			vipcarcount.setText(postInfo.getVipcarcount()+"");
			billingindex_id.setItems(FXCollections.observableArrayList("活动规则1",
					" 活动规则2"));
			billingindex_id.getSelectionModel().select(0);
			
		
		} else if (ParkInfoController.state3.equalsIgnoreCase("add")) {
			title.setText("区域信息新增");
			id.setVisible(false);
			sid.setVisible(false);
			billingindex_id.setItems(FXCollections.observableArrayList("活动规则1",
					" 活动规则2"));
		}

	}
}
