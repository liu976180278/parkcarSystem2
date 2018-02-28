package com.parkhelp.controller.system;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.parkhelp.po.system.parkinfo.GateInfo;
import com.parkhelp.po.system.parkinfo.ParkInfo;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
import com.parkhelp.po.system.parkinfo.PostInfo;
import com.parkhelp.po.system.parkinfo.PublicledInfo;
import com.parkhelp.service.system.parkinfo.GateInfoService;
import com.parkhelp.service.system.parkinfo.ParkInfoService;
import com.parkhelp.service.system.parkinfo.ParkZoneInfoService;
import com.parkhelp.service.system.parkinfo.PostInfoService;
import com.parkhelp.service.system.parkinfo.PublicledInfoService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;
import com.parkhelp.vo.system.parkinfo.GateInfoVo;
import com.parkhelp.vo.system.parkinfo.ParkZoneInfoVo;
import com.parkhelp.vo.system.parkinfo.PostInfoVo;
import com.parkhelp.vo.system.parkinfo.PublicledInfoVo;

@Component
public class ParkInfoController {
	@Autowired(required = true)
	private ParkInfoService parkInfoService;
	@Autowired(required = true)
	private GateInfoService gateInfoService;
	@Autowired(required = true)
	private ParkZoneInfoService parkZoneInfoService;
	@Autowired(required = true)
	private PostInfoService postInfoService;
	@Autowired(required = true)
	private PublicledInfoService publicledInfoService;
	@FXML
	private Label parkno1;
	@FXML
	private Label parkname1;
	@FXML
	private Label park_type1;
	@FXML
	private Label PARK_BAYNUM1;
	@FXML
	private Label longitude1;
	@FXML
	private Label latitude1;
	@FXML
	private Label parkaddress1;
	@FXML
	private Label spacecount1;
	@FXML
	private Label freecount1;
	@FXML
	private Label parkphoto1;
	@FXML
	private Label remark1;
	@FXML
	private Label PARK_FEEINDEX1;
	@FXML
	private Label PARK_FEEDESC1;
	@FXML
	private Label PARK_FEELEVEL1;
	@FXML
	private Label PARK_REGIONID1;
	@FXML
	private Label park_freetime1;
	@FXML
	private Label park_agentid1;
	@FXML
	private Label park_subtype1;
	@FXML
	private Label dbStatus1;
	@FXML
	private Label videoDiskRecorderIp1;
	@FXML
	private Label enableVideoDiskRecorder1;
	@FXML
	private Label park_logon1;
	@FXML
	private Button btnUpdatePark;
	public static String sid1;
	// ------------------------------------
	@FXML
	private TableView<PostInfoVo> tablePostinfo;
	@FXML
	private TableColumn<PostInfoVo, String> id2;
	@FXML
	private TableColumn<PostInfoVo, String> parkname2;
	@FXML
	private TableColumn<PostInfoVo, String> post_name2;
	@FXML
	private TableColumn<PostInfoVo, String> post_type2;
	@FXML
	private TableColumn<PostInfoVo, String> remark2;
	@FXML
	private TableColumn<PostInfoVo, String> dbstatus2;
	public static String sid2;
	public static String state2;
	@FXML
	private Button btnUpdatePost;
	@FXML
	private Button btnAddPost;
	@FXML
	private Button btnDetailPost;
	@FXML
	private Button btnDeletePost;
	ObservableList<PostInfoVo> data2;
	// ------------------------------------
	@FXML
	private TableView<ParkZoneInfoVo> tableZone;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> id3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> zonename3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> zonecount3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> vipcarcount3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> maxtempcar3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> zonefreecount3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> billingindex_id3;
	// private TableColumn<PostInfoVo, String> 禁入类型;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> updatetime3;
	@FXML
	private TableColumn<ParkZoneInfoVo, String> dbStatus3;
	public static String sid3;
	public static String state3;
	@FXML
	private Button btnDetailZone;
	@FXML
	private Button btnUpdateZone;
	@FXML
	private Button btnDeleteZone;
	@FXML
	private Button btnAddZone;
	ObservableList<ParkZoneInfoVo> data3;
	// ------------------------------------
	@FXML
	private TableView<GateInfoVo> tableGateInfo;
	@FXML
	private TableColumn<GateInfoVo, String> ordernum4;
	@FXML
	private TableColumn<GateInfoVo, String> gategroup4;
	@FXML
	private TableColumn<GateInfoVo, String> zone_id4;
	@FXML
	private TableColumn<GateInfoVo, String> post_id4;
	@FXML
	private TableColumn<GateInfoVo, String> gatename4;
	@FXML
	private TableColumn<GateInfoVo, String> gateno4;
	@FXML
	private TableColumn<GateInfoVo, String> cameraIp4;
	@FXML
	private TableColumn<GateInfoVo, String> videoChannelNum4;
	@FXML
	private TableColumn<GateInfoVo, String> ledip4;
	@FXML
	private TableColumn<GateInfoVo, String> led_brand4;
	@FXML
	private TableColumn<GateInfoVo, String> remark4;
	@FXML
	private TableColumn<GateInfoVo, String> dbStatus4;
	public static String sid4;
	public static String state4;
	@FXML
	private Button btnAddGate;
	@FXML
	private Button btnDeleteGate;
	@FXML
	private Button btnUpdateGate;
	@FXML
	private Button btnDetailGate;
	ObservableList<GateInfoVo> data4;
	// ----------------------------------
	@FXML
	private TableView<PublicledInfoVo> tableLed;
	@FXML
	private TableColumn<PublicledInfoVo, String> ledname;
	@FXML
	private TableColumn<PublicledInfoVo, String> zone_id;
	@FXML
	private TableColumn<PublicledInfoVo, String> ledbrand;
	@FXML
	private TableColumn<PublicledInfoVo, String> cardaddress;
	@FXML
	private TableColumn<PublicledInfoVo, String> ledip;
	@FXML
	private TableColumn<PublicledInfoVo, String> numcount;
	@FXML
	private TableColumn<PublicledInfoVo, String> actiontype;
	@FXML
	private TableColumn<PublicledInfoVo, String> actionspeed;
	@FXML
	private TableColumn<PublicledInfoVo, String> partWidth;
	@FXML
	private TableColumn<PublicledInfoVo, String> partHeight;
	@FXML
	private TableColumn<PublicledInfoVo, String> coordinateX;
	@FXML
	private TableColumn<PublicledInfoVo, String> coordinateY;
	@FXML
	private TableColumn<PublicledInfoVo, String> fontsize;
	@FXML
	private TableColumn<PublicledInfoVo, String> isused;
	@FXML
	private TableColumn<PublicledInfoVo, String> fontbold;
	@FXML
	private TableColumn<PublicledInfoVo, String> holdtime;
	@FXML
	private TableColumn<PublicledInfoVo, String> texttmp;
	@FXML
	private Button btnDetailLed;
	@FXML
	private Button btnUpdateLed;
	@FXML
	private Button btnDeleteLed;
	@FXML
	private Button btnAddLed;
	public static String sid5;
	public static String state5;
	ObservableList<PublicledInfoVo> data5; 
	

