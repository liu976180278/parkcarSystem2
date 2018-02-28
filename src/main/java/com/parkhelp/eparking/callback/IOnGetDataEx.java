package com.parkhelp.eparking.callback;
import com.parkhelp.eparking.data.PlateResult;
import com.sun.jna.Callback;
public interface IOnGetDataEx extends Callback
{
	public void callback(PlateResult.ByReference plateResult);
}

