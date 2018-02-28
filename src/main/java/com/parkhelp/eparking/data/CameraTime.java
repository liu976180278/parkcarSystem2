package com.parkhelp.eparking.data;
import java.util.List;
import com.sun.jna.Structure;

public class CameraTime extends Structure 
{
	public static class ByReference extends CameraTime implements Structure.ByReference {}  
	public static class ByValue extends CameraTime implements Structure.ByValue {}  	
	public int Year; 		/* �� */
	public int Month; 		/* �� */
	public int Day; 		/* �� */
	public int Hour; 		/* ʱ */
	public int Minute; 		/* �� */
	public int Second; 		/* �� */
	public int Millisecond; /* ΢�� */
}