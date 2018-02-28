package com.parkhelp.controller.system;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.WindowEvent;

import com.parkhelp.po.system.UserInfo;
import com.parkhelp.service.system.UserInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.MD5;
import com.parkhelp.util.SpringFxmlLoader;

public class UserInfoUpdateController {
	@Autowired(required = true)
	private UserInfoService userInfoService;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;
	@FXML
	private TextField userName;
	@FXML
	private DatePicker age;
	@FXML
	private PasswordField password;
	@FXML
	private TextField telNum;
	@FXML
	private TextField workNo;
	@FXML
	private TextField loginName;
	@FXML
	private ChoiceBox<String> sex;
	@FXML
	private ChoiceBox<String> role;
	@FXML
	private TextArea remark;
	@FXML
	private Label title;
	@FXML
	private AnchorPane userinfoPane;
	
	public void initialize() {
		GoUi.dragged(title);
		userInfoService = (UserInfoService) SpringFxmlLoader.context
				.getBean("userInfoServiceImpl");
		inint();
	}
	
	public void inint(){
		sex.setItems(FXCollections.observableArrayList("男", "女" ));
		role.setItems(FXCollections.observableArrayList("分管员工", "普通员工"));
		if(UserInfoController.status==0){
			title.setText("用户信息详情");
			reUserInfo();
			userinfoPane.setDisable(true);
		}else if(UserInfoController.status==1){
			title.setText("用户信息添加");
		}else if(UserInfoController.status==2){
			title.setText("用户信息修改");
			reUserInfo();
		}
		
		
		btnNo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				btnNo.getScene().getWindow().setOnHidden(new EventHandler<WindowEvent>() {
					public void handle(WindowEvent arg0) {
					}
				});
				btnNo.getScene().getWindow().hide();
			}
		});
		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				if(UserInfoController.status==0){
					btnOk.getScene().getWindow().hide();
				}else if(UserInfoController.status==1){
					addUserInfo();
				}else{
					updateUserInfo();
				}
			}
		});
	}
	
	public void addUserInfo(){
		if(userName.getText()==null||userName.getText().equals("")
				||age.getValue()==null||password.getText()==null||password.getText().equals("")
				||telNum.getText()==null||telNum.getText().equals("")||workNo.getText()==null
				||workNo.getText().equals("")||remark.getText()==null||remark.getText().equals("")
				||sex.getValue()==null||sex.getValue().equals("")
				||role.getValue()==null||sex.getValue().equals("")
					){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告！");
				alert.setHeaderText("不能有空选项！");
				alert.showAndWait();
			}else{
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(userName.getText());
				userInfo.setLoginname(loginName.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					userInfo.setAge(sdf.parse(age.getValue()+""));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				userInfo.setPassword(MD5.MD5(password.getText()));
				userInfo.setTelnum(telNum.getText());
				userInfo.setWorkNo(workNo.getText());
				userInfo.setRemark(remark.getText());
				String ssex = sex.getSelectionModel().getSelectedItem();
				String srole = role.getSelectionModel().getSelectedItem();
				userInfo.setCreatedTime(new Date());
				userInfo.setParkid_id("hzcl");
				if(ssex.equals("男")){
					userInfo.setSex(0);
				}else{
					userInfo.setSex(1);
				}
				if(srole.equals("普通员工")){
					userInfo.setRole(1);	
				}else{
					userInfo.setRole(11);	
				}
				userInfoService.addUserInfo(userInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
	}
	
	public void updateUserInfo(){
		if(userName.getText()==null||userName.getText().equals("")
				||age.getValue()==null||password.getText()==null||password.getText().equals("")
				||telNum.getText()==null||telNum.getText().equals("")||workNo.getText()==null
				||workNo.getText().equals("")||remark.getText()==null||remark.getText().equals("")
				||sex.getValue()==null||sex.getValue().equals("")
				||role.getValue()==null||sex.getValue().equals("")
					){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("警告！");
				alert.setHeaderText("不能有空选项！");
				alert.showAndWait();
			}else{
				UserInfo userInfo = new UserInfo();
				userInfo.setUsername(userName.getText());
				userInfo.setLoginname(loginName.getText());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					userInfo.setAge(sdf.parse(age.getValue()+""));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				userInfo.setPassword(password.getText());
				userInfo.setTelnum(telNum.getText());
				userInfo.setWorkNo(workNo.getText());
				userInfo.setRemark(remark.getText());
				String ssex = sex.getSelectionModel().getSelectedItem();
				String srole = role.getSelectionModel().getSelectedItem();
				userInfo.setParkid_id("hzcl");
				if(ssex.equals("男")){
					userInfo.setSex(0);
				}else{
					userInfo.setSex(1);
				}
				if(srole.equals("普通员工")){
					userInfo.setRole(1);	
				}else{
					userInfo.setRole(11);	
				}
				userInfo.setCreatedTime(userInfoService.findById(UserInfoController.id).getCreatedTime());
				userInfo.setUpdatedTime(new Date());
				userInfo.setId(UserInfoController.id);
				userInfoService.update(userInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
	}
	
	
	//数据回显
	public void reUserInfo(){
		String id =UserInfoController.id;
		UserInfo userInfo=  userInfoService.findById(id);
		userName.setText(userInfo.getUsername());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(userInfo.getAge());
		LocalDate endOfFeb = LocalDate.parse(date);
		age.setValue(endOfFeb);
		password.setText(userInfo.getPassword());
		telNum.setText(userInfo.getTelnum());
		workNo.setText(userInfo.getWorkNo());
		loginName.setText(userInfo.getLoginname());
		remark.setText(userInfo.getRemark());
		if((userInfo.getSex()+"").equals("0")){
			sex.getSelectionModel().select(0);
		}else {
			sex.getSelectionModel().select(1);
		}
		if((userInfo.getRole()+"").equals("1")){
			role.getSelectionModel().select(1);
		}else {
			role.getSelectionModel().select(0);
		}
	}
}
