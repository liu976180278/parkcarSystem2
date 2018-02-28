package com.parkhelp.controller.system.parkinfo;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.controller.system.ParkInfoController;
import com.parkhelp.po.system.parkinfo.ParkInfo;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;
@Component
public class ParkUpdateController {
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@FXML
	private TextField parkno;
	@FXML
	private TextField PARK_REGIONID;
	@FXML
	private TextField longitude;
	@FXML
	private TextField parkaddress;
	@FXML
	private TextField freecount;
	@FXML
	private TextField remark;
	@FXML
	private TextField park_freetime;
	@FXML
	private TextField park_agentid;
	@FXML
	private TextField parkname;
	@FXML
	private TextField PARK_BAYNUM;
	@FXML
	private TextField latitude;
	@FXML
	private TextField spacecount;
	@FXML
	private TextField parkphoto;
	@FXML
	private TextField PARK_FEEINDEX;
	@FXML
	private TextField PARK_FEELEVEL;
	@FXML
	private TextField videoDiskRecorderIp;
	@FXML
	private TextField PARK_FEEDESC;
	@FXML
	private ChoiceBox<String> park_type;
	@FXML
	private ChoiceBox<String> enableVideoDiskRecorder;
	@FXML
	private ChoiceBox<String> park_logon;
	@FXML
	private ChoiceBox<String> park_subtype;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;
	@FXML
	private Label title;

	public void initialize() {
		GoUi.dragged(title);
		parkInfoService = (ParkInfoService) SpringFxmlLoader.context
				.getBean("parkInfoServiceImpl");
		inint();
		click();
	}

	public void inint() {
		//GoUi.dragged(title);
		ParkInfo parkInfo = parkInfoService.findById(ParkInfoController.sid1);
		parkno.setText(parkInfo.getParkno());
		PARK_REGIONID.setText(parkInfo.getPARK_REGIONID());
		longitude.setText(parkInfo.getLongitude()+"");
		parkaddress.setText(parkInfo.getParkaddress());
		freecount.setText(parkInfo.getFreecount()+"");
		remark.setText(parkInfo.getRemark());
		park_freetime.setText(parkInfo.getPark_freetime()+"");
		park_agentid.setText(parkInfo.getPark_agentid());
		parkname.setText(parkInfo.getParkname());
		PARK_BAYNUM.setText(parkInfo.getPARK_BAYNUM()+"");
		latitude.setText(parkInfo.getLatitude()+"");
		spacecount.setText(parkInfo.getSpacecount()+"");
		parkphoto.setText(parkInfo.getParkphoto());
		PARK_FEEINDEX.setText(parkInfo.getPARK_FEEINDEX());
		PARK_FEELEVEL.setText(parkInfo.getPARK_FEELEVEL()+"");
		videoDiskRecorderIp.setText(parkInfo.getVideoDiskRecorderIp());
		PARK_FEEDESC.setText(parkInfo.getPARK_FEEDESC());
		park_type.setItems(FXCollections.observableArrayList("路边", "路外" ));
		enableVideoDiskRecorder.setItems(FXCollections.observableArrayList("不启用", "启用"));
		park_logon.setItems(FXCollections.observableArrayList("上班", "下班"));
		park_subtype.setItems(FXCollections.observableArrayList("景区", "非景区"));
		if((parkInfo.getPark_type()+"").equals("1")){
			park_type.getSelectionModel().select(0);
		}else {
			park_type.getSelectionModel().select(1);
		}
		if((parkInfo.getEnableVideoDiskRecorder()+"").equals("0")){
			enableVideoDiskRecorder.getSelectionModel().select(0);
		}else {
			enableVideoDiskRecorder.getSelectionModel().select(1);
		}
		if((parkInfo.getPark_logon()+"").equals("1")){
			park_logon.getSelectionModel().select(0);
		}else {
			park_logon.getSelectionModel().select(1);
		}
		
		if((parkInfo.getPark_subtype()+"").equals("22")){
			park_subtype.getSelectionModel().select(0);
		}else {
			park_subtype.getSelectionModel().select(1);
		}
	}
	
	public void click(){
		btnNo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				btnNo.getScene().getWindow().hide();
			}
		});
		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					ParkInfo parkInfo = new ParkInfo();
					parkInfo.setId(ParkInfoController.sid1);
					parkInfo.setPARK_BAYNUM(Integer.parseInt(PARK_BAYNUM.getText())); 				
					parkInfo.setPARK_FEEINDEX(PARK_BAYNUM.getText());
					parkInfo.setPARK_FEEDESC(PARK_FEEDESC.getText());		
					parkInfo.setPARK_FEELEVEL(Integer.parseInt(PARK_FEELEVEL.getText()));				
					parkInfo.setPARK_REGIONID(PARK_REGIONID.getText());;			
					parkInfo.setFreecount(Integer.parseInt(freecount.getText()));;
					parkInfo.setLatitude(Double.parseDouble(latitude.getText()));;				
					parkInfo.setPark_agentid(park_agentid.getText());		
					parkInfo.setPark_freetime(Integer.parseInt(park_freetime.getText()));				
					parkInfo.setParkaddress(parkaddress.getText());;
					parkInfo.setParkname(parkname.getText());
					parkInfo.setParkno(parkno.getText());
					parkInfo.setParkphoto(parkphoto.getText());
					parkInfo.setRemark(remark.getText());
					parkInfo.setSpacecount(Integer.parseInt(spacecount.getText()));				
					parkInfo.setVideoDiskRecorderIp(videoDiskRecorderIp.getText());
					String VideoDisk = enableVideoDiskRecorder.getSelectionModel().getSelectedItem();
					String type = park_type.getSelectionModel().getSelectedItem();
					String logon = park_logon.getSelectionModel().getSelectedItem();
					String subtype = park_subtype.getSelectionModel().getSelectedItem();
					if(VideoDisk.equals("不启用")){
						parkInfo.setEnableVideoDiskRecorder(0);
					}else{
						parkInfo.setEnableVideoDiskRecorder(1);
					}
					if(type.equals("路边")){
						parkInfo.setPark_type(1);	
					}else{
						parkInfo.setPark_type(2);	
					}
					if(logon.equals("上班")){
						parkInfo.setPark_logon(1+"");	
					}else{
						parkInfo.setPark_logon(2+"");	
					}
					if(subtype.equals("景区")){
						parkInfo.setPark_subtype(22);	
					}else{
						parkInfo.setPark_subtype(23);	
					}
					parkInfoService.update(parkInfo);
					btnOk.getScene().getWindow().hide();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示");
					alert.setHeaderText("操作成功");
					alert.showAndWait();
				} catch (Exception e) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示");
					alert.setHeaderText("操作失败");
					alert.showAndWait();
					e.printStackTrace();
				}
			}
		});
	}
	

}
