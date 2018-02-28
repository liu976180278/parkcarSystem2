package com.parkhelp.controller.video;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.parkhelp.controller.main.MainController;
import com.parkhelp.eparking.api.WTY_EX;
import com.parkhelp.eparking.callback.IOnConnectStatus;
import com.parkhelp.eparking.callback.IOnGetDataEx2;
import com.parkhelp.eparking.callback.IOnJpegCallback;
import com.parkhelp.eparking.data.DevData_info;
import com.parkhelp.eparking.data.PlateResult_Ex;
import com.parkhelp.po.system.parkinfo.GateInfo;
import com.parkhelp.service.system.parkinfo.GateInfoService;
import com.parkhelp.util.SpringFxmlLoader;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
@Component
public class VideoController4 {
	@Autowired(required = true)
	private GateInfoService gateInfoService;
	private static String ip1;
	private short port = 8080;
	public final static int max_jpg_len = 200000 - 312;
	public final static int max_image_len = 818888;
	public static IOnJpegCallback jpegStream = new OnJpegStream();//
	public static IOnConnectStatus connStatus = new OnConnectStatus();//
	public static IOnGetDataEx2 getData2 = new OnGetDataEx2();//
	public static byte[] byteA = new byte[max_jpg_len];
	public static byte[] byte_imageA = new byte[max_image_len];
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screensize = kit.getScreenSize();
	@FXML
	private SplitPane splitPane;
	@FXML
	private AnchorPane apane;
	private static List<byte[]> bytes = null;
	private static List<ImageView> list = null;
	private static List<String> ips =null ;
	List<GateInfo> gates=null;
	public void initialize() {
		bytes=new ArrayList<byte[]>();
		list=new ArrayList<ImageView>();
		ips=new ArrayList<String>();
		gateInfoService = (GateInfoService) SpringFxmlLoader.context
				.getBean("gateInfoServiceImpl");
		GateInfo ginfo  =new GateInfo();
		ginfo.setGategroup("1");
		gates = gateInfoService.findAll(ginfo);
		for(GateInfo g:gates){
			ips.add(g.getCameraIp());
			System.out.println(g.getCameraIp());
			bytes.add(new byte[max_jpg_len]);
		}
		ininImageView(ips.size());
		if(MainController.viedoState==0){
			initWTY_EX();
			MainController.viedoState=1;
		}
		
	}
	
	// JPEG 流显示
	public static class OnJpegStream implements IOnJpegCallback {
		public void callback(DevData_info.ByReference JpegInfo) {
			byte bzero = 0;
			String strJpegIp = new String(JpegInfo.chWTYIP).replaceAll(
					"[^0-9.]", " ").trim();
			String trueJpegIp = strJpegIp;

			while (trueJpegIp.endsWith(".")) {
				trueJpegIp = strJpegIp.substring(0, trueJpegIp.length() - 2);
			}
			for(int i=0;i<ips.size();i++){
				// 设备IP1的动态图像显示
				if ((ips.get(i).trim()).equals(trueJpegIp)) {
					if ((JpegInfo.nStatus == 0)) {
						// 正常状态
						if ((JpegInfo.nLen > 0) && (JpegInfo.pchBuf != null)) {
							Arrays.fill(bytes.get(i), bzero);
							System.arraycopy(
									JpegInfo.pchBuf.getByteArray(0, JpegInfo.nLen),
									0, bytes.get(i), 0, JpegInfo.nLen);
							// 控件显示动态图像
							try {
								jpegShow(list.get(i), bytes.get(i));
							} catch (Exception e) {
								System.out.println("jpegShow(list.get(i), bytes.get(i));");
							}
								
						}
					}
				}
			}
		}
		
	}

	// 连接状态显示
	public static class OnConnectStatus implements IOnConnectStatus {
		public void callback(String chWTYIP, int nStatus) {
			// 设备的连接状态
			if (nStatus != 1) {
				System.out.println(chWTYIP + "连接断开");
			}
		}
	}

