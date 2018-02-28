package com.parkhelp.dao.system.parkinfo;
import java.util.List;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;

public interface ParkZoneInfoMapper {
	public List<ParkZoneInfo> findAll(ParkZoneInfo parkZoneInfo);

	public ParkZoneInfo findById(String id);

	public void delete(String id);

	public void update(ParkZoneInfo parkZoneInfo);

	public void add(ParkZoneInfo parkZoneInfo);
}
