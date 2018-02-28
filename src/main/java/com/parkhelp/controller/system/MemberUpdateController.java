package com.parkhelp.controller.system;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.parkhelp.po.system.MemberCar;
import com.parkhelp.service.system.MemberService;
import com.parkhelp.util.SpringFxmlLoader;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;

@Component
public class MemberUpdateController {
	@Autowired(required = true)
	private MemberService memberService;
	@FXML
	private TextField carowner;
	@FXML
	private TextField telno;
	@FXML
	private TextField carno;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnNo;
	@FXML
	private HBox clolorHbox;
	@FXML
	private HBox carTypeHbox;
	ToggleGroup color = new ToggleGroup();//颜色单选按钮组
	ToggleGroup type = new ToggleGroup();//类型单选按钮组
	
	public void initialize() {
		memberService = (MemberService) SpringFxmlLoader.context
				.getBean("memberServiceImpl");
		onMouseClick();
		inint();
	}

	private void onMouseClick() {
		btnOk.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				String carclolr = (String) color.getSelectedToggle().getUserData();
				String carType=(String) type.getSelectedToggle().getUserData();
				if("".equals(carowner.getText().trim())||"".equals(carno.getText().trim())||"".equals(telno.getText().trim())){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告");
					alert.setHeaderText("输入框不能为空");
					alert.showAndWait();
				}else{
					MemberCar member =new MemberCar();
					member.setCarowner(carowner.getText().trim());
					member.setCarno(carno.getText().trim());
					member.setTelno(telno.getText().trim());
					member.setStarttime(new Date());
					member.setEndtime(new Date());
					member.setCarnocolor(carclolr);
					member.setBalance(0.0);
					member.setZone_id("qyid"+UUID.randomUUID());
					member.setCartype(carType);
					if(MemberController.id==null){
						memberService.addMemberCar(member);
					}else {
						member.setId(MemberController.id);
						memberService.update(member);
					}
					btnOk.getScene().getWindow().hide();
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示");
					alert.setHeaderText("操作成功");
					alert.showAndWait();
					
				}
			}
		});
		btnNo.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				btnNo.getScene().getWindow().setOnHidden(new EventHandler<WindowEvent>() {
					public void handle(WindowEvent arg0) {
						System.out.println("关闭");
					}
				});
				btnNo.getScene().getWindow().hide();
			}
		});
	}
	
	public void inint(){
		btnNo.setStyle("-fx-base: #C2FF68");
		btnOk.setStyle("-fx-base: #FFFF6F;");
		RadioButton crb1 = new RadioButton("红色\t\t");
		crb1.setToggleGroup(color);
		crb1.setUserData("红");
		crb1.setSelected(true);
		 
		RadioButton crb2 = new RadioButton("白色\t\t");
		crb2.setUserData("白");
		crb2.setToggleGroup(color);
		
		RadioButton crb3 = new RadioButton("蓝色\t\t");
		crb3.setUserData("蓝");
		crb3.setToggleGroup(color);
		
		RadioButton crb4 = new RadioButton("黄色\t\t");
		crb4.setUserData("黄");
		crb4.setToggleGroup(color);
		clolorHbox.getChildren().addAll(crb1,crb2,crb3,crb4);
		
		RadioButton trb1 = new RadioButton("小汽车\t\t");
		trb1.setToggleGroup(type);
		trb1.setUserData("0");
		trb1.setSelected(true);
		 
		RadioButton trb2 = new RadioButton("大货车\t\t");
		trb2.setUserData("1");
		trb2.setToggleGroup(type);
		
		RadioButton trb3 = new RadioButton("面包车\t\t");
		trb3.setUserData("2");
		trb3.setToggleGroup(type);
		
		RadioButton trb4 = new RadioButton("警车\t\t");
		trb4.setUserData("3");
		trb4.setToggleGroup(type);
		
		if(MemberController.id!=null){
			MemberCar memberCar=memberService.findMemberCarById(MemberController.id);
			carowner.setText(memberCar.getCarowner());
			telno.setText(memberCar.getTelno());
			carno.setText(memberCar.getCarno());
			//车辆类型的数据回显
			switch (Integer.parseInt(memberCar.getCartype())) {
			case 0:
				trb1.setSelected(true);
				break;
			case 1:
				trb2.setSelected(true);
				break;
			case 2:
				trb3.setSelected(true);
				break;
			case 3:
				trb4.setSelected(true);
				break;
			default:
				break;
			}
			//车辆颜色的数据回显
			if(memberCar.getCarnocolor().equals("白")){
				crb2.setSelected(true);
			}else if(memberCar.getCarnocolor().equals("蓝")){
				crb3.setSelected(true);
			}else if(memberCar.getCarnocolor().equals("黄")){
				crb4.setSelected(true);
			}else {
				crb1.setSelected(true);
			}
		} 
		carTypeHbox.getChildren().addAll(trb1,trb2,trb3,trb4);
		
	}
	
}
