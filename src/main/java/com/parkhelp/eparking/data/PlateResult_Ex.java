package com.parkhelp.eparking.data;
import java.util.List;

import com.sun.jna.Structure;
public class PlateResult_Ex extends Structure  {
	public static class ByReference extends PlateResult_Ex implements Structure.ByReference {}  
	public static class ByValue extends PlateResult_Ex implements Structure.ByValue {}  
	public byte[] chWTYIP = new byte[16]; 				// ���IP
	public byte[] chColor = new byte[8]; 				// ������ɫ
	public byte[] chLicense = new byte[16]; 			// ���ƺ���
	public PlateLocation.ByValue pcLocation; 			// ������ͼ���е�����
	public CameraTime.ByValue shootTime; 				// ʶ������Ƶ�ʱ��	
	public int					nConfidence;						/* ���ƿ��Ŷ�			*/
	public int					nTime;								/* ʶ���ʱ				*/
	public int					nDirection;							/* ���Ʒ���		    	*/
	public byte[] reserved = new byte[256]; 					/* Ԥ��     			*/
	public Image_Info.ByValue		pFullImage;						/* ȫ��ͼ������(ע�⣺��������䣬�˴�ָ��Ϊ��) */
	public Image_Info.ByValue		pPlateImage;						/* ����ͼ������(ע�⣺��������䣬�˴�ָ��Ϊ��) */
}
