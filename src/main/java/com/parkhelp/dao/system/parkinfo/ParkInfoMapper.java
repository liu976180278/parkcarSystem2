package com.parkhelp.dao.system.parkinfo;

import java.util.List;
import com.parkhelp.po.system.parkinfo.ParkInfo;

public interface ParkInfoMapper {
	public List<ParkInfo> findAll(ParkInfo parkInfo);

	public ParkInfo findById(String id);

	public void delete(String id);

	public void update(ParkInfo parkInfo);

	public void add(ParkInfo parkInfo);
}
