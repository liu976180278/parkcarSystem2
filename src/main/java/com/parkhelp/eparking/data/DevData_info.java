package com.parkhelp.eparking.data;

import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class DevData_info extends Structure 
{	
	public static class ByReference extends DevData_info implements Structure.ByReference {}  
	public static class ByValue extends DevData_info implements Structure.ByValue {}  			
    public byte[] chWTYIP = new byte[16]; // ���IP
	public Pointer pchBuf;
	public int nLen; 
	public int nStatus; 				 /* Current recv data status. 0:Normal, other:Non-normal */
	public byte[] reserved = new byte[128];
}
