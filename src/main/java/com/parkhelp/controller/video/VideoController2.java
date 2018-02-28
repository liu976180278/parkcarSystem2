package com.parkhelp.controller.video;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.parkhelp.eparking.api.WTY_EX;
import com.parkhelp.eparking.callback.IOnConnectStatus;
import com.parkhelp.eparking.callback.IOnGetDataEx2;
import com.parkhelp.eparking.callback.IOnJpegCallback;
import com.parkhelp.eparking.data.DevData_info;
import com.parkhelp.eparking.data.PlateResult_Ex;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class VideoController2 {
	private static int setRotate=0;
	private static String ip1;
	private short port = 8080;
	public final static int max_jpg_len = 200000 - 312;
	public final static int max_image_len = 818888;
	public  static IOnJpegCallback jpegStream = new OnJpegStream();//
	public  static IOnConnectStatus connStatus = new OnConnectStatus();//
	public  static IOnGetDataEx2 getData2 = new OnGetDataEx2();//
	public static byte[] byteA = new byte[max_jpg_len];
	public static byte[] byteB = new byte[max_jpg_len];
	public static byte[] byte_imageA = new byte[max_image_len];
	Toolkit kit = Toolkit.getDefaultToolkit();
    Dimension  screensize= kit. getScreenSize();
	@FXML
	public  HBox hbox;
	@FXML
	private SplitPane splitPane;
	public  static List<ImageView> list =new ArrayList<ImageView>();
	public void initialize() {
		ininImageView();
		initWTY_EX();
	}

	// JPEG 流显示
	public  static class OnJpegStream implements IOnJpegCallback {
		public void callback(DevData_info.ByReference JpegInfo) {
			byte bzero = 0;
			String strJpegIp = new String(JpegInfo.chWTYIP).replaceAll(
					"[^0-9.]", " ").trim();
			String trueJpegIp = strJpegIp;

			while (trueJpegIp.endsWith(".")) {
				trueJpegIp = strJpegIp.substring(0, trueJpegIp.length() - 2);
			}
			// 设备IP1的动态图像显示
			if ((ip1.trim()).equals(trueJpegIp)) {
				if ((JpegInfo.nStatus == 0)) {
					// 正常状态
					if ((JpegInfo.nLen > 0) && (JpegInfo.pchBuf != null)) {
						Arrays.fill(byteA, bzero);
						System.arraycopy(
								JpegInfo.pchBuf.getByteArray(0, JpegInfo.nLen),
								0, byteA, 0, JpegInfo.nLen);
						// 控件显示动态图像
						for(int i=0;i<list.size();i++){
							jpegShow(list.get(i),byteA);
						}
						
					}
				}
			}
		}
	}

	// 连接状态显示
	public  static class OnConnectStatus implements IOnConnectStatus {
		public void callback(String chWTYIP, int nStatus) {
			// 设备的连接状态
			if (nStatus != 1) {
				System.out.println(chWTYIP + "连接断开");
			}
		}
	}

	// 新的接受识别结果
	public  static class OnGetDataEx2 implements IOnGetDataEx2 {
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
					/*if (pF != null && pF.jPanel1 != null) {
						pF.jpegShow(pF.jPanel1, byte_imageA);
					}*/
				}
			}
		}
	}

	// 相机设备的初始化
	public void initWTY_EX() {
			int errorCode=1;
			ip1 = "192.168.100.245";
			try {
				WTY_EX.INSTANCE.WTY_RegWTYConnEvent(connStatus);
				//WTY_EX.INSTANCE.WTY_RegDataExEvent(getData); 7.1.6.0			
				WTY_EX.INSTANCE.WTY_RegDataEx2Event(getData2);
			    WTY_EX.INSTANCE.WTY_RegJpegEvent(jpegStream);
				// 初始化设备IP1			
				errorCode = WTY_EX.INSTANCE.WTY_InitSDK(port, null, 0, ip1);			
				if (errorCode == 0) {
					System.out.println("初始化Wintone成功，IP=" + ip1);
				} else {
					System.out.println("初始化Wintone失败，IP=" + ip1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
	public   static synchronized void jpegShow(ImageView iv,byte[] byteA) 
	{
		if(byteA!=null){
			InputStream in =new ByteArrayInputStream(byteA);
			Image a = new Image(in);
			iv.setImage(a);
		}
	}
	
	private   void ininImageView(){
		int size=2;
		int width=(screensize.width-310)/size;
		for(int i=0;i<size;i++){
			AnchorPane aPane = new AnchorPane();
			ImageView imageV = new ImageView();
			//new Image(getClass().getResourceAsStream("/com/parkhelp/image/main/main.png"))
			imageV.setFitWidth(width);
			imageV.setPreserveRatio(false);
	        imageV.setPickOnBounds(true);
			imageV.setFitHeight(screensize.height*0.315);
			Button b = new Button("开闸");
			splitPane.getDividers().get(0).positionProperty().addListener((observable, oldValue, newValue) -> {
	            double w = screensize. height-300;
	            double w1 = w * newValue.doubleValue();
	            imageV.setFitHeight(w1);
	        });
			AnchorPane.setTopAnchor(imageV, 0.0);
			AnchorPane.setBottomAnchor(imageV, 30.0);
			AnchorPane.setBottomAnchor(b, 0.0);
			AnchorPane.setLeftAnchor(b, 50.0);
			aPane.getChildren().addAll(imageV,b);
			list.add(imageV);
			aPane.setPrefWidth((width));
			hbox.getChildren().add(aPane);
			if(i<size-1){
				Button bLine = new Button();
				bLine.setStyle("-fx-background-color: #D1E9E9;");
				aPane.getChildren().add(bLine);
				AnchorPane.setBottomAnchor(bLine, 0.0);
				AnchorPane.setTopAnchor(bLine, 0.0);
				AnchorPane.setRightAnchor(bLine, 0.0);
			}
		}
	}
	

}
