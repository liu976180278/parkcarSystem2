package com.parkhelp.eparking.data;
import com.sun.jna.Structure;

public class PlateLocation extends Structure 
{
	public static class ByReference extends PlateLocation implements Structure.ByReference {}  
	public static class ByValue extends PlateLocation implements Structure.ByValue {}  
	
	public int Left; 		/* �� */
	public int Top; 		/* �� */
	public int Right; 		/* �� */
	public int Bottom; 		/* �� */
}