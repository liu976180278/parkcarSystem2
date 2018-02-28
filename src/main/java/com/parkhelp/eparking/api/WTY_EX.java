package com.parkhelp.eparking.api;
import com.parkhelp.eparking.callback.IOnConnectStatus;
import com.parkhelp.eparking.callback.IOnGetDataEx;
import com.parkhelp.eparking.callback.IOnGetDataEx2;
import com.parkhelp.eparking.callback.IOnJpegCallback;
import com.parkhelp.main.MainLZC;
import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;
public interface WTY_EX extends StdCallLibrary 
{
	public static String strFilePath = System.getProperty("user.dir") + "\\src\\main\\java\\com\\parkhelp\\eparking\\WTY.dll";
	//public static String strFilePath = "D:/WTY.dll";
	public static WTY_EX INSTANCE = (WTY_EX)Native.loadLibrary(strFilePath, WTY_EX.class);
	/**
	 * @param nPort
	 *            连接相机的端口，现默认为8080
	 * @param hWndHandle
	 *            接收消息的窗体句柄，当为NULL时，表示无窗体，可忽略。
	 * @param uMsg
	 *            用户自定义消息，当hWndHandle不为NULL时使用
	 * @param chServerIP
	 *            相机的IP地址
	 * 
	 * @return 0 相机连接成功， 1 相机连接失败
	 */
	public int WTY_InitSDK(int nPort, Void hWndHandle, int uMsg,String chServerIP);
	/**
	 * 断开所有已经连接WTY，释放资源
	 */
	public void WTY_QuitSDK();

	/**
	 * 触发识别
	 * @param pCameraIP
	 *            相机IP
	 * @param nPort
	 *            连接相机的端口，现默认为8080
	 * 
	 * @return 0 成功， 非0 失败
	 */
	public int WTY_SetTrigger(String pCameraIP, int nCameraPort);

	/**
	 * 1：连接状态回调函数的注册，必须在连接设备函数(WTY_InitSDK)之前 调用。 2：此方式是被动获取PC 与设备之间的连接状态
	 * 
	 * @param obj
	 *            回调接口
	 */
	public void WTY_RegWTYConnEvent(IOnConnectStatus obj);

	/**
	 * 1: 一台PC 连接多台设备时，此函数仅需实现一次。当区分不同设备的识别结 果时，可以通过输出参数中recResult 中的chWTYIP
	 * 来区分。
	 * 
	 * @param recResult
	 *            可为NULL
	 * @param obj
	 *            回调类，类名、方法名必须与Demo中的保持一致，否则会注册失败。
	 */
	public void WTY_RegDataExEvent(IOnGetDataEx obj);
	

	
	/*新的注册回调函数7.1.6.0*/	 
	public void WTY_RegDataEx2Event(IOnGetDataEx2 odj);
	
	/**
	 * 1: 注册获取Jpeg流的回调函数
	 *    
	 * @param obj
	 *            1:此功能目前适用于V6.0.0.0版本,
	 * 				V5.1.2.0、V5.2.1.0、V5.2.2.0不能使用此功能
	 */

	public void WTY_RegJpegEvent(IOnJpegCallback obj);
	
	/**
	 * 获取连接状态
	 */
	public int WTY_CheckStatus(String DevIp);
	

	
	
	/************************************************************************/
	/* WTY_SetSavePath: 如果用户需要动态库自动保存图片，可以通过该函数设置保*/
	/*					存图片的路径。										*/
	/*		Parameters:														*/
	/*			chSavePath[in]:	文件存储路径，以"\\"结束，如："D:\\Image\\"	*/
	/*		Return Value:   void											*/
	/*																		*/
	/*		Notice:   														*/
	/*			全景图：指定目录\\设备IP\\年月日（YYYYMMDD）\\FullImage\\	*/
	/*									时分秒-毫秒__颜色_车牌号码__.jpg	*/
	/*			车牌图：指定目录\\设备IP\\年月日（YYYYMMDD）\\PlatelImage\\	*/
	/*									时分秒-毫秒__颜色_车牌号码__.jpg	*/
	/************************************************************************/
	public int WTY_SetSavePath(String chSavePath);
	
	
	/************************************************************************/
	/* WTY_SetTransContent: 控制相机设备上传内容					        */
	/*		Parameters:														*/
	/*			pCameraIP[in]:		要设置的设备IP							*/
	/*			nCameraPort[in]:	端口,默认8080							*/
	/*			nFullImg[in]:		全景图，0表示不传，1表示传				*/
	/*			nPlateImg[in]:		车牌图，0表示不传，1表示传				*/
	/*		Return Value:   int												*/
	/*							0	成功									*/
	/*						  非0	失败									*/
	/************************************************************************/
	public int WTY_SetTransContent (String pCameraIP, int nCameraPort, int nFullImg, int nPlateImg);
	
	/************************************************************************/
	/* 函数说明: 控制继电器的闭合											        */
	/*		Parameters:														*/
	/*			pCameraIP[in]:			相机IP								*/
	/*			nCameraPort[in]:		端口,默认9110						*/
	/*		Return Value:   int												*/
	/*							0	设置成功								*/
	/*						  非0	失败									*/
	/*		Notice:   														*/
	/*				通过此功能，可以在PC端通过一体机设备，来控制道闸的抬起	*/
	/*				设备继电器输出信号为：开关量信号。						*/
	/************************************************************************/
	public int WTY_SetRelayClose(String pCameraIP, int nCameraPort);
	
	/************************************************************************/
	/* 	函数: 根据IP地址，断开指定设备链接									*/
	/*		Parameters:														*/
	/*			pCameraIP[in]:			相机IP地址							*/
	/*		Return Value:   int												*/
	/*							0	获取成功								*/
	/*							1	获取失败								*/
	/************************************************************************/
	public int WTY_QuitDevice(String pCameraIP);
	
	/************************************************************************/
	/* WTY_SetNetworkCardBind: 手动绑定指定网卡IP							*/
	/*		Parameters:														*/
	/*			pCameraIP[in]		要绑定的网卡IP地址						*/
	/*		Return Value:   int												*/
	/*							0	成功									*/
	/*						  非0	失败									*/
	/*		notice:当PC机存在多网卡的情况时，又不想禁用为单网卡时，可通过该	*/
	/*				函数绑定与相机通讯的网卡IP								*/
	/************************************************************************/
	public int WTY_SetNetworkCardBind(String pCameraIP);
	
	/************************************************************************/
	/* WTY_RS485Send: RS485透明传输											*/
	/*		Parameters:														*/
	/*			pCameraIP[in]				相机设备IP地址					*/
	/*			nPort[in]					端口,默认8080					*/
	/*			chData[in]					将要传输的数据块的首地址		*/
	/*			nSendLen[in]				将要传输的数据块的字节数		*/
	/*		Return Value:   int												*/
	/*							0	成功									*/
	/*						  非0	失败									*/
	/*		notice：														*/
	/*				1：用户通过此接口，往相机发送数据，相机设备会原样将数据	*/
	/*				通过RS485接口转发出去，到客户所接的外部设备上。			*/
	/*				2：使用此功能前，需要在演示DEMO的设置界面上，设置相机不 */
	/*				能传输识别结果(默认S485传输识别结果)。					*/
	/************************************************************************/
	public int WTY_RS485Send(String pCameraIP, int nCameraPort,  byte[] chData, int nSendLen);
}
