package com.parkhelp.eparking.callback;
import com.parkhelp.eparking.data.PlateResult_Ex;
import com.sun.jna.Callback;
public interface IOnGetDataEx2 extends Callback
{
	public void callback(PlateResult_Ex.ByReference plateResult);
}

