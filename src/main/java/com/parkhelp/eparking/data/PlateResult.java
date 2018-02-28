package com.parkhelp.eparking.data;
import com.sun.jna.Structure;


public class PlateResult extends Structure 
{
	public static class ByReference extends PlateResult implements Structure.ByReference {}  
	public static class ByValue extends PlateResult implements Structure.ByValue {}  
	
	public byte[] chWTYIP = new byte[16]; 				
	public int nFullLen = 0; 								
	public int nPlateLen; 								
	public byte[] chFullImage = new byte[200000 - 312]; 
	public byte[] chPlateImage = new byte[10000]; 		
	public byte[] chColor = new byte[8]; 				
	public byte[] chLicense = new byte[16]; 			
	public PlateLocation.ByValue pcLocation; 			
	public CameraTime.ByValue shootTime; 							
	public byte[] reserved = new byte[256];
}
