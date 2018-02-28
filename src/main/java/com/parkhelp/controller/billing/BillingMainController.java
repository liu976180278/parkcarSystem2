/**
 * @Description: TODO
 * @date 2017年6月19日 上午10:04:00 	
 */
package com.parkhelp.controller.billing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.parkhelp.po.billing.Billindex;
import com.parkhelp.service.billindex.BillindexService;
import com.parkhelp.util.GoUi;
import com.parkhelp.util.SpringFxmlLoader;
import com.parkhelp.vo.system.parkinfo.PublicledInfoVo;

/**
 * @author lzc
 *
 */
@Controller
public class BillingMainController {
	@Autowired(required = true)
	private BillindexService billindexService;
	@FXML
	TreeView<String> treeView;
	public void initialize() {
		billindexService = (BillindexService) SpringFxmlLoader.context
				.getBean("billindexServiceImpl");
		inintree();
	}
	public void inintree(){
		Image cIcon = new Image(getClass().getResourceAsStream(
				"/com/parkhelp/image/system/tree_sec_icon.png"));
		Image rootIcon = new Image(getClass().getResourceAsStream(
				"/com/parkhelp/image/system/file_open.png"));
		TreeItem<String> rootItem = new TreeItem<String>("计费索引列表",new ImageView(
				rootIcon));
		rootItem.setExpanded(true);
		List<Billindex> billindex =billindexService.findAll(null);
		List<TreeItem<String>> treeItems = new ArrayList<TreeItem<String>>() ;
		for(Billindex b:billindex){
			TreeItem<String> Item = new TreeItem<String>(b.getBill_name(),new ImageView(
					cIcon));
			treeItems.add(Item);
		}
		rootItem.getChildren().addAll(FXCollections
				.observableList(treeItems));
		treeView.setRoot(rootItem);
		treeView.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {
					public void handle(MouseEvent arg0) {
						MultipleSelectionModel<TreeItem<String>> str = treeView
								.getSelectionModel();
						TreeItem<String> m = str.getSelectedItem();
						try {
							if (m.getValue().equalsIgnoreCase("会员信息")) {
								//GoUi.goOldUi("/com/parkhelp/view/system/memberManager.fxml",Object);
							}
						} catch (NullPointerException e) {
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}
}