	// ------------------------------------
	public void initialize() {
		parkInfoService = (ParkInfoService) SpringFxmlLoader.context
				.getBean("parkInfoServiceImpl");
		gateInfoService = (GateInfoService) SpringFxmlLoader.context
				.getBean("gateInfoServiceImpl");
		parkZoneInfoService = (ParkZoneInfoService) SpringFxmlLoader.context
				.getBean("parkZoneInfoServiceImpl");
		postInfoService = (PostInfoService) SpringFxmlLoader.context
				.getBean("postInfoServiceImpl");
		publicledInfoService = (PublicledInfoService) SpringFxmlLoader.context
				.getBean("publicledInfoServiceImpl");
		ininParkInfo();
		ininPostInfo();
		ininZoneInfo();
		ininGateInfo();
		ininPublicLed();
	}

	public void ininPostInfo() {
		List<PostInfo> postInfos = postInfoService.findAll(null);
		List<PostInfoVo> postInfoVos = new ArrayList<PostInfoVo>();
		for (PostInfo info : postInfos) {
			postInfoVos.add(new PostInfoVo(info));
		}
		data2 = FXCollections.observableList(postInfoVos);
		id2.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
				"id"));
		parkname2
				.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
						"parkname"));
		post_name2
				.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
						"post_name"));
		post_type2
				.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
						"post_type"));
		remark2.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
				"remark"));
		dbstatus2
				.setCellValueFactory(new PropertyValueFactory<PostInfoVo, String>(
						"dbstatus"));
		tablePostinfo.setItems(data2);

		btnUpdatePost.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<PostInfoVo> selectionModel = tablePostinfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PostInfoVo postInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					sid2 = postInfoVo.getId();
					state2 = "update";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/postinfoManager.fxml",
										"岗亭管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininPostInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做修改");
					alert.showAndWait();
				}

			}
		});

		btnDetailPost.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<PostInfoVo> selectionModel = tablePostinfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PostInfoVo postInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					sid2 = postInfoVo.getId();
					state2 = "detail";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/postinfoManager.fxml",
										"岗亭管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininPostInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做查看");
					alert.showAndWait();
				}

			}
		});

		btnAddPost.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				state2 = "add";
				try {
					Stage stage = GoUi
							.goNewUi(
									"/com/parkhelp/view/system/parkinfo/postinfoManager.fxml",
									"岗亭管理");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									ininPostInfo();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btnDeletePost.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<PostInfoVo> selectionModel = tablePostinfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PostInfoVo postInfoVo = selectionModel.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						data2.remove(index);
						postInfoService.delete(postInfoVo.getId());
					} else {
						System.out.println("no");
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，在删除");
					alert.showAndWait();
				}

			}
		});

	}

	public void ininParkInfo() {
		List<ParkInfo> list = parkInfoService.findAll(null);
		ParkInfo parkInfo = list.get(0);
		sid1 = parkInfo.getId();
		parkno1.setText(parkInfo.getParkno());
		parkname1.setText(parkInfo.getParkname());
		PARK_BAYNUM1.setText(parkInfo.getPARK_BAYNUM() + "");
		longitude1.setText(parkInfo.getLongitude() + "");
		latitude1.setText(parkInfo.getLatitude() + "");
		parkaddress1.setText(parkInfo.getParkaddress());
		spacecount1.setText(parkInfo.getSpacecount() + "");
		freecount1.setText(parkInfo.getFreecount() + "");
		parkphoto1.setText(parkInfo.getParkphoto());
		remark1.setText(parkInfo.getRemark());
		PARK_FEEINDEX1.setText(parkInfo.getPARK_FEEINDEX());
		PARK_FEEDESC1.setText(parkInfo.getPARK_FEEDESC());
		PARK_FEELEVEL1.setText(parkInfo.getPARK_FEELEVEL() + "");
		park_freetime1.setText(parkInfo.getPark_freetime() + "");
		park_agentid1.setText(parkInfo.getPark_agentid());
		PARK_REGIONID1.setText(parkInfo.getPARK_REGIONID());
		videoDiskRecorderIp1.setText(parkInfo.getVideoDiskRecorderIp());
		btnUpdatePark.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				try {
					Stage stage = GoUi
							.goNewUi(
									"/com/parkhelp/view/system/parkinfo/parkinfoManager.fxml",
									"停车场信息修改");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									initialize();
								}
							});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		if (parkInfo.getPark_type() == 2) {
			park_type1.setText("路外");
		} else {
			park_type1.setText("路边");
		}
		if (parkInfo.getPark_subtype() == 22) {
			park_subtype1.setText("景区");
		} else {
			park_subtype1.setText("非景区");
		}
		if (parkInfo.getDbStatus() == 0) {
			dbStatus1.setText("正常记录");
		} else {
			dbStatus1.setText("非正常记录");
		}
		if (parkInfo.getEnableVideoDiskRecorder() == 0) {
			enableVideoDiskRecorder1.setText("不启用");
		} else {
			enableVideoDiskRecorder1.setText("启用");
		}
		if (parkInfo.getPark_logon().equalsIgnoreCase("1")) {
			park_logon1.setText("上班");
		} else {
			park_logon1.setText("下班");
		}

	}

	public void ininZoneInfo() {
		List<ParkZoneInfo> ParkZoneInfo = parkZoneInfoService.findAll(null);
		List<ParkZoneInfoVo> ParkZoneInfoVos = new ArrayList<ParkZoneInfoVo>();
		for (ParkZoneInfo info : ParkZoneInfo) {
			ParkZoneInfoVos.add(new ParkZoneInfoVo(info));
		}
		data3 = FXCollections.observableList(ParkZoneInfoVos);
		id3.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
				"id"));
		zonename3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"zonename"));
		zonecount3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"zonecount"));
		vipcarcount3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"vipcarcount"));
		maxtempcar3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"maxtempcar"));
		zonefreecount3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"zonefreecount"));
		billingindex_id3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"billingindex_id"));
		updatetime3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"updatetime"));
		dbStatus3
				.setCellValueFactory(new PropertyValueFactory<ParkZoneInfoVo, String>(
						"dbStatus"));
		tableZone.setItems(data3);

		btnDetailZone.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<ParkZoneInfoVo> selectionModel = tableZone
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				ParkZoneInfoVo parkZoneInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid3 = parkZoneInfoVo.getId();
					state3 = "detail";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/zoneinfoManager.fxml",
										"岗亭管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininPostInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做查看");
					alert.showAndWait();
				}
			}
		});

		btnUpdateZone.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<ParkZoneInfoVo> selectionModel = tableZone
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				ParkZoneInfoVo parkZoneInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid3 = parkZoneInfoVo.getId();
					state3 = "update";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/zoneinfoManager.fxml",
										"岗亭管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininZoneInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做修改");
					alert.showAndWait();
				}
			}
		});

		btnDeleteZone.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<ParkZoneInfoVo> selectionModel = tableZone
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				ParkZoneInfoVo parkZoneInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						data3.remove(index);
						parkZoneInfoService.delete(parkZoneInfoVo.getId());
					} else {
						// System.out.println("no");
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，在删除");
					alert.showAndWait();
				}

			}
		});

		btnAddZone.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				state3 = "add";
				try {
					Stage stage = GoUi
							.goNewUi(
									"/com/parkhelp/view/system/parkinfo/zoneinfoManager.fxml",
									"区域管理");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									ininZoneInfo();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void ininGateInfo() {
		List<GateInfo> gateInfos = gateInfoService.findAll(null);
		List<GateInfoVo> gateInfoVos = new ArrayList<GateInfoVo>();
		for (GateInfo info : gateInfos) {
			gateInfoVos.add(new GateInfoVo(info));
		}
		data4 = FXCollections
				.observableList(gateInfoVos);
		ordernum4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"ordernum"));
		gategroup4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"gategroup"));
		zone_id4.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				"zone_id"));
		post_id4.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				"post_id"));
		gatename4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"gatename"));
		gateno4.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				"gateno"));
		cameraIp4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"cameraIp"));
		videoChannelNum4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"videoChannelNum"));
		ledip4.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
				"ledip"));
		led_brand4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"led_brand"));
		dbStatus4
				.setCellValueFactory(new PropertyValueFactory<GateInfoVo, String>(
						"dbStatus"));
		tableGateInfo.setItems(data4);
		btnAddGate.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				state4 = "add";
				try {
					Stage stage = GoUi
							.goNewUi(
									"/com/parkhelp/view/system/parkinfo/gateinfoManager.fxml",
									"通道管理");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									ininGateInfo();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
		btnDeleteGate.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {

				TableViewSelectionModel<GateInfoVo> selectionModel = tableGateInfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				GateInfoVo gateInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						data4.remove(index);
						gateInfoService.delete(gateInfoVo.getId());
					} else {
						// System.out.println("no");
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，在删除");
					alert.showAndWait();
				}

			
			}
		});
		btnUpdateGate.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<GateInfoVo> selectionModel = tableGateInfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				GateInfoVo gateInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid4 = gateInfoVo.getId();
					state4 = "update";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/gateinfoManager.fxml",
										"通道管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininGateInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做修改");
					alert.showAndWait();
				}
			}
		});
		btnDetailGate.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<GateInfoVo> selectionModel = tableGateInfo
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				GateInfoVo GateInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid4 = GateInfoVo.getId();
					state4 = "detail";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/gateinfoManager.fxml",
										"岗亭管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininPostInfo();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做查看");
					alert.showAndWait();
				}
			
				
				
			}});
	}

	public void ininPublicLed() {
		List<PublicledInfo> ledInfos = publicledInfoService.findAll(null);
		List<PublicledInfoVo> ledInfoVos = new ArrayList<PublicledInfoVo>();
		for (PublicledInfo info : ledInfos) {
			ledInfoVos.add(new PublicledInfoVo(info));
		}
		data5 = FXCollections
				.observableList(ledInfoVos);
		ledname.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"ledname"));
		zone_id.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"zone_id"));
		ledbrand.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"ledbrand"));
		cardaddress
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"cardaddress"));
		ledip.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"ledip"));
		numcount.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"numcount"));
		actiontype
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"actiontype"));
		actionspeed
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"actionspeed"));
		partWidth
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"partWidth"));
		partHeight
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"partHeight"));
		coordinateX
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"coordinateX"));
		coordinateY
				.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
						"coordinateY"));
		fontsize.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"fontsize"));
		isused.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"isused"));
		fontbold.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"fontbold"));
		holdtime.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"holdtime"));
		texttmp.setCellValueFactory(new PropertyValueFactory<PublicledInfoVo, String>(
				"texttmp"));
		tableLed.setItems(data5);
		
		btnUpdateLed.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<PublicledInfoVo> selectionModel = tableLed
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PublicledInfoVo ledInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid5 = ledInfoVo.getId();
					state5 = "update";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/ledinfoManager.fxml",
										"LED管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										ininPublicLed();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做修改");
					alert.showAndWait();
				}
			}
		});
		
		btnDetailLed.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				TableViewSelectionModel<PublicledInfoVo> selectionModel = tableLed
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PublicledInfoVo publicledInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					sid5 = publicledInfoVo.getId();
					state5= "detail";
					try {
						Stage stage = GoUi
								.goNewUi(
										"/com/parkhelp/view/system/parkinfo/ledinfoManager.fxml",
										"LED管理");
						stage.getScene().getWindow()
								.setOnHidden(new EventHandler<WindowEvent>() {
									public void handle(WindowEvent arg0) {
										//ininPublicLed();
									}
								});
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，再做查看");
					alert.showAndWait();
				}
			}
		});
		btnDeleteLed.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {

				TableViewSelectionModel<PublicledInfoVo> selectionModel = tableLed
						.getSelectionModel();
				int index = selectionModel.getSelectedIndex();
				PublicledInfoVo ledInfoVo = selectionModel
						.getSelectedItem();
				if (index != -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle("提示");
					alert.setHeaderText("你确认要删除该天记录吗？");
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						data5.remove(index);
						gateInfoService.delete(ledInfoVo.getId());
					} else {
						// System.out.println("no");
					}
				} else {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("警告！");
					alert.setHeaderText("请选择某条记录，在删除");
					alert.showAndWait();
				}
			}
		});
		btnAddLed.setOnMouseClicked(new EventHandler<Event>() {
			public void handle(Event arg0) {
				state5 = "add";
				try {
					Stage stage = GoUi
							.goNewUi(
									"/com/parkhelp/view/system/parkinfo/ledinfoManager.fxml",
									"LED管理");
					stage.getScene().getWindow()
							.setOnHidden(new EventHandler<WindowEvent>() {
								public void handle(WindowEvent arg0) {
									ininPublicLed();
								}
							});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
