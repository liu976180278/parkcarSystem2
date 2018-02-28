package com.parkhelp.controller.system;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.List;

import com.parkhelp.util.GoUi;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
public class SystemController {
	@FXML
	TreeView<String> treeView;
	@FXML
	private Pane systemPane;

	public void initialize() {
		inintree();
	}

	public void inintree() {
		Image rootIcon = new Image(getClass().getResourceAsStream(
				"/com/parkhelp/image/system/file_open.png"));
		Image cIcon = new Image(getClass().getResourceAsStream(
				"/com/parkhelp/image/system/tree_sec_icon.png"));
		TreeItem<String> rootItem = new TreeItem<String>("系统管理");
		rootItem.setExpanded(true);

		TreeItem<String> _001 = new TreeItem<String>("系统管理", new ImageView(
				rootIcon));
		TreeItem<String> _001001 = new TreeItem<String>("系统基本信息",
				new ImageView(cIcon));
		_001.getChildren().addAll(_001001);
		_001.setExpanded(true);

		TreeItem<String> _002 = new TreeItem<String>("系统配置信息", new ImageView(
				rootIcon));
		TreeItem<String> _002001 = new TreeItem<String>("配置首选项信息",
				new ImageView(cIcon));
		TreeItem<String> _002002 = new TreeItem<String>("出入口 控制",
				new ImageView(cIcon));
		TreeItem<String> _002003 = new TreeItem<String>("通道首选项信息",
				new ImageView(cIcon));
		TreeItem<String> _002004 = new TreeItem<String>("白名单推送", new ImageView(
				cIcon));
		_002.getChildren().addAll(_002001, _002002, _002003, _002004);
		_002.setExpanded(true);

		TreeItem<String> _003 = new TreeItem<String>("停车场管理", new ImageView(
				rootIcon));
		TreeItem<String> _003001 = new TreeItem<String>("停车场信息", new ImageView(
				cIcon));
		_003.getChildren().addAll(_003001);
		_003.setExpanded(true);

		TreeItem<String> _004 = new TreeItem<String>("用户管理", new ImageView(
				rootIcon));
		TreeItem<String> _004001 = new TreeItem<String>("用户信息", new ImageView(
				cIcon));
		_004.getChildren().addAll(_004001);
		_004.setExpanded(true);

		TreeItem<String> _005 = new TreeItem<String>("会员管理", new ImageView(
				rootIcon));
		TreeItem<String> _005001 = new TreeItem<String>("会员信息", new ImageView(
				cIcon));
		_005001.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						System.out.println("sdas");
					}
				});
		_005.getChildren().addAll(_005001);
		_005.setExpanded(true);
		//自定义节点
		TreeItem<String> _006 = new TreeItem<String>("计费管理", new ImageView(
				rootIcon));
		TreeItem<String> _006001 = new TreeItem<String>("统计计费索引",
				new ImageView(cIcon));
		_006.getChildren().addAll(_006001);
		_006.setExpanded(true);
		rootItem.getChildren().addAll(_001, _002, _003, _004, _005, _006);
		treeView.setRoot(rootItem);
		treeView.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						MultipleSelectionModel<TreeItem<String>> str = treeView
								.getSelectionModel();
						TreeItem<String> m = str.getSelectedItem();
						try {
							if (m.getValue().equalsIgnoreCase("会员信息")) {
								GoUi.goOldUi("/com/parkhelp/view/system/memberManager.fxml",systemPane);
							}else if (m.getValue().equalsIgnoreCase("用户信息")) {
								GoUi.goOldUi("/com/parkhelp/view/system/userinfoManager.fxml",systemPane);
							}else if (m.getValue().equalsIgnoreCase("停车场信息")) {
								GoUi.goOldUi("/com/parkhelp/view/system/parkinfoManager.fxml",systemPane);
							}else if (m.getValue().equalsIgnoreCase("通道首选项信息")) {
								GoUi.goOldUi("/com/parkhelp/view/system/gateinfoConfig.fxml",systemPane);
							}
						} catch (IOException e) {
							e.printStackTrace();
						} catch (NullPointerException e) {
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}
}
