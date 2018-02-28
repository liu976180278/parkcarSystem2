package com.parkhelp.controller.system;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import com.parkhelp.controller.main.MainController;
import com.parkhelp.po.system.parkinfo.GateInfo;
import com.parkhelp.service.system.parkinfo.GateInfoService;
import com.parkhelp.util.SpringFxmlLoader;
import com.parkhelp.vo.system.parkinfo.GateInfoVo;
@Component
public class GateinfoConfigController {
	@Autowired(required=true)
	private  GateInfoService gateInfoService;
	@FXML
	private TableView<GateInfoVo> gateTable;//table
	@FXML
	private TableColumn<GateInfoVo, CheckBox> isUsed;
	@FXML 
	private TableColumn<GateInfoVo, String> ordernum ;
	@FXML 
	private TableColumn<GateInfoVo, String>gatename;
	@FXML 
	private TableColumn<GateInfoVo, String> zone_id;
	@FXML 
	private TableColumn<GateInfoVo, String> cameraIp;
	@FXML 
	private TableColumn<GateInfoVo, String> ledip;
	@FXML 
	private TableColumn<GateInfoVo, String> dbStatus;
	@FXML 
	private TableColumn<GateInfoVo, String> remark;
	@FXML 
	private Button btnOk;
	//集合数据
	private ObservableList<GateInfoVo> data;

	public  void initialize(){
		gateInfoService =  (GateInfoService)SpringFxmlLoader.context.getBean("gateInfoServiceImpl");
		changData();
		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				List<GateInfoVo>  list  = (java.util.List<GateInfoVo>) gateTable.getItems();
				GateInfo gate=null;
				for(int i=0;i<list.size();i++){
					if(list.get(i).getIsUsed().isSelected()){
						if(list.get(i).getGategroup().equals("1")){
							list.get(i).getIsUsed().setSelected(true);
							gate=gateInfoService.findById(list.get(i).getId());
							gate.setGategroup("1");
						}else{
							list.get(i).getIsUsed().setSelected(false);
							gate=gateInfoService.findById(list.get(i).getId());
							gate.setGategroup("0");
						}
					}else {
						gate=gateInfoService.findById(list.get(i).getId());
						gate.setGategroup("0");
						
					}
					gateInfoService.update(gate);
				}
				MainController.viedoState=0;
				changData();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("提示！");
				alert.setHeaderText("保存成功");
				alert.showAndWait();
			}
		});
	}

	private void changData() {
		ArrayList <GateInfo> gates = (ArrayList<GateInfo>) gateInfoService.findAll(null);
		ArrayList<GateInfoVo> gatesVos=new ArrayList<GateInfoVo>();
		for(GateInfo g :gates){
			gatesVos.add(new GateInfoVo(g));
		}
		data = FXCollections.observableList(gatesVos);
		isUsed
		.setCellValueFactory(new PropertyValueFactory<GateInfoVo, CheckBox>(
				"isUsed"));
		 ordernum.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
					"ordernum")); 
		 gatename.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
					"gatename"));
		 zone_id.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
					"zone_id"));
		 cameraIp.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
					"cameraIp"));
		 ledip.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
					"ledip"));
		 dbStatus.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				 "dbStatus"));
		 remark.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				 "remark"));
		 gateTable.setItems(data);
	}


}
