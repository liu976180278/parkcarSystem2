package com.parkhelp.controller.system;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.filechooser.FileSystemView;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.parkhelp.main.MainLZC;
import com.parkhelp.po.system.MemberCar;
import com.parkhelp.service.system.MemberService;
import com.parkhelp.util.SpringFxmlLoader;

@Component
public class MemberController {
	@Autowired(required=true)
	private  MemberService memberService;
	@FXML
	private TableView<MemberCar> memberTable;//table
	@FXML 
	private TableColumn<String,String> xuhao;
	@FXML 
	private TableColumn<MemberCar, String> carno;
	@FXML 
	private TableColumn<MemberCar, String> carnocolor;
	@FXML 
	private TableColumn<MemberCar, Double> balance;//余额
	@FXML 
	private TableColumn<MemberCar, String> starttime;//会员有效时间
	@FXML 
	private TableColumn<MemberCar, String> endtime;//会员结束时间
	@FXML 
	private TableColumn<MemberCar, String> cartype;//车辆类型
	@FXML 
	private TableColumn<MemberCar, String> zone_id;//区域id
	@FXML 
	private TableColumn<MemberCar, String> carowner;//车主
	@FXML 
	private TableColumn<MemberCar, String> telno;//电话号码
	//集合数据
	private ObservableList<MemberCar> data;
	@FXML
	private TextField textCarno;//
	@FXML
	private TextField textName;//
	@FXML
	private TextField textPhone;//
	@FXML
	private Button findmember; //查询按钮
	@FXML
	private Button deletemember;//删除按钮
	@FXML
	private Button addmember; //添加按钮
	@FXML
	private Button updateMember; //更新按钮
	public static String id;//更新所需要的id
	@FXML
	private Button exportMember;//导出
	@FXML
	private Button importMember;//导入
	
	public  void initialize(){
		memberService =  (MemberService)SpringFxmlLoader.context.getBean("memberServiceImpl");
		onMouseClick();
		changData();
		
	}
	
	public void onMouseClick(){
		findmember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				changData();
			}
		});
		
		deletemember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<MemberCar> selectionModel = memberTable
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				MemberCar memberCar = selectionModel.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK){
						data.remove(index);
						memberService.delete(memberCar.getId());
						System.out.println(memberCar.getId());
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
		
		addmember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					id=null;
					final Parent root = FXMLLoader.load(getClass().getResource("/com/parkhelp/view/system/memberUpdate.fxml"));
					Stage stage = new Stage();
					Scene scene = new Scene(root);
					stage.setScene(scene);
					stage.setTitle("添加会员");
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.initOwner(MainLZC.mainStage);
					//stage.initStyle(StageStyle.TRANSPARENT);//去点windows自带的框
					stage.show();
					stage.getScene().getWindow().setOnHidden(new EventHandler<WindowEvent>() {
						public void handle(WindowEvent arg0) {
							changData();
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		updateMember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<MemberCar> selectionModel = memberTable
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				MemberCar memberCar = selectionModel.getSelectedItem();
				if (index != -1) {
						id=memberCar.getId();
						try {
							final Parent root = FXMLLoader.load(getClass().getResource("/com/parkhelp/view/system/memberUpdate.fxml"));
							Stage stage = new Stage();
							Scene scene = new Scene(root);
							stage.setScene(scene);
							stage.setTitle("更新会员");
							stage.initModality(Modality.APPLICATION_MODAL);
							stage.initOwner(MainLZC.mainStage);
							stage.show();
							stage.getScene().getWindow().setOnHidden(new EventHandler<WindowEvent>() {
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
		
		exportMember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("会员导出");
				fileChooser.setInitialFileName("会员列表.xls");
				fileChooser.setInitialDirectory(FileSystemView.getFileSystemView()
						.getHomeDirectory());
				File file = fileChooser.showSaveDialog(null);
				try {
					if(file!=null){
						List<MemberCar> list = memberTable.getItems();
						data = FXCollections.observableList(list);
						memberService.exportMemberCar(file, data);
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("提示！");
						alert.setHeaderText("导出成功");
						alert.showAndWait();
					}
				} catch (FileNotFoundException e) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("导出失败 ，该文件正在被另一程序使用。");
					alert.showAndWait();
				}
			}
		});
		
		importMember.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				FileChooser chooser = new FileChooser();
				File file = chooser.showOpenDialog(null);
				if(file!=null){
					memberService.importMember(file);
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("提示");
					alert.setHeaderText("导入成功");
					alert.showAndWait();
					changData();
				}
			}
		});
	}
	
	public void changData(){
		MemberCar memeber=  new MemberCar();
		memeber.setCarno(textCarno.getText());
		memeber.setCarowner(textName.getText());
		memeber.setTelno(textPhone.getText());
		ArrayList<MemberCar> members= (ArrayList<MemberCar>) memberService.findAll(memeber);
		data = FXCollections.observableList(members);
		xuhao.setCellValueFactory(aaa -> new ReadOnlyStringWrapper(String.valueOf(memberTable.getItems().indexOf(aaa.getValue())+1)));
		carno.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"carno"));
		carnocolor.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"carnocolor"));
		balance.setCellValueFactory(new PropertyValueFactory<MemberCar, Double>(
				"balance"));
		starttime.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"strstarttime"));
		endtime.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"strendtime"));
		cartype.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"cartype"));
		zone_id.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"zone_id"));
		carowner.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"carowner"));
		telno.setCellValueFactory(new PropertyValueFactory<MemberCar, String>(
				"telno"));
		memberTable.setItems(data);
	}
	
}
