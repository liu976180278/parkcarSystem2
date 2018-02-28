package com.parkhelp.controller.system.parkinfo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.controller.system.ParkInfoController;
import com.parkhelp.po.system.parkinfo.GateInfo;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
import com.parkhelp.po.system.parkinfo.PostInfo;
import com.parkhelp.service.system.parkinfo.GateInfoService;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.service.system.parkinfo.ParkZoneInfoService;
import com.parkhelp.service.system.parkinfo.PostInfoService;
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
public class GeteUpdateController {
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@Autowired(required = true)
	private GateInfoService gateInfoService;
	@Autowired(required = true)
	private ParkZoneInfoService parkZoneInfoService;
	@Autowired(required = true)
	private PostInfoService postInfoService;
	@FXML
	private TextField gatename;
	@FXML
	private TextField ordernum;
	@FXML
	private TextField gateno;
	@FXML
	private TextField cameraIp;
	@FXML
	private TextField gategroup;
	@FXML
	private TextField ledip;
	@FXML
	private ChoiceBox<String> led_brand;
	@FXML
	private ChoiceBox<String> zone_id;
	@FXML
	private ChoiceBox<String> post_id;
	@FXML
	private ChoiceBox<String> gatetype;
	@FXML
	private ChoiceBox<String> camera_brand;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;
	@FXML
	private Label title;
	@FXML
	private AnchorPane gatePane;

	public void initialize() {
		GoUi.dragged(title);
		parkInfoService=(ParkInfoService) SpringFxmlLoader.context
				.getBean("parkInfoServiceImpl");
		gateInfoService = (GateInfoService) SpringFxmlLoader.context
				.getBean("gateInfoServiceImpl");
		parkZoneInfoService = (ParkZoneInfoService) SpringFxmlLoader.context
				.getBean("parkZoneInfoServiceImpl");
		postInfoService = (PostInfoService) SpringFxmlLoader.context
				.getBean("postInfoServiceImpl");
		inint();
		click();
	}

