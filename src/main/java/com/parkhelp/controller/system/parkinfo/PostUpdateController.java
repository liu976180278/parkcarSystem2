package com.parkhelp.controller.system.parkinfo;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.controller.system.ParkInfoController;
import com.parkhelp.po.system.parkinfo.PostInfo;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.service.system.parkinfo.PostInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;

@Component
public class PostUpdateController {
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@Autowired(required = true)
	private PostInfoService postInfoService;
	@FXML
	private TextField post_name;
	@FXML
	private ChoiceBox<String> post_type;
	@FXML
	private TextArea remark;
	@FXML
	private Label title;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;

	public void initialize() {
		GoUi.dragged(title);
		postInfoService = (PostInfoService) SpringFxmlLoader.context
				.getBean("postInfoServiceImpl");
		parkInfoService = (ParkInfoService) SpringFxmlLoader.context
				.getBean("parkInfoServiceImpl");
		inint();
		click();
	}

	private void inint() {
		if (!ParkInfoController.state2.equalsIgnoreCase("add")) {
			if(ParkInfoController.state2.equalsIgnoreCase("update")){
				title.setText("岗亭信息修改");
			}else{
				title.setText("岗亭信息详情");
				/*post_name.setFocusTraversable(false);
				post_name.setEditable(false);
				remark.setEditable(false);
				post_type.setFocusTraversable(false);*/
			}
			PostInfo postInfo = postInfoService
					.findById(ParkInfoController.sid2);
			post_name.setText(postInfo.getPost_name());
			remark.setText(postInfo.getRemark());
			post_type.setItems(FXCollections.observableArrayList("单通道", " 双通道"));
			if ((postInfo.getPost_type() + "").equals("0")) {
				post_type.getSelectionModel().select(0);
			} else {
				post_type.getSelectionModel().select(1);
			}
		} else if (ParkInfoController.state2.equalsIgnoreCase("add")) {
			title.setText("岗亭信息新增");
			post_type.setItems(FXCollections.observableArrayList("单通道", "双通道"));
		}

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
						if (ParkInfoController.state2.equalsIgnoreCase("update")) {
						updatePostInfo();
						}else if(ParkInfoController.state2.equalsIgnoreCase("add")){
							addPostInfo();
						}else if(ParkInfoController.state2.equalsIgnoreCase("detail")){
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
				PostInfo postInfo = new PostInfo();
				postInfo.setPost_name(post_name.getText());
				postInfo.setRemark(remark.getText());
				postInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				String type = post_type.getSelectionModel()
						.getSelectedItem();
				if (type.equals("单通道")) {
					postInfo.setPost_type(0);
				} else {
					postInfo.setPost_type(1);
				}
				postInfoService.add(postInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
			
			public void updatePostInfo(){
				PostInfo postInfo = new PostInfo();
				postInfo.setId(ParkInfoController.sid2);
				postInfo.setPost_name(post_name.getText());
				postInfo.setRemark(remark.getText());
				postInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				String type = post_type.getSelectionModel()
						.getSelectedItem();
				if (type.equals("单通道")) {
					postInfo.setPost_type(0);
				} else {
					postInfo.setPost_type(1);
				}
				postInfoService.update(postInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
		});
	}
	
	
}
