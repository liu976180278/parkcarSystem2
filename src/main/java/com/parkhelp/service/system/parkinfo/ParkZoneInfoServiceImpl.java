package com.parkhelp.service.system.parkinfo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkhelp.dao.system.parkinfo.ParkInfoMapper;
import com.parkhelp.dao.system.parkinfo.ParkZoneInfoMapper;
import com.parkhelp.po.system.parkinfo.ParkZoneInfo;
@Service
public class ParkZoneInfoServiceImpl implements ParkZoneInfoService{
	@Autowired
	private ParkZoneInfoMapper parkZoneInfoCarMapper;
	public List<ParkZoneInfo> findAll(ParkZoneInfo parkZoneInfo) {
		return parkZoneInfoCarMapper.findAll(parkZoneInfo);
	}

	public ParkZoneInfo findById(String id) {
		return parkZoneInfoCarMapper.findById(id);
	}

	public void delete(String id) {
		parkZoneInfoCarMapper.delete(id);
	}

	public void update(ParkZoneInfo parkZoneInfo) {
		parkZoneInfoCarMapper.update(parkZoneInfo);
	}

	public void add(ParkZoneInfo parkZoneInfo) {
		parkZoneInfoCarMapper.add(parkZoneInfo);
	}
	
}