	// 新的接受识别结果
	public static class OnGetDataEx2 implements IOnGetDataEx2 {
		public void callback(PlateResult_Ex.ByReference plateResult) {
			byte bzero = 0;
			String strPlateIp = new String(plateResult.chWTYIP).trim();
			// 设备IP1的识别结果处理
			if ((ip1.trim()).equals(strPlateIp)) {
				// 控件显示图像
				if ((plateResult.pFullImage.nLen > 0)
						&& (plateResult.pFullImage.pBuffer != null)) {
					Arrays.fill(byte_imageA, bzero);
					System.arraycopy(plateResult.pFullImage.pBuffer
							.getByteArray(0, plateResult.pFullImage.nLen), 0,
							byte_imageA, 0, plateResult.pFullImage.nLen);
					/*
					 * if (pF != null && pF.jPanel1 != null) {
					 * pF.jpegShow(pF.jPanel1, byte_imageA); }
					 */
				}
			}
		}
	}

	// 相机设备的初始化
	public void initWTY_EX() {
		int errorCode = 1;
		try {
			WTY_EX.INSTANCE.WTY_RegWTYConnEvent(connStatus);
			// WTY_EX.INSTANCE.WTY_RegDataExEvent(getData); 7.1.6.0
			WTY_EX.INSTANCE.WTY_RegDataEx2Event(getData2);
			WTY_EX.INSTANCE.WTY_RegJpegEvent(jpegStream);
			for(String ip:ips){
				// 初始化设备IP1
				errorCode = WTY_EX.INSTANCE.WTY_InitSDK(port, null, 0, ip);
				if (errorCode == 0) {
					System.out.println("初始化Wintone成功，IP=" + ip);
				} else {
					System.out.println("初始化Wintone失败，IP=" + ip);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized void jpegShow(ImageView iv, byte[] byteA) {
		if (byteA != null) {
			InputStream in = new ByteArrayInputStream(byteA);
			Image a = new Image(in);
			iv.setImage(a);
		}
	}

	private void ininImageView(int size) {
		GridPane gp = new GridPane();
		apane.getChildren().add(gp);
		AnchorPane.setBottomAnchor(gp, 0.0);
		AnchorPane.setTopAnchor(gp, 0.0);
		AnchorPane.setLeftAnchor(gp, 0.0);
		AnchorPane.setRightAnchor(gp, 0.0);
		double h = screensize. height-300;
		double w = screensize. width-310;
		for(int i=0;i<size;i++){
			AnchorPane a1 = new AnchorPane();
			ImageView imageV = new ImageView();
			Button b = new Button(gates.get(i).getGatename());
			splitPane.getDividers().get(0).positionProperty().addListener((observable, oldValue, newValue) -> {
				double h1 = h * newValue.doubleValue();
	           if(size<=2){
	        	   imageV.setFitHeight((h1/((size-1)/2+1))*1.0);
	           }else{
	   	           imageV.setFitHeight((h1/((size-1)/2+1))*0.9);
	           }
	          /* System.out.println(newValue.doubleValue());*/
	        });
			imageV.setPreserveRatio(false);
	        imageV.setPickOnBounds(true);
	        AnchorPane.setTopAnchor(imageV, 0.0);
	        list.add(imageV);
			imageV.setFitWidth(w/2-4.0);
			imageV.setFitHeight(h*0.4/((size-1)/2+1));
			b.setPrefHeight(30.0);
			AnchorPane.setTopAnchor(imageV, 0.0);
			AnchorPane.setBottomAnchor(imageV, 30.0);
			AnchorPane.setBottomAnchor(b, 1.0);
			a1.getChildren().addAll(imageV,b);
			a1.setPrefWidth(1000.0);
			a1.setPrefHeight(500.0);
			gp.add(a1, i%2, (i/2));
			GridPane.setMargin(a1, new Insets(2.0));
		}
	}

}
