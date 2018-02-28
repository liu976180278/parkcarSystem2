package com.parkhelp.eparking.callback;
import com.parkhelp.eparking.data.DevData_info;
import com.sun.jna.Callback;
public interface IOnJpegCallback extends Callback
{
	public void callback(DevData_info.ByReference JpegInfo);
}