	private void inint() {
		camera_brand.setItems(FXCollections.observableArrayList("XLT",
				"YS", "YT", "ZS", "ZXYD", "DH"));
		gatetype.setItems(FXCollections.observableArrayList("入口", "出口"));
		led_brand.setItems(FXCollections
				.observableArrayList("DSGD", "FRTK"));
		ArrayList<String> zoneName = new ArrayList<String>();
		List<ParkZoneInfo> parkZoneInfo = parkZoneInfoService.findAll(null);
		for (ParkZoneInfo zone : parkZoneInfo) {
			zoneName.add(zone.getZonename());
		}
		ArrayList<String> postName = new ArrayList<String>();
		List<PostInfo> postInfos = postInfoService.findAll(null);
		for (PostInfo post : postInfos) {
			postName.add(post.getPost_name());
		}
		zone_id.setItems(FXCollections.observableArrayList(zoneName));
		post_id.setItems(FXCollections.observableArrayList(postName));
		if (!ParkInfoController.state4.equalsIgnoreCase("add")) {
			if (ParkInfoController.state4.equalsIgnoreCase("update")) {
				title.setText("通道信息修改");
			} else {
				title.setText("通道信息详情");
				gatePane.setDisable(true);
			}
			GateInfo gateinfo = gateInfoService
					.findById(ParkInfoController.sid4);
			gatename.setText(gateinfo.getGatename());
			ordernum.setText(gateinfo.getOrdernum() + "");
			gateno.setText(gateinfo.getGateno());
			cameraIp.setText(gateinfo.getCameraIp());
			gategroup.setText(gateinfo.getGategroup());
			ledip.setText(gateinfo.getLedip());
			if (!(null == gateinfo.getLed_brand())) {
				if ((gateinfo.getLed_brand()).equals("Socket")) {
					led_brand.getSelectionModel().select(0);
				} else {
					led_brand.getSelectionModel().select(1);
				}
			}

			if (!(null == gateinfo.getCamera_brand())) {
				if ((gateinfo.getCamera_brand()).equals("Signaltone")) {
					camera_brand.getSelectionModel().select(0);
				} else if ((gateinfo.getCamera_brand()).equals("Uniview")) {
					camera_brand.getSelectionModel().select(1);
				} else if ((gateinfo.getCamera_brand()).equals("YanTai")) {
					camera_brand.getSelectionModel().select(2);
				} else if ((gateinfo.getCamera_brand()).equals("ZS")) {
					camera_brand.getSelectionModel().select(3);
				} else if ((gateinfo.getCamera_brand()).equals("ZXYD")) {
					camera_brand.getSelectionModel().select(4);
				} else if ((gateinfo.getCamera_brand()).equals("DH")) {
					camera_brand.getSelectionModel().select(5);
				}
			}

			if (!(null == gateinfo.getGatetype())) {
				if ((gateinfo.getGatetype()).equals("0")) {
					gatetype.getSelectionModel().select(0);
				} else {
					gatetype.getSelectionModel().select(1);
				}
			}

			if (gateinfo.getParkZoneInfo()!=null) {
				zone_id.getSelectionModel().select(
						gateinfo.getParkZoneInfo().getZonename());
			}
			if (gateinfo.getPostInfo()!=null) {
				post_id.getSelectionModel().select(
						gateinfo.getPostInfo().getPost_name());
			}
		} else if (ParkInfoController.state4.equalsIgnoreCase("add")) {
			title.setText("通道信息新增");
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
						if (ParkInfoController.state4.equalsIgnoreCase("update")) {
							updateGateInfo();
						}else if(ParkInfoController.state4.equalsIgnoreCase("add")){
							addGateInfo();
						}else if(ParkInfoController.state4.equalsIgnoreCase("detail")){
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

			public void addGateInfo() {
				GateInfo gateInfo = new GateInfo();
				gateInfo.setCameraIp(cameraIp.getText());
				gateInfo.setGatename(gatename.getText());
				gateInfo.setGateno(gateno.getText());
				gateInfo.setLedip(ledip.getText());
				gateInfo.setGategroup(gategroup.getText());
				if(ordernum.getText().equals("")||ordernum.getText()==null){
					gateInfo.setOrdernum(0);

				}else{
					gateInfo.setOrdernum(Integer.parseInt(ordernum.getText()));
				}
				String brand = led_brand.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(brand)&&brand!=null){
					if (brand.equals("DSGD")) {
						gateInfo.setLed_brand("Socket");
					} else {
						gateInfo.setLed_brand("AllInOne");
					}
				}
				
				String gate = gatetype.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(gate)&&gate!=null){
					if (gate.equals("入口")) {
						gateInfo.setGatetype("0");
					} else {
						gateInfo.setGatetype("1");
					}
				}
				
				
				String camera = camera_brand.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(camera)&&camera!=null){
					if (camera.equals("XLT")) {
						gateInfo.setCamera_brand("Signaltone");
					}else if (camera.equals("YS")) {
						gateInfo.setCamera_brand("Uniview");
					}else if (camera.equals("YT")) {
						gateInfo.setCamera_brand("YanTai");
					}else if (camera.equals("ZS")) {
						gateInfo.setCamera_brand("ZS");
					}else if (camera.equals("ZXYD")) {
						gateInfo.setCamera_brand("ZXYD");
					}else if (camera.equals("DH")) {
						gateInfo.setCamera_brand("DH");
					}
				}
				
				
				String zone = zone_id.getSelectionModel()
						.getSelectedItem();
				ParkZoneInfo parkZoneInfo=new ParkZoneInfo();
				parkZoneInfo.setZonename(zone);
				String zoneid = parkZoneInfoService.findAll(parkZoneInfo).get(0).getId();
				gateInfo.setZone_id(zoneid);
				
				String post = post_id.getSelectionModel()
						.getSelectedItem();
				PostInfo postInfo=new PostInfo();
				postInfo.setPost_name(post);
				String postid = postInfoService.findAll(postInfo).get(0).getId();
				gateInfo.setPost_id(postid);
				
				String parkid = parkInfoService.findAll(null).get(0).getId();
				gateInfo.setParkno_id(parkid);
				
				
				gateInfoService.add(gateInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
			
			public void updateGateInfo(){
				GateInfo gateInfo = new GateInfo();
				gateInfo.setId(ParkInfoController.sid4);
				gateInfo.setCameraIp(cameraIp.getText());
				gateInfo.setGatename(gatename.getText());
				gateInfo.setGateno(gateno.getText());
				gateInfo.setLedip(ledip.getText());
				gateInfo.setGategroup(gategroup.getText());
				if(ordernum.getText().equals("")||ordernum.getText()==null){
					gateInfo.setOrdernum(0);

				}else{
					gateInfo.setOrdernum(Integer.parseInt(ordernum.getText()));
				}
				
				String brand = led_brand.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(brand)&&brand!=null){
					if (brand.equals("DSGD")) {
						gateInfo.setLed_brand("Socket");
					} else {
						gateInfo.setLed_brand("AllInOne");
					}
				}
				
				String gate = gatetype.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(gate)&&gate!=null){
					if (gate.equals("入口")) {
						gateInfo.setGatetype("0");
					} else {
						gateInfo.setGatetype("1");
					}
				}
				
				
				String camera = camera_brand.getSelectionModel()
						.getSelectedItem();
				if(!"".equals(camera)&&camera!=null){
					if (camera.equals("XLT")) {
						gateInfo.setCamera_brand("Signaltone");
					}else if (camera.equals("YS")) {
						gateInfo.setCamera_brand("Uniview");
					}else if (camera.equals("YT")) {
						gateInfo.setCamera_brand("YanTai");
					}else if (camera.equals("ZS")) {
						gateInfo.setCamera_brand("ZS");
					}else if (camera.equals("ZXYD")) {
						gateInfo.setCamera_brand("ZXYD");
					}else if (camera.equals("DH")) {
						gateInfo.setCamera_brand("DH");
					}
				}
				
				
				
				String zone = zone_id.getSelectionModel()
						.getSelectedItem();
				ParkZoneInfo parkZoneInfo=new ParkZoneInfo();
				parkZoneInfo.setZonename(zone);
				String zoneid = parkZoneInfoService.findAll(parkZoneInfo).get(0).getId();
				gateInfo.setZone_id(zoneid);
				
				String post = post_id.getSelectionModel()
						.getSelectedItem();
				PostInfo postInfo=new PostInfo();
				postInfo.setPost_name(post);
				String postid = postInfoService.findAll(postInfo).get(0).getId();
				gateInfo.setPost_id(postid);
				
				String parkid = parkInfoService.findAll(null).get(0).getId();
				gateInfo.setParkno_id(parkid);
				
				
				gateInfoService.update(gateInfo);
				btnOk.getScene().getWindow().hide();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示");
				alert.setHeaderText("操作成功");
				alert.showAndWait();
			}
		});
	}

}
