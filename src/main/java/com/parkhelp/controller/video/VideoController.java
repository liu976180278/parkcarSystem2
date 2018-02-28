package com.parkhelp.controller.video;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import com.parkhelp.eparking.api.WTY_EX;
import com.parkhelp.eparking.callback.IOnConnectStatus;
import com.parkhelp.eparking.callback.IOnGetDataEx2;
import com.parkhelp.eparking.callback.IOnJpegCallback;
import com.parkhelp.eparking.data.DevData_info;
import com.parkhelp.eparking.data.PlateResult_Ex;

public class VideoController {
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
	@FXML
	private AnchorPane Apane;
	private static ImageView testImageView=new ImageView();
	public void initialize() {
		Apane.getChildren().addAll(testImageView);
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension  screensize= kit. getScreenSize();
		testImageView.setFitHeight(screensize.height*0.31);
		testImageView.setFitWidth(screensize.width*0.35);
		//initWTY_EX();
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
						/*
						 * if (pF != null && pF.jPanel1 != null) {
						 * pF.jpegShow(pF.jPanel1, byteA); }
						 */
						jpegShow(testImageView,byteA);
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



}
