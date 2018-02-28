package com.parkhelp.eparking.data;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
public class Image_Info extends Structure  {
	
	public static class ByReference extends Image_Info implements Structure.ByReference {}  
	public static class ByValue extends Image_Info implements Structure.ByValue {} 
	public int				nWidth;							/* ���					*/
	public int				nHeight;						/* �߶�					*/
	public int				nPitch;							/* ͼ���ȵ�һ��������ռ�ڴ��ֽ���*/
	public int				nLen;							/* ͼ��ĳ���			*/
	public byte[] reserved = new byte[16];			/* Ԥ��     			*/
	public Pointer pBuffer;
}
