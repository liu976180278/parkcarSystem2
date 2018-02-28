package com.parkhelp.controller.system.parkinfo;
import java.util.ArrayList;
import java.util.List;

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
import javafx.scene.layout.AnchorPane;

import org.springframework.beans.factory.annotation.Autowired;

import com.parkhelp.controller.system.ParkInfoController;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
import com.parkhelp.po.system.parkinfo.PostInfo;
import com.parkhelp.po.system.parkinfo.PublicledInfo;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.service.system.parkinfo.ParkZoneInfoService;
import com.parkhelp.service.system.parkinfo.PublicledInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;

public class LedUpdateController {
	@Autowired(required = true)
	private PublicledInfoService publicledInfoService;
	@Autowired(required = true)
	private ParkZoneInfoService parkZoneInfoService;
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@FXML
	private Label title;
	@FXML
	private AnchorPane ledPane;
	@FXML
	private TextField ledname;
	@FXML
	private TextField ledip;
	@FXML
	private TextField actionspeed;
	@FXML
	private TextField partWidth;
	@FXML
	private TextField coordinateX;
	@FXML
	private TextField fontsize;
	@FXML
	private TextField holdtime;
	@FXML
	private TextField cardaddress;
	@FXML
	private TextField numcount;
	@FXML
	private TextField partHeight;
	@FXML
	private TextField coordinateY;
	@FXML
	private TextArea texttmp;
	@FXML
	private ChoiceBox<String> actiontype;
	@FXML
	private ChoiceBox<String> ledbrand;
	@FXML
	private ChoiceBox<String> zone_id;
	@FXML
	private ChoiceBox<String> fontbold;
	@FXML
	private ChoiceBox<String> isused;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;

	public void initialize() {
		GoUi.dragged(title);
		publicledInfoService = (PublicledInfoService) SpringFxmlLoader.context
				.getBean("publicledInfoServiceImpl");
		parkZoneInfoService = (ParkZoneInfoService) SpringFxmlLoader.context
				.getBean("parkZoneInfoServiceImpl");
		parkInfoService=(ParkInfoService) SpringFxmlLoader.context
		.getBean("parkInfoServiceImpl");
		inint();
		click();
	}

