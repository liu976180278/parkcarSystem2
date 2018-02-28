package com.parkhelp.controller.system;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.po.system.UserInfo;
import com.parkhelp.service.system.UserInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;
import com.parkhelp.vo.system.UserInfoVo;

@Component
public class UserInfoController {
	@Autowired(required = true)
	private UserInfoService userInfoService;
	@FXML
	private TableView<UserInfoVo> userInfoTable;
	@FXML
	private TableColumn<UserInfoVo, String> workNo;
	@FXML
	private TableColumn<UserInfoVo, String> userName;
	@FXML
	private TableColumn<UserInfoVo, String> loginName;
	@FXML
	private TableColumn<UserInfoVo, String> role;
	@FXML
	private TableColumn<UserInfoVo, String> sex;
	@FXML
	private TableColumn<UserInfoVo, String> telnum;
	@FXML
	private TableColumn<UserInfoVo, String> age;
	@FXML
	private TableColumn<UserInfoVo, String> remark;
	@FXML
	private TableColumn<UserInfoVo, String> createdTime;
	@FXML
	private TableColumn<UserInfoVo, String> updatedTime;
	@FXML
	private TableColumn<UserInfoVo, String> dbStatus;
	// 集合数据
	private ObservableList<UserInfoVo> data;

	@FXML
	private Button findUserInfo;// 查询按钮
	@FXML
	private Button deleteUserInfo;// 删除按钮
	@FXML
	private Button detailUserInfo;// 查看按钮 
	@FXML
	private Button addUserInfo;// 添加按钮 
	@FXML
	private Button updateUserInfo;// 修改按钮 

	@FXML
	private TextField textUserName;
	@FXML
	private TextField textLoginrName;
	public static String id;// 更新查看所需要的id
	public static int status;// 根据状态，才知道是查看，添加，修改

	public void initialize() {
		userInfoService = (UserInfoService) SpringFxmlLoader.context
				.getBean("userInfoServiceImpl");
		onMouseClick();
		changData();
	}

	public void onMouseClick() {
		findUserInfo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				changData();
			}
		});
		addUserInfo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					status = 1;
					Stage stage=GoUi.goNewUi("/com/parkhelp/view/system/userinfoUpdate.fxml", "用户管理");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									changData();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		updateUserInfo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				status = 2;
				TableViewSelectionModel<UserInfoVo> selectionModel = userInfoTable
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				UserInfoVo UserInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					id = UserInfoVo.getId();
					try {
						Stage stage=GoUi.goNewUi("/com/parkhelp/view/system/userinfoUpdate.fxml", "用户管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										changData();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做修改");
					alert.showAndWait();
				}
			}
		});
		detailUserInfo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				status = 0;
				TableViewSelectionModel<UserInfoVo> selectionModel = userInfoTable
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				UserInfoVo UserInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					id = UserInfoVo.getId();
					try {
						Stage stage=GoUi.goNewUi("/com/parkhelp/view/system/userinfoUpdate.fxml", "用户管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										changData();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做查看");
					alert.showAndWait();
				}
			}
		});
		deleteUserInfo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<UserInfoVo> selectionModel = userInfoTable
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				UserInfoVo userInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						data.remove(index);
						userInfoService.delete(userInfoVo.getId());
					} else {
						System.out.println("no");
					}
				}else{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，在删除");
					alert.showAndWait();
				}
			}
		});
	}

	public void changData() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUsername(textUserName.getText());
		userInfo.setLoginname(textLoginrName.getText());
		ArrayList<UserInfo> userInfos = (ArrayList<UserInfo>) userInfoService
				.findAll(userInfo);
		ArrayList<UserInfoVo> userInfoVos=new ArrayList<UserInfoVo>();
		for(UserInfo u :userInfos){
			userInfoVos.add(new UserInfoVo(u));
		}
		data = FXCollections.observableList(userInfoVos);
		workNo.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"workNo"));
		userName.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"userName"));
		loginName
				.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
						"loginName"));
		role.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"role"));
		sex.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"sex"));
		telnum.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"telnum"));
		age.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>("age"));
		remark.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"remark"));
		createdTime
				.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
						"createdTime"));
		updatedTime
				.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
						"updatedTime"));
		dbStatus.setCellValueFactory(new PropertyValueFactory<UserInfoVo, String>(
				"dbStatus"));
		userInfoTable.setItems(data);
	}

}