	private void inint() {
		ArrayList<String> zoneName = new ArrayList<String>();
		List<ParkZoneInfo> parkZoneInfo = parkZoneInfoService.findAll(null);
		for (ParkZoneInfo zone : parkZoneInfo) {
			zoneName.add(zone.getZonename());
		}
		zone_id.setItems(FXCollections.observableArrayList(zoneName));
		actiontype.setItems(FXCollections.observableArrayList("立即显示", "连续左移"));
		ledbrand.setItems(FXCollections.observableArrayList("DSGD", "FRTK"));
		fontbold.setItems(FXCollections.observableArrayList("细", "粗"));
		isused.setItems(FXCollections.observableArrayList("启用", "未启用"));
		zone_id.getSelectionModel().select(0);
		actiontype.getSelectionModel().select(0);
		ledbrand.getSelectionModel().select(0);
		fontbold.getSelectionModel().select(0);
		isused.getSelectionModel().select(0);
		if (!ParkInfoController.state5.equalsIgnoreCase("add")) {
			if (ParkInfoController.state5.equalsIgnoreCase("update")) {
				title.setText("LED信息修改");
			} else {
				title.setText("LED信息详情");
				ledPane.setDisable(true);
			}
			PublicledInfo info  =new PublicledInfo();
			info=publicledInfoService.findById(ParkInfoController.sid5);
			 ledname.setText(info.getLedname());
			 ledip.setText(info.getLedip());
			 actionspeed.setText(info.getActionspeed()+"");
			 partWidth.setText(info.getPartWidth()+"");
			 coordinateX.setText(info.getCoordinateX()+"");
			 fontsize.setText(info.getFontsize()+"");
			 holdtime.setText(info.getHoldtime()+"");
			cardaddress.setText(info.getCardaddress()+"");
			 numcount.setText(info.getNumcount()+"");
			 partHeight.setText(info.getPartHeight()+"");
			 coordinateY.setText(info.getCoordinateY()+"");
			 texttmp.setText(info.getTexttmp());
			 if(info.getActiontype()!=null){
				 if(info.getActiontype().equals("1")){
					 actiontype.getSelectionModel().select(0);
				 }else{
					 actiontype.getSelectionModel().select(1);
				 }
			 }
			 if(info.getLedbrand().equals("Socket")){
				 ledbrand.getSelectionModel().select(0);
			 }else{
				 ledbrand.getSelectionModel().select(0);
			 }
			 if(info.getFontbold()==0){
				 fontbold.getSelectionModel().select(0);
			 }else{
				 fontbold.getSelectionModel().select(1);
			 }
			 if(info.getIsused()==0){
				 isused.getSelectionModel().select(0);
			 }else{
				 isused.getSelectionModel().select(1);
			 }
			 if (info.getParkZoneInfo()!=null) {
					zone_id.getSelectionModel().select(
							info.getParkZoneInfo().getZonename());
				}
		}else{
			title.setText("LED信息新增");
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
						if (ParkInfoController.state5.equalsIgnoreCase("update")) {
							updateLedInfo();
						}else if(ParkInfoController.state5.equalsIgnoreCase("add")){
							addLedInfo();
						}else if(ParkInfoController.state5.equalsIgnoreCase("detail")){
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

			public void addLedInfo() {
				PublicledInfo  ledInfo= new PublicledInfo();
				
				ledInfo.setLedname(ledname.getText());
				ledInfo.setLedip(ledip.getText());
				ledInfo.setTexttmp(texttmp.getText());
				if(holdtime.getText()==null||"".equals(holdtime.getText())){
					ledInfo.setHoldtime(0);
				}else{
					ledInfo.setHoldtime(Integer.parseInt(holdtime.getText()));
				}
				if(coordinateY.getText()==null||"".equals(coordinateY.getText())){
					ledInfo.setCoordinateY(0);
				}else{
					ledInfo.setCoordinateY(Integer.parseInt(coordinateY.getText()));
				}
				if(coordinateX.getText()==null||"".equals(coordinateX.getText())){
					ledInfo.setCoordinateX(0);
				}else{
					ledInfo.setCoordinateX(Integer.parseInt(coordinateX.getText()));
				}
				if(partHeight.getText()==null||"".equals(partHeight.getText())){
					ledInfo.setPartHeight(0);
				}else{
					ledInfo.setPartHeight(Integer.parseInt(partHeight.getText()));
				}
				if(partWidth.getText()==null||"".equals(partWidth.getText())){
					ledInfo.setPartWidth(0);
				}else{
					ledInfo.setPartWidth(Integer.parseInt(partWidth.getText()));
				}
				if(cardaddress.getText()==null||"".equals(cardaddress.getText())){
					ledInfo.setCardaddress(0);
				}else{
					ledInfo.setCardaddress(Integer.parseInt(cardaddress.getText()));
				}
				if(actionspeed.getText()==null||"".equals(actionspeed.getText())){
					ledInfo.setActionspeed(0);
				}else{
					ledInfo.setActionspeed(Integer.parseInt(actionspeed.getText()));
				}
				if(numcount.getText()==null||"".equals(numcount.getText())){
					ledInfo.setNumcount(0);
				}else{
					ledInfo.setNumcount(Integer.parseInt(numcount.getText()));
				}
				if(fontsize.getText()==null||"".equals(fontsize.getText())){
					ledInfo.setFontsize(0);
				}else{
					ledInfo.setFontsize(Integer.parseInt(fontsize.getText()));
				}
				
				String font = fontbold.getSelectionModel()
						.getSelectedItem();
				if (font.equals("细")) {
					ledInfo.setFontbold(0);
				} else {
					ledInfo.setFontbold(1);
				}
				String atype = actiontype.getSelectionModel()
						.getSelectedItem();
				if (atype.equals("立即显示")) {
					ledInfo.setActiontype("1");
				} else {
					ledInfo.setActiontype("3");
				}
				
				String isuse = isused.getSelectionModel()
						.getSelectedItem();
				if (isuse.equals("启用")) {
					ledInfo.setIsused(0);
				} else {
					ledInfo.setIsused(1);
				}
				
				String brand = ledbrand.getSelectionModel()
						.getSelectedItem();
				if (brand.equals("DSGD")) {
					ledInfo.setLedbrand("Socket");
				} else {
					ledInfo.setLedbrand("AllInOne");
				}
				
				String zone = zone_id.getSelectionModel()
						.getSelectedItem();
				ParkZoneInfo parkZoneInfo=new ParkZoneInfo();
				parkZoneInfo.setZonename(zone);
				String zoneid = parkZoneInfoService.findAll(parkZoneInfo).get(0).getId();
				ledInfo.setZone_id(zoneid);
				ledInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				publicledInfoService.add(ledInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
			
			public void updateLedInfo(){
				PublicledInfo  ledInfo= new PublicledInfo();
				ledInfo.setId(ParkInfoController.sid5);
				ledInfo.setLedname(ledname.getText());
				ledInfo.setLedip(ledip.getText());
				ledInfo.setTexttmp(texttmp.getText());
				if(holdtime.getText()==null||"".equals(holdtime.getText())){
					ledInfo.setHoldtime(0);
				}else{
					ledInfo.setHoldtime(Integer.parseInt(holdtime.getText()));
				}
				if(coordinateY.getText()==null||"".equals(coordinateY.getText())){
					ledInfo.setCoordinateY(0);
				}else{
					ledInfo.setCoordinateY(Integer.parseInt(coordinateY.getText()));
				}
				if(coordinateX.getText()==null||"".equals(coordinateX.getText())){
					ledInfo.setCoordinateX(0);
				}else{
					ledInfo.setCoordinateX(Integer.parseInt(coordinateX.getText()));
				}
				if(partHeight.getText()==null||"".equals(partHeight.getText())){
					ledInfo.setPartHeight(0);
				}else{
					ledInfo.setPartHeight(Integer.parseInt(partHeight.getText()));
				}
				if(partWidth.getText()==null||"".equals(partWidth.getText())){
					ledInfo.setPartWidth(0);
				}else{
					ledInfo.setPartWidth(Integer.parseInt(partWidth.getText()));
				}
				if(cardaddress.getText()==null||"".equals(cardaddress.getText())){
					ledInfo.setCardaddress(0);
				}else{
					ledInfo.setCardaddress(Integer.parseInt(cardaddress.getText()));
				}
				if(actionspeed.getText()==null||"".equals(actionspeed.getText())){
					ledInfo.setActionspeed(0);
				}else{
					ledInfo.setActionspeed(Integer.parseInt(actionspeed.getText()));
				}
				if(numcount.getText()==null||"".equals(numcount.getText())){
					ledInfo.setNumcount(0);
				}else{
					ledInfo.setNumcount(Integer.parseInt(numcount.getText()));
				}
				if(fontsize.getText()==null||"".equals(fontsize.getText())){
					ledInfo.setFontsize(0);
				}else{
					ledInfo.setFontsize(Integer.parseInt(fontsize.getText()));
				}
				
				String font = fontbold.getSelectionModel()
						.getSelectedItem();
				if (font.equals("细")) {
					ledInfo.setFontbold(0);
				} else {
					ledInfo.setFontbold(1);
				}
				String atype = actiontype.getSelectionModel()
						.getSelectedItem();
				if (atype.equals("立即显示")) {
					ledInfo.setActiontype("1");
				} else {
					ledInfo.setActiontype("3");
				}
				
				String isuse = isused.getSelectionModel()
						.getSelectedItem();
				if (isuse.equals("启用")) {
					ledInfo.setIsused(0);
				} else {
					ledInfo.setIsused(1);
				}
				
				String brand = ledbrand.getSelectionModel()
						.getSelectedItem();
				if (brand.equals("DSGD")) {
					ledInfo.setLedbrand("Socket");
				} else {
					ledInfo.setLedbrand("AllInOne");
				}
				
				String zone = zone_id.getSelectionModel()
						.getSelectedItem();
				ParkZoneInfo parkZoneInfo=new ParkZoneInfo();
				parkZoneInfo.setZonename(zone);
				String zoneid = parkZoneInfoService.findAll(parkZoneInfo).get(0).getId();
				ledInfo.setZone_id(zoneid);
				ledInfo.setParkno_id(parkInfoService.findAll(null)
						.get(0).getId());
				publicledInfoService.update(ledInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			
			}
		});
	}
}
